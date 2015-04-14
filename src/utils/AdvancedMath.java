package utils;
import java.lang.Math;
/** Used for things like: 
  * Center of gravity,
  * Distance formula,
  * Pythagorean's Theorem,
  * Angle calculations,
  * and other complex calculations.*/
public final class AdvancedMath {
	/** Finds the absolute value angle at pntJ between pnt1 and pnt2 in degrees */
	public static double angleDifference(Point2D pnt1, Point2D pntJ, Point2D pnt2) {
		double dx, dy;
		dx = pnt1.getCoords()[0]-pntJ.getCoords()[0];
		dy = pnt1.getCoords()[1]-pntJ.getCoords()[1];
		double ang1 = Math.atan(dy/dx);
		if(pnt1.getCoords()[0] < 0)
			ang1 += Math.PI;
		// same for other angle
		dx = pnt2.getCoords()[0]-pntJ.getCoords()[0];
		dy = pnt2.getCoords()[1]-pntJ.getCoords()[1];
		double ang2 = Math.atan(dy/dx);
		if(pnt2.getCoords()[0] < 0)
			ang2 += Math.PI;
		return ang2 - ang1;
	}
}
