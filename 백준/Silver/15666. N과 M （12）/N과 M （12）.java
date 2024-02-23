import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	int count, len;
	int[] result, q;
	StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] condition = stringToIntArr(br.readLine());
		q = stringToIntArr(br.readLine());
//		1차 시도 (사실 왜 틀린지 모르겠음)
//		Set<Integer> set = new HashSet<>();
//		for(int num : q) {
//			set.add(num);
//		}
//		q = set.stream().mapToInt(Integer::intValue).toArray();
//		len = q.length; // 총 개수
//		count = condition[1];
//		result = new int[count];
//		Arrays.sort(q);
//		dfs(0,0);
//		System.out.println(sb);
		
//		2차 시도
		len = condition[0];
		count = condition[1]; // 뽑을 개수
		Arrays.sort(q);
		result = new int[count];
		dfs(0, 0);
		System.out.println(sb);
	}

	private void dfs(int start, int level) {
		if (level == count) {
			for (int i = 0; i < count; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int before = Integer.MIN_VALUE;
		for (int i = start; i < len; i++) {
			int now = q[i];
			if (before != now) {
				before = now;
				result[level] = q[i];
				dfs(i, level + 1);
			}
//				result[level] = q[i];
//				dfs(i, level + 1);
		}

	}

	public int[] stringToIntArr(String str) {
		return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

}