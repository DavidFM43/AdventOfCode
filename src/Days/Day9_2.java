package Days;

import java.util.*;
import java.io.File;

public class Day9_2 {
public static void main(String[] args) throws Exception{

    File file = new File("C:\\Users\\user\\Desktop\\Test\\AdventOfCode\\src\\input");
    Scanner scan = new Scanner(file);

    int target = 36845998;

    int size = 1000;

    Long[] arr = new Long[size];
    TreeSet<Long> minmax  = new TreeSet<>();
    

    int cont = 0;

    int lrange = 0;
    int hrange = 1;
    
    while(scan.hasNextLine()){
        Long num = Long.parseLong(scan.nextLine());
        arr[cont] = num;
        cont++;
    }
    
    Long sum = arr[0];
    minmax.add(arr[0]);
    
    while(true){

        if(sum == target)
            break;

        else if (sum < target){
            sum += arr[hrange];
            minmax.add(arr[hrange]);
            hrange++;
        }
        else if(sum > target){
            sum -= arr[lrange];
            minmax.remove(arr[lrange]);
            lrange++;
        }
        
    }

    System.out.println(minmax.first() + minmax.last());


}
}
