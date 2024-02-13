import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int start = 0;
		
		while(size-- > 0) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > start) {
				for(int i = start + 1; i <= num; i++) {
					stack.push(i); // 1,2,3,4
					sb.append("+").append("\n");
				}
				start = num; // 다음 for문에서는 5부터
			}else if(stack.peek() != num) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append("-").append("\n");
		}
		
		System.out.println(sb);
		
	}

}