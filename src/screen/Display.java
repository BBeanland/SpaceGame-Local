package screen;
import objects.Entity;
import utils.Point2D;
/** Holds objects on the screen */
public class Display {
	public static final int PlayerMoveAmount = 8;
	private Entity playerEnt;
	private Point2D playerPos;
	public Display() {
		playerEnt = new Entity(0, new Point2D(0,0), new Point2D(Render.ScreenDim_X,Render.ScreenDim_Y));
		//if(playerEnt.)
	}
	public void movePlayer(boolean dir) {
		int change = Display.PlayerMoveAmount * ((dir)?1:-1);
		playerPos.offsetPoint(change, 0);
		System.out.println("Moved Player");
	}
}
