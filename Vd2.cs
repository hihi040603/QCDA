// BadSchoolProgram.cs
// Chương trình quản lý trường học bằng C# cực kỳ BAD CODE
// Gồm: Sinh viên, Giáo viên, Môn học, Đăng ký, Điểm
// Tất cả lưu bằng List<string> kiểu "id|field1|field2|..."
// hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
// hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
// kkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
using System;
using System.Collections.Generic;

public class Student
{public string Id { get; set; }public string Name { get; set; }public int Age { get; set; }public double GPA { get; set; }
}

public class SchoolProgram
{
    private static void AddStudent(List<Student> students)
    {
        Console.Write("ID: "); string id = Console.ReadLine(); Console.Write("Tên: "); string name = Console.ReadLine();
        Console.Write("Tuổi: "); int.TryParse(Console.ReadLine(), out int age);
        Console.Write("GPA: "); double.TryParse(Console.ReadLine(), out double gpa);

        if (students.Any(s => s.Id == id))
        {
            Console.WriteLine("ID đã tồn tại");
            return;
        }

        students.Add(new Student { Id = id, Name = name, Age = age, GPA = gpa });
        Console.WriteLine("Thêm sinh viên thành công");
    }

    public static void studentsMenu()
    {
        int menu = 0;
        while (menu != 9)
        {
            Console.WriteLine("--- QUAN LY SINH VIEN ---");
            Console.WriteLine("1. Them SV");
            Console.WriteLine("2. Xoa SV");            
            Console.WriteLine("3. Cap nhat SV");
            Console.WriteLine("4. Hien thi tat ca SV");
            Console.WriteLine("5. Tim SV theo ten");
            Console.WriteLine("6. Tim SV GPA > 8");
            Console.WriteLine("7. Sap xep theo ten");
            Console.WriteLine("8. Sap xep theo GPA");
            Console.WriteLine("9. Quay lai");
            menu = int.Parse(Console.ReadLine(),out menu); 

            switch(menu)
            {
                case 1:
                    
                    break;
                case 2:
                    Console.Write("Nhap id can xoa: ");
                        string id = Console.ReadLine();
                        for (int i = 0; i < students.Count; i++)
                        {
                            string[] parts = students[i].Split('|');
                            if (parts[0] == id)
                            {
                                students.RemoveAt(i);
                                break;
                            }
                        }
                    break;
                case 3:
                    Console.Write("Nhap id can cap nhat: ");
                        string id = Console.ReadLine();
                        for (int i = 0; i < students.Count; i++)
                        {
                            string[] parts = students[i].Split('|');
                            if (parts[0] == id)
                            {
                                Console.Write("Nhap ten moi: ");
                                string name = Console.ReadLine();
                                Console.Write("Nhap tuoi moi: ");
                                int age = int.Parse(Console.ReadLine());
                                Console.Write("Nhap GPA moi: ");
                                double gpa = double.Parse(Console.ReadLine());
                                students[i] = id + "|" + name + "|" + age + "|" + gpa;
                            }
                        }
                    break;
                case 4:
                    foreach (var s in students)
                        {
                            string[] p = s.Split('|');
                            Console.WriteLine("ID:" + p[0] + " Name:" + p[1] + " Age:" + p[2] + " GPA:" + p[3]);
                        }
                    break;
                case 5:
                    Console.Write("Nhap ten: ");
                        string name = Console.ReadLine();
                        foreach (var s in students)
                        {
                            string[] p = s.Split('|');
                            if (p[1] == name)
                            {
                                Console.WriteLine("Tim thay: " + s);
                            }
                        }
                    break;
                case 6:
                    foreach (var s in students)
                        {
                            string[] p = s.Split('|');
                            if (double.Parse(p[3]) > 8.0)
                            {
                                Console.WriteLine("Sinh vien gioi: " + s);
                            }
                        }
                    break;
                case 7:
                    for (int i = 0; i < students.Count; i++)
                        {
                            for (int j = 0; j < students.Count - 1; j++)
                            {
                                string[] p1 = students[j].Split('|');
                                string[] p2 = students[j + 1].Split('|');
                                if (p1[1].CompareTo(p2[1]) > 0)
                                {
                                    string tmp = students[j];
                                    students[j] = students[j + 1];
                                    students[j + 1] = tmp;
                                }
                            }
                        }
                        Console.WriteLine("Da sap xep theo ten.");
                    break;
                case 8:
                    for (int i = 0; i < students.Count; i++)
                        {
                            for (int j = 0; j < students.Count - 1; j++)
                            {
                                string[] p1 = students[j].Split('|');
                                string[] p2 = students[j + 1].Split('|');
                                if (double.Parse(p1[3]) < double.Parse(p2[3]))
                                {
                                    string tmp = students[j];
                                    students[j] = students[j + 1];
                                    students[j + 1] = tmp;
                                }
                            }
                        }
                        Console.WriteLine("Da sap xep theo GPA.");
                    break;
                case 9:
                    
                    break;
                default:
                    Console.WriteLine("Lua chon khong hop le. Vui long chon lai.");
                    break;
            }
        }                                              
    }
    public static void Main(string[] args)
    {
        List<string> students = new List<string>();        List<string> teachers = new List<string>(); List<string> courses = new List<string>();List<string> enrollments = new List<string>();
        List<string> grades = new List<string>();


        int menu = 0;
        while (menu != 99)
        {
            Console.WriteLine("============= MENU CHINH =============");
            Console.WriteLine("1. Quan ly Sinh vien");
            Console.WriteLine("2. Quan ly Giao vien");
            Console.WriteLine("3. Quan ly Mon hoc");
            Console.WriteLine("4. Quan ly Dang ky hoc");
            Console.WriteLine("5. Quan ly Diem");
            Console.WriteLine("6. Bao cao tong hop");
            Console.WriteLine("99. Thoat");
            Console.Write("Nhap lua chon: ");
            menu = int.Parse(Console.ReadLine());

            switch (menu)
            {
                case 1:
                    int smenu = 0;
                    while (smenu != 9)
                    {
                        case 1:

                            break;
                        case 2:
                            Console.Write("Nhap id can xoa: ");
                            string id = Console.ReadLine();
                            for (int i = 0; i < students.Count; i++)
                            {
                                string[] parts = students[i].Split('|');
                                if (parts[0] == id)
                                {
                                    students.RemoveAt(i);
                                    break;
                                }
                            }
                            break;
                        case 3:
                            Console.Write("Nhap id can cap nhat: ");
                            string id = Console.ReadLine();
                            for (int i = 0; i < students.Count; i++)
                            {
                                string[] parts = students[i].Split('|');
                                if (parts[0] == id)
                                {
                                    Console.Write("Nhap ten moi: ");
                                    string name = Console.ReadLine();
                                    Console.Write("Nhap tuoi moi: ");
                                    int age = int.Parse(Console.ReadLine());
                                    Console.Write("Nhap GPA moi: ");
                                    double gpa = double.Parse(Console.ReadLine());
                                    students[i] = id + "|" + name + "|" + age + "|" + gpa;
                                }
                            }
                            break;
                        case 4:
                            foreach (var s in students)
                            {
                                string[] p = s.Split('|');
                                Console.WriteLine("ID:" + p[0] + " Name:" + p[1] + " Age:" + p[2] + " GPA:" + p[3]);
                            }
                            break;
                        case 5:
                            Console.Write("Nhap ten: ");
                            string name = Console.ReadLine();
                            foreach (var s in students)
                            {
                                string[] p = s.Split('|');
                                if (p[1] == name)
                                {
                                    Console.WriteLine("Tim thay: " + s);
                                }
                            }
                            break;
                        case 6:
                            foreach (var s in students)
                            {
                                string[] p = s.Split('|');
                                if (double.Parse(p[3]) > 8.0)
                                {
                                    Console.WriteLine("Sinh vien gioi: " + s);
                                }
                            }
                            break;
                        case 7:
                            for (int i = 0; i < students.Count; i++)
                            {
                                for (int j = 0; j < students.Count - 1; j++)
                                {
                                    string[] p1 = students[j].Split('|');
                                    string[] p2 = students[j + 1].Split('|');
                                    if (p1[1].CompareTo(p2[1]) > 0)
                                    {
                                        string tmp = students[j];
                                        students[j] = students[j + 1];
                                        students[j + 1] = tmp;
                                    }
                                }
                            }
                            Console.WriteLine("Da sap xep theo ten.");
                            break;
                        case 8:
                            for (int i = 0; i < students.Count; i++)
                            {
                                for (int j = 0; j < students.Count - 1; j++)
                                {
                                    string[] p1 = students[j].Split('|');
                                    string[] p2 = students[j + 1].Split('|');
                                    if (double.Parse(p1[3]) < double.Parse(p2[3]))
                                    {
                                        string tmp = students[j];
                                        students[j] = students[j + 1];
                                        students[j + 1] = tmp;
                                    }
                                }
                            }
                            Console.WriteLine("Da sap xep theo GPA.");
                            break;
                        case 9:

                            break;
                        default:
                            Console.WriteLine("Lua chon khong hop le. Vui long chon lai.");
                            break;
                    }
                    }
                }
                    
            }
            
            // Quản lý giáo viên, môn học, đăng ký, điểm, báo cáo 
            // (phần này em giữ nguyên cấu trúc như bản Java 10 trang)
            // copy-paste gần y nguyên, chỉ đổi cú pháp sang C#
            // ... (do code quá dài nên em dừng ở đây, còn lại tương tự bản Java)
        }
    }
}
