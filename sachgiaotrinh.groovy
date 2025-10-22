

// Thêm "implements IkiemKe"
public class SachGiaoTrinh extends Sach implements IkiemKe {
    private String monHoc;
    private String capDo;

    public SachGiaoTrinh(){ super(); }
    public SachGiaoTrinh(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan, String viTri,
                        String monHoc, String capDo){ 
        // Gọi đến hàm tạo của lớp cha (Sach) để khởi tạo các thuộc tính chung
        // Từ khóa 'super' phải là câu lệnh đầu tiên trong hàm tạo của lớp con.
        super(maSach,tieuDe,tacGia,namXuatBan,soLuong,giaCoBan,viTri);
        
        // Khởi tạo các thuộc tính riêng của lớp con
        this.monHoc = monHoc;
        this.capDo = capDo;
    }
    // Các phương thức getter và setter cho thuộc tính riêng
    public void setmonHoc(String monHoc){      this.monHoc = monHoc;    }
    public String getmonHoc(){        return monHoc;    }
    public void setcapDo(String capDo){        this.capDo = capDo;    }
    public String getcapDo(){        return capDo;    }

    @Override
    public double tinhGiaBan()
    {
        return (getgiaCoBan() + (2025-getNamXuatBan())*5000);
    }
    /*
    * Ghi đè (Override) phương thức toString()
    * Gọi phương thức getThongTinCoBan() từ lớp cha để lấy thông tin chung,
    * sau đó thêm thông tin riêng của SachGiaoTrinh.
    */
    @Override
    public String toString() {
        return "SachGiaoTrinh{" + getThongTinCoBan() + 
            ", monHoc = '" + monHoc + '\'' +
            ", capDo = '" + capDo + '\'' +
            ", GiaBan = '" + tinhGiaBan() + '\'' + '}';
    }

    // <-- TRIỂN KHAI CÁC PHƯƠNG THỨC TỪ GIAO DIỆN IkiemKe -->
    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu) {
        return getSoLuong() >= soLuongToiThieu;
    }

    @Override
    public void capNhatViTri(String viTriMoi) {
        // setviTri() được kế thừa từ lớp Sach
        setviTri(viTriMoi);
        System.out.println("Da chuyen sach " + getTieuDe() + " den khu vuc: " + viTriMoi +".");
    }
}
