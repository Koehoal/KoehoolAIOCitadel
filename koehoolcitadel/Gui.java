package koehoolcitadel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class Gui extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 339, 188);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Mining", null, panel, null);
		panel.setLayout(null);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Use Mining");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(6, 7, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 37, 362, 2);
		panel.add(separator);
		
		final JCheckBox checkBox_5 = new JCheckBox("Take Anagogic Orts");
		checkBox_5.setBounds(6, 46, 129, 23);
		panel.add(checkBox_5);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Stone", "Ore", "Precious Ore"}));
		comboBox.setBounds(116, 76, 208, 20);
		panel.add(comboBox);
		
		JLabel lblOreToMine = new JLabel("Ore To Mine : ");
		lblOreToMine.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOreToMine.setBounds(16, 79, 90, 14);
		panel.add(lblOreToMine);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("WoodCutting", null, panel_1, null);
		panel_1.setLayout(null);
		
		final JRadioButton rdbtnUseWoodcutting = new JRadioButton("Use WoodCutting");
		buttonGroup.add(rdbtnUseWoodcutting);
		rdbtnUseWoodcutting.setBounds(6, 7, 109, 23);
		panel_1.add(rdbtnUseWoodcutting);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-15, 37, 362, 2);
		panel_1.add(separator_1);
		
		final JCheckBox checkBox_4 = new JCheckBox("Take Anagogic Orts");
		checkBox_4.setBounds(6, 46, 129, 23);
		panel_1.add(checkBox_4);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Crafting", null, panel_2, null);
		panel_2.setLayout(null);
		
		final JRadioButton rdbtnUseCrafting = new JRadioButton("Use Crafting");
		buttonGroup.add(rdbtnUseCrafting);
		rdbtnUseCrafting.setBounds(6, 7, 109, 23);
		panel_2.add(rdbtnUseCrafting);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-18, 37, 362, 2);
		panel_2.add(separator_2);
		
		final JCheckBox checkBox_3 = new JCheckBox("Take Anagogic Orts");
		checkBox_3.setBounds(6, 46, 129, 23);
		panel_2.add(checkBox_3);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Summoning", null, panel_3, null);
		panel_3.setLayout(null);
		
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Use Summoning");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(6, 7, 109, 23);
		panel_3.add(rdbtnNewRadioButton_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(-28, 37, 362, 2);
		panel_3.add(separator_3);
		
		final JCheckBox checkBox_2 = new JCheckBox("Take Anagogic Orts");
		checkBox_2.setBounds(6, 46, 129, 23);
		panel_3.add(checkBox_2);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Cooking", null, panel_4, null);
		panel_4.setLayout(null);
		
		final JRadioButton rdbtnUseCooking = new JRadioButton("Use Cooking");
		buttonGroup.add(rdbtnUseCooking);
		rdbtnUseCooking.setBounds(6, 7, 109, 23);
		panel_4.add(rdbtnUseCooking);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(-16, 37, 362, 2);
		panel_4.add(separator_4);
		
		final JCheckBox checkBox_1 = new JCheckBox("Take Anagogic Orts");
		checkBox_1.setBounds(6, 46, 129, 23);
		panel_4.add(checkBox_1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("FireMaking", null, panel_5, null);
		panel_5.setLayout(null);
		
		final JRadioButton rdbtnUseFiremaking = new JRadioButton("Use FireMaking");
		buttonGroup.add(rdbtnUseFiremaking);
		rdbtnUseFiremaking.setBounds(6, 7, 109, 23);
		panel_5.add(rdbtnUseFiremaking);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(-14, 37, 362, 2);
		panel_5.add(separator_5);
		
		final JCheckBox checkBox = new JCheckBox("Take Anagogic Orts");
		checkBox.setBounds(6, 46, 129, 23);
		panel_5.add(checkBox);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Smithing", null, panel_6, null);
		panel_6.setLayout(null);
		
		final JRadioButton rdbtnUseSmithing = new JRadioButton("Use Smithing");
		buttonGroup.add(rdbtnUseSmithing);
		rdbtnUseSmithing.setBounds(6, 7, 109, 23);
		panel_6.add(rdbtnUseSmithing);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(-14, 37, 362, 2);
		panel_6.add(separator_6);
		
		final JCheckBox chckbxTakeAnagogicOrts = new JCheckBox("Take Anagogic Orts");
		chckbxTakeAnagogicOrts.setBounds(6, 48, 129, 23);
		panel_6.add(chckbxTakeAnagogicOrts);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxTakeAnagogicOrts.isSelected() || checkBox.isSelected() || checkBox_1.isSelected() || checkBox_2.isSelected()
						|| checkBox_3.isSelected() || checkBox_4.isSelected() || checkBox_5.isSelected()){
					KoehoalCitadel.Loot = true;
				}
				
				if(rdbtnNewRadioButton.isSelected()){
					KoehoalCitadel.Task = "Mining";
					if(comboBox.getSelectedItem().toString().contentEquals("Stone")){
						KoehoalCitadel.Resource = "Stone";
					}else if(comboBox.getSelectedItem().toString().contentEquals("Ore")){
						KoehoalCitadel.Resource = "Ore";
					}else if(comboBox.getSelectedItem().toString().contentEquals("Precious Ore")){
						KoehoalCitadel.Resource = "Precious Ore";
					}
				}else if(rdbtnUseWoodcutting.isSelected()){
					KoehoalCitadel.Task = "WoodCutting";
					KoehoalCitadel.Resource = "Root";
				}else if(rdbtnUseCrafting.isSelected()){
					KoehoalCitadel.Task = "Crafting";
					KoehoalCitadel.Resource = "Loom";
				}else if(rdbtnNewRadioButton_1.isSelected()){
					KoehoalCitadel.Task = "Summoning";
					KoehoalCitadel.Resource = "Obelisk";
				}else if(rdbtnUseCooking.isSelected()){
					KoehoalCitadel.Task = "Cooking";
					
				}else if(rdbtnUseFiremaking.isSelected()){
					KoehoalCitadel.Task = "FireMaking";
					KoehoalCitadel.Resource = "Charcoal";
				}else if(rdbtnUseSmithing.isSelected()){
					KoehoalCitadel.Task = "Smithing";
					
				}
				
				
				dispose();
			}
		});
		btnStart.setBounds(10, 190, 104, 23);
		contentPane.add(btnStart);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setBounds(114, 190, 106, 23);
		contentPane.add(btnClose);
		
		JButton btnVisitThread = new JButton("Visit Thread");
		btnVisitThread.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisitThread.setBounds(223, 190, 106, 23);
		contentPane.add(btnVisitThread);
	}
}
