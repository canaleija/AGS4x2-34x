/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.Random;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Individuo {
    
    //  fitness
    public static final int NUM_GENES = 12;
    private int[]genotipo;
    private int fitness;
    private int fenotipo;
    
    // agregamos el constructor de genotipo aleatorio
    public Individuo (){
       this.genotipo = new int[NUM_GENES];
       // asignar a cada alelo aleatorio ya sea 1 o 0
       generarAlelosAleatorios();
    }
    
    private void generarAlelosAleatorios(){
      Random ran = new Random();
      // recorremos el genotipo completo 
      for (int x=0; x < NUM_GENES;x++)
          this.genotipo[x] = ran.nextInt(2);
    }
    public void calcularFenotipo(){
      this.fenotipo = 0;
      // decodificar genotipo (binario a decimal)
      // TODO: CALCULAR BINARIO
    }
    
}
