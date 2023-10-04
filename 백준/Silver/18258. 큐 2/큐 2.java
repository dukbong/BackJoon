import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		/*
		push X: 정수 X를 큐에 넣는 연산이다.
		pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		size: 큐에 들어있는 정수의 개수를 출력한다.
		empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
		front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		*/
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		int lastNum = 0;
		for(int i = 0; i < length; i++){
			String str = br.readLine();
			if(str.contains("push")){
				int num = Integer.parseInt(str.split(" ")[1]);
				lastNum = num;
				queue.offer(num);
			}else{
				switch(str){
				case "pop":
					if(queue.isEmpty()){
						sb.append(-1);
					}else{
						sb.append(queue.poll());
					}
					sb.append("\n");
					break;
				case "size":
					sb.append(queue.size()).append("\n");
					break;
				case "empty":
					if(queue.isEmpty()){
						sb.append(1);
					}else{
						sb.append(0);
					}
					sb.append("\n");
					break;
				case "front":
					if(queue.isEmpty()){
						sb.append(-1);
					}else{
						sb.append(queue.peek());
					}
					sb.append("\n");
					break;
				case "back":
					if(queue.isEmpty()){
						sb.append(-1);
					}else{
						sb.append(lastNum);
					}
					sb.append("\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}