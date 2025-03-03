package main;

public class Book { //단일책
	private String title=null;  //책제목
	 private boolean flag = true; // 대여가능여부
	

	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getTitle() { // 도서관리자 권한 직접참조
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void bookPrt() { // 책정보 출력
		if(flag==true) {
			   System.out.println(this.title+"(대여가능)");
			}else if (flag==false) {
				System.out.println(this.title+"(대여불가능)");
			}
	}
	public void bookBorrow() { //책대여
		if(flag==true) {
		   this.flag=false; // 대여불가 상태로 변환
		   System.out.println(this.title+"을 대여하셨습니다");
		}
	}
	public void bookReturnOne() { // 책반납
		if(flag==false) {
			   this.flag=true; // 대여가능 상태로 변환
			   System.out.println(this.title+"을 반납하였습니다");
			}
		}
}
