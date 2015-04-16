package screen;
import objects.Entity;
import utils.Point2D;
/** Holds objects on the screen */
public class Display {
	public static final int PlayerMoveAmount = 8;
	private Entity playerEnt;
	public Display() {
		playerEnt = new Entity(0, new Point2D());
		//if(playerEnt.)
	}
	public void movePlayer(boolean dir) {
		int change = Display.PlayerMoveAmount * ((dir)?1:-1);
		playerPos.offsetPoint(change, 0);
		System.out.println("Moved Player");
	}
}
