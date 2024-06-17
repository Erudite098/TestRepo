import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;



public class test extends JFrame {

	private JPanel contentPane;
	private JTextField txtsurname;
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
	
	public test() {
		testMe();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	private JTextField textfullname;
	
	public void Connect() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/infoman", "root","");
        }
        catch (ClassNotFoundException ex) 
        {
          ex.printStackTrace();
        }
        catch (SQLException ex) 
        {
           ex.printStackTrace();
        }
	}
	
	public void table_load(){
	    try {
	    	pst = con.prepareStatement("select * from employee");
	    	rs = pst.executeQuery();
	    	table.setModel(DbUtils.resultSetToTableModel(rs));
	    } 
	    catch (SQLException e) {
	        e.printStackTrace();
	    } 
	}
	
	

	/**
	 * Create the frame.
	 */
	private void testMe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String surname, fullname;
			    surname = txtsurname.getText();
			    fullname = textfullname.getText();
	
			                
			     try {
			        pst = con.prepareStatement("insert into employee(surname, fullname)values(?,?)");
			        pst.setString(1, surname);
			        pst.setString(2, fullname);
			
			        pst.executeUpdate();
			        JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
			        table_load();
			                       
			        txtsurname.setText("");
			        textfullname.setText("");
//			        txtPrice.setText("");
			        txtsurname.requestFocus();
			       }
			    catch (SQLException e1) 
			        {            
			       e1.printStackTrace();
			    }
			}
		});

		btnAdd.setBounds(203, 291, 96, 21);
		contentPane.add(btnAdd);

		txtsurname = new JTextField();
		txtsurname.setColumns(10);
		txtsurname.setBounds(203, 51, 200, 30);
		contentPane.add(txtsurname);

		JLabel lblUserName = new JLabel("UserName");
		lblUserName.setBounds(203, 34, 125, 15);
		contentPane.add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(203, 199, 70, 15);
		contentPane.add(lblPassword);

		passFieldLogin = new JPasswordField();
		passFieldLogin.setBounds(203, 224, 200, 30);
		contentPane.add(passFieldLogin);
		
		table = new JTable();
		table.setBounds(160, 397, 381, 120);
		contentPane.add(table);
		
		textfullname = new JTextField();
		textfullname.setColumns(10);
		textfullname.setBounds(203, 108, 200, 30);
		contentPane.add(textfullname);
		
		JLabel lblUserName_1 = new JLabel("UserName");
		lblUserName_1.setBounds(203, 91, 125, 15);
		contentPane.add(lblUserName_1);
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
