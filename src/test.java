import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class test extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(226, 111, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(226, 155, 96, 21);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(372, 111, 96, 19);
		contentPane.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(372, 155, 96, 21);
		contentPane.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(93, 111, 96, 19);
		contentPane.add(textField_2);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(93, 155, 96, 21);
		contentPane.add(btnNewButton_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(93, 242, 96, 19);
		contentPane.add(textField_3);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(93, 286, 96, 21);
		contentPane.add(btnNewButton_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(226, 242, 96, 19);
		contentPane.add(textField_4);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(226, 286, 96, 21);
		contentPane.add(btnNewButton_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(372, 242, 96, 19);
		contentPane.add(textField_5);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(372, 286, 96, 21);
		contentPane.add(btnNewButton_5);
	}
}
