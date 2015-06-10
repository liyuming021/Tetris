package russia.model;

import java.awt.Color;
import java.awt.Graphics;
import russia.listener.ShapeListener;
import russia.util.Global;

public class Shape {
	/**
	 * 图形的形状：非对称图形（如：7字形）为4种，轴对称图形（如：长条）为2种，全对称图形（如：方块）为1种
	 */
	private int[][] body;
	/**
	 * 图形状态（不同旋转角度），表示当前图形处于第几种状态
	 */
	private int status;
	/**
	 * 图形距左边界格数
	 */
	private int left;
	/**
	 * 图形距上边界格数
	 */
	private int top;
	private ShapeListener listener;

	/**
	 * 构造对象时启动
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
	 * 左移
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
	 * 旋转
	 */
	public void rotate() {
		status = (status + 1) % body.length;
	}
		
	/**
	 * 16个元素，4行4列，若是1，就fill
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
	 * 判断特定点数据是否为1
	 * @param x 横坐标（从左上角开始）
	 * @param y 纵坐标（从左上角开始）
	 * @return
	 */
	private boolean getFlagByPoint(int x,int y) {
		return body[status][y * 4 + x] == 1;
	}
}
