package graphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;


import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class facture extends JFrame {
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Connection con;
	private JTable table;
	private JTable table_1;
	
	public facture() {
		setTitle("AN SCHOLL");
		setSize(1200,750);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1196, 713);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(74, 31, 61));
		panel_1.setBounds(0, 0, 1186, 81);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbllev = new JLabel("FACTURE");
		lbllev.setForeground(new Color(168, 79, 84));
		lbllev.setFont(new Font("Dialog", Font.BOLD, 30));
		lbllev.setBounds(71, 3, 247, 59);
		panel_1.add(lbllev);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1_2.setBackground(new Color(162,79,70));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1_2.setBackground(new Color(168, 79, 84));
			}
		});
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1_2.setBackground(new Color(168, 79, 84));
		panel_2_1_2.setBounds(396, 20, 128, 39);
		panel_1.add(panel_2_1_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("  SUPPRIME ");
		lblNewLabel_4_2.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4_2.setBounds(0, 0, 128, 39);
		panel_2_1_2.add(lblNewLabel_4_2);
		
		JPanel panel_2_1_3 = new JPanel();
		panel_2_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1_3.setBackground(new Color(162,79,70));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1_3.setBackground(new Color(168, 79, 84));
			}
		});
		panel_2_1_3.setLayout(null);
		panel_2_1_3.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1_3.setBackground(new Color(168, 79, 84));
		panel_2_1_3.setBounds(560, 20, 134, 39);
		panel_1.add(panel_2_1_3);
		
		JLabel lblNewLabel_4_3 = new JLabel("    ÉDIT ");
		lblNewLabel_4_3.setForeground(Color.WHITE);
		lblNewLabel_4_3.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4_3.setBounds(10, 0, 128, 39);
		panel_2_1_3.add(lblNewLabel_4_3);
		
		JPanel panel_2_1_4 = new JPanel();
		panel_2_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1_4.setBackground(new Color(162,79,70));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1_4.setBackground(new Color(168, 79, 84));
			}
		});
		panel_2_1_4.setLayout(null);
		panel_2_1_4.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1_4.setBackground(new Color(168, 79, 84));
		panel_2_1_4.setBounds(968, 20, 128, 39);
		panel_1.add(panel_2_1_4);
		
		JLabel lblNewLabel_4_4 = new JLabel("   SEARCH");
		lblNewLabel_4_4.setForeground(Color.WHITE);
		lblNewLabel_4_4.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4_4.setBounds(0, 0, 128, 39);
		panel_2_1_4.add(lblNewLabel_4_4);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		textField_1.setColumns(10);
		textField_1.setCaretColor(Color.WHITE);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(74, 31, 61));
		textField_1.setBounds(754, 20, 188, 39);
		panel_1.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(754, 59, 188, 25);
		panel_1.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new menu().setVisible(true);dispose();
			}
		});
		lblNewLabel_1.setBounds(0, 0, 61, 51);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(facture.class.getResource("/photo/left return.png")));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(168, 79, 84));
		panel_2.setBounds(0, 81, 330, 632);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1_1.setBackground(new Color(162,79,70));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1_1.setBackground(new Color(168, 79, 84));
			}
		});
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1_1.setBackground(new Color(168, 79, 84));
		panel_2_1_1.setBounds(172, 527, 128, 39);
		panel_2.add(panel_2_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("  IMPRIMER ");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4_1.setBounds(0, 0, 128, 39);
		panel_2_1_1.add(lblNewLabel_4_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1.setBackground(new Color(162,79,70));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1.setBackground(new Color(168, 79, 84));
			}
		});
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1.setBackground(new Color(168, 79, 84));
		panel_2_1.setBounds(75, 437, 128, 39);
		panel_2.add(panel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("  CALCULER");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4.setBounds(0, 0, 128, 39);
		panel_2_1.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 AM ", "2 AM", "3 AM", "4 AM", "1 AS", "2 AS", "3 AS"}));
		comboBox.setToolTipText("1 AM\r\n2 AM \r\n3 AM\r\n4 AM\r\n1 AS\r\n2 AS\r\n3 AS");
		comboBox.setForeground(new Color(74, 31, 61));
		comboBox.setFont(new Font("Unispace", Font.BOLD, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(103, 47, 185, 32);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_4_2_1_2_1_1_1 = new JLabel("SCOLAIRE ");
		lblNewLabel_4_2_1_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2_1_1_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2_1_1_1.setBounds(10, 58, 128, 32);
		panel_2.add(lblNewLabel_4_2_1_2_1_1_1);
		
		JLabel lblNewLabel_4_2_1_2_2_1 = new JLabel("ANNÉE ");
		lblNewLabel_4_2_1_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_2_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2_2_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2_2_1.setBounds(10, 40, 83, 32);
		panel_2.add(lblNewLabel_4_2_1_2_2_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setToolTipText("1 AM\r\n2 AM \r\n3 AM\r\n4 AM\r\n1 AS\r\n2 AS\r\n3 AS");
		comboBox_1_1.setForeground(new Color(74, 31, 61));
		comboBox_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		comboBox_1_1.setBackground(Color.WHITE);
		comboBox_1_1.setBounds(103, 124, 185, 32);
		panel_2.add(comboBox_1_1);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("ÉLEVÉ ");
		lblNewLabel_4_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_1.setBounds(10, 124, 83, 32);
		panel_2.add(lblNewLabel_4_2_1_1);
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("MONTANT TOTAL : ");
		lblNewLabel_4_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2.setBounds(10, 190, 242, 32);
		panel_2.add(lblNewLabel_4_2_1_2);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2_1_1_1.setBackground(new Color(162,79,70));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2_1_1_1.setBackground(new Color(168, 79, 84));
			}
		});
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1_1_1.setBackground(new Color(168, 79, 84));
		panel_2_1_1_1.setBounds(21, 527, 117, 39);
		panel_2.add(panel_2_1_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("   CLEAR");
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4_1_1.setBounds(0, 0, 118, 39);
		panel_2_1_1_1.add(lblNewLabel_4_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 82, 855, 631);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		


	}
	

	

	
}
