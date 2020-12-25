import java.util.*;


import java.io.File;
public class Day11 {
    public static void main(String[] args) throws Exception{
        int size = 91;
        File file = new File("C:\\Users\\user\\Desktop\\Test\\AdventOfCode\\src\\input");
        Scanner scan = new Scanner(file); 
        String firstLine = scan.nextLine();
        int cont = 2;
        char[][] seatLayout = new char[size+2][firstLine.length()+2];
        Arrays.fill(seatLayout[0], 'L');
        Arrays.fill(seatLayout[size+1], 'L');
        
        seatLayout[1][0] = 'L';
        seatLayout[1][firstLine.length()+1] = 'L';
        for(int z = 1; z < firstLine.length()+1;z++){
            seatLayout[1][z] = firstLine.charAt(z-1);
        }
        
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            seatLayout[cont][0] = 'L';
           for(int j = 1; j < firstLine.length()+1;j++){
                seatLayout[cont][j] = line.charAt(j-1);
           }
           seatLayout[cont][firstLine.length()+1] = 'L';
            cont++;
        } 
        
        
        
        while(true){
            System.out.println(same(seatLayout,newGen(seatLayout,size)));
            if(same(seatLayout,newGen(seatLayout, size)))
                break;
            seatLayout = newGen(seatLayout,size);
            }   
        System.out.println(count(seatLayout,size));

        
    
}
public static long count(char[][] arr, int size){
    long ans = 0;
    for(int i = 1; i < arr.length;i++){
        for(int j = 1; j < arr[0].length;j++){
            if(arr[i][j] == '#')
                ans++;
        }
    }
    return ans;
}
public static char[][] copy(char[][] arr){
    char[][] copy = new char[arr.length][arr[0].length];
    for(int i = 1; i < arr.length-1; i++){
        for(int j = 1; j < arr[0].length-1;j++){
            copy[i][j] = arr[i][j];
        }
    }
    return copy;
}
public static boolean same(char[][] a1, char[][] a2){
    for(int i = 0; i < a1.length; i++){
        for(int j = 0; j < a1.length;j++){
            if (a1[i][j] != a2[i][j])
            return false;
        }   
    }
    return true;
}
public static void print(char[][] arr){

    for(int i = 0; i < 93;i++){
        System.out.println(Arrays.toString(arr[i]));
    }
}
public static int occupied(char[][] arr,int y, int x , String dir){ 

    if((y < 0 || y >= arr.length) && (x < 0 || x >= arr[0].length))
            return 0;
    switch (dir) {
        case "LFT":
            if(arr[y][x-1] == 'L')
                return 0;            
            else if (arr[y][x-1] == '#')
                return 1;
            else
                occupied(arr, y, x-1, "LFT");
            break;
        case "RGT":
            if(arr[y][x+1] == 'L')
                return 1;
            else if (arr[y][x+1] == '#')
                return 0;
            else
                occupied(arr,y,x+1,"RGT");
                break;
        case "DWN":
            if(arr[y-1][x] == 'L')
                return 1;
            else if (arr[y-1][x] == '#')
                return 0;
            else
                occupied(arr, y-1, x, "DWN");
                break;
        case "UP":
            if(arr[y-1][x] == 'L')
                return 1;
            else if (arr[y-1][x] == '#')
                return 0;
            else
                occupied(arr, y-1, x, "DWN");
                break;
        case "UPL":
            if(arr[y-1][x] == 'L')
                return 1;
            else if (arr[y-1][x] == '#')
                return 0;
            else
                occupied(arr, y-1, x, "DWN");
                break;
        case "UPR":
            if(arr[y-1][x] == 'L')
                return 1;
            else if (arr[y-1][x] == '#')
                return 0;
            else
                occupied(arr, y-1, x, "DWN");
            break;
        case "DWL":
            if(arr[y-1][x] == 'L')
                return 1;
            else if (arr[y-1][x] == '#')
                return 0;
            else
                occupied(arr, y-1, x, "DWN");
            break;
        case "DWR":
           if(arr[y-1][x] == 'L')
                return 1;
            else if (arr[y-1][x] == '#')
                return 0;
            else
                occupied(arr, y-1, x, "DWN");
            break;
        return 0;
    }
}

public static char[][] newGen(char[][] seatLayout, int size){
    char[][] newLayout =  copy(seatLayout);
        for(int y = 1; y < size+1;y++){
            for(int x = 1; x < seatLayout[1].length-1;x++){
                int cont2 = 0;
               if(seatLayout[y+1][x] == '#')
                    cont2++;
                if(seatLayout[y+1][x+1] == '#')
                    cont2++;
                if(seatLayout[y+1][x-1] == '#')
                    cont2++;
                if(seatLayout[y][x+1] == '#')
                    cont2++;
                if(seatLayout[y][x-1] == '#')
                    cont2++;
                if(seatLayout[y-1][x] == '#')
                    cont2++;
                if(seatLayout[y-1][x+1] == '#')
                    cont2++;
                if(seatLayout[y-1][x-1] == '#')
                    cont2++;
            if(seatLayout[y][x]=='L' && cont2 == 0)
                newLayout [y][x] = '#';
            else if(seatLayout[y][x] == '#' && cont2 >= 4)
                newLayout [y][x] = 'L';
            } 
        }
        return newLayout;
    }
                

}
