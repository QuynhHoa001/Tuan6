package Tuan6;
import java.time.LocalDate;
import java.util.*;

abstract public class KhachHang {
	protected String maKH;
	protected String hoTen;
	protected LocalDate ngayLapHD;
	protected double soKW;
	protected double donGia;
	public KhachHang(String maKH, String hoTen, LocalDate ngayLapHD, double soKW, double donGia) {
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.ngayLapHD = ngayLapHD;
		this.soKW = soKW;
		this.donGia = donGia;
	}
	public abstract double thanhTien();
	public String getMaKH() {return maKH;}
	public String getHoTen() {return hoTen;}
	public LocalDate getNgayLapHD() {return ngayLapHD;}
	@Override
	public String toString() {
		return String.format("%s | %s | Ngay: %s | TT: %,.0f",maKH,hoTen,ngayLapHD,thanhTien());
	}
	
}