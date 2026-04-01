package TH_LTHDT_CK;

public abstract class DichVu implements IPhanCong {
	private String maDV;
	private String tenDV;
	private double giaTien;
	
	public DichVu() {}
	public DichVu(String maDV, String tenDV, double giaTien) {
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.giaTien = giaTien;
	}
	public String GettenDV() {
		return tenDV;
	}
	public void SetmaDV(String maDV) {
		this.maDV = maDV;
	}
	public void SettenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public void SetgiaTien(Double giaTien) {
		this.giaTien = giaTien;
	}
	public String GetmaDV() {
		return maDV;
	}
	public double GetgiaTien() {
		return giaTien;
	}
	public String toString() {
		return "Ma dich vu: "+maDV+", Ten dich vu: "+tenDV+", Gia tien: "+giaTien;
	}
}
