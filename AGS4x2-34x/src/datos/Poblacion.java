/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Poblacion {
    
    private Individuo mejor;
    private LinkedList<Individuo> habitantes;
    private int num_habitantes;
    
    public Poblacion(int num_habitantes){
        this.num_habitantes = num_habitantes;
        generaPoblacionIncialAleatoria(num_habitantes);
    }

    private void generaPoblacionIncialAleatoria(int num_habitantes) {
      this.habitantes = new LinkedList<>();
      for (int x=0; x < num_habitantes;x++)
          this.getHabitantes().add(new Individuo());
            
    }

    /**
     * @return the mejor
     */
    public Individuo getMejor() {
        this.mejor = buscaAlMejor();
        return mejor;
    }

    /**
     * @return the habitantes
     */
    public LinkedList<Individuo> getHabitantes() {
        return habitantes;
    }

    /**
     * @return the num_habitantes
     */
    public int getNum_habitantes() {
        return num_habitantes;
    }

    private Individuo buscaAlMejor() {
       // garantizar que regresamos la referencia del mejor
       Individuo aux = this.habitantes.getFirst();
       for(int x=1; x<num_habitantes; x++){
           if(this.habitantes.get(x).getFitness()>aux.getFitness()){
               aux=this.habitantes.get(x);
            }
       }
       return aux;    
    }
    
}
