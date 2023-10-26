import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[][] arr;
	static int blue;
	static int white;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());

		arr = new int[len][len];

		for (int i = 0; i < len; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		// 초기 검사.
		check(arr, arr.length, 0);
		
		squareFunc(len / 2, arr);
		
		System.out.println(white);
		System.out.println(blue);
	}

	private void squareFunc(int start, int[][] arr) {
		if (arr.length == 1) {
			return;
		}

		int[][] test = new int[start][arr[0].length * 2];

		// 2차원은 1차원으로 펼친다.
		for (int i = 0, j = start; i < arr.length / 2; i++, j++) {
			int[] testing = new int[test[i].length];
			System.arraycopy(arr[i], 0, testing, 0, arr[i].length);
			System.arraycopy(arr[j], 0, testing, arr[i].length, arr[j].length);
			test[i] = testing;
		}
//		for(int i = 0; i < test.length; i++){
//			System.out.println(Arrays.toString(test[i]));
//		}

//		System.out.println();
		check(test, start, 0);
//		System.out.println("=== check 이후");
//		for(int i = 0; i < test.length; i++){
//			System.out.println(Arrays.toString(test[i]));
//		}
//		System.out.println();
		squareFunc(test.length / 2, test);

	}

	// 해당 2차원 배열이 같은 숫자로 이루어졌는지 확인
	private void check(int[][] arr, int start, int num) {
		if (num > arr[0].length - 1) {
			return;
		}

		int checkNum = arr[0][num];
		boolean checkBool = true;

//		System.out.println("==============");
//		System.out.println("index 시작 위치 : " + (num + start));
//		System.out.println("checkNum : " + checkNum);
//		System.out.println("==============");
		if(checkNum != 8){
			loop: for (int i = 0; i < arr.length; i++) {
				for (int j = num; j < num + start; j++) { // 0,0 0,4 ..
//				System.out.println("i = " + i + ", j = " + j + " = " + arr[i][j]);
					if (checkNum != arr[i][j] || checkNum > 1) {
//					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//					System.out.println("불통..");
//					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						checkBool = false;
						break loop;
					}
				}
			}
		}

		if (checkBool && checkNum != 8) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = num; j < num + start; j++) { // 0,0 0,4 ..
					arr[i][j] = 8;
				}
			}
			if (checkNum == 1) {
				blue++;
			} else {
				white++;
			}
		}
		check(arr, start, num + arr.length);
	}
}