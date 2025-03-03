package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk { // 키오스크(모든업무처리) 자동화
	private ArrayList<User> user = new ArrayList<>(); // 도서관 회원목록
	private Location[] llist = new Location[5]; // 책보관대(도서분류기호) ex)철학,문학,과학,예술 등등
	private SeatOne[] slist = new SeatOne[20]; // 회원 도서관 도서실 자리배치
	
	
	public void kioskMenu() { // 키오스크 메인메뉴
		seatAdd(); // 자리상황 초반세팅 
		//setLocation(); // 도서일련번호 초반셋팅
		boolean flag = true;
		Scanner s = new Scanner(System.in);
		while(flag) {
			System.out.println("1.로그인 2.회원가입 3.책검색 4.도서관관리(관리자전용) 5.시스템종료");
			int a = s.nextInt();
			s.nextLine();
			switch(a) {
			case 1:login(); break; // 로그인
			case 2:addUser(); break; // 회원가입
			case 3:searchBookMenu(); break; // 책검색
			case 4:manager(); break; // 관리자권한
			default : System.out.println("시스템을 종료합니다"); flag=false;
			}
		}
	}
	public void login() { // 로그인
		Scanner s = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요");
		String id = s.nextLine();
		System.out.println("비밀번호를 입력해주세요");
		String pass = s.nextLine();
			for(User a : this.user) { 
				if(a!=null) {
					if(a.getId().equals(id) && a.getPass().equals(pass)) {
						boolean flag = true;
						while(flag) {
						System.out.println("1.자리관리 2.책대여관리 3.회원정보수정 4.회원탈퇴 5.로그아웃");
						int num = s.nextInt();
						switch(num) {
						case 1: seatM(); break; // 자리관리
						case 2: bookM(); break; // 책대여 관리
						case 3: changeUser(); break; //회원정보수정
						case 4: deleteUser(); break; // 회원탈퇴
						default : flag = false;
						}
					}
				}else if(a.getId()!=id && a.getPass()!=pass){
					System.out.println("등록되지않은 아이디입니다 메뉴로 돌아갑니다");
				}
			}
		}
	}
	public void searchBookMenu() {  //비회원 비로그인 책검색
		Scanner s = new Scanner(System.in);   
		boolean flag = true;
		while (flag) {
			System.out.println("1.책제목검색 2.전체보기 3.뒤로가기");
			int num=s.nextInt();
			s.nextLine();
			switch(num) {
			case 1:
				System.out.println("도서 분류기호를 입력해주세요");
				String location = s.nextLine();
				for (int i=0; i<llist.length; i++) {
					if(llist[i].getLocation().equals(location)) { //등록된 분류기호와 입력한 기호가 맞다면
						llist[i].bookOne(); // 해당분류기호에 bookOne메서드 진입
						break;
					}
				}break;
			case 2: 
				for (Location c : llist) {
					if(c!=null) {c.lPrt();}
				} break; default : flag = false;
			}
		}
	}
	public void bookM() { // 도서대여,반납 메뉴
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("1.도서대여 2.도서반납 3.뒤로가기");
			int num = s.nextInt();
			s.nextLine();
			switch(num) {
			case 1: bookBorrow(); break; // 도서대여
			case 2: bookReturn(); break; // 도서반납
			default : flag = false;
			}
		}
	}
	public void bookBorrow() { // 회원도서 (대여)
		Scanner s = new Scanner(System.in);
		System.out.println("대여할 도서분류 기호를 입력해주세요");
		System.out.println("ex)과학, 철학, 예술, 문학 등등");
		String location = s.nextLine();
		for (int i=0; i<llist.length; i++) {
			if(llist[i]!=null) {
				if(llist[i].getLocation().equals(location)) {
					llist[i].bookBorrowOne();
					break;
				}
			}
		}
	}
	public void bookReturn() { // 회원도서 (반납)
		Scanner s = new Scanner(System.in);
		System.out.println("대여할 도서분류 기호를 입력해주세요");
		System.out.println("ex)과학, 철학, 예술, 문학 등등");
		String location = s.nextLine();
		for (int i=0; i<llist.length; i++) {
			if(llist[i]!=null) {
				if(llist[i].getLocation().equals(location)) {
					llist[i].bookReturnOne();
					break;
				}
			}
		}
	}
	public void seatM() { // 회원 자리관리 메뉴
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("1.자리조회 2.자리등록 3.자리퇴실 4.뒤로가기");
			int num = s.nextInt();
			s.nextLine();
			switch(num) {
			case 1: seatLookUp(); break;
			case 2: seatGo(); break;
			case 3: seatOut(); break;
			default : flag = false;
			}
		}
	}
	public void seatAdd() { // 모든자리 "비어있음" 으로 프로그램 시작시 자동셋팅
		for(int i=0; i<this.slist.length; i++) {
			String seatone = "등록가능";
			int seatnum = i+1;
			SeatOne seatone1 = new SeatOne();
			seatone1.setSeatone(seatone);
			seatone1.setSeatnum(seatnum);
			slist[i]=seatone1;
		}
	}
	public void seatGo() { // 자리등록
		Scanner s = new Scanner(System.in);
		seatLookUp();
		System.out.println("원하는 자리의 숫자를 입력해주세요");
		int num = s.nextInt();
		s.nextLine();
		String a = "!등록불가!";
		for (int i=0; i<slist.length; i++) {
			if(num==slist[i].getSeatnum()) {
				slist[i].setSeatone(a);
			}
		}
	}
	public void seatOut() { // 자리퇴실
		Scanner s = new Scanner(System.in);
		String a = "!등록불가!";
		String b = "등록가능";
		System.out.println("퇴실할 본인의 자리번호를 입력해주세요");
		int num = s.nextInt();
		s.nextLine();
		for (int i=0; i<slist.length; i++) {
			if(slist[i].getSeatnum()==num) {
				if(slist[i].getSeatone().equals(a)) {
					slist[i].setSeatone(b);
					break;
				}
			}
		}
	}
	public void seatLookUp() { // 자리전체 조회
		for (int i=0; i<slist.length; i++) {
			slist[i].seatPrt();
		}
	}
	public void addUser() { // 회원가입
		Scanner s = new Scanner(System.in);
		System.out.println("id를 입력해주세요");
		String id = s.nextLine();
		System.out.println("pw를 입력하세요");
		String pass = s.nextLine();
		User user = new User(id,pass); // User자료타입을 참조하여 user변수에 id,pass객체주소를 대입
		this.user.add(user);
		System.out.println("회원가입이 완료되었습니다");
	}
	public void deleteUser() { //회원 탈퇴
		Scanner s = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요");
		String id = s.nextLine();
		System.out.println("비밀번호를 입력해주세요");
		String pass = s.nextLine();
		for(User a : this.user) { 
			if(a.getId().equals(id) && a.getPass().equals(pass)) {
				a.setId(null);
				a.setPass(null);
				System.out.println("회원이 탈퇴되었습니다");
			}else {
				System.out.println("없는 회원정보 입니다 메뉴로 돌아갑니다");
			}
			break;
		}
		
	}
	public void changeUser() { // 아이디,비밀번호 변경
		Scanner s = new Scanner(System.in);
		System.out.println("기존 아이디를 입력해주세요");
		String id = s.nextLine();
		System.out.println("기존 비밀번호를 입력해주세요");
		String pass = s.nextLine();
		for(User a : this.user) { 
			if(a.getId().equals(id) && a.getPass().equals(pass)) {
				System.out.println("변경할 아이디를 입력해주세요");
				String id1 = s.nextLine();
				a.setId(id1);
				System.out.println("변경할 비밀번호를 입력해주세요");
				String pass1 =s.nextLine();
				a.setPass(pass1);
				System.out.println("회원 아이디,비밀번호가 변경되었습니다");
			}else if(a.getId()!=id || a.getPass()!=pass) {
			System.out.println("입력하신 회원정보가 틀렸습니다");
		
			}break;
		}
	}
	public void manager() { // 관리자권한
		Scanner s = new Scanner(System.in);
		System.out.println("관리자 아이디를 입력하세요");
		String id = s.nextLine();
		Manager manager = new Manager();
		Location location = new Location();
		if (id.equals(manager.id)) { // 입력한 관리자 id 저장된 관리자 id가 같을시 
			boolean flag = true;
			while(flag) {
				System.out.println("1.분류기호등록(도서등록전 필수등록) 2.도서(등록) 3.전체보기 4.나가기");
				int num = s.nextInt();
				s.nextLine();
				switch(num) {
				case 1: lOne(); break;
				case 2: bookAdd(); break;
				case 3: lPrt();  break;
				default : flag = false;
				}
			}
		}else {
			System.out.println("입력한 아이디가 존재하지 않습니다 메뉴로 돌아갑니다");
		}
	}
	public void lOne() { //분류기호 등록
		Scanner s = new Scanner(System.in);
		System.out.println("분류기호를 입력해주세요 최대 5개 등록가능");
		System.out.println("ex) 철학 or 경제 or 과학등 양식에 알맞게 작성하시오");
		Location location = new Location();
		String a = s.nextLine();
		location.setLocation(a);
		for (int i=0; i<llist.length; i++) {
			if(llist[i]==null) {
				llist[i]=location;
				break;
			}
		}
	}
	public void bookAdd() { // 도서등록
		Scanner s = new Scanner(System.in);
		System.out.println("등록된 분류기호를 입력하세요");
		System.out.println("!! 도서 분류기호를 등록하지 않았다면 분류기호부터 등록해주세요 !!");
		String a = s.nextLine();
		for (int i=0; i<llist.length; i++) {
			if (llist[i]!=null) {
				if(llist[i].getLocation().indexOf(a)!=-1) { //	//llist[i] 주소에 반환값이 a의 반환값중 -1 값이 같지않을때 반환값 인덱스모두같고 -1인덱스는 없음으로 무조건 false
					llist[i].bookMenu(); // 해당도서 분류의 도서를 등록하는 메서드로 진입
					break;
				}
			}else if(llist[i]==null) {
				System.out.println("등록된 도서 분류기호가 없습니다 등록바랍니다");
				break;
			}
		}
	}
	public void lPrt() { // 관리자 책등록후 등록된 책확인 기능
		for (Location c : llist) {
			if(c!=null) {
				c.lPrt();
			}
		}
	}
}