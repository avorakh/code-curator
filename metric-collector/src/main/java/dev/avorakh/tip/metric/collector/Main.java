package dev.avorakh.tip.metric.collector;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int size = 3;
        // Case 1
        MetricCollector collector = new FixedSizeWindowMetricCollector(size);
        collector.add(1);
        collector.add(6);
        collector.add(7);
        collector.add(2);
        double result1 = collector.add(3);
        System.out.println("Case 1:  " + result1); // Expect - 4

        // Case 2
        MetricCollector collector2 = new FixedSizeWindowMetricCollector(size);
        collector2.add(1);
        collector2.add(2);
        double result2 = collector2.add(3);
        System.out.println("Case 2:  " + result2); // Expect - 2

        // Case 3
        MetricCollector collector3 = new FixedSizeWindowMetricCollector(size);
        collector3.add(1);
        double result3 = collector3.add(4);
        System.out.println("Case 3:  " + result3); // Expect - 2.5
    }
}

interface MetricCollector {
    /**
     * Add an integer value to a collector storage and return the average value of the stored values.
     *
     * @param value - new value
     * @return average value stored in collector storage
     */
    double add(int value);
}

class FixedSizeWindowMetricCollector implements MetricCollector {
    private Queue<Integer> window;
    private int maxSize;
    private int sum;

    public FixedSizeWindowMetricCollector(int size) {
        this.window = new LinkedList<>();
        this.maxSize = size;
        this.sum = 0;
    }

    @Override
    public double add(int value) {
        if (window.size() == maxSize) {
            sum -= window.poll();
        }
        window.offer(value);
        sum += value;
        return (double) sum / window.size();
    }
}
