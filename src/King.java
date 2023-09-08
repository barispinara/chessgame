import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

	Player player;
	boolean captured;
	boolean moved;
	boolean inCheck;


	public King(Point location, Player player, boolean captured) {
		super(player, captured);
		this.location = location;
		this.captured = false;
		this.player = player;

		

	}

	@Override
	public List<Move> checkLegalMoves(Board board) {
		List<Move> MovesList = new ArrayList<Move>();
		Move(board, MovesList);
		return MovesList;
	}

	private void Move(Board board, List<Move> MovesList) {
		int LocationX = location.x;
		int LocationY = location.y;
		int north = -100;
		int south = 100;
		int east = 100;
		int west = -100;
		
		boolean northcheck = false;
		boolean northwestcheck = false;
		boolean northeastcheck = false;
		boolean southcheck =false;
		boolean southeastcheck = false;
		boolean southwestcheck = false;
		boolean westcheck =false;
		boolean eastcheck = false;
		boolean northpawncheck = false;
		boolean northeastpawncheck = false;
		boolean northwestpawncheck = false;
		boolean southpawncheck = false;
		boolean southeastpawncheck = false;
		boolean southwestpawncheck = false;
		boolean eastpawncheck = false;
		boolean westpawncheck = false;
		boolean kingcheck = false;
		boolean kingcheckdikey = false;
		boolean kingcheckyatay = false;


		Piece pieceAt;

		
		Point northMove = new Point(LocationX, LocationY + north);
		Point southMove = new Point(LocationX, LocationY + south);
		Point eastMove = new Point(LocationX + east, LocationY);
		Point westMove = new Point(LocationX + west, LocationY);

		Point NORTHWESTMove = new Point(LocationX + west, LocationY + north);
		Point NORTHEASTMove = new Point(LocationX + east, LocationY + north);
		Point SOUTHWESTMove = new Point(LocationX + west, LocationY + south);
		Point SOUTHEASTMove = new Point(LocationX + east, LocationY + south);
		
		
		
			
		//Hareket mümkün mü ?
			for(int i=0; i<board.pieces.size();i++) {
				if(!board.pieces.get(i).getPlayer().getColor().equals(this.player.getColor())) {
					if(!board.pieces.get(i).getClass().getName().equals("Pawn") && !board.pieces.get(i).getClass().getName().equals("King")) {
						for (int j=0; j<board.pieces.get(i).checkLegalMoves(board).size(); j++) {
							if(northcheck != true) {
							if(board.pieces.get(i).checkLegalMoves(board).get(j).getDestination().equals(northMove)) {
								northcheck=true;
							
							}}
							if(northwestcheck != true) {
							if(board.pieces.get(i).checkLegalMoves(board).get(j).getDestination().equals(NORTHWESTMove)) {
								northwestcheck=true;
								
							}}
							if(northeastcheck != true) {
							if(board.pieces.get(i).checkLegalMoves(board).get(j).getDestination().equals(NORTHEASTMove)) {
								northeastcheck=true;
								
							}}
							if(southcheck != true) {
							if(board.pieces.get(i).checkLegalMoves(board).get(j).getDestination().equals(southMove)) {
								southcheck=true;
								
							}}
							if(southwestcheck != true) {
							if(board.pieces.get(i).checkLegalMoves(board).get(j).getDestination().equals(SOUTHWESTMove)) {
								southwestcheck=true;
								
							}}
							if(southeastcheck != true) {
							if(board.pieces.get(i).checkLegalMoves(board).get(j).getDestination().equals(SOUTHEASTMove)) {
								southeastcheck=true;
								
							}}
							if (westcheck != true) {
							if(board.pieces.get(i).checkLegalMoves(board).get(j).getDestination().equals(westMove)) {
								westcheck=true;
							
							}}
							if (eastcheck != true) {
							if(board.pieces.get(i).checkLegalMoves(board).get(j).getDestination().equals(eastMove)) {
								eastcheck=true;
								
							}}}}
						else if (board.pieces.get(i).getClass().getName().equals("Pawn")) {
							if(this.player.getColor().equals("BLACK")) {
								if(northpawncheck != true) {
									if(board.pieces.get(i).getLocation().y-this.getLocation().y==-200) {
										if (board.pieces.get(i).getLocation().x-this.getLocation().x==100 || board.pieces.get(i).getLocation().x-this.getLocation().x==-100) {
											northpawncheck = true;
										}}}
								if(northwestpawncheck != true) {
									if(board.pieces.get(i).getLocation().y-this.getLocation().y==-200 && board.pieces.get(i).getLocation().x == this.getLocation().x) {
										northwestpawncheck = true;
									}
									if(board.pieces.get(i).getLocation().y-this.getLocation().y==-200 && board.pieces.get(i).getLocation().x-this.getLocation().x==-200) {
										northwestpawncheck = true;
									}}
								if(northeastpawncheck != true) {
									if(board.pieces.get(i).getLocation().y-this.getLocation().y==-200 && board.pieces.get(i).getLocation().x == this.getLocation().x) {
										northeastpawncheck = true;
									}
									if(board.pieces.get(i).getLocation().y-this.getLocation().y==-200 && board.pieces.get(i).getLocation().x-this.getLocation().x==200) {
										northeastpawncheck = true;
									}}
								if(southpawncheck != true) {
									if(board.pieces.get(i).getLocation().y == this.getLocation().y) {
										if(board.pieces.get(i).getLocation().x-this.getLocation().x == 100 && board.pieces.get(i).getLocation().x-this.getLocation().x == -100) {
											southpawncheck = true;
										}}}
								if(southwestpawncheck != true) {
									if(board.pieces.get(i).getLocation().y == this.getLocation().y) {
										if(board.pieces.get(i).getLocation().x-this.getLocation().x == -200) {
											southwestpawncheck = true;
										}}}
								if(southeastpawncheck != true) {
									if(board.pieces.get(i).getLocation().y == this.getLocation().y) {
										if(board.pieces.get(i).getLocation().x - this .getLocation().x == 200) {
											southeastpawncheck = true;
										}}}
								if(westpawncheck != true) {
									if(board.pieces.get(i).getLocation().y - this.getLocation().y == -100 && board.pieces.get(i).getLocation().x == this.getLocation().x) {
										westpawncheck = true;
									}
									if(board.pieces.get(i).getLocation().y-this.getLocation().y == -100 && board.pieces.get(i).getLocation().x-this.getLocation().x==-200) {
										westpawncheck = true;
									}}
								if(eastpawncheck != true) {
									if(board.pieces.get(i).getLocation().y - this.getLocation().y == -100 && board.pieces.get(i).getLocation().x == this.getLocation().x) {
										eastpawncheck = true;
									}
									if (board.pieces.get(i).getLocation().y-this.getLocation().y == -100 && board.pieces.get(i).getLocation().x-this.getLocation().x==200) {
										eastpawncheck = true;
									}}}
							else if (this.player.getColor().equals("WHITE")) {
								if(northpawncheck != true) {
									if(board.pieces.get(i).getLocation().y == this.getLocation().y) {
										if(board.pieces.get(i).getLocation().x-this.getLocation().x == 100 || board.pieces.get(i).getLocation().x-this.getLocation().x == -100) {
											northpawncheck = true;
										}}
								if(northeastpawncheck != true) {
									if(board.pieces.get(i).getLocation().y == this.getLocation().y) {
										if(board.pieces.get(i).getLocation().x-this.getLocation().x==200) {
											northeastpawncheck = true;
										}}}
								if(northwestpawncheck != true) {
									if(board.pieces.get(i).getLocation().y == this.getLocation().y) {
										if(board.pieces.get(i).getLocation().x - this.getLocation().x == -200) {
											northwestpawncheck = true;
										}}}
								if(southpawncheck != true) {
									if(board.pieces.get(i).getLocation().y - this.getLocation().y == 200) {
										if(board.pieces.get(i).getLocation().x - this.getLocation().x == 100 || board.pieces.get(i).getLocation().x - this.getLocation().x == -100) {
											southpawncheck = true;
										}}}
								if(southeastpawncheck != true) {
									if(board.pieces.get(i).getLocation().y - this.getLocation().y == 200 && board.pieces.get(i).getLocation().x == this.getLocation().x) {
										southeastpawncheck = true;
									}
									if(board.pieces.get(i).getLocation().y - this.getLocation().y == 200 && board.pieces.get(i).getLocation().x - this.getLocation().x == 200) {
										southeastpawncheck = true;
									}}
								if(southwestpawncheck != true) {
									if(board.pieces.get(i).getLocation().y - this.getLocation().y == 200 && board.pieces.get(i).getLocation().x == this.getLocation().x) {
										southwestpawncheck = true;
									}
									if(board.pieces.get(i).getLocation().y - this.getLocation().y == 200 && board.pieces.get(i).getLocation().x - this.getLocation().x == -200) {
										southwestpawncheck = true;
									}}
								if(eastpawncheck != true) {
									if(board.pieces.get(i).getLocation().y - this.getLocation().y == 100) {
										if(board.pieces.get(i).getLocation().x - this.getLocation().x == 200 || board.pieces.get(i).getLocation().x == this.getLocation().x) {
											eastpawncheck = true;
										}}}
								if(westpawncheck != true) {
									if(board.pieces.get(i).getLocation().y - this.getLocation().y == 100) {
										if(board.pieces.get(i).getLocation().x - this.getLocation().x == -200 || board.pieces.get(i).getLocation().x == this.getLocation().x) {
											westpawncheck = true;
										}}
								}}}}
						else if (board.pieces.get(i).getClass().getName().equals("King")) {
}}}
			//KUZEY
			if(northcheck == false && northpawncheck == false && kingcheck == false && kingcheckdikey == false && kingcheckyatay == false) {
				if(board.InsideTheBoard(northMove)) {
					pieceAt=board.getPieceAt(northMove);
					if(pieceAt !=null) {
						if(!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {
							MovesList.add(new Move (this,northMove,pieceAt));
							northcheck = false;
							northpawncheck = false;
							kingcheck = false;
							kingcheckdikey = false;
							kingcheckyatay = false;
						}}
					else if (pieceAt == null) {
						MovesList.add(new Move (this,northMove,pieceAt));
						northcheck = false;
						northpawncheck = false;
						kingcheck = false;
						kingcheckdikey = false;
						kingcheckyatay = false;
					}}}
			//KUZEY DOGU 
			if(northeastcheck == false && northeastpawncheck == false && kingcheck == false && kingcheckdikey == false && kingcheckyatay == false) {
				if(board.InsideTheBoard(NORTHEASTMove)) {
					pieceAt=board.getPieceAt(NORTHEASTMove);
					if(pieceAt !=null) {
						if(!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {
							MovesList.add(new Move (this,NORTHEASTMove,pieceAt));
							northeastcheck = false;
							northeastpawncheck = false;

						}}
					else if (pieceAt == null) {
						MovesList.add(new Move (this,NORTHEASTMove,pieceAt));
						northeastcheck = false;
						northeastpawncheck = false;
						kingcheck = false;
						kingcheckdikey = false;
						kingcheckyatay = false;
					}}}
			// KUZEY BATI
			if(northwestcheck == false && northwestpawncheck == false && kingcheck == false && kingcheckdikey == false && kingcheckyatay == false) {
				if(board.InsideTheBoard(NORTHWESTMove)) {
					pieceAt=board.getPieceAt(NORTHWESTMove);
					if(pieceAt !=null) {
						if(!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {
							MovesList.add(new Move (this,NORTHWESTMove,pieceAt));
							northwestcheck = false;
							northwestpawncheck = false;
							kingcheck = false;
							kingcheckdikey = false;
							kingcheckyatay = false;
						}}
					else if (pieceAt == null) {
						MovesList.add(new Move (this,NORTHWESTMove,pieceAt));
						northwestcheck = false;
						northwestpawncheck = false;
						kingcheck = false;
						kingcheckdikey = false;
						kingcheckyatay = false;
					}}}
			// GÜNEY
			if(southcheck == false && southpawncheck == false && kingcheck == false && kingcheckdikey == false && kingcheckyatay == false) {
				if(board.InsideTheBoard(southMove)) {
					pieceAt=board.getPieceAt(southMove);
					if(pieceAt !=null) {
						if(!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {
							MovesList.add(new Move (this,southMove,pieceAt));
							southcheck = false;
							southpawncheck = false;
							kingcheck = false;
							kingcheckdikey = false;
							kingcheckyatay = false;
						}}
					else if (pieceAt == null) {
						MovesList.add(new Move (this,southMove,pieceAt));
						southcheck = false;
						southpawncheck = false;
						kingcheck = false;
						kingcheckdikey = false;
						kingcheckyatay = false;
					}}}			
			// GÜNEY DOÐU
			if(southeastcheck == false && southeastpawncheck == false && kingcheck == false && kingcheckdikey == false && kingcheckyatay == false) {
				if(board.InsideTheBoard(SOUTHEASTMove)) {
					pieceAt=board.getPieceAt(SOUTHEASTMove);
					if(pieceAt !=null) {
						if(!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {
							MovesList.add(new Move (this,SOUTHEASTMove,pieceAt));
							southeastcheck = false;
							southeastpawncheck = false;
							kingcheck = false;
							kingcheckdikey = false;
							kingcheckyatay = false;
						}}
					else if (pieceAt == null) {
						MovesList.add(new Move (this,SOUTHEASTMove,pieceAt));
						southeastcheck = false;
						southeastpawncheck = false;
						kingcheck = false;
						kingcheckdikey = false;
						kingcheckyatay = false;
					}}}					
			// GÜNEY BATI
			if(southwestcheck == false && southwestpawncheck == false && kingcheck == false && kingcheckdikey == false && kingcheckyatay == false) {
				if(board.InsideTheBoard(SOUTHWESTMove)) {
					pieceAt=board.getPieceAt(SOUTHWESTMove);
					if(pieceAt !=null) {
						if(!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {
							MovesList.add(new Move (this,SOUTHWESTMove,pieceAt));
							southwestcheck = false;
							southwestpawncheck = false;
							kingcheck = false;
							kingcheckdikey = false;
							kingcheckyatay = false;
						}}
					else if (pieceAt == null) {
						MovesList.add(new Move (this,SOUTHWESTMove,pieceAt));
						southwestcheck = false;
						southwestpawncheck = false;
						kingcheck = false;
						kingcheckdikey = false;
						kingcheckyatay = false;
					}}}	
			// DOÐU
			if(eastcheck == false && eastpawncheck == false && kingcheck == false && kingcheckdikey == false && kingcheckyatay == false) {
				if(board.InsideTheBoard(eastMove)) {
					pieceAt=board.getPieceAt(eastMove);
					if(pieceAt !=null) {
						if(!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {
							MovesList.add(new Move (this,eastMove,pieceAt));
							eastcheck = false;
							eastpawncheck = false;
							kingcheck = false;
							kingcheckdikey = false;
							kingcheckyatay = false;
						}}
					else if (pieceAt == null) {
						MovesList.add(new Move (this,eastMove,pieceAt));
						eastcheck = false;
						eastpawncheck = false;
						kingcheck = false;
						kingcheckdikey = false;
						kingcheckyatay = false;
					}}}
			// BATI
			if(westcheck == false && westpawncheck == false && kingcheck == false && kingcheckdikey == false && kingcheckyatay == false) {
				if(board.InsideTheBoard(westMove)) {
					pieceAt=board.getPieceAt(westMove);
					if(pieceAt !=null) {
						if(!pieceAt.getPlayer().getColor().equals(this.player.getColor())) {
							MovesList.add(new Move (this,westMove,pieceAt));
							westcheck = false;
							westpawncheck = false;
							kingcheck = false;
							kingcheckdikey = false;
							kingcheckyatay = false;
						}}
					else if (pieceAt == null) {
						MovesList.add(new Move (this,westMove,pieceAt));
						westcheck = false;
						westpawncheck = false;
						kingcheck = false;
						kingcheckdikey = false;
						kingcheckyatay = false;
					}}}
			
	
	
	
	
	
	
	
	
	
	}
		
		

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isCaptured() {
		return captured;
	}

	public void setCaptured(boolean captured) {
		this.captured = captured;
	}

	public boolean isMoved() {
		return moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}

	@Override
	public String toString() {
		return "KING";
	}

}
