
import java.util.*;


class Student {
    private String id;
    private String name;
    private int age;
    private double gpa;

    public Student(String id, String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", GPA: " + gpa;
    }
}





class SchoolManager {
    private Scanner scanner = new Scanner(System.in);
    private List<Student> students = new ArrayList<>();

    public void manageStudents() {
        int choice = 0;
        while (choice != 9) {
            System.out.println("\n--- QUẢN LÝ SINH VIÊN ---");
            System.out.println("1. Thêm SV");
            System.out.println("2. Xóa SV");
            System.out.println("3. Cập nhật SV");
            System.out.println("4. Hiển thị tất cả SV");
            System.out.println("5. Tìm SV theo tên");
            System.out.println("6. Tìm SV GPA > 8");
            System.out.println("7. Sắp xếp theo tên");
            System.out.println("8. Sắp xếp theo GPA");
            System.out.println("9. Quay lại");
            System.out.print("Nhập lựa chọn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1: addStudent(); break;
                case 2: removeStudent(); break;
                case 3: updateStudent(); break;
                case 4: displayStudents(); break;
                case 5: findStudentByName(); break;
                case 6: findStudentsWithHighGpa(); break;
                case 7: sortStudentsByName(); break;
                case 8: sortStudentsByGpa(); break;
                case 9: System.out.println("Quay lại menu chính."); break;
                default: System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại."); break;
            }
        }
    }

    private void addStudent() {
        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập GPA: ");
        double gpa = Double.parseDouble(scanner.nextLine());

        students.add(new Student(id, name, age, gpa));
        System.out.println("Đã thêm sinh viên.");
    }

    private void removeStudent() {
        System.out.print("Nhập ID cần xóa: ");
        String id = scanner.nextLine();
        Student found = null;
        for (Student s : students) {
            if (s.getId().equals(id)) {
                found = s;
                break;
            }
        }
        if (found != null) {
            students.remove(found);
            System.out.println("Đã xóa sinh viên.");
        } else {
            System.out.println("Không tìm thấy sinh viên.");
        }
    }

    private void updateStudent() {
        System.out.print("Nhập ID cần cập nhật: ");
        String id = scanner.nextLine();
        Student found = null;
        for (Student s : students) {
            if (s.getId().equals(id)) {
                found = s;
                break;
            }
        }
        if (found != null) {
            System.out.print("Tên mới: ");
            found.setName(scanner.nextLine());
            System.out.print("Tuổi mới: ");
            found.setAge(Integer.parseInt(scanner.nextLine()));
            System.out.print("GPA mới: ");
            found.setGpa(Double.parseDouble(scanner.nextLine()));
            System.out.println("Đã cập nhật sinh viên.");
        } else {
            System.out.println("Không tìm thấy sinh viên.");
        }
    }

    private void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Chưa có sinh viên nào.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void findStudentByName() {
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        List<Student> found = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                found.add(s);
            }
        }
        if (found.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên.");
        } else {
            for (Student s : found) {
                System.out.println("Tìm thấy: " + s);
            }
        }
    }

    private void findStudentsWithHighGpa() {
        List<Student> highGpa = new ArrayList<>();
        for (Student s : students) {
            if (s.getGpa() > 8.0) {
                highGpa.add(s);
            }
        }
        if (highGpa.isEmpty()) {
            System.out.println("Không có sinh viên GPA > 8.");
        } else {
            for (Student s : highGpa) {
                System.out.println("Sinh viên giỏi: " + s);
            }
        }
    }

    private void sortStudentsByName() {
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Đã sắp xếp theo tên.");
    }

    private void sortStudentsByGpa() {
        students.sort((a, b) -> Double.compare(b.getGpa(), a.getGpa()));
        System.out.println("Đã sắp xếp theo GPA.");
    }

    // Các hàm quản lý khác (giáo viên, môn học, đăng ký học, điểm, báo cáo) 
    public void manageTeachers() { System.out.println("Chức năng Quản lý Giáo viên chưa triển khai."); }
    
    public void manageCourses() { 
                // Chức năng Quản lý Môn học 
                monhocmanager controll = new monhocmanager();
                Scanner sc = new Scanner(System.in);
                int cmenu = 0;
                while (cmenu != 9) {
                    System.out.println("--- QUAN LY MON HOC ---");
                    System.out.println("1. Them MH");
                    System.out.println("2. Xoa MH");
                    System.out.println("3. Cap nhat MH");
                    System.out.println("4. Hien thi MH");
                    System.out.println("9. Quay lai");
                    System.out.print("Nhap lua chon: ");
                    cmenu = sc.nextInt(); sc.nextLine();

                    if (cmenu == 1) {
                        System.out.print("Nhap id MH: ");
                        String id = sc.nextLine();
                        System.out.print("Nhap ten MH: ");
                        String name = sc.nextLine();
                        System.out.print("Nhap so tin chi: ");
                        int tc = sc.nextInt(); sc.nextLine();
                        controll.themmonhoc(new monhoc(id, name, tc));
                    } 
                    else if (cmenu == 2) {
                        System.out.print("Nhap id MH can xoa: ");
                        String id = sc.nextLine();
                        controll.xoamonhoc(id);
                    } else if (cmenu == 3) {
                        System.out.print("Nhap id MH cap nhat: ");
                        String id = sc.nextLine();
                        System.out.print("Nhap ten MH moi: ");
                        String name = sc.nextLine();
                        System.out.print("Nhap so tin chi moi: ");
                        int tc = sc.nextInt(); sc.nextLine();
                        controll.capNhatmonhoc(id, name, tc);
                    } else if (cmenu == 4) {
                        controll.hienThimonhoc();
                    }
                }
            }

    
     
    public void manageEnrollments() { System.out.println("Chức năng Quản lý Đăng ký học chưa triển khai."); }
    public void manageGrades() { System.out.println("Chức năng Quản lý Điểm chưa triển khai."); }
    public void generateReport() { System.out.println("Chức năng Báo cáo tổng hợp chưa triển khai."); }

    }
public class Vd1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SchoolManager manager = new SchoolManager();

        int choice = 0;
        while (choice != 99) {
            System.out.println("\n============= MENU CHÍNH =============");
            System.out.println("1. Quản lý Sinh viên");
            System.out.println("2. Quản lý Giáo viên");
            System.out.println("3. Quản lý Môn học");
            System.out.println("4. Quản lý Đăng ký học");
            System.out.println("5. Quản lý Điểm");
            System.out.println("6. Báo cáo tổng hợp");
            System.out.println("99. Thoát");
            System.out.print("Nhập lựa chọn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1: manager.manageStudents(); break;
                case 2: manager.manageTeachers(); break;
                case 3: manager.manageCourses(); break;
                case 4: manager.manageEnrollments(); break;
                case 5: manager.manageGrades(); break;
                case 6: manager.generateReport(); break;
                case 99: System.out.println("Thoát chương trình."); break;
                default: System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại."); break;
            }
        }

        scanner.close();
    }
}
