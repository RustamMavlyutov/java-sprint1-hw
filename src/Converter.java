class Converter {
    /* В этом классе будет осуществляться преобразование шагов в километры и килокалории. При этом:
      для подсчёта дистанции можно считать, что один шаг равен 75 см;
     для подсчёта количества сожжённых килокалорий можно считать, что 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий.
      Создайте следующие методы:
     */
    // метод, переводящий количество шагов в километры;
    int convertToKm(int steps) {
        double km = (steps * 0.75) / 1000;
        return (int)km;
    }
    // метод, переводящий количество шагов в килокалории.
    int convertStepsToKilocalories(int steps) {
        double kkal = (steps * 50) / 1000;
        return (int)kkal;
    }
}
