import java.util.List;

public interface IQuanLySach {
    Sach timKiemtheomasach(String maSach);
    int size(); // Them phuong thuc nay de lay so luong
    boolean themSach(Sach... sach);
    List<Sach> timKiemSach(String tenSach);
    boolean xoaSach(String maSach);
    void hienThiDanhSach();
}
