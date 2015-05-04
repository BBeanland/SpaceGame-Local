package screen;
import java.util.ArrayList;
import java.util.List;
import objects.Entity;
import utils.Point2D;
/** Holds objects on the screen */
public class Display {
	public static final int PlayerMoveAmount = 8;
	public static final int EntIndex_Player = 0;
	//public static final 
	List<Entity> entities = null;
	private Point2D playerPos;
	public Display() {
		entities = new ArrayList<Entity>();
		entities.add(new Entity(new Texture(Texture.TxPath_Default),0, new Point2D(0,0), new Point2D(Render.ScreenDim_X,Render.ScreenDim_Y)));
	}
	public void movePlayer(boolean dir) {
		int change = Display.PlayerMoveAmount * ((dir)?1:-1);
		playerPos.offsetPoint(change, 0);
		System.out.println("Moved Player");
	}
	public void drawGame() {
		entities.get(0).drawEntity();
	}
}
