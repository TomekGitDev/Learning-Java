package gfPackage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class IDGameLoop extends JPanel implements Runnable {
	private Thread thread;
	private boolean running;
	
	private int fps;
	private int tps;
	
	private int width;
	private int height;
	
	public Graphics2D graphics2d;
	private BufferedImage img;
	
	public static double currFPS = 60D;
	
	
	public IDGameLoop(int width, int height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
		
		setPreferredSize(new Dimension(width, height));
		setFocusable(false);
		requestFocus();
	}
	
	@Override
	public void addNotify() {
		// TODO Auto-generated method stub
		super.addNotify();
		
		if(thread == null){
			thread = new Thread(this);
			thread.start();
			
		}
	}
	
	
	@Override
	public void run() {
		
		init();
		
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / currFPS;
		int frames = 0;
		int ticks = 0;
		long lastTimer = System.currentTimeMillis();
		double deltaTime = 0D;
		while(running){
			long now = System.nanoTime();
			deltaTime += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = false;
			
			while(deltaTime >= 1){
				ticks++;
				tick(deltaTime);
				
				deltaTime -= 1;
				shouldRender = true;
			}
			
			if (shouldRender) {
				frames++;
				render();
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(System.currentTimeMillis() - lastTimer >= 1000){
				lastTimer += 1000;
				tps = frames;
				fps = ticks;
				frames = 0;
				ticks = 0;
			}
		}
		
		
	}

	public void init() {
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		graphics2d = (Graphics2D) img.getGraphics();
		
		running = true;
	}
	
	public void tick(double deltaTime) {
		// TODO Auto-generated method stub
		
	}
	
	public void render() {
		graphics2d.clearRect(0, 0, width, height);
	}
	
	public void clear(){
		Graphics g2 = getGraphics();
		if (img != null) {
			g2.drawImage(img, 0, 0, null);
		}
		g2.dispose();
	}

}
