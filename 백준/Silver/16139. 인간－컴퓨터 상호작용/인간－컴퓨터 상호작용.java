import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String N = br.readLine();
		int qCount = Integer.parseInt(br.readLine());
		int[] sumArr = new int[N.length()];
		String checkPoint = "";

		for (int i = 0; i < qCount; i++) {
			String[] arr = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);

			if (!checkPoint.equals(arr[0])) { // 똑같다면 미리 찾아둔 값으로 해결한다.
				checkPoint = arr[0];
				sumArr[0] = String.valueOf(N.charAt(0)).equals(checkPoint) ? 1 : 0;
				for (int j = 1; j < N.length(); j++) {
					sumArr[j] = sumArr[j - 1] + (String.valueOf(N.charAt(j)).equals(checkPoint) ? 1 : 0);
				}
			}

			int check = machine(N, arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), sumArr);
			sb.append(check).append("\n");
		}
		System.out.println(sb.toString());
	}

	private int machine(String string, String checkStr, int start, int end, int[] sumArr) {
		if (start == 0) {
			return sumArr[end];
		}
		return sumArr[end] - sumArr[start - 1];
	}
}