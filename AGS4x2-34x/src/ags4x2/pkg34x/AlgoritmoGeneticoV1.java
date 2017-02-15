/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ags4x2.pkg34x;

import datos.Herramientas;
import datos.Individuo;
import datos.Poblacion;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AlgoritmoGeneticoV1 {
    private int num_Generaciones,tam_poblacion;
    private double prob_muta;
    private Poblacion poblacion;

    public AlgoritmoGeneticoV1(int num_Generaciones, int tam_poblacion, double prob_muta) {
        this.num_Generaciones = num_Generaciones;
        this.tam_poblacion = tam_poblacion;
        this.prob_muta = prob_muta;
        // garantizar un población inicial
        this.poblacion = new Poblacion(this.tam_poblacion);
    }
    
    public void evolucionar(){
        
        // crear un proceso iterativo para simular las epocas
        for (int e=0; e < this.num_Generaciones;e++){
            // garantizar la creación de una nueva población
            Poblacion nuevaP = new Poblacion(); 
            // tenemos que iterar para construir la nueva generacion
            for(int i=0; i < this.tam_poblacion;i++){
               // proceso de seleccion de padre y madre
                Individuo padre = this.poblacion.obtenerAleatorio();
                Individuo madre = this.poblacion.obtenerAleatorio();
               // ejecutamos la cruza y obtenemos al hijo
                Individuo hijo = cruzaMascaraAleatoria(padre,madre);
               // dependiendo de una prob. muta se cambia el hijo
               if (Math.random()<=this.prob_muta){
                Herramientas.mutaGenAleatorio(hijo);
               }
// agrega el hijo a la nueva poblacion
               nuevaP.agregarHabitante(hijo);
            }
            // actualizamos la población 
            this.poblacion = new Poblacion(nuevaP);
            System.out.println(e+" - fitness de: "+this.poblacion.getMejor().getFitness());
        
        }
        
    }

    private Individuo cruzaMascaraAleatoria(Individuo padre, Individuo madre) {
         // generar la mascara aleatoria
         int mascara[] = Herramientas.generarMascaraAleatoria(padre.getGenotipo().length);
         int genotipoPadre [] = padre.getGenotipo();
         int genotipoMadre [] = madre.getGenotipo();
         int genotipoResultante []= new int[mascara.length];
         int genotipoResultante2 []= new int[mascara.length];
         
         // realizar el cruce 
         // recorrer la mascara de cruce
         for (int x=0; x < mascara.length;x++){
          // analizar el valor de la mascara
          if(mascara[x] == 1){
              genotipoResultante[x] = genotipoPadre[x];
              genotipoResultante2[x] = genotipoMadre[x];
          }else{
              genotipoResultante[x] = genotipoMadre[x];
              genotipoResultante2[x] = genotipoPadre[x];
          }
              
         }
         
         Individuo hijo1 = new Individuo(genotipoResultante);
         Individuo hijo2 = new Individuo(genotipoResultante2);
         if(hijo1.getFitness()<=hijo2.getFitness())
         {
            return hijo2;
         }
         return hijo1;
    }
}   

