package objects;
import screen.Render;
import screen.Texture;
import utils.Point2D;
public class Entity {
	Point2D pos = null;  
	Texture tex;
	/** See move; time that has passed per move */
	long delta; 
	/** Will contain the speed of the entity horiz and vertically in pixels per second */
	Point2D move; //careful because of ints? do we want to change to double?
	
	
	public Entity(int eType, Point2D pPos, Point2D bBox) {
		//can we make the entity get the screen too? we need it for dx dy changes as well as resizing
		pos = pPos;
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
	 * 	delta is the amount of time that has passed in milliseconds
	 */
	public void move(long delta) {
		// will update the location of the entity based on move speeds
		int moveX = move.getCoords()[0];
		int moveY = move.getCoords()[1];
		int x = (int)(delta * moveX) /60;
		int y = (int)(delta * moveY) /60;
		pos.offsetPoint(x,y);
	}
	/** Does logic for this entity about concurrent events and if certain things happen? */
	public void doLogic() {
		
	}

	public boolean collidesWith(Entity other) {
		//set bounds and then check for collision
		int tPosX = pos.getCoords()[0];
		int tPosY = pos.getCoords()[1];
		int oPosX = other.getCoords()[0];
		int oPosY = other.get.getCoords()[1];
		if()
		return false;
	}
}