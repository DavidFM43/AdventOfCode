import java.util.*;
public class Day2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ans = 0;
		
		for(int j = 0; j<1000;j++){
			String s = scan.nextLine();
				int guion;
				int x;
				int y;
				int z;
				int inicio;
				
				if(s.charAt(2)=='-') {
					 x = Integer.parseInt(s.substring(0,2));
					 guion = 2;
				}else {
					 x =s.charAt(0) - '0';
					 guion = 1;
				}
				if(s.charAt(guion+2)==' ') {
					 y = s.charAt(2) - '0';
					 z = s.charAt(guion+3);
						inicio = guion+6;

					 
				}else {
					 y = Integer.parseInt(s.substring(guion+1,guion+3));
					 z = s.charAt(guion+4);
						inicio = guion+7;

				}
				x--;
				y--;
				
				
				
				
				if (s.charAt(inicio+x)==z || s.charAt(inicio+y)==z)
					if (s.charAt(inicio+x)==z && s.charAt(inicio+y)==z) {}
					else
						ans++;
				
					
		}
		
		System.out.println(ans);
		

		
		
	}
}
