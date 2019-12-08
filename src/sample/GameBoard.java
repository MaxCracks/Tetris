package sample;
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
		GRID = new boolean [20][10]; 
		for (int j = 0; j<20;j++)
		{
			for (int i=0;i<10;i++)
			{
				GRID [j][i]=false;
			}
		}
		WIDTH = 10;
		HEIGHT = 20;
		aX=0; aY=0;
		bX=0; bY=0;
		cX=0; cY=0;
		dX=0; dY=0;
		GRIDSPACE = 25;
	}
	public void moveLeft(Piece p) {
	
		if(aX-1>=0 && bX-1>=0 && cX-1>=0 && dX-1>=0) {
	
		
			if (GRID[aX-1][aY]!=true && GRID[bX-1][bY]!=true && GRID[cX-1][cY]!=true && GRID[dX-1][dY]!=true)
			{
					p.modPos(-1*GRIDSPACE,0);
					updatePiece(p);
			}
			
			//else //throw exception here cannot move left
	
		}
		//else //throw exception here out of bounds
	}
	public void moveRight(Piece p) {
		if(aX+1<=WIDTH && bX+1<=WIDTH && cX+1<=WIDTH && dX+1<=WIDTH) {
			
			
			if (GRID[aX+1][aY]!=true && GRID[bX+1][bY]!=true && GRID[cX+1][cY]!=true && GRID[dX+1][dY]!=true)
			{
				p.modPos(1*GRIDSPACE,0);
				updatePiece(p);
			}
			
			//else //throw exception here cannot move right
		}
		//else //throw exception here out of bounds
	}
	
	public boolean moveDown(Piece p) {
		if(aY+1<=HEIGHT && bY+1<=HEIGHT && cY+1<=HEIGHT && dY+1<=HEIGHT)
		{
			if (GRID[aX][aY+1]!=true && GRID[bX][bY+1]!=true && GRID[cX][cY+1]!=true && GRID[dX][dY+1]!=true)
			{
				p.modPos(0,1*GRIDSPACE);
				updatePiece(p);
				return true;
			}
			else {	//throw exception here cannot move down
				updateBoard(p);	//end of turn so updates board
				return false;	//CALL .addScore(checkRows) in Tetris Runner
			}
		}
		else //throw exception here out of bounds
		{
			updateBoard(p);	//end of turn so updates board 
			return false;	//CALL .addScore(checkRows) in Tetris Runner
		}
	}
		
	public void rotate(Piece p) {
		p.rotate();
		updatePiece(p);
		if((aY<=HEIGHT && bY<=HEIGHT && cY<=HEIGHT && dY<=HEIGHT && aX<=WIDTH && bX<=WIDTH && cX<=WIDTH && dX<=WIDTH	// Checks if in grid
			&& aY>=0 && bY>=0 && cY>=0 && dY>=0 && aX>=0 && bX>=0 && cX>=0 && dX>=0)	// Checks if in grid
			&&(GRID[aX][aY]==false || GRID[bX][bY]==false || GRID[cX][cY]==false || GRID[dX][dY]==false)) //Checks if conflicting spots	
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
			return new ZPiece();
		}
		if (l==1)
		{
			return new SPiece();
		}
		if (l==2)
		{
			return new LPiece();
		}
		if (l==3)
		{
			return new IPiece();
		}
		if (l==4)
		{
			return new TPiece();
		}
		if (l==5)
		{
			return new OPiece();
		}
		if (l==6)
		{
			return new JPiece();
		}
		else	//throw exception Impossible random number generated/ generate L shape
		{
			return new LPiece();
		}
	}
	
	/*
	 * MOVE TO TETRIS CLASS
	 
	 public int checkRows() {
		int clearedRows = 0;
		for (int j=0;j<HEIGHT;j++) {
			int colFull=0;	//resets counter every row iteration
			for (int i=0;i<WIDTH;i++) {
				if (GRID[j][i]==true)	//occupied grid position
					colFull++;
			}
			if (colFull==WIDTH) {
				clearRow(j);	//clear the row and drop above
				j--;	//since rows above dropped one
				clearedRows++;	//number of cleared rows in one turn increment
			}
		}
		return clearedRows;
		
	}
	
	public int addScore(int clearedRows) {
		if (clearedRows==1)
			return 40;
		if (clearedRows==2)
			return 100;
		if (clearedRows==3)
			return 300;
		if (clearedRows==4)
			return 1200;
	/*	else if (clearedRows!=0)
		{
			//throw exception here should not be possible
		}
		return 0;
	}
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
	
	public void clearRow(int n) {	
		
		for(int i=0;i<=WIDTH;i++)
		{
			GRID[n][i]=false;	//empties row
		}
		
		for (n=n-1;n>=0;n--)	
		{
			for (int i=0;i<=WIDTH;i++)
			{
				GRID[n+1][i]=GRID[n][i];	//Drops rows above down by 1
			}
		}
		for (int i=0;i<=WIDTH;i++)	
		{
			GRID[0][i]=false;	//For top row to be set to zero b/c nothing above
		}
		
	}
	
	public boolean updateBoard(Piece p) {	
		updatePiece(p);
		
		if (GRID[aX][aY]!=true && GRID[bX][bY]!=true && GRID[cX][cY]!=true && GRID[dX][dY]!=true)
		{
			GRID[aX][aY]=true;
			GRID[bX][bY]=true;
			GRID[cX][cY]=true;
			GRID[dX][dY]=true;
			updatePiece(p);
			return true;
		}
		
		else //already taken thus GAME OVER
			return false;
		
	}
	
}