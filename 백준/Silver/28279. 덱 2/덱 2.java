import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		/*
		1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
		2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
		3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
		4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
		5: 덱에 들어있는 정수의 개수를 출력한다.
		6: 덱이 비어있으면 1, 아니면 0을 출력한다.
		7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
		8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
		*/
		
		int total = Integer.parseInt(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0; i < total; i++) {
			String str = br.readLine();
			
			if(str.length() == 1) {
				switch(str) {
				case "3":
					if(list.isEmpty()) {
						sb.append(-1).append("\n");
					}else {
						sb.append(list.removeFirst()).append("\n");
					}
					break;
				case "4":
					if(list.isEmpty()) {
						sb.append(-1).append("\n");
					}else {
						sb.append(list.removeLast()).append("\n");
					}
					break;
				case "5":
					sb.append(list.size()).append("\n");
					break;
				case "6":
					if(list.isEmpty()) {
						sb.append(1).append("\n");
					}else {
						sb.append(0).append("\n");
					}
					break;
				case "7":
					if(list.isEmpty()) {
						sb.append(-1).append("\n");
					}else {
						sb.append(list.getFirst()).append("\n");
					}
					break;
				case "8":
					if(list.isEmpty()) {
						sb.append(-1).append("\n");
					}else {
						sb.append(list.getLast()).append("\n");
					}
					break;
				}
			}else {
				int[] numArr = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
				if(numArr[0] == 1) {
					list.addFirst(numArr[1]);
				}else {
					list.addLast(numArr[1]);
				}
			}
		}
		System.out.println(sb.toString());
	}
}