package Tugas.Tugas3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PersonalInfoForm extends JPanel {
    private DefaultTableModel tableModel;

    public PersonalInfoForm() {
        setLayout(null);

        JLabel nameLabel = new JLabel("Nama:");
        nameLabel.setBounds(20, 20, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(120, 20, 150, 25);

        JLabel ageLabel = new JLabel("Usia:");
        ageLabel.setBounds(20, 60, 100, 25);
        SpinnerModel ageModel = new SpinnerNumberModel(18, 18, 100, 1);
        JSpinner ageSpinner = new JSpinner(ageModel);
        ageSpinner.setBounds(120, 60, 50, 25);

        JLabel genderLabel = new JLabel("Jenis Kelamin:");
        genderLabel.setBounds(20, 100, 100, 25);
        JRadioButton maleRadio = new JRadioButton("Laki-Laki");
        maleRadio.setBounds(120, 100, 80, 25);
        JRadioButton femaleRadio = new JRadioButton("Perempuan");
        femaleRadio.setBounds(200, 100, 100, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        JButton submitButton = new JButton("Simpan");
        submitButton.setBounds(120, 140, 100, 25);

        // Table to display inputs
        tableModel = new DefaultTableModel(new Object[]{"Nama", "Usia", "Jenis Kelamin"}, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(300, 20, 350, 150);

        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageSpinner);
        add(genderLabel);
        add(maleRadio);
        add(femaleRadio);
        add(submitButton);
        add(scrollPane);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            int age = (Integer) ageSpinner.getValue();
            String gender = maleRadio.isSelected() ? "Laki-Laki" : "Perempuan";
            tableModel.addRow(new Object[]{name, age, gender});
        });
    }
}
