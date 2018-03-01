import java.util.*;
public class Methods2 {
	static int piletotal=0;
	static int topcard=0;
	static Boolean userplayed=false;
	static Boolean compplayed=false;
	static Boolean comp2played=false;
	static int userchoice;
	static int onechoice;
	static int complives=3;
	static int comp2lives=3;
	static int ulives=3;
	static Boolean ufour=false;
	static Boolean compfour=false;
	static Boolean comp2four=false;

	public static int[] shuffle (int deck[]){
		Random rnd=new Random();

		//deal cards
		for (int x=0; x<deck.length; x++){
			//random number from whole length
			int y=rnd.nextInt(52);
			//temp int = num in 1 or 0
			int temp=deck[x];
			//make num at 1 or 0 = to random position
			deck[x]=deck[y];
			//deck at random position = to temp
			deck[y]=temp;

		}
		return deck;
	}
	public static int[] deal(int userc[], int compc[], int comp2c[],int deck[]){
		//dealing cards
		//give the player card at position 0 then increase topcard each time
		piletotal=0;
		topcard=0;
		if (ulives==0){
			System.out.println("User has been eliminated, the game has ended.");
			System.exit(0);
		}if (ulives>0){
			userc[0]=deck[topcard];
			topcard++;
			userc[1]=deck[topcard];
			topcard++;
			userc[2]=deck[topcard];
			topcard++;
		}if (complives>0){
			compc[0]=deck[topcard];
			topcard++;
			compc[1]=deck[topcard];
			topcard++;
			compc[2]=deck[topcard];
			topcard++;
		}if (comp2lives>0){
			comp2c[0]=deck[topcard];
			topcard++;
			comp2c[1]=deck[topcard];
			topcard++;
			comp2c[2]=deck[topcard];
			topcard++;
		}
		piletotal += deck[topcard];
		topcard++;
		System.out.println("The face-up card is: "+piletotal);
		System.out.println("Lets play! Computer 1 plays first.");
		return deck;	
	}

	public static int[] user(int userc[], int compc[], int comp2c[], int deck[] ){
		Scanner in=new Scanner(System.in);
		//user 
		do{
			if ((userc[0]!=4&&userc[1]!=4&&userc[2]!=4)||(userc[0]!=9&&userc[1]!=9&&userc[2]!=9)||(userc[0]!=10&&userc[1]!=10&&userc[2]!=10)||(userc[0]!=13&&userc[1]!=13&&userc[2]!=13)){
				if (piletotal+userc[0]>99&&piletotal+userc[1]>99&&piletotal+userc[2]>99){
					ulives=ulives-1;
					System.out.println("Your cards are "+userc[0]+", "+userc[1]+", "+userc[2]);
					System.out.println("There are no playable cards");
					System.out.println("User has lost a life.");
					System.out.println("Reshuffling and dealing cards now");
					deck=Methods2.shuffle(deck);
					deck=Methods2.deal(userc, compc, comp2c, deck);
					deck=Methods2.play(userc, compc, comp2c, deck);
					//if they have no lives left say theyre out hen go to two players
				}else if (ulives==0){
					System.out.println("User has lost all lives.");
					System.out.println("User has been eliminated, the game has ended.");
					System.exit(0);
				}

				try{
				do{
					System.out.println("Pick a card you want, if you want the first card press one, second press 2, third press 3.");
					System.out.println("Your cards are: "+userc[0]+", "+userc[1]+", "+userc[2]);
					userchoice=in.nextInt();
	
					}while(userchoice!=1&&userchoice!=2&&userchoice!=3);
				}catch ( java.util.InputMismatchException err){
					in.nextLine();
					System.out.println("That was an invalid input.");
				}
				
				//fours
				if (userchoice==1&&userc[0]==4){
					System.out.println("Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					userc[0]=deck[topcard];
					topcard++;
					ufour=true;
					deck=Methods2.userfour(userc, compc, comp2c, deck);
					userplayed=true;
				}

				else if (userchoice==2&&userc[1]==4){
					System.out.println("Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					userc[1]=deck[topcard];
					topcard++;
					ufour=true;
					deck=Methods2.userfour(userc, compc, comp2c, deck);
					userplayed=true;
				}

				else if (userchoice==3&&userc[2]==4){
					System.out.println("Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					userc[2]=deck[topcard];
					topcard++;
					ufour=true;
					deck=Methods2.userfour(userc, compc, comp2c, deck);
					userplayed=true;
				}

				//ones/aces
				else if(userchoice==1&&userc[0]==1){

					//card one 
					try{
					do{
						System.out.println("Would you like to play a 1 or 11? please enter the number below:");
						onechoice=in.nextInt();
					}while (!(onechoice==1||onechoice==11));
					if (onechoice==1){
						piletotal=piletotal+1;
						System.out.println("The current value of the pile is "+piletotal);
						userc[0]=deck[topcard];
						topcard++;
						userplayed=true;
					}if (onechoice==11){
						piletotal=piletotal+11;
						System.out.println("The current value of the pile is "+piletotal);
						userc[0]=deck[topcard];
						topcard++;
						userplayed=true;
					}
					}catch(java.util.InputMismatchException err){
						in.nextLine();
						System.out.println("That was an invalid input.");
					}
					}

				//card 2
				else if(userchoice==2&&userc[1]==1){
					try{
					do{
						System.out.println("Would you like to play a 1 or 11? please enter the number below:");
						onechoice=in.nextInt();
					}while (onechoice!=1||onechoice!=11);
					if (onechoice==1){
						piletotal=piletotal+1;
						System.out.println("The current value of the pile is "+piletotal);
						userc[1]=deck[topcard];
						topcard++;
						userplayed=true;
					}if (onechoice==11){
						piletotal=piletotal+11;
						System.out.println("The current value of the pile is "+piletotal);
						userc[1]=deck[topcard];
						topcard++;
						userplayed=true;
					}
					}catch(java.util.InputMismatchException err){
						in.nextLine();
						System.out.println("That was an invalid input.");
					}
				}

				//card 3
				else if(userchoice==3&&userc[2]==1){
					try{
					do{
						System.out.println("Would you like to play a 1 or 11? please enter the number below:");
						onechoice=in.nextInt();
					}while (onechoice!=1||onechoice!=11);
					if (onechoice==1){
						piletotal=piletotal+1;
						System.out.println("The current value of the pile is "+piletotal);
						userc[2]=deck[topcard];
						topcard++;
						userplayed=true;
					}if (onechoice==11){
						piletotal=piletotal+11;
						System.out.println("The current value of the pile is "+piletotal);
						userc[2]=deck[topcard];
						topcard++;
						userplayed=true;
					}
					}catch (java.util.InputMismatchException err){
						in.nextLine();
						System.out.println("That was an invalid input.");
					}
				}
				//nines
				else if (userchoice==1&&userc[0]==9){
					System.out.println("The curent value of the pile is "+piletotal);
					userc[0]=deck[topcard];
					topcard++;
					userplayed=true;
				}else if (userchoice==2&&userc[1]==9){
					System.out.println("The curent value of the pile is "+piletotal);
					userc[1]=deck[topcard];
					topcard++;
					userplayed=true;
				}else if (userchoice==3&&userc[2]==9){
					System.out.println("The curent value of the pile is "+piletotal);
					userc[2]=deck[topcard];
					topcard++;
					userplayed=true;
				}

				//tens
				else if (userchoice==1&&userc[0]==10){
					piletotal=piletotal-10;
					System.out.println("The curent value of the pile is "+piletotal);
					userc[0]=deck[topcard];
					topcard++;
					userplayed=true;
				}else if (userchoice==2&&userc[1]==10){
					piletotal=piletotal-10;
					System.out.println("The curent value of the pile is "+piletotal);
					userc[1]=deck[topcard];
					topcard++;
					userplayed=true;
				}else if (userchoice==3&&userc[2]==10){
					piletotal=piletotal-10;
					System.out.println("The curent value of the pile is "+piletotal);
					userc[2]=deck[topcard];
					topcard++;
					userplayed=true;
				}

				//kings
				else if (userchoice==1&&userc[0]==13){
					piletotal=99;
					System.out.println("The current value of the pile is "+piletotal);
					userc[0]=deck[topcard];
					topcard++;
					userplayed=true;
				}else if (userchoice==2&&userc[1]==13){
					piletotal=99;
					System.out.println("The current value of the pile is "+piletotal);
					userc[1]=deck[topcard];
					topcard++;
					userplayed=true;
				}else if (userchoice==3&&userc[2]==13){
					piletotal=99;
					System.out.println("The current value of the pile is "+piletotal);
					userc[2]=deck[topcard];
					topcard++;
					userplayed=true;
				}

				else if (userchoice==1){
					piletotal=piletotal+userc[0];
					System.out.println("The current value of the pile "+piletotal);
					userc[0]=deck[topcard];
					topcard++;
					userplayed=true;
				}else if (userchoice==2){
					piletotal=piletotal+userc[1];
					System.out.println("The current value of the pile "+piletotal);
					userc[1]=deck[topcard];
					topcard++;
					userplayed=true;
				}else if (userchoice==3){
					piletotal=piletotal+userc[2];
					System.out.println("The current value of the pile "+piletotal);
					userc[2]=deck[topcard];
					topcard++;
					userplayed=true;
				}

			}else{
				System.out.println("We hit a problem!");
				userplayed=true;
			}

		}while(userplayed==false);
		userplayed=false;

		return deck;
	}

	public static int[] comp(int userc[], int compc[], int comp2c[], int deck[] ){
		if ((compc[0]!=4&&compc[1]!=4&&compc[2]!=4)&&(compc[0]!=9&&compc[1]!=9&&compc[2]!=9)&&(compc[0]!=10&&compc[1]!=10&&compc[2]!=10)&&(compc[0]!=13&&compc[1]!=13&&compc[2]!=13)){
			if (piletotal+compc[0]>99&&piletotal+compc[1]>99&&piletotal+compc[2]>99){
				complives=complives-1;
				System.out.println("The computer had no playable cards");
				System.out.println("Computer 1 has lost a life.");
				System.out.println("Reshuffling and redealing cards now.");
				deck=Methods2.shuffle(deck);
				deck=Methods2.deal(userc, compc, comp2c, deck);
				deck=Methods2.play(userc, compc, comp2c, deck);
				//check to see if they have any lives, if they dont say theyre out then go to two players
			}else if (complives==0){
				System.out.println("Computer 1 has been eliminated, reshuffling and dealing cards now.");
				deck=Methods2.shuffle(deck);
				deck=Methods2.deal(userc, compc, comp2c, deck);
				deck=Methods2.play(userc, compc, comp2c, deck);
			}
		}if (piletotal<80){
			do{
				//make sure they can play, if they cant then subtract a life
					
					//SPECIAL CARDS
					//kings
				if (compc[0]==13){
					piletotal=99;
					System.out.println("The computer played a king");
					System.out.println("The current value of the pile is "+piletotal);
					compc[0]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[1]==13){
					piletotal=99;
					System.out.println("The computer played a king");
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[2]==13){
					piletotal=99;
					System.out.println("The computer played a king");
					System.out.println("The current value of the pile is "+piletotal);
					compc[2]=deck[topcard];
					topcard++;
					compplayed=true;

					//fours
				}else if (compc[0]==4){
					System.out.println("A 4 was played! Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					compc[0]=deck[topcard];
					topcard++;
					compplayed=true;
					compfour=true;
					deck=Methods2.compfour(userc, compc, comp2c, deck);
				}else if (compc[1]==4){
					System.out.println("A 4 was played! Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					compplayed=true;
					compfour=true;
					deck=Methods2.compfour(userc, compc, comp2c, deck);
				}else if (compc[2]==4){
					System.out.println("A 4 was played! Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					compc[2]=deck[topcard];
					topcard++;
					compplayed=true;
					compfour=true;
					deck=Methods2.compfour(userc, compc, comp2c, deck);

					//nines
				}else if (compc[0]==9){
					System.out.println("A 9 was played, skipping the computers turn.");
					System.out.println("The current value of the pile is "+piletotal);
					compc[0]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[1]==9){
					System.out.println("A 9 was played, skipping the computers turn.");
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[2]==9){
					System.out.println("A 9 was played, skipping the computers turn.");
					System.out.println("The current value of the pile is "+piletotal);
					compc[2]=deck[topcard];
					topcard++;
					compplayed=true;

					//ones
				}else if (compc[0]==1){
					piletotal=piletotal+11;
					System.out.println("The computer played an 11.");
					System.out.println("The current value of the pile is "+piletotal);
					compc[0]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[1]==1){
					piletotal=piletotal+11;
					System.out.println("The computer played an 11");
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[2]==1){
					piletotal=piletotal+11;
					System.out.println("The computer played an 11");
					System.out.println("The current value of the pile is "+piletotal);
					compc[2]=deck[topcard];
					topcard++;
					compplayed=true;


					//if no special cards are present then play the highest card while value is less than 80
					//if the first and second or second and third cards are the same play the card that comes first
				}else if(compc[0]==compc[1]){
					piletotal+=compc[0];
					System.out.println("The computer played "+compc[0]);
					System.out.println("The current value of the pile is "+piletotal);
					compc[0]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if(compc[1]==compc[2]){
					piletotal+=compc[1];
					System.out.println("The computer played "+compc[1]);
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if(compc[2]==compc[0]){
					piletotal+=compc[2];
					System.out.println("The computer played "+compc[2]);
					System.out.println("The current value of the pile is "+piletotal);
					compc[2]=deck[topcard];
					topcard++;
					compplayed=true;
			   }else if (compc[0]>compc[1]&&compc[0]>compc[2]){
					piletotal+=compc[0];
					System.out.println("The computer played "+compc[0]);
					System.out.println("The current value of the pile is "+piletotal);
					compc[0]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[1]>compc[0]&&compc[1]>compc[2]){
					piletotal+=compc[1];
					System.out.println("The computer played "+compc[1]);
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[2]>compc[1]&&compc[2]>compc[0]){
					piletotal+=compc[2];
					System.out.println("The computer played "+compc[2]);
					System.out.println("The current value of the pile is "+piletotal);
					compc[2]=deck[topcard];
					topcard++;
					compplayed=true;
				}else{
					System.out.println("We hit a problem!");
					compplayed=true;
				}



			}while(compplayed==false);
			

		}else if (piletotal>=80){
			System.out.println("The pile is bigger than 80");
			do{
				if (compc[0]==13){
					piletotal=99;
					System.out.println("The computer played a king");
					System.out.println("The current value of the pile is "+piletotal);
					compc[0]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[1]==13){
					piletotal=99;
					System.out.println("The computer played a king");
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[2]==13){
					piletotal=99;
					System.out.println("The computer played a king");
					System.out.println("The current value of the pile is "+piletotal);
					compc[2]=deck[topcard];
					topcard++;
					compplayed=true;

				}else if (compc[0]==4){
					System.out.println("The computer played a 4! Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					compc[0]=deck[topcard];
					topcard++;
					compplayed=true;
					compfour=true;
					deck=Methods2.compfour(userc, compc, comp2c, deck);
				}else if (compc[1]==4){
					System.out.println("The computer played a 4! Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					compplayed=true;
					compfour=true;
					deck=Methods2.compfour(userc, compc, comp2c, deck);
				}else if (compc[2]==4){
					System.out.println("The computer played a 4! Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					compc[2]=deck[topcard];
					topcard++;
					compplayed=true;
					compfour=true;
					deck=Methods2.compfour(userc, compc, comp2c, deck);

				}else if (compc[0]==9){
					System.out.println("A 9 was played, skipping the computers turn");
					System.out.println("The current value of the pile is "+piletotal);
					compc[0]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[1]==9){
					System.out.println("A 9 was played, skipping the computers turn");
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[2]==9){
					System.out.println("A 9 was played, skipping the computers turn");
					System.out.println("The current value of the pile is "+piletotal);
					compc[2]=deck[topcard];
					topcard++;
					compplayed=true;

				}else if (compc[0]==10){
					piletotal=piletotal-10;
					System.out.println("The computer played a 10");
					System.out.println("The current value of the pile is "+piletotal);
					compc[0]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[1]==10){
					piletotal=piletotal-10;
					System.out.println("The computer played a 10");
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[2]==10){
					piletotal=piletotal-10;
					System.out.println("The computer played a 10");
					System.out.println("The current value of the pile is "+piletotal);
					compc[2]=deck[topcard];
					topcard++;
					compplayed=true;


				}else if (compc[0]==1){
					piletotal=piletotal+1;
					System.out.println("The computer played a 1");
					System.out.println("The current value of the pile is "+piletotal);
					compc[0]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[1]==1){
					piletotal=piletotal+1;
					System.out.println("The computer played a 1");
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[2]==1){
					piletotal=piletotal+1;
					System.out.println("The computer played a 1");
					System.out.println("The current value of the pile is "+piletotal);
					compc[2]=deck[topcard];
					topcard++;
					compplayed=true;



				}else if(compc[0]==compc[1]){
					piletotal+=compc[0];
					System.out.println("The computer played "+compc[0]);
					System.out.println("The current value of the pile is "+piletotal);
					compc[0]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if(compc[1]==compc[2]){
					piletotal+=compc[1];
					System.out.println("The computer played "+compc[1]);
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if(compc[2]==compc[0]){
					piletotal+=compc[2];
					System.out.println("The computer played "+compc[2]);
					System.out.println("The current value of the pile is "+piletotal);
					compc[2]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[0]<compc[1]&&compc[0]<compc[2]){
					piletotal+=compc[0];
					System.out.println("The computer played "+compc[0]);
					System.out.println("The current value of the pile is "+piletotal);
					compc[0]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[1]<compc[0]&&compc[1]<compc[2]){
					piletotal+=compc[1];
					System.out.println("The computer played "+compc[1]);
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					compplayed=true;
				}else if (compc[2]<compc[1]&&compc[2]<compc[0]){
					piletotal+=compc[2];
					System.out.println("The computer played "+compc[2]);
					System.out.println("The current value of the pile is "+piletotal);
					compc[2]=deck[topcard];
					topcard++;
					compplayed=true;
				}else{
					System.out.println("We hit a problem!");
					compplayed=true;
				}



			}while(compplayed==false);
			
		}
		compplayed=false;
		System.out.println("cpu1 just finished his method");

		return deck;
	}


	public static int[] comp2(int userc[], int compc[], int comp2c[], int deck[] ){
		if ((comp2c[0]!=4&&comp2c[1]!=4&&comp2c[2]!=4)||(comp2c[0]!=9&&comp2c[1]!=9&&comp2c[2]!=9)||(comp2c[0]!=10&&comp2c[1]!=10&&comp2c[2]!=10)||(comp2c[0]!=13&&comp2c[1]!=13&&comp2c[2]!=13)){
			if (piletotal+comp2c[0]>99&&piletotal+comp2c[1]>99&&piletotal+comp2c[2]>99){
				comp2lives=comp2lives-1;
				System.out.println("There was no playable cards.");
				System.out.println("Computer 2 has lost a life.");
				System.out.println("Reshuffling and dealing cards now");
				deck=Methods2.shuffle(deck);
				deck=Methods2.deal(userc, compc, comp2c, deck);
				deck=Methods2.play(userc, compc, comp2c, deck);
				//if they have no lives left say theyre out hen go to two players
			}else if (comp2lives==0){
				System.out.println("Computer 2 has been eliminated, reshuffling and dealing cards now.");
				deck=Methods2.shuffle(deck);
				deck=Methods2.deal(userc, compc, comp2c, deck);
				deck=Methods2.play(userc, compc, comp2c, deck);
			}
		}if (piletotal<80){
			do{
				//check to see if they can play, if they cant then subtract a life
				if (comp2c[0]==13){
					piletotal=99;
					System.out.println("The computer 2 played a king");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[0]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[1]==13){
					piletotal=99;
					System.out.println("The computer 2 played a king");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[1]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[2]==13){
					piletotal=99;
					System.out.println("The computer 2 plaued a king");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[2]=deck[topcard];
					topcard++;
					comp2played=true;

					//fours
				}else if (comp2c[0]==4){
					System.out.println("The computer 2 played a 4! Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[0]=deck[topcard];
					topcard++;
					comp2played=true;
					comp2four=true;
					deck=Methods2.comp2four(userc, compc, comp2c, deck);
				}else if (comp2c[1]==4){
					System.out.println("The computer 2 played a 4! Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[1]=deck[topcard];
					topcard++;
					comp2played=true;
					comp2four=true;
					deck=Methods2.comp2four(userc, compc, comp2c, deck);
				}else if (comp2c[2]==4){
					System.out.println("The computer 2 played a 4! Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[2]=deck[topcard];
					topcard++;
					comp2played=true;
					comp2four=true;
					deck=Methods2.comp2four(userc, compc, comp2c, deck);

					//nines
				}else if (comp2c[0]==9){
					System.out.println("A 9 was played, skipping the computers 2 turn");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[0]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[1]==9){
					System.out.println("A 9 was played, skipping the computers 2 turn");
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[2]==9){
					System.out.println("A 9 was played, skipping the computers 2 turn");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[2]=deck[topcard];
					topcard++;
					comp2played=true;

					//ones
				}else if (comp2c[0]==1){
					piletotal=piletotal+11;
					System.out.println("The computer 2 played an 11");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[0]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[1]==1){
					piletotal=piletotal+11;
					System.out.println("The computer 2 played an 11");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[1]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[2]==1){
					piletotal=piletotal+11; 
					System.out.println("The computer 2 played an 11");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[2]=deck[topcard];
					topcard++;
					comp2played=true;




				}else if(comp2c[0]==comp2c[1]){
					piletotal+=comp2c[0];
					System.out.println("The computer 2 played "+comp2c[0]);
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[0]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if(comp2c[1]==comp2c[2]){
					piletotal+=comp2c[1];
					System.out.println("The computer 2 played "+comp2c[1]);
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[1]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if(comp2c[2]==comp2c[0]){
					piletotal+=comp2c[2];
					System.out.println("The computer 2 played "+comp2c[2]);
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[2]=deck[topcard];
					topcard++;
					comp2played=true;
				}

				//if no special cards are present play the highest card while value is less than 80
				else if (comp2c[0]>comp2c[1]&&comp2c[0]>comp2c[2]){
					piletotal+=comp2c[0];
					System.out.println("The computer 2 played "+comp2c[0]);
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[0]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[1]>comp2c[0]&&comp2c[1]>comp2c[2]){
					piletotal+=comp2c[1];
					System.out.println("The computer 2 played "+comp2c[1]);
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[1]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[2]>comp2c[1]&&comp2c[2]>comp2c[0]){
					piletotal+=comp2c[2];
					System.out.println("The computer 2 played "+comp2c[2]);
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[2]=deck[topcard];
					topcard++;
					comp2played=true;
				}else{
					System.out.println("We hit a problem!");
					comp2played=true;
				}
			}while(comp2played==false);
		
		}else if (piletotal>=80){
			System.out.println("The pile is bigger than 80");
			do{

				//comp2
				if (comp2c[0]==13){
					piletotal=99;
					System.out.println("The computer 2 played a king");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[0]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[1]==13){
					piletotal=99;
					System.out.println("The computer 2 played a king");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[1]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[2]==13){
					piletotal=99;
					System.out.println("The computer 2 played a king");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[2]=deck[topcard];
					topcard++;
					comp2played=true;

				}else if (comp2c[0]==4){
					System.out.println("The computer 2 played a 4! Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[0]=deck[topcard];
					topcard++;
					comp2played=true;
					comp2four=true;
					deck=Methods2.comp2four(userc, compc, comp2c, deck);
				}else if (comp2c[1]==4){
					System.out.println("The computer 2 played a 4! Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[1]=deck[topcard];
					topcard++;
					comp2played=true;
					comp2four=true;
					deck=Methods2.comp2four(userc, compc, comp2c, deck);
				}else if (comp2c[2]==4){
					System.out.println("The computer 2 played a 4! Reversing the order!");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[2]=deck[topcard];
					topcard++;
					comp2played=true;
					comp2four=true;
					deck=Methods2.comp2four(userc, compc, comp2c, deck);

				}else if (comp2c[0]==9){
					System.out.println("A 9 was played, skipping the computers 2 turn");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[0]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[1]==9){
					System.out.println("A 9 was played, skipping the computers 2 turn");
					System.out.println("The current value of the pile is "+piletotal);
					compc[1]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[2]==9){
					System.out.println("A 9 was played, skipping the computers 2 turn");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[2]=deck[topcard];
					topcard++;
					comp2played=true;

				}else if (comp2c[0]==10){
					piletotal=piletotal-10;
					System.out.println("The computer 2 played a 10");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[0]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[1]==10){
					piletotal=piletotal-10;
					System.out.println("The computer 2 played a 10");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[1]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[2]==10){
					piletotal=piletotal-10;
					System.out.println("The computer 2 played a 10");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[2]=deck[topcard];
					topcard++;
					comp2played=true;


				}else if (comp2c[0]==1){
					piletotal=piletotal+1;
					System.out.println("The computer 2 played a 1");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[0]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[1]==1){
					piletotal=piletotal+1;
					System.out.println("The computer 2 played a 1");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[1]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[2]==1){
					piletotal=piletotal+1;
					System.out.println("The computer 2 played a 1");
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[2]=deck[topcard];
					topcard++;
					comp2played=true;



				}else if(comp2c[0]==comp2c[1]){
					piletotal+=comp2c[0];
					System.out.println("The computer 2 played "+comp2c[0]);
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[0]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if(comp2c[1]==comp2c[2]){
					piletotal+=comp2c[1];
					System.out.println("The computer 2 played "+comp2c[1]);
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[1]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if(comp2c[2]==comp2c[0]){
					piletotal+=comp2c[2];
					System.out.println("The computer 2 played "+comp2c[2]);
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[2]=deck[topcard];
					topcard++;
					comp2played=true;
				}

				else if (comp2c[0]<comp2c[1]&&comp2c[0]<comp2c[2]){
					piletotal+=comp2c[0];
					System.out.println("The computer played "+compc[0]);
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[0]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[1]<comp2c[0]&&comp2c[1]<comp2c[2]){
					piletotal+=comp2c[1];
					System.out.println("The computer played "+compc[1]);
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[1]=deck[topcard];
					topcard++;
					comp2played=true;
				}else if (comp2c[2]<comp2c[1]&&comp2c[2]<comp2c[0]){
					piletotal+=comp2c[2];
					System.out.println("The computer played "+compc[2]);
					System.out.println("The current value of the pile is "+piletotal);
					comp2c[2]=deck[topcard];
					topcard++;
					comp2played=true;
				}else{
					System.out.println("We hit a problem!");
					comp2played=true;
				}
			}while(comp2played==false);
		}
		comp2played=false;
		System.out.println("cpu2 just finished his method");
		return deck;
	}

	
	//play
	public static int[] play(int userc[], int compc[], int comp2c[], int deck[] ){
		
		if(ulives>0&&complives>0&&comp2lives>0){
		do{
			System.out.println("user:"+ulives+" comp:"+complives+" comp2:"+comp2lives);
			//comp
			deck=Methods2.comp(userc, compc, comp2c, deck);
			System.out.println("");
			//comp2
			deck=Methods2.comp2(userc, compc, comp2c, deck);
			System.out.println("");
			//user
			deck=Methods2.user(userc, compc, comp2c, deck);
			System.out.println("");
		}while(ulives>0&&complives>0&&comp2lives>0);
		}
		if (complives==0){
			do{
				System.out.println("user:"+ulives+" comp:"+comp2lives);
				//comp2
				deck=Methods2.comp2(userc, compc, comp2c, deck);
				//user
				deck=Methods2.user(userc, compc, comp2c, deck);
			}while (ulives>0&&comp2lives>0);
		}
		if (comp2lives==0){
			do{
				System.out.println("user:"+ulives+" comp:"+complives);
				//comp
				deck=Methods2.comp(userc, compc, comp2c, deck);
				//user
				deck=Methods2.user(userc, compc, comp2c, deck);
			}while(ulives>0&&complives>0);
		}
		return deck;	
	}

	
	//comp four
	public static int[] compfour(int userc[], int compc[], int comp2c[], int deck[] ){
		//if all have 3 lives
		ufour=false;
		compfour=false;
		comp2four=false;
		if (ulives>0&&complives>0&&comp2lives>0){
		do{
			System.out.println("user:"+ulives+" comp:"+complives+" comp2:"+comp2lives);
			//user
			deck=Methods2.user(userc, compc, comp2c, deck);
			if (ufour==true){
				ufour=false;
				deck=Methods2.play(userc, compc, comp2c, deck);
			}
			//comp2
			deck=Methods2.comp2(userc, compc, comp2c, deck);
			if (comp2four==true){
				comp2four=false;
				deck=Methods2.comp2four2(userc, compc, comp2c, deck);
			}
			//comp
			deck=Methods2.comp(userc, compc, comp2c, deck);
			if (compfour==true){
				compfour=false;
				deck=Methods2.compfour2(userc, compc, comp2c, deck);
			}
		}while(ulives>0&&complives>0&&comp2lives>0);
		}
		//if comp loses
		if (complives==0){
			do{
				System.out.println("user:"+ulives+" comp2:"+comp2lives);
				//user
				deck=Methods2.user(userc, compc, comp2c, deck);
				if (ufour==true){
					ufour=false;
					deck=Methods2.play(userc, compc, comp2c, deck);
				}
				//comp2
				deck=Methods2.comp2(userc, compc, comp2c, deck);
				if (comp2four==true){
					comp2four=false;
					deck=Methods2.comp2four2(userc, compc, comp2c, deck);
				}
			}while(ulives>0&&comp2lives>0);
			//if comp 2 loses
		}if (comp2lives==0){
			do{
				System.out.println("user:"+ulives+" comp:"+complives);
				//user
				deck=Methods2.user(userc, compc, comp2c, deck);
				if (ufour==true){
					ufour=false;
					deck=Methods2.play(userc, compc, comp2c, deck);
				}
				//comp
				deck=Methods2.comp(userc, compc, comp2c, deck);
				if (compfour==true){
					compfour=false;
					deck=Methods2.compfour2(userc, compc, comp2c, deck);
				}

			}while(ulives>0&&complives>0);
		}
		return deck;
	}

	
	//comp 2 four
	public static int[] comp2four(int userc[], int compc[], int comp2c[], int deck[] ){
		//if all have 3 lives
		ufour=false;
		compfour=false;
		comp2four=false;

		if (ulives>0&&complives>0&&comp2lives>0){
		do{
			System.out.println("user:"+ulives+" comp:"+complives+" comp2:"+comp2lives);
			//comp
			deck=Methods2.comp(userc, compc, comp2c, deck);
			if (compfour==true){
				compfour=false;
				deck=Methods2.compfour2(userc, compc, comp2c, deck);
			}
			//user
			deck=Methods2.user(userc, compc, comp2c, deck);
			if (ufour==true){
				ufour=false;
				deck=Methods2.play(userc, compc, comp2c, deck);
			}
			//comp2
			deck=Methods2.comp2(userc, compc, comp2c, deck);
			if (comp2four==true){
				comp2four=false;
				deck=Methods2.comp2four2(userc, compc, comp2c, deck);
			}
		}while(ulives>0&&complives>0&&comp2lives>0);
		}
		// if comp loses
		if (complives==0){
			do{
				System.out.println("user:"+ulives+" comp2:"+comp2lives);
				//user
				deck=Methods2.user(userc, compc, comp2c, deck);
				if (ufour==true){
					ufour=false;
					deck=Methods2.play(userc, compc, comp2c, deck);
				}
				//comp2
				deck=Methods2.comp2(userc, compc, comp2c, deck);
				if (comp2four==true){
					comp2four=false;
					deck=Methods2.comp2four2(userc, compc, comp2c, deck);
				}
			}while(ulives>0&&comp2lives>0);
			//if comp 2 loses
		}if (comp2lives==0){
			do{
				System.out.println("user:"+ulives+" comp:"+complives);
				//comp
				deck=Methods2.comp(userc, compc, comp2c, deck);
				if (compfour==true){
					compfour=false;
					deck=Methods2.compfour2(userc, compc, comp2c, deck);
				}
				//user
				deck=Methods2.user(userc, compc, comp2c, deck);
				if (ufour==true){
					ufour=false;
					deck=Methods2.play(userc, compc, comp2c, deck);
				}
			}while(ulives>0&&complives>0);
		}
		return deck;
	}


	//user four
	public static int[] userfour(int userc[], int compc[], int comp2c[], int deck[] ){
		ufour=false;
		compfour=false;
		comp2four=false;
		//if all have 3 lives
		if (ulives>0&&complives>0&&comp2lives>0){
		do{
			System.out.println("user:"+ulives+" comp:"+complives+" comp2:"+comp2lives);
			//comp2
			deck=Methods2.comp2(userc, compc, comp2c, deck);
			if (comp2four==true){
				compfour=false;
				deck=Methods2.comp2four2(userc, compc, comp2c, deck);
			}
			//comp
			deck=Methods2.comp(userc, compc, comp2c, deck);
			if (compfour==true){
				compfour=false;
				deck=Methods2.compfour2(userc, compc, comp2c, deck);
			}
			//user
			deck=Methods2.user(userc, compc, comp2c, deck);
			if (ufour==true){
				ufour=false;
				deck=Methods2.play(userc, compc, comp2c, deck);
			}
		}while(ulives>0&&complives>0&&comp2lives>0);
		}
		// if comp loses
		if (complives==0){
			do{
				System.out.println("user:"+ulives+" comp2:"+comp2lives);
				//comp2
				deck=Methods2.comp2(userc, compc, comp2c, deck);
				if (comp2four==true){
					comp2four=false;
					deck=Methods2.comp2four2(userc, compc, comp2c, deck);
				}
				//user
				deck=Methods2.user(userc, compc, comp2c, deck);
				if (ufour==true){
					ufour=false;
					deck=Methods2.play(userc, compc, comp2c, deck);
				}
			}while(ulives>0&&comp2lives>0);
			//if comp 2 loses
		}if (comp2lives==0){
			do{
				System.out.println("user:"+ulives+" comp:"+complives);
				//comp
				deck=Methods2.comp(userc, compc, comp2c, deck);
				if (compfour==true){
					compfour=false;
					deck=Methods2.compfour2(userc, compc, comp2c, deck);
				}
				//user
				deck=Methods2.user(userc, compc, comp2c, deck);
				if (ufour==true){
					ufour=false;
					deck=Methods2.play(userc, compc, comp2c, deck);
				}
			}while(ulives>0&&complives>0);
		}
		return deck;
	}


	//comp four 2
	public static int[] compfour2(int userc[], int compc[], int comp2c[], int deck[] ){
		compfour=false;
		comp2four=false;
		ufour=false;
		//while all have 3 lives
		if (ulives>0&&complives>0&&comp2lives>0){
		do{
			System.out.println("user:"+ulives+" comp:"+complives+" comp2:"+comp2lives);
			//comp2
			deck=Methods2.comp2(userc, compc, comp2c, deck);
			if (comp2four==true){
				comp2four=false;
				deck=Methods2.comp2four(userc, compc, comp2c, deck);
			}
			//user
			deck=Methods2.user(userc, compc, comp2c, deck);
			if (ufour==true){
				ufour=false;
				deck=Methods2.play(userc, compc, comp2c, deck);
			}
			//comp
			deck=Methods2.comp(userc, compc, comp2c, deck);
			if (compfour==true){
				compfour=false;
				deck=Methods2.compfour(userc, compc, comp2c, deck);
			}
		}while(ulives>0&&complives>0&&comp2lives>0);
		}
		//if comp dies
		if (complives==0){
			do{
				System.out.println("user:"+ulives+" comp2:"+comp2lives);
				//comp2
				deck=Methods2.comp2(userc, compc, comp2c, deck);
				if (comp2four==true){
					comp2four=false;
					deck=Methods2.comp2four(userc, compc, comp2c, deck);
				}
				//user
				deck=Methods2.user(userc, compc, comp2c, deck);
				if (ufour==true){
					ufour=false;
					deck=Methods2.play(userc, compc, comp2c, deck);
				}
			}while(ulives>0&&comp2lives>0);
		}
		//if comp 2 dies
		if (comp2lives==0){
			do{
				System.out.println("user:"+ulives+" comp:"+complives);
				//user 
				deck=Methods2.user(userc, compc, comp2c, deck);
				if (ufour==true){
					ufour=false;
					deck=Methods2.play(userc, compc, comp2c, deck);
				}
				//comp
				deck=Methods2.comp(userc, compc, comp2c, deck);
				if (compfour==true){
					compfour=false;
					deck=Methods2.compfour(userc, compc, comp2c, deck);
				}
			}while(ulives>0&&complives>0);
		}
		return deck;
	}

	
	//comp 2 four 2
	public static int[] comp2four2(int userc[], int compc[], int comp2c[], int deck[] ){
		ufour=false;
		compfour=false;
		comp2four=false;
		//while all three have 3 lives
		if (ulives>0&&complives>0&&comp2lives>0){
		do{
			System.out.println("user:"+ulives+" comp:"+complives+" comp2:"+comp2lives);
			//user
			deck=Methods2.user(userc, compc, comp2c, deck);
			if (ufour==true){
				ufour=false;
				deck=Methods2.play(userc, compc, comp2c, deck);
			}
			//comp
			deck=Methods2.comp(userc, compc, comp2c, deck);
			if (compfour==true){
				compfour=false;
				deck=Methods2.compfour(userc, compc, comp2c, deck);
			}
			//comp2
			deck=Methods2.comp2(userc, compc, comp2c, deck);
			if (comp2four==true){
				comp2four=false;
				deck=Methods2.comp2four(userc, compc, comp2c, deck);
			}

		}while(ulives>0&&complives>0&&comp2lives>0);
		}
if (complives==0){
		//if comp dies
		do{
			System.out.println("user:"+ulives+" comp2:"+comp2lives);
			//user
			deck=Methods2.user(userc, compc, comp2c, deck);
			if (ufour==true){
				ufour=false;
				deck=Methods2.play(userc, compc, comp2c, deck);
			}
			//comp2
			deck=Methods2.comp2(userc, compc, comp2c, deck);
			if (comp2four==true){
				comp2four=false;
				deck=Methods2.comp2four(userc, compc, comp2c, deck);
			}
		}while(ulives>0&&comp2lives>0);
}
		if (comp2lives==0){
		//if comp 2 dies
		do{
			System.out.println("user:"+ulives+" comp:"+complives);
			//user
			deck=Methods2.user(userc, compc, comp2c, deck);
			if (ufour==true){
				ufour=false;
				deck=Methods2.play(userc, compc, comp2c, deck);
			}
			//comp
			deck=Methods2.comp(userc, compc, comp2c, deck);
			if (compfour==true){
				compfour=false;
				deck=Methods2.compfour(userc, compc, comp2c, deck);
			}
		}while(ulives>0&&complives>0);
		}
		return deck;
	}
}
