import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	ArrayList<Integer> list = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    	Collections.sort(list);
    	while(true){
    		if(!(list.get(2) < list.get(1) + list.get(0))){
    			int x = list.get(2) - 1;
    			list.set(2, x);
    		}else{
    			int result = list.stream().mapToInt(Integer::intValue).sum();
    			System.out.println(result);
    			break;
    		}
    	}
    }
}