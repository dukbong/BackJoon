import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String trash = br.readLine();
		int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		System.out.println(arr[0] + " " + arr[arr.length - 1]);
	}
}