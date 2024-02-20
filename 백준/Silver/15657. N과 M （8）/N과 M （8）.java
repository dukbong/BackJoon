import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	StringBuilder sb = new StringBuilder();
	int[] arr, size, result;

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 0 : size
		// 1 : 결과 배열 크기
		size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		// 실제 문제 배열
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		// 결과를 저장할 배열
		result = new int[size[1]];
		Arrays.sort(arr);
		dfs(0, 0);

		System.out.println(sb);
	}

	private void dfs(int start, int level) {
		if (level == size[1]) {
			for (int i = 0; i < size[1]; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		} else {

			// 뒤로 갈수록 앞에 숫자를 뽑지 않겠다.
			for (int i = start; i < arr.length; i++) {
				result[level] = arr[i];
				dfs(i, level + 1);
			}

		}

	}

}