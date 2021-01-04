import java.util.*;
import java.io.File;
public class Day16{
    public static void main(String[] args)throws Exception {
        File file = new File("//home//david//eclipse-workspace//AdventOfCode1//src//input");
        Scanner scan = new Scanner(file);
        int cont = 0; 
        int[][] ranges = new int[6][2];
        int total = 0;
         
        for(int i = 0; i < 3 ; i++ ){
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

        while(scan.hasNextLine()){
            String[] tickets = scan.nextLine().split(",");
            for(int j = 0; j < tickets.length;j++){
                boolean valid = false;
                for(int i = 0; i < ranges.length;i++){
                    if (Integer.parseInt(tickets[j]) >= ranges[i][0] && Integer.parseInt(tickets[j]) <= ranges[i][1]){
                       valid = true; 
                       break;
                }
            }
            if(valid == false)
                total += Integer.parseInt(tickets[j]);
        }
    }
        System.out.println(total);
}
}
