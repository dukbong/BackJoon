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
		/*
		 * 처음 든 생각 누접합을 구하고 1~n까지 구해서 max를 구한다. >> 좀 제일 단순한 방법인거 같다.
		 */
		int num = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// int max = Arrays.stream(arr).max().getAsInt();

		// 4차 줄이기 시도
		// 누적합
		// for (int i = 1; i < num; i++) {
		// arr[i] = arr[i - 1] + arr[i];
		// }

		// machine(arr, 1, num, max);
		machine(arr, arr[0], arr[0]);
	}

	// private void machine(int[] sumArr, int start, int num, int max) {
	private void machine(int[] sumArr, long prev, long max) {
		// 1차 메모리 초과 발생 !!! 재귀 버리기
		// if (start == num) {
		// System.out.println(max);
		// System.out.println("최대값은 " + max);
		// return;
		// }
		//
		// int[] changeArr = new int[num - start];
		//
		// changeArr[0] = sumArr[start];
		// for (int i = 1; i < num - start; i++) {
		// // System.out.println(sumArr[i+start] + ", " + sumArr[j]);
		// changeArr[i] = sumArr[i + start] - sumArr[i - 1];
		// if (changeArr[i] > max) {
		// max = changeArr[i];
		// }
		// }
		// System.out.println(Arrays.toString(changeArr) + " >> " + (start+1));

		// machine(sumArr, start + 1, num, max);

		// 2차 반복문도 메모리 초과..
		// 3차 이걸 좀 더 줄여볼 필요가 있다. >> 필요없는 배열들을 다 버린다. >> 이번엔 시간초과 ㅠㅠ (O(N^2))
		// while(start != num){
		// int[] changeArr = new int[num - start]; // 3차에서 지움

		// changeArr[0] = sumArr[start]; // 3차에서 지움

		// for(int i = 1; i < num - start; i++){
		for (int i = 1; i < sumArr.length; i++) {
			// changeArr[i] = sumArr[i + start] - sumArr[i - 1]; // 3차에서 지움
			if(sumArr[i] < sumArr[i] + prev){
				prev = sumArr[i] + prev;
			}else{
				prev = sumArr[i];
			}
			
			if(max < prev){
				max = prev;
			}
//			int testNum = sumArr[i + start] - sumArr[i - 1]; // 3차에서 변경
//			if (testNum > max) {
//				max = testNum;
//			}
		}
		// System.out.println(Arrays.toString(changeArr) + " >> " + (start+1));
		// start++;
		// }
		System.out.println(max);
	}

}
