package eightpuzzle.solver.task;

import eightpuzzle.util.SingleThreadStopwatch;

/**
 * Created by mario on 31/01/14.
 */
class TaskRunner {
    private static TaskRunner ourInstance = new TaskRunner();
    private final SingleThreadStopwatch stopwatch = new SingleThreadStopwatch();

    private TaskRunner() {
    }

    static TaskRunner getInstance() {
        return ourInstance;
    }

    void run(Task task) {
        stopwatch.start();
        task.run();
        stopwatch.stop();
        System.out.println(SingleThreadStopwatch.timeToString(stopwatch.getTotalTime()));
    }
}
