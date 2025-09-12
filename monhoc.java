import java.util.ArrayList;

public class monhoc {
   private String id;
    private String name;
    private int tinChi;

    public monhoc(String id, String name, int tinChi) {
        this.id = id;
        this.name = name;
        this.tinChi = tinChi;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getTinChi() { return tinChi; }

    public void setName(String name) { this.name = name; }
    public void setTinChi(int tinChi) { this.tinChi = tinChi; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | TinChi: " + tinChi;
    }

    private ArrayList<monhoc> courses = new ArrayList<>();

    public void themmonhoc(monhoc mh) {
        courses.add(mh);
    }

    public void xoamonhoc(String id) {
        courses.removeIf(mh -> mh.getId().equals(id));
    }

    public void capNhatmonhoc(String id, String name, int tinChi) {
        for (monhoc mh : courses) {
            if (mh.getId().equals(id)) {
                mh.setName(name);
                mh.setTinChi(tinChi);
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
    

