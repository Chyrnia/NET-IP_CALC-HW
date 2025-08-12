/* 
 * This is the Validated Data class. It stores the ip and mask spat by the validator. It's the class the Calculator
 * expects to work with
 */
public class ValidatedData {
	  

	public ValidatedData(){
		this.validatedIp = null;
		this.validatedMask = null;
	}

	public String getValidIp(){
		return validatedIp;
	}

	public String getValidMask(){
		return validatedMask;
	}

	public void setValidIp(String ip){
		this.validatedIp = ip;
	}

	public void setValidMask(String mask){
		this.validatedMask = mask;
	}

	//Data fields
	private String validatedIp;
	private String validatedMask;

}

