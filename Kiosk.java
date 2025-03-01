package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Kiosk {
	private ArrayList<User> user = new ArrayList<>();
	private HashMap<Location, Book> bookList = new HashMap<>();
	private SeatOne[] seat = new SeatOne[30];
	
	public void searchBook() {  //책검색
		Scanner s = new Scanner(System.in);   
		boolean flag = true;
		while (flag) {
			System.out.println("1.책검색  2.전체보기");
			int num=s.nextInt();
			switch(num) {
			case 1:
				System.out.println("책 제목을 입력해주세요.");
				String title1 = s.nextLine();
				if(bookList.get(key)==title1) { //HasgMap에서 뽑아쓰는거 <--- 알아보고 적용시키는거 우선으로 작업하기
					
				}
			case 2: 
			}
		}
	}
	public void kioskMenu() { // 키오스크 메인메뉴
		seatAdd(); // 자리상황 초반세팅 
		boolean flag = true;
		Scanner s = new Scanner(System.in);
		while(flag) {
			System.out.println("1.로그인 2.회원가입 3.책검색 4.책등록(관리자로그인필요)");
			int a = s.nextInt();
			s.nextLine();
			switch(a) {
			case 1:login(); break; // 로그인
			case 2:addUser(); break; // 회원가입
			case 3:searchBook(); break; // 책검색
			case 4:addBook(); break; // 책등록
			default : flag=false;
			}
		}
	}
	public void login() { // 로그인
		Scanner s = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요");
		String id = s.nextLine();
		System.out.println("비밀번호를 입력해주세요");
		String pass = s.nextLine();
		User user = new User(id,pass);
		for(User a : this.user) { 
			if(user.getId()==id) {
				boolean flag = true;
				System.out.println("1.자리등록 2.책대여 3.책반납 4.책검색");
				while(flag) {
					int num = s.nextInt();
					switch(num) {
					case 1: 
					case 2:
					case 3:
					}
				}
			}
		}
	}
	public void seatAdd() { // 자리상황 초반 세팅
		for(int i=1; i<this.seat.length+1; i++) {
			int seatNum = i;
			String seat = "비어있음";
			SeatOne seatone = new SeatOne(seatNum,seat);
			this.seat[i]=seatone;
		}
	}
	/*public void seatLook() { // 전체 자리상황 조회
		for(int i=1; i<this.seat.length+1; i++) {
			if(seat[i]==null) {
				
			}
		}
	}*/
	
	public void addUser() { // 회원가입
		Scanner s = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요");
		String id = s.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pass = s.nextLine();
		User user = new User(id,pass); // User자료타입을 참조하여 user변수에 id,pass객체주소를 대입
		this.user.add(user);
	}
	public void addBook() { // 책등록
		Scanner s = new Scanner(System.in);
		System.out.println("관리자 아이디를 입력하세요");
		String id = s.nextLine();
		Manager manager = new Manager();
		if (id.equals(manager.id)) {
			System.out.println("책 제목을 입력하세요");
			String title = s.nextLine();
			System.out.println("책 코드를 입력하세요");
			String code = s.nextLine();
			System.out.println("책 자리번호를 입력하세요");
			String location1 = s.nextLine();
			Book book = new Book (title, code);
			Location location = new Location(location1);
			bookList.put(location, book);
			System.out.println("책이 등록되었습니다");
		}
	}
	public void deleteUser() { //회원 탈퇴
		Scanner s = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요");
		String id = s.nextLine();
		System.out.println("비밀번호를 입력해주세요");
		String pass = s.nextLine();
		User user = new User(id,pass);
		for(User a : this.user) { 
			if(user.getId()==id) {
			
			}
		}
	}
}
