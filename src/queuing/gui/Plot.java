package queuing.gui;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import queuing.QueueFactory;

public class Plot extends JComponent{
	
	JFrame pFrame;

   
	int height = 670;//col
	int width = 670; // row
	int countn = 0 , countt = 0 , scale = 40;
	QueueFactory qf;;
	int nti; // nt scale
	int xi; // t scale
	int ti;
	public Plot(QueueFactory qf) {
		super();
		this.qf=qf;
		initialize();
		int k = qf.getCapacity();
		ti = qf.getMinTi();
		if(k<=10)
		{
			nti = 1;
		}
		else
		{
			int l =(int) (Math.round(k/10.0) * 10);
			nti = l / 10;
		}
		int l =(int) (Math.round(ti/10.0) * 10);
		xi = l / 10;
	}


	@Override
	public void paint(Graphics g) {
		update();
		Graphics2D gd =  (Graphics2D) g;
		Stroke s = new BasicStroke(5f);
		gd.setColor(Color.YELLOW);
		// x fixed change in y axis
		for (int i = 0; i < height; i+=scale) {
			gd.drawLine(i, 0, i,height);
		}
		// y fixed change in x axis
		for (int i = 0; i < width; i+=scale) {
			gd.drawLine(0, i, width,i);
		}
		gd.setColor(Color.RED);
		gd.drawLine(ti*10, 0, ti*10,height);
		
		gd.setColor(Color.BLACK);
		
		
		// draw axis (0,0) -> (400,0)
		gd.drawLine(0, 0, 0, 1000);//y
		gd.drawLine(0, 400, 1000, 400);//x
		
		// why incrasing when change the demantions
		// TODO count by ratio
		for (int i = 0; i < 1000; i+=scale) {
			gd.drawLine(i, 400, i, 395);
			if(countt==0)
			{
				countt+=xi;
				continue;
			}
			gd.drawString(String.valueOf(countt),i,390);
			countt+=xi;
		}
		
		for (int i = 400; i > 0; i-=scale) {
			gd.drawLine(0, i, 5, i);
			if(countn==0)
			{
				countn+=nti;
				continue;
			}
			gd.drawString(String.valueOf(countn), 10, i);
			countn+=nti;
		}
		
		gd.setStroke(s);
		
		//paint n(t)
		int start = 400;
		int end = 395;
		int x = 0;
		int arrivalTime = (int) qf.getArrivalTime();
		int arrivalx = (arrivalTime * scale)/xi; // start after 1/lamda
		int n;
		int t = arrivalTime;
		
		for (int i = 0; i < 1000; i+=scale) {
			//gd.drawLine(i, ss--, i++, m--);
			if(i<arrivalx)
			{
				gd.drawLine(0, 400, arrivalx, 400);
				continue;
			}

			
			n = qf.getNumberOfCustomers(t);
			//System.out.println("at t = "+t+" , n = "+n);
			if(n>x)
				start = goUp(i,start,gd);
			else if(n<x)
				start = goDown(i,start,gd);
			else
				freeze(i,start,gd);
			x = n;
			t+=xi;
		}
		
		
		
	}
	public int goUp(int x , int y,Graphics2D gd) 
	{
		gd.drawLine(x, y, x, y-=scale); // vertical-up
		//gd.drawLine(i, start, i, start+40); // vertical-down
		gd.drawLine(x, y, x+scale, y);//horizontal
		return y;
	}
	public int goDown(int x , int y,Graphics2D gd) 
	{
		
		gd.drawLine(x, y, x, y-=scale); // vertical-down
		gd.drawLine(x, y, x+scale, y);//horizontal
		return y;
	}
	public void freeze(int x , int y,Graphics2D gd) 
	{
		
		gd.drawLine(x, y, x+scale, y);//horizontal
	}

	   
	   private void initialize() {
		   pFrame = new JFrame();
		   pFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		   pFrame.add(this);
		   pFrame.setSize(670, 440);  
		   pFrame.setLocation(200, 200);  
		   
	   }
	   private void update() {
		   pFrame.add(this);   
	   }
	   
//	   public static void main(String args[]) 
//	   {
//		   QueueFactory qf = new QueueFactory(6, 4, 5, 0);
//		   Plot p = new Plot(qf);
//		   p.pFrame.setVisible(true);
//	   }
}
