package queuing.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ploter extends JComponent{

	private JFrame frame;
	JPanel draw;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ploter window = new Ploter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ploter() {
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 683, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		draw = new JPanel();
		draw.setBounds(0, 0, 667, 494);
		frame.getContentPane().add(draw);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics2D gd =  (Graphics2D) draw.getGraphics();
				Stroke s = new BasicStroke(5f);
				gd.setColor(Color.BLACK);
				gd.setStroke(s);
				gd.drawLine(100, 100, 300, 100);
			}
		});
		draw.add(btnNewButton);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D gd =  (Graphics2D) g;
		gd.drawLine(100, 200, 300, 400);
		Stroke s = new BasicStroke(5f);
		gd.setColor(Color.BLACK);
		gd.setStroke(s);
		gd.drawLine(100, 100, 300, 100);
		super.paint(g);
	}
}
