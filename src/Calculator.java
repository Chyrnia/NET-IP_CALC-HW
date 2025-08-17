/*
 * This is the Calculator class. Here we receive a ValidatedData instance, 
 * calculate network and broadcast addresses, and produce Results ;)
 */

public final class Calculator {
	private Calculator(){
	}

	public static ResultsData calculate(ValidatedData valid){
		ResultsData r = new ResultsData();
		String[] ipOctets = BinaryUtils.getBinaryIp(valid.getValidIp()).split("\\."); 
		String[] maskOctets = BinaryUtils.getBinaryIp(valid.getValidMask()).split("\\."); 
		String[] networkOctets = new String[4];
		String[] broadcastOctets = new String[4];

		//the network address of any IP+mask is networkIP = ip & mask
		for(int i = 0; i < ipOctets.length; i++){
			networkOctets[i] = BinaryUtils.bitwiseAndOctets(ipOctets[i], maskOctets[i]);
		}
		//the broadcast address is broadcast = networkIP | ~mask
		for(int i = 0; i < networkOctets.length; i++){
			broadcastOctets[i] = BinaryUtils.bitwiseOrOctets(networkOctets[i], BinaryUtils.invertOctet(maskOctets[i]));
		}
		r.setBinaryIp(String.join(".",ipOctets));
		r.setBinaryMask(String.join(".",maskOctets));
		r.setBinaryNet(String.join(".",networkOctets));
		r.setBinaryBroad(String.join(".",broadcastOctets));

		r.setValidatedIp(valid.getValidIp());
		r.setValidatedMask(valid.getValidMask());
		r.setNetworkIp(BinaryUtils.getNumericIp(r.getBinaryNet()));
		r.setBroadcastIp(BinaryUtils.getNumericIp(r.getBinaryBroad()));

		return r;
	}

	public static IpPairResult calculateReachability(ResultsData first, ResultsData second){

		//To calculate if two ips can reach each other,
		//we first see if the first can see the second,
		boolean firstToSecond = canIpASeeIpB(first, second);
		//and then if the second can see the first
		boolean secondToFirst = canIpASeeIpB(second, first);

		IpPairResult pair = new IpPairResult(first,second,firstToSecond,secondToFirst);
		return pair;
	}

	private static boolean canIpASeeIpB(ResultsData first, ResultsData second){
		//To determine if an IP can talk to another, we can think of it as if IP1 looks at IP2 through its own mask. If
		//applying IP1's mask to IP2 results in the same network that IP1's has, IP1 considers IP2 to be in its same subnet
		String[] firstMask = first.getBinaryMask().split("\\.");
		String[] secondIp = second.getBinaryIp().split("\\.");
		String[] calculatedNet = new String[4];
		for(int i = 0; i < secondIp.length; i++){
			calculatedNet[i] = BinaryUtils.bitwiseAndOctets(secondIp[i], firstMask[i]); 
		}
		//compare the calculatedNet with the netIp of IP1
		String calcNet = String.join(".",calculatedNet);
		return calcNet.equals(first.getBinaryNet());
	}
}
