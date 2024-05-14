package org.example;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java -jar Calculator.jar <num1> <num2> <operation>");
            return;
        }

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        String operation = args[2];

        int result;
        switch (operation) {
            case "+":
                result = Calculator.add(num1, num2);
                break;
            case "-":
                result = Calculator.subtract(num1, num2);
                break;
            case "x":
                result = Calculator.multiply(num1, num2);
                break;
            case "/":
                result = Calculator.divide(num1, num2);
                break;
            default:
                System.out.println("Invalid operation: " + operation);
                return;
        }

        System.out.println("Result: " + result);
    }
}
