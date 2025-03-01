package main;

public class Book {
   private String title=null;  //책제목
   private String code=null;  //책 고유코드

 
   Book(String title, String location){
	   this.title=title;
	   this.code=location;
   }
   public void bookPrt() {
	   System.out.println(this.title);
       System.out.println(this.code);
	}
		
}
