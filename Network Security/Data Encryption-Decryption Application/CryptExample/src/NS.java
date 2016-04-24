import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;


public class NS extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NS frame = new NS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataEnde = new JLabel("Data Encription/Decryption Application");
		lblDataEnde.setBounds(109, 11, 222, 14);
		contentPane.add(lblDataEnde);
		
		JLabel lblNewLabel = new JLabel("Text for Encription");
		lblNewLabel.setBounds(10, 56, 90, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblTextForDecription = new JLabel("Text for Decription");
		lblTextForDecription.setBounds(175, 60, 102, 22);
		contentPane.add(lblTextForDecription);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 97, 135, 90);
		contentPane.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(175, 97, 125, 90);
		contentPane.add(textPane_1);
		
		JButton btnGenerateResults = new JButton("Generate Results");
		btnGenerateResults.setBounds(310, 164, 115, 23);
		contentPane.add(btnGenerateResults);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(10, 232, 400, 175);
		contentPane.add(textPane_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(316, 110, 108, 20);
		comboBox.addItem("Select Algorithm");
		contentPane.add(comboBox);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(20, 207, 46, 14);
		contentPane.add(lblResults);
	}
}
