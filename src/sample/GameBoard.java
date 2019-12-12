package sample;

import sample.Piece;

import java.util.*;

/**
 * The GameBoard class implements Board interface,
 * used to control Pieces and set rules for actions.
 */

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

	/**
	 * Creates a GameBoard object
	 */
	public GameBoard() {
		GRID = new boolean [24][12];
		for (int j = 0; j<24;j++)
		{
			for (int i=0;i<12;i++)
			{
				GRID [j][i]=false;		//makes all grid spaces empty
			}
		}
		WIDTH = 12;		//# of columns
		HEIGHT = 24;	//# of rows
		GRIDSPACE = 25;	//size of each grid box
		aX=0; aY=0;
		bX=0; bY=0;
		cX=0; cY=0;
		dX=0; dY=0;
	}
	
	/**
	 * Moves Piece left if movement is valid
	 * @param p - The Piece being moved
	 */
	public void moveLeft(Piece p) {

		if(aX-1>=0 && bX-1>=0 && cX-1>=0 && dX-1>=0) {		//checks if in grid space


			if (!GRID[aY][aX - 1] && !GRID[bY][bX-1] && !GRID[cY][cX-1] && !GRID[dY][dX-1])		//checks if grid spaces to the left are taken
			{
					p.modPos(-1*GRIDSPACE,0);
					updatePiece(p);
			}

			//else cannot move left

		}
		//else out of bounds
	}
	
	/**
	 * Moves Piece right if movement is valid
	 * @param p - The Piece being moved
	 */
	public void moveRight(Piece p) {
		if(aX+1 < WIDTH && bX+1 < WIDTH && cX+1 < WIDTH && dX+1 < WIDTH) {		//checks if in grid space


			if (!GRID[aY][aX+1] && !GRID[bY][bX+1] && !GRID[cY][cX+1] && !GRID[dY][dX+1])		//checks if grid spaces to the right are taken
			{
				p.modPos(GRIDSPACE,0);
				updatePiece(p);
			}

			//else cannot move right
		}
		//else out of bounds
	}
	
	/**
	 * Moves Piece down if movement is valid
	 * @param p - The Piece being moved
	 * @return If Piece was moved down successfully
	 */
	public boolean moveDown(Piece p) {
		updatePiece(p);
		if(aY+1< HEIGHT && bY+1 < HEIGHT && cY+1 < HEIGHT && dY+1 < HEIGHT)		//checks if in grid space
		{
			if (!GRID[aY+1][aX] && !GRID[bY+1][bX] && !GRID[cY+1][cX] && !GRID[dY+1][dX])	//checks if grid spaces below are taken
			{
				p.modPos(0, GRIDSPACE);
				updatePiece(p);
				return true;
			}
			else //Cannot move down
			{	
				return false;	
			}
		}
		else //Out of bounds
		{
			return false;	
		}
	}
	
	/**
	 * Rotates Piece once if rotation is valid
	 * @param p - The Piece being moved
	 */
	public void rotate(Piece p) {
		p.rotate();		
		updatePiece(p);
		if((aY<HEIGHT && bY<HEIGHT && cY<HEIGHT && dY<HEIGHT && aX<WIDTH && bX<WIDTH && cX<WIDTH && dX<WIDTH	// Checks if in grid
			&& aY>=0 && bY>=0 && cY>=0 && dY>=0 && aX>=0 && bX>=0 && cX>=0 && dX>=0)	// Checks if in grid
			&&(GRID[aY][aX]==false|| GRID[bY][bX] ==false|| !GRID[cY][cX]==false || !GRID[dY][dX]==false)) //Checks if conflicting spots
		{
			updatePiece(p);		//Spot valid, will save position
		}
		else //Unable to rotate (rotates back to original position)
		{
			p.rotate();
			p.rotate();
			p.rotate();
			updatePiece(p);
		}
	}

	/**
	 * Randomly chooses new Piece
	 * @return The random Piece generated
	 */
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
			return new SPiece(); 
		}
		else	//Impossible random number generated/ generate a T shape
		{
			return new TPiece();
		}
	}

	/**
	 * Updates x,y values for all rectangles of a Piece
	 * @param p - The Piece being updated
	 */
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
	
	/**
	 * Clears a row and drops all above rows down
	 * @param n - The row being cleared
	 */
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
				GRID[n][i] = false;			//Clears row above 

			}
		}

	}

	/**
	 * Updates GRID with new piece (end of turn)
	 * @param p - The Piece being added to the board
	 * @return If Piece was added to board successfully
	 */
	public boolean updateBoard(Piece p) {
		updatePiece(p);	

		if (!GRID[aY][aX] && !GRID[bY][bX] && !GRID[cY][cX] && !GRID[dY][dX])	//checks if grid spaces are available
		{
			GRID[aY][aX]=true;	
			GRID[bY][bX]=true;
			GRID[cY][cX]=true;
			GRID[dY][dX]=true;
			updatePiece(p);
			return true;	//set all grid spaces of piece to occupied and updates piece position
		}

		else //already taken thus GAME OVER
			return false;

	}

}
