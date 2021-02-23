package Days;

import java.util.*;



import java.io.File;
public class Day8_2 {
public static void main(String[] args) throws Exception{
	int inle = 643;
	File file = new File("C:\\Users\\user\\Desktop\\Test\\AdventOfCode\\src\\input");

	Scanner scan = new Scanner(file);
	

	String[][] comms = new String[inle][2];
	
	int cont = 0;
	while(scan.hasNextLine()){
		comms[cont] = scan.nextLine().split(" ");
		cont++;
	}
	

	for(int i = 0; i < comms.length;i++){
		if (comms[i][0].compareTo("jmp") == 0){
			comms[i][0] = "nop";
			int[] result = lap(comms);

			
			if (result[0] == 0){
				System.out.println(result[1]);
				break;
			}else{
				comms[i][0] = "jmp";
			}			
		}

		else if (comms[i][0].compareTo("nop") == 0){
			comms[i][0] = "jmp";
			int[] result = lap(comms);

			if (result[0] == 0){
				System.out.println(result[1]);
				break;			
			}else{
				comms[i][0] = "nop";
			}	
		}

	}
	
}

public static int[] lap(String[][] comms){
	int inle = 643;
	int accumulator = 0;
	boolean[] vis = new boolean[inle];
	Arrays.fill(vis, Boolean.FALSE);
	int pos = 0;
	int test = 0;
	
	while(test == 0){
		
		String action = comms[pos][0];
		
		vis[pos] = true;
		
		switch(action){
			
			case "acc":
			accumulator += Integer.parseInt(comms[pos][1]);
			pos++;
			break;
			
			case "jmp":			
			pos += Integer.parseInt(comms[pos][1]);
			break;
			
			case "nop":
			pos++;
			break;
		}
		if(pos >= inle)
			break;
		else if (vis[pos] == true)
				test = 1;
		
	}
	return new int[]{test,accumulator};
}
}
