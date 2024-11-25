import javax.swing.*;
import java.awt.event.ActionListener;

public class Calculadora {
    private javax.swing.JPanel JPanel;
    private JTextField txtBarraDigitavel;
    private JLabel txtCalculadora;
    private JButton Button7;
    private JButton Button4;
    private JButton Button1;
    private JButton ButtonC;
    private JButton Button9;
    private JButton Button6;
    private JButton Button3;
    private JButton buttonSubtracao;
    private JButton Button8;
    private JButton Button5;
    private JButton Button2;
    private JButton Button0;
    private JButton buttonDivisao;
    private JButton buttonMultiplicacao;
    private JButton buttonAdicao;
    private JButton buttonIgual;

    private double num1, num2, resultado;
    private String operacao;

    public Calculadora() {
        txtBarraDigitavel.setEditable(false);
        txtBarraDigitavel.setHorizontalAlignment(JTextField.RIGHT);

        ActionListener listenerNumerico = e -> {
            JButton botao = (JButton) e.getSource();
            txtBarraDigitavel.setText(txtBarraDigitavel.getText() + botao.getText());
        };

        Button0.addActionListener(listenerNumerico);
        Button1.addActionListener(listenerNumerico);
        Button2.addActionListener(listenerNumerico);
        Button3.addActionListener(listenerNumerico);
        Button4.addActionListener(listenerNumerico);
        Button5.addActionListener(listenerNumerico);
        Button6.addActionListener(listenerNumerico);
        Button7.addActionListener(listenerNumerico);
        Button8.addActionListener(listenerNumerico);
        Button9.addActionListener(listenerNumerico);

        ActionListener listenerOperacao = e -> {
            JButton botao = (JButton) e.getSource();
            operacao = botao.getText();
            num1 = Double.parseDouble(txtBarraDigitavel.getText());
            txtBarraDigitavel.setText("");
        };

        buttonAdicao.addActionListener(e -> {
            JButton botao = (JButton) e.getSource();
            operacao = botao.getText();
            num1 = Double.parseDouble(txtBarraDigitavel.getText());
            txtBarraDigitavel.setText(txtBarraDigitavel.getText() + " " + operacao + " ");
        });
        buttonSubtracao.addActionListener(e -> {
            JButton botao = (JButton) e.getSource();
            operacao = botao.getText();
            num1 = Double.parseDouble(txtBarraDigitavel.getText());
            txtBarraDigitavel.setText(txtBarraDigitavel.getText() + " " + operacao + " ");
        });
        buttonDivisao.addActionListener(e -> {
            JButton botao = (JButton) e.getSource();
            operacao = botao.getText();
            num1 = Double.parseDouble(txtBarraDigitavel.getText());
            txtBarraDigitavel.setText(txtBarraDigitavel.getText() + " " + operacao + " ");
        });
        buttonMultiplicacao.addActionListener(e -> {
            JButton botao = (JButton) e.getSource();
            operacao = botao.getText();
            num1 = Double.parseDouble(txtBarraDigitavel.getText());
            txtBarraDigitavel.setText(txtBarraDigitavel.getText() + " " + operacao + " ");
        });

        buttonIgual.addActionListener(e -> {
            try {
                String[] partes = txtBarraDigitavel.getText().split(" ");
                if (partes.length == 3) {
                    double num1 = Double.parseDouble(partes[0]);
                    String operacao = partes[1];
                    double num2 = Double.parseDouble(partes[2]);

                    double resultado = 0;

                    switch (operacao) {
                        case "+" -> resultado = num1 + num2;
                        case "-" -> resultado = num1 - num2;
                        case "*" -> resultado = num1 * num2;
                        case "/" -> {
                            if (num2 != 0) {
                                resultado = num1 / num2;
                            } else {
                                txtBarraDigitavel.setText("Erro: Divisão por zero");
                                return;
                            }
                        }
                        default -> {
                            txtBarraDigitavel.setText("Erro: Operador Inválido");
                            return;
                        }
                    }

                    if (resultado == (int) resultado) {
                        txtBarraDigitavel.setText(String.valueOf((int) resultado));
                    } else {
                        txtBarraDigitavel.setText(String.valueOf(resultado));
                    }
                } else {
                    txtBarraDigitavel.setText("Erro: Expressão Invalida");
                }
            } catch (NumberFormatException ex) {
                txtBarraDigitavel.setText("Erro: Numero Invalido");
            }
        });

        ButtonC.addActionListener(e -> txtBarraDigitavel.setText(""));

        }
    public static void main (String[]args){
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new Calculadora().JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
