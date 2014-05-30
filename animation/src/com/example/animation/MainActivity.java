package com.example.animation;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),
		// R.drawable.phone);
		// notBuilder.setLargeIcon(largeIcon);
		

		/*
		 * // Step1 : create the RotateAnimation object RotateAnimation anim =
		 * new RotateAnimation(0f, 350f, 15f, 15f); // Step 2: Set the Animation
		 * properties anim.setInterpolator(new LinearInterpolator());
		 * anim.setRepeatCount(Animation.INFINITE); anim.setDuration(700);
		 * 
		 * // Step 3: Start animating the image image.startAnimation(anim);
		 * 
		 * // Later. if you want to stop the animation //
		 * image.setAnimation(null);
		 */
	}

	public void start(View v) {
		
		ImageView view = (ImageView) findViewById(R.id.imageView1);
		Path path = new Path();
		Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
		Canvas c = new Canvas(b);
		view.draw(c);
		// View.onDraw(c);
		Paint mPaint = new Paint();
		mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		path.addRect(view.getLeft(), view.getTop(), view.getRight(),
				view.getBottom(), Path.Direction.CW);
		DashPathEffect pe = new DashPathEffect(new float[] { 5, 8, 8, 4 }, 13);

		mPaint.setPathEffect(pe);
		mPaint.setColor(Color.GREEN);
		c.drawPath(path, mPaint);

	}

	/*
	 * public void start(View v) { ImageView view = (ImageView)
	 * findViewById(R.id.imageView1); Path path = new Path(); Canvas c = new
	 * Canvas(); Paint mPaint = new Paint(); path.addRect(view.getLeft(),
	 * view.getTop(), view.getRight(), view.getBottom(), Path.Direction.CW);
	 * DashPathEffect pe = new DashPathEffect(new float[] { 10, 5, 5, 5 }, 0);
	 * 
	 * mPaint.setPathEffect(pe); mPaint.setColor(Color.GREEN); c.drawPath(path,
	 * mPaint); }
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
