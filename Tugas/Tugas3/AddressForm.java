package Tugas.Tugas3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddressForm extends JPanel {
    private DefaultTableModel tableModel;

    public AddressForm() {
        setLayout(null);

        JLabel addressLabel = new JLabel("Alamat:");
        addressLabel.setBounds(20, 20, 100, 25);
        JTextArea addressArea = new JTextArea();
        addressArea.setBounds(120, 20, 150, 50);

        JLabel cityLabel = new JLabel("Kota:");
        cityLabel.setBounds(20, 80, 100, 25);
        String[] cities = {"Jakarta", "Bandung", "Surabaya", "Medan", "Makassar"};
        JComboBox<String> cityComboBox = new JComboBox<>(cities);
        cityComboBox.setBounds(120, 80, 150, 25);

        JButton submitButton = new JButton("Simpan");
        submitButton.setBounds(120, 120, 100, 25);

        // Table to display inputs
        tableModel = new DefaultTableModel(new Object[]{"Alamat", "Kota"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(300, 20, 350, 100);

        add(addressLabel);
        add(addressArea);
        add(cityLabel);
        add(cityComboBox);
        add(submitButton);
        add(scrollPane);

        submitButton.addActionListener(e -> {
            String address = addressArea.getText();
            String city = (String) cityComboBox.getSelectedItem();
            tableModel.addRow(new Object[]{address, city});
        });
    }
}
