import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int limit = Integer.parseInt(br.readLine().split(" ")[1]);
		String[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).filter(val -> val < limit).mapToObj(String::valueOf).toArray(String[]::new);
		String join = String.join(" ", arr);
		System.out.println(join);
	}
}