/*
 * This is the Calculator class. Here we receive a ValidatedData instance, 
 * calculate network and broadcast addresses, and produce Results ;)
 */

public class Calculator extends BinaryStringManipulator {
	public Calculator(){
	}

	public Results calculate(ValidatedData valid){
		Results r = new Results();
		String[] ipOctets = getBinaryIp(valid.getValidIp()).split("\\."); 
		String[] maskOctets = getBinaryIp(valid.getValidMask()).split("\\."); 
		String[] networkOctets = new String[4];
		String[] broadcastOctets = new String[4];
		
		//the network address of any IP+mask is networkIP = ip & mask
		for(int i = 0; i < ipOctets.length; i++){
			networkOctets[i] = super.bitwiseAndOctets(ipOctets[i], maskOctets[i]);
		}
		//the broadcast address is broadcast = networkIP | ~mask
		for(int i = 0; i < networkOctets.length; i++){
			broadcastOctets[i] = super.bitwiseOrOctets(networkOctets[i], super.invertOctet(maskOctets[i]));
		}

		r.setValidatedIp(valid.getValidIp());
		r.setNetworkIp(super.getNumericIp(String.join(".",networkOctets)));
		r.setBroadcastIp(super.getNumericIp(String.join(".",broadcastOctets)));

		return r;
	}

}
