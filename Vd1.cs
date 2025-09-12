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
        return "Sinh viên " + student.getName() + " đăng ký môn " + course.getName();
    }
}

class EnrollmentManager {
    private List<Enrollment> enrollments = new ArrayList<>();

    public void enroll(Student student, Course course) {
        enrollments.add(new Enrollment(student, course));
    }

    public void listEnrollments() {
        if (enrollments.isEmpty()) {
            System.out.println("⚠ Chưa có đăng ký nào.");
        } else {
            System.out.println("\n📖 DANH SÁCH ĐĂNG KÝ:");
            for (Enrollment e : enrollments) {
                System.out.println(e);
            }
        }
    }
}