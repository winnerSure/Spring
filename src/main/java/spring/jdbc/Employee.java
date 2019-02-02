package spring.jdbc;

public class Employee {
    private int id;
    private String last_name;
    private String email;

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    private int dept_id;
//    private Departments departments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Departments getDepartments() {
//        return departments;
//    }
//
//    public void setDepartments(Departments departments) {
//        this.departments = departments;
//    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", dept_id=" + dept_id +
                '}';
    }
}
