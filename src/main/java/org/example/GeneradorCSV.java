package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneradorCSV{
  private final String[] encabezado;
  private final File f;

  public GeneradorCSV(String fileName,String ... header){
    this.f = new File("./" + fileName + ".csv");
    this.encabezado = header;
    try(FileWriter fw = new FileWriter(this.f);){
      fw.write(toCSV(header) + "\n");
    } catch (Exception e){
      System.out.println("Se produjo un error");
    }
  }

  private String toCSV(String[] line) throws IOException { //Recibe un arreglo de Strings y lo devuelve en formato CSV
    StringBuilder sb = new StringBuilder();
    int index = countRows();
    sb.append(index).append(", "); // agrega un index al inicio
    int i = 0;
    for (String element : line) {
      sb.append(element);
      if (i < line.length - 1) {
        sb.append(", ");
      }
      i++;
    }
    return sb.toString();
  }

  public void addValues(String ... v)  { //Lanza excepción cuando el número de valores es diferente a los definidos en el encabezado
    if (v.length != encabezado.length) throw new IllegalArgumentException("Número de argumentos incorrecto");
    try(FileWriter fw = new FileWriter(this.f, true)){
      fw.write(toCSV(v) + "\n");
    } catch (Exception e){
      System.out.println("Se produjo un error");
    }
  }

  public void clearFile() {
    try (FileWriter fw = new FileWriter(this.f)) {
      fw.write(""); // cadena vacía en el archivo para sobreescribir su contenido anterior
    } catch (IOException e) {
      System.out.println("Se produjo un error al borrar el contenido del archivo CSV.");
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    try (Scanner scanner = new Scanner(this.f)) {   // Crea un objeto scanner del archivo csv
      while (scanner.hasNextLine()) {
        sb.append(scanner.nextLine()).append("\n"); // Lee la linea de scanner y la agrega al StringBuilder con un salto al final
      }
    } catch (IOException e) {
      System.out.println("Se produjo un error al leer el archivo CSV.");
    }
    return sb.toString();
  }

  public void updateRow(int rowIndex, String ... v) throws IOException {
    if (v.length != encabezado.length) throw new IllegalArgumentException("Número de argumentos incorrecto");
    if (rowIndex == 0) throw new IllegalArgumentException("No se pueden modificar los headers");
    List<String> rows = new ArrayList<>();

    // Leer cada línea del archivo CSV y agregarla a la variable 'rows'
    try (Scanner scanner = new Scanner(this.f)) {
      while (scanner.hasNextLine()) {
        rows.add(scanner.nextLine());
      }
    }

    // Obtener la fila a actualizar y separar los valores en un arreglo de Strings
    String[] rowToUpdate = rows.get(rowIndex).split(",");

    // Reemplazar los valores existentes en el arreglo con los nuevos valores proporcionados
    for (int i = 0; i < v.length; i++) {
      rowToUpdate[i] = v[i];
    }

    // Actualizar la fila en la variable 'rows'
    rows.set(rowIndex, Integer.toString(rowIndex) + "," +String.join(",", rowToUpdate));

    // Escribir todas las filas de la variable 'rows' al archivo CSV
    try (FileWriter fw = new FileWriter(this.f)) {
      for (String row : rows) {
        fw.write(row + "\n");
      }
    }
  }

  public int countRows() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(this.f));
    int count = 0;
    while (reader.readLine() != null) {
      count++;
    }
    reader.close();
    return count;
  }

}
