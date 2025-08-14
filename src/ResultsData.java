/*
 * This is the data class Results. It stores the final products of our program so they can be more easily referenced,
 */

public class ResultsData {

	public ResultsData(){
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

	public String getValidatedMask(){
		return validatedMask;
	}

	public String getBinaryIp(){
		return binaryIp;
	}

	public String getBinaryMask(){
		return binaryMask;
	}

	public String getBinaryNet(){
		return binaryNet;
	}

	public String getBinaryBroad(){
		return binaryBroad;
	}

	public void setValidatedIp(String validIp){
		this.validatedIp = validIp;
	}

	public void setValidatedMask(String validMask){
		this.validatedMask = validMask;
	}

	public void setBinaryIp(String binIp){
		this.binaryIp = binIp;
	}

	public void setBinaryMask(String binMask){
		this.binaryMask = binMask;
	}

	public void setBinaryNet(String binNet){
		this.binaryNet = binNet;
	}

	public void setBinaryBroad(String binBroad){
		this.binaryBroad = binBroad;
	}

	public void setNetworkIp(String netIp){
		this.networkIp = netIp;
	}

	public void setBroadcastIp(String broadIp){
		this.broadcastIp = broadIp;
	}

	
	//Data fields
	private String validatedIp;
	private String validatedMask;
	private String networkIp;
	private String broadcastIp;

	private String binaryIp;
	private String binaryMask;
	private String binaryNet;
	private String binaryBroad;

}
