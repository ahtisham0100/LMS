package LMS;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

class passwords extends HashMap {

   public ArrayList<String> booklist = new ArrayList<>();
   private HashMap<String,String>  admin;
   private  HashMap<String,String> student;
   Boolean loogingin;

   ArrayList<String> TimelyReturned = new ArrayList<>();

public  void addtoTimelyRetuned(String s ){
    TimelyReturned.add(s);

}

   //contructor
    passwords() {
        admin = new HashMap<>();
        student = new HashMap<>();
        admin.put("muhammad","password");
        admin.put("alikhan","password");

        student.put("ahtisham","ahtisham123");
        student.put("muhammad", "muhammad123");

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

    //autherticating if in setudent frame value are ahtisham and ahtisham123
    public Boolean studentkey(String user , String password){
        return student.containsValue(password) &&student.containsKey(user);
     }

     public void authentication(String user, String password , boolean selection)
     {

         if (selection !=true) {

             authenticateAdmin(user,  password);
         }
         else {
             authenticateStudent(user, password);
         }
     }

    public void authenticateStudent(String key, String password){
        if (student.containsKey(key)&&student.containsValue(password)){
            Student studentobj = new Student(key,password,booklist,TimelyReturned);
            JOptionPane.showMessageDialog(null,"login successful as student ","login",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,"Enter correct credentials","login erroe",JOptionPane.ERROR_MESSAGE);
        }
    }
     public void authenticateAdmin(String key, String password){
         if (admin.containsKey(key)&&admin.containsValue(password)){
           JOptionPane.showMessageDialog(null,"login successful as admin" ,"login",JOptionPane.INFORMATION_MESSAGE);
             new Admin(this);

         } else {
             JOptionPane.showMessageDialog(null,"Enter correct credentials","login erroe",JOptionPane.ERROR_MESSAGE);
         }
     }
}


//initialzied this class inside loging frame to  authentocate   not limimted to student login though name is student login
class studentlogin extends passwords {
    String user, password;
    Boolean loogingin;

    ArrayList<String> TimelyRetunedBooks = new ArrayList<>();

public void addtoTimelyReturned (String s ){

}

    studentlogin(String user, String password, Boolean loogingin) {
        this.loogingin = loogingin;
        this.password = password;
        this.user = user;
    }

    public void authentication()
    {

        if (this.loogingin !=true) {

                super.authenticateAdmin(this.user, this.password);
            }
         else {
                super.authenticateStudent(this.user, this.password);
            }
        }
    }


class Student extends passwords{
     String name ,course , rank , id ;
    ArrayList<String> issuedBooks =  new ArrayList();
    ArrayList<String> Bookhistory =  new ArrayList();

    public void AddToIssuedlist(String s ){
        issuedBooks.add(s) ;

    }

    public void removeFromIssedList(){
        issuedBooks.remove(this) ;
    }

    public void AddtoBookHistory(String book){
        Bookhistory.add(book);
    }




      Student(String user, String password, ArrayList booklist, ArrayList<String> timelyReturned){
          passwords a = new passwords();

          if ( user.equals("ahtisham")&&password.equals("ahtisham123")){
              this.name="Muhammad Ahtisham Arif";
                      this.course= "BESE-29C";
                      this.rank ="NC";
                              this.id ="460540";
          new StudentFirstFrame(this.name,this.rank, this.id, this.course , booklist , issuedBooks,Bookhistory ,TimelyReturned);
          } else {
              this.name="Muhammad Saad";
              this.course= "BEIS-4";
              this.rank ="PC";
              this.id ="12014";
              new StudentFirstFrame(this.name,this.rank, this.id, this.course,booklist,issuedBooks,Bookhistory, TimelyReturned);
          }
      }
}







public class Main {

    public static void main(String[] args) {

    }
}
