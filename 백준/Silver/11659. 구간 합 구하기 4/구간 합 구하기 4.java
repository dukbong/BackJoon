import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private int[] brArr(String str){
		return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = brArr(br.readLine());
		int[] N = brArr(br.readLine());
		int[] sumArr = new int[N.length];
		
		sumArr[0] = N[0];
		for(int i = 1; i < N.length; i++){
			sumArr[i] = sumArr[i - 1] + N[i];
		}
		
		for(int i = 0; i < arr[1]; i++){
			int[] Q = brArr(br.readLine());
			int result = areaSum(sumArr, Q[0] - 1, Q[1] - 1);
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private int areaSum(int[] sumArr, int start, int end) {
//		1차 재귀함수 시간 초과
//		if(start > end){
//			return out;
//		}
//		out += n[start];
//		return areaSum(n, start + 1, end, out);
		
//		2차 for문 시간초과
//		for(int i = start; i <= end; i++){
//			out += n[i];
//		}
//		return out;
		
		if(start == 0){
			return sumArr[end];
		}
		return sumArr[end] - sumArr[start - 1];
	}
	
}