package game;
import screen.Render;
/** Main class for our game. */
public class Game {
	private Render render = null;
	public void runGame() {
		render = new Render();
		render.run();
	}
	public static void main(String[] args) {
		new Game().runGame();
	}
}
