import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;


import java.util.ArrayList;


public class MainPanel extends JPanel{
	private final ArrayList<Point> points = new ArrayList<Point>();
	private Color current;
	private int size;
	
	public MainPanel()
	{
		addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent event1) {
				Point p = new Point(event1.getX(), event1.getY(), size, current);
				points.add(p);
				repaint();
			}
		});
			
		addMouseMotionListener(new MouseMotionAdapter(){
			@Override
			public void mouseDragged(MouseEvent event2){
				Point p = new Point(event2.getX(), event2.getY(), size, current);
				points.add(p);
				repaint();
			}
		});
		current = Color.black;
		size = 3;
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for (Point point: points){
			g.setColor(point.getColor());
			g.fillOval(point.getX(), point.getY(), point.getSize(), point.getSize());
		}
	}
	
	public void clearCanvas() {
		points.clear();
		repaint();
	}
	
	public void changePenColor(Color c) {
		current = c;
	}
	
	public void changePenSize(int size1) {
		size = size1;
	}
}
		



