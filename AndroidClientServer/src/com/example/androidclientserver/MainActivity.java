package com.example.androidclientserver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private Socket socket;
	private static final int SERVERPORT=8008;
	private static final String SERVER_IP="10.1.2.71";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new Thread(new ClientThread()).start();
	}
	public void sendMessage(View view)
	{
		try
		{
			EditText editText=(EditText) findViewById(R.id.EditText01);
			String str=editText.getText().toString();
			PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			out.println(str);
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	class ClientThread implements Runnable
	{
		@Override
		public void run()
		{
			try
			{
				InetAddress serverAddr=InetAddress.getByName(SERVER_IP);
				socket=new Socket(serverAddr,SERVERPORT);
				
			}
			catch (UnknownHostException e1)
			{
				e1.printStackTrace();
			}
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
