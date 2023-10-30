import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		System.out.println(machine(arr[0], arr[1], arr[2]));
		
//		for(int i = 0; i < Q[1]; i++){
//			if(Q[0] < Q[2]){
//				Q[0] *= Q[0];
//			}else{
//				System.out.println(Q[0] % Q[2]);
//				break;
//			}
//		}
	}

	private long machine(int i, int j, int k) {
		if(j == 0){
			return 1;
		}
		
		long x = machine(i,j/2,k);
		if(j % 2 == 0){
			return x * x % k;
		}else{
			return (x * x % k) * i % k;
		}
	}

}