import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	int limit, size;
	boolean[] visited;
	int[] result, array;
	StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] question = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		limit = question[1];
		size = question[0];
		array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		visited = new boolean[array.length];
		result = new int[limit];
		Arrays.sort(array);
		dfs(0);
		System.out.println(sb);

	}

	public void dfs(int cnt) {
		if (cnt == limit) {
			for (int i = 0; i < limit; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		}

		else {
			int before = 0;
			for (int i = 0; i < size; i++) {
				if (!visited[i] && before != array[i]) {
					visited[i] = true;
					result[cnt] = array[i];
					before = array[i];
					dfs(cnt + 1);
					visited[i] = false;
				}
			}
		}
	}

}