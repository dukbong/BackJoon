import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int size = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < size; i++){
			String command = br.readLine();
			
			if(command.contains("push")){
				int num = Integer.parseInt(command.split(" ")[1]);
				stack.add(num);
				continue;
			}
			
			switch(command){
			case "pop":
				if(stack.isEmpty()){
					sb.append(-1);
				}else{
					sb.append(stack.pop());
				}
				break;
			case "size":
				sb.append(stack.size());
				break;
			case "empty":
				if(stack.isEmpty()){
					sb.append(1);
				}else{
					sb.append(0);
				}
				break;
			case "top":
				if(stack.isEmpty()){
					sb.append(-1);
				}else{
					sb.append(stack.peek());
				}
				break;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
/*
	push X: 정수 X를 스택에 넣는 연산이다.
	pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	size: 스택에 들어있는 정수의 개수를 출력한다.
	empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
	top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/