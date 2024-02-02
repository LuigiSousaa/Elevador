package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElevadorVisual extends JFrame {
    private JButton chamarButton;
    private Elevador elevadorEsquerdo;
    private Elevador elevadorDireito;

    public ElevadorVisual() {
        // Configuração básica da janela
        super("Elevadores");

        // Inicialização dos elevadores
        elevadorEsquerdo = new Elevador("Esquerdo");
        elevadorDireito = new Elevador("Direito");

        // Configuração do botão "Chamar"
        chamarButton = new JButton("Chamar");
        chamarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para chamar o elevador
                // Você pode implementar sua lógica aqui
            }
        });

        // Configuração do layout

        
        setLayout(new BorderLayout());
        add(chamarButton, BorderLayout.CENTER);

        // Adiciona os elevadores à GUI
        add(elevadorEsquerdo.getElevadorPanel(), BorderLayout.WEST);
        add(elevadorDireito.getElevadorPanel(), BorderLayout.EAST);

        // Configurações adicionais da janela
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ElevadorVisual();
            }
        });
    }
}

class Elevador {
    private String nome;
    private JPanel elevadorPanel;
    private JLabel andarLabel;

    public Elevador(String nome) {
        this.nome = nome;
        elevadorPanel = new JPanel();
        andarLabel = new JLabel("Térreo");

        // Configuração do layout do elevadorPanel
        elevadorPanel.setLayout(new BorderLayout());
        elevadorPanel.add(new JLabel(nome), BorderLayout.NORTH);
        elevadorPanel.add(andarLabel, BorderLayout.CENTER);
    }

    public JPanel getElevadorPanel() {
        return elevadorPanel;
    }

    public void setAndar(int andar) {
        andarLabel.setText("Andar " + andar);
    }
}
