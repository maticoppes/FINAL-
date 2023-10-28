/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tallerpoo;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManejoArchivos {
 public static void crearArchivo(String nombreArchivo)   {
     File archivo= new File(nombreArchivo);////te crea el objeto de tipo archivo
     
     try {
         PrintWriter salida= new PrintWriter(archivo);
         salida.close();//hay que cerrar porq sino entra en bucle
         System.out.println("Se creo el archivo");//si te sale este cartel es porque se creo el archivo
     } catch (FileNotFoundException ex) {
      ex.printStackTrace(System.out)   ;
     }
  }
 public static void escribirArchivo(String nombreArchivo, String contenido)   {
     File archivo= new File(nombreArchivo);////te crea el objeto de tipo archivo
     
     try {
         PrintWriter salida= new PrintWriter(new FileWriter(archivo, true ));// tiene que estar la clase fileWriter para que escriba contenido y no sobre escriba, true es para que siga escribiendo
         salida.println(contenido);//lo que pasa por parametro se mete en el archivo
         salida.close();//hay que cerrar porq sino entra en bucle
         System.out.println("Se escribio el archivo");//si te sale este cartel es porque se creo el archivo
     } catch (FileNotFoundException ex) {
      ex.printStackTrace(System.out)   ;
     } catch (IOException ex) {
      ex.printStackTrace(System.out);   
     }
  }
 public static void leerArchivo(String nombreArchivo)   {// solo mandar el nombre del archivo
     File archivo= new File(nombreArchivo);////te crea el objeto de tipo archivo
     
     try {
         BufferedReader entrada= new BufferedReader(new FileReader(archivo));// para leer aplica la clase BufferedReader
         String lectura= entrada.readLine();//lee solo la primera linea de entrada(el archivo)
         while (lectura!=null){
             System.out.println(lectura);
             lectura=entrada.readLine();
             }
         entrada.close();
     } catch (FileNotFoundException ex) {
      ex.printStackTrace(System.out)   ;
     } catch (IOException ex) {
      ex.printStackTrace(System.out);   
     }
  }
}
