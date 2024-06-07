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

    StudentBookissueFrame(ArrayList<String> bookList ) {
        this.setTitle("Library Book List");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLayout(new BorderLayout());

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
            JOptionPane.showMessageDialog(this,
                    "You have issued: " + selectedBook,
                    "Book Issued",
                    JOptionPane.INFORMATION_MESSAGE);

            listModel.remove(selectedIndex);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this,
                    "Please select a book to issue.",
                    "No Book Selected",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();

      //  new StudentBookissueFrame(books);
    }
}
