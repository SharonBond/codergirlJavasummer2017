
import static java.lang.System.out;
import java.util.Scanner;

public class ThankYouMailMerge

{
    public static void main (String[] args) 
    {

        out.println("Thank You Letters."); 
        String name = ("");
        float donation = 0;
        boolean keepGoing = true; 

        while (keepGoing)

        { 
        
            Scanner keyboard = new Scanner(System.in);
            out.println("What is the whole name of the donor?");
            name = keyboard.nextLine(); 
            out.println(); 

            if(name.equals ("quit"))
            { 
                keepGoing = false;
            }
            else                

            {
     
                out.println("How much did he or she donate?"); 
                donation = keyboard.nextFloat(); 
                out.println();
                out.println("Dear " + name  + ",\n"); 
                out.println("Thank you for your donation! We rely on donors like you to keep our"); 
                out.println("organization effective, and you came through for us. Your donation of $" + donation); 
                out.println("will help our efforts to make a difference in the world.\n"); 
                out.println("As you may know, we are a registered non-profit organization, so your");
                out.println("donation is tax deductible. You may use this letter as a receipt for tax");
                out.println("purposes.\n");
                out.println("Thank you again for your support!\n");
                out.println("Sincerely, ");
                out.println("Paula Jones");
                out.println("christmassweatersforhomelesspuppies.org");
                out.println(); 
            }
        }

      
    }    

}   

   