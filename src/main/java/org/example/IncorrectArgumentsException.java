package org.example;

public class IncorrectArgumentsException extends Exception{
  private int numberArgs;
/*  public IncorrectArgumentsExecption(int n){
    super("IncorrectNumberOfArguments");
    this.numberArgs = n;
  }*/

  public String toString(){
    return getMessage() + "\nArguments recieved: " + this.numberArgs;
  }
}
