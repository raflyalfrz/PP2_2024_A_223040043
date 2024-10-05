import java.awt.event.*;
import javax.swing.*;

public class AppBiodata extends JFrame {

    private boolean checkBoxSelected;

    public AppBiodata() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInputnama = new JLabel("Nama :");
        labelInputnama.setBounds(15,20,350,30);

        JTextField textFieldnama = new JTextField();
        textFieldnama.setBounds(15,50,350,30);

        JLabel labelInputnomor = new JLabel("Nomor Hp :");
        labelInputnomor.setBounds(15,90,350,30);

        JTextField textFieldnomor = new JTextField();
        textFieldnomor.setBounds(15,120,350,30);

        JLabel labelRadio = new JLabel("Jenis Kelamin :");
        labelRadio.setBounds(15,150,350,30);

        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15,180,350,30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15,210,350,30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15,240,350,30);

        JButton button = new JButton("Simpan");
        button.setBounds(15,290,100,40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15,350,350,100);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisMember = "";
                if(radioButton1.isSelected()){
                    jenisMember = radioButton1.getText();
                }
                if(radioButton2.isSelected()){
                    jenisMember = radioButton2.getText();
                }
        
                String nama = textFieldnama.getText();
                String nomor = textFieldnomor.getText();
                txtOutput.append("Nama : "+nama+"\n");
                txtOutput.append("Nomor : "+nomor+"\n");
                txtOutput.append("Jenis Kelamin :"+jenisMember+"\n");
            
                if (checkBoxSelected) {
                    txtOutput.append("WNA : Ya\n"); 
                } else {
                    txtOutput.append("WNA : Bukan\n");
                }  
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
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(txtOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AppBiodata a = new AppBiodata();
                a.setVisible(true);
            }
        });
    }
}
