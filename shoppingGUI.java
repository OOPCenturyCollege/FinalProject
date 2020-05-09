package FinalPackage1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import FinalPackage2.Clothing;
import FinalPackage2.Consumables;
import FinalPackage2.Electronics;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;

public class shoppingGui extends JFrame implements WindowListener {

	private static final int NAME = 0;
	private static final int PRICE = 1;
	private static final int QUANTITY = 2;
	private static List<Items> products = new ArrayList<>();
	
	private JPanel overallPanel;
	private JComboBox clothingCombo; 
	private JComboBox electronicCombo; 
	private JComboBox consumableCombo; 
    private JTextArea output; 
    
    
    //clothing info
	private Clothing[] clothing = {
			new Clothing("White T-Shirt", 9.99, 0),
			new Clothing("Black Hoodie", 29.99, 0),
			new Clothing("Red Blouse", 19.99, 0),
			new Clothing("Denim Jeans", 9.99, 0),
			new Clothing("Rain Jacket", 29.99, 0),
			new Clothing("Gray Sweatpants", 19.99, 0)
			};
	
	//electronics info
	private Electronics[] electronic = {
			new Electronics("Smart TV", 1499.99, 0),
			new Electronics("Headphones", 39.99, 0),
			new Electronics("iPhone", 399.99, 0),
			new Electronics("Slim Laptop", 599.99, 0),
			new Electronics("Earbuds", 34.99, 0),
			new Electronics("Wired Mouse", 19.99, 0)
			};
	
	//consumable info
	private Consumables[] consumable = {
			new Consumables("Gummy Worms", 2.99, 0),
			new Consumables("Beef Jerky", 5.99, 0),
			new Consumables("Apple Juice", 1.99, 0),
			new Consumables("Chocolate Bar", 0.99, 0),
			new Consumables("Ramen Noodles", 0.24, 0),
			new Consumables("Frozen Pizza", 4.99, 0)
			};
	
	//customer info
	private Customer[] customer = {
			new Customer("John ", "Adams", "123 Happy Lane", "St. Paul", 
					"MN", "JAdams@exmaple.com", 55123, 123456)
	}; 
	
	private Cart cart = new Cart(20); 	
	
	public static void main(String[] args) {
		writeToFile();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shoppingGui frame = new shoppingGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//creates txt for cart data
	public static void writeToFile() {
		try {
			System.out.println("Creating cartData.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream("cartData.txt", true));
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//reads cartdata txt
	public static void readFromFile() {
		try {
			Scanner file = new Scanner(new FileInputStream("cartData.txt"));

			while (file.hasNextLine()) {
				String line = file.nextLine(); // read the line ""
				// convert each line to a product a object
				String[] productStr = line.split(", "); // "

				String name = productStr[NAME];
				double price = Double.parseDouble(productStr[PRICE]);
				int quantity = Integer.parseInt(productStr[QUANTITY]);

				Items product = new Items(name, price, quantity);
				products.add(product); 
			}
			displayProducts();
			file.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void displayProducts() {
		for (Items product : products) {
			System.out.println(product);

		}
	}
	
	
	
	//exit pop up window
	private class confirmExit extends JFrame implements ActionListener {
		private JLabel lbl = new JLabel("Are you sure you want to exit?");
		private JButton okButton = new JButton("Exit");
		private JButton cancelButton = new JButton("Cancel");
		public confirmExit(String title) {
			super(title);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(250,110);
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
	
	
	
	public shoppingGui() {
		//title
		setTitle("Shop.com Express App");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//app size
		setBounds(100, 100, 813, 515);
		setListener();
		
	//menubar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
	//accountinfo
		JButton accountInfoBtn = new JButton("Account Info");
		accountInfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText("");
				output.append(customer[0] + "\n"); 
			}
		});
		accountInfoBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(accountInfoBtn);
		JPanel panel_4 = new JPanel();
		menuBar.add(panel_4);
		JLabel lblNewLabel_1 = new JLabel("Welcome to Shop.com! ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel_4.add(lblNewLabel_1);
		
		
		//!!!!
	//cart summary
		JButton cartSumBtn = new JButton("Cart Summary");
		readFromFile();
		cartSumBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				for (Items product : products) {
					output.append(product.toString() +"\n");
				}
				output.setText(" "); 
				output.setText(cart.toString());
			}
		});
		menuBar.add(cartSumBtn);
		
		
		

	//clear cart button
		JButton clearBtn = new JButton("Clear Cart");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PrintWriter pw = new PrintWriter("cartData.txt");
					pw.print("");
					pw.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				output.setText("Cart cleared!\n");
			}
		});
		menuBar.add(clearBtn);
		

		overallPanel = new JPanel();
		overallPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(overallPanel);
		overallPanel.setLayout(new GridLayout(2, 2, 0, 0));
		JPanel topPanel = new JPanel();
		overallPanel.add(topPanel);
		topPanel.setLayout(new BorderLayout(0, 0));
		JPanel mainPanel = new JPanel();
		topPanel.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		
		
	//clothing
		JLabel clothingLabel = new JLabel("Clothing");
		clothingLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clothingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainPanel.add(clothingLabel);
		
		clothingCombo = new JComboBox(clothing);
		clothingCombo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
		        System.out.println("clothing item selected");
		        }
			});
		mainPanel.add(clothingCombo);
		
		//quantity spinner panel
		JPanel cloQuanPan = new JPanel();
		mainPanel.add(cloQuanPan);
		cloQuanPan.setLayout(null);
		JSpinner cloSpinner = new JSpinner();
		cloSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		//actionlistener for jspinner
		cloSpinner.addChangeListener(new ChangeListener() {      
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("clothing quantity changed");
			}
			});
		cloSpinner.setBounds(145, 0, 51, 72);
		cloQuanPan.add(cloSpinner);
		
		//add button
		JButton cloAddBtn = new JButton("Add to cart");
		cloAddBtn.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
				int quantity = (Integer) cloSpinner.getValue(); 
				Clothing selectedClothing = (Clothing) clothingCombo.getSelectedItem(); 
				selectedClothing.setQuantity(quantity); 
				cart.add(selectedClothing); 
				if(quantity<=0) {
					output.append("Quantity is set to zero! Nothing added to cart \n");
					System.out.println("nothing added to cart!");
				} else {
				System.out.println("cart add button clicked");
				output.append(quantity +" " + selectedClothing.getName() +  " has been added to your cart! \n");
				PrintWriter pw1 = new PrintWriter(new FileOutputStream("cartData.txt", true));
				pw1.println(clothingCombo.getSelectedItem() +", " + quantity);
				pw1.close();
				}}catch(Exception e1){
					e1.printStackTrace();
				}	
			}
		});
		mainPanel.add(cloAddBtn);
	
		
		
	//electronics
		JLabel ElectronicsLbl = new JLabel("Electronics");
		ElectronicsLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ElectronicsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		mainPanel.add(ElectronicsLbl);
		
		electronicCombo = new JComboBox(electronic);
		electronicCombo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
		        System.out.println("electronic item selected");
		        Electronics selectedElectronic = (Electronics) electronicCombo.getSelectedItem();
		        }
			});
		mainPanel.add(electronicCombo);
		
		//quantity spinner panel
		JPanel elecQuanPan = new JPanel();
		elecQuanPan.setLayout(null);
		mainPanel.add(elecQuanPan);
		
		JSpinner elecSpinner = new JSpinner();
		elecSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		elecSpinner.addChangeListener(new ChangeListener() {      
			  @Override
			  public void stateChanged(ChangeEvent e) {
			   System.out.println("electronics quantity changed");
			  }
			});
	
		elecSpinner.setBounds(145, 0, 51, 72);
		elecQuanPan.add(elecSpinner);
		
		//add button
		JButton elecAddBtn = new JButton("Add to cart");
		elecAddBtn.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("electronics add button clicked");
				try {
				int quantity2 = (Integer) elecSpinner.getValue(); 
				Electronics selectedElectronic = (Electronics) electronicCombo.getSelectedItem(); 
				selectedElectronic.setQuantity(quantity2); 
				cart.add(selectedElectronic); 
				if(quantity2<=0) {
					output.append("Quantity is set to zero! Nothing added to cart \n");
					System.out.println("nothing added to cart!");
				} else {
				System.out.println("cart add button clicked");
				output.append(quantity2 +" " + selectedElectronic.getName() +  " has been added to your cart! \n");
				PrintWriter pw2 = new PrintWriter(new FileOutputStream("cartData.txt", true));
				pw2.println(electronicCombo.getSelectedItem() +", " + quantity2);
				pw2.close();
				}}catch(Exception e1){
					e1.printStackTrace();
				}	
			}
		});
		mainPanel.add(elecAddBtn);
		
		
		
	//consumables
		JLabel consumablesLbl = new JLabel("Consumables");
		consumablesLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		consumablesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		mainPanel.add(consumablesLbl);
		
		consumableCombo = new JComboBox(consumable);
		consumableCombo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
		        System.out.println("consumable item selected");
		        }
			});
		mainPanel.add(consumableCombo);
		
		//quantity spinner panel
		JPanel conQuanPan = new JPanel();
		conQuanPan.setLayout(null);
		mainPanel.add(conQuanPan);
		JSpinner conSpinner = new JSpinner();
		conSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		conSpinner.addChangeListener(new ChangeListener() {      
				@Override
				public void stateChanged(ChangeEvent e) { 
					System.out.println("consumables quantity changed");
				}
				});
		conSpinner.setBounds(145, 0, 51, 72);
		conQuanPan.add(conSpinner);
		
		//add button
		JButton conAddBtn = new JButton("Add to cart");
		conAddBtn.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("consumables add button clicked");
				try {
				int quantity3 = (Integer) conSpinner.getValue(); 
				Consumables selectedConsumable = (Consumables) consumableCombo.getSelectedItem(); 
				selectedConsumable.setQuantity(quantity3); 
				cart.add(selectedConsumable); 
				
				if(quantity3<=0) {
					output.append("Quantity is set to zero! Nothing added to cart \n");
					System.out.println("nothing added to cart!");
				} else {
				System.out.println("cart add button clicked");
				output.append(quantity3 +" " + selectedConsumable.getName() +  " has been added to your cart! \n");
				PrintWriter pw3 = new PrintWriter(new FileOutputStream("cartData.txt", true));
				pw3.println(consumableCombo.getSelectedItem() +", " + quantity3);
				pw3.close();
				}}catch(Exception e1){
					e1.printStackTrace();
				}	
			}
		});
		mainPanel.add(conAddBtn);
		
	//console
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Console", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		overallPanel.add(bottomPanel);
		bottomPanel.setLayout(new BorderLayout(0, 0));
	    output = new JTextArea();
	    output.setEditable(false);
		bottomPanel.add(output, BorderLayout.CENTER);
	}


	
	//window listener
	private void setListener() {
		addWindowListener(this);
	}
	//window status
	@Override
	public void windowOpened(WindowEvent e) {

	}
	@Override
	public void windowClosing(WindowEvent e) {
		confirmExit exitframe = new confirmExit("Confirm Exit");
		exitframe.setVisible(true);
	}
	@Override
	public void windowClosed(WindowEvent e) {

	}
	@Override
	public void windowIconified(WindowEvent e) {

	}
	@Override
	public void windowDeiconified(WindowEvent e) {

	}
	@Override
	public void windowActivated(WindowEvent e) {

	}
	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
