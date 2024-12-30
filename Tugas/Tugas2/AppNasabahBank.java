import java.awt.event.*;
import javax.swing.*;

public class AppNasabahBank extends JFrame {

    public AppNasabahBank() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label untuk input Nama
        JLabel labelInputnama = new JLabel("Nama : ");
        labelInputnama.setBounds(30, 20, 100, 20);

        // JTextField untuk memasukan Nama
        JTextField textFieldnama = new JTextField();
        textFieldnama.setBounds(140, 20, 150, 30);

        // Label untuk input nomor telepon
        JLabel labelInputnomor = new JLabel("Nomor Telepon : ");
        labelInputnomor.setBounds(30, 60, 100, 20);

        // JTextField untuk memasukan nomor telepon
        JTextField textFieldnomor = new JTextField();
        textFieldnomor.setBounds(140, 60, 150, 30);

        // Label untuk memilih jenis kelamin
        JLabel labelRadio = new JLabel("Jenis kelamin:");
        labelRadio.setBounds(30, 100, 100, 20);

        // RadioButton untuk pilihan Laki-Laki
        JRadioButton radioButton1 = new JRadioButton("Laki - Laki");
        radioButton1.setBounds(30, 125, 100, 20);

        // RadioButton untuk pilihan Perempuan
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(30, 150, 100, 20);

        // ButtonGroup untuk mengelompokkan pilihan jenis kelamin
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // CheckBox untuk pilihan Warga Negara Asing (WNA)
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(30, 180, 200, 20);

        // Label untuk jenis tabungan
        JLabel labelJenisTabungan = new JLabel("Jenis Tabungan:");
        labelJenisTabungan.setBounds(30, 210, 120, 20);

        // Daftar pilihan jenis tabungan
        String[] jenisTabungan = { "Tabungan Reguler", "Tabungan Berjangka", "Tabungan Pendidikan", 
        "Tabungan Haji/Umrah", "Tabungan Pensiun", "Tabungan Syariah", "Tabungan Rencana" };
        JList<String> listJenisTabungan = new JList<>(jenisTabungan);
        listJenisTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(listJenisTabungan);
        listScrollPane.setBounds(140, 210, 150, 80);

        // MenuBar untuk menyediakan opsi Reset dan Exit
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuReset = new JMenuItem("Reset");
        JMenuItem menuExit = new JMenuItem("Exit");

        // Label untuk frekuensi transaksi per bulan
        JLabel labelFrekuensiTransaksi = new JLabel("Frekuensi Transaksi Perbulan:");
        labelFrekuensiTransaksi.setBounds(30, 300, 200, 20);

        // Spinner untuk input frekuensi transaksi (model angka)
        SpinnerModel modelFrekuensiTransaksi = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner spinnerFrekuensiTransaksi = new JSpinner(modelFrekuensiTransaksi);
        spinnerFrekuensiTransaksi.setBounds(240, 300, 100, 30);

        // Label untuk input password
        JLabel labelPassword = new JLabel("Password :");
        labelPassword.setBounds(30, 340, 100, 20);

        // PasswordField untuk input password
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(140, 340, 150, 30);

        // Label untuk konfirmasi password
        JLabel labelConfirmPassword = new JLabel("Confirm Password :");
        labelConfirmPassword.setBounds(30, 380, 150, 20);

        // PasswordField untuk konfirmasi password
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(140, 380, 150, 30);

        // Label untuk input tanggal lahir
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir :");
        labelTanggalLahir.setBounds(30, 420, 100, 20);

        // Spinner untuk input tanggal lahir dengan model tanggal
        SpinnerDateModel modelTanggalLahir = new SpinnerDateModel();
        JSpinner spinnerTanggalLahir = new JSpinner(modelTanggalLahir);
        spinnerTanggalLahir.setBounds(140, 420, 150, 30);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy");
        spinnerTanggalLahir.setEditor(editor);

        // Tombol untuk simpan data
        JButton button = new JButton("Simpan");
        button.setBounds(30, 460, 100, 30);

        // JTextArea untuk menampilkan output
        JTextArea txtOutput = new JTextArea("");
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBounds(30, 500, 300, 150);

        // ActionListener untuk tombol Simpan
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldnama.getText();
                String nomor = textFieldnomor.getText();
                String jenisKelamin = "";
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }

                String pilihanTabungan = listJenisTabungan.getSelectedValue();
                String frekuensiTransaksi = spinnerFrekuensiTransaksi.getValue().toString();
                String tanggalLahir = editor.getFormat().format(spinnerTanggalLahir.getValue());

                txtOutput.append("Nama : " + nama + "\n");
                txtOutput.append("No Telepon : " + nomor + "\n");
                txtOutput.append("Jenis Kelamin : " + jenisKelamin + "\n");
                if (checkBox.isSelected()) {
                    txtOutput.append("WNA : Ya\n");
                } else {
                    txtOutput.append("WNA : Bukan\n");
                }
                txtOutput.append(
                        "Jenis Tabungan : " + (pilihanTabungan != null ? pilihanTabungan : "Belum dipilih") + "\n");
                txtOutput.append("Frekuensi Transaksi : " + frekuensiTransaksi + "\n");

                char[] password = passwordField.getPassword();
                char[] confirmPassword = confirmPasswordField.getPassword();
                if (String.valueOf(password).equals(String.valueOf(confirmPassword))) {
                    txtOutput.append("Password: Cocok\n");
                } else {
                    txtOutput.append("Password: Tidak Cocok\n");
                }

                txtOutput.append("Tanggal Lahir : " +tanggalLahir+ "\n");
                txtOutput.append("=========================================\n");
            }
        });

        // ActionListener untuk menu Reset
        menuReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldnama.setText("");
                textFieldnomor.setText("");
                bg.clearSelection();
                checkBox.setSelected(false);
                listJenisTabungan.clearSelection();
                spinnerFrekuensiTransaksi.setValue(1);
                passwordField.setText("");
                confirmPasswordField.setText("");
                spinnerTanggalLahir.setValue(new java.util.Date());
                txtOutput.setText("");
            }
        });

        // ActionListener untuk menu Exit
        menuExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Menambahkan komponen ke menu
        menu.add(menuReset);
        menu.add(menuExit);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        // Menambahkan komponen ke JFrame
        this.add(button);
        this.add(textFieldnama);
        this.add(labelInputnama);
        this.add(textFieldnomor);
        this.add(labelInputnomor);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(labelJenisTabungan);
        this.add(listScrollPane);
        this.add(labelFrekuensiTransaksi);
        this.add(spinnerFrekuensiTransaksi);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir);
        this.add(scrollPane);

        // Menentukan ukuran JFrame dan layout
        this.setSize(500, 800);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AppNasabahBank n = new AppNasabahBank();
                n.setVisible(true);
            }
        });
    }
}
