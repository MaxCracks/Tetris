package sample;

import sample.Piece;

/**
 * Board interface gives layout of necessary features for all boards
 */
public interface Board {
	public void moveLeft(Piece p);
	public void moveRight(Piece p);
	public boolean moveDown(Piece p);
	public void rotate(Piece p);
	public Piece makePiece();
	
}
