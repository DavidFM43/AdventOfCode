import java.util.ArrayList;
import java.util.HashSet;

public class test {
    public static void main(String[] args){
        HashSet<ArrayList<Integer>> test = new HashSet<>();
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        test.add(testList);
        System.out.println(test);
        testList = new ArrayList<>();
        System.out.println(test);
        System.out.println(testList);
        testList.add(1);
        testList.add(2);
        testList.add(4);
        test.add(testList);
        System.out.println(test);
    }

    static String reverse(String arr){
        String out = "";
        for(int i = 0; i < arr.length(); i++){
            out += arr.charAt(arr.length()-1-i);
        }
        return out;
    }
    static boolean check(String[] tile1, String[] tile2){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4;j++){
                /*
                System.out.println(tile1[i]+" = "+tile2[i]);
                System.out.println(tile1[i]+" = "+reverse(tile2[i]));
                System.out.println("----------");
                 */
                if(tile1[i] == tile2[j] || tile1[j] == reverse(tile2[j]) || reverse(tile1[i]) == tile2[j] || reverse(tile1[i]) == reverse(tile2[j])){
                    return true;
                }
            }
        }
        return false;
    }
}
