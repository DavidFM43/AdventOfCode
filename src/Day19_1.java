import java.util.*;
import java.io.File;
public class Day19_1 {
    public static void main(String[] args) throws Exception{
        File file = new File("//home//david//eclipse-workspace//AdventOfCode1//src//input");
        Scanner scan = new Scanner(file);
        boolean inRules = true;
        HashMap<Integer,String> rules = new HashMap<>();
        ArrayList<String> messages = new ArrayList<>();
        while(scan.hasNextLine()){
            String rule = scan.nextLine();
            if(rule.length() == 0){
                inRules = false;
            }
            if(inRules){
               int ruleNum = Integer.parseInt(rule.split(":")[0]);
               String ruleContent = rule.split(":")[1];
               rules.put(ruleNum, ruleContent);
            }else{
                messages.add(rule);
            }
        }
        messages.remove(0);
        
        for(Integer ruleNum:rules.keySet()){
            System.out.println(ruleNum + " :" + rules.get(ruleNum));
        }
        /*
        for(int i = 0; i < 6; i++){
            compute(i, rules);
        }
        */
        System.out.println(Arrays.toString(rules.get(0).split(" ")));
    }

    public static String compute(int ruleNum, HashMap<Integer,String> rules){
        String ruleContent = rules.get(ruleNum);
        if(ruleContent.compareTo(" \"a\"") == 0){
            return "a";
        }else if(ruleContent.compareTo(" \"b\"") == 0){
            return "b";
        }
        String message = "";

        String[] parts = ruleContent.split("|");

        if(parts.length == 2){
            //Tiene dos posibilidades
        }else{
            String[] c1 = parts[0].split(" ");
            for(int i = 0; i < c1.length; i++){
                message += compute(Integer.parseInt(c1[i]),rules);
            }
        }

        return message;
    }
}
