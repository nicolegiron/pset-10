import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class Main {

	private JFrame frame;
	private JTextField txtSearch;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		frame.setBounds(100, 100, 761, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnAdd.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		btnDelete.setBounds(109, 11, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		txtSearch = new JTextField("Search");
		txtSearch.setBounds(10, 43, 188, 23);
		frame.getContentPane().add(txtSearch);
		txtSearch.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtSearch.setText("");
            }
        });
		txtSearch.setColumns(10);
		
		JCheckBox chckbxAsc = new JCheckBox("Asc");
		chckbxAsc.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		chckbxAsc.setBounds(36, 73, 63, 23);
		frame.getContentPane().add(chckbxAsc);
		
		JCheckBox chckbxDesc = new JCheckBox("Desc");
		chckbxDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		chckbxDesc.setBounds(128, 73, 70, 23);
		frame.getContentPane().add(chckbxDesc);
		
		List<Word> jsonArray = GSONReadingFromFileExample.returnWords();
		System.out.println(jsonArray);
		
		@SuppressWarnings("unchecked")
		JList list_1 = new JList(jsonArray.toArray());
		list_1.setLayoutOrientation(JList.VERTICAL);
		list_1.setBounds(-19, 102, 188, 375);
		frame.getContentPane().add(list_1);
		
		textField = new JTextField();
		textField.setBounds(212, 14, 525, 478);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(179, 121, 17, 48);
		frame.getContentPane().add(scrollBar);
	}
}
