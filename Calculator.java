import static java.lang.System.out;
import java.util.Scanner;

public class Calculator

{
    public static int add(int a, int b)
    {
        // This works!
        return a + b;
    }

    public static int subtract(int a, int b)
    {
        // FIX the line below! - This is fixed! SW
        return a-b;
    }

    public static int multiply(int a, int b)
    {
        // FIX the line below! - This is fixed! SW
        return a*b;
    }

    public static float divide (float a, float b)
    { 
        return (float)a/(float)b; 
    }

    public static void main(String[] args)
    {

        Scanner keyboard = new Scanner(System.in);
        // First we call the add function.
        // It takes two input parameters which are 5 and 7 here.
        // The return value of add(), which is 12,
        // gets saved in the variable x.
        int x = add(5, 7);
        // Then we print out the value of x in our print statement	
        out.println("5 plus 7 equals " + x);
        // Now we do the same kind of call, but in a single line,
        // without needing 'x' as a temporary variable in between.
        out.println("3 plus 5 equals " + add(3, 5));
        out.println("1 plus 2 equals " + add(1, 2));

        // The subtraction results are wrong
        // because the subtract() method is incomplete. Fix it! - Fixed! SW
        out.println("9 minus 4 equals " + subtract(9, 4));
        out.println("9 minus 3 equals " + subtract(9, 3));

        // The multiplication results are wrong
        // because the multiply() method is incomplete. Fix it! - Fixed! SW
        out.println("3 times 3 equals " + multiply(3, 3));
        out.println("2 times 4 equals " + multiply(2, 4));

        // Now it's your turn! Create a divide() method and write some
        // print statements to test that it works right.
        // divide method added, print statements added. 
        out.println("3 divided by 3 equals " + divide(3, 3));
        out.println("2 divided by 4 equals " + divide(2, 4));
        out.println("9 divided by 4 equals " + divide (9, 4));
        out.println("9 divided by 3 equals " + divide (9, 3));
        out.println("2 divided by 8 equals " + divide (2,8));

        out.println("Please enter a number"); 
        float xx = keyboard.nextFloat(); 
        out.println(""); 
        out.println("Please enter another number"); 
        float yy = keyboard.nextFloat(); 

        out.println("");

        if ((xx == 0) || (yy ==0))

        {	
            out.println ("Stop that. We can't divide by zero. We will return the word \"infinity\" which is useless.");
        }
        else
        {

            out.println ("You've entered " + xx + " and " + yy + ".");
            out.println(xx +  " divided by " + yy + " equals " + divide(xx,yy));
            out.println("If we flip them, we have " + yy + " divided by " + xx + " which is " + divide(yy,xx));
        }

    }
}