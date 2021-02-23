package Days;

import java.util.*;
import java.io.*;

public class Day6 {
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	Set<Character> s2 = new HashSet<>();
	Set<Character> s1 = new HashSet<>();
	
	int totalAnswers = 0;
	boolean newGroup= true;
	
	for(int i = 0; i< 2062;i++) {
		
		s2.clear();
		String line = scan.nextLine();
		
		if(line.isEmpty()) {
			
			totalAnswers += s1.size();
			s1.clear();
			newGroup = true;
		}
		
		
		else {
			for(int j = 0; j < line.length();j++) 
				s2.add(line.charAt(j));
			
			if(s1.isEmpty() && newGroup) {
				s1.addAll(s2);
				newGroup= false;
			}else {
				s1.retainAll(s2);
			}
		}
	}
	
	totalAnswers += s1.size();
	System.out.println(totalAnswers);

}
}
