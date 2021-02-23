package Days;

import java.util.*;
import java.io.File;
public class Day8_1 {
public static void main(String[] args) throws Exception{
	
	File file = new File("C:\\Users\\user\\Desktop\\Test\\AdventOfCode\\src\\input");

	Scanner scan = new Scanner(file);
	
	int accumulator = 0;
	String[][] comms = new String[643][2];
	boolean[] vis = new boolean[643];
	Arrays.fill(vis, Boolean.FALSE);
	int cont = 0;

	while(scan.hasNextLine()){
		comms[cont] = scan.nextLine().split(" ");
		cont++;
	}


	int pos = 0;
	boolean test = true;
	while(test){

		String action = comms[pos][0];
		vis[pos] = true;
		
		switch(action){
			case "acc":
			accumulator += Integer.parseInt(comms[pos][1]);
			pos++;
			if(vis[pos]==true)
				test = false;
			break;
			case "jmp":
			pos += Integer.parseInt(comms[pos][1]);
			if(vis[pos]==true)
				test = false;
			break;
			case "nop":
			pos++;
		}

	}
	System.out.println(accumulator);
	
	
}

}
