package Days;

import java.util.*;
public class Day5 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	TreeSet<Integer> nums = new TreeSet<>(); 

	int h = 0;
	for(int x = 0; x < 901;x++) {
	
	String line = scan.nextLine();
	
	int row = 0;
	int column = 0;
	for(int i = 0; i < 7; i++) {
		int bin = (line.charAt(6-i) == 'B')?1:0;
		row += bin*(Math.pow(2, i));
		}
	for(int j = 0; j<3 ;j++) {
		int bin1 = (line.charAt(9-j) == 'R')?1:0;
		column += bin1*(Math.pow(2, j));
	}
	
	int ans = row*8+column;
	nums.add(ans);
	if (ans>h) {
		h=ans;
	}
	}
	while(true) {
		Integer x = nums.first();
		if (!nums.contains(x+1)) {
			System.out.println(x+1);
			break;
		}
		nums.remove(x);
	}

}
}
