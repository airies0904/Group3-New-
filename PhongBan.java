

import java.util.ArrayList;

public class PhongBan {
    private String maPhong;
    private String tenPhong;
    private ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();

    public PhongBan(String maPhong, String tenPhong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
    }

    public void themNhanVien(NhanVien nv) {
        danhSachNhanVien.add(nv);
    }
}