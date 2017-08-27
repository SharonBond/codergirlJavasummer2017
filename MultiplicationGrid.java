import static java.lang.System.out;
import java.util.Scanner;

public class MultiplicationGrid
{ 
    public static String format (int a)
    { 
        if (a<10)
        { 
            return ("    " + a); 
        } 
        else if (a>= 100)
        { 
            return ("  "+ a);
        } 
        else if (a >=10 && a < 100)
        { 	
            return ("   " + a);
        } 
        else 
        { 
            return (""); 
        } 

    } 

    public static void Multiply (int b )
    {

        for (int digit1 = 0; digit1 <= b; digit1++)
            out.print(format(digit1));
        out.println(); 
        for (int digit1 = 0; digit1 <= b; digit1++)
        { 
            out.print(format(digit1)); 
            for (int digit2 = 0; digit2 <= b; digit2 ++)
            {
                int product = digit1 * digit2; 
                out.print(format(product)); 
            } 
            out.println(); 
        } 	



    }

    public static void main(String [] args)
    { 		

        out.println("Welcome to Multiplication Tables\n");
        boolean again = true; 
        int count = 0; 
        int wrong = 0; 
        do 
        { 
            out.println("How large would you like to see them? Up to 20 only please. Type 0 to stop."); 
            Scanner keyboard = new Scanner(System.in);
            int entry = keyboard.nextInt();

            out.print ("     "); 

            if (entry> 20) 
            { out.println("Please try again. You're aiming too high.\n"); 
                wrong++;
            } 
            else if (entry <0) 
            {
                out.println("Try again, keep it positive this time.\n");
                wrong++; 
            } 

            else if (entry== 0)

            { 
                if (count >=1 && count < 20)
                {out.println("I put a lot of effort into this. The least you could have done is played correctly " + (count+1) + " times. "); 
                } 
                else if (count>=20)
                {
                    out.println("You're a peach! You ran me " + count + " times.");
                }

                else if (count == 0)
                { 
                    out.println("You're breaking my heart by not playing. Another day I guess."); 
                }
                if (wrong==1)
                {
                    out.println("And you wasted " + wrong + " time doing it wrong. Thanks a lot.");
                }
                else if (wrong >1)
                {
                    out.println("And you wasted " + wrong + " times doing it wrong. Thanks a lot. ");
                } 
                again = false;
            } 

            else 
            {  
                if (entry < 5)
                { 

                    Multiply(entry);
                    count++; 
                    out.println(); 
                    out.println("I'm smart. I can handle bigger numbers.\n");
                } 
                else 
                { 
                    Multiply(entry);
                    count++; 
                    out.println();
                }
            }

        } while (again); 

    } 
} 