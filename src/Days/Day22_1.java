package Days;

import java.io.File;
import java.util.*;
public class Day22_1 {
    public static void main(String[] args) throws Exception {
        File file = new File("//home//david//eclipse-workspace//AdventOfCode1//src//input");
        Scanner scan = new Scanner(file);
        Queue<Integer> p1 = new LinkedList<>();
        Queue<Integer> p2 = new LinkedList<>();

        boolean inP1 = true;

        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(!line.contains("Player")){
                if(line.length() == 0)
                    inP1 = false;
                else {
                    Integer num = Integer.parseInt(line);
                    if (inP1) {
                        p1.add(num);
                    } else {
                        p2.add(num);
                    }
                }

            }
        }

        boolean p1Winner = false;

        while(!p1.isEmpty() && !p2.isEmpty()){
            if(p1.peek() > p2.peek())
                p1Winner = true;
            else
                p1Winner = false;
            if(p1Winner) {
                p1.add(p1.remove());
                p1.add(p2.remove());
            }else{
                p2.add(p2.remove());
                p2.add(p1.remove());
            }
        }
        System.out.println(p1);
        System.out.println(p2);

        Stack<Integer> reversed = new Stack<>();;
        Queue<Integer> selected = new LinkedList<>();
        selected = (p1.isEmpty())?p2:p1;
        int ans = 0;

        for(Integer num:selected){
            reversed.push(num);
        }
        for(int i = 0; i < selected.size();i++){
            ans += reversed.pop()*(i+1);
        }
        System.out.println(ans);
    }
}
