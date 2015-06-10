package russia.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import russia.model.Shape;
import russia.util.Global;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Shape shape;
	
	public GamePanel() {
		this.setSize(Global.WIDTH * Global.CELL_SIZE,
				Global.HEIGHT * Global.CELL_SIZE );
	}
	
	@Override
	public void paint(Graphics g) {
		//�ػ���壬����ԭ������
		g.setColor(new Color(0xcfcfcf));
		g.fillRect(0, 0, Global.WIDTH * Global.CELL_SIZE, 
				Global.HEIGHT * Global.CELL_SIZE);
	
		//�ػ�ͼ��
		if(shape != null)
			this.shape.drawMe(g);
	}

	public void redisplay(Shape shape) {
		this.shape = shape;
		this.repaint();
	}
}
