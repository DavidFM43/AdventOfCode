package Days;

import java.util.*;
import java.io.File;
public class Day14_2{
    public static void main(String[] args)throws Exception{
        File file = new File("//home//david//eclipse-workspace//AdventOfCode1//src//input");
        Scanner scan = new Scanner(file);
        HashMap<Long,Long> modified = new HashMap<>();
        long ans = 0;
        char[] mask = new char[36];

        while(scan.hasNextLine()){
            String[] input = scan.nextLine().replace(" =","").split(" ");
            if(input[0].compareTo("mask") == 0){
                mask = input[1].toCharArray();
            }else{
                char[] bin = new char[36];
                Arrays.fill(bin,'0');
                Long value = (long) Integer.parseInt(input[1]);
                int address = Integer.parseInt(input[0].replace("mem[","").replace("]",""));
                char[] binary = Integer.toBinaryString(address).toCharArray();  //Binary ahora es la direccion.
                binary = reversed(binary);
                for(int i = bin.length-1; i >= 0; i--){
                    if(mask[i] == 'X') {
                        bin[i] = 'X';
                    }else if(mask[i] == '1'){
                        bin[i] = '1';
                    }
                    else if(35 - i< binary.length) {
                        bin[i] = binary[35 - i];
                    }
                }
                HashSet<Long> temp = dirs(bin);
                System.out.println(temp);
                for(Long num : temp){
                   modified.put(num,value);
                }
            }

        }

        for(Long x : modified.keySet()){
            ans += modified.get(x);
        }
        System.out.println(ans);
    }

    public static long toDec(char[] binary){
        long decimal = 0;
        int cont = 0;
        for(int i = binary.length-1; i >= 0; i--){
            decimal += Character.getNumericValue(binary[i])*Math.pow(2,cont);
            cont++;
        }
        return decimal;
    }
   public static char[] reversed(char[] arr) {
        char[] newArray = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[arr.length - 1 - i];
        }
        return newArray;
    }
    public static HashSet<Long> dirs(char[] uaddress){
        HashSet<Long> ads = new HashSet<>();
        int numx = 0;
        for(int i = uaddress.length-1;i >= 0; i--){
            if (uaddress[i] == 'X'){
                char[] one = clone(uaddress);
                one[i] = '1';
                char[] zero = clone(uaddress);
                zero[i] = '0';
                ads.addAll(dirs(one));
                ads.addAll(dirs(zero));
                numx++;
                break;
            }
        }
        if(numx == 0){
            ads.add( toDec(uaddress));
        }
        return ads;
    }


    public static char[] clone(char[] arr) {
        char[] clone = new char[arr.length];
        System.arraycopy(arr, 0, clone, 0, arr.length);
        return clone;
    }
}
