import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int[] arr = new int[num + 2];
		arr[1] = 1;
		arr[2] = 2;
		
		if(num <= 2){
			System.out.println(num);
			return;
		}
		
		// 교휸.. 문제를 똑바로 읽자
		machine(num, arr);
	}

	private void machine(int num, int[] arr) {
		
		for(int i = 3; i <= num; i++){
			arr[i] = (arr[i - 2] + arr[i - 1]) % 15746;
		}
		
		System.out.println(arr[num]);
	}

//	시간 초과... 재귀
//	private int machine(int num) {
//		
//		if(num <= 2){
//			return num;
//		}
//		
//		return machine(num - 2) + machine(num - 1);
//	}
	
	
	
}


