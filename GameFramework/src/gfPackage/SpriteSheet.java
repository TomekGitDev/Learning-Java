package gfPackage;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage spritesheet;
	
	public void setSpritesheet(BufferedImage spritesheet) {
		this.spritesheet = spritesheet;
	}
	
	public BufferedImage getTile(int xTile, int yTile, int width, int height) {
		BufferedImage sprite = spritesheet.getSubimage(xTile, yTile, width, height);
		return sprite;
	}
	
}
