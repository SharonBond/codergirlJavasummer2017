import static java.lang.System.out;
import java.util.Scanner;

public class Temperature
{
	public static void main(String [] args)
	{
	int [][] temps = new int [4][7]; 
	temps [0][0] = 68;
	temps [0][1] = 70;
	temps [0][2] = 76; 
	temps [0][3] = 70; 
	temps [0][4] = 68;
	temps [0][5] = 71; 
	temps [0][6] = 75;
	temps [1][0] = 76;
	temps [1][1] = 76;
	temps [1][2] = 87; 
	temps [1][3] = 84; 
	temps [1][4] = 82;
	temps [1][5] = 75; 
	temps [1][6] = 83;
	temps [2][0] = 73;
	temps [2][1] = 72;
	temps [2][2] = 81;
	temps [2][3] = 78;
	temps [2][4] =76;
	temps [2][5] = 73;
	temps [2][6] =77;
	temps [3][0] = 64;
	temps [3][1] = 65;
	temps [3][2] = 69;
	temps [3][3] = 68;
	temps [3][4] = 70;
	temps [3][5] = 74;
	temps [3][6] =72;
	
	
	
	//int rows = 4;
	//int columns = 7;
	String days [] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; 
	String times [] = { "7 AM", "3 PM", "7 PM", "3 AM"} ;
	
	out.println("Temperature Calculator\n"); 
	
	out.println("The data provided are:"); 

	for (int i= 0; i < times.length; i++) 
	{ out.print(times[i] + ": "); 
		for (int j = 0; j < days.length; j++) 
		{
			if (j < (days.length -1))
		
			{
			out.print(temps [i][j]+ ", "); 
			}
			 else 
			{ out.print(temps[i][j]);}
			}  
			
		
	out.println(""); 
	 
 	}
 	
 	out.println(); 
 	out.println("Based on that data, the following are the average temperatures for the week.\n");
 	
 	
 	
 	for (int j = 0; j<days.length; j++)
 	{ out.print(days [j]);
 	 int columnSum = 0 ;
 	for (int i = 0; i< times.length; i++)
 	
 	{ 
 		
 		columnSum += temps[i][j];
 		
 		} 
		
		double average = columnSum/(double)times.length; 
		average = (double)Math.round(average * 100d)/100d; //remove this line for non rounded
		out.println(": " + average);  	
			 
 	}
 	out.println();
 	
 	for (int i = 0; i<times.length; i++)
 	{ out.print(times[i]);
 	 int rowSum= 0 ;
 	for (int j = 0; j< days.length; j++)
 	
 	{ 
 		
 		rowSum+= temps[i][j];
 		
 		} 
		
		double average = rowSum/(double)days.length; 
		average = (double)Math.round(average * 100d)/100d; //remove this line for non rounded
		
		out.println(": " + average);  	
			 
 	}
 	out.println(); 
 	out.println("The final average temperature for the weeks was:\n");
 	
 	 out.print("Overall: "); 
 	int totalSum = 0;
 	for (int i = 0; i<times.length; i++)
 	{ 
 	
 	for (int j = 0; j< days.length; j++)
 	
 	{ 
 		totalSum+= temps[i][j];
 	 		} 
 	}
 	
 	double average = totalSum/(double)(days.length * times.length);
 	average = (double)Math.round(average * 100d)/100d; //remove this line for non rounded

		out.println( average);  	
			 
 	
	}
	}