package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CalculadoraDeDesconto {
    private JLabel lblDesconto;
    private JTextField jtfValorADescontar;
    private JComboBox jcbDesconto;
    private JButton calcularDesconto;
    private JPanel jpCalculadoraDeDesconto;


    public JPanel getJpCalculadoraDeDesconto() {
        return jpCalculadoraDeDesconto;
    }

    public CalculadoraDeDesconto() {

        calcularDesconto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String desconto = (String) jcbDesconto.getSelectedItem();
                String resultado;
                float valorDescontado;
                switch (desconto) {
                    case "10%":
                        valorDescontado = CalcularDesconto(Float.parseFloat(jtfValorADescontar.getText()), 0.1f);
                        resultado = "O novo valor com desconto é R$"+ String.format("%.2f",valorDescontado).replace(".",",");
                        JOptionPane.showMessageDialog(null,resultado);
                        break;
                    case "15%":
                        valorDescontado = CalcularDesconto(Float.parseFloat(jtfValorADescontar.getText()), 0.15f);
                        resultado = "O novo valor com desconto é R$"+ String.format("%.2f",valorDescontado).replace(".",",");
                        JOptionPane.showMessageDialog(null,resultado);
                        break;
                    case "20%":
                        valorDescontado = CalcularDesconto(Float.parseFloat(jtfValorADescontar.getText()), 0.2f);
                        resultado = "O novo valor com desconto é R$"+ String.format("%.2f",valorDescontado).replace(".",",");
                        JOptionPane.showMessageDialog(null,resultado);
                        break;
                    case "50%":
                        valorDescontado = CalcularDesconto(Float.parseFloat(jtfValorADescontar.getText()), 0.5f);
                        resultado = "O novo valor com desconto é R$"+ String.format("%.2f",valorDescontado).replace(".",",");
                        JOptionPane.showMessageDialog(null,resultado);
                        break;
                    case "O gerente ta maluco!":
                        valorDescontado = CalcularDesconto(Float.parseFloat(jtfValorADescontar.getText()), 0.90f);
                        resultado = "O novo valor com desconto é R$"+ String.format("%.2f",valorDescontado).replace(".",",");
                        JOptionPane.showMessageDialog(null,resultado);
                        break;
                    default:
                        jcbDesconto.setSelectedIndex(0);
                }



            }
        });

        jtfValorADescontar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String caracteres="0987654321.";
                if(!caracteres.contains(e.getKeyChar()+"")){
                    e.consume();
                }
            }
        });
    }

    public float CalcularDesconto(float valorADescontar, float desconto) {
        return valorADescontar - valorADescontar * desconto;
    }
}




