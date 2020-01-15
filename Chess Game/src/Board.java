import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Board extends javax.swing.JPanel implements Cloneable, MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	final Color validMoveColor = new Color(51, 51, 51);

	Player player1 = new Player("WHITE");

	Player player2 = new Player("BLACK");

	public List<Piece> pieces = new ArrayList<Piece>();
	Set<Point> possiblemoves = new HashSet<Point>();
	Set<Point> castlemoves = new HashSet<Point>();

	public List<Piece> getPieces() {
		return pieces;
	}

	static int turn = 1;
	int mousex, mousey;
	boolean click;
	boolean selected;
	int showmovex, showmovey;
	Piece pieceAt = null;
	int index;
	boolean nextPlayer = true;
	int moveclear = 0;
	boolean clickcheck = true;

	public void paint(Graphics g) {
		BufferedImage pawnblackimg = null;
		BufferedImage pawnwhiteimg = null;
		BufferedImage rookblackimg = null;
		BufferedImage rookwhiteimg = null;
		BufferedImage knightblackimg = null;
		BufferedImage knightwhiteimg = null;
		BufferedImage bishopblackimg = null;
		BufferedImage bishopwhiteimg = null;
		BufferedImage queenblackimg = null;
		BufferedImage queenwhiteimg = null;
		BufferedImage kingblackimg = null;
		BufferedImage kingwhiteimg = null;

		try {
			pawnwhiteimg = ImageIO.read(new File ("images/pawnwhite.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pawnblackimg = ImageIO.read(new File("images/pawnblack.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			knightwhiteimg = ImageIO.read(new File("images/knightwhite.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			knightblackimg = ImageIO.read(new File("images/knightblack.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bishopwhiteimg = ImageIO.read(new File("images/bishopwhite.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bishopblackimg = ImageIO.read(new File("images/bishopblack.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rookwhiteimg = ImageIO.read(new File("images/rookwhite.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rookblackimg = ImageIO.read(new File("images/rookblack.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			queenwhiteimg = ImageIO.read(new File("images/queenwhite.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			queenblackimg = ImageIO.read(new File("images/queenblack.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			kingwhiteimg = ImageIO.read(new File("images/kingwhite.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			kingblackimg = ImageIO.read(new File("images/kingblack.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 800);
		g.drawRect(0, 0, 800, 800);

		for (int i = 0; i <= 700; i += 200)
			for (int j = 100; j <= 700; j += 200) {
				g.setColor(validMoveColor);
				;
				g.fillRect(i, j, 100, 100);

			}
		for (int i = 100; i <= 700; i += 200)
			for (int j = 0; j <= 700; j += 200) {
				g.setColor(validMoveColor);
				g.fillRect(i, j, 100, 100);

			}

		for (int i = 0; i < pieces.size(); i++) {
			if (pieces.get(i).getPlayer().equals(player1)) {
				if (pieces.get(i).getClass().getName().equals("Pawn")) {
					g.drawImage(pawnwhiteimg, pieces.get(i).getLocation().x - 35, pieces.get(i).getLocation().y - 50,
							null);
				}
				if (pieces.get(i).getClass().getName().equals("Rook")) {
					g.drawImage(rookwhiteimg, pieces.get(i).getLocation().x - 35, pieces.get(i).getLocation().y - 50,
							null);
				}
				if (pieces.get(i).getClass().getName().equals("Bishop")) {
					g.drawImage(bishopwhiteimg, pieces.get(i).getLocation().x - 35, pieces.get(i).getLocation().y - 50,
							null);
				}
				if (pieces.get(i).getClass().getName().equals("Knight")) {
					g.drawImage(knightwhiteimg, pieces.get(i).getLocation().x - 35, pieces.get(i).getLocation().y - 50,
							null);
				}
				if (pieces.get(i).getClass().getName().equals("King")) {
					g.drawImage(kingwhiteimg, pieces.get(i).getLocation().x - 35, pieces.get(i).getLocation().y - 50,
							null);
				}
				if (pieces.get(i).getClass().getName().equals("Queen")) {
					g.drawImage(queenwhiteimg, pieces.get(i).getLocation().x - 35, pieces.get(i).getLocation().y - 50,
							null);
				}
			}
			if (pieces.get(i).getPlayer().equals(player2)) {
				if (pieces.get(i).getClass().getName().equals("Pawn")) {
					g.drawImage(pawnblackimg, pieces.get(i).getLocation().x - 35, pieces.get(i).getLocation().y - 50,
							null);
				}
				if (pieces.get(i).getClass().getName().equals("Rook")) {
					g.drawImage(rookblackimg, pieces.get(i).getLocation().x - 35, pieces.get(i).getLocation().y - 50,
							null);
				}
				if (pieces.get(i).getClass().getName().equals("Bishop")) {
					g.drawImage(bishopblackimg, pieces.get(i).getLocation().x - 35, pieces.get(i).getLocation().y - 50,
							null);
				}
				if (pieces.get(i).getClass().getName().equals("Knight")) {
					g.drawImage(knightblackimg, pieces.get(i).getLocation().x - 35, pieces.get(i).getLocation().y - 50,
							null);
				}
				if (pieces.get(i).getClass().getName().equals("King")) {
					g.drawImage(kingblackimg, pieces.get(i).getLocation().x - 35, pieces.get(i).getLocation().y - 50,
							null);
				}
				if (pieces.get(i).getClass().getName().equals("Queen")) {
					g.drawImage(queenblackimg, pieces.get(i).getLocation().x - 35, pieces.get(i).getLocation().y - 50,
							null);
				}
			}
		}
		for (Point value : possiblemoves) {
			if (click) {
				g.setColor(Color.green);
				g.fillRect(value.x, value.y, 10, 10);
				selected = false;

			}
		}
		for (Point value2 : castlemoves) {
			if (click) {
				g.setColor(Color.green);
				g.fillRect(value2.x, value2.y, 10, 10);
				selected = false;

			}
		}
		if(this.checkCheckMate()==true) {
			g.setColor(Color.gray);
			g.fillRect(100, 300, 600, 200);
			Font font = new Font ("SansSerif " , Font.BOLD , 50);
			g.setFont(font);
			g.setColor(Color.black);
			g.drawString("GAME OVER", 250, 400);
			
		}
	}

	// Taslari olustur
	public Board() {
		addMouseListener(this);

		addMouseMotionListener(this);

		pieces.add(new King(new Point(450, 50), player1, false));
		pieces.add(new King(new Point(350, 750), player2, false));
		pieces.add(new Pawn(new Point(50, 150), player1, false));
		pieces.add(new Pawn(new Point(150, 150), player1, false));
		pieces.add(new Pawn(new Point(250, 150), player1, false));
		pieces.add(new Pawn(new Point(350, 150), player1, false));
		pieces.add(new Pawn(new Point(450, 150), player1, false));
		pieces.add(new Pawn(new Point(550, 150), player1, false));
		pieces.add(new Pawn(new Point(650, 150), player1, false));
		pieces.add(new Pawn(new Point(750, 150), player1, false));
		pieces.add(new Knight(new Point(150, 50), player1, false));
		pieces.add(new Knight(new Point(650, 50), player1, false));
		pieces.add(new Bishop(new Point(550, 50), player1, false));
		pieces.add(new Bishop(new Point(250, 50), player1, false));
		pieces.add(new Rook(new Point(50, 50), player1, false));
		pieces.add(new Rook(new Point(750, 50), player1, false));
		pieces.add(new Queen(new Point(350, 50), player1, false));

		// white pieces

		pieces.add(new Pawn(new Point(50, 650), player2, false));
		pieces.add(new Pawn(new Point(150, 650), player2, false));
		pieces.add(new Pawn(new Point(250, 650), player2, false));
		pieces.add(new Pawn(new Point(350, 650), player2, false));
		pieces.add(new Pawn(new Point(450, 650), player2, false));
		pieces.add(new Pawn(new Point(550, 650), player2, false));
		pieces.add(new Pawn(new Point(650, 650), player2, false));
		pieces.add(new Pawn(new Point(750, 650), player2, false));
		pieces.add(new Knight(new Point(150, 750), player2, false));
		pieces.add(new Knight(new Point(650, 750), player2, false));
		pieces.add(new Bishop(new Point(250, 750), player2, false));
		pieces.add(new Bishop(new Point(550, 750), player2, false));
		pieces.add(new Queen(new Point(450, 750), player2, false));
		pieces.add(new Rook(new Point(50, 750), player2, false));
		pieces.add(new Rook(new Point(750, 750), player2, false));

		for (int i = 0; i < pieces.size(); i++) {
			if (pieces.get(i).isCaptured() == true) {
				pieces.remove(i);
			}
		}

	}

	public Piece Move(Piece piece, Point destination) {
		if (piece.isCaptured() == false) {
			if (this.InsideTheBoard(destination)) {
				pieceAt = getPieceAt(destination);
				if (pieceAt != null) {
					if (!pieceAt.getPlayer().getColor().equals(piece.getPlayer().getColor())) {
						piece.setLocation(destination);
						piece.setMoved(true);
						for (int i = 0; i < pieces.size(); i++) {
							if (pieces.get(i).equals(pieceAt)) {
								pieces.get(i).setCaptured(true);
								pieces.remove(i);
							}
						}
						return piece;
					}
				} else if (pieceAt == null) {
					piece.setLocation(destination);
					piece.setMoved(true);
					return piece;
				}
			}
		}
		return null;
	}

	public void PawnPromotion() {
		for (int i = 0; i < pieces.size(); i++) {
			if (pieces.get(i).getClass().getName().equals("Pawn")) {
				;
				if (pieces.get(i).getPlayer().getColor().equals("BLACK")) {
					if (pieces.get(i).getLocation().y == 50) {
						pieces.add(new Queen(pieces.get(i).getLocation(), player2, false));
						pieces.remove(i);
					}
				}
			}
			if (pieces.get(i).getPlayer().getColor().equals("WHITE")) {
				if (pieces.get(i).getLocation().y == 750) {
					pieces.add(new Queen(pieces.get(i).getLocation(), player1, false));
					pieces.remove(i);

				}
			}
		}
	}

	public boolean inCheck() {
		if (turn % 2 == 1) {

			for (int i = 0; i < pieces.size(); i++) {

				if (!pieces.get(i).getPlayer().getColor().equals(pieces.get(0).getPlayer().getColor())) {
					for (int k = 0; k < pieces.get(i).checkLegalMoves(this).size(); k++) {
						if (pieces.get(i).checkLegalMoves(this).get(k).getDestination()
								.equals(pieces.get(0).getLocation())) {
							return true;

						}
					}
				}

			}
		}
		if (turn % 2 == 0) {
			for (int i = 0; i < pieces.size(); i++) {

				if (!pieces.get(i).getPlayer().getColor().equals(pieces.get(1).getPlayer().getColor())) {
					for (int k = 0; k < pieces.get(i).checkLegalMoves(this).size(); k++) {
						if (pieces.get(i).checkLegalMoves(this).get(k).getDestination()
								.equals(pieces.get(1).getLocation())) {

							return true;

						}

					}
				}

			}
		}
		return false;

	}

	public boolean whiteLongCastling() {
		// FOR WHITE KING
		if (turn % 2 == 1) {
			if (!pieces.get(0).isMoved()) {
				for (int i = 0; i < pieces.size(); i++) {
					if (pieces.get(i).getPlayer().getColor().equals("WHITE")
							&& pieces.get(i).getClass().getName().equals("Rook")) {

						// WHITE LONG CASTLE
						if (pieces.get(i).getLocation().equals(new Point(50, 50))) {
							if (getPieceAt(new Point(150, 50)) == null && getPieceAt(new Point(250, 50)) == null
									&& getPieceAt(new Point(350, 50)) == null) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public boolean whiteShortCastling() {

		// FOR WHITE KING
		if (turn % 2 == 1) {
			if (!pieces.get(0).isMoved()) {
				for (int i = 0; i < pieces.size(); i++) {
					if (pieces.get(i).getPlayer().getColor().equals("WHITE")
							&& pieces.get(i).getClass().getName().equals("Rook")) {

						// WHITE SHORT CASTLE
						if (pieces.get(i).getLocation().equals(new Point(750, 50))) {
							if (getPieceAt(new Point(550, 50)) == null && getPieceAt(new Point(650, 50)) == null) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;

	}

	public boolean blackShortCastling() {
		if (turn % 2 == 0) {
			if (!pieces.get(1).isMoved()) {

				for (int i = 0; i < pieces.size(); i++) {
					if (pieces.get(i).getPlayer().getColor().equals("BLACK")
							&& pieces.get(i).getClass().getName().equals("Rook")) {

						// BLACK SHORT CASTLE

						if (pieces.get(i).getLocation().equals(new Point(50, 750))) {
							if (getPieceAt(new Point(150, 750)) == null && getPieceAt(new Point(250, 750)) == null) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public boolean blackLongCastling() {

		if (turn % 2 == 0) {
			if (!pieces.get(1).isMoved()) {

				for (int i = 0; i < pieces.size(); i++) {
					if (pieces.get(i).getPlayer().getColor().equals("BLACK")
							&& pieces.get(i).getClass().getName().equals("Rook")) {

						// BLACK LONG CASTLE
						if (pieces.get(i).getLocation().equals(new Point(750, 750))) {
							if (getPieceAt(new Point(450, 750)) == null && getPieceAt(new Point(550, 750)) == null
									&& getPieceAt(new Point(650, 750)) == null) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public boolean checkCheckMate() {
		if (inCheck()) {
			if (pieces.get(0).checkLegalMoves(this).size() == 0) {
				return true;
			}
			if (pieces.get(1).checkLegalMoves(this).size() == 0) {
				return true;

			}
		}
		return false;
	}

	public boolean InsideTheBoard(Point destination) {
		if (destination.x < 800 && destination.y < 800) {
			return true;
		} else {
			return false;
		}
	}

	public Piece getPieceAt(Point des) {
		for (Piece piece : pieces) {
			if ((des.x == piece.getLocation().x) && (des.y == piece.getLocation().y)) {
				return piece;
			}
		}

		return null;

	}

	public void switchPlayer() {
		nextPlayer = !nextPlayer;
		turn++;
		System.out.println("SAY " + turn);

	}

	@Override
	public void mousePressed(MouseEvent e) {

		mousex = (e.getX() / 100) * 100 + 50;
		mousey = (e.getY() / 100) * 100 + 50;

		for (int i = 0; i < pieces.size(); i++) {

			if (pieces.get(i).getLocation().x == mousex && pieces.get(i).getLocation().y == mousey) {
				// BEYAZ TAKIM
				if (pieces.get(i).getPlayer().getColor().equalsIgnoreCase("WHITE") && nextPlayer == true) {
					click = true;
					if (clickcheck == true) {
						clickcheck = !clickcheck;
					} else if (clickcheck == false) {
						possiblemoves.clear();
						castlemoves.clear();
					}
					for (int j = 0; j < pieces.get(i).checkLegalMoves(this).size(); j++)
						possiblemoves.add(pieces.get(i).checkLegalMoves(this).get(j).getDestination());

					selected = true;
					index = i;

					if (pieces.get(i).getClass().getName().equals("King")) {
						if (whiteShortCastling()) {
							castlemoves.add(new Point(650, 50));

						}

						if (whiteLongCastling()) {
							castlemoves.add(new Point(150, 50));
						}

					}
					break;

				}

				// SIYAH TAKIM
				if (pieces.get(i).getPlayer().getColor().equalsIgnoreCase("BLACK") && nextPlayer == false) {
					click = true;
					if (clickcheck) {
						clickcheck = !clickcheck;
					} else if (!clickcheck) {
						possiblemoves.clear();
						castlemoves.clear();

					}
					for (int j = 0; j < pieces.get(i).checkLegalMoves(this).size(); j++)
						possiblemoves.add(pieces.get(i).checkLegalMoves(this).get(j).getDestination());
					selected = true;
					index = i;

					if (pieces.get(i).getClass().getName().equals("King")) {
						if (blackShortCastling()) {
							castlemoves.add(new Point(150, 750));

						}

						if (blackLongCastling()) {
							castlemoves.add(new Point(650, 750));
						}

					}
					break;

				}
			} else {
				click = false;
				selected = false;
			}

			for (Point values : possiblemoves) {

				if (this.inCheck() == false) {
					if (mousex == values.x && mousey == values.y) {
						Move(pieces.get(index), values);
						possiblemoves.clear();
						this.PawnPromotion();
						this.switchPlayer();
						clickcheck = true;
						repaint();
						break;
					}
				}
				if (this.inCheck() == true) {
					if (mousex == values.x && mousey == values.y) {
						Point backmove = new Point(pieces.get(index).getLocation());
						Move(pieces.get(index), values);
						if (this.inCheck() == true) {
							Move(pieces.get(index), backmove);
							clickcheck = true;
							possiblemoves.clear();
							repaint();
							break;
						} else {
							this.PawnPromotion();
							clickcheck = true;
							repaint();

						}
					}
				}
			}

			for (Point value2 : castlemoves) {
				if (mousex == value2.x && mousey == value2.y) {
					Move(pieces.get(index), value2);
					Piece piece;
					if (value2.x == 150 && value2.y == 50) {
						piece = getPieceAt(new Point(50, 50));
						piece.setLocation(new Point(250, 50));

					} else if (value2.x == 650 && value2.y == 50) {
						piece = getPieceAt(new Point(50, 50));
						piece.setLocation(new Point(650, 50));
					} else if (value2.x == 150 && value2.y == 750) {
						piece = getPieceAt(new Point(50, 750));
						piece.setLocation(new Point(250, 750));
					} else if (value2.x == 650 && value2.y == 750) {
						piece = getPieceAt(new Point(50, 750));
						piece.setLocation(new Point(650, 750));
					}
					this.switchPlayer();

					castlemoves.clear();
					clickcheck = true;
					repaint();
					break;
				}

			}

		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}
}
