import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> start = new ArrayList<>();
        start.add(1);
        start.add(1);
        
        if(x < 2){
            System.out.println(x * 2);
        }else{
            for(int i = 0; i < x-2; i++){
                start = show(start, x);    
            }
            System.out.println(start.stream().reduce((acc, cur) -> acc + cur).get().intValue()* 2);
        }
    }
    private ArrayList<Integer> show(ArrayList<Integer> start, int x){
        ArrayList<Integer> middle = new ArrayList<>();
        for(int i = 1; i < start.size(); i++){
            int n = start.get(i) + start.get(i - 0);
            middle.add(n);
        }
        start.clear();
        start.add(1);
        start.addAll(middle);
        start.add(1);
        return start;
    }
}