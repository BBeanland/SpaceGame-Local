package utils;
import screen.Render;
/** A point in 2D space, or a Box */ // we should just revert this back to just ints and then just use ints as a box like a box could be 2 x 3 so rep by (2,3)
public class Point2D {
	private int x, y;
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int[] getCoords() { 
		int [] ret = {x, y};
		return ret;
	}
	public void offsetPoint(int dx, int dy) {
		x += dx;
		y += dy;
	}
	public boolean makeInside() {
		boolean inside = (x>=0 && x<=Render.ScreenDim_X) &&
				(y>=0 && y<=Render.ScreenDim_Y);
		if(!inside) {
			// move back to nearest edge inside
			if(x<0)
				x = 0;
			if(x>Render.ScreenDim_X)
				x = Render.ScreenDim_X;
			if(y<0)
				y = 0;
			if(y>Render.ScreenDim_Y)
				y = Render.ScreenDim_Y;
		}
		return inside;	
	}
}
