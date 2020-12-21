import java.util.*;
public class Day4 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	HashMap<String,String> credentials = new HashMap<>();
	int numValid = 0;
	String[] campos = {"byr","iyr","eyr","hgt","hcl","ecl","pid"};
	
	for(int i = 0; i < 1010; i++) {
	
		
		
		String line = scan.nextLine();
		
		if(line.isEmpty()) {
			
			boolean valid = true;
			
			for(String campo:campos) {
				if(!credentials.containsKey(campo)) {
					valid = false;
					break;
				}
			}
			if(valid)
				numValid++;
			
			credentials.clear();
			
			
			
		}else {
			
			String[] fields = line.split(" ");
			
			for(String field: fields) {
				String[] partes = field.split(":");

				boolean validC = check(partes[0],partes[1]);
				if(validC)
					credentials.put(partes[0],partes[1]);
				
			}
		}
	
	}
	
	System.out.println(numValid);
	
	
	
	
}
public static boolean check(String key , String value) {
	HashSet<Character> chars = new HashSet<>();
	chars.add('0');
	chars.add('1');
	chars.add('2');
	chars.add('3');
	chars.add('4');
	chars.add('5');
	chars.add('6');
	chars.add('7');
	chars.add('8');
	chars.add('9');
	chars.add('a');
	chars.add('b');
	chars.add('c');
	chars.add('d');
	chars.add('e');
	chars.add('f');
	
	HashSet<String> eyes = new HashSet<>();
	
	eyes.add("amb");
	eyes.add("blu");
	eyes.add("brn");
	eyes.add("gry");
	eyes.add("grn");
	eyes.add("hzl");
	eyes.add("oth");
	
	switch(key) {
	case "byr":
		int byr = Integer.parseInt(value);
		return (byr<=2002 && byr >=1920)?true:false;
	case "iyr":
		int iyr = Integer.parseInt(value);
		return (iyr<=2020 && iyr >=2010)?true:false;
	case "eyr":
		int eyr = Integer.parseInt(value);
		return (eyr<=2030 && eyr >=2020)?true:false;	
	case "hgt":
		
		int length = value.length();
		String metric;
		if(value.substring(length-2,length).compareTo("cm")==0) {
			metric = "cm";
		}else if(value.substring(length-2,length).compareTo("in")==0) {
			metric = "in";
		}else {
			return false;
		}
		
		int hgt = Integer.parseInt(value.substring(0,length-2));
		
		
		if (metric == "cm") {
			return (hgt<=193 && hgt>=150)?true:false;
		}else {
			return (hgt<=76 && hgt>=59)?true:false;
		}
	case "hcl":
		if(value.charAt(0) !='#' || value.length()!=7)
			return false;
		for(int j = 1; j < value.length();j++) {
			if(!chars.contains(value.charAt(j)))
				return false;
		}
		return true;
	case "ecl":
		return(eyes.contains(value))?true:false;
	case "pid":
		if (value.length()==9)
			return true;
		return false;
		
	default:
		return true;
		
		
		
		
		
		
	}
	
}

}
