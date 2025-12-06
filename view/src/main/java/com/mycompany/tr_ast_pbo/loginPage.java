package com.mycompany.tr_ast_pbo;

import java.awt.Color;
import javax.swing.JOptionPane;
import com.mycompany.tr_ast_pbo.admin.adminPage;
import com.mycompany.tr_ast_pbo.user.DashboardUser;
import logic.LoginLogic;

public class loginPage extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(loginPage.class.getName());

    public loginPage() {
        initComponents();
        setDarkMode(DarkMode.isDarkMode);
    }

    private void setDarkMode(boolean isDark) {
        if(isDark){
            jPanel1.setBackground(new Color(44, 44, 44));
            headerPanel.setBackground(new Color(44, 44, 44));
            bodyPanel.setBackground(new Color(44, 44, 44));
            labelUsername.setForeground(Color.WHITE);
            labelPassword.setForeground(Color.WHITE);
            titik2Username.setForeground(Color.WHITE);
            titik2Password.setForeground(Color.WHITE);
            darkModeToggle.setText("Light Mode");
        }else{
            jPanel1.setBackground(new Color(249, 248, 246));
            headerPanel.setBackground(new Color(249, 248, 246));
            bodyPanel.setBackground(new Color(249, 248, 246));
            labelUsername.setForeground(Color.BLACK);
            labelPassword.setForeground(Color.BLACK);
            titik2Username.setForeground(Color.BLACK);
            titik2Password.setForeground(Color.BLACK);
            darkModeToggle.setText("Dark Mode");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        bodyPanel = new javax.swing.JPanel();
        labelUsername = new javax.swing.JLabel();
        inputUsername = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        inputPassword = new javax.swing.JPasswordField();
        lupaPasswordBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        titik2Username = new javax.swing.JLabel();
        titik2Password = new javax.swing.JLabel();
        darkModeToggle = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 248, 246));
        jPanel1.setLayout(new java.awt.BorderLayout());

        headerPanel.setBackground(new java.awt.Color(249, 248, 246));
        jPanel1.add(headerPanel, java.awt.BorderLayout.NORTH);

        bodyPanel.setBackground(new java.awt.Color(249, 248, 246));
        bodyPanel.setPreferredSize(new java.awt.Dimension(640, 280));

        labelUsername.setForeground(new java.awt.Color(0, 0, 0));
        labelUsername.setText("Username");

        inputUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUsernameActionPerformed(evt);
            }
        });

        labelPassword.setForeground(new java.awt.Color(0, 0, 0));
        labelPassword.setText("Password ");

        inputPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPasswordActionPerformed(evt);
            }
        });

        lupaPasswordBtn.setBackground(new java.awt.Color(255, 51, 51));
        lupaPasswordBtn.setForeground(new java.awt.Color(0, 0, 0));
        lupaPasswordBtn.setText("Lupa Password");
        lupaPasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lupaPasswordBtnActionPerformed(evt);
            }
        });

        loginBtn.setBackground(new java.awt.Color(51, 255, 0));
        loginBtn.setForeground(new java.awt.Color(0, 0, 0));
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        titik2Username.setForeground(new java.awt.Color(0, 0, 0));
        titik2Username.setText("      :");

        titik2Password.setForeground(new java.awt.Color(0, 0, 0));
        titik2Password.setText("      :");

        darkModeToggle.setText("Dark Mode");
        darkModeToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkModeToggleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
                bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(darkModeToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bodyPanelLayout.createSequentialGroup()
                                                        .addComponent(lupaPasswordBtn)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bodyPanelLayout.createSequentialGroup()
                                                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(bodyPanelLayout.createSequentialGroup()
                                                                        .addComponent(labelPassword)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(titik2Password, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(bodyPanelLayout.createSequentialGroup()
                                                                        .addComponent(labelUsername)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(titik2Username, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(inputUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                                                .addComponent(inputPassword)))))
                                .addContainerGap(342, Short.MAX_VALUE))
        );
        bodyPanelLayout.setVerticalGroup(
                bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelUsername)
                                        .addComponent(inputUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(titik2Username))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelPassword)
                                        .addComponent(titik2Password)
                                        .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginBtn)
                                        .addComponent(lupaPasswordBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                .addComponent(darkModeToggle)
                                .addGap(43, 43, 43))
        );

        jPanel1.add(bodyPanel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void inputUsernameActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void lupaPasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {
        LoginLogic loginLogic = new LoginLogic();
        String username = inputUsername.getText();
        String password = new String(inputPassword.getPassword());

        if(username.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Tolong Isi Username!", "Login", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(password.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Tolong Isi Password!", "Login", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String role = loginLogic.getRole(username, password);

        if(role == null){
            JOptionPane.showMessageDialog(rootPane, "Username atau Password salah!", "Login Gagal", JOptionPane.ERROR_MESSAGE);
            inputUsername.setText("");
            inputPassword.setText("");
            return;
        }

        if(role.equalsIgnoreCase("admin")){
            new adminPage().setVisible(true);
            this.dispose();
        } else if(role.equalsIgnoreCase("anggota")){
            new DashboardUser(username).setVisible(true);
            this.dispose();
        }
    }

    private void darkModeToggleActionPerformed(java.awt.event.ActionEvent evt) {
        setDarkMode(darkModeToggle.isSelected());
        DarkMode.isDarkMode = darkModeToggle.isSelected();

        if (darkModeToggle.isSelected()) {
            darkModeToggle.setText("Light Mode");
        } else {
            darkModeToggle.setText("Dark Mode");
        }
    }

    private void inputPasswordActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new loginPage().setVisible(true));
    }

    private javax.swing.JPanel bodyPanel;
    private javax.swing.JToggleButton darkModeToggle;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JTextField inputUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JButton loginBtn;
    private javax.swing.JButton lupaPasswordBtn;
    private javax.swing.JLabel titik2Password;
    private javax.swing.JLabel titik2Username;
}