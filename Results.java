/*
 * This is the data class Results. It stores the final products of our program so they can be more easily referenced,
 */

public class Results {

	public Results(){
		this.validatedIp = null;
		this.networkIp = null;
		this.broadcastIp = null;	
	}

	public String getValidatedIp(){
		return validatedIp;
	}

	public String getNetworkIp(){
		return networkIp;
	}

	public String getBroadcastIp(){
		return broadcastIp;
	}

	public void setValidatedIp(String validIp){
		this.validatedIp = validIp;
	}

	public void setNetworkIp(String netIp){
		this.networkIp = netIp;
	}

	public void setBroadcastIp(String broadIp){
		this.broadcastIp = broadIp;
	}

	
	//Data fields
	private String validatedIp;
	private String networkIp;
	private String broadcastIp;

}
