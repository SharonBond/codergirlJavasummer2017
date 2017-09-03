

import static java.lang.System.out;
import java.util.Scanner;
import java.util.Random;

public class  GuessMyNumberTwo

  
{
  public static void Understand ( )
  {
    String [] understand = {"I didn't understand that.", " That wasn't a valid option.", 
    "Try again, that didn't make sense.", "No comprendo.", "Please make sense this time."};
 
    out.println(understand[Rando(1)]);
    
  }
  
    public static void Cheated ( )
    { 
        String [] cheated  = {"If I didn't know you better, I'd assume you're cheating. ", 
                "First try? I can only assume you're psychic. Give me the Powerball numbers!", 
                "Cheating!! That is the only way you'd guess so quickly. ",
                "Impressive!! Look at you getting it on your first try. ",
                "I need to step up my game. I can't believe you got it so quickly."} ;
                  
        out.println(cheated[Rando(1)]); 
    }

    public static void Higher ( )       
    {
        String[] higher = { "Guess higher.", 
                "Aim higher.", 
                "Nope, the number is higher.", 
                "My number is higher than that number.", "Try a larger number."};
                   
        out.println(higher[Rando(1)]);
    }

    public static void lower ()
    {

        String [] lower  = {"Guess lower.", "Nope, too high. The number is lower. ", 
                "Wrong, my number is less than that. ", "Higher... no wait... lower. Yes, lower.", 
                "Try something smaller." };
            
        out.println(lower[Rando(1)]);
    }

    public static void Ten ()
    {
        String [] tenTimes =  {"10 guesses, 10 failures. We\'re done here. ", 
                "You two couldn\'t get it within 10 guesses. I\'m not impressed. ", 
                "We gave you 10 tries, you gave us 10 wrong answers. I suggest you play again for practice." , 
                "You\'re not very good at this are you? I gave you 10 chances.",
                "I assume failure is a word you're both familiar with? Game over!" } ;

        out.println(tenTimes[Rando(1)]); 

    }

	public static void Turn ()
	{ String [] yourTurn = { " give it a go.",  " you're up.", " give it a shot.", " your turn to guess.", 
	"give me a guess."}; 
	  
	out.println(yourTurn[Rando(1)]); 


}
    public static int Rando (int x)
    {
        Random r = new Random (System.currentTimeMillis()); 
        int i= r.nextInt(5);
        return i; 
    }

    public static void main (String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);

        int guess;
        boolean playAgain = true; 
        boolean samePeople = true; 
       	boolean loop = true; 
        boolean yetAnotherLoopVariable = true; 

        String again; 

        do 
        {
            out.println("Player one enter your name."); 
            String play1 = keyboard.nextLine(); 

            out.println("Player two enter your name."); 
            String play2 = keyboard.nextLine(); 
            out.println();
         
                   if ( play1 .equals (play2))
                {out.println("Same name! How cute! And just a little confusing. Let's fix that.\n");
                play1 = ( play1 + " 1");
                play2 = (play2 + " 2"); 
              
              }

            out.println("Player one is " + play1  + " and player two is " + play2); 
            out.println(); 
        
            do
            {
                Random r = new Random (System.currentTimeMillis());  
                int diceRoll = r.nextInt((100-1)+1) +1; 
               //CHEAT MODE:
               // out.println(diceRoll);   
                out.println("I'm thinking of a number between 1 and 100. What is it?"); 
                out.println(play1+ " guess"); 
                out.println(); 
                int count = 0; 
                
                do 
                {
                    guess = keyboard.nextInt(); 
                    keyboard.nextLine();
                    out.println(); 
                    count++; 

                    if (guess <1 || guess >100)
                    { 
                        out.println("I think I said between 1 and 100. Try again. We won't count that one.");
                        count = (count-1);

                    } 
                    else if (guess > diceRoll)
                    { 
                        lower(); 

                    
                        if (count%2 == 0)
                        {
                            
                             if (count == 10)
                            { Ten();
                              guess = diceRoll;
                                }
                            else 
                            {
                            out.print (play1 + " ");
                            Turn ();
                            }
                           
                        }
                        else if (count%2!=0)
                        {out.print (play2 + " ");
                        Turn(); 

                         
                        }

                    } 
                    else if (guess < diceRoll)
                    { 

                        if (count%2 == 0)
                        {
                            if (count <10)
                            {
                                Higher();
                                out.print (play1 + " ");
                                Turn();}
                            else if (count == 10)
                            { guess = diceRoll;
                                Ten();
                                out.println ("The number was " + diceRoll); 
                            }
                        }
                        else if (count%2!=0) 

                        {Higher();
                            out.print (play2 + " " );
                            Turn(); 
                        

                        }

                    } 
                    else if (guess == diceRoll)
                    { 
                        out.println("You got it! My number was " + diceRoll);

                        if (count%2 == 0) 

                        { out.println("Congrats " + play2 + "!"); 
                        out.println(); 
                            if (count == 2)
                            { 
                            Cheated();
                            out.println(); 
                            
                             } 
                            out.println("There were a total of " + count + " tries");
                            out.println("It took you only " + count/2 + " tries"); 
                        } 

                        else
                        { out.println("Congrats " + play1 + "!");
                        out.println(); 

                            int playOneCount = (int) Math.ceil((double)count / 2); 
                            if ( count == 1)
                            {
                            out.println("It took a total of " + count + " try.");
                                Cheated(); 

                            } 
                            else 
                            { 
                                out.println("There were a total of " + count + " tries.");
                                out.println("It took you only " + playOneCount + " tries."); }

                            //again = keyboard.nextLine(); 
                        }  
                    }

                }while (guess != diceRoll);

           
                do {
                    out.println(); 
                    out.println("Do you want to play again? Enter yes or no");
                    again = keyboard.nextLine();
                    out.println(); 

                    if (again.equals("no"))
                    {   
                    	
                        playAgain = false; 
                        samePeople = false; 
                        yetAnotherLoopVariable =false; 
                         out.print("I'll be here if you want to play again later, " + play1 + " and "); 
                         out.println(play2 + ". Thanks for the entertainment!");
                    } 

                    else if (again.equals("yes"))
                        do
                        { 

                            yetAnotherLoopVariable =false ; 
                            loop = true;
                            //out.println(); 
                            out.println("Are the same players playing? yes or no"); 
                            String same = keyboard.nextLine(); 
			    out.println(); 	
                            if (same.equals("yes"))
                            {out.println();
                              samePeople = true;         
                               loop = false;
                            } 
                            else if (same.equals("no"))
                            {samePeople = false;                              
                                loop = false;
                                playAgain = true;
                            }
                            else 
                            {Understand();
                            out.println(); 
                                
                                loop = true;
                            } 
                        } while (loop == true);
                    else 
                    {
                        Understand();
                        out.println(); 
                        playAgain = false;
                        samePeople = false; 
                        yetAnotherLoopVariable = true; 
                    }
                } while (yetAnotherLoopVariable == true); 
            }while (samePeople == true); 
        } while (playAgain == true);  
    }    
}   
