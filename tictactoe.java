import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

class tictactoe
{
	public static void main(String args[])
	{
		//intilaztion
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		method mt = new method();
		boolean hvsc2 = true;
		boolean human = false;
		boolean computer = false;
		int count =0;								//counting for 9 moves
		int hvsc =1;
 		String name1 = "Bhavik";
		String name2 = "Computer";
		
		char a[] = new char[9];
		for(int i=0;i<9;i++)
		{a[i] = '.';}
	
	
		while(hvsc2)								//choose to play with computer or Human(Friend)
		{
			System.out.println("With whom Do You Want to Play??");
			System.out.println("1.Your Friend.");
			System.out.println("2.With Computer.");
			hvsc = sc.nextInt();
			
			if(hvsc==1)								
			{
				hvsc2=false; 
				human = true;
				System.out.println("Enter Your name:");
				name1 = sc.next();				
				
				System.out.println("Enter Your Friend's name:");
				name2 = sc.next();
			}
			else if(hvsc==2)
			{
				System.out.println("Enter Your name:");
				name1 = sc.next();				
				hvsc2=false; 
				computer = true;
			}
			else
			{
				System.out.println("Enter Valid Option.");
				hvsc2=true;
			}
		}
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("===========================");
		System.out.println("=== WELCOME TO THE GAME ===");
		System.out.println("===========================");
		System.out.println("");
		System.out.println("");



		
		System.out.print("You had Choose to Play with ");
		if(hvsc==1){System.out.println("Friend");}
		else if(hvsc==2){System.out.println("Computer");}
		System.out.println("Play board: ");
		System.out.println("╔═══╦═══╦═══╗   ╔═══╦═══╦═══╗");
		System.out.println("║ 0 ║ 1 ║ 2 ║   ║   ║   ║   ║");
		System.out.println("╠═══╬═══╬═══╣   ╠═══╬═══╬═══╣");
		System.out.println("║ 3 ║ 4 ║ 5 ║   ║   ║   ║   ║");   
		System.out.println("╠═══╬═══╬═══╣   ╠═══╬═══╬═══╣");
		System.out.println("║ 6 ║ 7 ║ 8 ║   ║   ║   ║   ║");
		System.out.println("╚═══╩═══╩═══╝   ╚═══╩═══╩═══╝");
		/*
		System.out.println("0 1 2   . . .");
		System.out.println("3 4 5   . . .");
		System.out.println("9 7 8   . . .");
		*/
		boolean game = true;					//controlling whole game.
		
		while(game)
		{
			boolean p1 = true;
			boolean p2 = false;
			int mov1 = 9;
			int mov2 = 9;
			System.out.println("Player 1:");
		
			while(p1)						//Player1
			{
				System.out.println(name1+"(X) Enter the position:");
				mov1 = sc.nextInt();		//player1 input
				p1 = false;
				p2 = true;
				if(hvsc==1)
				{human = true;}
				if(hvsc==2)
				{computer = true;}
				
				if(mov1<0 || mov1>8)
				{
					System.out.println("Enter valid Position:");
					p1 =true;
				}
				else if(mov1>=0 && mov1<=8)
				{
					if(a[mov1] != '.')
					{
						System.out.println("Position (" + mov1 + ") is Already used." );
						p1 = true;
					}
					else 
					{a[mov1] = 'X';  count++;}
					mt.print(a);
				}
			}
			
			//player1 Condition checking...
			if(mt.condition(a,'X'))
			{
			//	System.out.println("Player1 Win..");
				String message = name1 +"(X) Win the Game!!!!";
				JOptionPane.showMessageDialog(null, message, "Game Result", JOptionPane.INFORMATION_MESSAGE);
				game = false;  p2=false;
			}
			
			if(count==9)
			{
				//System.out.println("More Than 9 moves are not allowed.");
				System.out.println("--x--x--x--x--It's a TIE--x--x--x--x--");
				game = false;
				System.exit(0);
			}
			
			while(p2)
			{
				while(computer)		//for computer
				{
					mov2 = rd.nextInt(0,9);    //Player2 input
					p2 = false;
					computer = false;
					p1 = true;
					
					if(a[mov2] != '.')
						{
							p2 = true;
							computer=true;
						}
					else 
						{
							System.out.println("Computer Had Choose "+ " Position " + mov2 );
							a[mov2] = 'O';  count++;
							mt.print(a);
						}
					
				}
				while(human)
				{
					System.out.println(name2 + "(O) Enter the position:");
					mov2 = sc.nextInt();    //Player2 input
					p2 = false;
					human = false;
					p1 = true;
					
					if(mov2<0 || mov2>8)
					{
						System.out.println("Enter valid Position:");
						p2 =true;
						human=true;
					}
					else if (mov2>=0 && mov2<=8)
					{
						if(a[mov2] != '.')
						{
							System.out.println("Position (" + mov2 + ") is Already used." );
							p2 = true;
							human=true;
						}
						else 
						{a[mov2] = 'O';  count++;}
						mt.print(a);
					}
				}
			}
			
			//Player2 checking....
			if(mt.condition(a,'O'))
			{
				//System.out.println("Player2 Win..");
				String message = name2 + "(O) Win the Game!!!!";
				JOptionPane.showMessageDialog(null, message, "Game Result", JOptionPane.INFORMATION_MESSAGE);
				game = false; p1=false;
			}
		}	
	}
}
class method
{
	void print(char b[])
	{
	 /*	System.out.println("0 1 2  " + b[0] + " " + b[1] +  " " + b[2]);
		System.out.println("3 4 5  " + b[3] + " " + b[4] +  " " + b[5]);
		System.out.println("6 7 8  " + b[6] + " " + b[7] +  " " + b[8]);
		System.out.println("");  
	 */

		System.out.println("╔═══╦═══╦═══╗   ╔═══╦═══╦═══╗");
		System.out.println("║ 0 ║ 1 ║ 2 ║   ║ "+b[0]+" ║ "+b[1]+" ║ "+b[2]+" ║");
		System.out.println("╠═══╬═══╬═══╣   ╠═══╬═══╬═══╣");
		System.out.println("║ 3 ║ 4 ║ 5 ║   ║ "+b[3]+" ║ "+b[4]+" ║ "+b[5]+" ║");
		System.out.println("╠═══╬═══╬═══╣   ╠═══╬═══╬═══╣");
		System.out.println("║ 6 ║ 7 ║ 8 ║   ║ "+b[6]+" ║ "+b[7]+" ║ "+b[8]+" ║");
		System.out.println("╚═══╩═══╩═══╝   ╚═══╩═══╩═══╝");
	}
	
	boolean condition(char a[],char x)
	{
		if(a[0]==x && a[1]==x && a[2]==x || a[3]==x && a[4]==x && a[5]==x || a[6]==x && a[7]==x && a[8]==x || a[0]==x && a[4]==x && a[8]==x || a[2]==x && a[4]==x && a[6]==x || a[0]==x && a[6]==x && a[3]==x || a[1]==x && a[4]==x && a[7]==x || a[2]==x && a[5]==x && a[8]==x )
		{return true;}
		else
		{return false;}
	}
}