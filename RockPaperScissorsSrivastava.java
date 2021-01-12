//imports JFrame and graphics
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*; 
import javax.swing.*;

public class RockPaperScissorsSrivastava {

//declares variable for player wins
	static int humanWon;
//initializes variables for wins, losses, and ties at 0
	static int win=0;
   static int loss=0;
	static int total=0;
	static int tie=0;
//opens introduction to the game and game window
	public static void main(String[] args)
   {
		gamePanel();
		introductionPanel();
	}
//gives player instructions to how to play
	private static void introductionPanel(){
		String text="This game is super easy and you should know how to play it. Here's how to play in case you live under a cave and don't know:\nRock crushes scissors.\nScissors cuts paper.\nPaper covers rock.\nAyurv is bad at this game so please don't have him play";
		JOptionPane.showMessageDialog(null,text, "Welcome to Rock Paper Scissors!", 0, new ImageIcon(System.getProperty("user.dir")+"/image/5.gif"));
	}
//carries contents of the main game
	private static void gamePanel(){
//Frame of main game
		JFrame game = new JFrame("ROCK PAPER SCISSORS SHOOT"); 
//allows buttons to have custom location
		Container panel = game.getContentPane(); 		
      panel.setLayout(null); 
//creates icon string name
		String[] iconString= new String[3]; 
      		int[] boundInt= new int[3];
            //creates conditions for numbers used in game
		for(int i=0; i<=2; i++){ 			
      iconString[i]=System.getProperty("user.dir")+"/image/"+i+".jpg";
			boundInt[i]=40+150*i;
		}
//Sets rock button with color and location
		JButton Rock = new JButton ("Rock", new ImageIcon(iconString[0]));
		Rock.setBackground(Color.GREEN);
		Rock.setBounds(40,boundInt[0],150,100);

//Sets paper button with color, location, and size
		JButton Paper = new JButton ("Paper", new ImageIcon(iconString[1]));
		Paper.setBackground(Color.GREEN);
		Paper.setBounds(40,boundInt[1],150,100);

//Sets scissors button with color, location, and size
		JButton Scissors = new JButton ("Scissors", new ImageIcon(iconString[2]));
		Scissors.setBackground(Color.GREEN);
		Scissors.setBounds(40,boundInt[2],150,100);//creating three buttons

		
//Sets score button with position and size
		JButton Scores = new JButton("Scores");
		Scores.setBounds(350, 430, 80, 30);
//Sets quit button with position and size
		JButton Quit = new JButton("Quit");
		Quit.setBounds(260, 430, 80, 30);
//Adds all buttons into the main game panel
		panel.add(Rock);
		panel.add(Paper);
		panel.add(Scissors);
		panel.add(Scores);
		panel.add(Quit);
//Calculates win if rock button is clicked
		Rock.addActionListener( 				
            new ActionListener() {
					public void actionPerformed( ActionEvent event ) {
						computeWinner(1);
					}
				}
		);
//Calculates win if paper button is clicked
		Paper.addActionListener(

				new ActionListener() {
					public void actionPerformed( ActionEvent event ) {
						computeWinner(2);
					}
				}
		);
//Calculates win if scissors button is clicked
		Scissors.addActionListener(

				new ActionListener() {
					public void actionPerformed( ActionEvent event ) {
						computeWinner(3);
					}
				}
		);
//Lists scores with wins, ties, and attempts if scores button is clicked
		Scores.addActionListener(

				new ActionListener() {
					public void actionPerformed( ActionEvent event ) {
						win=win;
 						total=total;
                  tie=tie;

						JOptionPane.showMessageDialog(null,"Scores:"+"\nWins: " + win+"\nTie: "+tie+"\nTotal: " + total,"Cheater!", 0, new ImageIcon(System.getProperty("user.dir")+"/image/4.jpg"));

					}
				}
		);
//If quit button is clicked, gives goodbye message
		Quit.addActionListener( //quit the game and show three beat up guys

				new ActionListener() {
					public void actionPerformed( ActionEvent event ) {
						String text="Paper: Thank goodness you stop playing!\nThe rock keep trying to break free\n and the scissors keep cutting me!\nRock: Let me out!\nScissors: Dang rock! Snip snip.\n\nAyurv: Thank you for playing and I have\ntake these guys to the hospital now.";
						JOptionPane.showMessageDialog(null,text, "Thank you for playing!", 0, new ImageIcon(System.getProperty("user.dir")+"/image/6.gif"));
						System.exit(0);
					}
				}
		);
//sets size of secondary JFrame window that shows after each turn
		game.setSize(500, 500); 
		game.setVisible(true); 
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
   //assigns computer a variable at random that symbolizes the rock, paper, or scissors
public static int computerRandomChoice(){
		int result=(int)(Math.random()*3)+1;		
		return result;
	}
   //computes winner by adding minimum value between the human and computer with the maximum value
	public static void computeWinner(int x){
		int computerChoice=computerRandomChoice();
		int humanChoice=x;
		String text,text1="";
		String winningCombination= ""+Math.min(computerChoice, humanChoice)+Math.max(computerChoice, humanChoice);
//switches button with value to symbolize rock, paper, or scissors depending on what button the player pressed
		switch(Integer.parseInt(winningCombination)){
//case if player clicked paper
		case 12:
			text = "Paper wins!";
			if(humanChoice==2) humanWon=1;
			break;
         //case if player clicked rock
		case 13:
			text = "Rock wins!";
			if(humanChoice==1) humanWon=1;
			break;
         //case if player clicked scissors
		case 23:
			text = "Scissors wins!";
			if(humanChoice==3) humanWon=1;
			break;
		default: text="It is a tie!";
		humanWon=2;
		tie=tie+1;
		}
//if the winning combination is 1, the player won
		if(humanWon==1){
			text1="Human wins!  ";
			humanWon=0;
			win=win+1;
			total=total+1;
		}
      //if winning combination is 2, it is a tie
      else if(humanWon==2){
			text1="It is a tie!  ";
			humanWon=0;		
		}
      //if the winning combination is 3, the computer won
      else{
			text1="Computer wins!  ";
			total=total+1;

		}

//Gives boundaries of pop up window that appears every time a round is played
		JFrame game = new JFrame("ROCK PAPER SCISSORS SHOOT"); 
		Container panel = game.getContentPane(); 
		panel.setLayout(null); 


		JLabel l0 = new JLabel(text1+text);
		l0.setBounds(75, 10, 300, 35);
		panel.add(l0);


//Tells player his or her choice
		JLabel Human = new JLabel("Your Choice: " +humanChoice);
		Human.setBounds(40, 35, 150, 35);
		panel.add(Human);
//Tells player computer's choice
		JLabel Computer = new JLabel("Computer's Choice " +computerChoice);
		Computer.setBounds(215, 35, 150, 35);
		panel.add(Computer);

//Tells player total wins
		JLabel Win = new JLabel("Wins: " + win);
		Win.setBounds(125, 25, 150, 350);
		panel.add(Win);
//Tells Player total ties
      JLabel Tie = new JLabel("Ties: "+ tie);
		Tie.setBounds(125, 30, 125, 370);
		panel.add(Tie);
//Tells player total attempts
      JLabel Total = new JLabel("Attempts: "+ total);
		Total.setBounds(130, 35, 110, 390);
		panel.add(Total);

//Sets size of main game
		game.setSize(400, 270); 
		game.setVisible(true); 		



	}

	

}