import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] strArr = new String[arr[0]][];
       
        for(int i = 0; i < arr[0]; i++){
            strArr[i] = Arrays.stream(br.readLine().split("")).toArray(String[]::new);
        }
        
        ArrayList<String> bw = new ArrayList<>();
        ArrayList<String> wb = new ArrayList<>();
        
        String b = "BWBWBWBW";
        String w = "WBWBWBWB";
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for(int i = 1; i <= 8; i++) {
        	if(i % 2 != 0) {
        		sb1.append(b);
        		sb2.append(w);
        	}else {
        		sb1.append(w);
        		sb2.append(b);
        	}
        }
        
        for(int i = 0; i < 64; i++) {
        	bw.add(String.valueOf(sb1.toString().charAt(i)));
        	wb.add(String.valueOf(sb2.toString().charAt(i)));
        }
        
        // color
        ArrayList<Integer> checkList = new ArrayList<>();
        
        int x = arr[1]-8;
        int y = arr[0]-8;
        
        for(int i = 0; i <= y; i++){
             for(int j = 0; j <= x; j++){
                 int checkx = j;
                 int checky = i;
                 ArrayList<String> save = new ArrayList<>();
                 
                 for(int k = checky; k < checky + 8; k++){
                      for(int l = checkx; l < checkx +8; l++){
                           save.add(strArr[k][l]);
                      }
                 }
                 
                 int num1 = 0;
                 int num2 = 0;
                 
                 for(int k = 0; k < save.size(); k++){
                     if(!save.get(k).equals(bw.get(k))){
                         num1 ++;
                     }
                     if(!save.get(k).equals(wb.get(k))){
                         num2 ++;
                     }
                 }
                 
                 if(num1 > num2){
                     checkList.add(num2);
                 }else{
                     checkList.add(num1);
                 }
             }
        }
        Collections.sort(checkList);
        System.out.println(checkList.get(0));
    }
}