public class CalculadoraRed {

	public static void main(String[] args){
		//create data class Input and assign the candidate
		InputData in = null;
		if(args.length != 1){
			System.out.println("ERROR: Not enough arguments.");
			System.exit(1);
		}	
		in = new InputData(args[0]);

		//Instances of computing classes
		//validator, calculator and parser
		Validator v = new Validator();
		Calculator c = new Calculator();

		//Pass Input to validator, get Validated Data and pass it to Calculator
		ValidatedData valid = v.validateInput(in);
		//return Results and print'em
		ResultsData r = c.calculate(valid);
		displayResults(r);
	}

	private static void displayResults(ResultsData r){
		//prints the product of our incesant toiling
		System.out.printf("Original IP: %s\nBinary IP: %s\nOriginal Mask: %s\nBinary Mask: %s\nNetwork IP: %s\nBinary Network IP: %s\nBroadcast IP: %s\nBinary Broadcast IP: %s\n",
				r.getValidatedIp(), r.getBinaryIp(), r.getValidatedMask(), r.getBinaryMask(), r.getNetworkIp(), r.getBinaryNet(), r.getBroadcastIp(), r.getBinaryBroad());
	}


}
