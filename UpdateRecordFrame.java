package LMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateRecordFrame extends JFrame {
    private JPanel mainPanel;
    private JList<String> bookList;
    private DefaultListModel<String> bookListModel;
    private JButton addButton;
    private JButton deleteButton;
    private JTextField bookTextField;
    private ArrayList<String> books;

    public UpdateRecordFrame(ArrayList<String> books) {
        this.books = books;

        setTitle("Update Record");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Initialize the book list model and JList
        bookListModel = new DefaultListModel<>();
        for (String book : books) {
            bookListModel.addElement(book);
        }
        bookList = new JList<>(bookListModel);
        JScrollPane scrollPane = new JScrollPane(bookList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Initialize the text field and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        bookTextField = new JTextField(20);
        addButton = new JButton("Add Book");
        deleteButton = new JButton("Delete Selected Book");
        inputPanel.add(bookTextField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // Add action listeners to the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newBook = bookTextField.getText();
                if (!newBook.isEmpty()) {
                    addBook(newBook);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = bookList.getSelectedIndex();
                if (selectedIndex != -1) {
                    deleteBook(selectedIndex);
                }
            }
        });

        // Set the content pane and make the frame visible
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
    }

    private void addBook(String book) {
        books.add(book);
        bookListModel.addElement(book);
        bookTextField.setText("");
    }

    private void deleteBook(int index) {
        books.remove(index);
        bookListModel.remove(index);
    }

    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();
        books.add("1984");
        books.add("To Kill a Mockingbird");
        books.add("The Great Gatsby");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UpdateRecordFrame frame = new UpdateRecordFrame(books);
                frame.setVisible(true);
            }
        });
    }
}
