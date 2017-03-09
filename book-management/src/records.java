import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;   

public class records {    
    JFrame f;    
    records(){    
    f=new JFrame();    
    f.setTitle("BOOK MANAGEMENT");
    f.getContentPane().setBackground(new Color(0, 51, 102));
    String data[][]={ {"2011-11-02","2014101969","Stephane Mae Yeo","Design Book", "250", "02-02"},    
            {"2011-11-02", "2014101967" ,"Bernadette Villajin","DB Book", "250", "02-03"},    
            {"2011-11-02", "2014101969", "LJ Seno","Seno Books", "250", "02-04"}};    
String column[]={"date", "student ID", "student name","book", "amount", "OR#"};         
    f.getContentPane().setLayout(null);
    
    JPanel panel = new JPanel();
    panel.setBackground(new Color(255, 255, 255));
    panel.setBounds(10, 59, 664, 416);
    f.getContentPane().add(panel);
    panel.setLayout(null);
    JTable StudentTable=new JTable(data,column);    
    StudentTable.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(StudentTable);
    sp.setBounds(10, 41, 644, 364);
    panel.add(sp);
    
    JLabel lblNewLabel = new JLabel("Records");
    lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
    lblNewLabel.setBounds(10, 11, 204, 19);
    panel.add(lblNewLabel);
    
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
    btnNewButton_2.setBounds(189, 12, 147, 23);
    f.getContentPane().add(btnNewButton_2);
    
    JButton btnRecords = new JButton("Records");
    btnRecords.setFont(new Font("Segoe UI", Font.PLAIN, 11));
    btnRecords.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    	}
    });
    btnRecords.setBounds(346, 12, 89, 23);
    f.getContentPane().add(btnRecords);
    f.setSize(700,525);
    f.setVisible(true);    
}     
public static void main(String[] args) {    
    new records();    
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