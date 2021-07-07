package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;


public class Archivo {

    public static Vector<String> leerArchivoTXT(String nombreArchivo) {
        Vector<String> texto = new Vector<>();

        try {
            File archivo = new File("./MODA-Store/" + nombreArchivo);
            Scanner scan = new Scanner(archivo);

            while (scan.hasNextLine()) {
                texto.add(scan.nextLine());
            }

            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error, no se encontro el archivo con ese nombre");
        }

        return texto;
    }
}

