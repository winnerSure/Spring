package spring.jdbc;

public class Departments {
    private int id;
    private String dept_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    @Override
    public String toString() {
        return "Departments{" +
                "id=" + id +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }
}
