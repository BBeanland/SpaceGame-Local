package screen;
import org.lwjgl.Sys;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import java.nio.ByteBuffer;
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
/** Class for working with lwjgl */
public class Render {
	private static String Window_Title = "Space Invaders 3D!";
	public static int ScreenDim_X = 1280;
	public static int ScreenDim_Y = 720;
	private GLFWErrorCallback errorCallback;
	private GLFWKeyCallback keyCallback;
	private long window;
	// Screen objects
	Display disp = null;
	public void init() {
		disp = new Display();
		// Setup an error callback. The default implementation
		// will print the error message in System.err.
		glfwSetErrorCallback(errorCallback = errorCallbackPrint(System.err));
		// Initialize GLFW. Most GLFW functions will not work before doing this.
		if (glfwInit() != GL11.GL_TRUE)
			throw new IllegalStateException("Unable to initialize GLFW");
		// Configure our window
		glfwDefaultWindowHints(); // optional, the current window hints are already the default
		glfwWindowHint(GLFW_VISIBLE, GL_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE); // the window will be resizable
		// Create the window
		window = glfwCreateWindow(Render.ScreenDim_X, Render.ScreenDim_Y, Render.Window_Title, NULL, NULL);
		if(window == NULL)
			throw new RuntimeException("Failed to create the GLFW window");
		// Setup a key callback. It will be called every time a key is pressed, repeated or released.
		glfwSetKeyCallback(window, keyCallback = new GLFWKeyCallback() {
			@Override
			public void invoke(long window, int key, int scancode, int action, int mods) {
				if(key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
					glfwSetWindowShouldClose(window, GL_TRUE); // We will detect this in our rendering loop
				if(key == GLFW_KEY_RIGHT || key == GLFW_KEY_D)
					disp.movePlayer(true);			
				
			}
		});
		// Get the resolution of the primary monitor
		ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		// Center our window
		glfwSetWindowPos(
				window,
				(GLFWvidmode.width(vidmode) - Render.ScreenDim_X) / 2,
				(GLFWvidmode.height(vidmode) - Render.ScreenDim_Y) / 2
				);
		// Make the OpenGL context current
		glfwMakeContextCurrent(window);
		// Enable v-sync
		glfwSwapInterval(1);
		// Make the window visible
		glfwShowWindow(window);
	}
	public void run() {
		System.out.println();
		try {
			init();
			loop();
			// Release window and window callbacks
			glfwDestroyWindow(window);
			keyCallback.release();
		} finally {
			// Terminate GLFW and release the GLFWerrorfun
			glfwTerminate();
			errorCallback.release();
		}
	}
	public void loop() {
		GLContext.createFromCurrent();
		// Set the clear color
		glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
		// Run the rendering loop until the user has attempted to close
		// the window or has pressed the ESCAPE key.
		while ( glfwWindowShouldClose(window) == GL_FALSE ) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
			glfwSwapBuffers(window); // swap the color buffers
			// Poll for window events. The key callback above will only be
			// invoked during this call.
			glfwPollEvents();
		}
	}
}
