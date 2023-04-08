import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(new Scanner(System.in));
        while (true) {
            printMenu();
            int i = scanner.nextInt();
            if (i == 1) {
                stepTracker.addNewNumberStepsPerDay(); // Ввести количество шагов за определённый день
            } else if (i == 2) {
                stepTracker.changeStepGoal();// Изменить цель по количеству шагов
            } else if (i == 3) {
                stepTracker.printStatistic(); //Выводим статистику
            } else if (i == 4) {
                System.out.println ( "Пока!" );
                scanner.close();
                return;
            } else {
                System.out.println ( "Такой команды нет" );
            }
        }
    }
    static void printMenu() {
        // Вывод доступных команд
        System.out.println ( "Ввести количество шагов за определённый день -1" );
        System.out.println ( "Изменить цель по количеству шагов в день -2" );
        System.out.println ( "Напечатать статистику за определённый месяц -3" );
        System.out.println ( "Выйти из приложения -4" );
    }
}
