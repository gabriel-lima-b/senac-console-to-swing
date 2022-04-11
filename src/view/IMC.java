package view;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class IMC {
    private JTextField jtfSNome;
    private JTextField jtfFPeso;
    private JTextField jtfFAltura;
    private JButton jbCalcular;
    private JButton jbLimpar;
    private JPanel panelMain;

    public IMC() {

        jbLimpar.addActionListener(e -> {
            jtfSNome.setText("");
            jtfFAltura.setText("");
            jtfFPeso.setText("");
            jtfSNome.requestFocus();
        });

        jbCalcular.addActionListener(e -> {
            String nome, imcResultado, resultado;
            float peso, altura, imc;

            nome = jtfSNome.getText();
            nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();

            String alturaString = jtfFAltura.getText();
            if(alturaString.contains(",")){
                alturaString = alturaString.replace(",",".");
            }

            peso = Float.parseFloat(jtfFPeso.getText());
            altura = Float.parseFloat(alturaString);

            imc = peso / (altura * altura);

            if(imc < 18.5){
                imcResultado = "magreza";
            }else if (imc <= 24.9){
                imcResultado = "peso ideal";
            }else if (imc <= 30){
                imcResultado = "sobrepeso";
            }else{
                imcResultado = "obesidade";
            }

            resultado = nome + ", seu IMC é de: "+ String.format("%.2f",imc).replace(".",",") + " e você está com: " + imcResultado;
            JOptionPane.showMessageDialog(null,resultado);
        });

        jtfSNome.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if(jtfSNome.getText().isBlank()){
                    JOptionPane.showMessageDialog(null,"Um nome deve ser informado.");
                    jtfSNome.requestFocus();
                }
            }
        });
        jtfSNome.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String caracteres="0987654321=+-_)(*&^%$#@!;:";
                if(caracteres.contains(e.getKeyChar()+"")){
                    e.consume();
                }
            }
        });
        jbCalcular.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    jbCalcular.doClick();
                }
            }
        });
        jbLimpar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    jbLimpar.doClick();
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("IMC");
        frame.setContentPane(new IMC().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
