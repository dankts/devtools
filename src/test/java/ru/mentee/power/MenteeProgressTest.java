package ru.mentee.power;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MenteeProgressTest {

  @Test
  void shouldFormatSummary_whenProgressCreated() {
    MenteeProgress progress = new MenteeProgress("Даниил", 2, 11);

    String result = progress.summary();

    assertThat(result).isEqualTo("Sprint 2 → Даниил: planned 11 h");
  }

  @Test
  void shouldDetectReadiness_whenHoursAboveThreshold() {
    MenteeProgress progress = new MenteeProgress("Алексей", 1, 15);

    assertThat(progress.readyForSprint()).isTrue();
  }

  @Test
  void shouldDetectLackOfReadiness_whenHoursBelowThreshold() {
    MenteeProgress progress = new MenteeProgress("Сергей", 5, 1);

    assertThat(progress.readyForSprint()).isFalse();
  }
}