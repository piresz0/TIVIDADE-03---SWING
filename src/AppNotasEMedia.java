import javax.swing.*;
import java.util.ArrayList;

public class AppNotasEMedia {
    private JLabel txtAplicativodeNotas;
    private JTextField txtBarra2;
    private JTextField txtBarra1;
    private JTextField txtBarra3;
    private JTextField txtBarra4;
    private JButton adicionarButton1;
    private javax.swing.JPanel JPanel;
    private JTextArea txtArea1;
    private JButton calcularMédiaDasNotasButton5;
    private JLabel txtMediaEStatus;
    private JLabel AdicioneaNota01;
    private JLabel AdicioneaNota02;

    private final ArrayList<Double> notas = new ArrayList<>();

    public AppNotasEMedia() {

        adicionarButton1.addActionListener(e -> adicionarNota(txtBarra1));
        adicionarButton1.addActionListener(e -> adicionarNota(txtBarra2));

        calcularMédiaDasNotasButton5.addActionListener(e -> calcularMedia());
    }

    private void adicionarNota(JTextField campoNota) {
        try {
            double nota = Double.parseDouble(campoNota.getText());
            if (nota < 0 || nota > 10) {
                JOptionPane.showMessageDialog(JPanel, "Insira a nota de 0 a 10.", "Nota Invalida", JOptionPane.ERROR_MESSAGE);
            } else {
                notas.add(nota);
                txtArea1.append("Nota adicionada com sucesso!\n");
                campoNota.setText("");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(JPanel, "Insira u mnumero valido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularMedia() {
        if (notas.isEmpty()){
            JOptionPane.showMessageDialog(JPanel, "Nenhuma nota foi adicionada.", "Erro", JOptionPane.ERROR_MESSAGE);
        }


        double soma = 0;
        for (double nota : notas) {
            soma += nota;

            double media = soma / notas.size();

            String status = media >= 7 ? "Aprovado" : "Reprovado";
            txtMediaEStatus.setText(status);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AppNotasEMedia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new AppNotasEMedia().JPanel);
        frame.pack();
        frame.setVisible(true);

    }
}