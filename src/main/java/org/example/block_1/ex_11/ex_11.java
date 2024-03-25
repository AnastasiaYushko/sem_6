package org.example.block_1.ex_11;

//11. Написать класс Formatter, с методом format(Date date), форматирующим дату и время.
// Использовать для форматирования класс SimpleDateFormat.
// В основном потоке создается единственный экземпляр класса Formatter.
// Создать 5 потоков, каждому потоку передается при инициализации этот экземпляр.
// Потоки должны корректно форматировать дату-время, синхронизация не разрешается.

public class ex_11 {
    public static void main(String[] args) {
        Formatter formatter = new Formatter("yyyy-MM-dd HH:mm:ss");

        Thread thread1 = new DateThread(formatter);
        Thread thread2 = new DateThread(formatter);
        Thread thread3 = new DateThread(formatter);
        Thread thread4 = new DateThread(formatter);
        Thread thread5 = new DateThread(formatter);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
