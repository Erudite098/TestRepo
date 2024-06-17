import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class test extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldUserName;
	private JPasswordField passFieldLogin;

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

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtFieldUserName.getText();
				String password = new String(passFieldLogin.getPassword());
				if (authenticate(username, password)) {
					// Proceed to main application
				} else {
					JOptionPane.showMessageDialog(null, "Invalid credentials");
				}
			}
		});

		btnLogin.setBounds(203, 166, 96, 21);
		contentPane.add(btnLogin);

		txtFieldUserName = new JTextField();
		txtFieldUserName.setColumns(10);
		txtFieldUserName.setBounds(203, 82, 200, 30);
		contentPane.add(txtFieldUserName);

		JLabel lblUserName = new JLabel("UserName");
		lblUserName.setBounds(203, 65, 125, 15);
		contentPane.add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(203, 111, 70, 15);
		contentPane.add(lblPassword);

		passFieldLogin = new JPasswordField();
		passFieldLogin.setBounds(203, 124, 200, 30);
		contentPane.add(passFieldLogin);
	}// end frame

	private boolean authenticate(String username, String password) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT * FROM User WHERE username = ? AND password = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
