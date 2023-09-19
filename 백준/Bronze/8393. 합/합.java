import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i = num; i >= 1; i--){
			result += i;
		}
		System.out.println(result);
	}
}