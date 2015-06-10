package russia.model;

import java.awt.Color;
import java.awt.Graphics;
import russia.listener.ShapeListener;
import russia.util.Global;

public class Shape {
	/**
	 * ͼ�ε���״���ǶԳ�ͼ�Σ��磺7���Σ�Ϊ4�֣���Գ�ͼ�Σ��磺������Ϊ2�֣�ȫ�Գ�ͼ�Σ��磺���飩Ϊ1��
	 */
	private int[][] body;
	/**
	 * ͼ��״̬����ͬ��ת�Ƕȣ�����ʾ��ǰͼ�δ��ڵڼ���״̬
	 */
	private int status;
	/**
	 * ͼ�ξ���߽����
	 */
	private int left;
	/**
	 * ͼ�ξ��ϱ߽����
	 */
	private int top;
	private ShapeListener listener;

	/**
	 * �������ʱ����
	 */
	public Shape() {
		new Thread(new ShapeDirver()).start();
	}
	public void setBody(int body[][]) {
		this.body = body;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void addShapeListener(ShapeListener listener) {
		if(listener != null)
			this.listener = listener;
	}
	/**
	 * ����
	 */
	public void moveLeft() {
		left--;
	}
	public void moveRight() {
		left++;
	}
	public void moveDown() {
		top++;
	}
	/**
	 * ��ת
	 */
	public void rotate() {
		status = (status + 1) % body.length;
	}
		
	/**
	 * 16��Ԫ�أ�4��4�У�����1����fill
	 * @param g
	 */
	public void drawMe(Graphics g) {
		g.setColor(Color.BLUE);
		for(int x=0; x<4; x++) 
			for(int y=0; y<4; y++) {
				if(getFlagByPoint(x,y)) {
					g.fill3DRect((x + left) * Global.CELL_SIZE, (y + top) * Global.CELL_SIZE, 
							Global.CELL_SIZE, Global.CELL_SIZE, true);
				}
			}
	}
	
	public int getLeft() {
		return left;
	}
	
	public int getTop() {
		return top;
	}
	
	private class ShapeDirver implements Runnable {
		@Override
		public void run() {
			while(true) {
					moveDown();
					listener.shapeMovedDown(Shape.this);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * �ж��ض��������Ƿ�Ϊ1
	 * @param x �����꣨�����Ͻǿ�ʼ��
	 * @param y �����꣨�����Ͻǿ�ʼ��
	 * @return
	 */
	private boolean getFlagByPoint(int x,int y) {
		return body[status][y * 4 + x] == 1;
	}
}
