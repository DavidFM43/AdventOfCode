package Days;

import java.util.*;
import java.io.File;
public class Day18_2 {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\user\\Desktop\\Test\\AdventOfCode\\src\\input");
        Scanner scan = new Scanner(file);
        long ans = 0;
        while(scan.hasNextLine()){
            String input = scan.nextLine();
            input = input.replace(" ", "");
            ans += solve(input.toCharArray());
        }
        System.out.println(ans);
    }
    static long solve(char[] expression1){
        char[] expression= postFix(expression1).toCharArray();
        Stack<Long> numbers = new Stack<>();
        for(int i = 0; i < expression.length; i++){
            char ch = expression[i];
            if(Character.isDigit(ch)){
                long num = Character.getNumericValue(ch);
                numbers.push(num);
            }else if(ch == '+'){
                numbers.push(numbers.pop() + numbers.pop());
            }else if(ch == '*'){
                numbers.push(numbers.pop() * numbers.pop());
            }
    }
        return numbers.pop();
    }
    static String postFix(char[] expression){
        String postfix = "";
        Stack<Character> operators = new Stack<>();
        operators.push('#');

        for(int i = 0; i < expression.length; i++){
            if(Character.isDigit(expression[i])){
                postfix += expression[i];
            }else if(expression[i] == '('){
                operators.push(expression[i]);
            
            }else if(expression[i] == '+'){
                operators.push(expression[i]);
            }else if(expression[i] == ')'){
                while(operators.peek() != '#' && operators.peek() != '('){
                    postfix += operators.pop();
                }
                operators.pop();
            }else{
                while(operators.peek() != '#' && operators.peek() == '+'){
                        postfix += operators.pop();
                    }
                    operators.push(expression[i]);
                }
            }
        while(operators.peek() != '#'){
            postfix += operators.pop();
        }
        return postfix;
    }
}
