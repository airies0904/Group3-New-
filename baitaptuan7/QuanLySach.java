package baitaptuan7;

import java.util.ArrayList;

public class QuanLySach {
    private ArrayList<Sach> danhSachSach;

    public QuanLySach() {
        danhSachSach = new ArrayList<>();
    }

    public void themSach(Sach s) {
        danhSachSach.add(s);
        System.out.println("Da them sach: " + s.getTieuDe());
    }

    public void hienThiDanhSach() {
        System.out.println("\n===== DANH SACH SACH =====");
        for (Sach s : danhSachSach) {
            System.out.println(s.toString());
        }
        System.out.println("==========================\n");
    }
}
