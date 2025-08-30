import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class loginSignup extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public loginSignup() {
        setTitle("XYZ Portal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createLoginPanel(), "Login");

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(233, 30, 99),
                        getWidth(), getHeight()/2, new Color(155, 89, 182));
                g2d.setPaint(gp);

                Path2D.Double path = new Path2D.Double();
                path.moveTo(0, 0);
                path.lineTo(0, 200);
                path.curveTo(getWidth()/4.0, 300, getWidth()*3/4.0, 100, getWidth(), 200);
                path.lineTo(getWidth(), 0);
                path.closePath();
                g2d.fill(path);
            }
        };
        panel.setLayout(new GridBagLayout());

        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(Color.WHITE);
        card.setPreferredSize(new Dimension(400, 350));
        card.setBorder(new CompoundBorder(
                new EmptyBorder(20, 20, 20, 20),
                new LineBorder(new Color(230, 230, 230), 1, true)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel logo = new JLabel("XYZ UNIVERSITY", JLabel.CENTER);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        logo.setForeground(new Color(52, 52, 52));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        card.add(logo, gbc);

       
        JRadioButton studentBtn = new JRadioButton("STUDENT LOGIN");
        JRadioButton parentBtn = new JRadioButton("PARENT LOGIN");
        ButtonGroup group = new ButtonGroup();
        group.add(studentBtn);
        group.add(parentBtn);
        studentBtn.setSelected(true);

        studentBtn.setBackground(Color.WHITE);
        parentBtn.setBackground(Color.WHITE);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        radioPanel.setBackground(Color.WHITE);
        radioPanel.add(studentBtn);
        radioPanel.add(parentBtn);

        gbc.gridy = 1; gbc.gridwidth = 2;
        card.add(radioPanel, gbc);

        JLabel sysIdLabel = new JLabel("SYSTEM ID");
        sysIdLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        JTextField sysIdField = new JTextField(12);
        styleTextField(sysIdField);

        JButton otpBtn = new JButton("OTP");
        styleSmallButton(otpBtn, new Color(0, 180, 100));

        JPanel sysPanel = new JPanel(new BorderLayout(5, 5));
        sysPanel.setBackground(Color.WHITE);
        sysPanel.add(sysIdField, BorderLayout.CENTER);
        sysPanel.add(otpBtn, BorderLayout.EAST);

        gbc.gridy = 2; gbc.gridx = 0; gbc.gridwidth = 1;
        card.add(sysIdLabel, gbc);
        gbc.gridx = 1;
        card.add(sysPanel, gbc);

        JLabel otpLabel = new JLabel("OTP");
        otpLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        JTextField otpField = new JTextField(15);
        styleTextField(otpField);

        gbc.gridy = 3; gbc.gridx = 0;
        card.add(otpLabel, gbc);
        gbc.gridx = 1;
        card.add(otpField, gbc);

        JButton loginBtn = new JButton("Login");
        styleButton(loginBtn, new Color(233, 30, 99));

        gbc.gridy = 4; gbc.gridx = 0; gbc.gridwidth = 2;
        card.add(loginBtn, gbc);

        JLabel homeLink = new JLabel("<HTML>Go to <U>Home</U></HTML>", JLabel.CENTER);
        homeLink.setForeground(new Color(233, 30, 99));
        homeLink.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        homeLink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gbc.gridy = 5; gbc.gridwidth = 2;
        card.add(homeLink, gbc);

        panel.add(card);
        return panel;
    }

    private void styleTextField(JTextField field) {
        field.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(200, 200, 200)));
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBackground(Color.WHITE);
    }

    private void styleButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBorder(new EmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void styleSmallButton(JButton button, Color bgColor) {
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBorder(new EmptyBorder(5, 12, 5, 12));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(loginSignup::new);
    }
}
