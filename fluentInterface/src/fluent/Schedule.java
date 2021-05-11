package fluent;

import java.util.ArrayList;

public class Schedule {

    ArrayList<Action> list;

    public Schedule() {
        this.list = new ArrayList<>();
    }

    static class ActionBuilder {

        String from = "-";
        String to = "-";
        String description = "undefined";
        String priority = "no priority";
        Schedule schedule;

        public ActionBuilder(Schedule schedule) {
            this.schedule = schedule;
        }

        ActionBuilder from(String from) {
            this.from = from;
            return this;
        }

        ActionBuilder to(String to) {
            this.to = to;
            return this;
        }

        ActionBuilder priority(String priority) {
            this.priority = priority;
            return this;
        }

        ActionBuilder description(String description) {
            this.description = description;
            return this;
        }

        Schedule submit() {
            schedule.list.add(new Action(from, to, description, priority));
            return schedule;
        }

    }

    ActionBuilder add() {
        return new ActionBuilder(this);
    }

    void print() {
        list.forEach(System.out::println);
    }

}
