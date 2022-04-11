package view;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LivedDays {
    private JTextField jtfSName;
    private JButton jbCalculate;
    private JLabel nameLabel;
    private DateTimeFormatter df = DateTimeFormatter.ofPattern("d/MM/yyyy");
    private JFormattedTextField jftfBirthDate;
    private JPanel panelLivedDays;


    public LivedDays() {
        jftfBirthDate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                    (c == KeyEvent.VK_BACK_SPACE) ||
                    (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))) {
                    JOptionPane.showMessageDialog(null, "Digite uma data válida dd/mm/aaaa");
                    e.consume();
                }
            }
        });

        jtfSName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String caracteres = "0987654321=+-_)(*&^%$#@!;:";
                if (caracteres.contains(e.getKeyChar() + "")) {
                    e.consume();
                }
            }
        });

        jbCalculate.addActionListener(actionEvent -> {
            if (!jftfBirthDate.getText().matches(
                "([0-9]{2})/([0-9]{2})/([0-9]{4})"
            )){
                JOptionPane.showMessageDialog(null, "Digite uma data válida");
            } else {
                LocalDate birthLocalDate = LocalDate.parse(jftfBirthDate.getText(), df);
                long diff = ChronoUnit.DAYS.between(birthLocalDate, LocalDate.now());

                String name = jtfSName.getText();
                name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

                String message = name + ", você já viveu " + diff + " dias!";

                JOptionPane.showMessageDialog(null, message);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dias Vividos");
        frame.setContentPane(new LivedDays().panelLivedDays);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
