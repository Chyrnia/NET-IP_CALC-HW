/*
 * This is the class validator. It expects an Input instance, with the raw data. It verifies the ip
 * and the mask are both valid, suitable for calculator to work on them. It can manage masks in the 
 * form /number or /number.number.number.number
 */
public class Validator extends BinaryStringManipulator { 

	public Validator(){
	}

	public ValidatedData validateInput(InputData in){
		//Create the data object
		ValidatedData v = new ValidatedData();

		//Input has two fields that we care about
		//inputIp and inputMask
		//ip is easy, we will check that it has the form of an IP address like this
		if(!validateIpForm(in.getInputIp())){
			System.exit(5);
		}

		v.setValidIp(in.getInputIp());

		//the mask is almost the same but it might be in short or long form 
		String longMask = null;

		//if its short
		if(in.getInputMask().length() == 2){
			longMask = super.getNumericIp(constructBitMaskFromNumber(Integer.parseInt(in.getInputMask())));
		}else{
			//if it's long form
			longMask = in.getInputMask();
		}

		//let's validate the form

		if(!validateIpForm(longMask)){
			System.exit(6);
		}

		v.setValidMask(longMask);
		return v;
	}

	public boolean validateIpForm(String rawIp){
		//splits the given ip by the dots
		String[] octets = rawIp.split("\\.");
		//check if we have enough octets
		if(octets.length != 4){
			System.out.println(rawIp);
			System.out.printf("Need exactly four octets, got %d\n", octets.length);
			return false;
		}
		//checks if any value is bigger than 255 or less than 0
		for(String o : octets){
			int oct = Integer.parseInt(o);
			if(oct > 255) {
				System.out.printf("No octet can be higher that 255, got %d\n", oct);
				return false;
			}else if(oct < 0){
				System.out.printf("Can't have negative numbers, got %d\n", oct);
				return false;
			}
		}
		//In isolation, this should be enough to decide we have something with the form of an IP address
		//We can use this for masks in long form too
		return true;
	}

	public String constructBitMaskFromNumber(int num){

		StringBuilder mask = new StringBuilder(40);
		if(num > 32 || num < 0){
			System.out.println("Meaningless number for mask");
			System.exit(4);
		}

		for(int i = 0; i < 32; i++){
			if(i != 0 && (i % 8) == 0){
				mask.append(".");
			}
			if(i < num){
				mask.append(1);
			}else{
				mask.append(0);
			}

		}
		return mask.toString();
	}
}
