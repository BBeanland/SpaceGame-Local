package screen;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import utils.Point2D;
import de.matthiasmann.twl.utils.PNGDecoder;
public class Texture {
	private InputStream fileIn = null;
	private PNGDecoder decoder = null;
	private Point2D dims = null;
	private ByteBuffer buff = null;
	/** Load an image from a file name */
	public Texture(String filename) {
		try {
			fileIn = new FileInputStream(filename);
			decoder = new PNGDecoder(fileIn);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error occurred. Exiting...");
			System.exit(-1);
		}
		dims = new Point2D(decoder.getWidth(), decoder.getHeight());
	}
}
