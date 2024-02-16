import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	StringBuilder sb = new StringBuilder();
	int limit;
	List<int[]> list;

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		limit = Integer.parseInt(br.readLine());

		// 저장 용도
		list = new ArrayList<>();

		for (int i = 0; i < limit; i++) {
			list.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
		}

		for (int i = 0; i < limit; i++) {
			go(i);
		}

		System.out.println(sb);
	}

	private void go(int start) {
		int count = 1;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(start)[0] < list.get(i)[0] && list.get(start)[1] < list.get(i)[1]) {
				count++;
			}
		}
		
		if (start < limit - 1) {
			sb.append(count).append(" ");
		} else {
			sb.append(count);
		}
	}

}