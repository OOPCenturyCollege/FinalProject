package FinalPackage1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class shoppingGUI extends JFrame implements ActionListener, WindowListener {

	private static final Items[][] Items = null;
	private JPanel contentPane;
	private JTextField qtyTextField;
	private JComboBox clothingCombo; 
	private JComboBox electronicCombo; 
	private JComboBox consumableCombo; 
    private JTextArea output; 
    private JTextField priceTextField;
	private Cart cart = new Cart(20); 
	private Items[] cartSummary = new Items[20]; 
 
	private Clothing[] clothing = {
			new Clothing("T-Shirt", 9.99),
			new Clothing("Hoodie", 29.99),
			new Clothing("Blouse", 19.99)
			};
	
	private Electronics[] electronic = {
			new Electronics("Tv", 1000.00),
			new Electronics("Headphones", 19.99),
			new Electronics("Iphone", 299.99)
			};
	
	
	private Consumables[] consumable = {
			new Consumables("Gummy worms", 2.99),
			new Consumables("Beef Jerky", 5.99),
			new Consumables("Apple Juice", 1.99)
			};
		
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shoppingGUI frame = new shoppingGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//exit pop up window
	private class confirmExit extends JFrame implements ActionListener{
		private JLabel lbl = new JLabel("Do you want to exit?");
		private JButton cancelButton = new JButton("Cancel");
		private JButton okButton = new JButton("Exit");
		
		
		public confirmExit(String title) {
			super(title);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(200,100);
			setLayout(new FlowLayout());
			
			okButton.addActionListener(this);
			cancelButton.addActionListener(this);
			add(lbl);
			add(cancelButton);
			add(okButton);
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			String callingBtn = e.getActionCommand();
			if (callingBtn.equalsIgnoreCase("cancel")) {
				dispose();
			}
			else if (callingBtn.equalsIgnoreCase("exit")) {
				System.exit(0);
			}
			
		}
	}
	

	public shoppingGUI() {
		setTitle("Shopping Cart");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 722, 515);
		setListener();
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton_1 = new JButton("Account Info");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(btnNewButton_1);
	
		
		JButton btnNewButton_3 = new JButton("Cart Summary");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText(" "); 
				output.append(cart.toString() + "\n");
				
				
			}
		});
		menuBar.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Logout");
		menuBar.add(btnNewButton_2);
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		
		//JLabel lblNewLabel_2 = new JLabel("Price");
		//panel_2.add(lblNewLabel_2);
		
		//priceTextField = new JTextField();
		//panel_2.add(priceTextField);
		//priceTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Quantity");
		panel_2.add(lblNewLabel);
		
		
		
		
		qtyTextField = new JTextField();
		panel_2.add(qtyTextField);
		qtyTextField.setColumns(10);
		

		
		class AddToCartListener implements ActionListener{ 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Items selectedClothing = (Items) clothingCombo.getSelectedItem();
				try {
				int quantity = Integer.parseInt(qtyTextField.getText()); 
				}catch(NumberFormatException e1){
					e1.printStackTrace();
				}
				
				int quantity = 0;
				selectedClothing.setQuantity(quantity); 
				cart.add(selectedClothing) ; 
				output.append(selectedClothing.getName() + " has been added to your cart! \n"); 
	
				Electronics selectedElectronic = (Electronics) electronicCombo.getSelectedItem();
				
				selectedElectronic.setQuantity(quantity);
				cart.add(selectedElectronic);  
				output.append(selectedElectronic.getName()+ " has been added to your cart! \n");
				
		
				Consumables selectedConsumable = (Consumables) consumableCombo.getSelectedItem(); 
				
				selectedConsumable.setQuantity(quantity); 
				cart.add(selectedConsumable); 
				output.append(selectedConsumable.getName() + " has been added to your cart! \n");
	
				
				
			}
			 
		}
		
		JButton addBtn = new JButton("Add ");
		addBtn.addActionListener(new AddToCartListener()); 
		panel_2.add(addBtn);
		
		
		
		JButton btnNewButton_4 = new JButton("Remove");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				
			}
		});
		panel_2.add(btnNewButton_4);
		
	
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		JLabel lblNewLabel_7 = new JLabel("Clothings");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_7);
		
		clothingCombo = new JComboBox(clothing);
		panel_3.add(clothingCombo);
		
		JLabel lblNewLabel_1 = new JLabel("Electronics");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_1);
		
		 electronicCombo = new JComboBox(electronic);
		panel_3.add(electronicCombo);
		
		JLabel lblNewLabel_3 = new JLabel("Consumables");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_3);
		
		consumableCombo = new JComboBox(consumable);
		panel_3.add(consumableCombo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Console", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
	    output = new JTextArea();
		panel.add(output, BorderLayout.CENTER);
	}


	//window listener
	private void setListener() {
		addWindowListener(this);
		
	}

	//window status
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("shoppingGUI.windowOpened()");
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("shoppingGUI.windowClosing()");
		confirmExit exitframe = new confirmExit("Confirm Exit");
		exitframe.setVisible(true);
	}


	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("shoppingGUI.windowClosed()");
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("shoppingGUI.windowIconified()");
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("shoppingGUI.windowDeiconified()");
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("shoppingGUI.windowActivated()");
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("shoppingGUI.windowDeactivated()");
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
