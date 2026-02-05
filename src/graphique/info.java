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

public class info extends JFrame {
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_7;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Connection con;

	public info() {
		setTitle("AN SCHOLL");
		setSize(500,750);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anis?user=root&password=anisroot");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(74, 31, 63));
		panel.setBounds(0, 0, 486, 713);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("AN    SCHOLL");
		lblNewLabel_3.setForeground(new Color(168, 79, 84));
		lblNewLabel_3.setFont(new Font("Viner Hand ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(160, 156, 189, 49);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(info.class.getResource("/photo/scoll.png")));
		lblNewLabel.setBounds(193, 25, 104, 82);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("NOM :          AN SCHOLL");
		lblNewLabel_4_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_1.setBounds(32, 220, 421, 32);
		panel.add(lblNewLabel_4_2_1_1);
		
		JLabel lblNewLabel_4_2_1_1_1 = new JLabel("ADRESSE : Lot Mili Bir Slam BEJAIA,ALEGRIA ");
		lblNewLabel_4_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_1_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_1_1.setBounds(32, 287, 421, 32);
		panel.add(lblNewLabel_4_2_1_1_1);
		
		JLabel lblNewLabel_4_2_1_1_2 = new JLabel("TÉLÉPHONE :    0782409131");
		lblNewLabel_4_2_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_1_2.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_1_2.setBounds(32, 360, 421, 32);
		panel.add(lblNewLabel_4_2_1_1_2);
		
		JLabel lblNewLabel_4_2_1_1_3 = new JLabel("FIX :     034101694 / 034106687");
		lblNewLabel_4_2_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_3.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_1_3.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_1_3.setBounds(32, 421, 421, 32);
		panel.add(lblNewLabel_4_2_1_1_3);
		
		JLabel lblNewLabel_4_2_1_1_4 = new JLabel("NOMBRE D'ÉLÈVES :");
		lblNewLabel_4_2_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_4.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_1_4.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_1_4.setBounds(32, 481, 421, 32);
		panel.add(lblNewLabel_4_2_1_1_4);
		
		JLabel lblNewLabel_4_2_1_1_5_1 = new JLabel("NOMBRE DFORMATION DISPONIBLE :");
		lblNewLabel_4_2_1_1_5_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_5_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_1_5_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_1_5_1.setBounds(32, 554, 421, 32);
		panel.add(lblNewLabel_4_2_1_1_5_1);
		
		try {
            // Compter le nombre d'élèves
            String countElevesQuery = "SELECT COUNT(*) FROM eleve";
            PreparedStatement countElevesStatement = con.prepareStatement(countElevesQuery);
            ResultSet countElevesResult = countElevesStatement.executeQuery();

            if (countElevesResult.next()) {
                int nombreEleves = countElevesResult.getInt(1);
                
                lblNewLabel_4_2_1_1_4.setText("NOMBRE D'ÉLÈVES : " + nombreEleves);
            }

            // ... (d'autres mises à jour d'informations similaires)

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		try {
            
            String countElevesQuery = "SELECT COUNT(*) FROM enseigne";
            PreparedStatement countElevesStatement = con.prepareStatement(countElevesQuery);
            ResultSet countElevesResult = countElevesStatement.executeQuery();

            if (countElevesResult.next()) {
                int nombreEleves = countElevesResult.getInt(1);
                
                lblNewLabel_4_2_1_1_5_1.setText("NOMBRE DFORMATION DISPONIBLE : " + nombreEleves);
            }

            // ... (d'autres mises à jour d'informations similaires)

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		
		
		
    }
		
	}

