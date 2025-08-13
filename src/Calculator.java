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
		r.setBinaryIp(String.join(".",ipOctets));
		r.setBinaryMask(String.join(".",maskOctets));
		r.setBinaryNet(String.join(".",networkOctets));
		r.setBinaryBroad(String.join(".",broadcastOctets));

		r.setValidatedIp(valid.getValidIp());
		r.setValidatedMask(valid.getValidMask());
		r.setNetworkIp(super.getNumericIp(r.getBinaryNet()));
		r.setBroadcastIp(super.getNumericIp(r.getBinaryBroad()));

		return r;
	}

}
