class MonthData {
    int[] days = new int[30];

    int[] getDays() {
        return days;
    }
    // Вывод элементов массива в необходимом формате
    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    // подсчёт суммы элементов массива days[]
    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    // поиск максимального элемента
    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (maxSteps < days[i])
                maxSteps = days[i];
        }
        return maxSteps;
    }

    // поиск максимальной серии
    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > goalByStepsPerDay) {
                currentSeries++;
                if(currentSeries >= finalSeries) {
                    finalSeries = currentSeries;
                }
            }else{
                currentSeries=0;
                }
            }

        return finalSeries;
    }

}