import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VirtualPetApp extends JFrame {
    VirtualPet bichinhoVirtual;
    JLabel labelFome;
    JLabel labelFelicidade;
    JTextField campoNome;

    public VirtualPetApp() {
        setTitle("Aplicativo Bichinho Virtual");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        campoNome = new JTextField(10);
        JButton botaoCriar = new JButton("Criar Bichinho");
        labelFome = new JLabel("Fome: N/A");
        labelFelicidade = new JLabel("Felicidade: N/A");

        JButton botaoAlimentar = new JButton("Alimentar");
        JButton botaoBrincar = new JButton("Brincar");
        JButton botaoAcariciar = new JButton("Acariciar");
        JButton botaoMorrer = new JButton("Matar Bichinho");

        botaoCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                bichinhoVirtual = new VirtualPet(nome);
                atualizarLabels();
            }
        });

        botaoAlimentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bichinhoVirtual != null) {
                    bichinhoVirtual.alimentar();
                    atualizarLabels();
                }
            }
        });

        botaoBrincar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bichinhoVirtual != null) {
                    bichinhoVirtual.brincar();
                    atualizarLabels();
                }
            }
        });

        botaoAcariciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bichinhoVirtual != null) {
                    bichinhoVirtual.acariciar();
                    atualizarLabels();
                }
            }
        });

        botaoMorrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bichinhoVirtual = null;
                labelFome.setText("Fome: N/A");
                labelFelicidade.setText("Felicidade: N/A");
            }
        });

        add(new JLabel("Nome do Bichinho:"));
        add(campoNome);
        add(botaoCriar);
        add(labelFome);
        add(labelFelicidade);
        add(botaoAlimentar);
        add(botaoBrincar);
        add(botaoAcariciar);
        add(botaoMorrer);
    }

    private void atualizarLabels() {
        if (bichinhoVirtual != null) {
            labelFome.setText("Fome: " + bichinhoVirtual.getFome());
            labelFelicidade.setText("Felicidade: " + bichinhoVirtual.getFelicidade());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VirtualPetApp app = new VirtualPetApp();
            app.setVisible(true);
        });
    }
}