import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        Character[] arr = IntStream.rangeClosed('a', 'z')
        					  	   .mapToObj(c -> (char)c)
        					  	   .toArray(Character[]::new);
        
        int[] result = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
        	String check = String.valueOf(arr[i]);
        	if(input.contains(check)){
        		int index = input.indexOf(check);
        		result[i] = index;
        	}else{
        		result[i] = -1;
        	}
        }
        
        String[] str = Arrays.stream(result).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", str));
    }
}