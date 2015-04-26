package objects;
import screen.Render;
import screen.Texture;
import utils.Point2D;
public class Entity {
	Point2D pos = null;  
	Texture tex;
	
	long delta; //see move; time that has passed per move
	/** will contain the speed of the entity horiz and vertically in (pixels/ a second??) */
	Point2D move; //careful because of ints? do we want to change to double?
	
	
	public Entity(int eType, Point2D p) { //can we make the entity get the screen too? we need it for dx dy changes as well as resizing
		pos = p;
		move = new Point2D(500,500); //we need to test to determine a manageable speed
	}
	
	/** return the center of gravity of the image based on pixels */
	public int[] getCOG() {
		int cog [] = {Render.ScreenDim_X/2,Render.ScreenDim_Y/2};
		return pos.getCoords();
	}
	public Texture getTexture() { //is the texture auto re-adjustable?
		return tex;
	}
	/** The entity will move itself based on a certain amount of time passing.
	 * delta is the amount of time that has passed in milliseconds
	 */
	public void move(long delta) {
		// will update the location of the entity based on move speeds
		int[] currentSpeed = this.getSpeeds();
		int moveX = currentSpeed[0];
		int moveY = currentSpeed[1];
		int x = (delta * moveX) / 1000;
		int y = (delta * moveY) / 1000;
		pos.offsetPoint(x,y);
	}

	/** Returns an array with the horizontal and vertical speeds of the entity */
	public int[] getSpeeds() {
		return move.getCoords();
	}
	/** Does logic for this entity about concurrent events and if certain things happen? */
	public void doLogic() {
	}

	public boolean collidesWith(Entity other) {
		//set bounds and then check for collision
		return false;
	}
}