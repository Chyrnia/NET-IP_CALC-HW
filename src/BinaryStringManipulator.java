/* 
 * This is the Binary String Manipulator class, and it is the parent of Validator and Calculator both, 
 * as they are the classes that need to manipulate strings with binary representations.
 */

import java.util.StringTokenizer;

public class BinaryStringManipulator {

	public BinaryStringManipulator(){
	}

    public String getBinaryOctet(int ipChunk){
        StringBuilder builder = new StringBuilder(Integer.toBinaryString(ipChunk));
        while(builder.length() < 8){
            builder.insert(0,0);  //this inserts a zero on the left until our binary representation has a length of 8
        }
        if(builder.length() > 8){
			builder.delete(0, builder.length() - 8);
        }
        return builder.toString();
    }

	public String getBinaryIp(String strIp){
		StringBuilder builder = new StringBuilder(40);
		StringTokenizer tokenizer = new StringTokenizer(strIp, ".");
		int count = 0;

		while(tokenizer.hasMoreTokens()){
			if(count > 0){
				builder.append(".");
			}

			builder.append(this.getBinaryOctet(Integer.parseInt(tokenizer.nextToken())));
			count++;
		}

		return builder.toString();
	}

	public String getNumericIp(String binStrIp){
		StringBuilder builder = new StringBuilder(20);
		StringTokenizer tokenizer = new StringTokenizer(binStrIp, ".");
		int count = 0;

		while(tokenizer.hasMoreTokens()){
			if(count > 0){
				builder.append(".");
			}
			builder.append(Integer.parseInt(tokenizer.nextToken(), 2));
			count++;
		}
		return builder.toString();
	}

	public String bitwiseAndOctets(String o1, String o2){
		int first = Integer.parseInt(o1,2);
		int second = Integer.parseInt(o2,2);
		return this.getBinaryOctet(first & second);
	}

	public String bitwiseOrOctets(String o1, String o2){
		int first = Integer.parseInt(o1,2);
		int second = Integer.parseInt(o2,2);
		return this.getBinaryOctet(first|second);
	}

	public String getLastOctet(String binStrIp){
		return binStrIp.substring(27);
	}

	public String invertOctet(String octet){
		int o = Integer.parseInt(octet, 2);
		return this.getBinaryOctet(~o);
	}
}
