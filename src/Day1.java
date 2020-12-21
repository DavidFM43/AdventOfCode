import java.util.*;
public class Day1 {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	Set<Integer> set = new HashSet<>();
	int[] nums = new int[200];
	int cont = 0;
	
	while(true) {
		String s = scan.nextLine();
		if(s.length() != 0) { 
			
			int x = Integer.parseInt(s);
			nums[cont] = x;
			set.add(x);
			cont++;
		}else 
			break;	
	}
    
	for (int i = 0; i <nums.length-1;i++) {
		for(int j = i+1; j <nums.length;j++) {
			int z =  nums[i]+nums[j];
			if (set.contains(2020-z)) { 
				System.out.println(nums[i]*nums[j]*(2020-z));
				break;
			}
		}
	}

	
}
}
