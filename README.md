##  Quick Start
./gradlew run - запуск программы

./gradlew test - запуск тестов

##  Описание пакета ru.mentee.power
Все классы находятся в данном пакете:

ProgressDemo.java - главный класс, который содержит метод main(), которые явлется точкой запуска программы.

MenteeProgress.java - record, для представления прогресса менти

## Таблица полей record `MenteeProgress`

| Поле                  | Тип     | Описание                                                        |
|-----------------------|---------|-----------------------------------------------------------------|
| `menteeName`          | String  | Имя студента.                                                   |
| `sprintNumber`        | int     | Номер текущего спринта.                                         |
| `plannedHoursPerWeek` | int     | Количество часов, запланированных студентом на спринт (неделя). |

## Правило веток: feature/DVT-X

`master` - ветка со стабильной версией проекта, прямые коммиты запрещены

`feature/DVT-X` - новая разработка ведется в отдельных ветках, которые создаются от `master`, эти изменения не влияют на стабильную версию проекта


**Правило именования**: Название ветки должно следовать формату `feature/DVT-X`, где `X` — это номер урока.

## Git локальный цикл: шаги и команды

1. git init - инициализация репозитория
2. git status - проверка состояния
3. git add - добавление в staging
4. git commit - фиксация изменений
5. git branch - создание веток
6. git log - просмотр истории

## Сценарий ручной проверки DVT-6
### Запуск приложения
1. Откройте Gradle Tool Window (View → Tool Windows → Gradle)
2. Выполните: devtools → Tasks → application → run
3. Ожидаемый вывод в Run Tool Window: Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков
### Запуск тестов
1. Откройте Gradle Tool Window
2. Выполните: devtools → Tasks → verification → test
3. Ожидаемый вывод: BUILD SUCCESSFUL, все тесты зелёные
### Отладка через Debug
1. Установите breakpoint на строке цикла while в ProgressTracker.calculateProgress
2. Запустите Debug: кликните правой кнопкой на main → Debug 'ProgressTracker.main()'
3. Используйте Step Over (F8) для прохождения итераций
4. Проверьте Variables: counter, remainingHours должны изменяться корректно
5. Используйте Evaluate Expression (Alt+F8): вычислите remainingLessons * 2
6. Ожидаемый результат Evaluate: 14 (для completedLessons=5, totalLessons=12)
### Что делать при ошибках
1. Если вывод некорректен: проверьте логику цикла через Debug
2. Если тесты красные: откройте вывод теста, найдите AssertionError, скорректируйте метод
3. 3Если Debug не останавливается: убедитесь, что breakpoint установлен (красный кружок)

### Кодстайл-гайд проекта devtools

#### 1. Именование методов: camelCase
До: `public void add_student(Student s) { }`

После: `public void addStudent(Student student) { }`

Почему: Java Convention требует camelCase для методов. 

Источник: https://google.github.io/styleguide/javaguide.html#s5.3-camel-case

#### 2. Пробелы после if/for/while
До: `if(condition) {`

После: `if (condition) {`

Почему: улучшает читаемость, отделяет ключевое слово от выражения.

Источник: Oracle Code Conventions — Whitespace

#### 3. Длина строки: максимум 120 символов
До: `public List getStudentsFromSpecificCityWithVeryLongName...`

После: `public List getStudentsByCity(String city) {`

Почему: длинные строки затрудняют чтение в редакторе и при code review

Источник: https://google.github.io/styleguide/javaguide.html#s4.4-column-limit

#### 4. Порядок импортов
До: ` import java.util.List; import java.util.ArrayList; import java.io.File`

После: `import java.io.File; import java.util.ArrayList; import java.util.List;`

Почему: алфавитный порядок упрощает поиск импортов.\

Источник: IntelliJ IDEA → Code → Optimize Imports

#### 5. Фигурные скобки для if
До: `if (condition) doSomething()`

После: `if (condition) { doSomething(); }`

Почему: скобки обязательны даже для однострочных блоков

Источник: https://google.github.io/styleguide/javaguide.html#s4.1.1-braces-always-used




