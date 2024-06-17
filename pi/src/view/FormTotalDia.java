package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import dao.PedidoDAO;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class FormTotalDia extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JFormattedTextField txtData;
    private JFormattedTextField txtTotal; // Declarando txtTotal como campo de classe para acesso global

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormTotalDia frame = new FormTotalDia();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FormTotalDia() {
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 583, 467);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, 567, 77);
        contentPane.add(panel);

        JLabel lblNewLabel = new JLabel("HISTÓRICO DE VENDAS");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(150, 11, 250, 55);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Posição do Dia", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel_1.setBounds(10, 81, 547, 187);
        contentPane.add(panel_1);

        JLabel lblNewLabel_1 = new JLabel("Data:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_1.setBounds(127, 81, 54, 17);
        panel_1.add(lblNewLabel_1);

        try {
            MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
            dateFormatter.setPlaceholderCharacter('_');
            txtData = new JFormattedTextField(dateFormatter);
            txtData.setHorizontalAlignment(SwingConstants.CENTER);
            txtData.setFont(new Font("Tahoma", Font.BOLD, 13));
            txtData.setColumns(10);
            txtData.setBounds(180, 73, 119, 34);
            panel_1.add(txtData);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        JButton btnPesquisarVenda = new JButton("Pesquisar");
        btnPesquisarVenda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dataText = txtData.getText();
                if (!dataText.isEmpty()) {
                    LocalDate data = LocalDate.parse(dataText, formato);
                    double total_dia;
                    PedidoDAO dao_p = new PedidoDAO();
                    total_dia = dao_p.posicaoDoDia(data);
                    txtTotal.setText(String.valueOf(total_dia)); // Corrigido: acessando txtTotal corretamente
                } else {
                    // Tratar caso o campo esteja vazio
                }
            }
        });
        btnPesquisarVenda.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnPesquisarVenda.setBounds(309, 74, 119, 32);
        panel_1.add(btnPesquisarVenda);

        txtTotal = new JFormattedTextField((Object) null); // Criando txtTotal antes de usá-lo
        txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
        txtTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
        txtTotal.setColumns(10);
        txtTotal.setBounds(188, 308, 194, 41);
        contentPane.add(txtTotal);
    }
}
