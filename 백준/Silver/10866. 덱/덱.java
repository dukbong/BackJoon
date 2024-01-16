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
			
			if(command.contains("push_front")){
				int num = Integer.parseInt(command.split(" ")[1]);
				q.addFirst(num);
				continue;
			}
			if(command.contains("push_back")){
				int num = Integer.parseInt(command.split(" ")[1]);
				q.addLast(num);
				continue;
			}
			
			switch(command){
			case "pop_front":
				// pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if(q.isEmpty()){
					sb.append(-1);
				}else{
					sb.append(q.poll());
				}
				break;
			case "pop_back":
				// pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if(q.isEmpty()){
					sb.append(-1);
				}else{
					sb.append(q.pollLast());
				}
				break;
			case "size":
				// size: 덱에 들어있는 정수의 개수를 출력한다.
				sb.append(q.size());
				break;
			case "empty":
				// empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
				if(q.isEmpty()){
					sb.append(1);
				}else{
					sb.append(0);
				}
				break;
			case "front":
				// front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if(q.isEmpty()){
					sb.append(-1);
				}else{
					sb.append(q.peek());
				}
				break;
			case "back":
				// back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
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