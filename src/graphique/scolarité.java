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
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class scolarité extends JFrame {
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	ArrayList < Integer > ssid = new ArrayList<>();
	private DefaultTableModel Model;
	private JTable table;
	Connection con;
	JComboBox comboBox_1;
	public scolarité() {
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
		
		JLabel lbllev = new JLabel("SCOLARITÉ ");
		lbllev.setBounds(71, 3, 247, 59);
		lbllev.setForeground(new Color(168, 79, 84));
		lbllev.setFont(new Font("Dialog", Font.BOLD, 30));
		panel_1.add(lbllev);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 61, 51);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new menu().setVisible(true);dispose();
			}
		});
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(scolarité.class.getResource("/photo/left return.png")));
		
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
			@Override
			public void mouseClicked(MouseEvent e) {
				search();
			}
		});
		panel_2_1_4.setLayout(null);
		panel_2_1_4.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1_4.setBackground(new Color(168, 79, 84));
		panel_2_1_4.setBounds(712, 17, 128, 39);
		panel_1.add(panel_2_1_4);
		
		JLabel lblNewLabel_4_4 = new JLabel("   SEARCH");
		lblNewLabel_4_4.setForeground(Color.WHITE);
		lblNewLabel_4_4.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4_4.setBounds(0, 0, 128, 39);
		panel_2_1_4.add(lblNewLabel_4_4);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(null);
		textField.setBackground(new Color(74, 31, 61));
		textField.setBounds(498, 17, 188, 39);
		panel_1.add(textField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(498, 56, 188, 25);
		panel_1.add(separator_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(168, 79, 84));
		panel_2.setBounds(0, 81, 330, 632);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
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
			@Override
			public void mouseClicked(MouseEvent e) {
				Model.setRowCount(0);
				inserten();
				populateTable();
			}
		});
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1.setBackground(new Color(168, 79, 84));
		panel_2_1.setBounds(10, 443, 128, 39);
		panel_2.add(panel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("   AJOUTER ");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4.setBounds(0, 0, 128, 39);
		panel_2_1.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(103, 212, 185, 32);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_4_2_1_2_2_2 = new JLabel("MODULÉ ");
		lblNewLabel_4_2_1_2_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_2_2.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2_2_2.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2_2_2.setBounds(10, 133, 83, 32);
		panel_2.add(lblNewLabel_4_2_1_2_2_2);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("1 AM\r\n2 AM \r\n3 AM\r\n4 AM\r\n1 AS\r\n2 AS\r\n3 AS");
		comboBox_1.setForeground(new Color(74, 31, 61));
		comboBox_1.setFont(new Font("Unispace", Font.BOLD, 16));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(103, 133, 185, 32);
		panel_2.add(comboBox_1);
		
		JLabel lblNewLabel_4_2_1_2_1_2 = new JLabel("HOUR");
		lblNewLabel_4_2_1_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1_2.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2_1_2.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2_1_2.setBounds(10, 219, 128, 32);
		panel_2.add(lblNewLabel_4_2_1_2_1_2);
		
		JLabel lblNewLabel_4_2_1_2_3 = new JLabel("PRIX");
		lblNewLabel_4_2_1_2_3.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_3.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2_3.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2_3.setBounds(10, 201, 83, 32);
		panel_2.add(lblNewLabel_4_2_1_2_3);
		
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
			@Override
			public void mouseClicked(MouseEvent e) {
				delete();
				Model.setRowCount(0);
				populateTable();
			}
		});
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1_2.setBackground(new Color(168, 79, 84));
		panel_2_1_2.setBounds(160, 443, 128, 39);
		panel_2.add(panel_2_1_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("  SUPPRIME ");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4_2.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2.setBounds(0, 0, 128, 39);
		panel_2_1_2.add(lblNewLabel_4_2);
		
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
			@Override
			public void mouseClicked(MouseEvent e) {
				updatetb();
				Model.setRowCount(0);
				populateTable();
			}
		});
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		panel_2_1_1.setBackground(new Color(168, 79, 84));
		panel_2_1_1.setBounds(85, 516, 128, 39);
		panel_2.add(panel_2_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("     ÉDIT ");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4_1.setBounds(0, 0, 128, 39);
		panel_2_1_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 45, 13);
		panel.add(lblNewLabel);
		

		
	    Model = new DefaultTableModel();
	    Model.addColumn("prix");
	    Model.addColumn("module");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(329, 81, 857, 632);
		panel.add(scrollPane);
		
		table = new JTable(Model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_2.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
		        String selectedValueComboBox2 = table.getValueAt(table.getSelectedRow(), 1).toString();
		        comboBox_1.setSelectedItem(selectedValueComboBox2);
			}
		});
		scrollPane.setViewportView(table);
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anis?user=root&password=anisroot");
			combomodel();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		populateTable();

	}
	
	
	private void combomodel()
	{
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT DISTINCT module_taught FROM enseigne");
			 ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
                String moduleTaught = rs.getString("module_taught");
                comboBox_1.addItem(moduleTaught);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void populateTable() {
	    try {
	        String query = "SELECT * FROM scolarite_table";
	        PreparedStatement preparedStatement = con.prepareStatement(query);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	        	ssid.add(resultSet.getInt("id"));
	            String nom = resultSet.getString("nom_module");
	            String prenom = resultSet.getString("price");


	            Model.addRow(new Object[]{ nom, prenom});
	            
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	
	}
	
	private void inserten() {
	    try {
	        String query = "insert into scolarite_table (nom_module,price) values (?,?)";
	        PreparedStatement preparedStatement = con.prepareStatement(query);
	        preparedStatement.setString(1, textField_2.getText());
	        preparedStatement.setString(2, comboBox_1.getSelectedItem().toString());

	        
	        preparedStatement.executeUpdate();
	        JOptionPane.showMessageDialog(this, "Ajouté avec succès");


	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	
	}
	
	private void updatetb() {
	    try {
	        int selectedRow = table.getSelectedRow();

	        if (selectedRow != -1) {
	            String query = "update scolarite_table set nom_module=?,price=? where id=?";
	            PreparedStatement preparedStatement = con.prepareStatement(query);
	            preparedStatement.setString(1, textField_2.getText());
	            preparedStatement.setString(2, comboBox_1.getSelectedItem().toString());
	            preparedStatement.setInt(3, ssid.get(selectedRow));
	            

	            preparedStatement.executeUpdate();
	            JOptionPane.showMessageDialog(this, "Mise à jour effectuée avec succès");
	        } else {
	            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à mettre à jour.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	private void delete() {
	    try {
	        int selectedRow = table.getSelectedRow();

	        if (selectedRow != -1) { 
	            String query = "delete from scolarite_table where id=?";
	            PreparedStatement preparedStatement = con.prepareStatement(query);
	            preparedStatement.setInt(1, ssid.get(selectedRow));
	            preparedStatement.executeUpdate();
	            JOptionPane.showMessageDialog(this, "Supprimé avec succès");          
	            // Après la suppression, supprimez la ligne du modèle
	            Model.removeRow(selectedRow);
	            // Enlevez également l'ID de la liste ensgid
	            ssid.remove(selectedRow);
	        } else {
	            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à supprimer.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	private void search() {
	    String searchTerm = textField.getText().trim();

	    if (!searchTerm.isEmpty()) {
	        Model.setRowCount(0);

	        try {
	            String query = "SELECT * FROM scolarite_table WHERE nom_module = ?";
	            PreparedStatement preparedStatement = con.prepareStatement(query);
	            preparedStatement.setString(1, searchTerm);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                ssid.add(resultSet.getInt("id"));
	                String nom = resultSet.getString("nom_module");
	                String prenom = resultSet.getString("price");

	                Model.addRow(new Object[]{ nom, prenom});
	            }

	            if (Model.getRowCount() == 0) {
	                JOptionPane.showMessageDialog(this, "Aucun résultat trouvé pour : " + searchTerm);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Veuillez entrer un terme de recherche.");
	    }
	}
}
