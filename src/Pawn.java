import java.util.List;
import java.awt.Point;
import java.util.ArrayList;

public class Pawn extends Piece {

	private boolean captured;
	private Player player;
	private boolean moved;
	private Point location;

	public Pawn(Point location, Player player, boolean captured) {
		super(player,captured);
		
		this.location = location;
		this.captured = captured;
		this.player = player;
		this.moved = moved;
		

	}
	@Override
	public List<Move> checkLegalMoves(Board board) {
		List<Move> MovesList = new ArrayList<Move>();
		
		NormalMove(board, MovesList);
		AttackMove(board,MovesList);
		return MovesList;

	}

	private void AttackMove(Board board, List<Move> MovesList) {

		int LocationX = location.x;
		int LocationY = location.y;
		int MoveXright = 100;
		int MoveXleft = -100;
		int MoveY =0;
		Piece pieceAt;
		Piece pieceAt2;

		// Color check
		if (player.getColor().equals("BLACK")) {
			MoveY = -100;
		} else {
			MoveY = 100;
		}

		Point AtCapture = new Point(LocationX + MoveXright, LocationY + MoveY);
		Point AtCapture2 = new Point(LocationX + MoveXleft, LocationY + MoveY);

		if (board.InsideTheBoard(AtCapture)) {
			pieceAt = board.getPieceAt(AtCapture);
			if (pieceAt != null ) {
				if ((this.player.getColor()) != (pieceAt.getPlayer().getColor())) {
					MovesList.add(new Move(this, AtCapture,pieceAt));

				}

			}

		}
		if (board.InsideTheBoard(AtCapture2)) {
			pieceAt2 = board.getPieceAt(AtCapture2);
			if (pieceAt2 != null ) {
				if ((this.player.getColor()) != (pieceAt2.getPlayer().getColor())) {
					MovesList.add(new Move(this, AtCapture2,pieceAt2));

				}
			}
		}

	}

	private void NormalMove(Board board, List<Move> MovesList) {
		int LocationX = location.x;
		int LocationY = location.y;

		int MoveY=0;
		int DoubleY=0;

		Piece pieceAt;
		Piece pieceAtDouble;

		// Color check
		if (player.getColor().equals("BLACK")) {
			MoveY = -100;
		} else {
			MoveY = 100;
		}
		Point Normal = new Point(LocationX, LocationY + MoveY);

		// Color + doubleMove check
		if(!moved) {
		if (player.getColor().equals("BLACK")) {
			DoubleY = -200;

		} else  {
			DoubleY = 200;
		}
		}

		Point Double = new Point(LocationX, LocationY + DoubleY);
		// Looks if move is inside the board
		if (board.InsideTheBoard(Normal)) {

			// looks if move is not an attack move
			pieceAt = board.getPieceAt(Normal);

			if (pieceAt == null) {

				MovesList.add(new Move(this, Normal,pieceAt));

			}

		}
		// For double movement
		if (board.InsideTheBoard(Double) && moved == false) {
            pieceAt = board.getPieceAt(Normal);
            pieceAtDouble = board.getPieceAt(Double);

            if(pieceAt==null) {
                if(pieceAtDouble==null) {

                MovesList.add(new Move(this, Double,pieceAtDouble));
            }
            }
        }
    }
	


	
	
	
	public boolean isCaptured() {
		return captured;
	}

	public void setCaptured(boolean captured) {
		this.captured = captured;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isItMoved() {
		return moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}

	@Override
	public String toString() {
		return "PAWN";
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

}
