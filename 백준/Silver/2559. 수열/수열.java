import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private int[] lineArr(String str){
		return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] Q = lineArr(br.readLine());
		int[] N = lineArr(br.readLine());
		int[] nSum = new int[N.length];
		nSum[0] = N[0];
		for(int i = 1; i < N.length; i++){
			nSum[i] = nSum[i - 1] + N[i];
		}
		int[] arr = temp(nSum, Q[1] - 1);
		Arrays.sort(arr);
		System.out.println(arr[arr.length - 1]);
	}

	private int[] temp(int[] nSum, int area) {
		int[] save = new int[nSum.length - area];
		for(int i = 0; i <= nSum.length - area - 1; i++){
			if(i == 0){
				save[i] = nSum[area];
			}else{
				save[i] = nSum[i + area] - nSum[i - 1];
			}
		}
		return save;
	}
}