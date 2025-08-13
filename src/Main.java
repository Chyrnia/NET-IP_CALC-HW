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
		ValidatedData valid = v.validateInput(in);
		System.out.println(valid.getValidIp());
		System.out.println(valid.getValidMask());

		//Pass Input to validator
		//get Validated Data and pass it to Calculator
		//return Results and print'em
		//For now, just to test thing are going ok, lets create a Results object, populate it with bullshit and print


	}

	private static void displayResults(Results r){
		//prints the product of our incesant toiling
		System.out.printf("Original IP : %s\nNetwork IP: %s\nBroadcast IP: %s\n",
				r.getValidatedIp(), r.getNetworkIp(), r.getBroadcastIp());
	}


}
