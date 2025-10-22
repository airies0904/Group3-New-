package baitap7;

import java.util.ArrayList;

public class QuanLySach {
    private ArrayList<Sach> danhSachSach = new ArrayList<>();

    public void themSach(Sach s) {
        danhSachSach.add(s);
    }

    public void hienThiDanhSachSach() {
        System.out.println("=== DANH SÁCH SÁCH ===");
        for (Sach s : danhSachSach) {
            System.out.println(s.toString());
        }
    }
}
