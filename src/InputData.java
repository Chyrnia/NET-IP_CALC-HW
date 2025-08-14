/*
 * This is the class Input. It stores the raw input and the unvalidated ip and mask, so they are worked on by the 
 * validator. It uses its method populateFields to populate itself using the candidate (raw input)
 * can abort execution of the program if it detects that there's not enough data to fill its own fields
 */
import java.util.StringTokenizer;

public class InputData {

	public InputData(String argument){
		this.candidate = argument;
		this.populateFields();
	}

	private void populateFields(){
		StringTokenizer tokenizer = new StringTokenizer(this.candidate, "/");
		if(tokenizer.countTokens() == 2){
			this.setInputIp(tokenizer.nextToken());
			this.setInputMask(tokenizer.nextToken());
		} else {
			System.out.println("ERROR: Not enough data...");
			System.exit(1);
		}
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
