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
        String archivo;
        archivo = c.readLine("escribe el nombre del archivo a editar: ");
        appendTextToFile(archivo, c.readLine("Escribe el texto que añadir al fichero: "));
        System.out.println("Resultado: " + leer(archivo));
    }

    public static void writeTextToFile(String fn, String txt) {
        try (FileWriter archivo = new FileWriter(fn);BufferedWriter writer = new BufferedWriter(archivo)) {
            writer.write(txt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendTextToFile(String fn, String txt){
        String prev = leer(fn);
        writeTextToFile(fn, (prev + txt));
    }

    public static String leer(String nombreArchivo){
        String linea = null;
        String texto = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            do {
                linea = reader.readLine();
                if (linea != null)
                    texto += "\n" + linea;
            } while (linea != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return texto;
    }
}