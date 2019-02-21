package ad;

public class AdResourceResult {
    private int play_count;
    private int valid_cpm_play_count;
    private int play_sec;
    private int task_id;
    private int date_id;

    public int getDate_id() {
        return date_id;
    }

    public void setDate_id(int date_id) {
        this.date_id = date_id;
    }

    public int getPlay_count() {
        return play_count;
    }

    public void setPlay_count(int play_count) {
        this.play_count = play_count;
    }

    public int getValid_cpm_play_count() {
        return valid_cpm_play_count;
    }

    public void setValid_cpm_play_count(int valid_cpm_play_count) {
        this.valid_cpm_play_count = valid_cpm_play_count;
    }

    public int getPlay_sec() {
        return play_sec;
    }

    public void setPlay_sec(int play_sec) {
        this.play_sec = play_sec;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    @Override
    public String toString() {
        return "AdResourceResult{" +
                "play_count=" + play_count +
                ", valid_cpm_play_count=" + valid_cpm_play_count +
                ", play_sec=" + play_sec +
                ", task_id=" + task_id +
                ", date_id=" + date_id +
                '}';
    }
}
