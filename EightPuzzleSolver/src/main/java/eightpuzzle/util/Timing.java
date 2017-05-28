package eightpuzzle.util;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Author: Mario Gómez Martínez <magomar@gmail.com>
 */
public class Timing {
    private Timing() {
    }

    /**
     * Get CPU time in nanoseconds.
     */
    static long getCpuTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported() ?
                bean.getCurrentThreadCpuTime() : 0L;
    }

    /**
     * Get user time in nanoseconds.
     */
    public static long getUserTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported() ?
                bean.getCurrentThreadUserTime() : 0L;
    }

    /**
     * Get system time in nanoseconds.
     */
    public static long getSystemTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported() ?
                (bean.getCurrentThreadCpuTime() - bean.getCurrentThreadUserTime()) : 0L;
    }

    /**
     * Get CPU time in nanoseconds.
     */
    public static long getCpuTime(long[] ids) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        if (!bean.isThreadCpuTimeSupported())
            return 0L;
        long time = 0L;
        for (long id : ids) {
            long t = bean.getThreadCpuTime(id);
            if (t != -1)
                time += t;
        }
        return time;
    }

    /**
     * Get user time in nanoseconds.
     */
    public static long getUserTime(long[] ids) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        if (!bean.isThreadCpuTimeSupported())
            return 0L;
        long time = 0L;
        for (long id : ids) {
            long t = bean.getThreadUserTime(id);
            if (t != -1)
                time += t;
        }
        return time;
    }

    /**
     * Get system time in nanoseconds.
     */
    public static long getSystemTime(long[] ids) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        if (!bean.isThreadCpuTimeSupported())
            return 0L;
        long time = 0L;
        for (long id : ids) {
            long tc = bean.getThreadCpuTime(id);
            long tu = bean.getThreadUserTime(id);
            if (tc != -1 && tu != -1)
                time += (tc - tu);
        }
        return time;
    }
}
