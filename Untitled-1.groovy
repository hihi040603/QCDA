// Chương trình quản lý trường học cực kỳ BAD CODE
// Lưu ý: code này chỉ để sinh viên phân tích, KHÔNG nên dùng thật
// Tất cả dữ liệu lưu trữ trong ArrayList<String> dạng "id|name|field1|field2|..."

import java.util.*;

public class BadSchoolProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Danh sách dữ liệu: lưu sinh viên, giáo viên, môn học, đăng ký, điểm...
        ArrayList<String> students = new ArrayList<String>();
        ArrayList<String> teachers = new ArrayList<String>();
        ArrayList<String> courses = new ArrayList<String>();
        ArrayList<String> enrollments = new ArrayList<String>();
        ArrayList<String> grades = new ArrayList<String>();

        int menu = 0;
        while (menu != 99) {
            System.out.println("============= MENU CHINH =============");
            System.out.println("1. Quan ly Sinh vien");
            System.out.println("2. Quan ly Giao vien");
            System.out.println("3. Quan ly Mon hoc");
            System.out.println("4. Quan ly Dang ky hoc");
            System.out.println("5. Quan ly Diem");
            System.out.println("6. Bao cao tong hop");
            System.out.println("99. Thoat");
            System.out.print("Nhap lua chon: ");
            menu = sc.nextInt(); sc.nextLine();

            if (menu == 1) {
                // Quản lý sinh viên
                int smenu = 0;
                while (smenu != 9) {
                    System.out.println("--- QUAN LY SINH VIEN ---");
                    System.out.println("1. Them SV");
                    System.out.println("2. Xoa SV");
                    System.out.println("3. Cap nhat SV");
                    System.out.println("4. Hien thi tat ca SV");
                    System.out.println("5. Tim SV theo ten");
                    System.out.println("6. Tim SV GPA > 8");
                    System.out.println("7. Sap xep theo ten");
                    System.out.println("8. Sap xep theo GPA");
                    System.out.println("9. Quay lai");
                    smenu = sc.nextInt(); sc.nextLine();

                    if (smenu == 1) {
                        System.out.print("Nhap id: ");
                        String id = sc.nextLine();
                        System.out.print("Nhap ten: ");
                        String name = sc.nextLine();
                        System.out.print("Nhap tuoi: ");
                        int age = sc.nextInt(); sc.nextLine();
                        System.out.print("Nhap GPA: ");
                        double gpa = sc.nextDouble(); sc.nextLine();
                        students.add(id + "|" + name + "|" + age + "|" + gpa);
                    } else if (smenu == 2) {
                        System.out.print("Nhap id can xoa: ");
                        String id = sc.nextLine();
                        for (int i = 0; i < students.size(); i++) {
                            String[] parts = students.get(i).split("\\|");
                            if (parts[0].equals(id)) {
                                students.remove(i);
                                break;
                            }
                        }
                    } else if (smenu == 3) {
                        System.out.print("Nhap id can cap nhat: ");
                        String id = sc.nextLine();
                        for (int i = 0; i < students.size(); i++) {
                            String[] parts = students.get(i).split("\\|");
                            if (parts[0].equals(id)) {
                                System.out.print("Nhap ten moi: ");
                                String name = sc.nextLine();
                                System.out.print("Nhap tuoi moi: ");
                                int age = sc.nextInt(); sc.nextLine();
                                System.out.print("Nhap GPA moi: ");
                                double gpa = sc.nextDouble(); sc.nextLine();
                                students.set(i, id + "|" + name + "|" + age + "|" + gpa);
                            }
                        }
                    } else if (smenu == 4) {
                        for (int i = 0; i < students.size(); i++) {
                            String[] p = students.get(i).split("\\|");
                            System.out.println("ID:" + p[0] + " Name:" + p[1] + " Age:" + p[2] + " GPA:" + p[3]);
                        }
                    } else if (smenu == 5) {
                        System.out.print("Nhap ten: ");
                        String name = sc.nextLine();
                        for (int i = 0; i < students.size(); i++) {
                            String[] p = students.get(i).split("\\|");
                            if (p[1].equals(name)) {
                                System.out.println("Tim thay: " + students.get(i));
                            }
                        }
                    } else if (smenu == 6) {
                        for (int i = 0; i < students.size(); i++) {
                            String[] p = students.get(i).split("\\|");
                            if (Double.parseDouble(p[3]) > 8.0) {
                                System.out.println("Sinh vien gioi: " + students.get(i));
                            }
                        }
                    } else if (smenu == 7) {
                        for (int i = 0; i < students.size(); i++) {
                            for (int j = 0; j < students.size() - 1; j++) {
                                String[] p1 = students.get(j).split("\\|");
                                String[] p2 = students.get(j + 1).split("\\|");
                                if (p1[1].compareTo(p2[1]) > 0) {
                                    String tmp = students.get(j);
                                    students.set(j, students.get(j + 1));
                                    students.set(j + 1, tmp);
                                }
                            }
                        }
                        System.out.println("Da sap xep theo ten.");
                    } else if (smenu == 8) {
                        for (int i = 0; i < students.size(); i++) {
                            for (int j = 0; j < students.size() - 1; j++) {
                                String[] p1 = students.get(j).split("\\|");
                                String[] p2 = students.get(j + 1).split("\\|");
                                if (Double.parseDouble(p1[3]) < Double.parseDouble(p2[3])) {
                                    String tmp = students.get(j);
                                    students.set(j, students.get(j + 1));
                                    students.set(j + 1, tmp);
                                }
                            }
                        }
                        System.out.println("Da sap xep theo GPA.");
                    }
                }

            } else if (menu == 2) {
                // Quản lý giáo viên (copy-paste giống sinh viên nhưng khác field)
                // BAD CODE: cực kỳ trùng lặp
                int tmenu = 0;
                while (tmenu != 9) {
                    System.out.println("--- QUAN LY GIAO VIEN ---");
                    System.out.println("1. Them GV");
                    System.out.println("2. Xoa GV");
                    System.out.println("3. Cap nhat GV");
                    System.out.println("4. Hien thi GV");
                    System.out.println("9. Quay lai");
                    tmenu = sc.nextInt(); sc.nextLine();
                    if (tmenu == 1) {
                        System.out.print("Nhap id GV: ");
                        String id = sc.nextLine();
                        System.out.print("Nhap ten GV: ");
                        String name = sc.nextLine();
                        System.out.print("Nhap chuyen mon: ");
                        String major = sc.nextLine();
                        teachers.add(id + "|" + name + "|" + major);
                    } else if (tmenu == 2) {
                        System.out.print("Nhap id GV can xoa: ");
                        String id = sc.nextLine();
                        for (int i = 0; i < teachers.size(); i++) {
                            String[] p = teachers.get(i).split("\\|");
                            if (p[0].equals(id)) {
                                teachers.remove(i);
                                break;
                            }
                        }
                    } else if (tmenu == 3) {
                        System.out.print("Nhap id GV cap nhat: ");
                        String id = sc.nextLine();
                        for (int i = 0; i < teachers.size(); i++) {
                            String[] p = teachers.get(i).split("\\|");
                            if (p[0].equals(id)) {
                                System.out.print("Nhap ten moi: ");
                                String name = sc.nextLine();
                                System.out.print("Nhap chuyen mon moi: ");
                                String major = sc.nextLine();
                                teachers.set(i, id + "|" + name + "|" + major);
                            }
                        }
                    } else if (tmenu == 4) {
                        for (int i = 0; i < teachers.size(); i++) {
                            String[] p = teachers.get(i).split("\\|");
                            System.out.println("ID:" + p[0] + " Name:" + p[1] + " Major:" + p[2]);
                        }
                    }
                }

            } else if (menu == 3) {
                // Quản lý môn học (copy-paste nữa)
                int cmenu = 0;
                while (cmenu != 9) {
                    System.out.println("--- QUAN LY MON HOC ---");
                    System.out.println("1. Them MH");
                    System.out.println("2. Xoa MH");
                    System.out.println("3. Cap nhat MH");
                    System.out.println("4. Hien thi MH");
                    System.out.println("9. Quay lai");
                    cmenu = sc.nextInt(); sc.nextLine();
                    if (cmenu == 1) {
                        System.out.print("Nhap id MH: ");
                        String id = sc.nextLine();
                        System.out.print("Nhap ten MH: ");
                        String name = sc.nextLine();
                        System.out.print("Nhap so tin chi: ");
                        int tc = sc.nextInt(); sc.nextLine();
                        courses.add(id + "|" + name + "|" + tc);
                    } else if (cmenu == 2) {
                        System.out.print("Nhap id MH can xoa: ");
                        String id = sc.nextLine();
                        for (int i = 0; i < courses.size(); i++) {
                            String[] p = courses.get(i).split("\\|");
                            if (p[0].equals(id)) {
                                courses.remove(i);
                                break;
                            }
                        }
                    } else if (cmenu == 3) {
                        System.out.print("Nhap id MH cap nhat: ");
                        String id = sc.nextLine();
                        for (int i = 0; i < courses.size(); i++) {
                            String[] p = courses.get(i).split("\\|");
                            if (p[0].equals(id)) {
                                System.out.print("Nhap ten moi: ");
                                String name = sc.nextLine();
                                System.out.print("Nhap tin chi moi: ");
                                int tc = sc.nextInt(); sc.nextLine();
                                courses.set(i, id + "|" + name + "|" + tc);
                            }
                        }
                    } else if (cmenu == 4) {
                        for (int i = 0; i < courses.size(); i++) {
                            String[] p = courses.get(i).split("\\|");
                            System.out.println("ID:" + p[0] + " Name:" + p[1] + " TinChi:" + p[2]);
                        }
                    }
                }
            }

            else if (menu == 4) {
                // Quản lý đăng ký học (spaghetti cực mạnh)
                int emenu = 0;
                while (emenu != 9) {
                    System.out.println("--- QUAN LY DANG KY HOC ---");
                    System.out.println("1. Dang ky mon hoc");
                    System.out.println("2. Huy dang ky");
                    System.out.println("3. Xem tat ca dang ky");
                    System.out.println("9. Quay lai");
                    emenu = sc.nextInt(); sc.nextLine();
                    if (emenu == 1) {
                        System.out.print("Nhap id SV: ");
                        String sid = sc.nextLine();
                        System.out.print("Nhap id MH: ");
                        String cid = sc.nextLine();
                        enrollments.add(sid + "|" + cid);
                    } else if (emenu == 2) {
                        System.out.print("Nhap id SV: ");
                        String sid = sc.nextLine();
                        System.out.print("Nhap id MH: ");
                        String cid = sc.nextLine();
                        for (int i = 0; i < enrollments.size(); i++) {
                            String[] p = enrollments.get(i).split("\\|");
                            if (p[0].equals(sid) && p[1].equals(cid)) {
                                enrollments.remove(i);
                                break;
                            }
                        }
                    } else if (emenu == 3) {
                        for (int i = 0; i < enrollments.size(); i++) {
                            String[] p = enrollments.get(i).split("\\|");
                            System.out.println("SV: " + p[0] + " dang ky MH: " + p[1]);
                        }
                    }
                }
            }

            else if (menu == 5) {
                // Quản lý điểm (trùng lặp vô hạn)
                int gmenu = 0;
                while (gmenu != 9) {
                    System.out.println("--- QUAN LY DIEM ---");
                    System.out.println("1. Nhap diem");
                    System.out.println("2. Cap nhat diem");
                    System.out.println("3. Hien thi diem");
                    System.out.println("9. Quay lai");
                    gmenu = sc.nextInt(); sc.nextLine();
                    if (gmenu == 1) {
                        System.out.print("Nhap id SV: ");
                        String sid = sc.nextLine();
                        System.out.print("Nhap id MH: ");
                        String cid = sc.nextLine();
                        System.out.print("Nhap diem: ");
                        double d = sc.nextDouble(); sc.nextLine();
                        grades.add(sid + "|" + cid + "|" + d);
                    } else if (gmenu == 2) {
                        System.out.print("Nhap id SV: ");
                        String sid = sc.nextLine();
                        System.out.print("Nhap id MH: ");
                        String cid = sc.nextLine();
                        for (int i = 0; i < grades.size(); i++) {
                            String[] p = grades.get(i).split("\\|");
                            if (p[0].equals(sid) && p[1].equals(cid)) {
                                System.out.print("Nhap diem moi: ");
                                double d = sc.nextDouble(); sc.nextLine();
                                grades.set(i, sid + "|" + cid + "|" + d);
                            }
                        }
                    } else if (gmenu == 3) {
                        for (int i = 0; i < grades.size(); i++) {
                            String[] p = grades.get(i).split("\\|");
                            System.out.println("SV:" + p[0] + " MH:" + p[1] + " Diem:" + p[2]);
                        }
                    }
                }
            }

            else if (menu == 6) {
                // Báo cáo tổng hợp (spaghetti cực đỉnh)
                System.out.println("=== BAO CAO ===");
                for (int i = 0; i < students.size(); i++) {
                    String[] s = students.get(i).split("\\|");
                    System.out.println("Sinh vien: " + s[1]);
                    for (int j = 0; j < enrollments.size(); j++) {
                        String[] e = enrollments.get(j).split("\\|");
                        if (e[0].equals(s[0])) {
                            for (int k = 0; k < courses.size(); k++) {
                                String[] c = courses.get(k).split("\\|");
                                if (c[0].equals(e[1])) {
                                    System.out.print(" - Mon hoc: " + c[1]);
                                    for (int m = 0; m < grades.size(); m++) {
                                        String[] g = grades.get(m).split("\\|");
                                        if (g[0].equals(s[0]) && g[1].equals(c[0])) {
                                            System.out.print(" | Diem: " + g[2]);
                                        }
                                    }
                                    System.out.println();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
