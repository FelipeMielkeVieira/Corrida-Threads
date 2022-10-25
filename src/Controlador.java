import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador extends JFrame implements Runnable {
    private JPanel painelPrincipal;
    private JSlider numCorredores;
    private JSlider tempoEspera;
    private JSlider distancia;
    private JButton GOButton;
    private JProgressBar corredor1;
    private JProgressBar corredor2;
    private JProgressBar corredor3;
    private JProgressBar corredor4;
    private JProgressBar corredor5;
    private JProgressBar corredor6;
    private JProgressBar corredor7;
    private JProgressBar corredor8;
    private JProgressBar corredor9;
    private JProgressBar corredor10;
    private JProgressBar corredor11;
    private JProgressBar corredor12;
    private JProgressBar corredor13;
    private JProgressBar corredor14;
    private JProgressBar corredor15;
    private JLabel textoCorredor1;
    private JLabel textoCorredor2;
    private JLabel textoCorredor3;
    private JLabel textoCorredor4;
    private JLabel textoCorredor6;
    private JLabel textoCorredor5;
    private JLabel textoCorredor7;
    private JLabel textoCorredor8;
    private JLabel textoCorredor9;
    private JLabel textoCorredor10;
    private JLabel textoCorredor11;
    private JLabel textoCorredor12;
    private JLabel textoCorredor13;
    private JLabel textoCorredor14;
    private JLabel textoCorredor15;
    public Integer distanciaMaxima;
    private ArrayList<Runner> listaRunners = new ArrayList<>();
    public static Controlador controlador;

    public Controlador() {
        criarComponentes();
        GOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comecarCorrida();
            }
        });
    }

    public void comecarCorrida() {
        this.distanciaMaxima = distancia.getValue();
        resetarRunners();
        resetarProgresso();
        atualizarComponentesRunner();
        criarRunners();
    }

    public void criarRunners() {
        for (int i = 0; i < numCorredores.getValue(); i++) {
            Runner runner = new Runner(i, tempoEspera.getValue(), retornaBarraProgresso(i));
            listaRunners.add(runner);
            runner.start();
        }
    }

    public JProgressBar retornaBarraProgresso(Integer idRunner) {
        return switch (idRunner) {
            case 0 -> corredor1;
            case 1 -> corredor2;
            case 2 -> corredor3;
            case 3 -> corredor4;
            case 4 -> corredor5;
            case 5 -> corredor6;
            case 6 -> corredor7;
            case 7 -> corredor8;
            case 8 -> corredor9;
            case 9 -> corredor10;
            case 10 -> corredor11;
            case 11 -> corredor12;
            case 12 -> corredor13;
            case 13 -> corredor14;
            case 14 -> corredor15;
            default -> null;
        };
    }

    public void resetarProgresso() {
        corredor1.setValue(0);
        corredor2.setValue(0);
        corredor3.setValue(0);
        corredor4.setValue(0);
        corredor5.setValue(0);
        corredor6.setValue(0);
        corredor7.setValue(0);
        corredor8.setValue(0);
        corredor9.setValue(0);
        corredor10.setValue(0);
        corredor11.setValue(0);
        corredor12.setValue(0);
        corredor13.setValue(0);
        corredor14.setValue(0);
        corredor15.setValue(0);
    }

    public void atualizarComponentesRunner() {
        int numero = this.numCorredores.getValue();
        if (numero < 15) {
            corredor15.setVisible(false);
            textoCorredor15.setVisible(false);
        }
        if (numero < 14) {
            corredor14.setVisible(false);
            textoCorredor14.setVisible(false);
        }
        if (numero < 13) {
            corredor13.setVisible(false);
            textoCorredor13.setVisible(false);
        }
        if (numero < 12) {
            corredor12.setVisible(false);
            textoCorredor12.setVisible(false);
        }
        if (numero < 11) {
            corredor11.setVisible(false);
            textoCorredor11.setVisible(false);
        }
        if (numero < 10) {
            corredor10.setVisible(false);
            textoCorredor10.setVisible(false);
        }
        if (numero < 9) {
            corredor9.setVisible(false);
            textoCorredor9.setVisible(false);
        }
        if (numero < 8) {
            corredor8.setVisible(false);
            textoCorredor8.setVisible(false);
        }
        if (numero < 7) {
            corredor7.setVisible(false);
            textoCorredor7.setVisible(false);
        }
        if (numero < 6) {
            corredor6.setVisible(false);
            textoCorredor6.setVisible(false);
        }
        if (numero < 5) {
            corredor5.setVisible(false);
            textoCorredor5.setVisible(false);
        }
        if (numero < 4) {
            corredor4.setVisible(false);
            textoCorredor4.setVisible(false);
        }
        if (numero < 3) {
            corredor3.setVisible(false);
            textoCorredor3.setVisible(false);
        }
    }

    public void resetarRunners() {
        corredor3.setVisible(true);
        textoCorredor3.setVisible(true);
        corredor4.setVisible(true);
        textoCorredor4.setVisible(true);
        corredor5.setVisible(true);
        textoCorredor5.setVisible(true);
        corredor6.setVisible(true);
        textoCorredor6.setVisible(true);
        corredor7.setVisible(true);
        textoCorredor7.setVisible(true);
        corredor8.setVisible(true);
        textoCorredor8.setVisible(true);
        corredor9.setVisible(true);
        textoCorredor9.setVisible(true);
        corredor10.setVisible(true);
        textoCorredor10.setVisible(true);
        corredor11.setVisible(true);
        textoCorredor11.setVisible(true);
        corredor12.setVisible(true);
        textoCorredor12.setVisible(true);
        corredor13.setVisible(true);
        textoCorredor13.setVisible(true);
        corredor14.setVisible(true);
        textoCorredor14.setVisible(true);
        corredor15.setVisible(true);
        textoCorredor15.setVisible(true);
    }

    public void terminarCorrida(Integer idRunner) {
        pararRunners();
        JOptionPane.showMessageDialog(null, "Corredor " + idRunner + " ganhou!");
    }

    public void pararRunners() {
        for (Runner runner : listaRunners) {
            runner.setCorrendo(false);
        }
    }

    public void criarComponentes() {
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    @Override
    public void run() {
        if (!isVisible()) {
            setVisible(true);
        } else {
            System.out.println("Já está visível!");
        }
    }

    public static void main(String[] args) {
        controlador = new Controlador();
        controlador.run();
    }
}
