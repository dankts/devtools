package ru.mentee.power.progress;

public class ProgressTracker {

    public static String calculateTotalProgress(Mentee[] mentees) {
        int index = 0;
        int completedTotal = 0;
        int totalTotal = 0;

        while (index < mentees.length) {
            completedTotal += mentees[index].completedLessons();
            totalTotal += mentees[index].totalLessons();
            index++;
        }

        int remainingTotal = totalTotal - completedTotal;

        return String.format("Суммарно: пройдено %d из %d уроков, осталось %s уроков",
                completedTotal, totalTotal, remainingTotal);
    }

    static void main() {
        var mentee1 = new Mentee("Иван", "Москва", "Найти работу", 5, 12);
        var mentee2 = new Mentee("Мария", "Анапа", "Повысить зарплату", 8, 12);
        var mentee3 = new Mentee("Пётр", "Новосибирск", "Стать Senior", 12, 12);
        Mentee[] mentees = {mentee1, mentee2, mentee3};
        System.out.println(calculateTotalProgress(mentees));
    }
}
