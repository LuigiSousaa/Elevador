package com.projeto.View;

import java.net.URL;
import javax.swing.*;

import com.projeto.Model.Elevador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AmbienteGUI extends JFrame {
    private Elevador elevador1;
    private Elevador elevador2;
    private JLabel[] elevadores; // Array para armazenar os JLabels dos elevadores
    private int[] andarElevador; // Array para armazenar o andar atual de cada elevador

    public AmbienteGUI() {
        setTitle("Grid Layout Exemplo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Inicializa os arrays
        elevadores = new JLabel[2];
        andarElevador = new int[2];

        // Inicializa as instâncias de Elevador
        elevador1 = new Elevador();
        elevador2 = new Elevador();

        // Criando o layout com 3 colunas e 9 linhas
        setLayout(new GridLayout(9, 3, 10, 10));

        ClassLoader classLoader = getClass().getClassLoader();

        URL abertasIconUrl = classLoader.getResource("elevadores_portas_abertas.png");
        ImageIcon abertasIcon = new ImageIcon(abertasIconUrl);

        URL fechadasIconUrl = classLoader.getResource("elevadores_portas_fechadas.png");
        ImageIcon fechadasIcon = new ImageIcon(fechadasIconUrl);

        URL botaoIconUrl = classLoader.getResource("botaoChamar.png");
        ImageIcon botaoIcon = new ImageIcon(botaoIconUrl);

        // Tamanho desejado para as imagens de elevadores fechados
        int labelWidth = 80;
        int labelHeight = 60;

        // Adicionando componentes ao layout
        for (int i = 1; i <= 27; i++) {
            if (i % 3 == 1 || i % 3 == 0) { // Colunas 1 e 3
                JLabel label = new JLabel(fechadasIcon);
                label.setIcon(new ImageIcon(
                        fechadasIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH)));
                elevadores[i % 3] = label; // Armazena a referência do JLabel do elevador
                andarElevador[i % 3] = 1; // Inicializa o andar do elevador
                add(label);
            } else if (i % 3 == 2) { // Coluna 2
                JButton button = new JButton(botaoIcon);
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);
                button.setFocusPainted(false);
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button.setIcon(new ImageIcon(botaoIcon.getImage().getScaledInstance(50, 35, Image.SCALE_SMOOTH)));
                button.addActionListener(new BotaoListener(i % 3)); // Adiciona um ouvinte de eventos para o botão
                add(button);
            }
        }

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Classe interna para lidar com eventos de botão
    private class BotaoListener implements ActionListener {
        private int elevadorIndex;

        public BotaoListener(int elevadorIndex) {
            this.elevadorIndex = elevadorIndex;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int andarDestino = (elevadorIndex == 1) ? 1 : 3; // Determina o andar de destino com base no botão clicado

            // Lógica para movimentar o elevador até o andar de destino
            movimentarElevador(andarDestino);
        }

        private void movimentarElevador(int andarDestino) {
            // Verifica se o elevador está parado
            if (elevadorIndex >= 1 && elevadorIndex <= elevadores.length) {
                // Verifica se o elevador está parado
                if (elevador1.isParado()) {
                    // Atualiza o andar atual do elevador
                    elevador1.setAndarAtual(andarDestino);

                    // Abre as portas do elevador
                    elevador1.abrirPortas();

                    // Atualiza a interface gráfica, substituindo a imagem do andar atual
                    ImageIcon elevadorAbertoIcon = new ImageIcon("elevadores_portas_abertas.png");
                    elevadores[elevadorIndex - 1].setIcon(new ImageIcon(elevadorAbertoIcon.getImage()
                            .getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
                } else {
                    System.out.println("O elevador está em movimento. Não é possível abrir as portas.");
                }
            } else {
                System.out.println("Índice de elevador inválido: " + elevadorIndex);
            }
        }
    }

    public void run() {
        pack();
        setVisible(true);
        setSize(400, 700);
        setResizable(false);
        setLocationRelativeTo(null);
    }

}
