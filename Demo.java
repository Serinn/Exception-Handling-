package exceptionfinal;

import exceptionfinal.ConnectionType;
import exceptionfinal.Ftp;
import exceptionfinal.Protocol;
import exceptionfinal.Connection;
import exceptionfinal.ProtocolException;
import exceptionfinal.Logger;
import java.lang.Thread;



public class Demo {

	public static void main(String[] args) throws NoConnectionException {
	
		Logger.getInstance().logInfo("This is a info message");
		Logger.getInstance().logDebug("This is a debug message");
		Logger.getInstance().logWarning("This is a warning message");
		Logger.getInstance().logError("This is a error message");
		
		
		try {
			Protocol ssh = Connection.getInstance(ConnectionType.SSH);
			Protocol ssh2 = Connection.getInstance(ConnectionType.SSH);
			Protocol telnet = Connection.getInstance(ConnectionType.TELNET);
			Protocol scp = Connection.getInstance(ConnectionType.SCP);
			Protocol ftp = Connection.getInstance(ConnectionType.FTP);
		} catch (ProtocolException e1) {
			// TODO Auto-generated catch block
			System.out.println("no ssh");
			e1.printStackTrace();
			
		}
	
		
	    final int numberOfConnections =4;
		while(numberOfConnections > 0) {
		try {
	    Protocol protocol = Protocol.send(null);
		break;
		}
		catch(NoConnectionException e) {
			Logger.getInstance().logInfo("I am in send..");
			Logger.getInstance().logWarning("No connection!" + e.getMessage());
			e.printStackTrace();
		} catch (BusyConnectionException e) {
			Logger.getInstance().logError("Connection busy.. try again later!");
			Thread.sleep(500L);
		}
	     finally {
				Logger.getInstance().logInfo("Send hasbeen handled! :)");

	     }
		}
		
	
			try {
				long timeout;
				Thread.sleep(timeout);
			Logger.getInstance().logError("Timeout session is over!!!");
			} catch(InterruptedException e2) {
				
				e2.printStackTrace();
			}
			
		
		
		if(ssh == ssh2) {
			System.out.println(" ssh is equal to ssh2");
		}
		Protocol.send(" testing ssh ");
		Protocol.send("Testing telnet ");
		Protocol.send("Testing scp");
		
		
		
		System.out.println(Connection.getCurrentConnections());
		Connection.release(ConnectionType.SSH);
		System.out.println(Connection.getCurrentConnections());
		
		ftp = Connection.getInstance(ConnectionType.FTP);
		System.out.println(Connection.getCurrentConnections());
		
		
		ssh = Connection.getInstance(ConnectionType.SSH);
		ftp = Connection.getInstance(ConnectionType.FTP);
		ftp = Connection.getInstance(ConnectionType.FTP);
		
		ftp = Connection.getInstance(ConnectionType.FTP);
		Protocol.send("Testing FTP");
		Connection.release(ConnectionType.FTP);
		
		Protocol tftp = Connection.getInstance(ConnectionType.TFTP);
		Protocol tftp2 = Connection.getInstance(ConnectionType.TFTP);
		System.out.println(Connection.getCurrentConnections());
		if(tftp == tftp2 ) {
			System.out.println("Same object");
		}
		Protocol.send("test the TFTP ");
		Protocol.send("test the TFTP ");

		//ftp = Ftp.getInsatnce();
		///Connection.release(ConnectionType.TFTP);
		System.out.println(Connection.getCurrentConnections());//3
		if(ftp == null) {
			System.out.println("FTP is a null");
		} else {
			System.out.println("FTP is not a null");
		}
		Protocol.send(" breaking the logic ");
			
		
	}
	}

}