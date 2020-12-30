import java.util.*;
import java.io.File;
public class Day14_1{
    public static void main(String[] args)throws Exception{
    File file = new File("//home//david//eclipse-workspace//AdventOfCode1//src//input");
    Scanner scan = new Scanner(file);
    HashMap<Integer,Long> modified = new HashMap<>();
    char[] mask = new char[36];
    long ans = 0;
    while(scan.hasNextLine()){
        String[] input = scan.nextLine().replace(" =","").split(" ");
        if(input[0].compareTo("mask") == 0){
             mask = input[1].toCharArray();            
        }else{
            int[] bin = new int[36];
            int address = Integer.parseInt(input[0].replace("mem[","").replace("]","")); 
            int decimal = Integer.parseInt(input[1]);
            char[] binary = Integer.toBinaryString(decimal).toCharArray();
            binary = reversed(binary);

            for(int i = bin.length-1; i >= 0; i--){
                if(mask[i] != 'X') {
                    bin[i] = mask[i] - '0';
                }
                else if(35 - i< binary.length) {
                    bin[i] = binary[35 - i] - '0';
                }
            }
            modified.put(address,toDec(bin));
        }
    }
    for(Long value : modified.values()) {
        ans += value;
    }
   System.out.println(ans);

}
    public static int toDec(char[] binary){
        int decimal = 0;
        int cont = 0;
        for(int i = binary.length-1; i >= 0; i--){
            decimal += Character.getNumericValue(binary[i])*Math.pow(2,cont);
            cont++;
        }
        return decimal;
    }
public static long toDec(int[] binary){
    long decimal = 0;
    int cont = 0;
    for(int i = binary.length-1; i >= 0; i--){
        decimal += binary[i]*Math.pow(2,cont);
        cont++;
    }
    return decimal;
    }
public static char[] reversed(char[] arr){
        char[] newArray = new char[arr.length];
        for(int i = 0; i < arr.length; i++){
            newArray[i] = arr[arr.length-1-i];
        }
        return newArray;
}
}
