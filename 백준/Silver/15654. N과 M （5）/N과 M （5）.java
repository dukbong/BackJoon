import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	int[] nums;
	int limit;
	StringBuilder sb = new StringBuilder();
	int[] result;
	boolean[] visited;

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		limit = arr[1];
		visited = new boolean[nums.length];
		result = new int[limit];
		Arrays.sort(nums);
		dfs(0,0);
		System.out.println(sb);
	}

	private void dfs(int num, int level) {
		if(level == limit) {
			for(int i = 0; i < result.length; i++) {
				if(i != result.length - 1) {
					sb.append(result[i]).append(" ");
				}else {
					sb.append(result[i]);
				}
			}
			sb.append("\n");
			return;
		}
		
		for(int i = num; i < nums.length; i++) {
			if(visited[i] == false) {
				result[level] = nums[i];
				visited[i] = true;
				dfs(num, level + 1);
				visited[i] = false;
			}
		}
		
	}

}