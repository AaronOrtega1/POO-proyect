import org.example.GeneradorCSV;

public class testCSV {
  public static void main(String[] args) {
    GeneradorCSV g1 = new GeneradorCSV("Nombre", "Apellido","Carrera");
    g1.addValues("Sergio","Villa","ISC");
    g1.addValues("Aaron","Ortega","ISC");
    System.out.println(g1.toString());
    g1.clearFile();
    System.out.println("Después de limpiar el archivo:");
    System.out.println(g1.toString());

  }
}
