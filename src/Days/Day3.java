package Days;

import java.util.*;
public class Day3 {
public static void main(String[] args) {
	char[][] mapa = new char[323][31];
	Scanner scan = new Scanner(System.in);
	for(int i = 0; i < 323; i++) {
		String line = scan.nextLine();
		char[] chars = line.toCharArray();
		for(int j = 0; j < chars.length;j++) {
			mapa[i][j] = chars[j];
		}
	}
	
	long ans=1;
	int[][] slopes = {{1,1},{3,1},{5,1},{7,1},{1,2}};
	for (int z = 0; z < slopes.length;z++){
	int px = slopes[z][0];
	int py = slopes[z][1];
	int x = 0;
	int y = 0;
	int arboles = 0;
	while(y<323) {
		char pos = mapa[y][x];
		if (pos=='#') {
			arboles++;
		}
		x = (x + px)%31;
		y += py;
	}
	
	ans = ans*arboles;
	
	}
	System.out.println("Respuesta: "+ans);
	
	}
}
