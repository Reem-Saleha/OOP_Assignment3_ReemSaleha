import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;

public class SendMailGUI {
    public static void main(String[] args) {
        // Create main frame
        JFrame frame = new JFrame("Email Sender");
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        
        JTextField fromField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField toField = new JTextField();
        JTextField subjectField = new JTextField();
        JTextArea messageArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(messageArea);

        inputPanel.add(new JLabel("From (email):"));
        inputPanel.add(fromField);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);
        inputPanel.add(new JLabel("To:"));
        inputPanel.add(toField);
        inputPanel.add(new JLabel("Subject:"));
        inputPanel.add(subjectField);
        inputPanel.add(new JLabel("Message:"));
        inputPanel.add(scrollPane);

        // Button panel
        JButton sendButton = new JButton("Send Email");
        sendButton.addActionListener(e -> sendEmail(
            fromField.getText(),
            new String(passwordField.getPassword()),
            toField.getText(),
            subjectField.getText(),
            messageArea.getText()
        ));

        // Add components to frame
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(sendButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private static void sendEmail(String from, String password, String to, 
                               String subject, String message) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

            Message email = new MimeMessage(session);
            email.setFrom(new InternetAddress(from));
            email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            email.setSubject(subject);
            email.setText(message);

            Transport.send(email);
            JOptionPane.showMessageDialog(null, "Email sent successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, 
                "Error sending email: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}