package queuing.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import queuing.QueueFactory;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DGUI {

	JFrame dFrame;
	private JTextField txtEnterSizeK;
	private JTextField txtEnterServiceTime;
	private JTextField txtEnterArrivalTime;
	private JTextField txtStartingCustomersM;
	private JTextField txtEnterT;
	private JTextField txtEnterN;
	
	private String k,servicetime,arrivaltime,m,t,n;
	private int ti , nt ,wq;
	private QueueFactory qf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DGUI window = new DGUI();
					window.dFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dFrame = new JFrame();
		dFrame.getContentPane().setEnabled(false);
		dFrame.setBounds(100, 100, 434, 386);
		dFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dFrame.getContentPane().setLayout(null);
		
		txtEnterSizeK = new JTextField();
		txtEnterSizeK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
			}
		});
		txtEnterSizeK.setToolTipText("Enter Size K");
		txtEnterSizeK.setBounds(135, 22, 257, 20);
		dFrame.getContentPane().add(txtEnterSizeK);
		txtEnterSizeK.setColumns(10);
		
		txtEnterServiceTime = new JTextField();
		txtEnterServiceTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtEnterServiceTime.setToolTipText("Enter Service Time");
		txtEnterServiceTime.setBounds(135, 60, 257, 20);
		dFrame.getContentPane().add(txtEnterServiceTime);
		txtEnterServiceTime.setColumns(10);
		
		txtEnterArrivalTime = new JTextField();
		txtEnterArrivalTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtEnterArrivalTime.setToolTipText("Enter Arrival Time");
		txtEnterArrivalTime.setBounds(135, 108, 257, 20);
		dFrame.getContentPane().add(txtEnterArrivalTime);
		txtEnterArrivalTime.setColumns(10);
		
		txtStartingCustomersM = new JTextField();
		txtStartingCustomersM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtStartingCustomersM.setToolTipText("Starting Customers M");
		txtStartingCustomersM.setBounds(135, 153, 257, 20);
		dFrame.getContentPane().add(txtStartingCustomersM);
		txtStartingCustomersM.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(56, 262, 89, 14);
		dFrame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel_10 = new JLabel("Error While Calculateing");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setBounds(169, 262, 223, 14);
		dFrame.getContentPane().add(lblNewLabel_10);
		lblNewLabel_10.setVisible(false);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(56, 293, 89, 14);
		dFrame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(56, 318, 89, 14);
		dFrame.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				arrivaltime=txtEnterArrivalTime.getText();
				m=txtStartingCustomersM.getText();
				k = txtEnterSizeK.getText();
				servicetime=txtEnterServiceTime.getText();
				try {
					if(txtStartingCustomersM.getText().isEmpty())
						m = "0";
					if(k==null)
						k = "0";
					if(arrivaltime==null)
						arrivaltime = "0";
					if(servicetime==null)
						servicetime = "0";
					
					int M = Integer.valueOf(m);
					int K = Integer.valueOf(k);
					double servTime = Double.valueOf(servicetime);
					double arrTime = Double.valueOf(arrivaltime);
					
					qf = new QueueFactory(servTime,arrTime,K,M);
					
					ti = qf.getMinTi();
					
					
					
					
					lblNewLabel_1.setText(String.valueOf(ti));
					lblNewLabel_1.setVisible(true);
				}
				catch(Exception ex) 
				{
					lblNewLabel_10.setText("Error While Calculateing");
					lblNewLabel_10.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(36, 207, 89, 23);
		dFrame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Ti:");
		lblNewLabel.setBounds(10, 262, 46, 14);
		dFrame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Plot");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(dFrame,"Comming Soon","Stay tuned",1);
			}
		});
		btnNewButton_1.setBounds(169, 207, 89, 23);
		dFrame.getContentPane().add(btnNewButton_1);
		

		
		JLabel lblNewLabel_2 = new JLabel("N(t):");
		lblNewLabel_2.setBounds(10, 293, 46, 14);
		dFrame.getContentPane().add(lblNewLabel_2);
		
		txtEnterT = new JTextField();
		txtEnterT.setToolTipText("Enter T");
		txtEnterT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtEnterT.setBounds(172, 290, 86, 20);
		dFrame.getContentPane().add(txtEnterT);
		txtEnterT.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Wq(n):");
		lblNewLabel_3.setBounds(10, 318, 46, 14);
		dFrame.getContentPane().add(lblNewLabel_3);
		
		txtEnterN = new JTextField();
		txtEnterN.setToolTipText("Enter N");
		txtEnterN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtEnterN.setBounds(172, 315, 86, 20);
		dFrame.getContentPane().add(txtEnterN);
		txtEnterN.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Compute");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				t = txtEnterT.getText();
				nt = qf.getNumberOfCustomers(Integer.valueOf(t));
				lblNewLabel_4.setText(String.valueOf(nt));
				lblNewLabel_4.setVisible(true);
				}
				catch(Exception ex) 
				{
					lblNewLabel_10.setText("Error While computing n(t)");
					lblNewLabel_10.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBounds(303, 289, 89, 23);
		dFrame.getContentPane().add(btnNewButton_2);
		
		JButton button = new JButton("Compute");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					n = txtEnterN.getText();
					wq = qf.getWaitingTime(Integer.valueOf(n));
					lblNewLabel_5.setText(String.valueOf(wq));
					lblNewLabel_5.setVisible(true);
				}
				catch(Exception ex) 
				{
					lblNewLabel_10.setText("Error While computing Wq(n)");
					lblNewLabel_10.setVisible(true);
				}
			}
		});
		button.setBounds(303, 314, 89, 23);
		dFrame.getContentPane().add(button);
		

		
		JButton btnNewButton_3 = new JButton("<--");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueueGUI qg = new QueueGUI();
				dFrame.setVisible(false);
				qg.frame.setVisible(true);
				//frame.dispose();
			}
		});
		btnNewButton_3.setBounds(303, 207, 89, 23);
		dFrame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_6 = new JLabel("K");
		lblNewLabel_6.setToolTipText("");
		lblNewLabel_6.setBounds(36, 25, 46, 14);
		dFrame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("1/MU");
		lblNewLabel_7.setBounds(36, 63, 46, 14);
		dFrame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("1/LAMDA");
		lblNewLabel_8.setBounds(36, 111, 66, 14);
		dFrame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("M");
		lblNewLabel_9.setBounds(36, 156, 46, 14);
		dFrame.getContentPane().add(lblNewLabel_9);
		

	}
}
