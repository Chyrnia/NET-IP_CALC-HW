public class Main {

	public static void main(String[] args){
		//create data class Input and assign the candidate
		Input in = null;
		if(args.length != 1){
			System.out.println("ERROR: Not enough arguments.");
			System.exit(1);
		}	
		in = new Input(args[0]);

		//Instances of computing classes
		//validator, calculator and parser
		Validator v = new Validator();
		Calculator c = new Calculator();

		//Pass Input to validator, get Validated Data and pass it to Calculator
		ValidatedData valid = v.validateInput(in);
		//return Results and print'em
		Results r = c.calculate(valid);
		displayResults(r);
	}

	private static void displayResults(Results r){
		//prints the product of our incesant toiling
		System.out.printf("Original IP : %s\nNetwork IP: %s\nBroadcast IP: %s\n",
				r.getValidatedIp(), r.getNetworkIp(), r.getBroadcastIp());
	}


}
