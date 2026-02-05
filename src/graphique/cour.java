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

public class cour extends JFrame {
	private JTextField textField_1;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	ArrayList < Integer > classid = new ArrayList<>();
	private Connection con;
	private DefaultTableModel Model;
	private JTable table;
	JComboBox comboBox_1_1;
	JComboBox comboBox_1;
	JComboBox comboBox;
	JComboBox comboBox_3;
	JComboBox comboBox_2;
	public cour() {
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
		
		JLabel lbllev = new JLabel("PROGRAME ");
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
			@Override
			public void mouseClicked(MouseEvent e) {
				updatetb();
				Model.setRowCount(0);
				populateTable();
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
			@Override
			public void mouseClicked(MouseEvent e) {
				search();
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
		lblNewLabel_1.setIcon(new ImageIcon(cour.class.getResource("/photo/left return.png")));
		
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
		
		JLabel lblNewLabel_4_1 = new JLabel("    CLEAR");
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
		panel_2_1.setBounds(10, 527, 128, 39);
		panel_2.add(panel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("   AJOUTER ");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Unispace", Font.BOLD, 17));
		lblNewLabel_4.setBounds(0, 0, 128, 39);
		panel_2_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("SALLE");
		lblNewLabel_4_2_1.setBounds(10, 34, 83, 32);
		panel_2.add(lblNewLabel_4_2_1);
		lblNewLabel_4_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1.setBackground(new Color(74, 31, 61));
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("HEUER ");
		lblNewLabel_4_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2.setBounds(10, 203, 83, 32);
		panel_2.add(lblNewLabel_4_2_1_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(103, 206, 185, 32);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_4_2_1_2_1 = new JLabel("DE DÉBUT ");
		lblNewLabel_4_2_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2_1.setBounds(10, 221, 128, 32);
		panel_2.add(lblNewLabel_4_2_1_2_1);
		
		JLabel lblNewLabel_4_2_1_1_1_1 = new JLabel("DURÉE ");
		lblNewLabel_4_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_1_1_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_1_1_1.setBounds(10, 328, 96, 32);
		panel_2.add(lblNewLabel_4_2_1_1_1_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"salle 1", "salle 2", "salle 3", "salle 4", "salle 5", "salle 6", "salle 7", "salle 8"}));
		comboBox_1.setToolTipText("1 AM\r\n2 AM \r\n3 AM\r\n4 AM\r\n1 AS\r\n2 AS\r\n3 AS");
		comboBox_1.setForeground(new Color(74, 31, 61));
		comboBox_1.setFont(new Font("Unispace", Font.BOLD, 16));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(103, 34, 185, 32);
		panel_2.add(comboBox_1);
		
		JLabel lblNewLabel_4_2_1_2_1_2 = new JLabel("");
		lblNewLabel_4_2_1_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1_2.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2_1_2.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2_1_2.setBounds(10, 227, 128, 32);
		panel_2.add(lblNewLabel_4_2_1_2_1_2);
		
		JLabel lblNewLabel_4_2_1_1_1 = new JLabel("LE JOUR");
		lblNewLabel_4_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_1_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_1_1.setBounds(10, 263, 83, 32);
		panel_2.add(lblNewLabel_4_2_1_1_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1 AM ", "2 AM", "3 AM", "4 AM", "1 AS", "2 AS", "3 AS"}));
		comboBox.setToolTipText("1 AM\r\n2 AM \r\n3 AM\r\n4 AM\r\n1 AS\r\n2 AS\r\n3 AS");
		comboBox.setForeground(new Color(74, 31, 61));
		comboBox.setFont(new Font("Unispace", Font.BOLD, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(103, 150, 185, 32);
		panel_2.add(comboBox);
		
		JLabel lblNewLabel_4_2_1_2_1_1_1 = new JLabel("SCOLAIRE ");
		lblNewLabel_4_2_1_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2_1_1_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2_1_1_1.setBounds(10, 161, 128, 32);
		panel_2.add(lblNewLabel_4_2_1_2_1_1_1);
		
		JLabel lblNewLabel_4_2_1_2_2_1 = new JLabel("ANNÉE ");
		lblNewLabel_4_2_1_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_2_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_2_2_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_2_2_1.setBounds(10, 143, 83, 32);
		panel_2.add(lblNewLabel_4_2_1_2_2_1);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("MODULES ");
		lblNewLabel_4_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		lblNewLabel_4_2_1_1.setBackground(new Color(74, 31, 61));
		lblNewLabel_4_2_1_1.setBounds(10, 101, 83, 32);
		panel_2.add(lblNewLabel_4_2_1_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"2 HOURS", "3 HOURS", "1 HOUR 30 MIN"}));
		comboBox_2.setToolTipText("1 AM\r\n2 AM \r\n3 AM\r\n4 AM\r\n1 AS\r\n2 AS\r\n3 AS");
		comboBox_2.setForeground(new Color(74, 31, 61));
		comboBox_2.setFont(new Font("Unispace", Font.BOLD, 16));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(103, 328, 185, 32);
		panel_2.add(comboBox_2);
		
		comboBox_1_1 = new JComboBox();
		comboBox_1_1.setToolTipText("1 AM\r\n2 AM \r\n3 AM\r\n4 AM\r\n1 AS\r\n2 AS\r\n3 AS");
		comboBox_1_1.setForeground(new Color(74, 31, 61));
		comboBox_1_1.setFont(new Font("Unispace", Font.BOLD, 16));
		comboBox_1_1.setBackground(Color.WHITE);
		comboBox_1_1.setBounds(103, 101, 185, 32);
		panel_2.add(comboBox_1_1);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"DIMANCHE ", "LUNDI ", "MARDI ", "MERCREDI ", "JEUDI ", "VENDREDI ", "SAMEDI"}));
		comboBox_3.setToolTipText("1 AM\r\n2 AM \r\n3 AM\r\n4 AM\r\n1 AS\r\n2 AS\r\n3 AS");
		comboBox_3.setForeground(new Color(74, 31, 61));
		comboBox_3.setFont(new Font("Unispace", Font.BOLD, 16));
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(103, 263, 185, 32);
		panel_2.add(comboBox_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 45, 13);
		panel.add(lblNewLabel);
	
	    Model = new DefaultTableModel();
	    Model.addColumn("salle");
	    Model.addColumn("module");
	    Model.addColumn("anneé scolaire");
	    Model.addColumn("hour de debut");
	    Model.addColumn("le jour");
	    Model.addColumn("dureé");
	    
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(328, 81, 858, 632);
		panel.add(scrollPane);
		
		table = new JTable(Model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        String selectedValueComboBox1 = table.getValueAt(table.getSelectedRow(), 0).toString();
		        comboBox_1.setSelectedItem(selectedValueComboBox1);
		        
		        String selectedValueComboBox2 = table.getValueAt(table.getSelectedRow(), 1).toString();
		        comboBox_1_1.setSelectedItem(selectedValueComboBox2);
		        
		        String selectedValueComboBox22 = table.getValueAt(table.getSelectedRow(), 2).toString();
		        comboBox.setSelectedItem(selectedValueComboBox22);
				
		        
		        textField_3.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
		        
		        String selectedValueComboBox7 = table.getValueAt(table.getSelectedRow(), 4).toString();
		        comboBox_3.setSelectedItem(selectedValueComboBox7);
		        
		        String selectedValueComboBox8 = table.getValueAt(table.getSelectedRow(), 5).toString();
		        comboBox_2.setSelectedItem(selectedValueComboBox8);
				
				
				
				
				
				
				
				
				
				
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
                comboBox_1_1.addItem(moduleTaught);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private void populateTable() {
	    try {
	        String query = "SELECT * FROM emploi_du_temps";
	        PreparedStatement preparedStatement = con.prepareStatement(query);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	        	classid.add(resultSet.getInt("id"));
	            String nom = resultSet.getString("salle");
	            String prenom = resultSet.getString("module_enseigne");
	            String dateNaissance = resultSet.getString("annee_scolaire");
	            String telephone = resultSet.getString("heure_debut");
	            String genre = resultSet.getString("jour");
	            String moduleEnseigne = resultSet.getString("duree");
	            

	            Model.addRow(new Object[]{ nom, prenom, dateNaissance, telephone, genre, moduleEnseigne});
	            
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	
	}
	
	private void inserten() {
	    try {
	        String query = "insert into emploi_du_temps (salle,module_enseigne,annee_scolaire,heure_debut,jour,duree) values (?,?,?,?,?,?)";
	        PreparedStatement preparedStatement = con.prepareStatement(query);
	        preparedStatement.setString(1,comboBox_1.getSelectedItem().toString());
	        preparedStatement.setString(2, comboBox_1_1.getSelectedItem().toString());
	        preparedStatement.setString(3, comboBox.getSelectedItem().toString());
	        preparedStatement.setString(4,textField_3.getText());
	        preparedStatement.setString(5, comboBox_3.getSelectedItem().toString());
	        preparedStatement.setString(6, comboBox_2.getSelectedItem().toString());
	        
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

	            String query = "update emploi_du_temps set salle=?,module_enseigne=?,annee_scolaire=?,heure_debut=?,jour=?,duree=? where id=?";
	            PreparedStatement preparedStatement = con.prepareStatement(query);
	            preparedStatement.setString(1, comboBox_1.getSelectedItem().toString());
	            preparedStatement.setString(2, comboBox_1_1.getSelectedItem().toString());
	            preparedStatement.setString(3, comboBox.getSelectedItem().toString());
	            preparedStatement.setString(4, textField_3.getText());
	            preparedStatement.setString(5, comboBox_3.getSelectedItem().toString());
	            preparedStatement.setString(6, comboBox_2.getSelectedItem().toString());
	            preparedStatement.setInt(7, classid.get(selectedRow));

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
	            String query = "delete from emploi_du_temps where id=?";
	            PreparedStatement preparedStatement = con.prepareStatement(query);
	            preparedStatement.setInt(1, classid.get(selectedRow));
	            preparedStatement.executeUpdate();
	            JOptionPane.showMessageDialog(this, "Supprimé avec succès");          
	            // Après la suppression, supprimez la ligne du modèle
	            Model.removeRow(selectedRow);
	            // Enlevez également l'ID de la liste ensgid
	            classid.remove(selectedRow);
	        } else {
	            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une ligne à supprimer.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	private void search() {
	    String searchTerm = textField_1.getText().trim();

	    if (!searchTerm.isEmpty()) {
	        Model.setRowCount(0);

	        try {
	            String query = "SELECT * FROM emploi_du_temps WHERE module_enseigne = ?";
	            PreparedStatement preparedStatement = con.prepareStatement(query);
	            preparedStatement.setString(1, searchTerm);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                classid.add(resultSet.getInt("id"));
	                String nom = resultSet.getString("salle");
	                String prenom = resultSet.getString("module_enseigne");
	                String dateNaissance = resultSet.getString("annee_scolaire");
	                String telephone = resultSet.getString("heure_debut");
	                String genre = resultSet.getString("jour");
	                String moduleEnseigne = resultSet.getString("duree");

	                Model.addRow(new Object[]{ nom, prenom, dateNaissance, telephone, genre, moduleEnseigne});
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
