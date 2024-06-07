package LMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentFirstFrame extends JFrame implements ActionListener {
    //creating a local copy of booklist
 public ArrayList<String> issuedbooks = new ArrayList<>();
    ArrayList<String> Mybooks = new ArrayList();

    public void addtoissuedbooks(String s ){
        issuedbooks.add(s);
    }

    ArrayList Booklist = new ArrayList();
    JLabel namelabel, ranklabel, idlabel, courselabel, studentaction;
    JButton bookIssueButton, returnbookButton, generatereportButtom;

    StudentFirstFrame(String name, String rank, String id, String course , ArrayList booklist) {
       this.Booklist=booklist;
        this.setTitle("Welcome to E-Library " + name);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(900, 500);
        this.getContentPane().setBackground(new Color(0xA0A25A));
        this.setLayout(null);

        // Create labels with specified properties
        namelabel = new JLabel("Name: " + name);
        namelabel.setForeground(Color.black);
        namelabel.setFont(new Font("Arial", Font.BOLD, 18));
        namelabel.setBounds(10, 10, 400, 24);

        courselabel = new JLabel("Course: " + course);
        courselabel.setBounds(10, 60, 250, 24);
        courselabel.setForeground(Color.BLACK);
        courselabel.setFont(new Font("Arial", Font.BOLD, 18));

        ranklabel = new JLabel("Rank: " + rank);
        ranklabel.setBounds(260, 60, 200, 24);
        ranklabel.setForeground(Color.BLACK);
        ranklabel.setFont(new Font("Arial", Font.BOLD, 18));

        idlabel = new JLabel("CMS ID: " + id);
        idlabel.setBounds(470, 60, 200, 24);
        idlabel.setForeground(Color.black);
        idlabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Add labels to the frame
        this.add(namelabel);
        this.add(courselabel);
        this.add(ranklabel);
        this.add(idlabel);

        studentaction = new JLabel("Student Action Bar");
        studentaction.setFont(new Font("Arial", Font.BOLD, 24));
        studentaction.setBounds(10, 150, 300, 30);
        studentaction.setForeground(new Color(0x260456));
        // Add buttons to the frame
        bookIssueButton = new JButton("Issue a book");

        bookIssueButton.setForeground(Color.BLACK);
        bookIssueButton.setFont(new Font("Arial", Font.BOLD, 18));
        bookIssueButton.setBounds(10, 250, 200, 30);
bookIssueButton.setBackground(new Color(0x7070B4));

        returnbookButton = new JButton("Return a Book");
        returnbookButton.setForeground(Color.BLACK);
        returnbookButton.setFont(new Font("Arial", Font.BOLD, 18));
        returnbookButton.setBounds(220, 250, 200, 30);
        returnbookButton.setBackground(new Color(0x7070B4));

        generatereportButtom = new JButton("My BookShelf Report");
        generatereportButtom.setForeground(Color.BLACK);
        generatereportButtom.setFont(new Font("Arial", Font.BOLD, 18));
        generatereportButtom.setBounds(460, 250, 230, 30);
        generatereportButtom.setBackground(new Color(0x7070B4));
        this.setSize(800,400);
        this.setResizable(false);
        this.add(studentaction);
        this.add(bookIssueButton);
        this.add(returnbookButton);
        this.add(generatereportButtom);
bookIssueButton.addActionListener(this);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==bookIssueButton){
            new StudentBookissueFrame(Booklist) ;

        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("a");
        list.add("b");

        list.add("a");
        list.add("b");
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("b");
        new StudentFirstFrame("ahtisham","nc","ds","ase",list);
    }
}
