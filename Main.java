import java.util.Scanner;

public class Main {
    public static String calc(String input) {
        String[] romanNum = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
                "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String[] str = input.split(" ");
        if (str.length > 3) {
            throw new IllegalArgumentException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (str.length < 3) {
            throw new IllegalArgumentException("т.к. строка не является математической операцией");
        }
        String firstNum = str[0];
        String secondNum = str[2];
        String op = str[1];
        int index;
        int num1 = ToNumber(firstNum);
        int num2 = ToNumber(secondNum);
        if ((num1 == -1 && num2 != -1) || (num1 != -1 && num2 == -1)){
            throw new IllegalArgumentException();
        }
        if (num1 == -1) { // arabic
            int arabicNum1 = Integer.parseInt(firstNum);
            int arabicNum2 = Integer.parseInt(secondNum);

            if (arabicNum1 <= 0 || arabicNum2 <= 0 || arabicNum1 > 10 || arabicNum2 > 10) {
                throw new IllegalArgumentException("т.к. одно или оба числа больше 10 или меньше/равно 0");
            }
            return switch (op) {
                case "+" -> String.valueOf(arabicNum1 + arabicNum2);
                case "-" -> String.valueOf(arabicNum1 - arabicNum2);
                case "*" -> String.valueOf(arabicNum1 * arabicNum2);
                case "/" -> String.valueOf(arabicNum1 / arabicNum2);
                default -> throw new IllegalArgumentException("т.к. неверный знак операции");
            };
        }
        //romain
        switch (op) {
            case "+" -> {
                index = num1 + num2;
                return String.valueOf(romanNum[index]);
            }
            case "-" -> {
                if (num1 > num2) {
                    index = num1 - num2;
                    return String.valueOf(romanNum[index]);
                }
                throw new IllegalArgumentException("т.к. в римской системе нет отрицательных чисел");
            }
            case "*" -> {
                index = num1 * num2;
                return String.valueOf(romanNum[index]);
            }
            case "/" -> {
                index = num1 / num2;
                if (String.valueOf(romanNum[index]).equals("0")) {
                    throw new IllegalArgumentException("т.к. в римской системе нет нуля");
                }
                return String.valueOf(romanNum[index]);
            }
            default -> throw new IllegalArgumentException("т.к. неверный знак операции");
        }
    }
    static int ToNumber(String number) {
        return switch (number) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) { //можно было бы использовать while(true) но IDE ругался
            Scanner console = new Scanner(System.in);
            String input = console.nextLine();
            System.out.println(calc(input));
        }
    }
}


