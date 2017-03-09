import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.*;

public class login {

	private JFrame frmBookManagement;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmBookManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBookManagement = new JFrame();
		frmBookManagement.getContentPane().setForeground(new Color(102, 153, 255));
		frmBookManagement.getContentPane().setBackground(new Color(0, 51, 102));
		frmBookManagement.setTitle("BOOK MANAGEMENT");
		frmBookManagement.setBounds(-8, -19, 500, 500);
		frmBookManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBookManagement.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(74, 70, 323, 298);
		frmBookManagement.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login to Service");
		lblNewLabel.setBounds(28, 30, 267, 42);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.setBounds(28, 226, 267, 36);
		panel.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(28, 177, 267, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(28, 160, 99, 14);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setForeground(new Color(204, 204, 204));
		textField.setBounds(28, 122, 267, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(28, 104, 77, 14);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(51, 204, 204));
		separator.setBackground(new Color(102, 153, 255));
		separator.setBounds(28, 83, 267, 4);
		panel.add(separator);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
