package com.projeto.View;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class AmbienteGUI extends JFrame {
    private JButton chamarButton;
    private JLabel elevadorEsquerda;
    private JLabel elevadorDireita;
    private ImageIcon abertasIcon;
    private ImageIcon fechadasIcon;
    ImageIcon botaoIcon;

    public AmbienteGUI() {
        setTitle("Grid Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Instanciando as classes para usar os ícones
        ClassLoader classLoader = getClass().getClassLoader();

        URL abertasIconUrl = classLoader.getResource("elevadores_portas_abertas.png");
        abertasIcon = new ImageIcon(abertasIconUrl);

        URL fechadasIconUrl = classLoader.getResource("elevadores_portas_fechadas.png");
        fechadasIcon = new ImageIcon(fechadasIconUrl);

        URL botaoIconUrl = classLoader.getResource("botaoChamar.png");
        botaoIcon = new ImageIcon(botaoIconUrl);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 3));

        // Iterando sobre as linhas e colunas
        for (int i = 9; i >= 1; i--) {    
                JLabel elevadorEsquerda = new JLabel(new ImageIcon(fechadasIcon.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));
                JButton chamarButton = new JButton(botaoIcon);
                chamarButton.setContentAreaFilled(false);
                chamarButton.setBorderPainted(false);
                chamarButton.setFocusPainted(false);
                chamarButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

                chamarButton.setPreferredSize(new Dimension(50, 40));

                JLabel elevadorDireita = new JLabel(new ImageIcon(fechadasIcon.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));

            panel.add(elevadorEsquerda);
            panel.add(chamarButton);
            panel.add(elevadorDireita);
        }

        add(panel);
    }

    public void run() {
        pack();
        setVisible(true);
        setSize(400, 700);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}