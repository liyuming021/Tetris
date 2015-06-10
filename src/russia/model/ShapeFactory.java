package russia.model;

import java.util.Random;

import russia.listener.ShapeListener;

public class ShapeFactory {
	/**
	 * 图形库
	 */
	private int shapes[][][] = new int[][][]{
		{
			{	1,0,0,0,	1,1,1,0,
				0,0,0,0,	0,0,0,0
			},
			{	1,1,0,0,	1,0,0,0,
				1,0,0,0,	0,0,0,0
			},
			{	1,1,1,0,	0,0,1,0,
				0,0,0,0,	0,0,0,0
			},
			{	0,1,0,0,	0,1,0,0,
				1,1,0,0,	0,0,0,0
			}
		}
	};
	/**
	 * 获得图形，启动移动，并注册listener
	 * @param listener
	 * @return
	 */
	public Shape getShape(ShapeListener listener) {
		Shape shape = new Shape();
		//给本图形添加通知controller的监听器
		shape.addShapeListener(listener);
		
		//指定形状
		int type = new Random().nextInt(shapes.length);
		shape.setBody(shapes[type]);
		//默认第一种状态
		shape.setStatus(0);
		return shape;
	}
}
