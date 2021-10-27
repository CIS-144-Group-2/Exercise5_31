import java.util.*;

public class LuhnCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long input = 0;
        String stringInput = new String();

        System.out.println("Input a credit card number: ");
        input = sc.nextLong();

        stringInput = Long.toString(input);
        if (isValid(input, stringInput)) {
            System.out.print(input + " is valid");
        }
        else if (!isValid(input, stringInput)){
            System.out.print(input + " is not valid");
        }
        sc.close();
    }
    public static boolean isValid(Long longInput, String stringInput) {
        long sum = (rToLEvenSum(longInput) + rToLOddSum(longInput)) % 10;
        boolean output = false; 
        if (sum == 0 && isCardLengthCorrect(stringInput) && isPrefixCorrect(stringInput)) {
            output = true;
        }
        else if((sum != 0) || !isCardLengthCorrect(stringInput) || !isPrefixCorrect(stringInput)) {
            output = false;
        }
        return output;
    }
    public static long rToLEvenSum(long input){
        long output = 0,
             digit = 0,
             tracker = 1,
             numX2 = 0;

        while (input > 0) {    
            if ((tracker % 2) == 0){
                digit = input % 10;
                numX2 = digit * 2;

                if (numX2 < 10){
                    output += digit * 2;
                }
                else if (numX2 > 9){
                    output += numX2 - 9;
                }

                input /= 10;
                tracker++;
            }
            else if ((tracker % 2) != 0) {
                input /= 10;
                tracker++;
            }
        }
        return output;
    }

    public static long rToLOddSum(long input) {
        long sum = 0, 
             digit = 0, 
             tracker = 1;

        while (input > 1) {
            if ((tracker % 2) != 0) {

                digit = input % 10;
                sum += digit;
                input /= 10;
                tracker++;
            } 

            else if ((tracker % 2) == 0) {
                input /= 10;
                tracker++;
            }
        }
        return sum;
    }

    public static boolean isCardLengthCorrect(String input){
        if (input.length() >= 13 && input.length() <= 16){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isPrefixCorrect(String input){

        boolean output = false;

        if (Integer.parseInt(Character.toString(input.charAt(0))) == 4){
            output = true;
        }

        // Master Card
        else if (Integer.parseInt(Character.toString(input.charAt(0))) == 5) {
            output = true;
        }

        // Discover
        else if (Integer.parseInt(Character.toString(input.charAt(0))) == 6) {
            output = true;
        }

        // American Express
        else if (Integer.parseInt(Character.toString(input.charAt(0))) == 3){
            if(Integer.parseInt(Character.toString(input.charAt(1))) == 7){
                output = true;
            }
        }
        return output;
    }
}
