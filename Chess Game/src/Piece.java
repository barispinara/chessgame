import java.awt.Point;
import java.util.List;

public abstract class Piece {

	protected Player Player;
	private boolean captured;
	protected Point location;
	private boolean moved;

	public Piece(Player player,boolean captured) {
		this.captured = false;
		this.moved=false;
	}

	public abstract List<Move> checkLegalMoves(Board board);

	public Player getPlayer() {
		return Player;
	}

	public void setPlayer(Player player) {
		Player = player;
	}

	public boolean isCaptured(){
		return captured;
	}

	public void setCaptured(boolean captured){
		if(captured==true) {
			this.location=null;
		}
		this.captured = captured;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public void setMoved(boolean moved) {
		this.moved=moved;
	}
	public boolean isMoved() {
		return moved;
	}
		
	
	

}
