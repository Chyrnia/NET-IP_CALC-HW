public class CalculadoraRed {

	public static void main(String[] args){
		//create data class Input and assign the candidate
		if(args.length < 1){
			System.out.println("ERROR: Not enough arguments.");
			System.exit(1);
		}	
		else if(args.length == 1){
			InputData in = new InputData(args[0]);
			procedureWithOneIP(in);
		}
		else if(args.length == 2){
			InputData in1 = new InputData(args[0]);
			InputData in2 = new InputData(args[1]);
			procedureWithTwoIPs(in1,in2);
		}
	}

	private static void procedureWithOneIP(InputData in){
		//Pass Input to validator, get Validated Data and pass it to Calculator
		ValidatedData valid = Validator.validateInput(in);
		//return Results and print'em
		ResultsData r = Calculator.calculate(valid);
		ResultsPrinter.displaySingleResult(r);
	}

	private static void procedureWithTwoIPs(InputData in1, InputData in2){
		//Validate data
		ValidatedData v1 = Validator.validateInput(in1);
		ValidatedData v2 = Validator.validateInput(in2);
		//Calculate networks and broadcast
		ResultsData r1 = Calculator.calculate(v1);
		ResultsData r2 = Calculator.calculate(v2);
		//Calculate reachability
		IpPairResult pair = Calculator.calculateReachability(r1,r2);
		//Print results 
		ResultsPrinter.displayIpPairResult(pair);
	}

	private static void displayResults(ResultsData r){
		//prints the product of our incesant toiling
		System.out.printf("Original IP: %s\nBinary IP: %s\nOriginal Mask: %s\nBinary Mask: %s\nNetwork IP: %s\nBinary Network IP: %s\nBroadcast IP: %s\nBinary Broadcast IP: %s\n",
				r.getValidatedIp(), r.getBinaryIp(), r.getValidatedMask(), r.getBinaryMask(), r.getNetworkIp(), r.getBinaryNet(), r.getBroadcastIp(), r.getBinaryBroad());
	}


}
