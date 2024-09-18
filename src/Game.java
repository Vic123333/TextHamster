import java.util.*;

public class Game {

	public static void main(String[] args) {
		boolean game_is_on = true;
		char user_input;
		Hamster hamster = new Hamster();
		Karte karte = new Karte(hamster);
		
		System.out.println("Hallo, hier die Spielanleitung "
				+ "\n1. Hamster drehen < oder >\n2. Hamster nach vorne bewegen v\n3. 1 Spiel beenden\n4. p Anzahl gefressener Körner ausgeben");
		
		Scanner sc = new Scanner(System.in);

		while (game_is_on) {
			karte.print_karte();
			System.out.print("Eingabe: ");
			user_input = sc.next().charAt(0); //scan for a single char
			System.out.println("");

			switch (user_input) {
			case '<': {
				hamster.turn_left();
				karte.karte_update();
				break;
			}
			case '>': {
				hamster.turn_right();
				karte.karte_update();
				break;	
			}
			case 'v': {
				hamster.go_forwards();
				karte.karte_update();
				break;
			}
			case 'p': {
				hamster.print_counted_grains();
				break;
			}
			case '1': {
				game_is_on = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + user_input);
			}
		}
		sc.close();
		
		
		
	}

}
