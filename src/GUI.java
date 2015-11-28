import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JList;


public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCharacter;
	private JButton btnAddItem;
	@SuppressWarnings("rawtypes")
	DefaultListModel listModel = new DefaultListModel<String>();
	ArrayList<String> itemId;
	ArrayList<String> trinketId;
	ArrayList<Integer> wantedItems = new ArrayList<Integer>();
	ArrayList<String> card;
	ArrayList<String> cardID;
	ArrayList<String> pill;
	ArrayList<String> pillID;
	String searcher;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	
	Code c;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GUI() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		setTitle("Isaac Character Editor");
		
		c = null;
		
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Choose the current playeres.xml file or exit this dialog if you don't have one.");
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	    		  "xml files (*.xml)", "xml");
	    
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(contentPane);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	       System.out.println(chooser.getSelectedFile().getAbsolutePath());
	    }
		
		 try {
			 if(System.getProperty("os.name").equals("Windows")) {
				 c = new Code(chooser.getSelectedFile(), true);
			 } else {
				 c = new Code(chooser.getSelectedFile());
			 }
		 } catch(NullPointerException catcher) {
		    	c = new Code();
		 }
		
		JButton btnSubmit = new JButton("Submit");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSubmit, -126, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSubmit, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSubmit, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnSubmit);
		
		txtCharacter = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, txtCharacter, 10, SpringLayout.WEST, contentPane);
		txtCharacter.setText("Character");
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtCharacter, 10, SpringLayout.NORTH, contentPane);
		contentPane.add(txtCharacter);
		txtCharacter.setColumns(10);
		
		btnAddItem = new JButton("Add Item");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAddItem, 44, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAddItem, -10, SpringLayout.EAST, contentPane);
		contentPane.add(btnAddItem);
		
		JComboBox comboBox = new JComboBox(); //items
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, 46, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 150, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, -11, SpringLayout.WEST, btnAddItem);
		contentPane.add(comboBox);
		
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
		DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
		decimalFormat.setGroupingUsed(false);
		
		JFormattedTextField frmtdtxtfldItems = new JFormattedTextField(decimalFormat);
		sl_contentPane.putConstraint(SpringLayout.NORTH, frmtdtxtfldItems, 6, SpringLayout.SOUTH, txtCharacter);
		sl_contentPane.putConstraint(SpringLayout.WEST, frmtdtxtfldItems, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, frmtdtxtfldItems, 35, SpringLayout.SOUTH, txtCharacter);
		sl_contentPane.putConstraint(SpringLayout.EAST, frmtdtxtfldItems, -11, SpringLayout.WEST, comboBox);
		frmtdtxtfldItems.setText("Items");
		contentPane.add(frmtdtxtfldItems);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSubmit, 1, SpringLayout.EAST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, btnSubmit);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, txtCharacter);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -104, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(scrollPane);
		
		JTextPane txtpnCodeToPut = new JTextPane();
		txtpnCodeToPut.setText("Code to put in");
		scrollPane.setViewportView(txtpnCodeToPut);
		
		JFormattedTextField frmtdtxtfldHealth = new JFormattedTextField(decimalFormat);
		frmtdtxtfldHealth.setText("Hearts");
		sl_contentPane.putConstraint(SpringLayout.NORTH, frmtdtxtfldHealth, 6, SpringLayout.SOUTH, frmtdtxtfldItems);
		sl_contentPane.putConstraint(SpringLayout.WEST, frmtdtxtfldHealth, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, frmtdtxtfldHealth, 35, SpringLayout.SOUTH, frmtdtxtfldItems);
		sl_contentPane.putConstraint(SpringLayout.EAST, frmtdtxtfldHealth, 139, SpringLayout.WEST, contentPane);
		contentPane.add(frmtdtxtfldHealth);
		
		JLabel label = new JLabel("Every full heart is 2. So 1 red heart would be 2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 6, SpringLayout.NORTH, frmtdtxtfldHealth);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 12, SpringLayout.EAST, frmtdtxtfldHealth);
		contentPane.add(label);
		
		JButton btnAddHp = new JButton("Set HP");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAddHp, 6, SpringLayout.SOUTH, comboBox);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAddHp, 6, SpringLayout.EAST, label);
		contentPane.add(btnAddHp);
		
		JFormattedTextField frmtdtxtfldBombs = new JFormattedTextField(decimalFormat);
		frmtdtxtfldBombs.setText("Bombs");
		sl_contentPane.putConstraint(SpringLayout.NORTH, frmtdtxtfldBombs, 6, SpringLayout.SOUTH, frmtdtxtfldHealth);
		sl_contentPane.putConstraint(SpringLayout.WEST, frmtdtxtfldBombs, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, frmtdtxtfldBombs, 35, SpringLayout.SOUTH, frmtdtxtfldHealth);
		sl_contentPane.putConstraint(SpringLayout.EAST, frmtdtxtfldBombs, 139, SpringLayout.WEST, contentPane);
		contentPane.add(frmtdtxtfldBombs);
		
		JFormattedTextField frmtdtxtfldKeys = new JFormattedTextField(decimalFormat);
		frmtdtxtfldKeys.setText("Keys");
		sl_contentPane.putConstraint(SpringLayout.NORTH, frmtdtxtfldKeys, 6, SpringLayout.SOUTH, frmtdtxtfldBombs);
		sl_contentPane.putConstraint(SpringLayout.WEST, frmtdtxtfldKeys, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, frmtdtxtfldKeys, 35, SpringLayout.SOUTH, frmtdtxtfldBombs);
		sl_contentPane.putConstraint(SpringLayout.EAST, frmtdtxtfldKeys, 144, SpringLayout.WEST, contentPane);
		contentPane.add(frmtdtxtfldKeys);
		
		JComboBox comboBox_1 = new JComboBox(); //characters
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox_1, -34, SpringLayout.NORTH, comboBox);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_1, 6, SpringLayout.EAST, txtCharacter);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox_1, -7, SpringLayout.NORTH, comboBox);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_1, 354, SpringLayout.EAST, txtCharacter);
		contentPane.add(comboBox_1);
		
		JFormattedTextField frmtdtxtfldCoins = new JFormattedTextField(decimalFormat);
		frmtdtxtfldCoins.setText("Coins");
		sl_contentPane.putConstraint(SpringLayout.NORTH, frmtdtxtfldCoins, 6, SpringLayout.SOUTH, frmtdtxtfldKeys);
		sl_contentPane.putConstraint(SpringLayout.WEST, frmtdtxtfldCoins, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, frmtdtxtfldCoins, 34, SpringLayout.SOUTH, frmtdtxtfldKeys);
		sl_contentPane.putConstraint(SpringLayout.EAST, frmtdtxtfldCoins, 144, SpringLayout.WEST, contentPane);
		contentPane.add(frmtdtxtfldCoins);
		
		JFormattedTextField frmtdtxtfldBlackHearts = new JFormattedTextField(decimalFormat);
		frmtdtxtfldBlackHearts.setText("Black Hearts");
		sl_contentPane.putConstraint(SpringLayout.NORTH, frmtdtxtfldBlackHearts, 6, SpringLayout.SOUTH, frmtdtxtfldCoins);
		sl_contentPane.putConstraint(SpringLayout.WEST, frmtdtxtfldBlackHearts, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, frmtdtxtfldBlackHearts, 33, SpringLayout.SOUTH, frmtdtxtfldCoins);
		sl_contentPane.putConstraint(SpringLayout.EAST, frmtdtxtfldBlackHearts, 144, SpringLayout.WEST, contentPane);
		contentPane.add(frmtdtxtfldBlackHearts);
		
		JLabel lblBlackheartdescription = new JLabel("Every full heart is 2. So 1 black heart would be 2");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBlackheartdescription, 0, SpringLayout.WEST, txtCharacter);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblBlackheartdescription, -309, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblBlackheartdescription, 178, SpringLayout.EAST, frmtdtxtfldBlackHearts);
		contentPane.add(lblBlackheartdescription);
		
		JButton btnAddBombs = new JButton("Set Bombs");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAddBombs, 1, SpringLayout.NORTH, frmtdtxtfldBombs);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAddBombs, 0, SpringLayout.WEST, comboBox);
		contentPane.add(btnAddBombs);
		
		JButton btnAddKeys = new JButton("Set Keys");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAddKeys, 0, SpringLayout.NORTH, frmtdtxtfldKeys);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAddKeys, 0, SpringLayout.WEST, comboBox);
		contentPane.add(btnAddKeys);
		
		JButton btnAddCoins = new JButton("Set Coins");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAddCoins, 0, SpringLayout.NORTH, frmtdtxtfldCoins);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAddCoins, 0, SpringLayout.WEST, comboBox);
		contentPane.add(btnAddCoins);
		
		JButton btnAddBlackHearts = new JButton("Set Black Hearts");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBlackheartdescription, 3, SpringLayout.SOUTH, btnAddBlackHearts);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAddBlackHearts, 1, SpringLayout.NORTH, frmtdtxtfldBlackHearts);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAddBlackHearts, 0, SpringLayout.WEST, comboBox);
		contentPane.add(btnAddBlackHearts);
		
		JFormattedTextField frmtdtxtfldSoulHearts = new JFormattedTextField(decimalFormat);
		sl_contentPane.putConstraint(SpringLayout.NORTH, frmtdtxtfldSoulHearts, 6, SpringLayout.SOUTH, lblBlackheartdescription);
		sl_contentPane.putConstraint(SpringLayout.WEST, frmtdtxtfldSoulHearts, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, frmtdtxtfldSoulHearts, -275, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, frmtdtxtfldSoulHearts, 0, SpringLayout.EAST, txtCharacter);
		frmtdtxtfldSoulHearts.setText("Soul Hearts");
		contentPane.add(frmtdtxtfldSoulHearts);
		
		JButton btnAddSoulHearts = new JButton("Set Soul Hearts");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAddSoulHearts, 6, SpringLayout.SOUTH, lblBlackheartdescription);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAddSoulHearts, 0, SpringLayout.EAST, btnAddBlackHearts);
		contentPane.add(btnAddSoulHearts);
		
		JLabel lblDescriptionofsoul = new JLabel("Every full heart is 2. So 1 soul heart would be 2");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblDescriptionofsoul, 6, SpringLayout.SOUTH, frmtdtxtfldSoulHearts);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblDescriptionofsoul, 0, SpringLayout.WEST, txtCharacter);
		contentPane.add(lblDescriptionofsoul);
		
		JCheckBox chckbxCanHeShoot = new JCheckBox("Can He/She Shoot?");
		sl_contentPane.putConstraint(SpringLayout.WEST, chckbxCanHeShoot, 0, SpringLayout.WEST, txtCharacter);
		contentPane.add(chckbxCanHeShoot);
		
		JButton btnDeleteItem = new JButton("Delete Item");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnDeleteItem, -6, SpringLayout.NORTH, scrollPane);
		contentPane.add(btnDeleteItem);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.EAST, btnDeleteItem, -6, SpringLayout.WEST, scrollPane_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_1, 6, SpringLayout.SOUTH, btnAddHp);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_1, -46, SpringLayout.WEST, btnSubmit);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_1, -6, SpringLayout.NORTH, btnSubmit);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_1, 112, SpringLayout.EAST, comboBox);
		contentPane.add(scrollPane_1);
		
		JList list = new JList(listModel);
		scrollPane_1.setViewportView(list);
		
		JComboBox comboBox_2 = new JComboBox(); //trinket
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox_2, 426, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox_2, -8, SpringLayout.NORTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, chckbxCanHeShoot, -6, SpringLayout.NORTH, comboBox_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_2, 15, SpringLayout.WEST, contentPane);
		contentPane.add(comboBox_2);
		
		JButton btnAddTrinket = new JButton("Add Trinket");
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_2, -6, SpringLayout.WEST, btnAddTrinket);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAddTrinket, 0, SpringLayout.NORTH, btnDeleteItem);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAddTrinket, -6, SpringLayout.WEST, btnDeleteItem);
		contentPane.add(btnAddTrinket);
		
		JComboBox comboBox_3 = new JComboBox(); //pill is pill=""
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox_3, 4, SpringLayout.SOUTH, lblDescriptionofsoul);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_3, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox_3, 32, SpringLayout.SOUTH, lblDescriptionofsoul);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_3, 139, SpringLayout.WEST, contentPane);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox(); //card is card=""
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox_4, 6, SpringLayout.SOUTH, lblDescriptionofsoul);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_4, 11, SpringLayout.EAST, comboBox_3);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox_4, 29, SpringLayout.SOUTH, lblDescriptionofsoul);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_4, 156, SpringLayout.EAST, comboBox_3);
		contentPane.add(comboBox_4);
		
		JCheckBox chckbxPill = new JCheckBox("Pill");
		sl_contentPane.putConstraint(SpringLayout.WEST, chckbxPill, 0, SpringLayout.WEST, txtCharacter);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, chckbxPill, -6, SpringLayout.NORTH, chckbxCanHeShoot);
		contentPane.add(chckbxPill);
		
		JCheckBox chckbxCard = new JCheckBox("Card");
		sl_contentPane.putConstraint(SpringLayout.NORTH, chckbxCard, 6, SpringLayout.SOUTH, comboBox_4);
		sl_contentPane.putConstraint(SpringLayout.WEST, chckbxCard, 0, SpringLayout.WEST, comboBox);
		contentPane.add(chckbxCard);
		
		card = c.getCardsandPills("card");
		cardID = c.getCardsandPillsIds("card");
		pill = c.getCardsandPills("pill");
		pillID = c.getCardsandPillsIds("pill");
		
		for(int i=0;i<pill.size();i++) {
			comboBox_3.addItem(pill.get(i));
		}
		
		for(int i=0;i<card.size();i++) {
			comboBox_4.addItem(card.get(i));
		}
		
		comboBox_1.addItem("Isaac");
		comboBox_1.addItem("Magdalene");
		comboBox_1.addItem("Cain");
		comboBox_1.addItem("Judas");
		comboBox_1.addItem("Blue Baby");
		comboBox_1.addItem("Eve");
		comboBox_1.addItem("Samson");
		comboBox_1.addItem("Azazel");
		comboBox_1.addItem("Lazarus");
		comboBox_1.addItem("Eden");
		comboBox_1.addItem("The Lost");
		comboBox_1.addItem("Lazarus II");
		comboBox_1.addItem("Black Judas");
		comboBox_1.addItem("Lilith");
		comboBox_1.addItem("Keeper");
		
		btnDeleteItem.setEnabled(false);
		chckbxCanHeShoot.setSelected(true);
		
		ArrayList<String> at = c.getItems("trinket");
		comboBox_2.addItem("N/A");
		
		for(int i=0;i<at.size();i++) {
			comboBox_2.addItem(at.get(i));
		}
		trinketId = c.getTrinketIds();
		
		ArrayList<String> al = c.getItems("items");
		for(int i=0;i<al.size();i++) {
			comboBox.addItem(al.get(i));
		}
		itemId = c.getItemIds("items");
		
		
		btnAddTrinket.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.trinkets(Integer.parseInt(trinketId.get(comboBox_2.getSelectedIndex()-1)));
			}
		});
		
		btnAddBombs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.bombs(Integer.parseInt(frmtdtxtfldBombs.getText()));
			}
		});
		
		btnAddBlackHearts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.black(Integer.parseInt(frmtdtxtfldBlackHearts.getText()));
			}
		});

		btnAddHp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.health(Integer.parseInt(frmtdtxtfldHealth.getText()));
			}
		});
		
		btnAddCoins.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.coins(Integer.parseInt(frmtdtxtfldCoins.getText()));
			}
		});
		
		btnAddSoulHearts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.soulHearts(Integer.parseInt(frmtdtxtfldSoulHearts.getText()));
			}
		});
		
		btnAddKeys.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				c.keys(Integer.parseInt(frmtdtxtfldKeys.getText()));
			}
		});
		
		
		comboBox_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtCharacter.setText(comboBox_1.getSelectedItem().toString());
				if(comboBox_1.getSelectedItem().toString().equals("Lilith")) {
					chckbxCanHeShoot.setSelected(false);
				} else {
					chckbxCanHeShoot.setSelected(true);
				}
			}
		});
		
		searcher = "";
		
		frmtdtxtfldItems.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
					listModel.addElement(comboBox.getSelectedItem());
					list.setModel(listModel);
					wantedItems.add(Integer.parseInt(itemId.get(comboBox.getSelectedIndex())));
					frmtdtxtfldItems.setText("");
					searcher = "";
				} else {
					
					if(!frmtdtxtfldItems.getText().equals(searcher)) {
						searcher = frmtdtxtfldItems.getText();
					}
					
					try {
						if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE) {
							searcher = searcher.substring(0, searcher.length()-1);
						} else {
							searcher += e.getKeyChar();
						}
					} catch(StringIndexOutOfBoundsException e1) {
						searcher = "";
					}
					
					ArrayList<String> found = new ArrayList<String>();
					
					for(String w : al) {
						if(w.toLowerCase().indexOf(searcher.toLowerCase())!=-1) {
							found.add(w);
						}
					}
					
					try {
						comboBox.setSelectedItem(found.get(0));
					} catch(IndexOutOfBoundsException e1) {
						
					}
				
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnAddItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listModel.addElement(comboBox.getSelectedItem());
				list.setModel(listModel);
				wantedItems.add(Integer.parseInt(itemId.get(comboBox.getSelectedIndex())));
				frmtdtxtfldItems.setText("");
				searcher = "";
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				btnDeleteItem.setEnabled(true);
			}
		});
		
		btnDeleteItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listModel.remove(list.getSelectedIndex());
				list.setModel(listModel);
				wantedItems.remove(list.getSelectedIndex()+1);
				btnDeleteItem.setEnabled(false);
			}
		});
		
		chckbxCard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chckbxPill.setSelected(false);
			}
		});
		
		chckbxPill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chckbxCard.setSelected(false);
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(chckbxCard.isSelected()) {
					c.setCard(cardID.get(comboBox_4.getSelectedIndex()));
				}
				if(chckbxPill.isSelected()) {
					c.setPill(pillID.get(comboBox_3.getSelectedIndex()));
				}
				for(int i=0;i<wantedItems.size();i++) {
					c.items(wantedItems.get(i));
				}
				try {
					c.getData();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				c.shoot(chckbxCanHeShoot.isSelected());
				c.character(txtCharacter.getText());
				txtpnCodeToPut.setText(c.submit());
				txtpnCodeToPut.requestFocus();
				
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Select a directory to save the file");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    int returnVal = chooser.showOpenDialog(contentPane);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			       System.out.println(chooser.getSelectedFile().getAbsolutePath());
			    }
				
				try {
					c.saveFile(chooser.getSelectedFile().getAbsolutePath());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				c.reset();
			}
		});
		
		
		
	}
}
