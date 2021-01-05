import java.util.*;
import java.io.File;
public class Day16_2{
    public static void main(String[] args)throws Exception {
        File file = new File("C:\\Users\\user\\Desktop\\Test\\AdventOfCode\\src\\input");
        Scanner scan = new Scanner(file);
        int cont = 0; 
        int ans = 0;
        int[][][] ranges = new int[20][2][2];
        HashSet<Integer> invalid = new HashSet<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); 
        for(int i = 0; i < 20; i++ ){
            String line = scan.nextLine();
            int[] first = toIntArr(line.split(":")[1].split("or")[0].trim().split("-"));
            int[] second = toIntArr(line.split(":")[1].split("or")[1].trim().split("-"));
            ranges[cont][0] = first;
            ranges[cont][1] = second;
            cont++;
        }           

        for(int i = 0; i < 5; i++){
            scan.nextLine();
        }

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
    for(int j = 0; j < 20; j++){
        int contador = 0;
    for(String cosa: tickets){                        
        int value = Integer.parseInt(cosa.split(",")[j]);
        if(value < ranges[0][0][0] || value > ranges[0][0][1]) {
            System.out.println(value);
        }else if (value < ranges[0][1][0] || value > ranges[0][1][1]){
            System.out.println(value);
        }else{
            contador++;
        }
    }
    System.out.println("Campo: "+j+". Check:"+contador);
    }
/*
for(Integer key:map.keySet()){
    System.out.println("Key: "+key+". Value: "+map.get(key));
}
*/


}
public static int[] toIntArr(String[] stringArr){
    int[] intArray = new int[stringArr.length];
    for(int i = 0; i < intArray.length;i++){
        intArray[i] = Integer.parseInt(stringArr[i]);
    }
    return intArray;
}
}
