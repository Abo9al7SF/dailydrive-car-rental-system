import java.awt.*;
import java.util.List;
import javax.swing.*;

public class CarRentalSystem {
    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }
}

class LoginFrame extends JFrame {
    private JPanel rightPanel;
    private CardLayout rightCardLayout;
    private JTextField loginUserField, registerUserField;
    private JPasswordField loginPassField, registerPassField;

    public LoginFrame() {
        setTitle("Car Rental System - Log In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0xFAEBEF));
        leftPanel.setPreferredSize(new Dimension(250, 400));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        try {
            ImageIcon icon = new ImageIcon("image.png");
            Image img = icon.getImage().getScaledInstance(320, 200, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(img));
            logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            logoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            leftPanel.add(logoLabel);
        } catch (Exception ex) {}

        leftPanel.add(Box.createVerticalGlue());

        JButton loginNavBtn = new JButton("Log In");
        loginNavBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginNavBtn.setBackground(new Color(0x333D79));
        loginNavBtn.setForeground(new Color(0xFAEBEF));
        loginNavBtn.setFont(new Font("Arial", Font.BOLD, 16));
        loginNavBtn.setFocusPainted(false);
        loginNavBtn.setMaximumSize(new Dimension(160, 40));
        leftPanel.add(loginNavBtn);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        JButton registerNavBtn = new JButton("Register");
        registerNavBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerNavBtn.setBackground(new Color(0xFAEBEF));
        registerNavBtn.setForeground(new Color(0x333D79));
        registerNavBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        registerNavBtn.setFocusPainted(false);
        registerNavBtn.setMaximumSize(new Dimension(160, 40));
        leftPanel.add(registerNavBtn);

        leftPanel.add(Box.createVerticalGlue());

        rightCardLayout = new CardLayout();
        rightPanel = new JPanel(rightCardLayout);

        JPanel loginPanel = new JPanel(null);
        loginPanel.setBackground(new Color(0x333D79));

        JLabel adminLabel = new JLabel("User Log In");
        adminLabel.setForeground(new Color(0xFAEBEF));
        adminLabel.setFont(new Font("Arial", Font.BOLD, 22));
        adminLabel.setBounds(80, 30, 300, 30);
        loginPanel.add(adminLabel);

        JLabel userLabel = new JLabel("Username");
        userLabel.setForeground(new Color(0xFAEBEF));
        userLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        userLabel.setBounds(80, 80, 300, 20);
        loginPanel.add(userLabel);

        loginUserField = new JTextField();
        loginUserField.setBounds(80, 105, 320, 30);
        loginPanel.add(loginUserField);

        JLabel passLabel = new JLabel("Password");
        passLabel.setForeground(new Color(0xFAEBEF));
        passLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passLabel.setBounds(80, 145, 300, 20);
        loginPanel.add(passLabel);

        loginPassField = new JPasswordField();
        loginPassField.setBounds(80, 170, 320, 30);
        loginPanel.add(loginPassField);

        JButton loginBtn = new JButton("Log In");
        loginBtn.setBackground(new Color(0x333D79));
        loginBtn.setForeground(new Color(0xFAEBEF));
        loginBtn.setFont(new Font("Arial", Font.BOLD, 16));
        loginBtn.setFocusPainted(false);
        loginBtn.setBounds(80, 220, 320, 38);
        loginPanel.add(loginBtn);

        JLabel registerHint = new JLabel("Do you have an account? Register");
        registerHint.setForeground(new Color(0xFAEBEF));
        registerHint.setFont(new Font("Arial", Font.PLAIN, 13));
        registerHint.setBounds(120, 285, 250, 25);
        loginPanel.add(registerHint);

        JPanel registerPanel = new JPanel(null);
        registerPanel.setBackground(new Color(0x333D79));

        JLabel registerTitle = new JLabel("Register New Account");
        registerTitle.setForeground(new Color(0xFAEBEF));
        registerTitle.setFont(new Font("Arial", Font.BOLD, 22));
        registerTitle.setBounds(80, 30, 350, 30);
        registerPanel.add(registerTitle);

        JLabel regUserLabel = new JLabel("Username");
        regUserLabel.setForeground(new Color(0xFAEBEF));
        regUserLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        regUserLabel.setBounds(80, 80, 300, 20);
        registerPanel.add(regUserLabel);

        registerUserField = new JTextField();
        registerUserField.setBounds(80, 105, 320, 30);
        registerPanel.add(registerUserField);

        JLabel regPassLabel = new JLabel("Password");
        regPassLabel.setForeground(new Color(0xFAEBEF));
        regPassLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        regPassLabel.setBounds(80, 145, 300, 20);
        registerPanel.add(regPassLabel);

        registerPassField = new JPasswordField();
        registerPassField.setBounds(80, 170, 320, 30);
        registerPanel.add(registerPassField);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBackground(new Color(0x333D79));
        registerBtn.setForeground(new Color(0xFAEBEF));
        registerBtn.setFont(new Font("Arial", Font.BOLD, 16));
        registerBtn.setFocusPainted(false);
        registerBtn.setBounds(80, 220, 320, 38);
        registerPanel.add(registerBtn);

        JLabel loginHint = new JLabel("Already have an account? Log In");
        loginHint.setForeground(new Color(0xFAEBEF));
        loginHint.setFont(new Font("Arial", Font.PLAIN, 13));
        loginHint.setBounds(120, 285, 250, 25);
        registerPanel.add(loginHint);

        rightPanel.add(loginPanel, "login");
        rightPanel.add(registerPanel, "register");
        rightCardLayout.show(rightPanel, "login");

        registerNavBtn.addActionListener(e -> rightCardLayout.show(rightPanel, "register"));
        registerHint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightCardLayout.show(rightPanel, "register");
            }
        });

        loginNavBtn.addActionListener(e -> rightCardLayout.show(rightPanel, "login"));
        loginHint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightCardLayout.show(rightPanel, "login");
            }
        });

        loginBtn.addActionListener(e -> {
            String user = loginUserField.getText().trim();
            String pass = new String(loginPassField.getPassword());
            if (user.equals("admin") && pass.equals("admin123")) {
                LogDAO.log("Log in: admin");
                new AdminFrame().setVisible(true);
                dispose();
            } else if (user.equals("company") && pass.equals("company123")) {
                LogDAO.log("Log in: company");
                new CompanyFrame().setVisible(true);
                dispose();
            } else if (CustomerDAO.authenticate(user, pass)) {
                LogDAO.log("Log in: " + user);
                new CustomerFrame(user).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login");
            }
        });

        registerBtn.addActionListener(e -> {
            String newUser = registerUserField.getText().trim();
            String newPass = new String(registerPassField.getPassword()).trim();
            if (newUser.isEmpty() || newPass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fields cannot be empty!");
            } else if (!CustomerDAO.register(newUser, newPass)) {
                JOptionPane.showMessageDialog(this, "Username already exists!");
            } else {
                LogDAO.log("Sign up: " + newUser);
                JOptionPane.showMessageDialog(this, "Sign up successful! You can now log in.");
                rightCardLayout.show(rightPanel, "login");
            }
        });

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);
        setContentPane(mainPanel);
    }
}

class AdminFrame extends JFrame {
    private DefaultListModel<String> customerListModel = new DefaultListModel<>();
    private JList<String> customerList = new JList<>(customerListModel);

    private DefaultListModel<String> logListModel = new DefaultListModel<>();
    private JList<String> logList = new JList<>(logListModel);

    public AdminFrame() {
        setTitle("Admin Dashboard");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JTabbedPane tabs = new JTabbedPane();

        JPanel managePanel = new JPanel(new BorderLayout());

        refreshCustomerList();
        managePanel.add(new JScrollPane(customerList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        JButton addBtn = new JButton("Add Customer");
        JButton deleteBtn = new JButton("Delete Customer");
        JButton modifyBtn = new JButton("Modify Customer");

        for (JButton b : new JButton[]{addBtn, deleteBtn, modifyBtn}) {
            b.setBackground(new Color(0x333D79)); 
            b.setForeground(new Color(0xFAEBEF));
            b.setFont(new Font("Arial", Font.PLAIN, 13));
            b.setFocusPainted(false);
        }

        addBtn.addActionListener(e -> {
            JTextField userField = new JTextField(12);
            JTextField passField = new JTextField(12);
            Object[] msg = {"Username:", userField, "Password:", passField};
            int opt = JOptionPane.showConfirmDialog(this, msg, "Add Customer", JOptionPane.OK_CANCEL_OPTION);
            if (opt == JOptionPane.OK_OPTION) {
                String u = userField.getText().trim();
                String p = passField.getText().trim();
                if (!u.isEmpty() && !p.isEmpty()) {
                    if (!CustomerDAO.register(u, p)) {
                        JOptionPane.showMessageDialog(this, "Username already exists!");
                    } else {
                        LogDAO.log("Admin added customer: " + u);
                        refreshCustomerList();
                    }
                }
            }
        });

        deleteBtn.addActionListener(e -> {
            String selected = customerList.getSelectedValue();
            if (selected != null) {
                int confirm = JOptionPane.showConfirmDialog(this, "Delete customer: " + selected + "?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    CustomerDAO.deleteCustomer(selected);
                    LogDAO.log("Admin deleted customer: " + selected);
                    refreshCustomerList();
                }
            }
        });

        modifyBtn.addActionListener(e -> {
            String selected = customerList.getSelectedValue();
            if (selected != null) {
                JTextField passField = new JTextField(12);
                Object[] msg = {"New Password for " + selected + ":", passField};
                int opt = JOptionPane.showConfirmDialog(this, msg, "Modify Customer", JOptionPane.OK_CANCEL_OPTION);
                if (opt == JOptionPane.OK_OPTION) {
                    String newPass = passField.getText().trim();
                    if (!newPass.isEmpty()) {
                        CustomerDAO.updatePassword(selected, newPass);
                        LogDAO.log("Admin modified customer: " + selected);
                        refreshCustomerList();
                    }
                }
            }
        });

        buttonPanel.add(addBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(modifyBtn);

        managePanel.add(buttonPanel, BorderLayout.SOUTH);

        JLabel manageLabel = new JLabel("Manage Users and Cars", SwingConstants.CENTER);
        manageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        manageLabel.setForeground(new Color(0x333D79));
        manageLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        managePanel.add(manageLabel, BorderLayout.NORTH);

        tabs.addTab("Manage", managePanel);

        JPanel reportsPanel = new JPanel(new BorderLayout());
        JLabel reportsLabel = new JLabel("Sign up, Log in, Log out History", SwingConstants.CENTER);
        reportsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        reportsLabel.setForeground(new Color(0x333D79));
        reportsLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        reportsPanel.add(reportsLabel, BorderLayout.NORTH);
        refreshLogList();
        logList.setFont(new Font("Arial", Font.PLAIN, 15));
        reportsPanel.add(new JScrollPane(logList), BorderLayout.CENTER);

        JButton refreshLogBtn = new JButton("Refresh Logs");
        refreshLogBtn.setBackground(new Color(0x333D79));
        refreshLogBtn.setForeground(new Color(0xFAEBEF));
        refreshLogBtn.setFont(new Font("Arial", Font.PLAIN, 13));
        refreshLogBtn.setFocusPainted(false);
        reportsPanel.add(refreshLogBtn, BorderLayout.SOUTH);
        refreshLogBtn.addActionListener(e -> refreshLogList());

        tabs.addTab("Reports", reportsPanel);

        JButton logoutBtn = new JButton("Log Out");
        logoutBtn.setBackground(new Color(0x333D79));
        logoutBtn.setForeground(new Color(0xFAEBEF));
        logoutBtn.setFont(new Font("Arial", Font.BOLD, 16));
        logoutBtn.setFocusPainted(false);
        logoutBtn.addActionListener(e -> {
            LogDAO.log("Log out: admin");
            dispose();
            new LoginFrame().setVisible(true);
        });

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(tabs, BorderLayout.CENTER);
        mainPanel.add(logoutBtn, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private void refreshCustomerList() {
        customerListModel.clear();
        for (String user : CustomerDAO.getAllCustomers()) {
            customerListModel.addElement(user);
        }
    }

    private void refreshLogList() {
        logListModel.clear();
        for (String entry : LogDAO.getAllLogs()) {
            logListModel.addElement(entry);
        }
    }
}

class CompanyFrame extends JFrame {
    private DefaultListModel<String> carListModel = new DefaultListModel<>();
    private JList<String> carList = new JList<>(carListModel);

    private DefaultListModel<String> logListModel = new DefaultListModel<>();
    private JList<String> logList = new JList<>(logListModel);

    public CompanyFrame() {
        setTitle("Company Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 480);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0xFAEBEF));
        leftPanel.setPreferredSize(new Dimension(220, 480));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        try {
            ImageIcon icon = new ImageIcon("image.png");
            Image img = icon.getImage().getScaledInstance(320, 200, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(img));
            logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            logoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            leftPanel.add(logoLabel);
        } catch (Exception ex) {}

        JButton manageBtn = new JButton("Manage Cars");
        manageBtn.setBackground(new Color(0x333D79));
        manageBtn.setForeground(new Color(0xFAEBEF));
        manageBtn.setFont(new Font("Arial", Font.BOLD, 15));
        manageBtn.setFocusPainted(false);
        manageBtn.setMaximumSize(new Dimension(180, 36));
        manageBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(manageBtn);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 12)));

        JButton reportsBtn = new JButton("Reports");
        reportsBtn.setBackground(new Color(0xFAEBEF));
        reportsBtn.setForeground(new Color(0x333D79));
        reportsBtn.setFont(new Font("Arial", Font.BOLD, 15));
        reportsBtn.setFocusPainted(false);
        reportsBtn.setMaximumSize(new Dimension(180, 36));
        reportsBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(reportsBtn);
        leftPanel.add(Box.createVerticalGlue());

        JButton logoutBtn = new JButton("Log Out");
        logoutBtn.setBackground(new Color(0x333D79));
        logoutBtn.setForeground(new Color(0xFAEBEF));
        logoutBtn.setFont(new Font("Arial", Font.BOLD, 16));
        logoutBtn.setFocusPainted(false);
        logoutBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutBtn.setMaximumSize(new Dimension(180, 36));
        logoutBtn.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        leftPanel.add(logoutBtn);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 18)));
        logoutBtn.addActionListener(e -> {
            LogDAO.log("Log out: company");
            dispose();
            new LoginFrame().setVisible(true);
        });

        CardLayout rightCards = new CardLayout();
        JPanel rightPanel = new JPanel(rightCards);

        JPanel managePanel = new JPanel(new BorderLayout());
        JLabel manageLabel = new JLabel("Manage Cars", SwingConstants.CENTER);
        manageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        manageLabel.setForeground(new Color(0x333D79));
        manageLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        managePanel.add(manageLabel, BorderLayout.NORTH);

        refreshCarList();
        carList.setFont(new Font("Arial", Font.PLAIN, 16));
        managePanel.add(new JScrollPane(carList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JTextField carField = new JTextField(12);
        buttonPanel.add(carField);

        JButton addBtn = new JButton("Add Car");
        JButton deleteBtn = new JButton("Delete Car");
        JButton modifyBtn = new JButton("Modify Car");
        JButton updateBtn = new JButton("Update List");

        for (JButton b : new JButton[]{addBtn, deleteBtn, modifyBtn, updateBtn}) {
            b.setBackground(new Color(0x333D79));
            b.setForeground(new Color(0xFAEBEF));
            b.setFont(new Font("Arial", Font.PLAIN, 13));
            b.setFocusPainted(false);
        }

        buttonPanel.add(addBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(modifyBtn);
        buttonPanel.add(updateBtn);

        managePanel.add(buttonPanel, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> {
            String carName = carField.getText().trim();
            if (!carName.isEmpty()) {
                String[] categories = {"Sedan", "SUV", "Luxury"};
                String category = (String) JOptionPane.showInputDialog(this, "Select car category:", "Category",
                        JOptionPane.QUESTION_MESSAGE, null, categories, categories[0]);
                if (category != null) {
                    CarDAO.addCar(carName, category);
                    LogDAO.log("Added car: " + carName + " (" + category + ")");
                    carField.setText("");
                    JOptionPane.showMessageDialog(this, "Car added!");
                    refreshCarList();
                }
            }
        });
        deleteBtn.addActionListener(e -> {
            String selected = carList.getSelectedValue();
            if (selected != null) {
                String name = selected.split("\\(")[0].trim();
                String category = selected.substring(selected.indexOf("(") + 1, selected.indexOf(")"));
                int confirm = JOptionPane.showConfirmDialog(this, "Delete car: " + selected + "?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    CarDAO.deleteCar(name, category);
                    LogDAO.log("Deleted car: " + selected);
                    refreshCarList();
                }
            }
        });
        modifyBtn.addActionListener(e -> {
            String selected = carList.getSelectedValue();
            if (selected != null) {
                String oldName = selected.split("\\(")[0].trim();
                String oldCategory = selected.substring(selected.indexOf("(") + 1, selected.indexOf(")"));
                JTextField newCarField = new JTextField(oldName, 12);
                String[] categories = {"Sedan", "SUV", "Luxury"};
                JComboBox<String> categoryBox = new JComboBox<>(categories);
                categoryBox.setSelectedItem(oldCategory);
                Object[] msg = {"New Name:", newCarField, "New Category:", categoryBox};
                int opt = JOptionPane.showConfirmDialog(this, msg, "Modify Car", JOptionPane.OK_CANCEL_OPTION);
                if (opt == JOptionPane.OK_OPTION) {
                    String newName = newCarField.getText().trim();
                    String newCat = (String) categoryBox.getSelectedItem();
                    if (!newName.isEmpty()) {
                        CarDAO.updateCar(oldName, oldCategory, newName, newCat);
                        LogDAO.log("Modified car: " + selected + " to " + newName + " (" + newCat + ")");
                        refreshCarList();
                    }
                }
            }
        });
        updateBtn.addActionListener(e -> refreshCarList());

        JPanel reportsPanel = new JPanel(new BorderLayout());
        JLabel reportsLabel = new JLabel("Car Actions History", SwingConstants.CENTER);
        reportsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        reportsLabel.setForeground(new Color(0x333D79));
        reportsLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        reportsPanel.add(reportsLabel, BorderLayout.NORTH);

        refreshLogList();
        logList.setFont(new Font("Arial", Font.PLAIN, 15));
        reportsPanel.add(new JScrollPane(logList), BorderLayout.CENTER);

        JButton refreshLogBtn = new JButton("Refresh Logs");
        refreshLogBtn.setBackground(new Color(0x333D79));
        refreshLogBtn.setForeground(new Color(0xFAEBEF));
        refreshLogBtn.setFont(new Font("Arial", Font.PLAIN, 13));
        refreshLogBtn.setFocusPainted(false);
        reportsPanel.add(refreshLogBtn, BorderLayout.SOUTH);
        refreshLogBtn.addActionListener(e -> refreshLogList());

        rightPanel.add(managePanel, "manage");
        rightPanel.add(reportsPanel, "reports");
        rightCards.show(rightPanel, "manage");

        manageBtn.addActionListener(e -> {
            manageBtn.setBackground(new Color(0x333D79));
            manageBtn.setForeground(new Color(0xFAEBEF));
            reportsBtn.setBackground(new Color(0xFAEBEF));
            reportsBtn.setForeground(new Color(0x333D79));
            rightCards.show(rightPanel, "manage");
        });
        reportsBtn.addActionListener(e -> {
            reportsBtn.setBackground(new Color(0x333D79));
            reportsBtn.setForeground(new Color(0xFAEBEF));
            manageBtn.setBackground(new Color(0xFAEBEF));
            manageBtn.setForeground(new Color(0x333D79));
            rightCards.show(rightPanel, "reports");
        });

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }

    private void refreshCarList() {
        carListModel.clear();
        for (String car : CarDAO.getAllCars()) {
            carListModel.addElement(car);
        }
    }

    private void refreshLogList() {
        logListModel.clear();
        for (String entry : LogDAO.getAllLogs()) {
            logListModel.addElement(entry);
        }
    }
}

class CustomerFrame extends JFrame {
    private DefaultListModel<String> carListModel = new DefaultListModel<>();
    private JList<String> carList = new JList<>(carListModel);
    private JComboBox<String> typeCombo;
    private String username;

    public CustomerFrame(String username) {
        this.username = username;
        setTitle("Customer Dashboard");
        setSize(800, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0xFAEBEF));
        leftPanel.setPreferredSize(new Dimension(220, 480));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        try {
            ImageIcon icon = new ImageIcon("image.png");
            Image img = icon.getImage().getScaledInstance(320, 200, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(img));
            logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            logoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
            leftPanel.add(logoLabel);
        } catch (Exception ex) {}

        JLabel filterLabel = new JLabel("Filter Cars:");
        filterLabel.setFont(new Font("Arial", Font.BOLD, 15));
        filterLabel.setForeground(new Color(0x333D79));
        filterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(filterLabel);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 8)));

        typeCombo = new JComboBox<>(new String[]{"All", "Sedan", "SUV", "Luxury"});
        typeCombo.setMaximumSize(new Dimension(180, 30));
        typeCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        typeCombo.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(typeCombo);

        leftPanel.add(Box.createVerticalGlue());

        JButton logoutBtn = new JButton("Log Out");
        logoutBtn.setBackground(new Color(0x333D79));
        logoutBtn.setForeground(new Color(0xFAEBEF));
        logoutBtn.setFont(new Font("Arial", Font.BOLD, 16));
        logoutBtn.setFocusPainted(false);
        logoutBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutBtn.setMaximumSize(new Dimension(180, 36));
        logoutBtn.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        leftPanel.add(logoutBtn);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 18)));

        JPanel rightPanel = new JPanel(new BorderLayout());

        JLabel carListLabel = new JLabel("Available Cars", SwingConstants.CENTER);
        carListLabel.setFont(new Font("Arial", Font.BOLD, 20));
        carListLabel.setForeground(new Color(0x333D79));
        carListLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        rightPanel.add(carListLabel, BorderLayout.NORTH);

        carList.setFont(new Font("Arial", Font.PLAIN, 16));
        rightPanel.add(new JScrollPane(carList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 24));

        JButton bookBtn = new JButton("Book Car");
        JButton updateBtn = new JButton("Update List");

        for (JButton b : new JButton[]{bookBtn, updateBtn}) {
            b.setBackground(new Color(0x333D79));
            b.setForeground(new Color(0xFAEBEF));
            b.setFont(new Font("Arial", Font.PLAIN, 15));
            b.setFocusPainted(false);
            b.setMaximumSize(new Dimension(180, 36));
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonPanel.add(Box.createHorizontalGlue());
            buttonPanel.add(b);
        }
        buttonPanel.add(Box.createHorizontalGlue());

        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        typeCombo.addActionListener(e -> filterCars((String)typeCombo.getSelectedItem()));

        bookBtn.addActionListener(e -> {
            String selected = carList.getSelectedValue();
            if (selected != null) {
                String carName = selected.split("\\(")[0].trim();
                JOptionPane.showMessageDialog(this, "Booked: " + carName);
                LogDAO.log("Booked: " + carName + " by " + username);
            }
        });

        updateBtn.addActionListener(e -> filterCars((String)typeCombo.getSelectedItem()));

        logoutBtn.addActionListener(e -> {
            LogDAO.log("Log out: " + username);
            dispose();
            new LoginFrame().setVisible(true);
        });

        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);

        filterCars("All");
    }

    private void filterCars(String type) {
        carListModel.clear();
        List<String> allCars = CarDAO.getAllCars();
        for (String car : allCars) {
            if (type.equals("All") || car.contains("(" + type + ")")) {
                carListModel.addElement(car);
            }
        }
    }
}