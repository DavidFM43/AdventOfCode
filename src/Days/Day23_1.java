package Days;

import com.sun.source.tree.Tree;

import java.io.File;
import java.util.*;
class Node{
    int value;
    Node next = null;
    Node prev = null;
    Node(int value){
        this.value = value;
    }
    Node(){

    }

}

class CircList{
    int size;
    TreeSet<Integer> numbers = new TreeSet<>();
    HashMap<Integer, Node> indexes = new HashMap<>();

    Node head = new Node();
    Node tail = new Node();

    Node currentCup = new Node();
    Node destination = new Node();
    CircList(){
       size = 0;
       currentCup = head;
    }
    void add(int num){
        numbers.add(num);
        if(size == 0) {
            head.value = num;
            tail = head;
            tail.next = head;

            indexes.put(num,head);

        }else {
            tail.next = new Node(num);
            indexes.put(num, tail.next);
            tail = tail.next;
            tail.next = head;

        }
        size++;
    }
    int getCurrentCup(){
        return currentCup.value;
    }
    public String toString(){

       String out = "[" ;

       Node current = head;

       for(int i = 0; i < this.size ;i++){
          out += current.value+", ";
          current = current.next;
       }

       out = out.substring(0,out.length()-2)+"]";

       return out;
    }

    Node getDestination(int destination) {
        return this.indexes.get(destination);
    }

    void move(int numMoves){
        for(int i = 0; i < numMoves;i++) {
/*
            System.out.println(this.toString());
            System.out.println("CurrentCup:"+currentCup.value);

 */
            HashSet<Integer> triplet = new HashSet<>();

            //Los 3 numeros que se van a mover.
            Node fpick = currentCup.next;
            Node lpick = fpick.next.next;
            currentCup.next = lpick.next;

            triplet.add(fpick.value);
            triplet.add(fpick.next.value);
            triplet.add(lpick.value);

            //System.out.println("pick up:"+triplet);

            //Numero de destino
            int desNumber = currentCup.value - 1;

            while (true) {

                if (triplet.contains(desNumber)) {
                    desNumber--;
                } else if (!numbers.contains(desNumber)) {
                    desNumber = numbers.last();
                } else {
                    break;
                }

            }
            /*
            System.out.println("Destination:"+desNumber);
            System.out.println();

             */
            Node destination = getDestination(desNumber);

            Node temp = destination.next;

            destination.next = fpick;
            lpick.next = temp;

            currentCup = currentCup.next;

        }
    }
    long result(){

        Node oneStar = getDestination(1).next;
        Node twoStar = oneStar.next;

        long firstNum = oneStar.value;
        long secondNum = twoStar.value;

        return firstNum * secondNum;
    }

}
public class Day23_1 {
    public static void main(String[] args) {
        String configuration = "974618352";
        CircList game = new CircList();

        for(Character num: configuration.toCharArray()){
            game.add(Character.getNumericValue(num));
        }

        for(int i = 10; i< 1000001;i++){
            game.add(i);
        }

        game.move(10000000);
        System.out.println(game.result());
    }
}
