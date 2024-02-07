import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (testCase-- > 0) {
			int count = 0;
			// size & index
			int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			// importance
			int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			Deque<Integer> q1 = new LinkedList<>();
			Deque<Integer> q2 = new LinkedList<>();
			PriorityQueue<Integer> q3 = new PriorityQueue<>(Collections.reverseOrder());
			
			// Queue add
			for(int i = 1; i <= arr1[0]; i++) {
				q1.add(i);
			}
			for(int i = 0; i < arr2.length; i++) {
				q2.add(arr2[i]);
				q3.add(arr2[i]);
			}
			
			while(true) {
				if(q2.peek() == q3.peek()) {
					// 정상
					if(q1.peek() == arr1[1] + 1) {
						sb.append(count + 1).append("\n");
						break;
					}
						count++;
						q1.poll();
						q2.poll();
						q3.poll();
				}else {
					// 비정상
					int tempNum = q1.poll();
					int tempImportance = q2.poll();
					q1.offer(tempNum);
					q2.offer(tempImportance);
				}
			}
		}
		System.out.println(sb);
	}
}