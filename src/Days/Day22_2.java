package Days;

import java.io.File;
import java.util.*;

//TODO: El runtime es muy pobre, necesito optimizar la recursion.

public class Day22_2 {
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

        HashSet<Queue<Integer>> previous = new HashSet<>();
        int answer = game(p1,p2,previous)[1];
        System.out.println(answer);
    }

    public static int[] game(Queue<Integer> p1, Queue<Integer> p2, HashSet<Queue<Integer>> previous){

        Queue<Integer> selected = new LinkedList<>();

       while(!p1.isEmpty() && !p2.isEmpty()) {

           Queue<Integer> copy = new LinkedList<>();
           copy.clear();
           copy.addAll(p1);
           copy.add(-1);
           copy.addAll(p2);

           if (previous.contains(copy)) {

                selected = p1;
                break;

           } else {

               previous.add(copy);

               Integer p1top = p1.poll();
               Integer p2top = p2.poll();

               if (p1.size()  < p1top || p2.size()  < p2top) {

                   boolean p1Winner = (p1top > p2top) ? true : false;

                   if (p1Winner) {
                       p1.add(p1top);
                       p1.add(p2top);
                   } else {
                       p2.add(p2top);
                       p2.add(p1top);
                   }


               } else {

                   Queue<Integer> p1clone = new LinkedList<>();
                   p1clone.addAll(p1);
                   Queue<Integer> p2clone = new LinkedList<>();
                   p2clone.addAll(p2);

                   Queue<Integer> newp1 = new LinkedList<>();

                   for(int i = 0; i < p1top;i++){
                       newp1.add(p1clone.remove());
                   }
                   Queue<Integer> newp2 = new LinkedList<>();

                   for(int i = 0; i < p2top;i++){
                       newp2.add(p2clone.remove());
                   }

                   int winner = game(newp1,newp2,new HashSet<Queue<Integer>>())[0];

                   if (winner == 0) {
                       p1.add(p1top);
                       p1.add(p2top);
                   } else {
                       p2.add(p2top);
                       p2.add(p1top);
                   }

               }
           }

       }

        if(selected.isEmpty()) {
            selected = (p1.isEmpty()) ? p2 : p1;
        }

        // 1 means p2 won.
        int winner = (selected.equals(p1)) ? 0 : 1;

        int ans = 0;

        Stack<Integer> reversed = new Stack<>();;

        for(Integer num:selected){
            reversed.push(num);
        }
        for(int i = 0; i < selected.size();i++){
            ans += reversed.pop()*(i+1);
        }
       return new int[]{winner, ans};

    }
}
