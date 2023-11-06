import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine()); // 찾고자 하는 위치
		machine(k, n);
	}

	private void machine(int k, int n) {
		
		long min = 1; // min(10^9, N2);
		long max = k;
		
		while(min < max){
			
			long mid = (max + min) / 2;
			long num = 0;
			
			for(int i = 1; i <= n; i++){
				num += Math.min(mid / i, n); // n은 그 행 전체를 의미한다.
			}
			
			if(k <= num){
				max = mid;
			}else{
				min = mid + 1;
			}
			
		}
		
		System.out.println(min);
	}
}