package org.example.block_1.ex_10;

// 10* Написать свой класс, аналогичный ConcurrentHashMap , используя ReadWriteLock.
// Будет ли эта реализация хуже ConcurrentHashMap, и если да, то почему?

// Отличия ConcurrentHashMap от HashMap
// Потокобезопасность - исправное функционирование при использовании его из нескольких потоков одновременно.
// Отсутствие блокировок всей таблицы на время доступа к ней
// Отсутствовали блокировки таблицы при выполнении операции чтения
public class ex_10 {
    public static void main(String[] args) {
        MyConcurrentHashMap<String, Integer> customMap = new MyConcurrentHashMap<>();

        customMap.put("key1", 1);
        customMap.put("key2", 2);

        System.out.println(customMap.get("key1"));
        System.out.println(customMap.get("key2"));

        customMap.remove("key1");

        System.out.println(customMap.get("key1"));
        System.out.println(customMap.get("key2"));

        customMap.put("key2", 3);
        System.out.println(customMap.get("key2"));
    }
}

// Реализация с использованием ReadWriteLock будет менее эффективной по сравнению с ConcurrentHashMap
// из-за специальных механизмов оптимизации для безопасности и эффективности параллельного доступа.
// Использование ReadWriteLock требует явного управления блокировками, что может привести
// к большему количеству переключений контекста и уменьшению производительности

