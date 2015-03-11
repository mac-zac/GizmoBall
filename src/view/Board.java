package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import physics.LineSegment;
import physics.Vect;
import model.AbsorberGizmo;
import model.Ball;
import model.CircleGizmo;
import model.Flipper;
import model.Praser;
import model.Model;
import model.SquareGizmo;
import model.TriangleGizmo;


public  class Board extends JPanel implements Observer {
	 int x1,x2,y1,y2;

	private static final long serialVersionUID = 1L;
	protected int width;
	protected int height;
	protected Model gm;
	private AffineTransform transform = new AffineTransform();

	public Board(int w, int h, Model m) {
		// Observe changes in Model
		m.addObserver(this);
		width = w;
		height = h;
		gm = m;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	// Fix onscreen size
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		
		 x1 = 50;
			x2 = 250;
			y1 = 50;
			y2 = 250;
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		
		g2.drawLine(x1,y1,x2,y1);
		g2.drawLine(x1,y1,x1,y2);
		g2.drawLine(x2,y2,x1,y2);
		g2.drawLine(x2,y2,x2,y1);

		// Draw all triangles
		for (TriangleGizmo tr : gm.getTriangle()) {
			g2.setColor(tr.getColor());
//			int[] xPoints = { tr.getX()+tr.getSize() , tr.getX(), tr.getX()+tr.getSize()};
//			int[] yPoints = { tr.getY(), tr.getY()+tr.getSize(), tr.getY()+tr.getSize() };
			ArrayList<LineSegment> lines = tr.getLSegments();

			Polygon poly = new Polygon();
			
			for(LineSegment aLine : lines ){
			Vect a = aLine.p1();
			Vect b = aLine.p2();
			poly.addPoint( (int) a.x(), (int) a.y());
			}
			
			//tr.get
			
			g2.fillPolygon(poly);
			
		}
		
//		if(gm.rotateTri == true){
//			rotateTriangles(g);
//		}
//		else if(gm.rotateTri == false){
//			triangles(g);
//		}
		// Draw left and right flipper
		for(Flipper rf : gm.getFlipper()){
			//gm.getFlipper().get(i).paint(g);
			if(rf.getOpCode().equals("RightFlipper")){
			g2.setColor(rf.getColor());
			
				System.out.println("trans up rF");
			
				rf.rotateFlipper();
				
				double x1pos = rf.getX1();
				double y1pos = rf.getY1();
				double x2pos = (int)x1pos + 35;
				double y2pos = (int)y1pos + 25;
				transform = rf.getTrans();
				
				Area shape = new Area(new Rectangle2D.Double(x1pos+35, y1pos+5, 15, 25));
				Area pivotedCircle = new Area(new Ellipse2D.Double(x2pos, y2pos, 15,15));
				shape.transform(transform);
				pivotedCircle.transform(transform);
				
				Graphics2D g2d = (Graphics2D)g;
				g2d.setColor(rf.getColor());
				g2d.fill(shape);
				g2d.fill(pivotedCircle);
				g2d.fillOval((int)x1pos+35,(int) y1pos, 15, 15);
			}
			else if(rf.getOpCode().equals("LeftFlipper")){
				
				System.out.println("trans up LF");
				rf.rotateFlipper();
				
				double x1pos = rf.getX1();
				double y1pos =rf.getY1();
				double x2pos = (int)x1pos;
		        double y2pos = (int)y1pos + 25;
				transform = rf.getTrans();
				
				 Area shape = new Area(new Rectangle2D.Double(x1pos, y1pos+5, 15, 25));
		            Area pivotedCircle = new Area(new Ellipse2D.Double(x2pos, y2pos, 15, 15));
		            shape.transform(transform);
		            pivotedCircle.transform(transform);
		            Graphics2D g2d = (Graphics2D)g;
		            g2d.setColor(rf.getColor());
		            g2d.fill(shape);
		            g2d.fill(pivotedCircle);
		            g2d.fillOval((int)x1pos,(int) y1pos, 15, 15);
			}
			
		}

		// Draw all squares
		for (SquareGizmo sq : gm.getSquare()) {
			g2.setColor(sq.getColor());
			g2.fillRect((int)sq.getX1(), (int)sq.getY1(), (int)sq.getH(), (int)sq.getH());
			
		}

		// Draw all absorber
		for (AbsorberGizmo abs : gm.getAbs()) {
			g2.setColor(abs.getColor());	
			g2.fillRect((int)abs.getX1(), (int)abs.getY1(), (int)abs.getX2(), (int)abs.getY2());
		}



		// Draw all circle
		for(CircleGizmo ci : gm.getCircle()) {
			g2.setColor(ci.getColor());
			g2.fillOval((int)ci.getX1(), (int)ci.getY1(),(int)ci.getRadius(),(int) ci.getRadius());
		}


		// Draw balls
		for(int i = 0; i < gm.getBall().size(); i++){
			if (gm.getBall().get(i) != null) {
				g2.setColor(gm.getBall().get(i).getColor());
				int x = (int) (gm.getBall().get(i).getX1() - gm.getBall().get(i).getRadius());
				int y = (int) (gm.getBall().get(i).getY1() - gm.getBall().get(i).getRadius());
				int width = (int) (2 * gm.getBall().get(i).getRadius());
				g2.fillOval(x, y, width, width);
			}
		}
	}




	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

}
