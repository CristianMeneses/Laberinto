/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static Logica.Laberinto.Matriz;

/**
 *
 * @author Estudiantes
 */
public class Jugar {
    public boolean moverse(int filas, int columnas, char a) {
         for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(Matriz[i][j] + " ");
                }
                System.out.println("");
            }
        if (true) {
            return true;
        } else {
            return false;
        }
    }
}
