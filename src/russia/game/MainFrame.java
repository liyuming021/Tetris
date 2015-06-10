package russia.game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import russia.controller.Controller;
import russia.model.ShapeFactory;
import russia.util.Global;
import russia.view.GamePanel;

public class MainFrame extends JFrame {

	/**
	 * version 1.0
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrame mainFrame;
	public MainFrame(Controller controller){		
		this.setTitle("����˹������Ϸ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Global.WIDTH * Global.CELL_SIZE  + 8,
				Global.HEIGHT * Global.CELL_SIZE + 25);
		this.setResizable(false);
		//�����Ϸ���
		this.add(controller.getGamePanel(),BorderLayout.CENTER);	
		//��Ӱ���������
		this.addKeyListener(controller);
	}
	
	public static void main(String[] args) {
		startGame();
	}
	
	public static void stopGame() {
		mainFrame.dispose();
		mainFrame = null;
	}
	
	public static void startGame() {
		ShapeFactory shapeFacory = new ShapeFactory();		
		GamePanel gamePanel = new GamePanel();
		Controller controller = new Controller(shapeFacory,gamePanel);
		mainFrame = new MainFrame(controller);
		mainFrame.setVisible(true);		
		controller.newGame();
	}
}
