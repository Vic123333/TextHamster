
public class Hamster {
	private Feldtyp feldtyp;
	private int grains = 0;
	private int[][] position = new int[2][1];
	
	
	public Feldtyp getFeldtyp() {
		return feldtyp;
	}

	public void setFeldtyp(Feldtyp feldtyp) {
		this.feldtyp = feldtyp;
	}

	public int getGrains() {
		return grains;
	}

	public void setGrains(int grains) {
		this.grains = grains;
	}

	public int[][] getPosition() {
		return position;
	}

	public void setPosition(int[][] position) {
		this.position[0][0] = position[0][0];
		this.position[1][0] = position[1][0];
	}

	public Hamster() {
		this.feldtyp = new Feldtyp();
		this.feldtyp.setSymbol('>');
	}
	
	public void turn_left() {
		if (getFeldtyp().getSymbol() == '<') {
			this.feldtyp.setSymbol('v');
			setFeldtyp(feldtyp);
		} else if (getFeldtyp().getSymbol() == '^') {
			this.feldtyp.setSymbol('<');
			setFeldtyp(feldtyp);
		} else if (getFeldtyp().getSymbol() == '>') {
			this.feldtyp.setSymbol('^');
			setFeldtyp(feldtyp);
		} else if (getFeldtyp().getSymbol() == 'v') {
			this.feldtyp.setSymbol('>');
			setFeldtyp(feldtyp);
		}
	}
	
	public void turn_right() {
		if (getFeldtyp().getSymbol() == '<') {
			this.feldtyp.setSymbol('^');
			setFeldtyp(feldtyp);
		} else if (getFeldtyp().getSymbol() == '^') {
			this.feldtyp.setSymbol('>');
			setFeldtyp(feldtyp);
		} else if (getFeldtyp().getSymbol() == '>') {
			this.feldtyp.setSymbol('v');
			setFeldtyp(feldtyp);
		} else if (getFeldtyp().getSymbol() == 'v') {
			this.feldtyp.setSymbol('<');
			setFeldtyp(feldtyp);
		}
	}
	
	public void go_forwards() {
		if (getFeldtyp().getSymbol() == '<') {
			this.position[1][0] = position[1][0] - 1;
			setPosition(position);
		} else if (getFeldtyp().getSymbol() == '^') {
			this.position[0][0] = position[0][0] - 1;
			setPosition(position);
		} else if (getFeldtyp().getSymbol() == '>') {
			this.position[1][0] = position[1][0] + 1;
			setPosition(position);
		} else if (getFeldtyp().getSymbol() == 'v') {
			this.position[0][0] = position[0][0] + 1;
			setPosition(position);
		}
	}
	
	public void count_grains() {
		setGrains(grains + 1);
	}
	
	public void print_counted_grains() {
		System.out.println("Du hast insgesamt " + getGrains() + " gesammelt!");
	}
}
