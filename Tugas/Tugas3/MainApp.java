package Tugas.Tugas3;

import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {
    private JPanel mainPanel;

    public MainApp() {
        setTitle("Nasabah Management Application");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu bar setup
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Forms");

        JMenuItem personalInfoItem = new JMenuItem("Data Pribadi Nasabah");
        JMenuItem addressItem = new JMenuItem("Alamat Nasabah");
        JMenuItem accountItem = new JMenuItem("Data Rekening");
        JMenuItem exitItem = new JMenuItem("Exit");

        personalInfoItem.addActionListener(e -> showForm(new PersonalInfoForm()));
        addressItem.addActionListener(e -> showForm(new AddressForm()));
        accountItem.addActionListener(e -> showForm(new RekeningForm()));
        exitItem.addActionListener(e -> System.exit(0));

        menu.add(personalInfoItem);
        menu.add(addressItem);
        menu.add(accountItem);
        menu.add(exitItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // Show the initial form
        showForm(new PersonalInfoForm());
    }

    private void showForm(JPanel formPanel) {
        mainPanel.removeAll();
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().setVisible(true));
    }
}
