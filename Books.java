package LMS;

import java.util.ArrayList;

public class Books {
    public ArrayList<String> booklist = new ArrayList<>();

    Books(){
        booklist.add("Pride and Prejuduce");
        booklist.add("THE TALES OF SHEIKH SAADI");
        booklist.add("HIKAYAT ROOMI");
        booklist.add("OLIVER TWIST");
        booklist.add("DIGITAL FUNDAMENTALS");
        booklist.add("THE FUNDAMENTALS OF PROGRAMMIG");
        booklist.add("Around the world in eighty days");
        booklist.add("HIKAYAT ROOMI");
        booklist.add("OLIVER TWIST");
        booklist.add("DIGITAL FUNDAMENTALS");
        booklist.add("THE FUNDAMENTALS OF PROGRAMMIG");
        booklist.add("HIKAYAT ROOMI");
        booklist.add("OLIVER TWIST");
        booklist.add("DIGITAL FUNDAMENTALS");
        booklist.add("THE FUNDAMENTALS OF PROGRAMMIG");
    }


    public void removebook(){
        booklist.remove(this) ;
    }
    public  void addbook(String s){
        booklist.add(s);
    }

public void printBooklist(){
    for (int i = 0;  ; i++) {

    }
}

}
