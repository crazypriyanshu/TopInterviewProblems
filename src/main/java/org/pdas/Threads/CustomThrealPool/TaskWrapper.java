package org.pdas.Threads.CustomThrealPool;

public class TaskWrapper implements Runnable{
    private final Runnable actualTask;
    private TaskState taskState;

    public TaskWrapper(Runnable actualTask, TaskState taskState) {
        this.actualTask = actualTask;
        this.taskState = TaskState.PENDING;
    }

    @Override
    public void run() {
        this.taskState = TaskState.RUNNING;
        try {
            actualTask.run();
            this.taskState = TaskState.COMPLETED;
        } catch (Exception e) {
            this.taskState = TaskState.FAILED;
            System.err.println("Actual task failed... ");
            throw e;
        }

    }
}
