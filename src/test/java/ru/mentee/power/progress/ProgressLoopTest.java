package ru.mentee.power.progress;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProgressLoopTest {

    @Test
    void shouldCalculateTotalProgress_whenMultipleMentees() {
        var mentee1 = new Mentee("Иван", "Москва", "Найти работу", 5, 12);
        var mentee2 = new Mentee("Мария", "Анапа", "Повысить зарплату", 8, 12);
        var mentee3 = new Mentee("Пётр", "Новосибирск", "Стать Senior", 12, 12);
        Mentee[] mentees = {mentee1, mentee2, mentee3};

        String messageResult = ProgressTracker.calculateTotalProgress(mentees);

        assertThat(messageResult).contains("пройдено 25 из 36 уроков").contains("осталось 11 уроков");
    }

    @Test
    void shouldCalculateTotalProgress_whenAllMenteesCompleted() {
        var mentee1 = new Mentee("Иван", "Москва", "Найти работу", 12, 12);
        var mentee2 = new Mentee("Мария", "Анапа", "Повысить зарплату", 12, 12);
        Mentee[] mentees = {mentee1, mentee2};

        String messageResult = ProgressTracker.calculateTotalProgress(mentees);

        assertThat(messageResult).contains("пройдено 24 из 24 уроков").contains("осталось 0 уроков");
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
}