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
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        while(true) {
        	String str = br.readLine();
        	if(str.equals(".")) {
        		break;
        	}
        	String result = checkQ(str, stack);
        	sb.append(result).append("\n");
        	stack.clear();
        }
        System.out.println(sb.toString());
    }
	private String checkQ(String str, Stack<Character> stack) {
		String replaceStr = str.replaceAll("[^()\\[\\]]+", "");
		if(replaceStr.length() == 0) {
			return "yes";
		}
		
		for(int i = 0; i < replaceStr.length(); i++) {
			char c = replaceStr.charAt(i);
			if(c == '(' || c == '[') {
				stack.push(c);
			}else if(stack.isEmpty()) {
				return "no";
			}else {
				char x = stack.peek();
				if(c == ')' && x == '(') {
					stack.pop();
				}else if(c == ']' && x == '[') {
					stack.pop();
				}else{
                    return "no";
                }
			}
		}
		if(stack.size() == 0) {
			return "yes";
		}
		return "no";
		
	}
}