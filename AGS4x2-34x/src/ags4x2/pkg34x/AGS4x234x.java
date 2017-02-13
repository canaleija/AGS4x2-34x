/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ags4x2.pkg34x;

import datos.Individuo;
import datos.Poblacion;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AGS4x234x {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlgoritmoGeneticoV1 ag = new AlgoritmoGeneticoV1(23, 23, 0.4);
        ag.evolucionar();
    }
    
}
