import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import org.json.simple.parser.ParseException;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

public class Main {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String nameTextField;
    private int count;
    private int numberPressed;
    private int newY;
    private JTextField tfield;
    private JTextField tfield2;
    private String definitionString = "";
	private	String partsOfSpeechString = "";
	private JPanel textPanel;
	private JScrollPane pane3;

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
	public Main()  {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		frame = new JFrame();
		frame.setTitle("Dictionary");
		frame.getContentPane().setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		frame.setBounds(100, 100, 857, 643);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
        JScrollPane pane2 = new JScrollPane();
		pane2.setBounds(228, 20, 605, 575);
		pane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(pane2);
		
		JTextPane textPane = new JTextPane();
		pane2.setViewportView(textPane);
		textPane.setMargin(new Insets(20, 20, 20, 20));
		textPane.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		textPane.setText("No word selected.");
		textPane.setEditable(false);
		pane2.setViewportView(textPane);
		
		List<Word> jsonArray = GSONReadingFromFileExample.returnWords();
		DefaultListModel model = new DefaultListModel();
		for(int i = 0; i < jsonArray.size(); i++) {
			model.addElement(jsonArray.get(i));
		}
		
		JList list = new JList(model);
		list.setCursor(cursor);
		list.setBounds(6, 119, 233, 388);
		list.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		JScrollPane pane = new JScrollPane(list);
		pane.setCursor(cursor);
		pane.setViewportView(list);
		pane.setBounds(10, 119, 205, 476);
		list.setLayoutOrientation(JList.VERTICAL);
        frame.getContentPane().add(pane);
        
		
          
        JButton btnAdd = new JButton("Add");
  		btnAdd.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				frame.getContentPane().remove(pane2);
  				
  				textPanel = new JPanel(new GridBagLayout());
  				textPanel.setBounds(228, 20, 605, 575);
  				textPanel.setBackground(Color.WHITE);
  				textPanel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
  				textPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));  				
  				pane3 = new JScrollPane();
  				pane3.setBounds(228, 20, 605, 575);
  				pane3.setViewportView(textPanel);
  				
  				GridBagConstraints c = new GridBagConstraints();
  				c.gridx = 0;
  				c.gridy = 0;
  				c.weightx = 0.5;
  				c.gridwidth = 1;
  	            c.fill = GridBagConstraints.HORIZONTAL;
  				c.anchor = GridBagConstraints.FIRST_LINE_START;
  				
  				JLabel wordLabel2 = new JLabel("Word");
  				wordLabel2.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
  				textPanel.add(wordLabel2, c);
  				
  				c.insets = new Insets(5,0,0,0);
  				
  				JTextField textField = new JTextField("  New word...");
  				textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
  				textField.setBorder(new LineBorder(Color.BLACK, 1));
  				textField.addFocusListener(new FocusListener() {@Override public void focusGained(FocusEvent e) {if(textField.getText().equals("  New word...")) {textField.setText("");}} @Override public void focusLost(FocusEvent e) {if(textField.getText().equals("")) {textField.setText("  New word...");}}});
  				c.weightx = 0.0;
  				c.gridwidth = 5;
  				c.gridx = 0;
  				c.gridy = 2;
  				textPanel.add(textField, c);
  				
  				c.insets = new Insets(10,0,0,0);
  				
  				JLabel newwordLabel3 = new JLabel("*definitions need to be added and filled one at a time*");
  				newwordLabel3.setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
  				c.weightx = 0.5;
  				c.gridy = 4;
  				c.gridwidth = 2;
  				textPanel.add(newwordLabel3, c);
  				
  				JLabel wordLabel3 = new JLabel("Definitions");
  				wordLabel3.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
  				c.weightx = 0.5;
  				c.gridy = 5;
  				c.gridwidth = 2;
  				textPanel.add(wordLabel3, c);
  				
  				c.insets = new Insets(15,0,0,0);
  				
  				JButton addDef = new JButton("+");
  				addDef.setBackground(Color.LIGHT_GRAY);
  				addDef.setFocusPainted(false);
  				addDef.setBorder(new LineBorder(Color.BLACK, 1));
  				addDef.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
  				addDef.setCursor(cursor);
  				c.gridy = 5;
  				c.gridx = 1;
  				c.gridwidth = 1;
  				textPanel.add(addDef, c);
  				
  				newY = 7;
  				
  				JTextField textField2 = new JTextField("  New word...");
  				textField2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
  				textField2.setBorder(new LineBorder(Color.BLACK, 1));
  				textField2.addFocusListener(new FocusListener() {@Override public void focusGained(FocusEvent e) {if(textField2.getText().equals("  New word...")) {textField2.setText("");}} @Override public void focusLost(FocusEvent e) {if(textField2.getText().equals("")) {textField2.setText("  New word...");}}});
  				c.weightx = 0.0;
  				c.gridwidth = 5;
  				c.gridy = newY;
  				newY+=1;
  				c.gridx = 0;
  				textPanel.add(textField2, c);
  				
  				JTextField textField3 = new JTextField("  Part of Speech...");
  				textField3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
  				textField3.setBorder(new LineBorder(Color.BLACK, 1));
  				textField3.addFocusListener(new FocusListener() {@Override public void focusGained(FocusEvent e) {if(textField3.getText().equals("  Part of Speech...")) {textField3.setText("");}} @Override public void focusLost(FocusEvent e) {if(textField3.getText().equals("")) {textField3.setText("  Part of Speech...");}}});
  				c.gridy = newY;
  				newY+=1;
  				textPanel.add(textField3, c);

  				JLabel wordLabel4 = new JLabel("Synonyms");
  				wordLabel4.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
  				c.gridy = newY;
  				newY+=1;
  				textPanel.add(wordLabel4, c);
  				
  				JTextField textField4 = new JTextField("  Synonyms...");
  				textField4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
  				textField4.setBorder(new LineBorder(Color.BLACK, 1));
  				textField4.addFocusListener(new FocusListener() {@Override public void focusGained(FocusEvent e) {if(textField4.getText().equals("  Synonyms...")) {textField4.setText("");}} @Override public void focusLost(FocusEvent e) {if(textField4.getText().equals("")) {textField4.setText("  Synonyms...");}}});
  				c.gridy = newY;
  				newY+=1;
  				textPanel.add(textField4, c);
  				
  				JLabel wordLabel5 = new JLabel("Antonyms");
  				wordLabel5.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
  				c.gridy = newY;
  				newY+=1;
  				textPanel.add(wordLabel5, c);
  				
  				JTextField textField5 = new JTextField("  Antonyms...");
  				textField5.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
  				textField5.setBorder(new LineBorder(Color.BLACK, 1));
  				textField5.addFocusListener(new FocusListener() {@Override public void focusGained(FocusEvent e) {if(textField5.getText().equals("  Antonyms...")) {textField5.setText("");}} @Override public void focusLost(FocusEvent e) {if(textField5.getText().equals("")) {textField5.setText("  Antonyms...");}}});
  				c.gridy = newY;
  				newY+=1;
  				textPanel.add(textField5, c);
  				
  				
  				JButton submitButt = new JButton("Submit");
  				submitButt.setBackground(Color.LIGHT_GRAY);
  				submitButt.setFocusPainted(false);
  				submitButt.setBorder(new LineBorder(Color.BLACK, 1));
  				submitButt.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
  				submitButt.setCursor(cursor);
  				c.gridy = newY;
  				newY+=1;
  				c.gridx = 1;
  				c.gridwidth = 1;
  				textPanel.add(submitButt, c);
  		  			
  				count = 0;
  				nameTextField = "textField";
  				numberPressed = 0;
  				
  				addDef.addActionListener(new ActionListener() {
  		  			public void actionPerformed(ActionEvent e) {
  		  				if(numberPressed > 0 && count == 0) {
  	  		  				definitionString += textField2.getText() + " " + tfield.getText();
  		  					partsOfSpeechString += textField3.getText() + " " + tfield2.getText();
  		  					count++;
  		  				}
  		  				numberPressed++;
  		  				JLabel tfield3 = new JLabel("More Definitions");
  		  				tfield3.setName(nameTextField + count);
  		  				tfield3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
  		  				c.weightx = 0.0;
  		  				c.gridwidth = 5;
  		  				c.gridx = 0;
		  				c.gridy = newY+1;
		  				newY+=1;
  		  				textPanel.add(tfield3, c);
  	  				
  		  				tfield = new JTextField("  New word...");
  		  				tfield.setName("textFieldGenerated");
  		  				tfield.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
  		  				tfield.setBorder(new LineBorder(Color.BLACK, 1));
  		  				tfield.addFocusListener(new FocusListener() {@Override public void focusGained(FocusEvent e) {if(tfield.getText().equals("  New word...")) {tfield.setText("");}} @Override public void focusLost(FocusEvent e) {if(tfield.getText().equals("")) {tfield.setText("  New word...");}}});
  		  				c.gridy = newY+1;
  		  				newY+=1;
  		  				textPanel.add(tfield, c);
  		  				
  		  				tfield2 = new JTextField("  Part of Speech...");
		  				tfield2.setName("textFieldGenerated");
		  				tfield2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		  				tfield2.setBorder(new LineBorder(Color.BLACK, 1));
		  				tfield2.addFocusListener(new FocusListener() {@Override public void focusGained(FocusEvent e) {if(tfield2.getText().equals("  Part of Speech...")) {tfield2.setText("");}} @Override public void focusLost(FocusEvent e) {if(tfield2.getText().equals("")) {tfield2.setText("  Part of Speech...");}}});
		  				c.gridy = newY+1;
		  				newY+=1;
  		  				textPanel.add(tfield2, c);
  		  				 		  				  		  				
  		  				frame.revalidate();
  		  				frame.repaint();
		  				textPane.setCaretPosition(0);
		  				
		  			    
  		  			}
  				});
  				
  				submitButt.addActionListener(new ActionListener() {
  		  			public void actionPerformed(ActionEvent e) {
  		  				if(count == 0 || numberPressed == 0) {
  		  					definitionString += textField2.getText();
  		  					partsOfSpeechString += textField3.getText();
  		  					count++;
  		  				}
  		  				
  		  				if(numberPressed > 0) {
  		  					definitionString += " ";
  		  					partsOfSpeechString += " ";
  		  					
  		  					definitionString += tfield.getText();
  		  					partsOfSpeechString += tfield2.getText();
  		  					numberPressed--;
  		  				}
  		  				System.out.println(definitionString);
  		  				System.out.println(partsOfSpeechString);
  		  			}
  				});
  				frame.getContentPane().add(pane3);
  				frame.revalidate();
				frame.repaint();
  			}
  		});
  		btnAdd.setCursor(cursor);
  		btnAdd.setBackground(Color.LIGHT_GRAY);
  		btnAdd.setFocusPainted(false);
  		btnAdd.setBorder(new LineBorder(Color.BLACK, 1));
  		btnAdd.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
  		btnAdd.setBounds(10, 20, 101, 25);
  		frame.getContentPane().add(btnAdd);
  		
  		JButton btnDelete = new JButton("Remove");
  		btnDelete.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				if(list.isSelectionEmpty()) {
  					System.out.println("nothing is selected");
  				} else {
  					System.out.println("something is selected");
  					
  					int index = list.getSelectedIndex();
  		            System.out.println("Index Selected: " + index);
  		            System.out.println("Value Selected: " +  list.getSelectedValue());
  		            
  		            try {
  		            	System.out.println("removing...");
						GSONWritingToFileExample.removeWord(list.getSelectedValue());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
  				}
  				
  			}
  		});
  		btnDelete.setCursor(cursor);
  		btnDelete.setBackground(Color.LIGHT_GRAY);
  		btnDelete.setFocusPainted(false);
  		btnDelete.setBorder(new LineBorder(Color.BLACK, 1));
  		btnDelete.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
  		btnDelete.setBounds(117, 20, 101, 25);
  		frame.getContentPane().add(btnDelete);

  		JTextField txtSearch = new JTextField("Search");
  		txtSearch.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
  		txtSearch.setBounds(10, 54, 208, 25);
  		txtSearch.addFocusListener(new FocusListener() {@Override public void focusGained(FocusEvent e) {txtSearch.setText("");} @Override public void focusLost(FocusEvent e) {txtSearch.setText("Search");}});
  		txtSearch.setColumns(10);
  		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Word> jsonArray2 = new ArrayList<Word>();
				int length = txtSearch.getText().length();
				for (Word word : jsonArray) {
					String wordShort = word.toString().substring(0, length);
			        if (txtSearch.getText().equals(wordShort)) {
			        	jsonArray2.add(word);
			        }
			    }
				updateList(list, jsonArray2);
			}
		});
  		frame.getContentPane().add(txtSearch);
          
		JCheckBox chckbxAsc = new JCheckBox("Asc");
		chckbxAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(jsonArray, Comparator.comparing(Word::getWord));
				updateList(list, jsonArray);
			}
		});
		buttonGroup.add(chckbxAsc);
		chckbxAsc.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		chckbxAsc.setBounds(37, 89, 78, 23);
		chckbxAsc.setSelected(true);
		chckbxAsc.setFocusPainted(false);
		chckbxAsc.setCursor(cursor);
		frame.getContentPane().add(chckbxAsc);
		
		JCheckBox chckbxDesc = new JCheckBox("Desc");
		chckbxDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collections.sort(jsonArray, Comparator.comparing(Word::getWord));
				Collections.reverse(jsonArray);
				updateList(list, jsonArray);
			}
		});
		buttonGroup.add(chckbxDesc);
		chckbxDesc.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		chckbxDesc.setBounds(128, 89, 91, 23);
		chckbxDesc.setFocusPainted(false);
		chckbxDesc.setCursor(cursor);
		frame.getContentPane().add(chckbxDesc);
		
		
		
		MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
            	frame.getContentPane().add(pane2);
	  			textPane.setText("");
            	pane2.getVerticalScrollBar().setValue(0);
            	JList theList = (JList) mouseEvent.getSource();
                int index = theList.locationToIndex(mouseEvent.getPoint());
                Object o = theList.getModel().getElementAt(index);
                textPane.setText(o.toString().substring(0, 1).toUpperCase() + o.toString().substring(1) + "\n\nDefinitions\n\n");
                Definition[] definition = jsonArray.get(index).getDefintions();
                for(int i = 0; i < definition.length; i++) {
                	textPane.setText(textPane.getText() + (i+1) + ". " + definition[i] + "\n\n");
                } 
                List<String> synonyms = jsonArray.get(index).getSynonyms();
                textPane.setText(textPane.getText() + "\n\nSynonyms\n\n");
                for(int i = 0; i < synonyms.size(); i++) {
                	textPane.setText(textPane.getText() + (i+1) + ". " + synonyms.get(i) + "\n\n");
                } 
              textPane.setCaretPosition(0);
            }
          };
          list.addMouseListener(mouseListener);
		
	}
	
	public void updateList(JList<String> wordList, List<Word> jsonArray) {
        DefaultListModel<String> listModel = (DefaultListModel<String>)wordList.getModel();
        listModel.clear();
        for(int i = 0; i < jsonArray.size(); i++) {
            listModel.addElement(jsonArray.get(i).toString());
        }
    }
}
