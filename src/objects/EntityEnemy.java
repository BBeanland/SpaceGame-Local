package objects;
import screen.Texture;
import utils.Point2D;
public class EntityEnemy extends Entity {
	public EntityEnemy(int eType, Point2D p, Point2D dims) {
		super(new Texture(Texture.TxPath_Player), eType, p, dims);
	}
}
