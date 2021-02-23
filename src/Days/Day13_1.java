package Days;

import java.util.*;
import java.io.File;

public class Day13_1{
    public static void main(String[] args)throws Exception{
    File file = new File("//home//david//eclipse-workspace//AdventOfCode//src//input");
    Scanner scan = new Scanner(file);
    scan.nextLine();
    HashMap<Long,Long> map = new HashMap<>();
    TreeSet<Long> ordered = new TreeSet<>();
    TreeSet<Long> reversed = new TreeSet<>();
    String[] nums = scan.nextLine().split(",");

    for(int i = 0; i < nums.length;i++){
        if (nums[i].compareTo("x") != 0) {
            int num = Integer.parseInt(nums[i]);
            ordered.add((long)num);
            map.put((long)num,modulus(-i,num));
        }
    }

    reversed = (TreeSet<Long>) ordered.descendingSet();
        Iterator it = reversed.iterator();
        Long dif = (Long) it.next();     // 5
        long term = map.get(dif);       // 4
        while(it.hasNext()){
            Long num = (Long) it.next();
            while(term %  num != map.get(num)){
                term += dif;
            }
            dif *= num;
        }

        System.out.println(term);
        //918753708
        //INT THRESHOLD: 2147483647
        //7736280437
        //100000000000000
        //807435693182510
        //9223372036854775807

}
public static long modulus(int x, int y){
       long r = x%y;
       if (r<0)
           r+=y;
       return r;
}

}
