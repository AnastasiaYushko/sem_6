package org.example.block_1.ex_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//6. То же самое. использовать метод Collections.synchronizedList
public class ex_6 {
    public static void main(String[] args) {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Runnable addTask = new AddTask_Thread(list);
        Runnable removeTask = new RemoveTask_Thread(list);

        Thread addThread = new Thread(addTask);
        Thread removeThread = new Thread(removeTask);

        addThread.start();
        removeThread.start();
    }
}
