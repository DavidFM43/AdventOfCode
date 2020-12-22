import java.util.*;


public class Day7 {
public static void main(String[] args){
Scanner scan = new Scanner(System.in);

HashMap<String,HashSet<String[]>> bags = new HashMap<>();

for(int i = 0; i < 594 ; i++){
    
	String line = scan.nextLine();
    String[] line1 = line.split("bags contain");
    
    String padre = line1[0].trim();
   
    
    String hijos = line1[1];
    String[] hijos1 = hijos.split(",");
    
    HashSet<String[]> sons = new HashSet<>();
    
    
    
    for(int j = 0; j < hijos1.length ;j++ ) {
    	String[] p1 = new String[2];
    	String[] p2 = hijos1[j].split(" ");
    	hijos1[j] = p2[2]+" "+p2[3];
    	p1[0] = p2[1];
    	
    	p1[1] = hijos1[j];
    	if (p1[0].compareTo("no")!=0) 
    		sons.add(p1);
    }
    bags.put(padre,sons);
    
}
System.out.println(sons("shiny gold",bags));





}
public static int sons(String bag,HashMap<String,HashSet<String[]>> bags) {
	int ans = 0;
	if (bags.get(bag).isEmpty())
		return 0;
	else {
	for(String[] pair:bags.get(bag)) {
		ans+=Integer.parseInt(pair[0]);
		ans+=Integer.parseInt(pair[0])*sons(pair[1],bags);

	}
	return ans;
	}
	
}
}
