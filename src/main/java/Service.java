import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Service {

  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);
    b.append(student.ToString());
    b.newLine();
    b.close();
  }

  public Collection<Student> getStudents() throws IOException {
    var ret = new ArrayList<Student>();
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    String line = "";
    while (true) {
      line = reader.readLine();
      if(line == null)
        break;
      Student student = Student.Parse(line);
      if (student.GetAge() != -1) {
        ret.add(student);
      }
    }
    reader.close();
    return ret;
  }

  public void deleteStudent(String firstName, String lastName) throws IOException {
    var students = getStudents();
    var f = new FileWriter("db.txt");
    var b = new BufferedWriter(f);

    for(Student student : students) {
      if(!student.GetFirstName().equals(firstName) || !student.GetLastName().equals(lastName)) {
        b.write(student.ToString());
        b.newLine();
      }
    }
    b.close();
  }
}
