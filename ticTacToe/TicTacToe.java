package ticTacToe;

import java.util.Scanner;

public class TicTacToe {
	
	static Scanner sc = new Scanner(System.in);
	
	//global declaration
	static char Matrix[][] = new char[][] {
        {'1','2','3'},
        {'4','5','6'},
        {'7','8','9'}
      };
      
      
     static char turn ='X';
     static int row;
     static int col;
     static boolean draw=false;

//---------------------------------------------------------------------------------------------------------------------------------------     
     
	public static void display() {
		
		//*********************Title Of Game***************** 
		System.out.println("*****************  TIC_TAC_TOE  *************");
		System.out.println();
	    System.out.println();
		
		
		 //*********************Players and their Symbols*****
         System.out.println("\t\t Player1 -> [X]");
         System.out.println("\t\t Player2 -> [O]");
         System.out.println();
         System.out.println();
		
		 //*********************Structure Of Game*************
         System.out.println("\t\t       |      |       ");
         System.out.println("\t\t   "+Matrix[0][0]+ "   |  "+Matrix[0][1]+ "   |   "+ Matrix[0][2]);
         System.out.println("\t\t ______|______|______ ");
         System.out.println("\t\t       |      |       ");
         System.out.println("\t\t   "+Matrix[1][0]+ "   |  "+Matrix[1][1]+ "   |   "+ Matrix[1][2]);  
         System.out.println("\t\t ______|______|______ ");
         System.out.println("\t\t       |      |       ");
         System.out.println("\t\t   "+Matrix[2][0]+ "   |  "+Matrix[2][1]+ "   |   "+ Matrix[2][2]);
         System.out.println("\t\t       |      |       ");
         System.out.println();
	}
	
//--------------------------------------------------------------------------------------------------------------------------------	
	
	private static void player_turn() {
		// TODO Auto-generated method stub
		
		if(turn=='X')
		{
			//*********************Turn By Turn******************
			System.out.print("Player1[X] Turn: ");
		}
		
		if(turn=='0')
		{
			//*********************Turn By Turn******************
			System.out.print("Player2[0] Turn: ");
		}
		
	
        //*********************take input from user**********
        int choice = sc.nextInt();
        
        
        //*********************case if user input a num other then 1 to 9***
        if(choice<1 || choice>9)
        {
        	System.err.println("Invalid Input");
        }
        
        switch(choice) {
        
        case 1: 
        	row=0;col=0;
        	break;
        	
        case 2: 
        	row=0;col=1;
        	break;
        	
        case 3: 
        	row=0;col=2;
        	break;
        	
        case 4: 
        	row=1;col=0;
        	break;
        	
        case 5: 
        	row=1;col=1;
        	break;
        	
        case 6: 
        	row=1;col=2;
        	break;
        	
        case 7:
        	row=2;col=0;
        	break;
        	
        case 8: 
        	row=2;col=1;
        	break;
        	
        case 9: 
        	row=2;col=2;
        	break;
        
        default:
        	System.out.println("Invalid Input");
        	break;
        }
        
        if(turn=='X' && Matrix[row][col]!='X' && Matrix[row][col]!='0')
        {
        	Matrix[row][col]='X';
        	turn='0';
        }
        else if(turn=='0'&& Matrix[row][col]!='X' && Matrix[row][col]!='0')
        {
        	Matrix[row][col]='0';
        	turn='X';
        }
        else
        {
        	System.out.println("BOX IS ALREADY FILLED");
        	System.out.println("PLS TRY AGAIN ");
        	player_turn();
        }
        display();
   }
	
//---------------------------------------------------------------------------------------------------------------------------
	
	public static boolean gameover() {
        //check win  row-wise and column-wise
		for(int i=0;i<3;i++) 
		{
			if(Matrix[i][0]==Matrix[i][1] && Matrix[i][0]==Matrix[i][2] || Matrix[0][i]==Matrix[1][i] && Matrix[0][i]==Matrix[2][i] )
			{
				return false;
			}
		}
		
		//diagonally check
		if(Matrix[0][0] == Matrix[1][1] && Matrix[0][0] == Matrix[2][2] || Matrix[0][2]==Matrix[1][1] && Matrix[0][2]==Matrix[2][0] )
		{
			return false;
		}
		
		
		
		
		//al boxex are fill or not
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				 if(Matrix[i][j]!='X' && Matrix[i][j]!='0')
				 {
					 return true;
				 }
			}
		}
		
		
		
		//draw
	    draw = true;
		return false;
		
		
		
	}
	
	
//-------------------------------------------------------------------------------------------------------------------------  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(gameover()) {
		display(); //display board
		player_turn();
		gameover();
		
		}
		
		if(turn=='X' && draw == false)
		{
			System.out.println("player2 [0] Wins!!!");
			System.out.println("congratulations");
		}
		else if(turn =='0' && draw==false)
		{
			System.out.println("player1 [X] Wins!!!");
			System.out.println("Congratulations");
		}
		else
		{
			System.out.println("GAME DRAW");
		}
	}
}

//--------------------------------------------------------------------------------------------------------------------------
