package LMS;


import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class BookListFrame extends JFrame {
    private JList<String> bookList;
    private JButton issueBookButton;

    private DefaultListModel<String> listModel;

    BookListFrame(ArrayList<String> books) {
        this.setTitle("Library Book List");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLayout(new BorderLayout());

        // Create a list model and add books to it
        listModel = new DefaultListModel<>();
        for (String book : books) {
            listModel.addElement(book);
        }

        // Create a JList and set the model
        bookList = new JList<>(listModel);
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bookList.setVisibleRowCount(10);
        JScrollPane listScrollPane = new JScrollPane(bookList);

        // Create the issue button
        issueBookButton = new JButton("Issue Book");
        issueBookButton.addActionListener(new IssueBookButtonListener());

        // Add components to the frame
        this.add(listScrollPane, BorderLayout.CENTER);
        this.add(issueBookButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private class IssueBookButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = bookList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedBook = bookList.getSelectedValue();
                JOptionPane.showMessageDialog(BookListFrame.this,
                        "You have issued: " + selectedBook,
                        "Book Issued",
                        JOptionPane.INFORMATION_MESSAGE);
                listModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(BookListFrame.this,
                        "Please select a book to issue.",
                        "No Book Selected",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();
        books.add("The Catcher in the Rye");
        books.add("To Kill a Mockingbird");
        books.add("1984");
        books.add("Pride and Prejudice");
        books.add("The Great Gatsby");

        new BookListFrame(books);
    }
}
