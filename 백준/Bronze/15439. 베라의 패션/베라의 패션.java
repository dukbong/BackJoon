import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
            
        // long을 넘어선다.
        BigInteger facN = BigInteger.ONE;
        BigInteger facK = BigInteger.valueOf(2);
        BigInteger facNK = BigInteger.ONE;
            
        for(int i = 1; i <= x; i++){
            facN = facN.multiply(BigInteger.valueOf(i));
        }
        for(int i = 1; i <= x - 2; i++){
            facNK = facNK.multiply(BigInteger.valueOf(i));
        }
        BigInteger result = facN.divide(facK.multiply(facNK));
        System.out.println(result.multiply(BigInteger.valueOf(2)));
        }
}