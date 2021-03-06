package Days;

import java.util.*;
import java.io.File;

public class Day19_1 {
    public static void main(String[] args) throws Exception {
        File file = new File("//home//david//eclipse-workspace//AdventOfCode1//src//input");

        Scanner scan = new Scanner(file);

        HashMap<Integer, String> rules = new HashMap<>();

        ArrayList<String> messages = new ArrayList<>();

        boolean inRules = true;
        //Parsing the input.
        while (scan.hasNextLine()) {
            String rule = scan.nextLine();
            if (rule.length() == 0) {
                inRules = false;
            }
            if (inRules) {
                int ruleNum = Integer.parseInt(rule.split(":")[0]);
                String ruleContent = rule.split(":")[1].trim();
                rules.put(ruleNum, ruleContent);
            } else {
                messages.add(rule);
            }
        }
        messages.remove(0);
        //Computing the result for the messages.
        int acc = 0;
        for (String message : messages) {
            if (compute(0, message, rules) == message.length())
                acc++;
        }
        //Printing the answer.
        System.out.println(acc);
    }
    //Compute function.
    public static int compute(int ruleNum, String message, HashMap<Integer, String> rules) {
        String rl = rules.get(ruleNum);
        if (rl.startsWith("\"a\"")) {
            if (message.startsWith("a"))
                return 1;
            else
                return -1;
        } else if (rl.startsWith("\"b\"")) {
            if (message.startsWith("b"))
                return 1;
            else
                return -1;
        }
        String[] ruleContent = rl.split(" \\| ");
        for (String opt : ruleContent) {
            int acc = 0;
            String[] cnt = opt.split(" ");
            for (String cn : cnt) {
                int rn = Integer.parseInt(cn);
                int ret = compute(rn,message.substring(acc),rules);
                if(ret == -1){
                    acc = ret;
                    break;
                }
                acc += ret;
            }
            if (acc != -1)
                return acc;
        }
        return -1;


    }
}
