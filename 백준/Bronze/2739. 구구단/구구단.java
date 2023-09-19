import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for(int i = 1; i <= 9; i++){
			System.out.printf("%d * %d = %d\n", num, i, num * i);
		}
	}
}