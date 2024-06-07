package LMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    private static final String ICON_PATH = "C:\\Users\\AHTISHAM\\Desktop\\My_Workspace\\java_workspace\\Project\\icons\\loginbg.jpg";
    private JTextField userField;
    private JPasswordField passwordField;
    private JRadioButton radioButton;
    private JButton loginButton;

    public LoginFrame() {
        this.setTitle("Library Management System");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900, 500);
        this.getContentPane().setBackground(new Color(0x101077));

        // Creating the background panel with an image
        WelcomeBackgroundPanel loginPanel = new WelcomeBackgroundPanel(new ImageIcon(ICON_PATH).getImage());
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.pink);
        loginPanel.setOpaque(true);
        // Adding components
        initComponents(loginPanel);

        this.add(loginPanel);
        this.setVisible(true);
    }

    private void initComponents(JPanel panel) {
        JLabel jLabel1 = new JLabel("Library");
        jLabel1.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel1.setBounds(50, 150, 200, 30);
        panel.add(jLabel1);
panel.setBackground(new Color(0x666696));
        JLabel jLabel2 = new JLabel("Management");
        jLabel2.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel2.setBounds(50, 200, 200, 30);
        panel.add(jLabel2);

        JLabel jLabel3 = new JLabel("System");
        jLabel3.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel3.setBounds(50, 250, 200, 30);
        panel.add(jLabel3);

        JLabel jLabel5 = new JLabel("Username:");
        jLabel5.setBounds(300, 150, 100, 30);
        panel.add(jLabel5);

        userField = new JTextField();
        userField.setBounds(400, 150, 200, 30);
        panel.add(userField);

        JLabel jLabel6 = new JLabel("Password:");
        jLabel6.setBounds(300, 200, 100, 30);
        panel.add(jLabel6);

        passwordField = new JPasswordField();
        passwordField.setBounds(400, 200, 200, 30);
        panel.add(passwordField);

        JLabel jLabel7 = new JLabel("Check if student:");
        jLabel7.setBounds(300, 250, 100, 30);
        panel.add(jLabel7);

        radioButton = new JRadioButton("I'm a student");
        radioButton.setBounds(400, 250, 150, 30);
        radioButton.addActionListener(this);
        panel.add(radioButton);

        loginButton = new JButton("Login");
        loginButton.setBounds(400, 300, 100, 30);
        loginButton.addActionListener(this);
        panel.add(loginButton);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user,password;
        Boolean selection;
        if(e.getSource() == loginButton) {
          selection =  radioButton.isSelected();
            // Handle login button action
             user = userField.getText();
            password = passwordField.getText();
studentlogin thisstudent = new studentlogin(user,password,selection);  //creating an instance of student from user details and checking
            //if these details are correect
                thisstudent.authentication();
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }

    class WelcomeBackgroundPanel extends JPanel {
        private Image backgroundImage;

        public WelcomeBackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this);
        }
    }
}
