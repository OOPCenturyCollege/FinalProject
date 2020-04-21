import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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

public class shoppingGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	private Tops[] tops = {
			new Tops("T-Shirt", 9.99, 1),
			new Tops("Hoodie", 29.99, 1),
			new Tops("Blouse", 19.99, 1)
			};
	
	private Bottoms[] bottoms = {
			new Bottoms("Shorts", 10.50, 1),
			new Bottoms("Jeans", 29.99, 1),
			new Bottoms("Sweatpants", 9.99, 1)
			};
	
	private Items[] items = {
			new Items("Hat", 14.99, 1),
			new Items("Sunglasses", 29.99, 1),
			new Items("Belt", 7.99, 1)
			};
	
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public shoppingGUI() {
		setTitle("Shopping Cart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 515);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(btnNewButton);
		
		textField = new JTextField();
		menuBar.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Search");
		menuBar.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Cart");
		menuBar.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Account");
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Wish List");
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
		
		JLabel lblNewLabel = new JLabel("Quantity");
		panel_2.add(lblNewLabel);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Add to Cart");
		panel_2.add(btnNewButton_5);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		JLabel lblNewLabel_7 = new JLabel("Tops");
		panel_3.add(lblNewLabel_7);
		
		JComboBox topsCombo = new JComboBox(tops);
		panel_3.add(topsCombo);
		
		JLabel lblNewLabel_1 = new JLabel("Bottoms");
		panel_3.add(lblNewLabel_1);
		
		JComboBox bottomsCombo = new JComboBox(bottoms);
		panel_3.add(bottomsCombo);
		
		JLabel lblNewLabel_3 = new JLabel("Items");
		panel_3.add(lblNewLabel_3);
		
		JComboBox itemsCombo = new JComboBox(items);
		panel_3.add(itemsCombo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Console", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea, BorderLayout.CENTER);
	}

}
