package russia.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import russia.listener.ShapeListener;
import russia.model.Shape;
import russia.model.ShapeFactory;
import russia.view.GamePanel;

public class Controller extends KeyAdapter implements ShapeListener{

	private Shape shape;
	private ShapeFactory shapeFactory;
	private GamePanel gamePanel;
	
	public Controller(ShapeFactory shapeFactory, 
			GamePanel gamePanel) {
		super();
		this.shapeFactory = shapeFactory;
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				shape.rotate();
				break;
			case KeyEvent.VK_DOWN:
				shape.moveDown();
				break;
			case KeyEvent.VK_LEFT:
				shape.moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				shape.moveRight();
				break;
		}
		gamePanel.redisplay(shape);
	}
	
	public void newGame() {
		//生产一个图形
		shape = shapeFactory.getShape(this);
	}

	@Override
	public void shapeMovedDown(Shape shape) {		
		if(gamePanel != null) {
			gamePanel.redisplay(shape);
		}
	}
	
	public GamePanel getGamePanel() {
		return this.gamePanel;
	}
}
