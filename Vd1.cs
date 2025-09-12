class Enrollment {
    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }

    @Override
    public String toString() {
        return student.getName() + " đăng ký " + course.getName();
    }
}

class EnrollmentManager {
    private List<Enrollment> enrollments = new ArrayList<>();

    public void enroll(Student s, Course c) {
        enrollments.add(new Enrollment(s, c));
    }

    public void listEnrollments() {
        enrollments.forEach(System.out::println);
    }
}