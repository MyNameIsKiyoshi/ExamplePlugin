package com.example.exampleplugin.task;

import org.bukkit.scheduler.*;

import java.util.function.*;

@SuppressWarnings("ALL")
public class ExampleTask extends BukkitRunnable {

    private int counter;
    private final IntConsumer countdownAction;
    private final Runnable completionAction;

    public ExampleTask(final int limit, final IntConsumer countdownAction, final Runnable completionAction){
        this.counter = limit;
        this.countdownAction = countdownAction;
        this.completionAction = completionAction;
    }

    @Override
    public void run() {
        if(--this.counter == 0){
            this.completionAction.run();
            this.cancel();
        }

        this.countdownAction.accept(this.counter);
    }
}
