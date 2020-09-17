package anakar01.packag.com.myroster;

public class ModelClass {

    private String empName, empEmail, emmMobile;
    private boolean expanded;

    public ModelClass(String empName, String empEmail, String emmMobile) {
        this.empName = empName;
        this.empEmail = empEmail;
        this.emmMobile = emmMobile;
        this.expanded = false;

    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public String getEmmMobile() {
        return emmMobile;
    }
}
