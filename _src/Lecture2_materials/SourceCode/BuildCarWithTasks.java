package com.loonycorn;

import java.util.ArrayList;
import java.util.List;

public class BuildCarWithTasks {

    public static void main(String[] args) {
        Task a = new Task("a");
        Task b = new Task("b", a);
        Task e = new Task("e");
        Task d = new Task("d", e);
        Task c = new Task("c", a, b, d);
        Task f = new Task("f", c);

        List<Task> taskList = new ArrayList<>();
        taskList.add(d);
        taskList.add(e);
        taskList.add(f);
        taskList.add(a);
        taskList.add(b);
        taskList.add(c);

        buildCar(taskList);
    }

    public static void buildCar(List<Task> taskList) {
        for (Task task : taskList) {
            task.execute();
        }
    }

    public static class Task {
        private String id;
        private List<Task> dependencyList;
        private boolean done = false;

        public Task(String id, Task... dependencyArray) {
            this.id = id;
            dependencyList = new ArrayList<Task>();
            for (Task task : dependencyArray) {
                dependencyList.add(task);
            }
        }

        public void execute() {
            if (done) {
                return;
            }

            // Ensure all successors are done first, this task
            // cannot be executed without executing all it's
            // dependencies.
            for (Task task : dependencyList) {
                task.execute();
            }
            runTask();
        }

        private void runTask() {
            // Performs some operations.
            done = true;
            System.out.println("Completed task: " + id.toUpperCase());
        }

    }
}
