import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int count = Integer.parseInt(br.readLine());
		for(int i = 0; i < count; i++){
			int something = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).reduce(1, (acc, cur) -> acc * cur);
			total -= something;
		}
		System.out.println(total == 0 ? "Yes" : "No");
	}
}