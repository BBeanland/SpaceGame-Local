package objects;

import utils.Point2D;

public class SpaceShip extends Entity {
	
	public SpaceShip(int eType, Point2D pPos, Point2D bBox) { //we can make bBox the texture size :3 // we havent used eType yet
		super(eType, pPos,bBox); 
		standardMove(400,400); //changes the move we dont have to use the method 
	}
	public void move(long delta) {
		//if we have moved to the left or right side then dont move
		int[] speeds = move.getCoords();
		int[] position = pos.getCoords();
		if ((speeds[0] < 0) && position[0] < 0 ) {//position  is less than 1/2 box length and speed is neg then 
			// out of bounds
			return;
		}
		// if we're moving right and have reached the right hand side

		// of the screen, don't move

		if ((speeds[0] > 0) && (position[0]> game.getWidth- Boxwidth/2)) {// then out of bounds
			return;
		}
		
		super.move(delta);
	}
}
