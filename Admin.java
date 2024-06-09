package LMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Admin extends JFrame implements ActionListener {
    ArrayList<String> booklist = new ArrayList<>();

    private JLabel adminActionCenterLabel;
    private  JLabel ClickLabel ;
    private JButton updateBookRecordButton;
    private JButton timelySubmissionsReportButton;
    private JButton lateSubmissionsButton;
    private  JButton logout ;
    JLabel topLabel;

    Admin(passwords obj){


        this.booklist = obj.booklist;
        this.setTitle("Admin Control Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 650);
        this.getContentPane().setBackground(new Color(0xFF675329, true));
        this.setLayout(null);
this.setSize(900,600);
this.setResizable(false);

        logout = new JButton("LOG OUT") ;
        logout.setBackground(new Color(0xE1A828));
        logout.setFont(new Font("Calibri", 1 , 18));
        logout.setBounds(700,10,150,18);
        logout.setFocusable(false);
        logout.addActionListener(this);

        topLabel = new JLabel("MCS | LIBRARY MANAGEMENT SYSTEM");
        topLabel.setFont(new Font("Courier New", Font.BOLD, 26));
        topLabel.setOpaque(true);
        topLabel.setBackground(new Color(25, 108, 148)); // Adjust color based on your preference
        topLabel.setForeground(Color.WHITE);
        topLabel.setBounds(75,0,500,20);




        // Admin action center label
        adminActionCenterLabel = new JLabel("Admin Control Panel");
        adminActionCenterLabel.setFont(new Font("Courier New", Font.BOLD, 28));
        adminActionCenterLabel.setOpaque(true);
        adminActionCenterLabel.setBackground(new Color(25, 108, 148)); // Adjust color based on your preference
        adminActionCenterLabel.setForeground(Color.WHITE);
        adminActionCenterLabel.setBounds(100,21,350,20);

        ClickLabel = new JLabel("Click To Perform Action  ");
        ClickLabel.setFont(new Font("Courier New", Font.BOLD, 28));
        ClickLabel.setOpaque(true);
        ClickLabel.setBackground(new Color(25, 108, 148)); // Adjust color based on your preference
        ClickLabel.setForeground(Color.WHITE);
        ClickLabel.setBounds(0,100,430,20);


        // Update the book record button
        updateBookRecordButton = new JButton("UPDATE THE BOOK RECORD");
        updateBookRecordButton.setFont(new Font("Consolas", Font.BOLD, 22));
        updateBookRecordButton.setBackground(new Color(211, 137, 190));
        updateBookRecordButton.setForeground(Color.DARK_GRAY);
        updateBookRecordButton.setBounds(20,175,300,24);
        updateBookRecordButton.addActionListener(this);
        // Late submissions button
        lateSubmissionsButton = new JButton("Late Submissions");
        lateSubmissionsButton.setFont(new Font("Consolas", Font.BOLD, 24));
        lateSubmissionsButton.setBackground(new Color(211, 137, 190));
        lateSubmissionsButton.setForeground(Color.DARK_GRAY);
       lateSubmissionsButton.setBounds(20,250,300,24);
        lateSubmissionsButton.addActionListener(this);

        timelySubmissionsReportButton = new JButton("Timely Submissions Report");
        timelySubmissionsReportButton.setFont(new Font("Consolas", Font.BOLD, 18));
        timelySubmissionsReportButton.setBackground(new Color(211, 137, 190));
        timelySubmissionsReportButton.setForeground(Color.DARK_GRAY);
        timelySubmissionsReportButton.setBounds(20,325,300,24);
        timelySubmissionsReportButton.addActionListener(this);

        this.add(logout);
        this.add(topLabel);
       this.add(adminActionCenterLabel);

        this.add(ClickLabel);
      this.add(updateBookRecordButton);
     this.add( timelySubmissionsReportButton);
     this.add(lateSubmissionsButton);
       this.setVisible(true);



    }

    public static void main(String[] args) {
        passwords a = new passwords();
        new Admin(a);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==updateBookRecordButton){
            new UpdateRecordFrame(booklist).setVisible(true);
            System.out.println("UpdatedRecordFrameOpened");
        } else if (e.getSource()==lateSubmissionsButton)
        {
 JOptionPane.showMessageDialog(null,"Late Submissions List is empty or All Books were returned on time.","Late Submissions",JOptionPane.PLAIN_MESSAGE);
        }else  if (e.getSource()==timelySubmissionsReportButton){
            new TimelyReturnedBooks(booklist).setVisible(true);
        } else if (e.getSource()==logout){
            this.dispose();
            new LoginFrame();
        }
    }

}
