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
       calcularFenotipo();
       calculaFitness();
    }
    public Individuo(Individuo ind){
       this.genotipo = ind.getGenotipo().clone();
       calcularFenotipo();
       calculaFitness();
    }

    public Individuo(int[] genotipoResultante) 
    {
        this.genotipo = genotipoResultante;
        calcularFenotipo();
        calculaFitness();
    }
    
    private void generarAlelosAleatorios(){
      Random ran = new Random();
      // recorremos el genotipo completo 
      for (int x=0; x < NUM_GENES;x++)
          this.getGenotipo()[x] = ran.nextInt(2);
    }
    private void calcularFenotipo(){
      int suma=0;
      int exp=0;
      // decodificar genotipo (binario a decimal)
      for (int x = NUM_GENES-1; x >=0 ;x--){
            
            if (this.getGenotipo()[x]==1){
              suma +=Math.pow(2, exp);
            }
            exp++;
        }
      this.fenotipo = suma;
    }
       
    private void calcularFenotipoInteger(){
       
        // recorremos el arreglo
        String aux = "";
        for (int x=0; x < NUM_GENES;x++)
            aux+=getGenotipo()[x];
         
        this.fenotipo =Integer.parseInt(aux, 2);
    }
    
    private void calculaFitness(){
     this.fitness = (4*(int)Math.pow(this.fenotipo,2))+(34*this.fenotipo);
     
    }

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }

    /**
     * @param genotipo the genotipo to set
     */
    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
        calcularFenotipoInteger();
        calculaFitness();
        
    }

    /**
     * @return the fitness
     */
    public int getFitness() {
        return fitness;
    }
    
    
}
