import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++){
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int sum = Arrays.stream(arr).reduce(0, (acc, cur) -> acc + cur);
			bw.write("Case #" + (i + 1) + ": " + arr[0] + " + " + arr[1] + " = " + sum+"\n");
		}
		bw.flush();
		bw.close();
	}
}
