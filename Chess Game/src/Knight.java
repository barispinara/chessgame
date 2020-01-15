import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

	private boolean captured;
	private Player player;
	private Point location;

	public Knight(Point location, Player player, boolean captured) {
		super(player, captured);

		this.location = location;
		this.captured = false;
		this.player = player;

	}

	@Override
	public List<Move> checkLegalMoves(Board board) {
		List<Move> MovesList = new ArrayList<Move>();
		Normal(board, MovesList);
		return MovesList;

	}

	private void Normal(Board board, List<Move> MovesList) {

		int x = this.location.x;
		int y = this.location.y;
		int North2 = 200;
		int South2 = -200;
		int West2 = 200;
		int East2 = -200;

		int North1 = 100;
		int South1 = -100;
		int West1 = 100;
		int East1 = -100;

		Piece pieceAt;

		Point North2East1 = new Point(x + North2, y + East1);
		Point North2West1 = new Point(x + North2, y + West1);
		Point South2East1 = new Point(x + South2, y + East1);
		Point South2West1 = new Point(x + South2, y + West1);

		Point East2North1 = new Point(x + North1, y + East2);
		Point West2North1 = new Point(x + North1, y + West2);
		Point East2South1 = new Point(x + South1, y + East2);
		Point West2South1 = new Point(x + South1, y + West2);

		if (board.InsideTheBoard(North2East1)) {
			pieceAt = board.getPieceAt(North2East1);
			if (pieceAt != null) {

				if (!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {

					MovesList.add(new Move(this, North2East1, pieceAt));

				}

			} else if (pieceAt == null) {
				MovesList.add(new Move(this, North2East1, pieceAt));
			}
		}

		if (board.InsideTheBoard(North2West1)) {
			pieceAt = board.getPieceAt(North2West1);
			if (pieceAt != null) {

				if (!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {

					MovesList.add(new Move(this, North2West1, pieceAt));

				}

			} else if (pieceAt == null) {
				MovesList.add(new Move(this, North2West1, pieceAt));
			}
		}
		if (board.InsideTheBoard(South2East1)) {
			pieceAt = board.getPieceAt(South2East1);
			if (pieceAt != null) {

				if (!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {

					MovesList.add(new Move(this, South2East1, pieceAt));

				}

			} else if (pieceAt == null) {
				MovesList.add(new Move(this, South2East1, pieceAt));
			}
		}
		if (board.InsideTheBoard(South2West1)) {
			pieceAt = board.getPieceAt(South2West1);
			if (pieceAt != null) {

				if (!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {

					MovesList.add(new Move(this, South2West1, pieceAt));

				}

			} else if (pieceAt == null) {
				MovesList.add(new Move(this, South2West1, pieceAt));
			}
		}
		if (board.InsideTheBoard(East2North1)) {
			pieceAt = board.getPieceAt(East2North1);
			if (pieceAt != null) {

				if (!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {

					MovesList.add(new Move(this, East2North1, pieceAt));

				}

			} else if (pieceAt == null) {
				MovesList.add(new Move(this, East2North1, pieceAt));
			}
		}
		if (board.InsideTheBoard(West2North1)) {
			pieceAt = board.getPieceAt(West2North1);
			if (pieceAt != null) {

				if (!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {

					MovesList.add(new Move(this, West2North1, pieceAt));

				}

			} else if (pieceAt == null) {
				MovesList.add(new Move(this, West2North1, pieceAt));
			}
		}
		if (board.InsideTheBoard(East2South1)) {
			pieceAt = board.getPieceAt(East2South1);
			if (pieceAt != null) {

				if (!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {

					MovesList.add(new Move(this, East2South1, pieceAt));

				}

			} else if (pieceAt == null) {
				MovesList.add(new Move(this, East2South1, pieceAt));
			}
		}
		if (board.InsideTheBoard(West2South1)) {
			pieceAt = board.getPieceAt(West2South1);
			if (pieceAt != null) {

				if (!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {

					MovesList.add(new Move(this, West2South1, pieceAt));

				}

			} else if (pieceAt == null) {
				MovesList.add(new Move(this, West2South1, pieceAt));
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



	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "KNIGHT";
	}
}
