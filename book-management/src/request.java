import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class request {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					request window = new request();
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
	public request() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(108, 86, 1, 1);
		frame.getContentPane().add(table);
		
		Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
		        { "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
		
	    Object columnNames[] = { "Column One", "Column Two", "Column Three" };
	    JTable table = new JTable(rowData, columnNames);

	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane);
	    frame.setSize(300, 150);
	    frame.setVisible(true);
		
		
		
		
		
		
	}
}
