import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
	
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /*
        	1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
			2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
			3: 스택에 들어있는 정수의 개수를 출력한다.
			4: 스택이 비어있으면 1, 아니면 0을 출력한다.
			5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
        */
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	String str = br.readLine();
        	if(str.contains("1")) {
        		// 이때는 스택에 정수를 넣는 행위
        		String[] arr = str.split(" ");
        		int num = Integer.parseInt(arr[1]);
        		stack.push(num);
        	}else {
        		switch(str) {
        		case "2":
        			if(stack.isEmpty()) {
        				sb.append(-1).append("\n");
        			}else {
        				sb.append(stack.pop()).append("\n");
        			}
        			break;
        		case "3":
        			sb.append(stack.size()).append("\n");
        			break;
        		case "4":
        			if(stack.isEmpty()) {
        				sb.append(1).append("\n");
        			}else {
        				sb.append(0).append("\n");
        			}
        			break;
        		case "5":
        			if(stack.isEmpty()) {
        				sb.append(-1).append("\n");
        			}else {
        				sb.append(stack.get(stack.size() - 1)).append("\n");
        			}
        			break;
        		}
        	}
        }
        System.out.println(sb.toString());
    }
}