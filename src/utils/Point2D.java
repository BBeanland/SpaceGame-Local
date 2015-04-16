package utils;
import screen.Render;
/** A point in 2D space, or a Box */
public class Point2D {
	private int x, y;
	public Point2D() {
		x = Render.ScreenDim_X/2;
		y = Render.ScreenDim_Y/2;
	}
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int[] getCoords() {
		int [] ret = {this.x, this.y};
		return ret;
	}
	public void offsetPoint(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
}
