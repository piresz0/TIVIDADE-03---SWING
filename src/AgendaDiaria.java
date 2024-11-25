import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendaDiaria {
    private JLabel txtAgendaDiaria;
    private JTextField textField1;
    private JSpinner txtData;
    private JButton adicioanarCompromissoButton;
    private JTable table1;
    private JButton removerCompromissoButton;
    private JSpinner txtHora;
    private DefaultTableModel tableModel;

    public AgendaDiaria() {
        JFrame frame = new JFrame("Agenda Diaria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 400);
        frame.setLayout(new BorderLayout());

        JPanel panelTop = new JPanel(new FlowLayout());
        txtAgendaDiaria = new JLabel("Compromisso: ");
        textField1 = new JTextField(15);
        txtData = new JSpinner(new SpinnerDateModel());
        txtHora = new JSpinner(new SpinnerDateModel());

        adicioanarCompromissoButton = new JButton("Adicionar Compromisso");

        panelTop.add(txtAgendaDiaria);
        panelTop.add(textField1);
        panelTop.add(new JLabel("Data:"));
        panelTop.add(txtData);
        panelTop.add(new JLabel("Hora:"));
        panelTop.add(txtHora);
        panelTop.add(adicioanarCompromissoButton);

        frame.add(panelTop, BorderLayout.NORTH);

        String[] colunas = {"Descrição", "Data", "Hora"};
        tableModel = new DefaultTableModel(null, colunas);
        table1.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table1);
        frame.add(scrollPane, BorderLayout.CENTER);

        removerCompromissoButton = new JButton("Remover Compromisso");
        frame.add(removerCompromissoButton, BorderLayout.SOUTH);

        adicioanarCompromissoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descricao = textField1.getText();
                Date data = (Date) txtData.getValue();
                Date hora = (Date) txtHora.getValue();

                if (descricao.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Insira uma descrição para o compromisso.");
                    return;
                }
                SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
                String dataFormatada = sdfData.format(data);
                String horaFormatada = sdfHora.format(hora);

                tableModel.addRow(new String[]{descricao, dataFormatada, horaFormatada});
                textField1.setText("");
            }

        });

        removerCompromissoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();

                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um compromisso para remover.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->new AgendaDiaria());
    }
}





