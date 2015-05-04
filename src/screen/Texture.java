package screen;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import utils.Point2D;
import de.matthiasmann.twl.utils.PNGDecoder;
import de.matthiasmann.twl.utils.PNGDecoder.Format;
public class Texture {
	public static final String TxPath_Player = "spr/spr_player.png";
	public static final String TxPath_Default = "spr/def_tex.png";
	private InputStream fileIn = null;
	private PNGDecoder decoder = null; //do I import PNG Decoder? 
	private Point2D dims = null;
	private ByteBuffer buff = null;
	/** Load an image from a file name */
	public Texture(String filename) {
		try {
			fileIn = new FileInputStream(filename);
			decoder = new PNGDecoder(fileIn);
			buff = ByteBuffer.allocateDirect(4*decoder.getWidth()*4*decoder.getWidth());
			decoder.decode(buff, decoder.getWidth(), Format.RGBA);
			buff.flip();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error occurred. Exiting...");
			System.exit(-1);
		}
		dims = new Point2D(decoder.getWidth(), decoder.getHeight());
	}
	public PNGDecoder getDecoder() {
		return this.decoder;
	}
	public ByteBuffer getBuff() {
		return buff;
	}
}
