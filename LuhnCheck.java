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
        else if (!isValid(input, stringInput)) {
            System.out.print(input + " is not valid");
        }
        sc.close();
    }

    // Holistic check function for card validity 
    public static boolean isValid(Long longInput, String stringInput) {
        // Sum the values of each summation function and take the mod 10
        long sum = (rToLEvenSum(longInput) + rToLOddSum(longInput)) % 10;
        boolean output = false;
        
        // If all conditions all satisfied, card is valid
        if (sum == 0 && isCardLengthCorrect(stringInput) && isPrefixCorrect(stringInput)) {
            output = true;
        } 
        
        // If even one condition fails, card is invalid
        else if ((sum != 0) || !isCardLengthCorrect(stringInput) || !isPrefixCorrect(stringInput)) {
            output = false;
        }
        return output;
    }

    // Sum the doubles of the evens
    public static long rToLEvenSum(long input) {
        long sum = 0, 
             digit = 0, 
             tracker = 1, 
             numX2 = 0;

        // Uses tracker to iterage through odds or evens independent of input
        while (input > 0) {
            if ((tracker % 2) == 0) {
                
                // Store the current digit's value
                digit = input % 10;
                numX2 = digit * 2;

                // Add to sum if * 2 is < 10
                if (numX2 < 10) {
                    sum += digit * 2;
                } 
                
                // Add digits together if * 2 is > 10
                // Subtracting 9 is the same is adding digits 
                else if (numX2 > 9) {
                    sum += numX2 - 9;
                }

                // Clip current digit
                input /= 10;
                tracker++;
            } 
            else if ((tracker % 2) != 0) {
                // Clip current digit without changing sum
                input /= 10;
                tracker++;
            }
        }
        return sum;
    }

    // Sum the odds
    public static long rToLOddSum(long input) {
        long sum = 0, 
             digit = 0, 
             tracker = 1;

        // Uses tracker to iterage through odds or evens independent of input
        while (input > 1) {
            if ((tracker % 2) != 0) {

                // Store the current digit's value
                digit = input % 10;
                
                // Add to sum
                sum += digit;

                // Clip current digit
                input /= 10;
                tracker++;
            }

            else if ((tracker % 2) == 0) {
                // Clip current digit without changing sum
                input /= 10;
                tracker++;
            }
        }
        return sum;
    }

    // Checks card length
    public static boolean isCardLengthCorrect(String input) {
        if (input.length() >= 13 && input.length() <= 16) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPrefixCorrect(String input) {
        boolean output = false;

        // Visa
        if (Integer.parseInt(Character.toString(input.charAt(0))) == 4) {
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
        else if (Integer.parseInt(Character.toString(input.charAt(0))) == 3) {
            if (Integer.parseInt(Character.toString(input.charAt(1))) == 7) {
                output = true;
            }
        }

        else {
            output = false;
        }
        return output;
    }
}