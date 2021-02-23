package Days;/*
 * find 2 nums whose sum is 2020. Then multiply them. 
 */
import java.util.*;
public class Day1_1 {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int[] arr = new int[200];
	int cont = 0;
	for(int i = 0; i < 200; i++) {
		arr[cont] = scan.nextInt();
		cont++;
	}

	scan.close();
		
	for(int j = 0; j< arr.length;j++) {
	
	for(int i = j; i < arr.length-1;i++) {
		
			if (arr[i]+arr[j]==2020)
				System.out.println(arr[i]*arr[j]);
		}
	}
	
}

}

