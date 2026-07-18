package ru.mentee.power.progress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProgressLoopTest {

  @Test
  void shouldCalculateTotalProgress_whenMultipleMentees() {
    var mentee1 = new Mentee("Иван", "Москва", "Найти работу", 5, 12);
    var mentee2 = new Mentee("Мария", "Анапа", "Повысить зарплату", 8, 12);
    var mentee3 = new Mentee("Пётр", "Новосибирск", "Стать Senior", 12, 12);
    Mentee[] mentees = {mentee1, mentee2, mentee3};

    int remainingTotal = ProgressTracker.calculateTotalProgress(mentees);

    assertThat(11).isEqualTo(remainingTotal);
  }

  @Test
  void shouldCalculateTotalProgress_whenAllMenteesCompleted() {
    var mentee1 = new Mentee("Иван", "Москва", "Найти работу", 12, 12);
    var mentee2 = new Mentee("Мария", "Анапа", "Повысить зарплату", 12, 12);
    Mentee[] mentees = {mentee1, mentee2};

    int remainingTotal = ProgressTracker.calculateTotalProgress(mentees);

    assertThat(0).isEqualTo(remainingTotal);
  }

  @Test
  @DisplayName("Должен выбросить исключение когда completedLessons больше totalLessons")
  void shouldThrowException_whenCompletedGreaterThanTotal() {
    assertThatThrownBy(() -> new Mentee("Иван", "Москва", "Backend", 15, 12))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Некорректные значения прогресса");
  }

  @Test
  @DisplayName("Не должен выбросить исключение когда данные корректны")
  void shouldNotThrowException_whenValidData() {
    assertThatCode(() -> new Mentee("Иван", "Москва", "Backend", 3, 12))
        .doesNotThrowAnyException();
  }

  @Test
  void shouldMainRunWithoutException() {
    assertThatCode(ProgressTracker::main)
        .doesNotThrowAnyException();
  }
}