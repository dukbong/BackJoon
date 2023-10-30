import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;

public class Main {

	StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nCount = Integer.parseInt(br.readLine());
		int[] N = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(N);
		int mCount = Integer.parseInt(br.readLine());
		int[] M = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		for(int i = 0; i < M.length; i++){
			if(machine(N, M[i]) >= 0){
				sb.append(1).append("\n");
			}else{
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}

	private int machine(int[] n, int m) {
		int low = 0;
		int heigh = n.length - 1;
		
		while(low <= heigh){
			int middle = (low + heigh) / 2;
			if(m < n[middle]){
				heigh = middle - 1;
			}else if (m > n[middle]){
				low = middle + 1;
			}else{
				return middle;
			}
		}
		
		return -1;
	}


}