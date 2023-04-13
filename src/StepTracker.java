import java.util.Scanner;
class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;   // цель шагов на день
    Converter converter = new Converter();

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    void addNewNumberStepsPerDay() {
        System.out.println ( "Введите номер месяца от 1 до 12 (включительно) " );
        // ввод и проверка номера месяца
        int month = scanner.nextInt();
        if ( ( month < 1) || ( month > 12 ) ) {
            System.out.println ( "Ошибка ввода! Месяца с индексом - " + month + " несуществует :(" );
            return;
        }

        System.out.println ( "Введите день от 1 до 30 (включительно)" );
        // ввод и проверка дня
        int day = scanner.nextInt();
        if ( ( day < 1) || ( day> 30 ) ) {
            System.out.println( "Ошибка ввода! Дня с индексом - " + day + " несуществует :(" );
            return;
        }
        System.out.println("Введите количество шагов");
        // ввод и проверка количества шагов
        int stepsTaken = scanner.nextInt();
        if ( stepsTaken < 0 ) {
            System.out.println ( "Ошибка ввода! Количество шагов не может быть меньше 0 :(" );
            return;
        }
        // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month-1];
        // Сохранение полученных данных
        monthData.days[day-1] = stepsTaken;
    }
    void printStatistic() {
        System.out.println ( "Введите номер месяца от 1 до 12 (включительно)" );
        int month = scanner.nextInt();
        if ((month < 1) || (month > 12)) {
            System.out.println ( "Ошибка ввода! Месяца с индексом - " + month + " несуществует :(" );
            return;
        }
        MonthData monthData = monthToData[month - 1];
        int sumSteps = monthData.sumStepsFromMonth();// получение суммы шагов за месяц
        int maxSteps = monthData.maxSteps();
        int finalSeries = monthData.bestSeries( goalByStepsPerDay );
        //Вывод в кансоль
        monthData.printDaysAndStepsFromMonth();// вывод общей статистики по дням
        System.out.println ( "Всего шагов за месяц: " + sumSteps );
        System.out.println ( "Максимально пройденно шагов за месяц: " + maxSteps );
        System.out.println ( "Пройденного среднее количество шагов за месяц: " + (sumSteps / 30) );
        System.out.println ( "Пройденной за месяц: " + converter.convertToKm(sumSteps) + " km" );
        System.out.println ( "Сожжённых килокалорий за месяц: " + converter.convertStepsToKilocalories(sumSteps) + " ккал" );
        System.out.println ( "вывод лучшей серии: " + finalSeries );
        System.out.println ();
    }
    //метод который будет менять это цель шагов на день вводимое пользователем.
    void changeStepGoal() {
        System.out.println ( "Введите цель шагов на день." );
        int newStepsGoal = scanner.nextInt();
        if (newStepsGoal <=0) {
            System.out.println ( "Ошибка ввода! Количество шагов не может быть меньше 0 :(" );
            return;
        }
        goalByStepsPerDay = newStepsGoal;
    }
}
