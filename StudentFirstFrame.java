package LMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentFirstFrame extends JFrame implements ActionListener {
    // Creating a local copy of booklist
    public ArrayList<String> issuedBooks = new ArrayList<>();
    ArrayList<String> myBooks = new ArrayList<>();
//copy of TimelyreturnedBooks
    ArrayList<String> TimelyReturned = new ArrayList<>();
    ArrayList<String> bookList = new ArrayList<>();
    //components
    JLabel nameLabel, rankLabel, idLabel, courseLabel, studentAction;
    JButton bookIssueButton, returnBookButton, generateReportButton ,logout ;


    StudentFirstFrame(String name, String rank, String id, String course, ArrayList<String> bookList, ArrayList<String> issuedBooks, ArrayList<String> bookHistory, ArrayList<String> timelyReturned) {
       TimelyReturned =timelyReturned;
        this.bookList = bookList;
        this.issuedBooks = issuedBooks;
        this.setTitle("Welcome to E-Library " + name);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(900, 500);
        this.getContentPane().setBackground(new Color(0xA0A25A));
        this.setLayout(null);

        // Create labels with specified properties
        logout = new JButton("LOG OUT") ;
        logout.setBackground(new Color(0xE1A828));
        logout.setFont(new Font("Calibri", 1 , 18));
        logout.setBounds(700,10,150,18);
        logout.setFocusable(false);
        logout.addActionListener(this);

        nameLabel = new JLabel("Name: " + name);
        nameLabel.setForeground(Color.black);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setBounds(10, 10, 400, 24);

        courseLabel = new JLabel("Course: " + course);
        courseLabel.setBounds(10, 60, 250, 24);
        courseLabel.setForeground(Color.BLACK);
        courseLabel.setFont(new Font("Arial", Font.BOLD, 18));

        rankLabel = new JLabel("Rank: " + rank);
        rankLabel.setBounds(260, 60, 200, 24);
        rankLabel.setForeground(Color.BLACK);
        rankLabel.setFont(new Font("Arial", Font.BOLD, 18));

        idLabel = new JLabel("CMS ID: " + id);
        idLabel.setBounds(470, 60, 200, 24);
        idLabel.setForeground(Color.black);
        idLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Add labels to the frame
        this.add(nameLabel);
        this.add(courseLabel);
        this.add(rankLabel);
        this.add(idLabel);

        studentAction = new JLabel("Student Action Bar");
        studentAction.setFont(new Font("Arial", Font.BOLD, 24));
        studentAction.setBounds(10, 150, 300, 30);
        studentAction.setForeground(new Color(0x260456));

        // Add buttons to the frame
        bookIssueButton = new JButton("Issue a book");
        bookIssueButton.setForeground(Color.BLACK);
        bookIssueButton.setFont(new Font("Arial", Font.BOLD, 18));
        bookIssueButton.setBounds(10, 250, 200, 30);
        bookIssueButton.setBackground(new Color(0x7070B4));

        returnBookButton = new JButton("Return a Book");
        returnBookButton.setForeground(Color.BLACK);
        returnBookButton.setFont(new Font("Arial", Font.BOLD, 18));
        returnBookButton.setBounds(220, 250, 200, 30);
        returnBookButton.setBackground(new Color(0x7070B4));

        generateReportButton = new JButton("My BookShelf Report");
        generateReportButton.setForeground(Color.BLACK);
        generateReportButton.setFont(new Font("Arial", Font.BOLD, 18));
        generateReportButton.setBounds(460, 250, 230, 30);
        generateReportButton.setBackground(new Color(0x7070B4));

        this.setSize(900, 400);
        this.add(logout) ;
        this.setResizable(false);
        this.add(studentAction);
        this.add(bookIssueButton);
        this.add(returnBookButton);
        this.add(generateReportButton);

        bookIssueButton.addActionListener(this);
        returnBookButton.addActionListener(this);
        generateReportButton.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookIssueButton) {
            new StudentBookissueFrame(bookList,  issuedBooks,TimelyReturned);
        } else if (e.getSource() == returnBookButton) {
            new StudentReturnBookFrame(issuedBooks, this);
        } else if (e.getSource() == generateReportButton) {
            new StudentBookShelfReportFrame(issuedBooks);
        } else if (e.getSource()==logout) {
            new LoginFrame();
        }
    }

    public void updateIssuedBooks(ArrayList<String> issuedBooks) {
        this.issuedBooks = issuedBooks;
        // You can add additional logic here to refresh the UI or save data if needed
        System.out.println("Updated issued books: " + issuedBooks);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> issuedList = new ArrayList<>();
        ArrayList<String> historyList = new ArrayList<>();
        ArrayList<String> TimlyRtnd = new ArrayList<>();

        list.add("1984");
        list.add("To Kill a Mockingbird");
        list.add("The Great Gatsby");

        new StudentFirstFrame("Ahtisham", "NC", "DS", "ASE", list, issuedList, historyList, TimlyRtnd);
    }
}
