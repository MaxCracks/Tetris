package sample;

import sample.Piece;

public interface Board {
	public void moveLeft(Piece p);
	public void moveRight(Piece p);
	public boolean moveDown(Piece p);
	public void rotate(Piece p);
	public Piece makePiece();
	
}
