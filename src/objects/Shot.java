package objects;

import utils.Point2D;

public class Shot extends Entity{
	//make not exactly within boundaries 
	//pos will be the enemy entity pos + his 1/2 box + 1 
	boolean alien = false;
	public Shot(int eType, Point2D pPos, Point2D bBox) {
		super(eType, pPos, bBox); //make from player
		standardMove(300,500);
		if(eType = 3 ) {
			alien = true; //if alien then we cant enable friendly fire
		}
	}

	/** The vertical speed at which the players shot moves */
	private double moveSpeed = -300;
	
	public void move(long delta) {
		// proceed with normal move

		super.move(delta);
		
		// if off the screen, remove ourselves

		if (y < 0) {
			game.removeEntity(this);
		}
	}

	public void collidedWith(Entity other) {
		
			// remove the affected entities
// use the alien thing ill do that later ad make the alien class
			game.removeEntity(this);
			game.removeEntity(other);
			game.notifyAlienKilled();//aka plus points and stuff
			
	}
}

