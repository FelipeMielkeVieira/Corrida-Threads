import javax.swing.*;

public class Runner extends Thread implements Runnable {

    private Integer idRunner;
    private Boolean correndo;
    private Integer espera;
    private JProgressBar progressBar;

    public void setCorrendo(Boolean correndo) {
        this.correndo = correndo;
    }

    public Runner(Integer idRunner, Integer espera, JProgressBar progressBar) {
        this.idRunner = idRunner;
        this.correndo = true;
        this.espera = espera;
        this.progressBar = progressBar;
    }

    public void processar() {
        try {
            int distancia = (int) (Math.random() * 1000 / (Controlador.controlador.distanciaMaxima / 10));
            this.progressBar.setValue(distancia + this.progressBar.getValue());
            if(this.progressBar.getValue() >= 100) {
                Controlador.controlador.terminarCorrida(this.idRunner + 1);
            }
            Thread.sleep((int) (Math.random() * espera));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (this.correndo) {
            try {
                this.processar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
