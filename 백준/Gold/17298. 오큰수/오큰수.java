import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
	
    public static void main(String[] args) throws IOException{
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int qSize = Integer.parseInt(br.readLine());
        int[] inputArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < qSize; i++){
            while(!stack.isEmpty() && inputArr[stack.peek()] < inputArr[i]){
                inputArr[stack.pop()] = inputArr[i];
            }
            stack.add(i);
        }

        while(!stack.isEmpty()){ // 없는 경우는 stack에 남아있다.
            inputArr[stack.pop()] = -1;
        }
        
        for(int i = 0; i < qSize; i++){
            sb.append(inputArr[i]).append(" ");
        }
        
        System.out.println(sb);
    }
}
