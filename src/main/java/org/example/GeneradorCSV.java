package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GeneradorCSV {
  private static String[] encabezado;
  private final File f = new File("./file.csv");

  public GeneradorCSV(String ... header){
    this.encabezado = header;
    try(FileWriter fw = new FileWriter(this.f);){
      fw.write(toCSV(header) + "\n");
    } catch (Exception e){
      System.out.println("Se produjo un error");
    }
  }

  private String toCSV(String[] line){ //Recibe un arreglo de Strings y lo devuelve en formato CSV
    String toReturn = "";
    int i=0;
    for(String element: line){
      if(line.length != i-2) //Si llega al penúltimo elemento del arreglo de strings ya no se agrega coma a toReturn
        toReturn += element + ", ";
      else{
        toReturn += element; //Cuando llega al último elemento del arreglo no pone coma después
      }
      i++;
    }
    return toReturn;
  }

  public void addValues(String ... v)  { //Lanza excepción cuando el número de argumentos es diferente a los definidos en el encabezado
    //if(v.length != encabezado.length) throw new IncorrectArgumentsExecption(v.length);
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
    try (Scanner scanner = new Scanner(this.f)) {
      while (scanner.hasNextLine()) {
        sb.append(scanner.nextLine()).append("\n");
      }
    } catch (IOException e) {
      System.out.println("Se produjo un error al leer el archivo CSV.");
    }
    return sb.toString();
  }

}
