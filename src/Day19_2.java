import java.util.*;
import java.io.File;

public class Day19_2 {
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
            if (compute(0,message,rules).contains(message.length()))
                acc++;
        }
        System.out.println(acc);
    }

    //Compute function.
    public static ArrayList<Integer> compute(int ruleNum, String message, HashMap<Integer, String> rules) {
        String rl = rules.get(ruleNum);
        ArrayList<Integer> re = new ArrayList<>();
        if (rl.startsWith("\"a\"")) {
            if (message.startsWith("a")) {
                re.add(1);
                return re;
            }
            else
                return re;
        } else if (rl.startsWith("\"b\"")) {
            if (message.startsWith("b")) {
                re.add(1);
                return re;
            }
            else
                return re;
        }
        String[] ruleContent = rl.split(" \\| ");
        ArrayList<Integer> compt = new ArrayList<>();
        for (String opt : ruleContent) {
            ArrayList<Integer> acc = new ArrayList<>();
            acc.add(0);
            String[] cnt = opt.split(" ");
            for (String cn : cnt) {
                ArrayList<Integer> totalAcc = new ArrayList<>();
                int rn = Integer.parseInt(cn);
                for(Integer ac : acc) {
                    ArrayList<Integer> ret = compute(rn, message.substring(ac, message.length()), rules);
                    for(Integer c : ret) {
                        totalAcc.add(ac + c);
                    }
                }
                acc = totalAcc;
            }
            for(Integer ac : acc){
                compt.add(ac);
            }
            }
            return compt;
        }
}
