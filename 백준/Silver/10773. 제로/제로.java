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
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        for(int i = 0; i < n; i++) {
        	int num = Integer.parseInt(br.readLine());
        	if(num != 0) {
        		stack.push(num);
        	}else {
        		stack.pop();
        	}
        }
        if(stack.size() != 0) {
        	result = stack.stream().reduce((acc, cur) -> acc + cur).get();
        }else {
        	result = 0;
        }
        System.out.println(result);
    }
}