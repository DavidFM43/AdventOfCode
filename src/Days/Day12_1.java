package Days;

import java.util.*;
import java.io.File;
public class Day12_1 {
	public static void main(String[] args) throws Exception{
		File file = new File("//home//david//eclipse-workspace//AdventOfCode//src//input");
        Scanner scan = new Scanner(file);   
        int x = 0;
        int y = 0;
        char dir = 'E';
        int angle = 0;
        while(scan.hasNextLine()){
            String ins = scan.nextLine();
            char act =  ins.charAt(0);
            int num = Integer.parseInt(ins.substring(1,ins.length()));
            if(act == 'F'){
               int [] coor =  move(x,y,dir,num);
               x  = coor[0];
               y  = coor[1];
                
            }
            else if(act == 'R'){
                angle = modulus(angle-num,360);
                dir = dir(angle);
            }
            else if(act == 'L'){
                angle = modulus(angle+num,360);
                dir = dir(angle);
            }
            else{
                int[] coor = move(x,y,act,num);
                x = coor[0];
                y = coor[1];
            }
       }
       System.out.println(Math.abs(x)+Math.abs(y));
    
    
        
	}
    public static char dir(int angle){
        if(angle == 0)
            return 'E';
        else if(angle == 90)
            return 'N';
        else if(angle == 180)
            return 'W';
        else if(angle == 270)
            return 'S';
        return 'M';
    }
    public static int modulus(int x, int y){
        int r = x%y;
        if(r<0)
            r+=y;
        return r;
    }
    public static int[] move(int x, int y, char action,int num){
        int[] coor = new int[2];
        coor[0] = x;
        coor[1] = y;
        switch(action){
            case 'N':
                coor[1] += num;
                break;
            case 'S':
                coor[1] -= num;
                break;
            case 'E':
                coor[0] += num;
                break;
            case 'W':
                coor[0] -= num;
                break;
        } 
        return coor;
    }
}
