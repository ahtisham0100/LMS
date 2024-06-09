package LMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentBookissueFrame extends JFrame implements ActionListener {

    private DefaultListModel<String> listModel;
    private JList<String> bookList;
    private JButton issueBookButton;
    private ArrayList<String> borrowedBooks; // List to store borrowed books
    private ArrayList<String> timelyReturned; // Reference to the timelyReturned list

    // Constructor now accepts available books, borrowed books, and timelyReturned
    StudentBookissueFrame(ArrayList<String> bookList, ArrayList<String> borrowedBooks, ArrayList<String> timelyReturned) {
        this.setTitle("Library Book List");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        this.setLayout(new BorderLayout());

        this.borrowedBooks = borrowedBooks; // Initialize borrowedBooks
        this.timelyReturned = timelyReturned; // Initialize timelyReturned

        // Create a list model and add books to it
        listModel = new DefaultListModel<>();
        for (String book : bookList) {
            listModel.addElement(book);
        }

        // Create a JList and set the model
        this.bookList = new JList<>(listModel);
        this.bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.bookList.setVisibleRowCount(10);
        JScrollPane listScrollPane = new JScrollPane(this.bookList);

        // Create the issue button
        issueBookButton = new JButton("Issue Book");
        issueBookButton.addActionListener(this);

        // Add components to the frame
        this.add(listScrollPane, BorderLayout.CENTER);
        this.add(issueBookButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = bookList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedBook = bookList.getSelectedValue();
            // Add the selected book to the borrowedBooks list
            borrowedBooks.add(selectedBook);
            JOptionPane.showMessageDialog(this,
                    "You have issued: " + selectedBook,
                    "Book Issued",
                    JOptionPane.INFORMATION_MESSAGE);

            // Remove the issued book from the available books list
            listModel.remove(selectedIndex);

            // Update the timelyReturned list
            timelyReturned.add(selectedBook);  // Modify the timelyReturned list

            // Dispose the frame after issuing the book
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select a book to issue.",
                    "No Book Selected",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
