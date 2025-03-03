package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Location { // 독서 보관대
	private String Location = null;
	private ArrayList<Book> book = new ArrayList<>();// 책(제목,식별번호)
	
	public ArrayList<Book> getBook() {
		return book;
	}
	public void setBook(ArrayList<Book> book) {
		this.book = book;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public void lPrt() { // 책출력 취급도서 안내
		System.out.println(Location);
		for (int i=0; i<book.size(); i++) {
			if (book.get(i)!=null)
				book.get(i).bookPrt();
		}
	}
	public void bookOne() { // 책 한권찾기
		Scanner s = new Scanner(System.in);
		System.out.println("책 제목을 입력해주세요.");
		String title1 = s.nextLine();
		for (int i=0; i<book.size(); i++) { // List중
			if(book.get(i).getTitle().indexOf(title1)!=-1) { // 입력값과 동일한 제목이있다면
				book.get(i).bookPrt(); // 북리스트 해당 주소중 동일제목 책 출력
			}
		}
	}
	public void bookBorrowOne() { // 책한권 대여 분류기호 입력 맞을시 대여권한 넘어감
		Scanner s = new Scanner(System.in);
		System.out.println("책 제목을 입력해주세요.");
		String title1 = s.nextLine();
		boolean flag = true;
		while(flag) {
		for (int i=0; i<book.size(); i++) { // List중
			if(book.get(i).getTitle().indexOf(title1)!=-1) { // 입력값과 동일한 제목이있다면
				book.get(i).bookPrt(); // 북리스트 해당 주소중 동일제목 책 출력
				System.out.println("해당 책을 대여하시겠습니까?");
				System.out.println("1.대여 2.취소");
				int num = s.nextInt();
				s.nextLine();
					switch(num) {
					case 1: book.get(i).bookBorrow(); flag=false; break;
					default : flag = false;
					}
				}
			}
		}
	}
	public void bookReturnOne() { // 책한권 반납
		Scanner s = new Scanner(System.in);
		System.out.println("책 제목을 입력해주세요.");
		String title1 = s.nextLine();
		boolean flag = true;
		while(flag) {
		for (int i=0; i<book.size(); i++) { // List중
			if(book.get(i).getTitle().indexOf(title1)!=-1) { // 입력값과 동일한 제목이있다면
				book.get(i).bookPrt(); // 북리스트 해당 주소중 동일제목 책 출력
				System.out.println("해당 책을 대여하시겠습니까?");
				System.out.println("1.반납 2.취소");
				int num = s.nextInt();
				s.nextLine();
					switch(num) {
					case 1: book.get(i).bookReturnOne(); flag=false; break;
					default : flag = false;
					}
				}
			}
		}
	}
	public void bookMenu() { // 책등록 메뉴
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("1.책등록 2.등록책(보기) 3.뒤로가기");
			int num = s.nextInt();
			s.nextLine();
			switch(num) {
			case 1: setBook(); break;
			case 2: CbookPrt(); break;
			default : flag = false;
			}
		}
	}
	public void setBook() { // 책등록
		Scanner s = new Scanner(System.in);
		System.out.println("책 제목을 입력해주세요");
		String title = s.nextLine();
		Book book = new Book();
		book.setTitle(title);
		this.book.add(book);
	}
	public void CbookPrt() { // 관리자용 책등록 현황보기 
		for (int i=0; i<book.size(); i++) {
			if (book.get(i)!=null)
			System.out.println((i+1)+"."+book.get(i).getTitle());
		}
	}

}