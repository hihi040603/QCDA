using System;
using System.Collections.Generic;
//clean code ver 1.0
// ===== Entity Classes =====
public class Student {
    public string Id { get; set; }
    public string Name { get; set; }
    public string Major { get; set; }

    public override string ToString() => $"{Id} - {Name} ({Major})";
}

public class Teacher {
    public string Id { get; set; }
    public string Name { get; set; }
    public string Department { get; set; }

    public override string ToString() => $"{Id} - {Name} ({Department})";
}

public class Course {
    public string Id { get; set; }
    public string Title { get; set; }
    public int Credit { get; set; }

    public override string ToString() => $"{Id} - {Title} ({Credit} tín chỉ)";
}

// ===== Repository Classes =====
public class StudentRepository {
    private List<Student> students = new List<Student>();

    public void Add(Student s) => students.Add(s);
    public List<Student> GetAll() => students;
}

public class TeacherRepository {
    private List<Teacher> teachers = new List<Teacher>();

    public void Add(Teacher t) => teachers.Add(t);
    public List<Teacher> GetAll() => teachers;
}

public class CourseRepository {
    private List<Course> courses = new List<Course>();

    public void Add(Course c) => courses.Add(c);
    public List<Course> GetAll() => courses;
}

// ===== Application Layer =====
public class SchoolApp {
    public static void Main(string[] args) {
        var studentRepo = new StudentRepository();
        var teacherRepo = new TeacherRepository();
        var courseRepo = new CourseRepository();

        int choice;
        do {
            Console.WriteLine("==== MENU ====");
            Console.WriteLine("1. Thêm Sinh viên");
            Console.WriteLine("2. Xem danh sách Sinh viên");
            Console.WriteLine("3. Thêm Giáo viên");
            Console.WriteLine("4. Xem danh sách Giáo viên");
            Console.WriteLine("5. Thêm Môn học");
            Console.WriteLine("6. Xem danh sách Môn học");
            Console.WriteLine("0. Thoát");
            Console.Write("Chọn: ");
            choice = int.Parse(Console.ReadLine());

            switch (choice) {
                case 1:
                    Console.Write("ID: "); string sid = Console.ReadLine();
                    Console.Write("Tên: "); string sname = Console.ReadLine();
                    Console.Write("Ngành: "); string smajor = Console.ReadLine();
                    studentRepo.Add(new Student { Id = sid, Name = sname, Major = smajor });
                    break;
                case 2:
                    foreach (var s in studentRepo.GetAll())
                        Console.WriteLine(s);
                    break;
                case 3:
                    Console.Write("ID: "); string tid = Console.ReadLine();
                    Console.Write("Tên: "); string tname = Console.ReadLine();
                    Console.Write("Khoa: "); string dept = Console.ReadLine();
                    teacherRepo.Add(new Teacher { Id = tid, Name = tname, Department = dept });
                    break;
                case 4:
                    foreach (var t in teacherRepo.GetAll())
                        Console.WriteLine(t);
                    break;
                case 5:
                    Console.Write("ID: "); string cid = Console.ReadLine();
                    Console.Write("Tên môn: "); string cname = Console.ReadLine();
                    Console.Write("Số tín chỉ: "); int credit = int.Parse(Console.ReadLine());
                    courseRepo.Add(new Course { Id = cid, Title = cname, Credit = credit });
                    break;
                case 6:
                    foreach (var c in courseRepo.GetAll())
                        Console.WriteLine(c);
                    break;
            }
        } while (choice != 0);
    }
}