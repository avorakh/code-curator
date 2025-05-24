# Fixed-Size Window Average Collector
## Objective
Implement a class of a metric collector that:

- Maintains a fixed-size window of the latest N integers (i.e., always keeps the most recent N values).
- After each new value is added, it returns the average of the current window.
- The average should reflect only the available values.

## For Interviewee 
Where:
- Fixed size - 3

| Case | Input array     | Expect   |
|------|-----------------|----------|
| 1    | [1, 2, 3]       | 2 or 2.0 |
| 2    | [2, 6, 3, 2, 7] | 4 or 4.0 |

Please use the code:
```java

public class Main {
    public static void main(String[] args) {
        int size = 3;
        // TBA solution
    }
}

interface MetricCollector {
    /**
     * Adds a new integer value to the collector and
     * returns the average of the current values in the collector..
     * 
     * @param value - new value
     * @return average of the stored elements.
     */
    ?/** Replace it */ add(int value);
}

class FixedSizeWindowMetricCollector implements MetricCollector {
    // TBA solution
    
    public FixedSizeWindowMetricCollector(int size) {
        // TBA solution
    }

    /**
     * Adds a new integer value to the collector and
     * returns the average of the current values in the collector..
     *
     * @param value - new value
     * @return average of the stored elements.
     */
    @Override
    public ?/** Replace it */ add(int value) {
        // TBA solution
        return 0;
    }
}
```

For Interviewer

| Case | Input array     | Output on the last input element | Notes       |
|------|-----------------|----------------------------------|-------------|
| 1    | [1, 2, 3]       | 2.0                              | two         |
| 2    | [2, 6, 5, 3, 7] | 4.0                              | four        |
| 3    | [1, 4]          | 2.5                              | Hidden case |
