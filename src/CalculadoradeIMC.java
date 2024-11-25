import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoradeIMC {
    private javax.swing.JPanel JPanel;
    private JLabel txtCalculadoradeIMC;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel txtDigiteoPeso;
    private JLabel txtDigiteaAltura;
    private JButton calcularIMCButton;
    private JLabel txtResultado;

    public CalculadoradeIMC() {
        calcularIMCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double peso = Double.parseDouble(textField2.getText());
                    double altura = Double.parseDouble(textField1.getText());

                    if (peso <=0 || altura <= 0) {
                        JOptionPane.showMessageDialog(JPanel,"Peso e altura devem ser maiores que zero", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (altura >3) {
                        altura = altura / 100;
                    }

                    double imc = peso / (altura * altura);

                    String categoria;
                    if (imc < 18.5) {
                        categoria = "Magreza";
                    } else if (imc < 25.0) {
                        categoria = "Normal";
                    } else if (imc < 35.0) {
                        categoria = "Sobrepeso";
                    } else {
                        categoria = "Obeso";
                    }

                    txtResultado.setText(String.format("IMC: %.2f - %s", imc, categoria));
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(JPanel, "Insira os valores numericos ", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CalculadoradeIMC");
        frame.setContentPane(new CalculadoradeIMC().JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
