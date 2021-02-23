package Days;

import java.util.*;



import java.io.File;

public class Day10_1 {
    public static void main(String[] args) throws Exception{

        File file = new File("C:\\Users\\user\\Desktop\\Test\\AdventOfCode\\src\\input");
        Scanner scan = new Scanner(file);
        
        int size= 92;
        TreeSet<Integer> adapters = new TreeSet<>();
        int joltage = 0;
        int onedif = 0;
        int threedif = 0;

        while(scan.hasNext()){
            int num = Integer.parseInt(scan.nextLine());
            adapters.add(num);    
        }

        int highest = adapters.last()+3;
        while(!adapters.isEmpty()){
            int adapter = adapters.first();
            int dif = adapter - joltage;
            if (dif == 1)
                onedif++;
            else
                threedif++;
            joltage = adapter;
            adapters.remove(adapter);
        }
        if(highest-joltage==1)
            onedif++;
        else
            threedif++;


        System.out.println(onedif*threedif);

    
    }
}
