import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
	
	private boolean captured;
	private Player player;
	private boolean moved;
	private Point location;
	
	public Queen(Point location, Player player, boolean captured) {
		super(player,captured);

		this.location = location;
		this.captured = captured;
		this.player = player;
		this.moved = moved;

	}
	public List<Move> checkLegalMoves(Board board) {
		List<Move> MovesList = new ArrayList<Move>();
		NormalandAttackMove(board, MovesList);
		return MovesList;
	}
	
	private void NormalandAttackMove(Board board, List<Move> MovesList) {
		Piece pieceAt;
		Piece pieceAt1;
		Piece pieceAt2;
		Piece pieceAt3;
		Piece pieceAt4;
		Piece pieceAt5;
		Piece pieceAt6;
		Piece pieceAt7;
		
		
		// SOL ALT CAPRAZ
				for (int i=100; i<800;i+=100) {

						Point Normal = new Point (location.x+i,location.y+i);
						if (board.InsideTheBoard(Normal)) {
							pieceAt = board.getPieceAt(Normal);
							if (pieceAt == null) {
								MovesList.add(new Move(this,Normal,pieceAt));
								
								
							}
							else if(pieceAt != null) {
								if(pieceAt.getPlayer().getColor().equals(this.player.getColor())) {
									break;
								}
								else  {
									MovesList.add(new Move(this,Normal,pieceAt));
									break;
								}
								
							}
							
						}
					}
		// SAG ALT CAPRAZ
		for (int i=100; i<800;i+=100) {

				Point Normal2 = new Point (location.x-i,location.y+i);
						if (board.InsideTheBoard(Normal2)) {
							pieceAt1 = board.getPieceAt(Normal2);
							if (pieceAt1 == null) {
								MovesList.add(new Move(this,Normal2,pieceAt1));
								
								
							}
							else if(pieceAt1 != null) {
								if(pieceAt1.getPlayer().getColor().equals(this.player.getColor())) {
									break;
								}
								else  {
									MovesList.add(new Move(this,Normal2,pieceAt1));
									break;
								}
								
							}
							
						}
					}
		// SAG UST CAPRAZ
		for (int i=100; i<800;i+=100) {

		Point Normal3 = new Point (location.x+i,location.y-i);
		if (board.InsideTheBoard(Normal3)) {
			pieceAt2 = board.getPieceAt(Normal3);
			if (pieceAt2 == null) {
				MovesList.add(new Move(this,Normal3,pieceAt2));									
		}
			else if(pieceAt2 != null) {
			if(pieceAt2.getPlayer().getColor().equals(this.player.getColor())) {
				break;
	}
			else  {
			MovesList.add(new Move(this,Normal3,pieceAt2));
			break;
	}								
	}							
	}
	}
		// SOL UST CAPRAZ
		for (int i=100; i<800;i+=100) {

				Point Normal4 = new Point (location.x-i,location.y-i);
				if (board.InsideTheBoard(Normal4)) {
					pieceAt3 = board.getPieceAt(Normal4);
					if (pieceAt3 == null) {
						MovesList.add(new Move(this,Normal4,pieceAt3));
						
						
					}
					else if(pieceAt3 != null) {
						if(pieceAt3.getPlayer().getColor().equals(this.player.getColor())) {
							break;
						}
						else  {
							MovesList.add(new Move(this,Normal4,pieceAt3));
							break;
						}
						
					}
					
				}
			}
		//DIKEY ASAGI DOGRU
				for (int i=100; i<800; i+=100) {
					
					Point Normal5 = new Point (location.x,location.y+i);
					if (board.InsideTheBoard(Normal5)) {
						pieceAt4=board.getPieceAt(Normal5);
						if(pieceAt4 == null) {
							MovesList.add(new Move(this,Normal5,pieceAt4));
						}
						else if(pieceAt4 != null) {
							if(pieceAt4.getPlayer().getColor().equals(this.player.getColor())) {
								break;
							}
							else  {
								MovesList.add(new Move(this,Normal5,pieceAt4));
								break;
							}
							
						}
					
					
					}
					
					
				}
		// YATAY SAGA DOGRU
		for ( int i=100; i<800; i+=100) {
					
			Point Normal6= new Point (location.x+i,location.y);
			if(board.InsideTheBoard(Normal6)) {
						pieceAt5=board.getPieceAt(Normal6);
						if(pieceAt5==null) {
							MovesList.add(new Move(this,Normal6,pieceAt5));
						}
						else if(pieceAt5 != null) {
							if(pieceAt5.getPlayer().getColor().equals(this.player.getColor())) {
							break;
							}
							else {
								MovesList.add(new Move(this,Normal6,pieceAt5));
								break;
							}
						}
					}
				}
		//DIKEY YUKARI DOGRU
		for (int i=100; i<800; i+=100) {
			
			Point Normal7 = new Point (location.x,location.y-i);
			if (board.InsideTheBoard(Normal7)) {
				pieceAt6=board.getPieceAt(Normal7);
				if(pieceAt6 == null) {
					MovesList.add(new Move(this,Normal7,pieceAt6));
				}
				else if(pieceAt6 != null) {
					if(pieceAt6.getPlayer().getColor().equals(this.player.getColor())) {
						break;
					}
					else  {
						MovesList.add(new Move(this,Normal7,pieceAt6));
						break;
					}
					
				}
			
			
			}
			
			
		}
		//YATAY SOLA DOGRU
		for (int i=100; i<800; i+=100) {
			
			Point Normal8 = new Point (location.x-i,location.y);
			if (board.InsideTheBoard(Normal8)) {
				pieceAt7=board.getPieceAt(Normal8);
				if(pieceAt7 == null) {
					MovesList.add(new Move(this,Normal8,pieceAt7));
				}
				else if(pieceAt7 != null) {
					if(pieceAt7.getPlayer().getColor().equals(this.player.getColor())) {
						break;
					}
					else  {
						MovesList.add(new Move(this,Normal8,pieceAt7));
						break;
					}
					
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
	public boolean isMoved() {
		return moved;
	}
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	public String toString () {
		return "QUEEN";
	}






}
