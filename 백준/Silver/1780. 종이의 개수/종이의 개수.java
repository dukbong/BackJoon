import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static StringBuilder sb = new StringBuilder();
	int minusOne = 0;
	int zero = 0;
	int one = 0;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());

		int[][] arr = new int[len][len];

		for (int i = 0; i < len; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		machine(0, 0, len, arr);

		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(one);
	}

	private void machine(int y, int x, int len, int[][] arr) {
		boolean check = true;

		int target = arr[y][x];

		for (int i = y; i < y + len; i++) {
			for (int j = x; j < x + len; j++) {
				if (target != arr[i][j]) {
					check = false;
				}
			}
		}

		if (check) {
			if (target == -1) {
				minusOne++;
			} else if (target == 0) {
				zero++;
			} else {
				one++;
			}
			return;
		}

		len /= 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				machine(y + i * len, x + j * len, len, arr);
			}
		}

//		machine(y, x, len, arr); // 가장 왼쪽 위
//		machine(y, x + len, len, arr);
//		machine(y, x + len * 2, len, arr);
//
//		machine(y + len, x, len, arr);
//		machine(y + len, x + len, len, arr);
//		machine(y + len, x + len * 2, len, arr);
//
//		machine(y + len * 2, x, len, arr); 
//		machine(y + len * 2, x + len, len, arr); 
//		machine(y + len * 2, x + len * 2, len, arr); // 가장 오른쪽 아래
	}
}