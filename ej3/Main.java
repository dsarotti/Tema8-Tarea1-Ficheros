package ej3;

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
        nombreArchivo = c.readLine("escribe el nombre del archivo a editar: ");
        String texto = leer(nombreArchivo);
        String temp;
        temp = c.readLine("Escribe lineas de texto separadas por <enter>, linea vacía para terminar: ") + "\n";
        while (!temp.isBlank()) {
            texto += temp;
            writeTextToFile(nombreArchivo, texto);
            temp = c.readLine() + "\n";
        }
        System.out.println("edición finalizada, el resultado es el siguiente: \n" +leer(nombreArchivo));
    }

    public static void writeTextToFile(String fn, String txt) {
        try (FileWriter archivo = new FileWriter(fn);BufferedWriter writer = new BufferedWriter(archivo)) {
            writer.write(txt);
        } catch (IOException e) {
            e.printStackTrace();
        }
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