import java.util.*;

public class Karte {
	private int height = 15;
	private int length = 11;
	private int[][] position = new int[2][1];
    private Feldtyp[][] myArray = new Feldtyp[height][length];
    private Hamster hamster;

	
	public Karte(Hamster hamster) {
		this.hamster = hamster;
		generateRandomPlayground();
		create_player();
	}
	
	public Karte() { //Overload the constructor when no input is used
		generateRandomPlayground();
	}
	
	public void print_karte() {
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < length; column++) {
				System.out.print(myArray[row][column].getSymbol());
			}
			System.out.println();
			
		}
	}
	
	private void generateRandomPlayground() {
	    char[] symbols = {'#', ' ', '*', ' ', ' '};

	    for (int row = 0; row < height; row++) {
	        for (int col = 0; col < length; col++) {
	            char symbol = symbols[(int) (Math.random() * symbols.length)];

	            if (row == 0 || row == height - 1 || col == 0 || col == length - 1) {
	                symbol = '#';
	            }

	            myArray[row][col] = new Feldtyp();
	            myArray[row][col].setSymbol(symbol);
	        }
	    }
	}
	
	public void create_player() {
		boolean is_on = true;
        Random rand = new Random();
        int random_x;
        int random_y;
        
		while (is_on) {
			random_y = rand.nextInt(14); // create a random position for the player
			random_x = rand.nextInt(10);
			position[0][0] = random_y;
			position[1][0] = random_x;
			if (myArray[position[0][0]][position[1][0]].getSymbol() == ' ') {
				is_on = false;
			}

		}
		hamster.setPosition(position); //set the position to the hamster
		myArray[position[0][0]][position[1][0]].setSymbol(hamster.getFeldtyp().getSymbol()); //set the position to the map

	}
	
	public void karte_update() {
		if (position[0][0] == hamster.getPosition()[0][0] && position[1][0] == hamster.getPosition()[1][0]) { // Check that no changes have been made to the position
			myArray[position[0][0]][position[1][0]].setSymbol(hamster.getFeldtyp().getSymbol());

		} else if (position[0][0] != hamster.getPosition()[0][0] || position[1][0] != hamster.getPosition()[1][0]) { //check the destination of the move 
			if (myArray[hamster.getPosition()[0][0]][hamster.getPosition()[1][0]].getSymbol() == '#') {
				hamster.setPosition(position);
				System.out.println("You can't go there!");
			} else if (myArray[hamster.getPosition()[0][0]][hamster.getPosition()[1][0]].getSymbol() == '*') {
				hamster.count_grains();
				System.out.println("Du hast einen Korn gefressen :D! " + hamster.getGrains());
				if (hamster.getGrains() > 10) {
					System.out.println("Du hast den Rekord des Erstellers übertroffen. Weiter so!");
				}
				myArray[position[0][0]][position[1][0]].setSymbol(' ');
				position[0][0] = hamster.getPosition()[0][0];
				position[1][0] = hamster.getPosition()[1][0];
				myArray[position[0][0]][position[1][0]].setSymbol(hamster.getFeldtyp().getSymbol());
			} else if (myArray[hamster.getPosition()[0][0]][hamster.getPosition()[1][0]].getSymbol() == ' ') {
				myArray[position[0][0]][position[1][0]].setSymbol(' ');
				position[0][0] = hamster.getPosition()[0][0];
				position[1][0] = hamster.getPosition()[1][0];
				myArray[position[0][0]][position[1][0]].setSymbol(hamster.getFeldtyp().getSymbol());
			}

		}
		
	}
	
}
