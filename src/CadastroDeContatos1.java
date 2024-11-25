import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDeContatos1 {
    private javax.swing.JPanel JPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel txtAddNome;
    private JLabel txtAddcll;
    private JLabel txtAddEmail;
    private JButton buttonAdicionarContato;
    private JList<String> list1;
    private JButton buttonrRemovercontato;
    private DefaultListModel<String> listaModel;

    public CadastroDeContatos1() {

        listaModel = new DefaultListModel<>();
        list1.setModel(listaModel);

        buttonAdicionarContato.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textField1.getText().trim();
                String tel = textField2.getText().trim();
                String email = textField3.getText().trim();

                if (nome.isEmpty() || tel.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    String contato = nome;
                    listaModel.addElement(contato);

                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                }
            }
        });

        buttonrRemovercontato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list1.getSelectedIndex();
                if (selectedIndex >= -1) {
                    listaModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um contato para remover!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new CadastroDeContatos1().JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}