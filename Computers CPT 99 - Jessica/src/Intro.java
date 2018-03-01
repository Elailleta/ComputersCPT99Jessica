
public class Intro {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
				int deck[]={1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,12,12,12,12,13,13,13,13};
				int temp[]={52};
				int userc[]={0,0,0};
				int compc[]={0,0,0};
				int comp2c[]={0,0,0};
				int ulives=3;
				int complives=3;
				int comp2lives=3;
				int comp1, comp2;
				int user;
				int players=3;
				int deal;

		System.out.println("Welcome to the card game 99!");
		System.out.println("Here are the rules:");
		System.out.println("1. At the start of the game special cards only amount to their face value");
		System.out.println("Special cards are as follows:");
		System.out.println("1 (ace) = you choose to add 1 or 11 to the pile");
		System.out.println("9 = skips your turn");
		System.out.println("4 = reverse the playing order");
		System.out.println("10 = subtract 10 from the total");
		System.out.println("13 (king) = raise the value to 99 instantly");
		System.out.println("All other cards only add their face value to the deck.");
		System.out.println("2. If you cannot play a card that keeps the value at or under 99 you lose a life");
		System.out.println("3. You have 3 lives");
		System.out.println("4. Last player standing wins, good luck");
		
		System.out.println("The game is starting... Shuffling cards...");
		deck=Methods2.shuffle(deck);
		System.out.println("Dealing the cards...");
		deck=Methods2.deal(userc, compc, comp2c, deck);
		deck=Methods2.play(userc, compc, comp2c, deck);
		
	}
}
