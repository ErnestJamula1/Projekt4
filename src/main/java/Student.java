public class Student {

  private String firstName;
  private String lastName;
  private int age;
    private String birthDate;

    public Student(String firstName, String lastName, int age, String birthDate) {
    this.firstName = firstName;
    this.lastName = lastName;
      this.age = age;
      this.birthDate = birthDate;
  }

  public String GetFirstName() {return firstName;}
  public String GetLastName() {return lastName;}
  public int GetAge() {return age;}
   public String GetBirthDate() {return birthDate;}

  public String ToString() {
    return firstName + " " + lastName + " " + Integer.toString(age) + " " + birthDate;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 4) 
      return new Student("Parse", "Error", -1, "");
    return new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]);
  }
}
