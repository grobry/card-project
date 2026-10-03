import java.util.Scanner;

	public class Menu {
		public static void main(String[] args) {
		int choice=99;
		
		Cards thisDeck = new Cards();
		Game thisGame = new Game();
		
		while(choice != 3)
		{
			choice = menu();
			switch(choice) 
			{
				case 1: thisGame.playerMain();
				break;
				case 2: thisGame.rules();
				break;
				case 3: System.out.println("Ending program...");
						System.exit(0);
				break;
			}
		  }
		}
		public static int menu() {	
			Scanner sc = new Scanner(System.in);
				int choice = 99;
			System.out.println("\n\t\t\tMenu:");
			System.out.println("------------------------------------------------------");
			System.out.println("\n\t\t    1. Play Game\n" +
							   "\t\t    2. View Rules\n" +
				               "\t\t    3. Exit\n");
			System.out.println("------------------------------------------------------");

			System.out.println("Enter a choice: ");
			System.out.println(); 
			choice = sc.nextInt();
			return choice;
				}
		}

