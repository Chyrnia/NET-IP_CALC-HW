/*
 * This is the data class Input. It stores the raw input and the unvalidated ip and mask, so they are worked on by the 
 * validator 
 */

public class Input {

	public Input(String argument){
		this.candidate = argument;
		this.inputIp = null;
		this.inputMask = null;
	}

	public String getCandidate(){
		return candidate;
	}

	public String getInputIp(){
		return inputIp;
	}

	public String getInputMask(){
		return inputMask;
	}

	public void setCandidate(String cand){
		this.candidate = cand;
	}

	public void setInputIp(String ip){
		this.inputIp = ip;
	}

	public void setInputMask(String mask){
		this.inputMask = mask;
	}

	//Data fields
	private String candidate;
	private String inputIp;
	private String inputMask;

}
