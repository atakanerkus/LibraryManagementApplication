package data_layer;

public enum Priority {
	invaluable(1),
    highlysignificant(2),
    noteworthy(3);

    private final int priorityValue;

    private Priority(int priorityValue) {
        this.priorityValue = priorityValue;
    }

    public int getPriorityValue() { // in terms of integer 1, 2, 3...
        return priorityValue;
    }
}

