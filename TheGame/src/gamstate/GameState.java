package gamstate;

import java.awt.Graphics2D;

public abstract class GameState {
	GameStateManager gsm;
	
	public GameState(GameStateManager gsm){
		this.gsm = gsm;
	}
	
	public abstract void tick(double deltaTime);
	public abstract void render(Graphics2D g);
}
