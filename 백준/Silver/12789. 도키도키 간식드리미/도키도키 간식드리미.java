import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
//		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Queue<Integer> test = Stream.of(br.readLine().split(" "))
									.map(Integer::parseInt)
									.collect(Collectors.toCollection(ArrayDeque::new));
		Queue<Integer> queue = new LinkedList<>(); // 정답 모음
		Stack<Integer> stack = new Stack<>();     // 오답 모음
		boolean check = true;
		
		while(test.size() != 0){
			int x = queue.size() + 1;
			if(x == test.peek()){
				queue.offer(test.poll());
			}else{
				if(stack.isEmpty()){
					stack.push(test.poll());
				}else{
					if(x == stack.peek()){
						queue.offer(stack.pop());
					}else{
						stack.push(test.poll());
					}
				}
			}
		}
		
		int count = 1;
		int num = queue.size();
		while(stack.size() != 0){
			if(num + count != stack.pop()){
				check = false;
				break;
			}else{
				count++;
			}
		}
		System.out.println(check?"Nice":"Sad");
	}
}