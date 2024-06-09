package LMS;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentBookShelfReportFrame extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> bookShelfList;

    // Constructor accepts issued books
    StudentBookShelfReportFrame(ArrayList<String> issuedBooks) {
        this.setTitle("My BookShelf Report");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        this.setLayout(new BorderLayout());

        // Create a list model and add issued books to it
        listModel = new DefaultListModel<>();
        for (String book : issuedBooks) {
            listModel.addElement(book);
        }

        // Create a JList and set the model
        this.bookShelfList = new JList<>(listModel);
        this.bookShelfList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.bookShelfList.setVisibleRowCount(10);
        JScrollPane listScrollPane = new JScrollPane(this.bookShelfList);

        // Add components to the frame
        this.add(listScrollPane, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
