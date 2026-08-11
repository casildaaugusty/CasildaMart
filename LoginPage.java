import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {

    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();

    public LoginPage() {

        setTitle("DhanyaMart - Login");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title
        JLabel title = new JLabel("DHANYAMART");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(110, 20, 200, 40);
        add(title);

        // Username
        addLabel("Username:", 50, 90);
        usernameField.setBounds(150, 90, 180, 30);
        add(usernameField);

        // Password
        addLabel("Password:", 50, 135);
        passwordField.setBounds(150, 135, 180, 30);
        add(passwordField);

        // Buttons
        JButton loginButton = createButton("Login", 50, 200);
        JButton clearButton = createButton("Clear", 155, 200);
        JButton exitButton = createButton("Exit", 260, 200);

        loginButton.addActionListener(e -> login());
        clearButton.addActionListener(e -> clearFields());
        exitButton.addActionListener(e -> System.exit(0));

        add(loginButton);
        add(clearButton);
        add(exitButton);

        setVisible(true);
    }

    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 100, 30);
        add(label);
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 90, 30);
        return button;
    }

    private void login() {

        String username = usernameField.getText().trim();
        String password = String.valueOf(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter username and password."
            );
            return;
        }

        if (username.equals("admin") && password.equals("1234")) {
            JOptionPane.showMessageDialog(
                this,
                "Login Successful!\nWelcome to DhanyaMart."
            );
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Invalid Username or Password.",
                "Login Failed",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        usernameField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginPage::new);
    }
}