public class Main {

	public static void main(String[] args){
		//create data class Input and assign the candidate
		Input in = new Input(args[0]);

		//Instances of computing classes
		//validator, calculator and parser
		
		//Do the work
		//First pass Input object to parser
		//Then pass it to validator
		//get Validated Data and pass it to Calculator
		//return Results and print'em
		//For now, just to test thing are going ok, lets create a Results object, populate it with bullshit and print

		Results out = new Results();
		out.setValidatedIp("192.168.1.108");
		out.setNetworkIp("192.168.1.0");
		out.setBroadcastIp("192.168.1.255");
		
		displayResults(out);


	}

	private static void displayResults(Results r){
		//prints the product of our incesant toiling
		System.out.printf("Original IP : %s\nNetwork IP: %s\nBroadcast IP: %s\n",
				r.getValidatedIp(), r.getNetworkIp(), r.getBroadcastIp());
	}

	//Private attributes

}
