package sample;

import sample.Piece;

import java.util.*;


public class GameBoard implements Board {

	public int GRIDSPACE;
	public int WIDTH;
	public int HEIGHT;
	public boolean [][] GRID;
	private int aX;
	private int aY;
	private int bX;
	private int bY;
	private int cX;
	private int cY;
	private int dX;
	private int dY;

	public GameBoard() {
		GRID = new boolean [24][12];
		for (int j = 0; j<24;j++)
		{
			for (int i=0;i<12;i++)
			{
				GRID [j][i]=false;
			}
		}
		WIDTH = 12;
		HEIGHT = 24;
		GRIDSPACE = 25;
		aX=0; aY=0;
		bX=0; bY=0;
		cX=0; cY=0;
		dX=0; dY=0;
	}
	public void moveLeft(Piece p) {

		if(aX-1>=0 && bX-1>=0 && cX-1>=0 && dX-1>=0) {


			if (!GRID[aY][aX - 1] && !GRID[bY][bX-1] && !GRID[cY][cX-1] && !GRID[dY][dX-1])
			{
					p.modPos(-1*GRIDSPACE,0);
					updatePiece(p);
			}

			//else //throw exception here cannot move left

		}
		//else //throw exception here out of bounds
	}
	public void moveRight(Piece p) {
		if(aX+1 < WIDTH && bX+1 < WIDTH && cX+1 < WIDTH && dX+1 < WIDTH) {


			if (!GRID[aY][aX+1] && !GRID[bY][bX+1] && !GRID[cY][cX+1] && !GRID[dY][dX+1])
			{
				p.modPos(GRIDSPACE,0);
				updatePiece(p);
			}

			//else //throw exception here cannot move right
		}
		//else //throw exception here out of bounds
	}

	public boolean moveDown(Piece p) {
		updatePiece(p);
		if(aY+1< HEIGHT && bY+1 < HEIGHT && cY+1 < HEIGHT && dY+1 < HEIGHT)
		{
			if (!GRID[aY+1][aX] && !GRID[bY+1][bX] && !GRID[cY+1][cX] && !GRID[dY+1][dX])
			{
				p.modPos(0, GRIDSPACE);
				updatePiece(p);
				return true;
			}
			else {	//throw exception here cannot move down
				return false;	//CALL .addScore(checkRows) in Tetris Runner
			}
		}
		else //throw exception here out of bounds
		{
			return false;	//CALL .addScore(checkRows) in Tetris Runner
		}
	}

	public void rotate(Piece p) {
		p.rotate();
		updatePiece(p);
		if((aY<HEIGHT && bY<HEIGHT && cY<HEIGHT && dY<HEIGHT && aX<WIDTH && bX<WIDTH && cX<WIDTH && dX<WIDTH	// Checks if in grid
			&& aY>=0 && bY>=0 && cY>=0 && dY>=0 && aX>=0 && bX>=0 && cX>=0 && dX>=0)	// Checks if in grid
			&&(!GRID[aX][aY] || !GRID[bX][bY] || !GRID[cX][cY] || !GRID[dX][dY])) //Checks if conflicting spots
		{
			updatePiece(p);
		}
		else //throw exception unable to rotate (rotates back to original pos.)
		{
			p.rotate();
			p.rotate();
			p.rotate();
		}
	}


	public Piece makePiece() {
		Random rand = new Random();

		int l= rand.nextInt(7);
		if (l==0)
		{
			return new IPiece();
		}
		if (l==1)
		{
			return new JPiece();
		}
		if (l==2)
		{
			return new LPiece();
		}
		if (l==3)
		{
			return new OPiece();
		}
		if (l==4)
		{
			return new TPiece();
		}
		if (l==5)
		{
			return new ZPiece();
		}
		if (l==6)
		{
			return new ZPiece();//USE SPiece(); when SPiece is ready
		}
		else	//throw exception Impossible random number generated/ generate L shape
		{
			return new TPiece();
		}
	}

	public void updatePiece(Piece p) {
		aX=(int)(p.getPos("a","x")/GRIDSPACE);
		aY=(int)(p.getPos("a","y")/GRIDSPACE);
		bX=(int)(p.getPos("b","x")/GRIDSPACE);
		bY=(int)(p.getPos("b","y")/GRIDSPACE);
		cX=(int)(p.getPos("c","x")/GRIDSPACE);
		cY=(int)(p.getPos("c","y")/GRIDSPACE);
		dX=(int)(p.getPos("d","x")/GRIDSPACE);
		dY=(int)(p.getPos("d","y")/GRIDSPACE);
	}

	public void clearRow(int n) {

		for(int i=0;i<WIDTH;i++)
		{
			GRID[n][i]=false;	//empties row
		}

		for (n=n-1;n>0;n--)
		{
			for (int i=0;i<WIDTH;i++)
			{
				GRID[n+1][i]=GRID[n][i];	//Drops rows above down by 1
				GRID[n][i] = false;

			}
		}

	}

	public boolean updateBoard(Piece p) {
		updatePiece(p);

		if (!GRID[aY][aX] && !GRID[bY][bX] && !GRID[cY][cX] && !GRID[dY][dX])
		{
			GRID[aY][aX]=true;
			GRID[bY][bX]=true;
			GRID[cY][cX]=true;
			GRID[dY][dX]=true;
			updatePiece(p);
			return true;
		}

		else //already taken thus GAME OVER
			return false;

	}

}
