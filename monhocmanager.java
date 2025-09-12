import java.util.ArrayList;

public class monhocmanager {
        private ArrayList<monhoc> courses = new ArrayList<>();

    public void themmonhoc(monhoc mh) {
        courses.add(mh);
    }

    public void xoamonhoc(String id) {
        courses.removeIf(mh -> mh.getId().equals(id));
    }

    public void capNhatmonhoc(String id) {
        for (monhoc mh : courses) {
            if (mh.getId().equals(id)) {
         
            }
        }
    }

    public void hienThimonhoc() {
        if (courses.isEmpty()) {
            System.out.println("Chưa có môn học nào!");
        } else {
            for (monhoc mh : courses) {
                System.out.println(mh);
            }
        }
    }
}
