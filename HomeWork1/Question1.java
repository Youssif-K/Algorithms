package HomeWork1;
import DataStructures.*;
import java.util.Scanner;

public class Question1 {
    
    public static boolean isAnOperation(char c){
        return c == '*' || c == '+' || c == '-' || c == '/';
    }

    public static void solveOperation(String operationString){
        Stack <String> operands = new Stack<String>();
        Stack <Character> operations = new Stack<Character>();
        
        for(char c : operationString.toCharArray()){
            if(Character.isDigit(c)){
                operands.push(String.valueOf(c));
            }else if(isAnOperation(c)){
                operations.push(c);
            }else{
                String op2 = operands.pop();
                String op1 = operands.pop();
                char operation = operations.pop();
                String finalOperation = '(' + op1 + operation + op2 + ')';
                operands.push(finalOperation);
            }
        }

        while(operations.getFirstNode() != null){
            String op2 = operands.pop();
            String op1 = operands.pop();
            char operation = operations.pop();
            String finalOperation = op1 + operation + op2;
            operands.push(finalOperation);
        }
        
        System.out.println(operands.pop());
    }

    public void main(String[] args){
        System.out.println("Enter a the operation with the missing left parentheses");
        Scanner sc = new Scanner(System.in);
        String operation = sc.nextLine();
        solveOperation(operation);
        sc.close();
    }

}
