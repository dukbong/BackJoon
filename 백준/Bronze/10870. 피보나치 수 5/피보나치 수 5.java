import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = factory(n);
		System.out.println(result);
	}

	private int factory(int n) {
		if(n <= 1){
			return n;
		}else{
			return factory(n - 2) + factory(n -1);
		}
	}
}