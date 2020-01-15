import java.awt.Point;

public  class Move {

	private Point destination;
	private Piece selected;
	private Piece attacked;

	public Move(Piece selected, Point destination,Piece attacked) {
		this.selected = selected;
		this.destination = destination;
		this.attacked=attacked;

	}

	public Point getDestination() {
		return destination;
	}

	public void setDestination(Point destination) {
		this.destination = destination;
	}

	public Piece getSelected() {
		return selected;
	}

	public void setSelected(Piece selected) {
		this.selected = selected;
	}

	public Piece getAttacked() {
		return attacked;
	}

	public void setAttacked(Piece attacked) {
		this.attacked = attacked;
	}
	
	
}
