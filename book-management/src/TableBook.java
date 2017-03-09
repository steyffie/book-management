import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;   

public class TableBook {    
    JFrame f;    
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    TableBook(){    
    f=new JFrame();    
    f.setTitle("BOOK MANAGEMENT");
    f.getContentPane().setBackground(new Color(0, 51, 102));
    String data[][]={ {"Design Book","Yeo","Yeo Publishing", "250", "25", "available"},    
                      {"DB Book", "Villajin" ,"Villajin Publishng","250", "25", "available"},    
                      {"Seno Book", "Seno", "LJ Seno Publishing","250", "25", "available"}};    
    String column[]={"Title", "Author", "publisher","price", "onhand", "status"};         
    f.getContentPane().setLayout(null);
    
    JPanel panel = new JPanel();
    panel.setBackground(new Color(255, 255, 255));
    panel.setBounds(10, 59, 664, 209);
    f.getContentPane().add(panel);
    panel.setLayout(null);
    JTable StudentTable=new JTable(data,column);    
    StudentTable.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(StudentTable);
    sp.setBounds(10, 41, 644, 157);
    panel.add(sp);
    
    JLabel lblNewLabel = new JLabel("List of Books");
    lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
    lblNewLabel.setBounds(10, 11, 204, 19);
    panel.add(lblNewLabel);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBackground(new Color(255, 255, 255));
    panel_1.setBounds(10, 279, 535, 189);
    f.getContentPane().add(panel_1);
    panel_1.setLayout(null);
    
    JLabel lblAddOrNumber = new JLabel("Book Information\r\n");
    lblAddOrNumber.setFont(new Font("Segoe UI", Font.BOLD, 15));
    lblAddOrNumber.setBounds(10, 11, 127, 14);
    panel_1.add(lblAddOrNumber);
    
    JLabel lblStudentId = new JLabel("Title");
    lblStudentId.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    lblStudentId.setBounds(10, 40, 134, 14);
    panel_1.add(lblStudentId);
    
    JLabel lblOrNumber = new JLabel("Author");
    lblOrNumber.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    lblOrNumber.setBounds(10, 85, 91, 14);
    panel_1.add(lblOrNumber);
    
    JLabel lblAmount = new JLabel("Publisher");
    lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    lblAmount.setBounds(10, 133, 77, 14);
    panel_1.add(lblAmount);
    
    textField = new JTextField();
    textField.setBounds(10, 54, 220, 20);
    panel_1.add(textField);
    textField.setColumns(10);
    
    textField_1 = new JTextField();
    textField_1.setBounds(10, 99, 220, 20);
    panel_1.add(textField_1);
    textField_1.setColumns(10);
    
    textField_2 = new JTextField();
    textField_2.setBounds(10, 147, 220, 20);
    panel_1.add(textField_2);
    textField_2.setColumns(10);
    
    JLabel lblPrice = new JLabel("Price");
    lblPrice.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    lblPrice.setBounds(293, 41, 46, 14);
    panel_1.add(lblPrice);
    
    JLabel lblOnhand = new JLabel("On-Hand");
    lblOnhand.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    lblOnhand.setBounds(293, 86, 71, 14);
    panel_1.add(lblOnhand);
    
    textField_3 = new JTextField();
    textField_3.setBounds(293, 54, 220, 20);
    panel_1.add(textField_3);
    textField_3.setColumns(10);
    
    textField_4 = new JTextField();
    textField_4.setBounds(293, 99, 220, 20);
    panel_1.add(textField_4);
    textField_4.setColumns(10);
    
    JCheckBox chckbxAvailable = new JCheckBox("Available");
    chckbxAvailable.setBackground(new Color(255, 255, 255));
    chckbxAvailable.setFont(new Font("Segoe UI", Font.PLAIN, 11));
    chckbxAvailable.setBounds(293, 138, 164, 36);
    panel_1.add(chckbxAvailable);
    
    JSeparator separator = new JSeparator();
    separator.setForeground(new Color(102, 153, 255));
    separator.setBackground(new Color(102, 153, 204));
    separator.setBounds(10, 46, 664, 2);
    f.getContentPane().add(separator);
    
    JButton btnNewButton = new JButton("LOG OUT");
    btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
    btnNewButton.setBounds(585, 11, 89, 23);
    f.getContentPane().add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("Manage Book");
    btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
    btnNewButton_1.setBounds(445, 11, 130, 23);
    f.getContentPane().add(btnNewButton_1);
    
    JButton btnNewButton_2 = new JButton("Manage Request");
    btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
    btnNewButton_2.setBounds(189, 11, 147, 23);
    f.getContentPane().add(btnNewButton_2);
    
    JButton btnNewButton_3 = new JButton("ADD");
    btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
    btnNewButton_3.setBounds(555, 279, 119, 126);
    f.getContentPane().add(btnNewButton_3);
    
    JButton btnNewButton_4 = new JButton("cancel");
    btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
    btnNewButton_4.setBounds(555, 416, 119, 52);
    f.getContentPane().add(btnNewButton_4);
    
    JButton btnRecords = new JButton("Records");
    btnRecords.setFont(new Font("Segoe UI", Font.PLAIN, 11));
    btnRecords.setBounds(346, 11, 89, 23);
    f.getContentPane().add(btnRecords);
    f.setSize(700,525);
    f.setVisible(true);    
}     
public static void main(String[] args) {    
    new TableBook();    
}    
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}  