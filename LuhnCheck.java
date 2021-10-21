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

    
    }

    

    static boolean cardIsValid(String input){
        if (input.length() >= 13 && input.length() <= 16){
            System.out.println("Card is valid");
            return true;
        }
        else{
            System.out.println("Card is invalid");
            return false;
        }
    }

    static String cardType(String input){

        String output = new String();

        if (input.charAt(0) == 4){
            output = VISA;
        }

        else if (input.charAt(0) == 5) {
            output = MASTER_CARD;
        }

        else if (input.charAt(0) == 6) {
            output = DISCOVER;
        }

        else if (input.charAt(0) == 3){
            if(input.charAt(1) == 7){
                output = AMEX;
            }
        }
        return output;
    }
}
