package org.example.block_1.ex_11;

//11. Написать класс Formatter, с методом format(Date date), форматирующим датувремя.
// Использовать для форматирования класс SimpleDateFormat.
// В основном потоке создается единственный экземпляр класса Formatter.
// Создать 5 потоков, каждому потоку передается при инициализации этот экземпляр.
// Потоки должны корректно форматировать дату-время, синхронизация не разрешается.

public class ex_11 {
    public static void main(String[] args) {
        Formatter formatter = new Formatter("yyyy-MM-dd HH:mm:ss");

        for (int i = 1; i <= 5; i++) {
            Thread thread = new DateThread(formatter);
            thread.setName("Thread " + i);
            thread.start();
        }
    }
}
