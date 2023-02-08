package ej1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        Console c = System.console();
        String archivo;
        String texto;
        archivo = c.readLine("escribe el nombre del archivo a crear o editar: ");
        texto = c.readLine("Escribe el texto que poner en el fichero: ");
        writeTextToFile(archivo, texto);
        archivo = c.readLine("Introduce la ruta de un archivo que leer: ");
        System.out.println(leer(archivo));
    }

    public static void writeTextToFile(String fn, String txt) {
        try (FileWriter archivo = new FileWriter(fn);BufferedWriter writer = new BufferedWriter(archivo)) {
            writer.write(txt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String leer(String nombreArchivo){
        String linea = null;
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