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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departments that = (Departments) o;

        if (id != that.id) return false;
        return dept_name != null ? dept_name.equals(that.dept_name) : that.dept_name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dept_name != null ? dept_name.hashCode() : 0);
        return result;
    }



    @Override
    public String toString() {
        return "Departments{" +
                "id=" + id +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }
}
