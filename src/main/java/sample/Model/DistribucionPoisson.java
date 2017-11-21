package sample.Model;

import main.java.sample.Model.Gamma;

import java.time.Duration;
import java.util.Random;

public class DistribucionPoisson implements Distribucion{
    private double lambda;

    public DistribucionPoisson(double lambda) {
        this.lambda = lambda;
    }

    public Duration calcular() {
        Random generador = new Random();                                        //Inicializamos el generador de números aleatorios
        double U = generador.nextDouble();
        int i = 0;
        double F = Math.exp(-lambda);
        while (U >= F){
            F += Math.exp(-lambda) * (Math.pow(lambda, (i/ Gamma.gamma(i+1))));
            i += 1;
        }
        long quantil = i;  //Generamos el quantil a partir de la probabilidad generada
        return Duration.ofMinutes(quantil);
    }

}
