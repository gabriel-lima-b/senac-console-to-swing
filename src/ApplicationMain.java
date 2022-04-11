import view.CalculadoraDeDesconto;
import view.IMC;

import javax.swing.*;

public class ApplicationMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Desconto");
        frame.setContentPane(new CalculadoraDeDesconto().getJpCalculadoraDeDesconto());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
