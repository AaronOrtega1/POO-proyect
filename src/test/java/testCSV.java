import org.example.GeneradorCSV;

import java.io.IOException;

public class testCSV {
  public static void main(String[] args) throws IOException {
    System.out.println("-------Incializacion g1-------");
    GeneradorCSV g1 = new GeneradorCSV("Nombre", "Apellido","Carrera");
    g1.addValues("Sergio","Villa","ISC");
    g1.addValues("Aaron","Ortega","ISC");
    System.out.println(g1.toString());
    g1.clearFile();
    System.out.println("Después de limpiar el archivo:");
    System.out.println(g1.toString());
    System.out.println("-------Incializacion g2-------");
    GeneradorCSV g2 = new GeneradorCSV("Nombre", "Apellido","Carrera");
    g2.addValues("Sergio","Villa","ISC");
    g2.addValues("Aaron","Ortega","ISC");
    System.out.println(g2.toString());
    g2.updateRow(1,"sergio", "villa", "isc");
    g2.updateRow(2,"aaron", "ortega", "isc");
    System.out.println(g2.toString());

  }
}
