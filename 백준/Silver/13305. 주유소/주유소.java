import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        BigInteger[] distance = new BigInteger[N-1];
		BigInteger[] price = new BigInteger[N-1];
		for(int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N-1; j++) {
				if(i == 0) {
					distance[j] = new BigInteger(st.nextToken());
				}else {
					price[j] = new BigInteger(st.nextToken());
				}
			}
		}
		BigInteger start = price[0];
		BigInteger result = start.multiply(distance[0]);
		for(int i = 1; i < N-1; i++) {
			if(price[i].compareTo(start)==1) { // price[i] > start
				price[i] = start;
			}
			start = price[i];
			result = result.add(start.multiply(distance[i]));
		}
		System.out.println(result);
	}
}