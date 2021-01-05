import java.util.*;
import java.io.File;
public class Day16_2{
    public static void main(String[] args)throws Exception {
        File file = new File("//home//david//eclipse-workspace//AdventOfCode1//src//input");
        Scanner scan = new Scanner(file);
        int cont = 0; 
        int ans = 0;
        HashMap<Integer, HashSet<Integer> > map = new HashMap<>();
        int size = 20;
        int[][][] ranges = new int[size][2][2];
        for(int i = 0; i < size; i++ ){
            String line = scan.nextLine();
            int[] first = toIntArr(line.split(":")[1].split("or")[0].trim().split("-"));
            int[] second = toIntArr(line.split(":")[1].split("or")[1].trim().split("-"));
            ranges[cont][0] = first;
            ranges[cont][1] = second;
            cont++;
        }           
        for(int i = 0; i < 2; i++){
            scan.nextLine();
        }
        String myTicket = scan.nextLine();
        scan.nextLine();
        scan.nextLine();
        
        String stringTickets = "";

        while(scan.hasNextLine()){
            String stringTicket = scan.nextLine();
            String[] ticket = stringTicket.split(",");
            boolean validTicket = true;
            for(int j = 0; j < ticket.length;j++){
                boolean valid = false;
                for(int i = 0; i < ranges.length;i++){
                    if ((Integer.parseInt(ticket[j]) >= ranges[i][0][0] && Integer.parseInt(ticket[j]) <= ranges[i][0][1]) || (Integer.parseInt(ticket[j]) >= ranges[i][1][0] && Integer.parseInt(ticket[j]) <= ranges[i][1][1])){
                       valid = true;
                       break;
                }
            }
            if(valid == false){
                ans += Integer.parseInt(ticket[j]);
                validTicket = false;
                break;

        }
    }
    if(validTicket == true) 
        stringTickets += stringTicket+" ";
}
    String[] tickets = stringTickets.split(" ");
        //System.out.println(tickets.length);
    for(int i = 0; i < size; i++){
        int cont2 = 0;
    for(int j = 0; j < size; j++){
        int contador = 0;
    for(String cosa: tickets){                        
        int value = Integer.parseInt(cosa.split(",")[j]);
           // System.out.println(value+" first["+ranges[0][0][0]+", "+ranges[0][0][1]+"]"+" second["+ranges[0][1][0]+", "+ranges[0][1][1]+"]");
        if(value < ranges[i][0][0] || value > ranges[i][0][1]) {
            if(value < ranges[i][1][0] || value > ranges[i][1][1]){
        }else{
            contador++;
        }
        }else{
            contador++;
        }
    }
    if(contador == tickets.length)
        if(map.get(j) == null){
            HashSet<Integer> values = new HashSet<>();
            values.add(i); 
            map.put(j,values);
        }else{
            HashSet<Integer> values = map.get(j);
            values.add(i);
            map.put(j,values);

        }
        cont2++;
    }
            //System.out.println(cont2); 
            //System.out.println("first["+ranges[i][0][0]+", "+ranges[i][0][1]+"]"+" second["+ranges[i][1][0]+", "+ranges[i][1][1]+"]");
    }
    //la llave j califica para los campos que tiene en el HashMap. 
    HashMap<Integer,Integer> answer = new HashMap<Integer,Integer>();
    while(true){
        boolean test = true;
        for(int i = 0; i < size; i++){
            if(map.get(i).size() == 1){
                Iterator it = map.get(i).iterator();
                int num = (int) it.next();
                answer.put(num,i);
                map = update(map,num);
                test = false;
                break;
            }
        }
        if(test == true)
            break;
    }
   long res = 1;
        System.out.println(myTicket);
    for(int i = 0; i < 6; i++){
        res *= Integer.parseInt(myTicket.split(",")[answer.get(i)]);
            System.out.println("Key "+i+" value "+answer.get(i));
            
    }
    System.out.println(res);
    }
/*
for(Integer key:map.keySet()){
    System.out.println("Key: "+key+". Value: "+map.get(key));
}
*/
public static void print(HashMap<Integer, HashSet<Integer>> map){
     for(Integer key : map.keySet()){
            System.out.println("Key "+key+" Values: "+map.get(key));
    }
}
public static HashMap<Integer, HashSet<Integer>> update(HashMap<Integer, HashSet<Integer>> map, int value){
    for(Integer key : map.keySet()){
        HashSet<Integer> set = map.get(key);
        set.remove(value);
        map.put(key,set);
    }
    return map;
}
public static int[] toIntArr(String[] stringArr){
    int[] intArray = new int[stringArr.length];
    for(int i = 0; i < intArray.length;i++){
        intArray[i] = Integer.parseInt(stringArr[i]);
    }
    return intArray;
}
}
