import java.util.*;
import java.io.File;
public class Day16_2{
    public static void main(String[] args)throws Exception {
        File file = new File("//home//david//eclipse-workspace//AdventOfCode1//src//input");
        Scanner scan = new Scanner(file);
        int cont = 0; 
        int[][] ranges = new int[40][2];
        HashSet<Integer> invalid = new HashSet<Integer>();
         
        for(int i = 0; i < 20 ; i++ ){
            String line = scan.nextLine();
            String[] first = line.split(":")[1].split("or")[0].trim().split("-");
            String[] second = line.split(":")[1].split("or")[1].trim().split("-");
            ranges[cont][0] = Integer.parseInt(first[0]);
            ranges[cont][1] = Integer.parseInt(first[1]);
            cont++;
            ranges[cont][0] = Integer.parseInt(second[0]);
            ranges[cont][1] = Integer.parseInt(second[1]);
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
                    if (Integer.parseInt(ticket[j]) >= ranges[i][0] && Integer.parseInt(ticket[j]) <= ranges[i][1]){
                       valid = true;
                       break;
                }
            }
            if(valid == false){
                validTicket = false;
                break;

        }
    }
    if(validTicket == true) 
        stringTickets += stringTicket+" ";
}
    String[] tickets = stringTickets.split(" ");
    //Aqui realmente solo debo de checkear los primeros 12 rangos 
    for(int i = 0; i < tickets.length;i++){
        for(String ticket: tickets){
            int value = Integer.parseInt(ticket.split(",")[i]);        
        }
    
    }
}
}
