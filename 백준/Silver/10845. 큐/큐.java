import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new LinkedList<>();
		
		int size = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < size; i++){
			String command = br.readLine();
			
			if(command.contains("push")){
				int num = Integer.parseInt(command.split(" ")[1]);
				q.offer(num);
				continue;
			}
			
			switch(command){
			case "pop":
				if(q.isEmpty()){
					sb.append(-1);
				}else{
					sb.append(q.poll());
				}
				break;
			case "size":
				sb.append(q.size());
				break;
			case "empty":
				if(q.isEmpty()){
					sb.append(1);
				}else{
					sb.append(0);
				}
				break;
			case "front":
				if(q.isEmpty()){
					sb.append(-1);
				}else{
					sb.append(q.peek());
				}
				break;
			case "back":
				if(q.isEmpty()){
					sb.append(-1);
				}else{
					sb.append(q.getLast());
				}
				break;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
/*
	push X: 정수 X를 큐에 넣는 연산이다.
	pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	size: 큐에 들어있는 정수의 개수를 출력한다.
	empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
	front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/