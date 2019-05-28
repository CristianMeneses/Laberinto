package laberinto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian
 */
public class Laberinto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int filas, columnas, aux = 0;
        int inix, iniy, finx, finy;
        int Matriz[][];
        String linea, parte1 = "", parte2 = "";

        /*  archivo es el txt
         fr es el que abre el archivo
         br es el que lee
         */
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("prueba.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura de la linea
            linea = br.readLine();

            // Primer linea: tamaño matriz
            for (int i = 0; i < linea.length(); i++) {
                if (linea.charAt(i) == ' ') {
                    aux++;
                } else if (aux == 0) {
                    parte1 += linea.charAt(i);
                } else {
                    parte2 += linea.charAt(i);
                }
            }

            // Conversión
            filas = Integer.parseInt(parte1);
            columnas = Integer.parseInt(parte2);
            // Creación de matriz
            Matriz = new int[filas][columnas];

            //Ciclo para llenar la matriz
            for (int i = 0; i < filas; i++) {
                linea = br.readLine();
                // Largo correcto
                if (linea.length() != (columnas * 2) - 1) {
                    JOptionPane.showMessageDialog(null, "Ingrese la cantidad"
                            + " correcta de columnas de la fila " + (i + 1));
                    System.exit(0);
                } else {
                    int l = 0;

                    // For para recorrer la linea horizontalmente 
                    for (int j = 0; j < (columnas * 2) - 1; j++) {
                        // Solo permite 1 0 y espacios
                        if (linea.charAt(j) != '1' && linea.charAt(j) != '0'
                                && linea.charAt(j) != ' ') {
                            JOptionPane.showMessageDialog(null, "Solo se permiten"
                                    + " \"1\" y \"0\"");
                            System.exit(0);
                        } else {
                            // Llenar matriz
                            if (linea.charAt(j) != ' ') {
                                Matriz[i][l] = linea.charAt(j) - 48;
                                l++;
                            }
                        }
                    }
                }
            } // Fin ciclo

            // Posición Inicial y Final 
            for (int m = 0; m < 2; m++) {
                linea = br.readLine();
                parte1 = "";
                parte2 = "";
                aux = 0;
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == ' ') {
                        aux++;
                    } else if (aux == 0) {
                        parte1 += linea.charAt(i);
                    } else {
                        parte2 += linea.charAt(i);
                    }
                }
                if (m == 0) {
                    // 5 va a representar al muñeco
                    Matriz[Integer.parseInt(parte1) - 1][Integer.parseInt(parte2) - 1] = 5;
                } else {
                    // 6 va a representar la meta
                    Matriz[Integer.parseInt(parte1) - 1][Integer.parseInt(parte2) - 1] = 6;
                }
            }
            
            /*
            Mostrar Matriz en pantalla
            */
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(Matriz[i][j] + " ");
                }
                System.out.println("");
            }
            /*
            Fin mostrar
            */
        } catch (Exception e) {
            System.out.println("Archivo no encontrado");
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }																									// fin condicion
    }

}
