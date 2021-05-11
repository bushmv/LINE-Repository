package fluent;

class Action {
    private final String from;
    private final String to;
    private final String description;
    private final String priority;

    public Action(String from, String to, String name, String description) {
        this.from = from;
        this.to = to;
        this.description = name;
        this.priority = description;
    }

    @Override
    public String toString() {
        return (description + "\t\t\t" + from + "\t-\t" + to + "\t" + priority);
    }
}
