import java.io.File;
import java.util.*;
import java.util.Scanner;
public class Day20_1 {
    public static void main(String[] args) throws Exception {
        File file = new File("//home//david//eclipse-workspace//AdventOfCode1//src//example");
        Scanner scan = new Scanner(file);
        HashMap<Integer,String[]> imageArray = new HashMap<>();

        boolean inTile = false;
        String tileImage = "";
        int tileNum = 0;
        //parsing the tiles and storing the sides of them.
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            if(line.startsWith("Tile")){
                tileNum = Integer.parseInt(line.split(" ")[1].replace(":",""));
                inTile = true;
            }else if(inTile == true){
                tileImage += line + "\n";
            }
            if(line.equals("") && inTile == true){
                String[] arr = tileImage.split("\n");
                String left = "";
                String right = "";
                for(int i = 0; i < arr.length;i++){
                    left += arr[i].charAt(0);
                    right += arr[i].charAt(9);
                }
                String[] tileSides = {arr[0],arr[9],left,right};
                imageArray.put(tileNum,tileSides);
                inTile = false;
                tileImage = "";

            }
        }

        long ans = 1;
        for(Integer ids : imageArray.keySet()) {
            int count = 0;
            for (Integer id : imageArray.keySet()) {
                if (ids != id) {
                    String[] tile1 = imageArray.get(id);
                    String[] tile2 = imageArray.get(ids);
                    if (check(tile1, tile2))
                        count++;
                }
            }
            if(count == 2){
                ans *= ids;
            }
        }

        System.out.println(ans);


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
                if(tile1[i].equals(tile2[j]) || tile1[j].equals(reverse(tile2[j])) || reverse(tile1[i]).equals(tile2[j]) || reverse(tile1[i]).equals(reverse(tile2[j]))){
                    return true;
                }
            }
        }
        return false;
    }
}