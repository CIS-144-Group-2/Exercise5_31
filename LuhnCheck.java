import java.util.Scanner;

public class LuhnCheck {

    static final String VISA = "VISA"; // 4
    static final String MASTER_CARD = "MASTER CARD"; // 5
    static final String AMEX = "AMERICAN EXPRESS"; // 37
    static final String DISCOVER = "DISCOVER"; // 6
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long input = 0;
        String stringInput = new String();

        System.out.println("Input a credit card number: ");
        input = sc.nextLong();

        stringInput = Long.toString(input);
        System.out.println(rToLEvenSum(input));
        System.out.println(rToLOddSum(input));
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
                //temp = input % 10;
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
            System.out.println("Card is valid");
            return true;
        }
        else{
            System.out.println("Card is invalid");
            return false;
        }
    }

    public static boolean isPrefixCorrect(String input){

        boolean output = false;

        if (input.charAt(0) == 4){
            output = true;
        }

        else if (input.charAt(0) == 5) {
            output = true;
        }

        else if (input.charAt(0) == 6) {
            output = true;
        }

        else if (input.charAt(0) == 3){
            if(input.charAt(1) == 7){
                output = true;
            }
        }
        else {
            output = false;
        }
        return output;
    }
}
