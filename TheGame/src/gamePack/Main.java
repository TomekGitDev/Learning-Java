package gamePack;
import gameloop.GameLoop;
import gfPackage.Script1;
import gfPackage.SpriteSheet;;

public class Main {

	static SpriteSheet blocks = new SpriteSheet();
	
	public static void main(String[] args) {
		Script1 frame = new Script1("game", 800, 600);
		frame.setFullscreen(0);
		frame.add(new GameLoop(1280,720));
		frame.setVisible(true);
		blocks.getTile(0, 0, 8, 8);
	}
	
	

}
