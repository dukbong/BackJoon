import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
        	int[] x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	BigInteger facN = IntStream.rangeClosed(1, x[1]).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, (acc, cur) -> acc.multiply(cur));
        	BigInteger facM = IntStream.rangeClosed(1, x[0]).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, (acc, cur) -> acc.multiply(cur));
        	BigInteger facNM = IntStream.rangeClosed(1,  x[1] - x[0]).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, (acc, cur) -> acc.multiply(cur));
        	sb.append(facN.divide(facM.multiply(facNM))).append("\n");
        }
        System.out.println(sb.toString());
    }
}