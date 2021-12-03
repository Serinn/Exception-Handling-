package exceptionfinal;

import exceptionfinal.ProtocolException;
import exceptionfinal.NoConnectionException;


public interface Protocol {
	
	//Connection is already released....
	//Unable to release the connection 
	//connection in use 
	public static boolean release() throws ProtocolException {
		return false;
	}
	
	
	//No connection....
	//timeout connection...
	//System busy exception....
	public static int send(String message) throws NoConnectionException, BusyConnectionException, DataProcessException, ProtocolException {
		int status = MyConstraints.BUSY_STATUS;
		
		if(message == null) {
			throw new NoConnectionException ("No connection.. creating new one..");
		}
		if(status == MyConstraints.BUSY_STATUS ) {
			Logger.getInstance().logError("Bug in creating new connection! :( ");
			throw new BusyConnectionException("Connection is busy.. try later");
		}
		if(status == MyConstraints.READY_STATUS )
		{
			Connection.getInstance(ConnectionType.SSH);
		}
		if(status== MyConstraints.DONE_RESULT) {
			Logger.getInstance().logInfo("Succesffull Release :) !!");
			Connection.release("ssh");
			return MyConstraints.DONE_RESULT;
		}
		else {
			Connection.release(message);
			Logger.getInstance().logError("Bug in release..");
			throw new DataProcessException("Connection failed to be released!");
			

		}
		
		
	}

}