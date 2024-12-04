import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class JavaELearningSystem {
    public static void main(String[] args) {

        JFrame frame = new JFrame("JAVA E-Learning System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);  

        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, 400, 50);
        titlePanel.setBackground(new Color(0, 102, 204)); 
        JLabel titleLabel = new JLabel("JAVA E-Learning System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        frame.add(titlePanel);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBounds(50, 80, 300, 200);
        centerPanel.setBackground(new Color(240, 240, 240)); 

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 80, 30);
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField userField = new JTextField();
        userField.setBounds(110, 20, 170, 30);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 70, 80, 30);
        passLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JPasswordField passField = new JPasswordField();
        passField.setBounds(110, 70, 170, 30);

        JButton connectButton = new JButton("Connect");
        connectButton.setBounds(110, 120, 170, 40);
        connectButton.setBackground(new Color(0, 204, 102)); 
        connectButton.setForeground(Color.WHITE);
        connectButton.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel resultLabel = new JLabel("", JLabel.CENTER);
        resultLabel.setBounds(20, 170, 260, 30);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        centerPanel.add(userLabel);
        centerPanel.add(userField);
        centerPanel.add(passLabel);
        centerPanel.add(passField);
        centerPanel.add(connectButton);
        centerPanel.add(resultLabel);
        frame.add(centerPanel);

        // Action listener for connect button
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                try {
                    // Use DBConnection class to connect
                    System.out.println(username + " " + password);
                    Connection connection = DBConnection.connect(username, password);
                    System.out.println(connection);
                    if (connection != null) {
                        resultLabel.setText("Connected successfully!");
                        resultLabel.setForeground(Color.GREEN);
                    }
                } catch (Exception ex) {
                    resultLabel.setText("Connection failed!");
                    resultLabel.setForeground(Color.RED);
                }
            }
        });

        // Set the background color for the whole frame
        frame.getContentPane().setBackground(new Color(245, 245, 245)); // Light background

        // Display the frame
        frame.setVisible(true);
    }
}
