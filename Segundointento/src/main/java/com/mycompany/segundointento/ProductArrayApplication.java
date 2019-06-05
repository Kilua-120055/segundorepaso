/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.segundointento;

import java.util.Arrays;

/**
 *
 * @author killua
 */
public class ProductArrayApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long[] input;
        long[] resul;
        
        input = new long[]{1,2,3,4,5};
        resul = calculateProductArrayBasic(input);
        System.out.println("Probando: " + Arrays.toString(input) + " - Resultado: " + Arrays.toString(resul));

  
    }
    public static long[] calculateProductArrayBasic(long[] input){
        if(input == null){
            return null;
        }
        
        long[] nuevacadena;
        long[] inicio;
        long[] fin;
        long[] resul = new long[input.length];
        
        for(int i=0; i<input.length ;i++)
        {
            inicio = Arrays.copyOfRange(input, 0, i);//copia un arreglo exacto como esta el otro
            fin= Arrays.copyOfRange(input, i+1, input.length);// se copio del inicio asta el finial del input.length
            nuevacadena = new long[inicio.length+fin.length];// une las dos cadenas desde donde esta en inicio.length y agrega el resto
            System.arraycopy(inicio,0, nuevacadena,0,inicio.length); //copia inicio desde su posicion 0 a la nuevacadena desde su posicion 0 y le aumentara el tam de inicio.length
            System.arraycopy(fin, 0, nuevacadena, inicio.length, fin.length); // une el resto de la cadena
            
            resul[i]=Arrays.stream(nuevacadena).reduce((a,b)-> a*b).orElse(1);//el resultado de la nuevacadena lo reduce y realiza la accion pero si no encuentra todos los datos se devuelve un 1
        }
        
        return resul;        
    }
}
