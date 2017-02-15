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
public class Herramientas {
    
    public static int[] generarMascaraAleatoria (int dim){
       Random ran = new Random();
       int mascara[] = new int[dim];
       for (int x=0; x<dim;x++){
        mascara[x]= ran.nextInt(2);
       }
       return mascara;
    }
    public static void mutaGenAleatorio(Individuo ind){
      // caculamos el gen aleatorio 
      Random ran = new Random();
      int pos = ran.nextInt(ind.getGenotipo().length);
      if (ind.getGenotipo()[pos]==1){
          ind.getGenotipo()[pos]=0;
         
      }else{
         ind.getGenotipo()[pos]=1;
      }
      ind.ajustarDespuesDeMuta();
    
    }
}
