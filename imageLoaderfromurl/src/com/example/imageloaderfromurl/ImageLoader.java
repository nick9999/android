package com.example.imageloaderfromurl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.widget.ImageView;

public class ImageLoader {

	String[] image_urls = { "http://api.androidhive.info/images/sample.jpg",
			"http://s3.amazonaws.com/thumbnails.illustrationsource.com/huge.86.433302.JPG" };

	MemoryCache memoryCache = new MemoryCache();
	FileCache fileCache;
	private Map<ImageView, String> imageViews = Collections
			.synchronizedMap(new WeakHashMap<ImageView, String>());
	ExecutorService executorService;

	public ImageLoader(Context context) {
		fileCache = new FileCache(context);
		executorService = Executors.newFixedThreadPool(5);
	}

	int stub_id = R.drawable.ic_launcher;

	public void DisplayImage(String url, int loader, ImageView imageView) {
		stub_id = loader;
		imageViews.put(imageView, url);
		Bitmap bitmap = memoryCache.get(url);
		if (bitmap != null)
			imageView.setImageBitmap(bitmap);
		else {
			queuePhoto(url, imageView);
			imageView.setImageResource(loader);
		}
	}

	private void queuePhoto(String url, ImageView imageView) {
		PhotoToLoad p = new PhotoToLoad(url, imageView);
		executorService.submit(new PhotosLoader(p));
	}

	private Bitmap getBitmap(String url) {
		File f = fileCache.getFile(url);

		// from SD cache
		Bitmap b = decodeFile(f);
		if (b != null)
			return b;

		// from web

		try {
			Bitmap bitmap = null;
			URL imageUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) imageUrl
					.openConnection();
			int k = 0;

			//k is the index for which view is called
			
			for (int i = 0; i < 75; i++) {
				if (image_urls[i].equals(imageUrl))
					k = i;
			}
			
			//if it is scrolling up
			
			for (int i = 0; i < max(k - 5, 0); i++) {

				URL imageurl = new URL(image_urls[i]);
				HttpURLConnection conn1 = (HttpURLConnection) imageurl
						.openConnection();
				conn1.disconnect();
			}
			
			//if it is scrolling down
			
			for (int i = 75; i > min(74, k + 5); i--) {
				URL imageurl1 = new URL(image_urls[i]);
				HttpURLConnection conn2 = (HttpURLConnection) imageurl1
						.openConnection();
				conn2.disconnect();

			}

			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			conn.setInstanceFollowRedirects(true);
			InputStream is = conn.getInputStream();
			OutputStream os = new FileOutputStream(f);
			Utils.CopyStream(is, os);
			os.close();
			return bitmap;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

		/*
		 * try { Bitmap bitmap=null; URL imageUrl = new URL(url); //
		 * HttpURLConnection conn =
		 * (HttpURLConnection)imageUrl.openConnection(); HttpURLConnection conn;
		 * for(int i=0;i<75;) { if(image_urls[i].equals(imageUrl)) { for(int
		 * j=i;j<i+6;j++) { conn = (HttpURLConnection)imageUrl.openConnection();
		 * conn.setConnectTimeout(30000); conn.setReadTimeout(30000);
		 * conn.setInstanceFollowRedirects(true); InputStream
		 * is=conn.getInputStream(); OutputStream os = new FileOutputStream(f);
		 * Utils.CopyStream(is, os); os.close(); bitmap = decodeFile(f); return
		 * bitmap; } }
		 * 
		 * } /*conn.setConnectTimeout(30000); conn.setReadTimeout(30000);
		 * conn.setInstanceFollowRedirects(true); InputStream
		 * is=conn.getInputStream(); OutputStream os = new FileOutputStream(f);
		 * Utils.CopyStream(is, os); os.close(); bitmap = decodeFile(f); return
		 * bitmap; } catch (Exception ex){ ex.printStackTrace(); return null; }
		 */
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	public int min(int a, int b) {
		return a < b ? a : b;
	}

	private Bitmap decodeFile(File f) {
		try {
			// decode image size
			BitmapFactory.Options o = new BitmapFactory.Options();
			o.inJustDecodeBounds = true;
			BitmapFactory.decodeStream(new FileInputStream(f), null, o);

			// Find the correct scale value. It should be the power of 2.
			final int REQUIRED_SIZE = 70;
			int width_tmp = o.outWidth, height_tmp = o.outHeight;
			int scale = 1;
			while (true) {
				if (width_tmp / 2 < REQUIRED_SIZE
						|| height_tmp / 2 < REQUIRED_SIZE)
					break;
				width_tmp /= 2;
				height_tmp /= 2;
				scale *= 2;
			}

			// decode with inSampleSize
			BitmapFactory.Options o2 = new BitmapFactory.Options();
			o2.inSampleSize = scale;
			return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
		} catch (FileNotFoundException e) {
		}
		return null;
	}

	private class PhotoToLoad {
		public String url;
		public ImageView imageView;

		public PhotoToLoad(String u, ImageView i) {
			url = u;
			imageView = i;
		}
	}

	class PhotosLoader implements Runnable {
		PhotoToLoad photoToLoad;

		PhotosLoader(PhotoToLoad photoToLoad) {
			this.photoToLoad = photoToLoad;
		}

		@Override
		public void run() {
			if (imageViewReused(photoToLoad))
				return;
			Bitmap bmp = getBitmap(photoToLoad.url);
			memoryCache.put(photoToLoad.url, bmp);
			if (imageViewReused(photoToLoad))
				return;
			BitmapDisplayer bd = new BitmapDisplayer(bmp, photoToLoad);
			Activity a = (Activity) photoToLoad.imageView.getContext();
			a.runOnUiThread(bd);
		}
	}

	boolean imageViewReused(PhotoToLoad photoToLoad) {
		String tag = imageViews.get(photoToLoad.imageView);
		if (tag == null || !tag.equals(photoToLoad.url))
			return true;
		return false;
	}

	class BitmapDisplayer implements Runnable {
		Bitmap bitmap;
		PhotoToLoad photoToLoad;

		public BitmapDisplayer(Bitmap b, PhotoToLoad p) {
			bitmap = b;
			photoToLoad = p;
		}

		public void run() {
			if (imageViewReused(photoToLoad))
				return;
			if (bitmap != null)
				photoToLoad.imageView.setImageBitmap(bitmap);
			else
				photoToLoad.imageView.setImageResource(stub_id);
		}
	}

	public void clearCache() {
		memoryCache.clear();
		fileCache.clear();
	}
}
