import java.io.*;
import java.net.*;
public class Helloworld
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		Socket smtpSocket=null;
		DataOutputStream os=null;
		DataInputStream is=null;
		try
		{
			smtpSocket =new Socket("localhost",25);//add apropriate port number
			os=new DataOutputStream(smtpSocket.getOutputStream());
			is=new DataInputStream(smtpSocket.getInputStream());
		}
		catch(UnknownHostException e)
		{
			System.err.println("Don't know about host: localhost");
		}
		catch (IOException e)
		{
			System.err.println("Couldn't get I/O for the connection to: localhost");
		}
		if (smtpSocket != null && os != null && is != null) {
            try
            	{
            		os.writeBytes("HELO\n");
            		 String responseLine;
                     while ((responseLine = is.readLine()) != null) {
                         System.out.println("Server: " + responseLine);
                         if (responseLine.indexOf("Ok") != -1)
                         {
                           break;
                         }
                     }
                     os.close();
                     is.close();
                     smtpSocket.close();  
            	}
            catch (UnknownHostException e) {
                System.err.println("Trying to connect to unknown host: " + e);
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
            }
	}
	
}
