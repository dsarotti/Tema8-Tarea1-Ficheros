import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Console c = System.console();
        String nombreArchivo;
        String temp;
        int numeroLineas;
        List<String> lineas = new LinkedList<>();

        // Ejercicio 1: writeTextToFile(String fn, String txt)
        System.out.println("# Ejercicio 1: writeTextToFile(String fn, String txt)");
        nombreArchivo = c.readLine("Escribe el nombre del archivo a escribir: ");
        temp = c.readLine("Escribe la frase a guardar en el fichero: ");
        writeTextToFile(nombreArchivo, temp);
        System.out.println("edición finalizada, el resultado es el siguiente: ");
        for (String linea : readLinesFromFile(nombreArchivo)) {
            System.out.println(linea);
        }
        System.out.println("----------\nFin del ejercicio 1\n----------");

        // Ejercicio2: appendTextToFile(String fn, String txt)
        System.out.println("\n# Ejercicio2: appendTextToFile(String fn, String txt)");
        nombreArchivo = c.readLine("Escribe el nombre del archivo en el que añadir una frase: ");
        temp = c.readLine("Escribe la frase que añadir al archivo: ");
        appendTextToFile(nombreArchivo, temp);
        System.out.println("edición finalizada, el resultado es el siguiente: ");
        for (String linea : readLinesFromFile(nombreArchivo)) {
            System.out.println(linea);
        }
        System.out.println("----------\nFin del ejercicio 2\n----------");

        // Ejercicio 3: appendLinesToFile(String fn, List<String> lines)
        System.out.println("\n# Ejercicio 3: appendLinesToFile(String fn, List<String> lines)");
        nombreArchivo = c.readLine("Escribe el nombre del archivo a editar: ");
        numeroLineas = Integer.parseInt(c.readLine("Indica el número de lineas a añadir: "));
        for (int i = 0; i < numeroLineas; i++)
            lineas.add(c.readLine("Frase " + (i + 1) + ": "));
        appendLinesToFile(nombreArchivo, lineas);
        System.out.println("edición finalizada, el resultado es el siguiente: ");
        for (String linea : readLinesFromFile(nombreArchivo)) {
            System.out.println(linea);
        }
        System.out.println("----------\nFin del ejercicio 3\n----------");

        // Ejercicio 4: readLinesFromFile(String fn)
        System.out.println("\n# Ejercicio 4: readLinesFromFile(String fn)");
        nombreArchivo = c.readLine("Escribe el nombre del fichero a leer: ");
        for (String linea : readLinesFromFile(nombreArchivo)) {
            System.out.println(linea);
        }
        System.out.println("----------\nFin del ejercicio 4\n----------");
    }

    /**
     * Escribe un texto en un fichero. El contenido del fichero se sobreescribirá.
     * 
     * @param fn  el nombre del archivo.
     * @param txt el texto a escribir en el archivo {@code fn}.
     */
    public static void writeTextToFile(String fn, String txt) {
        try (FileWriter archivo = new FileWriter(fn); BufferedWriter writer = new BufferedWriter(archivo)) {
            writer.write(txt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Añade un texto al final de un fichero. El contenido previo del fichero se
     * conserva.
     * 
     * @param fn  el nombre del archivo.
     * @param txt el texto a añadir en el archivo {@code fn}.
     */
    public static void appendTextToFile(String fn, String txt) {
        try (FileWriter archivo = new FileWriter(fn, true); BufferedWriter writer = new BufferedWriter(archivo)) {
            if (!readLinesFromFile(fn).isEmpty())
                writer.write("\n");
            writer.write(txt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Añade todas las líneas de una lista al final de un fichero. El contenido
     * previo del fichero se conserva.
     * 
     * @param fn    el nombre del archivo.
     * @param lines la lista de líneas a añadir en el archivo {@code fn}.
     */
    public static void appendLinesToFile(String fn, List<String> lines) {
        for (String txt : lines) {
            appendTextToFile(fn, txt);
        }
    }

    /**
     * Lee el contenido de un fichero y lo devuelve en una lista.
     * 
     * @param fn el nombre del archivo.
     * @return una lista con las líneas del archivo {@code fn}.
     */
    public static List<String> readLinesFromFile(String fn) {
        List<String> textos = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fn))) {
            while (reader.ready()) {
                textos.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textos;
    }
}