import java.util.*;
import java.io.File;
public class Day15_1 {
    public static void main(String[] args)throws Exception {
        File file = new File("//home//david//eclipse-workspace//AdventOfCode1//src//input");
        Scanner scan = new Scanner(file);
        HashMap<Integer, LinkedList<Integer>> position = new HashMap<>();
        String[] initial = scan.nextLine().split(",");
        for(int i = 0; i < initial.length; i++){
            LinkedList<Integer> indexes = new LinkedList<Integer>();
            indexes.addFirst(i+1);
            position.put(Integer.parseInt(initial[i]),indexes);
        }
        int currentIndex = initial.length+1;
        int lastNum = Integer.parseInt(initial[initial.length-1]);
        
        while(currentIndex < 30000001){
          if(position.get(lastNum).size() == 1){
               lastNum = 0;
               if(position.get(0) == null){
                    LinkedList<Integer> temp1 = new LinkedList<Integer>();
                    temp1.addLast(currentIndex);
                    position.put(0, temp1);
               }else{
                    LinkedList<Integer> temp2 = position.get(0);
                    if(temp2.size() == 2){
                        temp2.removeFirst();
                    }
                    temp2.addLast(currentIndex);
                    position.put(0,temp2);
               }
            }else{
                LinkedList<Integer> temp3 = position.get(lastNum);
                lastNum = temp3.getLast() - temp3.getFirst();
                if(position.get(lastNum) == null){
                    LinkedList<Integer> temp4 = new LinkedList<Integer>();
                    temp4.addLast(currentIndex);
                    position.put(lastNum,temp4);
                }else{
                    LinkedList<Integer> temp5 = position.get(lastNum);
                    if(temp5.size() == 2 )
                        temp5.removeFirst();
                    temp5.addLast(currentIndex);
                    position.put(lastNum,temp5);
                } 
            }
           currentIndex++;
        }
            System.out.println(lastNum);
    
}

}

