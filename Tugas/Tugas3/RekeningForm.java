package Tugas.Tugas3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RekeningForm extends JPanel {
    private DefaultTableModel tableModel;

    public RekeningForm() {
        setLayout(null);

        JLabel accountTypeLabel = new JLabel("Jenis Rekening:");
        accountTypeLabel.setBounds(20, 20, 100, 25);
        String[] accountTypes = {"Tabungan", "Giro", "Deposito"};
        JComboBox<String> accountTypeComboBox = new JComboBox<>(accountTypes);
        accountTypeComboBox.setBounds(130, 20, 170, 25);

        JLabel skillsLabel = new JLabel("Tipe Rekening:");
        skillsLabel.setBounds(20, 60, 150, 25);
        String[] skills = {"Silver", "Gold", "Platinum", "Diamond"};
        JList<String> skillList = new JList<>(skills);
        skillList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane skillScrollPane = new JScrollPane(skillList);
        skillScrollPane.setBounds(130, 60, 170, 60);

        JButton submitButton = new JButton("Simpan");
        submitButton.setBounds(120, 130, 100, 25);

        // Table to display inputs
        tableModel = new DefaultTableModel(new Object[]{"Jenis Rekening", "Tipe Rekening"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(310, 20, 320, 100);

        add(accountTypeLabel);
        add(accountTypeComboBox);
        add(skillsLabel);
        add(skillScrollPane);
        add(submitButton);
        add(scrollPane);

        submitButton.addActionListener(e -> {
            String accountType = (String) accountTypeComboBox.getSelectedItem();
            java.util.List<String> skillsSelected = skillList.getSelectedValuesList();
            tableModel.addRow(new Object[]{accountType, String.join(", ", skillsSelected)});
        });
    }
}
