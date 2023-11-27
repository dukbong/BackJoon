import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static boolean[] check;
	static int[][] arr;
	static int count = 0;
	static int node, line;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		node = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());
	
		arr = new int[node+1][node+1];
		check = new boolean[node+1];
		
		for(int i = 0 ; i < line ; i ++) {
			int[] brArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			arr[brArr[0]][brArr[1]] = arr[brArr[1]][brArr[0]] =  1;	
		}
			dfs(1);
			System.out.println(count-1);
		}
	public static void dfs(int start) {
		
		check[start] = true;
		count++;
		
		for(int i = 0 ; i <= node ; i++) {
			if(arr[start][i] == 1 && !check[i])
				dfs(i);
		}
		
	}
	
}