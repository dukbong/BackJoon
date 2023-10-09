import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
        new Main().solution();
    }
    
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] innerNum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < num; i++){
            queue.add(new int[] {i + 1, innerNum[i]});
        }
        
        sb.append(1).append(" ");
        int move = queue.poll()[1];
        
        while(!queue.isEmpty()) {
			if(move >0) {
				for(int i=1; i<move; i++) {
					queue.add(queue.poll());
				}
				int[] arr = queue.poll();
				move = arr[1];
				sb.append(arr[0]).append(" ");
			}
			else {
				for(int i=1; i<Math.abs(move); i++	) {
					queue.addFirst(queue.removeLast());
				}
				int[] arr = queue.removeLast();
				move = arr[1];
				sb.append(arr[0]).append(" ");
			}
		}
        System.out.println(sb.toString());
    }
}