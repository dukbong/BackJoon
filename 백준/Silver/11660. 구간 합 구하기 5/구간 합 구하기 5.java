import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	/*
	혼자 끄적이다 방법을 찾았다.
	4 3
	1 2 3 4 > 1 3 6 10
	2 3 4 5 > 2 5 9 14 
	3 4 5 6 > 3 7 12 18
	4 5 6 7 > 4 9 15 22
	*/
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private int[] readLineToArr(String str) {
		return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] Q = readLineToArr(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] nujeokArr = new int[Q[0]][Q[0]];
		
		// int[][] doubleArr = new int[Q[0]][Q[0]];

		for (int i = 0; i < Q[0]; i++) {
			// 음... 굳이 원본은 필요가 없다.
			// doubleArr[i] = readLineToArr(br.readLine());
			// nujeokArr[i][0] = doubleArr[i][0];
			// for(int j = 1; j < doubleArr.length; j++){
			// nujeokArr[i][j] = nujeokArr[i][j - 1] + doubleArr[i][j];
			// }
			int[] test = readLineToArr(br.readLine());
			nujeokArr[i][0] = test[0];
			for (int j = 1; j < test.length; j++) {
				nujeokArr[i][j] = nujeokArr[i][j - 1] + test[j];
			}
		}
//		누적합이 보고 싶어요~
//		for (int i = 0; i < 4; i++) {
//			System.out.println(Arrays.toString(nujeokArr[i]));
//		}

//		질문 시간
		for (int i = 0; i < Q[1]; i++) {
			int[] lineQ = readLineToArr(br.readLine());
			int startY = lineQ[0] - 1;
			int startX = lineQ[1] - 1;

			int endY = lineQ[2] - 1;
			int endX = lineQ[3] - 1;

			int height = endY - startY;
			
//			각각의 질문에 결과를 저장한다.
			int lineResult = 0;
			for(int j = 0; j <= height; j++){
				lineResult += nujeokArr[startY + j][endX] - (startX - 1 >= 0 ? nujeokArr[startY + j][startX - 1] : 0);
			}
			sb.append(lineResult).append("\n");
		}
		System.out.println(sb.toString());
		// 시간 복잡도 N^2
	}
}