package russia.model;

import java.util.Random;

import russia.listener.ShapeListener;

public class ShapeFactory {
	/**
	 * ͼ�ο�
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
	 * ���ͼ�Σ������ƶ�����ע��listener
	 * @param listener
	 * @return
	 */
	public Shape getShape(ShapeListener listener) {
		Shape shape = new Shape();
		//����ͼ�����֪ͨcontroller�ļ�����
		shape.addShapeListener(listener);
		
		//ָ����״
		int type = new Random().nextInt(shapes.length);
		shape.setBody(shapes[type]);
		//Ĭ�ϵ�һ��״̬
		shape.setStatus(0);
		return shape;
	}
}
