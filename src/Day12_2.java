import java.util.*;
import java.io.File;
public class Day12_2{
	public static void main(String[] args) throws Exception{
		File file = new File("//home//david//eclipse-workspace//AdventOfCode//src//input");
        Scanner scan = new Scanner(file);   
        int wx = 10;
        int wy = 1;
        int x = 0;
        int y = 0;
        while(scan.hasNextLine()){
            String ins = scan.nextLine();
            char act =  ins.charAt(0);
            int num = Integer.parseInt(ins.substring(1,ins.length()));
            if(act == 'F'){
                //move the waypoint vertically 
                if(wy >= 0){
                    int [] coor =  moveWaypoint(x,y,'N',wy*num);
                    y = coor[1];
                }else if(wy < 0){
                    int [] coor =  moveWaypoint(x,y,'S',Math.abs(wy)*num);
                    y = coor[1];
                }
                //move th waypoiny horizontally
                if(wx >= 0){
                    int [] coor = moveWaypoint(x,y,'E',wx*num);
                    x = coor[0];
                }else{
                    int [] coor = moveWaypoint(x,y,'W',Math.abs(wx)*num);
                    x = coor[0];
                }
                
            }
            else if(act == 'R'){
                if(num == 90){
                    int aux = wx;
                    wx = wy;
                    wy = -1*aux;
                }else if(num == 180){
                    wx = -1*wx;
                    wy = -1*wy;
                }else if (num == 270){
                    int aux = wx;
                    wx = -1*wy;
                    wy = aux;
                }
            }
             else if(act == 'L'){
                if(num == 90){
                    int aux = wx;
                    wx = -1*wy;
                    wy = aux;
                }else if (num == 180){
                    wx = -1*wx;
                    wy = -1*wy;
                }else if( num == 270){
                    int aux = wx;
                    wx = wy;
                    wy = -1*aux;
                }
             }
            else{
                int[] coor = moveWaypoint(wx,wy,act,num);
                wx = coor[0];
                wy = coor[1];
            }


       }
    System.out.println(Math.abs(x)+Math.abs(y));           
    
        
	}
   public static int modulus(int x, int y){
        int r = x%y;
        if(r<0)
            r+=y;
        return r;
    }
    public static int[] moveWaypoint(int x, int y, char action,int num){
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
