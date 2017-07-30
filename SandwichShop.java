
import static java.lang.System.out;
import java.util.Scanner;

public class SandwichShop
{
    public static void main (String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        int goalForVeggies = 50; 
        int goalForBurgers = 250; 
        int goalForSubs = 180;
        int goalForSoup = 70; 

        out.println("Checking sales goals."); 
        out.println("The sales goal for veggie sandwiches is " + goalForVeggies + "."); 
        out.println("How many veggie sandwiches were sold today?"); 
        int veggie = keyboard.nextInt(); 
        out.println(""); 

        if (veggie >= goalForVeggies) 
        { 
            out.print("Made goal for veggies.\n"); 
        } 
        else 
        { 	
            out.print("Fell short.\n"); 
        } 

        out.println("The sales goal for burgers is " + goalForBurgers + "."); 
        out.println("How many burgers were sold today?"); 
        int burgers = keyboard.nextInt(); 
        out.println("");

        if (burgers >= goalForBurgers)
        {
            out.println("Made goal for burgers."); 
        }
        else
        {
            out.println("Fell short."); 
        }
        out.println("The sales goal for subs is " + goalForSubs + "."); 
        out.println("How many subs were sold today?"); 
        int subs = keyboard.nextInt(); 
        out.println(""); 

        if (subs >= goalForSubs)
        {
            out.println("Made goal for subs."); 
        }
        else
        {
            out.println("Fell short."); 
        }

        out.println("The sales goal for soup is " + goalForSoup + "."); 
        out.println("How many soups were sold today?"); 
        int soup = keyboard.nextInt(); 
        out.println(""); 

        if (soup >= goalForSoup)
        {
            out.println("Made goal for soup.\n"); 
        }
        else
        {
            out.println("Fell short.\n"); 
        }

        if ( 	veggie >= goalForVeggies && burgers >= goalForBurgers && subs >= goalForSubs && soup >= goalForSoup )
        { 
            out.println("Made goal for everything!"); 
        }
        //else
        //{
        //out.println("Didn't reach all goals."); 
        //}

        
    }
}

