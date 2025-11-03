
// Thêm "implements IkiemKe"
public class SachGiaoTrinh extends Sach {
    private String monHoc;
    private String capDo;

    public SachGiaoTrinh(){ super(); }
    public SachGiaoTrinh(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan, String viTri,
                        String monHoc, String capDo){ 
        // Gọi đến hàm tạo của lớp cha (Sach) để khởi tạo các thuộc tính chung
        // Từ khóa 'super' phải là câu lệnh đầu tiên trong hàm tạo của lớp con.
        super(maSach,tieuDe,tacGia,namXuatBan,soLuong,giaCoBan,viTri);
        this.monHoc = monHoc;
        this.capDo = capDo;
    }
    // Các phương thức getter và setter cho thuộc tính riêng
    public void setmonHoc(String monHoc){ this.monHoc = monHoc; }
    public String getmonHoc(){ return monHoc; }
    public void setcapDo(String capDo){ this.capDo = capDo; }
    public String getcapDo(){ return capDo; }

    @Override
    public double tinhGiaBan()
    {
        return (getgiaCoBan() + (2025-getNamXuatBan())*5000);
    }

    @Override
    public String toString() {
        return "SachGiaoTrinh{" + getThongTinCoBan() + 
            ", monHoc = '" + monHoc + '\'' +
            ", capDo = '" + capDo + '\'' +
            ", GiaBan = '" + tinhGiaBan() + '\'' + '}';
    }
}
