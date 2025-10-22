import java.util.Scanner;

public class SachGiaoTrinh extends Sach1 implements IkiemKe{
    private String monHoc;
    private String capDo;
    private String viTri;
    public SachGiaoTrinh()
    {
        super();
    }
    public SachGiaoTrinh(String Masach,String TieuDe,String Tacgia,int NamXuatBan, int Soluong, int giaCoBan,String Monhoc, String Capdo, String viTri)
    {
        super(Masach, TieuDe, Tacgia, NamXuatBan, Soluong, giaCoBan);
        this.monHoc=Monhoc;
        this.capDo=Capdo;
        this.viTri=viTri;
    }
    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mon hoc: ");
        this.monHoc = sc.nextLine();
        System.out.print("Nhap cap do (Dai hoc/Pho thong): ");
        this.capDo = sc.nextLine();
    }
    @Override
    public double tinhGiaBan(){
        return getGiaCoBan() + ((2025-getNamXuatBan())*5000);
    }
    @Override
    public String toString()
    {
        return super.toString() + ", Mon hoc: " + monHoc + ", Cap do: " + capDo + ",Gia ban:" + tinhGiaBan();
    }
    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu) {
        if (Soluong >= soLuongToiThieu) {
            return true;
        }
        else
            return false;
    }
    @Override
    public void capNhatViTri(String viTriMoi) {
        this.viTri=viTriMoi;
        System.out.println("Da chuyen sach " +getTieuDe()+ " den khu vuc " + viTriMoi);
    }
}