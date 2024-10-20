import java.awt.event.*;
import javax.swing.*;

public class HelloAppBiodata extends JFrame {

    public HelloAppBiodata() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInputnama = new JLabel("Nama :");
        labelInputnama.setBounds(15,40,350,10);

        JTextField textFieldnama = new JTextField();
        textFieldnama.setBounds(15,60,350,30);

        JLabel labelInputnomor = new JLabel("Nomor :");
        labelInputnomor.setBounds(15,100,350,10);

        JTextField textFieldnomor = new JTextField();
        textFieldnomor.setBounds(15,120,350,30);

        JButton button = new JButton("Simpan");
        button.setBounds(15,205,350,40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15,250,350,100);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldnama.getText();
                String nomor = textFieldnomor.getText();
                txtOutput.append("Nama : "+nama+"\n");
                txtOutput.append("Nomor : "+nomor+"\n");
                txtOutput.append("=========================\n");
                textFieldnama.setText("");
                textFieldnomor.setText("");
            }
        });

        this.add(button);
        this.add(textFieldnama);
        this.add(labelInputnama);
        this.add(textFieldnomor);
        this.add(labelInputnomor);
        this.add(txtOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloAppBiodata h = new HelloAppBiodata();
                h.setVisible(true);
            }
        });
    }
}
