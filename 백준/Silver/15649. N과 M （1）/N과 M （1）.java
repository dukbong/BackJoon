import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
	
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] question = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] arr = IntStream.rangeClosed(1, question[0]).toArray(); // 전체 배열
		boolean[] bool = new boolean[question[0]]; // 중복을 막기 위해
		int[] out = new int[question[1]];
		
		backTracking(arr, out, bool, 0, question[1]);
		System.out.println(sb.toString());
	}

	private void backTracking(int[] arr, int[] out, boolean[] bool, int depth, int count) {
		
		// 찾았을 경우
		if(depth == count){
			for(int i = 0; i < out.length; i++){
				System.out.print(out[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < arr.length; i++){
			if(!bool[i]){
				bool[i] = true;
				out[depth] = arr[i];
				backTracking(arr,out, bool, depth + 1, count);
				bool[i] = false;
			}
		}
	}
}