import static java.lang.System.out; 
import java.util.Scanner; 

public class GroceryList

{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String item1; 

        out.println("Please list three items on your grocery shopping list.");
        out.print("Item 1? "); 

        item1 = keyboard.nextLine();
        out.println();

        String item2; 
        out.print("Item 2? ");
        item2 = keyboard.nextLine();
        out.println();

        String item3; 
        out.print("Item 3? ");      
        item3 = keyboard.nextLine();
        out.println();

        int quant1;
        out.println("Now, please enter the price of each item.");
        out.print ("How many " + item1 + "? ");
        quant1 = keyboard.nextInt(); 
        out.println();

        int quant2;

        out.print ("How many " + item2 + "? ");
        quant2 = keyboard.nextInt(); 
        out.println();

        int quant3;

        out.print ("How many " + item3 + "? ");
        quant3 = keyboard.nextInt(); 
        out.println();

        float cost1;

        out.println("Now, please enter the price of each item."); 
        out.print ("How much does one " + item1 + " cost? ");
        cost1 = keyboard.nextFloat();
        out.println();

        float cost2;

        out.print ("How much does one " + item2 + " cost? ");
        cost2 = keyboard.nextFloat();
        out.println();

        float cost3;

        out.print ("How much does one " + item3 + " cost? ");
        cost3 = keyboard.nextFloat();
        out.println();

        out.println("Calculating your grocery bill");
        float result = ((cost1 * quant1) + (cost2 * quant2) + (cost3 * quant3));
        out.print("Your total cost is " + result);

        
    }

   
}
