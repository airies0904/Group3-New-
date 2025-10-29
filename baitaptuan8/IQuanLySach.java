package baitaptuan8;

import java.util.List;

public interface IQuanLySach {
    void themSach(Sach s);
    Sach timKiemSachTheoMa(String maSach);
    boolean xoaSachTheoMa(String maSach);
    List<Sach> hienThiDanhSach();
}
