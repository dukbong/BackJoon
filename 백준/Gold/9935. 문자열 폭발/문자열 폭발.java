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
		Character[] q = br.readLine().chars().mapToObj(c -> (char)c).toArray(Character[]::new);
		int qLen = q.length;
		Character[] bomb =  br.readLine().chars().mapToObj(c -> (char)c).toArray(Character[]::new);
		int bombLen = bomb.length;
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < qLen; i++){
			
			stack.push(q[i]);
			int count = 0;
			
			if(stack.size() >= bombLen){
				
				for(int j = 0; j < bombLen; j++){
					
					if(stack.get(stack.size() - bombLen + j) == bomb[j]){
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
