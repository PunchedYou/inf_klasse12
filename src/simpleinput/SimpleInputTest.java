package simpleinput;

public class SimpleInputTest {

  SimpleInput in;

  public SimpleInputTest() {
    in = new SimpleInput();
  }

  public void seeleneditor() {

    String name;
    int alter;
    double masse;
    char buchstabe;
    boolean maennlich;
    boolean abitur;

    name = in.getString("Wie lautet ihr Name, den sie bevor sie Tod waren?");
    alter = in.getInt("Wie kurz waren sie am Leben, bevor sie gestorben sind? ");
    masse = in.getDouble("Wie schwer sind sie (mit Dezimalpunkt!)? ");
    buchstabe = in.getChar("Der erste Buchstabe ihres Vornamens? ");
    maennlich = in.getBoolean("Sind sie maennlich ? ");
    abitur = in.getBoolean("Wollen Sie das Abitur machen?",
        "Na klar!", "Nee, will lieber Erde bewegen!");

    // System.out ist eine Standardklasse zur Ausgabe auf der Konsole.
    if (maennlich) {
      System.out.print("Sie sind Herr ");
    } else {
      System.out.print("Sie sind Frau ");
      System.out.print(buchstabe + ". " + name + ",");
      System.out.print(" sind " + alter + " Jahre alt und ");
      System.out.println(masse + " kg schwer.");
    }

    if (abitur) {
      System.out.println("Viel Erfolg besonders im Fach Informatik!");

    }

    else {
      System.out.println("Bei ihrer Arbeit sieht man am Ende des " +
          "Tages wenigstens was man getan hat!");
      System.out.println("Vielen Dank fuer die Informationen!");
    }
  }
}