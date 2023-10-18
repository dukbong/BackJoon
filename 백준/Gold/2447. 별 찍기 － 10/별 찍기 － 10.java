import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	// 현재 시간 복잡도 O(N^2)
	// 문제1 > 메모리 초과
	// 문제2 > 중복계산 하는 곳이 있음
	
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int question = Integer.parseInt(br.readLine());
		char[][] arr = new char[question][question]; 

		Arrays.stream(arr).forEach(i -> { // N^2
			Arrays.fill(i, '*');
		});

		arr = draw(arr, question);

		for (char[] cr : arr) {
			sb.append(cr).append("\n");
		}
		System.out.println(sb.toString());
	}

	private char[][] draw(char[][] arr, int question) {
		if (question == 1) {
			return arr;
		} else {
			for (int i = question / 3; i < arr.length; i += question) {
				for (int j = question / 3; j < arr[0].length; j += question) {
					
					for (int k = 0; k < question / 3; k++) { // 중복 발생
						for (int l = 0; l < question / 3; l++) {
							arr[i + k][j + l] = ' ';
						}
					}
					
				}
			}
			return draw(arr, question / 3);
		}
	}
}