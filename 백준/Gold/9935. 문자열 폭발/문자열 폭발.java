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
		String[] q = br.readLine().split("");
		int qLen = q.length;
		String[] bomb = br.readLine().split("");
		int bombLen = bomb.length;
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < qLen; i++){
			stack.push(q[i].charAt(0));
			 
			int count = 0;
			if(stack.size() >= bombLen){
				
				for(int j = 0; j < bombLen; j++){
					
					if(stack.get(stack.size() - bombLen + j) == bomb[j].charAt(0)){
						count++;
					}
					
					if(count == bombLen){
						for(int l = 0; l < bombLen; l++){
							stack.pop();
						}
					}
					
				}
			}
		}
		
		if(stack.isEmpty()){
			System.out.println("FRULA");
		}else{
			for(char c : stack){
				sb.append(c);
			}
			System.out.println(sb);
		}
		
	}
}
