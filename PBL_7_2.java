class InvalidInputException extends Exception {
    InvalidInputException(String s) {
        super(s);
    }

}

class myException {
    static void validateInputRange(int n) throws InvalidInputException {

        if (n > 12 || n < 1) {
            System.out.println("Parsed Interger from CLA");
            throw new InvalidInputException("Invalid Input, enter number between 1 and 12");

        } else {
            System.out.println("Parsed Integer from CLA\nInput is valid.");

        }
    }

    static boolean validateInputFormat(String n) throws InvalidInputException {
        try {
            int x = Integer.parseInt(n);
        } catch (NumberFormatException e) {
            System.out.println("Input String can not be parsed to Integer");
            System.out.println("Exiting...");
            System.exit(1);
        }
        return true;
    }
}

public class PBL_7_2 {
    static int factorial(int n) {
        int fact = 1;
        for (int i = n; i > 1; i--) {
            fact = fact * i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int t = 0;
        while (t < 3) {
            try {
                System.out.print("Enter Input : ");

                myException.validateInputFormat(args[t]);

                myException.validateInputRange(Integer.parseInt(args[t]));

                System.out.println("Factorial of number : " + factorial(Integer.parseInt(args[t])));
            } catch (Exception e) {
                System.out.println("Exception  : " + e.getMessage());
            } finally {
                System.out.println("\n");
            }
            t++;
        }
    }
}