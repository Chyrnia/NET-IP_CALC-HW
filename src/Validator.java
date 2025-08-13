/*
 * This is the class validator. It expects an Input instance, with the raw data. It verifies the ip
 * and the mask are both valid, suitable for calculator to work on them. It can manage masks in the 
 * form /number or /number.number.number.number
 */
import java.util.StringTokenizer;
public class Validator extends BinaryStringManipulator {
    public Validator(){
    }

    public ValidatedData validateInput(Input in){
        //initialize the tokenizer
        tokenizer = new StringTokenizer(in.getInputIp(),".");



        //create data container instance
        ValidatedData valid = new ValidatedData();

        return valid;
    }

    private String validateIp(String rawIp){
        //validate ip
        if(tokenizer.countTokens() == 4){
            StringBuilder binForm = new StringBuilder(35);
            int[] ipChunk = new int[4];
            int i = 0;
            //fill the ipChunk with the actual numbers
            while(tokenizer.hasMoreTokens()){
                ipChunk[i] = Integer.parseInt(tokenizer.nextToken());
                i++;
            }
            //check that the chunks are at least feasibly part of an IP address
            for(int ch : ipChunk){
                if(ch < 0 || ch > 255){
                    System.out.printf("No member of an IP address can be:\n- Less than 0\n- Bigger than 255\n\tThere's a term: [%i]\n", ch);
                    System.exit(3);
                }
                if(Integer.toBinaryString(ch).length() < 8){
                    while(Integer.toBinaryString(ch).length() < 8){
                    }
                } else{
                    System.out.printf("Not enough ip octets. Required 4. Have %i\n", tokenizer.countTokens());
                    System.exit(2);
                }
            }
        }
        return "ERROR";
    }


}
