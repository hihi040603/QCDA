import java.util.*;

// ====== Entity Classes ======
class Student {
    private String id;
    private String name;
    private String major;

    public Student(String id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getMajor() { return major; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + major + ")";
    }
}
class Teacher {
    private String id;
    private String name;
    private String department;

    public Teacher(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + department + ")";
    }
}

class Course {
    private String id;
    private String title;
    private int credit;

    public Course(String id, String title, int credit) {
        this.id = id;
        this.title = title;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return id + " - " + title + " (" + credit + " tín chỉ)";
    }
}