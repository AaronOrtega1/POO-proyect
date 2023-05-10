package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class GeneradorCSV {

  private static String[] header;
  private static String value;

  public GeneradorCSV(String ... h) {
    header = h;
  }

  private static String getHeader(String[] header, int pos) { return header[pos]; }

/*  private static ArrayList<GeneradorCSV> listValues(Scanner sc) {
    ArrayList<GeneradorCSV> list = new ArrayList<>();
    GeneradorCSV g;
    int i = 0;

    do {
      System.out.println(getHeader(header,i) + ": ");


    }while (!value.equalsIgnoreCase("FIN"));
    return list;

  }*/

  public void addValue(String...v) {

  }


}
