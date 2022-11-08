package queuing.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About {

	JFrame iFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About window = new About();
					window.iFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public About() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		iFrame = new JFrame();
		iFrame.setBounds(100, 100, 478, 218);
		iFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iFrame.setVisible(false);
				QueueGUI qg = new QueueGUI();
				qg.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(165, 137, 89, 23);
		iFrame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("This Program is made by: Abdalrhman Mostafa");
		lblNewLabel.setBounds(95, 29, 294, 14);
		iFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("All Rights Resved");
		lblNewLabel_1.setBounds(165, 53, 122, 14);
		iFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("This Program is a Project for Queueing Course For Prof.Mohamed Rohiem");
		lblNewLabel_2.setBounds(10, 78, 609, 23);
		iFrame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("2022");
		lblNewLabel_3.setBounds(192, 112, 33, 14);
		iFrame.getContentPane().add(lblNewLabel_3);
	}

}
