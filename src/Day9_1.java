import java.util.*;
import java.io.File;

public class Day9_1 {
public static void main(String[] args) throws Exception{
    File file = new File("C:\\Users\\user\\Desktop\\Test\\AdventOfCode\\src\\input");
    Scanner scan = new Scanner(file);
    
    int size = 1000; 
    int start = 0;
    int end = 24;
    
    Long[] arr = new Long[size];
    int cont = 0;
    HashSet<Long> sums = new HashSet<>();
    
    while(scan.hasNextLine()){
        Long num = Long.parseLong(scan.nextLine());

        arr[cont] = num;
        if(cont <= end)
        sums.add(num);
        cont++;
    }
    
    
    boolean test = true;
    
    while(test == true){

        boolean found = false;
        Long target = arr[end+1];
        

        for(int i = start; i <= end; i++){

        
            if (sums.contains(target-arr[i]) && target-arr[i]!=arr[i]){                
                end++;
                sums.remove(arr[start]);
                sums.add(arr[end]);
                start++;
                found = true;                
                break;    

            }
        
        }
        if (found == false){
            test = false;     
        }          

    }
    System.out.println(arr[end+1]);

    



}    
}
