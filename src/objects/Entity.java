package objects;
import screen.Render;
import screen.Texture;
import utils.Point2D;
public class Entity {
	Point2D pos;  
	Texture tex;
	/** See move; time that has passed per move */
	long delta; 
	/** Will contain the speed of the entity horiz and vertically in pixels per second */
	Point2D move; //careful because of ints? do we want to change to double?
	// WE need to revert changes so that we can set the x and y speed again because we need it 
	
	
	public Entity(int eType, Point2D pPos, Point2D bBox) {
		// WE NEED THE SCREEN to notify deaths?
		//can we make the entity get the screen too? we need it for dx dy changes as well as resizing
		pos = pPos;
		move = new Point2D(500,500);
	}
	/** return the center of gravity of the image based on pixels */
	public int[] getCOG() {
		return pos.getCoords();
	}
	public Texture getTexture() { //is the texture auto re-adjustable?
		return tex;
	}
	/** The entity will move itself based on a certain amount of time passing.
	 * 	delta is the amount of time that has passed in milliseconds
	 */
	public void move(double deltaX, double deltaY) {
		// will update the location of the entity based on move speeds
		pos.offsetPoint((int)(deltaX * move.getCoords()[0])/60,
				(int)(deltaY * move.getCoords()[1])/60);
	}
	/** Does logic for this entity about concurrent events and if certain things happen? */
	public void doLogic() {
		
	}

	public boolean collidesWith(Entity other) {
		// Set bounds and then check for collision.
		// Just use the bounds class
		int posX = pos.getCoords()[0];
		int posY = pos.getCoords()[1];
		int oPosX = other.getCoords()[0];
		int oPosY = other.get.getCoords()[1];
		if()
			
		return false;
	}
}