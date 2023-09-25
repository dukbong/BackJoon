import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
    	/*
    		Equilateral :  세 변의 길이가 모두 같은 경우
			Isosceles : 두 변의 길이만 같은 경우
			Scalene : 세 변의 길이가 모두 다른 경우
			Invalid : 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 
		*/
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	while(true){
    		ArrayList<Integer> list = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    		Collections.sort(list);
    		HashSet<Integer> set = new HashSet<>(list);
    		
    		for(int i : set){
    			if(i == 0) {
    				return;
    			}
    		}
    		if(!(list.get(2) < list.get(1) + list.get(0))){
    			System.out.println("Invalid");
    			continue;
    		}
    		if(set.size() == 1){
    			System.out.println("Equilateral");
    		}else if(set.size() == 2){
    			System.out.println("Isosceles");
    		}else{
    			System.out.println("Scalene");
    		}
    	}
    }
}