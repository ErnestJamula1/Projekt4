/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

while(true) {
  System.out.println("\n1. Dodaj studenta");
  System.out.println("2. Wyświetl wszystkich studentów");
  System.out.println("3. Usuń studenta");
  System.out.println("4. Zaktualizuj dane studenta");
  System.out.println("5. Wyjście");
  System.out.print("Wybierz opcję: ");

  int choice = scanner.nextInt();
  scanner.nextLine();

  if(choice == 1) {
    System.out.println("Podaj imię studenta:");
    String firstName = scanner.nextLine();

    System.out.println("Podaj nazwisko studenta:");
    String lastName = scanner.nextLine();

    System.out.println("Podaj wiek studenta:");
    int age = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Podaj datę urodzenia (DD.MM.RRRR):");
    String birthDate = scanner.nextLine();

    s.addStudent(new Student(firstName, lastName, age, birthDate));
    System.out.println("Student został dodany.");
  }
  else if(choice == 2) {
    System.out.println("\nLista studentów:");
    var students = s.getStudents();
    for(Student current : students) {
      System.out.println(current.ToString());
    }
  }
  else if(choice == 3) {
    System.out.println("Podaj imię studenta do usunięcia:");
    String firstName = scanner.nextLine();

    System.out.println("Podaj nazwisko studenta do usunięcia:");
    String lastName = scanner.nextLine();

    s.deleteStudent(firstName, lastName);
    System.out.println("Student został usunięty.");
  }
  else if(choice == 4) {
    System.out.println("Podaj imię studenta:");
    String firstName = scanner.nextLine();

    System.out.println("Podaj nazwisko studenta:");
    String lastName = scanner.nextLine();

    System.out.println("Podaj nowy wiek studenta:");
    int newAge = scanner.nextInt();

    s.updateStudentAge(firstName, lastName, newAge);
    System.out.println("Dane studenta zostały zaktualizowane.");
  }
  else if(choice == 5) {
    break;
  }
}

scanner.close();
} catch (IOException e) {
System.out.println("Błąd podczas operacji na pliku: " + e.getMessage());
} catch (NumberFormatException e) {
System.out.println("Błąd: Nieprawidłowy format wieku");
}
}
}
