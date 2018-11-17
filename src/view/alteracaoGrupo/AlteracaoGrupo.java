package view.alteracaoGrupo;
import javax.swing.*;
public class AlteracaoGrupo extends JFrame {

//  Panel Principal
    private JPanel mainFrame;
//  ComboBox
    private JComboBox cbAlteracao;
    private JComboBox cbGrupo;
    private JComboBox cbSala;
//  Button
    private JButton btnConfirmar;
    private JButton btnCancelar;

    public AlteracaoGrupo() {
        setResizable(false);
        setSize(400, 200);
        setContentPane(mainFrame);
        setLocationRelativeTo(null);

        mainFrame.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
    }

    public JComboBox getCbAlteracao() {
        return cbAlteracao;
    }
    public JComboBox getCbGrupo() {
        return cbGrupo;
    }
    public JComboBox getCbSala() {
        return cbSala;
    }
    public JButton getBtnConfirmar() {
        return btnConfirmar;
    }
    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
