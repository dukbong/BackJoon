import java.io.*;
import java.util.*;

public class Main {

	static int result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		boolean[][] bool = new boolean[count][count];

		nQueen(bool, 0, count);
		System.out.println(result);
	}

	private void nQueen(boolean[][] bool, int start, int count) {
		if (count == 0) {
			long trueCount = 0; // 이 부부을 고치고 싶다.
			for (int i = 0; i < bool.length; i++) {
				for (int j = 0; j < bool[i].length; j++) {
					if (bool[i][j])
						trueCount++;
				}
			}

			if (trueCount == bool.length) {
				// for (int i = 0; i < bool.length; i++) {
				// for (int j = 0; j < bool[i].length; j++) {
				// if (bool[i][j]) {
				// sb.append("O ");
				// } else {
				// sb.append("X ");
				// }
				// }
				// sb.append("\n");
				// }
				// System.out.println(sb.toString());
				// sb.setLength(0);
				result++;
			}
			return;
		}

		// 여기가 문제다. N^2이면서 재귀다... 줄이자..
		// for (int i = start; i < bool.length; i++) {
		// for (int j = 0; j < bool[i].length; j++) {
		//
		// bool[i][j] = check(bool, i, j);
		//
		// if (bool[i][j]) {
		// nQueen(bool, i + 1, count - 1);
		// bool[i][j] = false;
		// }
		//
		// }
		// }

		for (int i = 0; i < bool.length; i++) {

			bool[i][start] = check(bool, i, start);

			if (bool[i][start]) {
				nQueen(bool, start + 1, count - 1);
				bool[i][start] = false;
			}
		}

	}

	private boolean check(boolean[][] bool, int y /* 행 */, int x/* 열 */) {
		// 시간 복잡도가 N^2이다.
		// for (int i = 0; i < bool.length; i++) {
		// for (int j = 0; j < bool[i].length; j++) {
		// if (bool[i][j]) {
		// if (i == y || j == x || Math.abs(i - y) == Math.abs(j - x)) {
		// return false;
		// }
		// }
		// }
		// }

		// 개선한 코드 아래의 시간복잡도는 N이다.
		for (int i = 0; i < bool.length; i++) {
			if (bool[i][x]/* 행 검사 */ || bool[y][i] /* 열 검사 */) {
				return false;
			}
		}

		for (int i = y, j = x; i >= 0 && j >= 0; i--, j--) {
			if (bool[i][j]) {
				return false;
			}
		}

		for (int i = y, j = x; i >= 0 && j < bool.length; i--, j++) {
			if (bool[i][j]) {
				return false;
			}
		}
		// 코드 줄이기
		for (int i = y, j = x; j >= 0 && i < bool.length; i++, j--) {
			if (bool[i][j]) {
				return false;
			}
		}

		for (int i = y, j = x; i < bool.length && j < bool.length; i++, j++) {
			if (bool[i][j]) {
				return false;
			}
		}

		return true;
	}
}
