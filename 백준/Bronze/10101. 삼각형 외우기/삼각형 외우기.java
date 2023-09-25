import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
    	/*
    		세 각의 크기가 모두 60이면, Equilateral
			세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
			세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
			세 각의 합이 180이 아닌 경우에는 Error
		*/
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int x = Integer.parseInt(br.readLine());
    	int y = Integer.parseInt(br.readLine());
    	int z = Integer.parseInt(br.readLine());
    	if(x + y + z != 180){
    		System.out.println("Error");
    		return;
    	}
    	
    	Set<Integer> set = new HashSet<>();
    	set.add(x);
    	set.add(y);
    	set.add(z);
    	if(set.size() == 1){
    		System.out.println("Equilateral");
    	}else if(set.size() == 2){
    		System.out.println("Isosceles");
    	}else{
    		System.out.println("Scalene");
    	}
    }
}