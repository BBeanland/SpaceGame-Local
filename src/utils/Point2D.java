package utils;
import screen.Render;
/** A point in 2D space, or a Box */ // we should just revert this back to just ints and then just use ints as a box like a box could be 2 x 3 so rep by (2,3)
public class Point2D<Type> {
	private Type x, y;
	public Point2D(Type x, Type y) {
		this.x = x;
		this.y = y;
	}
	public int[] getCoords() { 
		Type [] ret = {this.x, this.y};
		return ret;
	}
	public void offsetPoint(int dx, int dy) {
		(int)x += (int)dx;
		//(int)this.y += (int)dy;
	}
}
