package govind.iiitl.app.models;

public class Schedule {
    private String time;
    private String period;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Schedule(String time, String period) {
        this.time = time;
        this.period = period;
    }
}
