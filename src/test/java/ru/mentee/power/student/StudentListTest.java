package ru.mentee.power.student;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentListTest {

  private StudentList studentList;

  @BeforeEach
  void setUp() {
    studentList = new StudentList();
  }

  @Test
  void shouldAddStudent() {
    Student student = new Student("Alexey", "Moscow");
    studentList.addStudent(student);

    List<Student> result = studentList.getStudentsByCity("Moscow");
    assertThat(result).hasSize(1);
    assertThat(result).contains(student);
  }

  @Test
  void getStudentsList_whenOtherCity() {
    Student student1 = new Student("Alexey", "Moscow");
    Student student2 = new Student("Maria", "Novosibirsk");

    studentList.addStudent(student1);
    studentList.addStudent(student2);

    List<Student> result = studentList.getStudentsByCity("Moscow");
    assertThat(result).hasSize(1);
    assertThat(result).contains(student1);
    assertThat(result).doesNotContain(student2);
  }
}