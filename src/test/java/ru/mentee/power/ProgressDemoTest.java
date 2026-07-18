package ru.mentee.power;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProgressDemoTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outputStream));
  }

  @AfterEach
  void tearDown() {
    System.setOut(standardOut);
  }

  @Test
  void whenSprintReady() {
    var progress = new MenteeProgress("Алексей", 5, 12);

    assertThat(progress.readyForSprint()).isEqualTo(true);
  }

  @Test
  void runMainWithoutErrors() {
    assertThatCode(() -> ProgressDemo.main(new String[]{}))
        .doesNotThrowAnyException();
  }

  @Test
  void outputStudentName() {
    ProgressDemo.main(new String[]{});
    assertThat(outputStream.toString()).contains("Даниил");
  }
}