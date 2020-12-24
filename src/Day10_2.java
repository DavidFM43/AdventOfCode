/*

*/
import java.util.*;
import java.io.File;

public class Day10_2 {
    public static void main(String[] args) throws Exception{

        File file = new File("C:\\Users\\user\\Desktop\\Test\\AdventOfCode\\src\\input");
        Scanner scan = new Scanner(file);
        
        int size = 92;
        TreeSet<Integer> adapters = new TreeSet<>();
        int[] diffs = new int[size + 1];

        int joltage = 0;
        int onedif = 0;
        int threedif = 0;
        int cont = 0; 

        while(scan.hasNext()){
            int num = Integer.parseInt(scan.nextLine());
            adapters.add(num);    
       }

        int highest = adapters.last() + 3;

        while(!adapters.isEmpty()){

            int adapter = adapters.first();
            int dif = adapter - joltage;
            diffs[cont] = dif; 

            if (dif == 1)
                onedif++;
            else
                threedif++;

            joltage = adapter;
            adapters.remove(adapter);
            cont++;
        }
        diffs[cont] = highest - joltage;
            
        
        int cons = 0;
        int cont2 = 0;
        List<Integer> results = new ArrayList<>();
        while(cont2<diffs.length){
            cons = 0;
            while(diffs[cont2] == 1){
                    cons++;
                    cont2++;
            }
            if (cons > 1)
                results.add(cons-1);
            cont2++;
            }

    long ans = 1;
    for(Integer num: results){
       if (num > 1){
            ans *= 1 + factorial(num)/(factorial(num-1)*factorial(1)) + factorial(num)/(factorial(num-2)*factorial(2));
       }else{
            ans *= 1 + factorial(num)/(factorial(num-1)*factorial(1));
       }
    }
    System.out.println(ans);
    

}
public static long factorial(int number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }
}