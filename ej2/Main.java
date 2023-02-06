package ej2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        Console c = System.console();
        String nombreArchivo;
        nombreArchivo = c.readLine("escribe el nombre del archivo a crear o editar: ");
        String texto = leer(nombreArchivo);
        String temp;
        do {
            temp = c.readLine("Escribe lineas de texto separadas por <enter>, linea vacía para terminar: ")+"\n";
            texto += temp;
            try (FileWriter archivo = new FileWriter(nombreArchivo);
                    BufferedWriter writer = new BufferedWriter(archivo)) {
                writer.write(texto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!temp.isBlank());

        // leer
        // nombreArchivo = c.readLine("Introduce la ruta de un archivo que leer: ");
        System.out.println(leer(nombreArchivo));
    }

    public static String leer(String nombreArchivo) {
        String linea = "";
        String texto = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            do {
                linea = reader.readLine();
                if (linea != null)
                    texto += linea + "\n";
            } while (linea != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return texto;
    }
}