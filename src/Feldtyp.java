
public class Feldtyp {
	private char symbol;

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		if (symbol == '#' || symbol == '*' || symbol == ' ' || symbol == '<' || symbol == '>' || symbol == '^' || symbol == 'v') {
			this.symbol = symbol;
		} else {
			System.out.println("Invalid symbol!");
		}
	}
	
}


