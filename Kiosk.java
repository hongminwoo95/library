package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Kiosk {
	private ArrayList<User> user = new ArrayList<>();
	private HashMap<Location, Book> bookList = new HashMap<>();
	private SeatOne[] seat = new SeatOne[100];
	
	
	public void seatLook() {
		for(int i=1; i<this.seat.length+1; i++) {
			
		}
	}
	public void seatAdd() {
		SeatOne seatOne = new SeatOne();
		for(int i=1; i<this.seat.length+1; i++) {
			if(seat[i]==null) {
				
			}
		}
	}
	public void login() {
		Scanner s = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요");
		String id = s.nextLine();
		System.out.println("비밀번호를 입력해주세요");
		String pass = s.nextLine();
		User user = new User(id,pass);
		for(User a : this.user) { 
			if(user.getId()==id) {
				boolean flag = true;
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
	
	public void kioskMenu() {
		 boolean flag = true;
		 Scanner s = new Scanner(System.in);
	       while(flag) {
	         System.out.println("1.로그인 2.회원가입 3.책검색 4.책등록(관리자로그인필요)");
	         int a = s.nextInt();
	         s.nextLine();
		         switch(a) {
		         case 1:login(); break; // 각자 넣을거 넣으세요 틀 바꾸거나 고치고 싶으면 고쳐서 올려주세요
		         case 2:addUser(); break;
		         case 3:searchBook(); break;
		         case 4:addBook(); break;
		         default : flag=false;
		         }
	       }
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
			System.out.println("책이 등록되었습니다");
		}
	}
	public void addUser() {
		Scanner s = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요");
		String id = s.nextLine();
		System.out.println("비밀번호를 입력하세요");
		
		
		String pass = s.nextLine();
		User user = new User(id,pass);
		this.user.add(user);
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
	
	public void searchBook() {  //책검색
	     Scanner s = new Scanner(System.in);   
	     boolean flag = true;
		     while (flag) {
		     System.out.println("1.검색  2.전체보기");
		     int num=s.nextInt();
		     switch(num) {
		     case 1:
			     System.out.println("검색어를 입력해주세요.");
		         String search=s.nextLine();
		         
		     case 2: 
		    	
		   
		     
		     }
		    }
	}
}
