package LMS;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TimelyReturnedBooks extends JFrame {
    private JPanel mainPanel;
    private JList<String> bookList;
    private DefaultListModel<String> bookListModel;
    private ArrayList<String> timelyReturnedBooks;

    public TimelyReturnedBooks(ArrayList<String> timelyReturnedBooks ) {
        this.timelyReturnedBooks = timelyReturnedBooks;

        setTitle("Timely Returned Books");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Initialize the book list model and JList
        bookListModel = new DefaultListModel<>();
        for (String book : timelyReturnedBooks) {
            bookListModel.addElement(book);
        }
        bookList = new JList<>(bookListModel);
        JScrollPane scrollPane = new JScrollPane(bookList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Set the content pane and make the frame visible
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        ArrayList<String> timelyReturnedBooks = new ArrayList<>();
        timelyReturnedBooks.add("1984");
        timelyReturnedBooks.add("To Kill a Mockingbird");
        timelyReturnedBooks.add("The Great Gatsby");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TimelyReturnedBooks frame = new TimelyReturnedBooks(timelyReturnedBooks);
                frame.setVisible(true);
            }
        });
    }
}
