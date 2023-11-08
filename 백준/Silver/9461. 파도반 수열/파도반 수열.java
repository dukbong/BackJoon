import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] arr = machine();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++){
			int question = Integer.parseInt(br.readLine());
			sb.append(arr[question]).append("\n");
//			long[] arr = new long[question + 3];
//			machine(question, arr);
		}
		System.out.print(sb);
	}

	/*
	 * 생각해보니 지금 코드는 매번 새롭게 더해준다.
	 * 테스트 개수만큼 반복문이 돌아간다.
	 * 개선이 가능하다.
	 * */
	private long[] machine(/*int question, long[] arr*/) {
		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;

		for(int i = 4; i < arr.length; i++){
			arr[i] = (arr[i - 3] + arr[i - 2]);
		}
		
		return arr;
	}
}


