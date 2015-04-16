package objects;
import screen.Render;
import screen.Texture;
import utils.Point2D;
public class Entity {
	Point2D pos = null;
	Texture tex;
	public Entity(int eType, Point2D p) {
		pos = p;
	}
	/** return the center of gravity of the image based on pixels */
	public int[] getCOG() {
		int cog [] = {Render.ScreenDim_X/2,Render.ScreenDim_Y/2};
		return pos.getCoords();
	}
	public Texture getTexture() {
		return tex;
	}
}