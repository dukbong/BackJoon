import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 학생수와 커트라인
        int[] q = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 학생 점수
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i : s) {
        	list.add(i);
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() - q[1]));
    }
}