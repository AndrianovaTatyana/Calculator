import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите что-нибудь");
        String expression = scanner.nextLine();
        String[] data = expression.replace(" ", "").split("(?=\\+)|(?<=\\+)|(?=\\*)|(?<=\\*)|(?=\\-)|(?<=\\-)|(?=\\\\)|(?<=\\\\)");
        try {
            String result = String.valueOf(processInput(data));
            System.out.println(result);
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так, проверьте ввод");
        }


    }

    static String processInput(String[] data) throws Exception {
        if (RomanNumberTranslator.translateFromRoman(data[0]) == null) {
            int firstOperand = Integer.parseInt(data[0]);
            int secondOperand = Integer.parseInt(data[2]);
            if(firstOperand > 10 | secondOperand > 10){
                throw new Exception();
            }
            char operation = data[1].charAt(0);
            return calc(firstOperand, secondOperand, operation);
        }
        if (RomanNumberTranslator.translateFromRoman(data[0]) != null) {
            int firstOperand = Integer.parseInt(RomanNumberTranslator.translateFromRoman(data[0]));
            int secondOperand = Integer.parseInt(RomanNumberTranslator.translateFromRoman(data[2]));
            char operation = data[1].charAt(0);
            String result = calc(firstOperand, secondOperand, operation);
            String romanResult = RomanNumberTranslator.translateToRoman(result);
            return romanResult;
        }
        return null;

    }

    public static String calc(int num1, int num2, char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                result = 0;
        }
        return String.valueOf(result);
    }
}
