import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TrojuhelnikGuiForm extends JFrame {
    private JTextField textField3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton kopirujBtn;
    private JButton lzeSestrojitButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel mainPanel;
    private JMenu menuFile;
    private JMenuBar menuBar;
    private JMenu menuAction;
    private JMenuItem chooseFile;
    private JMenuItem miOpenFile;
    private JMenuItem miNacti;
    private JMenuItem miUloz;

    private JMenuItem miKopiruj;

    private JMenuItem miLzeSestrojit;
    private JFileChooser fileChooserOpen = new JFileChooser(".");

    public TrojuhelnikGuiForm() {
        initComponents();

        kopirujBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField2.setText(textField1.getText());
                textField3.setText(textField1.getText());
            }
        });
        lzeSestrojitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a = Integer.parseInt(textField1.getText());
                    int b = Integer.parseInt(textField2.getText());
                    int c = Integer.parseInt(textField3.getText());

                    if (a + b > c && a + c > b && b + c > a) {
                        JOptionPane.showMessageDialog(null, "Trojúhelník lze sestrojit.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Trojúhelník nelze sestrojit.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Chyba: Vstupní hodnoty musí být celá čísla.");
                }
            }
        });

    }

    public void initComponents() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuFile = new JMenu("Soubor");

        menuBar.add(menuFile);

        menuAction = new JMenu("Akce");
        menuBar.add(menuAction);


        miNacti = new JMenuItem("Načti ze souboru...");
        menuFile.add(miNacti);
        miNacti.addActionListener(e -> nacti());

        miUloz = new JMenuItem("Ulož do souboru...");
        menuFile.add(miUloz);
        miUloz.addActionListener(e -> uloz());

        miKopiruj = new JMenuItem("Kopíruj A do B i C");
        menuAction.add(miKopiruj);
        miKopiruj.addActionListener(e -> kopiruj());

        miLzeSestrojit = new JMenuItem("Lze sestroji trojúhelník?");
        menuAction.add(miLzeSestrojit);
        miLzeSestrojit.addActionListener(e -> lzeSestrojit());

    }

    public void kopiruj(){
        textField2.setText(textField1.getText());
        textField3.setText(textField1.getText());
    }
    public void lzeSestrojit(){
            try {
                int a = Integer.parseInt(textField1.getText());
                int b = Integer.parseInt(textField2.getText());
                int c = Integer.parseInt(textField3.getText());

                if (a + b > c && a + c > b && b + c > a) {
                    JOptionPane.showMessageDialog(null, "Trojúhelník lze sestrojit.");
                } else {
                    JOptionPane.showMessageDialog(null, "Trojúhelník nelze sestrojit.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Chyba: Vstupní hodnoty musí být celá čísla.");}
            }

    public void uloz(){

        int vysledek = fileChooserOpen.showOpenDialog(this);
        if (vysledek == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooserOpen.getSelectedFile();
            try {
                Writer writer = new FileWriter(selectedFile);
                writer.append(textField3 + "\n");
                writer.append(textField1 + "\n");
                writer.append(textField2 + "\n");
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
    }

    public void nacti() {
        int vysledek = fileChooserOpen.showOpenDialog(this);
        if (vysledek == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooserOpen.getSelectedFile();
            try {
                Reader reader = new FileReader(selectedFile);
                reader.read();

            } catch (IOException e) {
                throw new RuntimeException();
            }

        }
    }


    public static void main(String[] args) {
        TrojuhelnikGuiForm frame = new TrojuhelnikGuiForm();
        frame.pack();
        frame.setVisible(true);
    }


}



