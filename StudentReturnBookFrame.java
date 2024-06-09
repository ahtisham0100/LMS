package LMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentReturnBookFrame extends JFrame implements ActionListener {

    private DefaultListModel<String> listModel;
    private JList<String> issuedBookList;
    private JButton returnBookButton;
    private ArrayList<String> issuedBooks; // List to store issued books
    private StudentFirstFrame mainFrame; // Reference to the main frame

    // Constructor now accepts issued books and the main frame
    StudentReturnBookFrame(ArrayList<String> issuedBooks, StudentFirstFrame mainFrame) {
        this.setTitle("Return Book");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        this.setLayout(new BorderLayout());

        this.issuedBooks = issuedBooks; // Initialize issuedBooks
        this.mainFrame = mainFrame; // Initialize mainFrame

        // Create a list model and add books to it
        listModel = new DefaultListModel<>();
        for (String book : issuedBooks) {
            listModel.addElement(book);
        }

        // Create a JList and set the model
        this.issuedBookList = new JList<>(listModel);
        this.issuedBookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.issuedBookList.setVisibleRowCount(10);
        JScrollPane listScrollPane = new JScrollPane(this.issuedBookList);

        // Create the return button
        returnBookButton = new JButton("Return Book");
        returnBookButton.addActionListener(this);

        // Add components to the frame
        this.add(listScrollPane, BorderLayout.CENTER);
        this.add(returnBookButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = issuedBookList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedBook = issuedBookList.getSelectedValue();
            // Remove the selected book from the issuedBooks list
            /*
            code to add booktoTimelyReturnedHere
            */
            issuedBooks.remove(selectedBook);
            JOptionPane.showMessageDialog(this,
                    "You have returned: " + selectedBook,
                    "Book Returned",
                    JOptionPane.INFORMATION_MESSAGE);

            // Remove the returned book from the list model
            listModel.remove(selectedIndex);

            // Update the issued books list in the main frame
            mainFrame.updateIssuedBooks(issuedBooks);

            // Dispose the frame after returning the book
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select a book to return.",
                    "No Book Selected",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
