package main;

public class SeatOne { // 1개 자리 (개인자리)
	private String seatone = "비어있음"; // 자리상태
	private int seatnum = 0;
	
	public int getSeatnum() {
		return seatnum;
	}
	public void setSeatnum(int seatnum) {
		this.seatnum = seatnum;
	}
	public String getSeatone() {
		return seatone;
	}
	public void setSeatone(String seatone) {
		this.seatone = seatone;
	}
	
	public void seatPrt() {
		System.out.println(seatnum+"번 = "+seatone);
	}

   
}