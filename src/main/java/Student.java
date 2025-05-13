public class Student {

  private String firstName;
  private String lastName;
  private int age;

  public Student(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String GetFirstName() {return firstName;}
  public String GetLastName() {return lastName;}
  public int GetAge() {return age;}

  public String ToString() {
    return firstName + " " + lastName + " " + Integer.toString(age);
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 3) 
      return new Student("Parse", "Error", -1);
    return new Student(data[0], data[1], Integer.parseInt(data[2]));
  }
}
