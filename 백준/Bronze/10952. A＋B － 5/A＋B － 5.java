import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int breakPoint = Arrays.stream(arr).reduce(1, (acc,cur) -> acc * cur);
			int sum = Arrays.stream(arr).reduce(0, (acc,cur) -> acc + cur);
			
			if(breakPoint == 0){
				break;
			}
			
			System.out.println(sum);
		}
	}
}