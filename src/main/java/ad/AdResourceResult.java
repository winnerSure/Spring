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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdResourceResult that = (AdResourceResult) o;

        if (play_count != that.play_count) return false;
        if (valid_cpm_play_count != that.valid_cpm_play_count) return false;
        if (play_sec != that.play_sec) return false;
        if (task_id != that.task_id) return false;
        return date_id == that.date_id;
    }

    @Override
    public int hashCode() {
        int result = play_count;
        result = 31 * result + valid_cpm_play_count;
        result = 31 * result + play_sec;
        result = 31 * result + task_id;
        result = 31 * result + date_id;
        return result;
    }

//    public AdResourceResult(int play_count, int valid_cpm_play_count, int play_sec, int task_id, int date_id) {
//        this.play_count = play_count;
//        this.valid_cpm_play_count = valid_cpm_play_count;
//        this.play_sec = play_sec;
//        this.task_id = task_id;
//        this.date_id = date_id;
//    }
//
//    public static void main(String[]  args) {
//        AdResourceResult ad1 = new AdResourceResult(0,0,0,0,0);
//        AdResourceResult ad2 = new AdResourceResult(0,0,0,0,0);
//        System.out.println("args = [" + ad1.equals(ad2) + "]");
//    }
}
