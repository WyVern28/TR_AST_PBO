/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tr_ast_pbo.admin;

import java.awt.Color;
import javax.swing.JFrame;
import com.mycompany.tr_ast_pbo.DarkMode;
import java.awt.CardLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logic.FiturAdmin;
import objek.Anggota;
import objek.Buku;
import java.util.List;
import java.text.SimpleDateFormat;
import DTO.PinjamDTO;
import com.mycompany.tr_ast_pbo.loginPage;

/**
 *
 * @author Made
 */
public class adminPage extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(adminPage.class.getName());
    private FiturAdmin fiturAdmin = new FiturAdmin();
    private String selectedAnggotaId = null;
    private String selectedBukuId = null;

    /**
     * Creates new form adminPage
     */
    public adminPage() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDarkMode(DarkMode.isDarkMode);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane3.getViewport().setOpaque(false);
        
        CardLayout cl = (CardLayout) panelEdit.getLayout();
        
        tabPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Cek index tab yang dipilih
                int index = tabPanel.getSelectedIndex();
                
                if (index == 0) {
                    // Jika Tab 0 (Anggota) dipilih -> Tampilkan panel anggota
                    cl.show(panelEdit, "cardAnggota"); 
                } else if (index == 1) {
                    // Jika Tab 1 (Buku) dipilih -> Tampilkan panel buku
                    cl.show(panelEdit, "cardBuku");
                } else if (index == 2) {
                    // Jika Tab 2 (Peminjam) dipilih -> Tidak perlu panel edit
                    cl.show(panelEdit, "cardPeminjam");
                }
            }
        });
        
        loadTables();
        setupTableListeners();

    }
    
    private void setDarkMode(boolean isDark) {
        if(isDark){
            jPanel1.setBackground(new Color(44, 44, 44));
            mainPanel.setBackground(new Color(44, 44, 44));
            panelEdit.setBackground(new Color(44, 44, 44));
            panelEditAnggota.setBackground(new Color(44, 44, 44));
            panelEditBuku.setBackground(new Color(44, 44, 44));
            panelPeminjam.setBackground(new Color(44, 44, 44));
            tablePanel.setBackground(new Color(44, 44, 44));
            tabPanel.setBackground(new Color(44, 44, 44));
            perpus.setForeground(Color.WHITE);
            judulMenuAnggota.setForeground(Color.WHITE);
            judulMenuBuku.setForeground(Color.WHITE);
            namaAnggota.setForeground(Color.WHITE);
            password.setForeground(Color.WHITE);
            namaBuku.setForeground(Color.WHITE);
            penulis.setForeground(Color.WHITE);
            stok.setForeground(Color.WHITE);
            tglTerbit.setForeground(Color.WHITE);
            
            tableAnggota.setBackground(new Color(44, 44, 44));
            tableAnggota.setForeground(Color.WHITE);
            tableAnggota.setGridColor(Color.WHITE);
            
            tableBuku.setBackground(new Color(44, 44, 44));
            tableBuku.setForeground(Color.WHITE);
            tableBuku.setGridColor(Color.WHITE);
            
            tablePeminjam.setBackground(new Color(44, 44, 44));
            tablePeminjam.setForeground(Color.WHITE);
            tablePeminjam.setGridColor(Color.WHITE);
        
        }else{
            jPanel1.setBackground(new Color(249, 248, 246));
            mainPanel.setBackground(new Color(249, 248, 246));
            panelEdit.setBackground(new Color(249, 248, 246));
            panelEditAnggota.setBackground(new Color(249, 248, 246));
            panelEditBuku.setBackground(new Color(249, 248, 246));
            panelPeminjam.setBackground(new Color(249, 248, 246));
            tablePanel.setBackground(new Color(249, 248, 246));
            tabPanel.setBackground(new Color(249, 248, 246));
            perpus.setForeground(Color.BLACK);
            judulMenuAnggota.setForeground(Color.BLACK);
            judulMenuBuku.setForeground(Color.BLACK);
            namaAnggota.setForeground(Color.BLACK);
            password.setForeground(Color.BLACK);
            namaBuku.setForeground(Color.BLACK);
            penulis.setForeground(Color.BLACK);
            stok.setForeground(Color.BLACK);
            tglTerbit.setForeground(Color.BLACK);
            
            tableAnggota.setBackground(new Color(249, 248, 246));
            tableAnggota.setForeground(Color.BLACK);
            tableAnggota.setGridColor(Color.BLACK);
            
            tableBuku.setBackground(new Color(249, 248, 246));
            tableBuku.setForeground(Color.BLACK);
            tableBuku.setGridColor(Color.BLACK);
            
            tablePeminjam.setBackground(new Color(249, 248, 246));
            tablePeminjam.setForeground(Color.BLACK);
            tablePeminjam.setGridColor(Color.BLACK);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        perpus = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        panelEdit = new javax.swing.JPanel();
        panelEditAnggota = new javax.swing.JPanel();
        judulMenuAnggota = new javax.swing.JLabel();
        namaAnggota = new javax.swing.JLabel();
        namaAnggotaInput = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        passwordInput = new javax.swing.JTextField();
        tambahBtn1 = new javax.swing.JButton();
        editBtn1 = new javax.swing.JButton();
        deleteBtn1 = new javax.swing.JButton();
        cancelBtn1 = new javax.swing.JButton();
        darkModeToggle1 = new javax.swing.JToggleButton();
        logOut = new javax.swing.JButton();
        panelEditBuku = new javax.swing.JPanel();
        judulMenuBuku = new javax.swing.JLabel();
        namaBuku = new javax.swing.JLabel();
        namaBukuInput = new javax.swing.JTextField();
        penulis = new javax.swing.JLabel();
        penulisInput = new javax.swing.JTextField();
        stok = new javax.swing.JLabel();
        stokInput = new javax.swing.JTextField();
        tambahBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        tglTerbit = new javax.swing.JLabel();
        tglTerbitInput = new javax.swing.JTextField();
        darkModeToggle = new javax.swing.JToggleButton();
        logOut1 = new javax.swing.JButton();
        panelPeminjam = new javax.swing.JPanel();
        darkModeToggle2 = new javax.swing.JToggleButton();
        logOut2 = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        tabPanel = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAnggota = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBuku = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePeminjam = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(3000, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(1617, 100));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        perpus.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        perpus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        perpus.setText("PERPUSTAKAAN");
        jPanel1.add(perpus);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        mainPanel.setLayout(new java.awt.BorderLayout());

        panelEdit.setPreferredSize(new java.awt.Dimension(400, 539));
        panelEdit.setLayout(new java.awt.CardLayout());

        panelEditAnggota.setPreferredSize(new java.awt.Dimension(400, 300));

        judulMenuAnggota.setText("MENU EDIT ANGGOTA");

        namaAnggota.setText("Nama Anggota :");

        password.setText("Password :");

        tambahBtn1.setText("Tambah");
        tambahBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBtn1ActionPerformed(evt);
            }
        });

        editBtn1.setText("Edit");
        editBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtn1ActionPerformed(evt);
            }
        });

        deleteBtn1.setText("Delete");
        deleteBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn1ActionPerformed(evt);
            }
        });

        cancelBtn1.setText("Cancel");
        cancelBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtn1ActionPerformed(evt);
            }
        });

        darkModeToggle1.setText("Dark Mode");
        darkModeToggle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkModeToggle1ActionPerformed(evt);
            }
        });

        logOut.setText("Log Out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEditAnggotaLayout = new javax.swing.GroupLayout(panelEditAnggota);
        panelEditAnggota.setLayout(panelEditAnggotaLayout);
        panelEditAnggotaLayout.setHorizontalGroup(
            panelEditAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditAnggotaLayout.createSequentialGroup()
                .addGroup(panelEditAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditAnggotaLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(judulMenuAnggota))
                    .addGroup(panelEditAnggotaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelEditAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namaAnggota, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEditAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namaAnggotaInput, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(passwordInput)))
                    .addGroup(panelEditAnggotaLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelEditAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEditAnggotaLayout.createSequentialGroup()
                                .addComponent(darkModeToggle1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelEditAnggotaLayout.createSequentialGroup()
                                .addComponent(tambahBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelEditAnggotaLayout.setVerticalGroup(
            panelEditAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditAnggotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulMenuAnggota)
                .addGap(18, 18, 18)
                .addGroup(panelEditAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaAnggota)
                    .addComponent(namaAnggotaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEditAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(panelEditAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahBtn1)
                    .addComponent(editBtn1)
                    .addComponent(deleteBtn1)
                    .addComponent(cancelBtn1))
                .addGap(49, 49, 49)
                .addGroup(panelEditAnggotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(darkModeToggle1)
                    .addComponent(logOut))
                .addContainerGap(295, Short.MAX_VALUE))
        );

        panelEdit.add(panelEditAnggota, "cardAnggota");

        panelEditBuku.setPreferredSize(new java.awt.Dimension(400, 300));

        judulMenuBuku.setText("MENU EDIT BUKU");

        namaBuku.setText("Nama Buku: ");

        penulis.setText("Penulis :");

        stok.setText("Stok :");

        tambahBtn.setText("Tambah");
        tambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBtnActionPerformed(evt);
            }
        });

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        tglTerbit.setText("Tgl Terbit :");

        darkModeToggle.setText("Dark Mode");
        darkModeToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkModeToggleActionPerformed(evt);
            }
        });

        logOut1.setText("Log Out");
        logOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEditBukuLayout = new javax.swing.GroupLayout(panelEditBuku);
        panelEditBuku.setLayout(panelEditBukuLayout);
        panelEditBukuLayout.setHorizontalGroup(
            panelEditBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditBukuLayout.createSequentialGroup()
                .addGroup(panelEditBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelEditBukuLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(judulMenuBuku))
                    .addGroup(panelEditBukuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelEditBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(stok, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(penulis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namaBuku, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEditBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namaBukuInput)
                            .addComponent(penulisInput)
                            .addComponent(stokInput, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
                    .addGroup(panelEditBukuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tglTerbit)
                        .addGap(18, 18, 18)
                        .addComponent(tglTerbitInput, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditBukuLayout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(panelEditBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditBukuLayout.createSequentialGroup()
                        .addComponent(darkModeToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(logOut1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEditBukuLayout.createSequentialGroup()
                        .addComponent(tambahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        panelEditBukuLayout.setVerticalGroup(
            panelEditBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditBukuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulMenuBuku)
                .addGap(18, 18, 18)
                .addGroup(panelEditBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaBuku)
                    .addComponent(namaBukuInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEditBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(penulis)
                    .addComponent(penulisInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEditBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stok)
                    .addComponent(stokInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEditBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tglTerbit)
                    .addComponent(tglTerbitInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(panelEditBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahBtn)
                    .addComponent(editBtn)
                    .addComponent(deleteBtn)
                    .addComponent(cancelBtn))
                .addGap(49, 49, 49)
                .addGroup(panelEditBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(darkModeToggle)
                    .addComponent(logOut1))
                .addContainerGap(225, Short.MAX_VALUE))
        );

        panelEdit.add(panelEditBuku, "cardBuku");

        panelPeminjam.setPreferredSize(new java.awt.Dimension(300, 539));

        darkModeToggle2.setText("Dark Mode");
        darkModeToggle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkModeToggle2ActionPerformed(evt);
            }
        });

        logOut2.setText("Log Out");
        logOut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPeminjamLayout = new javax.swing.GroupLayout(panelPeminjam);
        panelPeminjam.setLayout(panelPeminjamLayout);
        panelPeminjamLayout.setHorizontalGroup(
            panelPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeminjamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(darkModeToggle2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(logOut2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        panelPeminjamLayout.setVerticalGroup(
            panelPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeminjamLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelPeminjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(darkModeToggle2)
                    .addComponent(logOut2))
                .addContainerGap(494, Short.MAX_VALUE))
        );

        panelEdit.add(panelPeminjam, "cardPeminjam");

        mainPanel.add(panelEdit, java.awt.BorderLayout.WEST);

        tablePanel.setPreferredSize(new java.awt.Dimension(700, 768));
        tablePanel.setLayout(new java.awt.BorderLayout());

        tableAnggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableAnggota.setShowGrid(true);
        jScrollPane1.setViewportView(tableAnggota);

        tabPanel.addTab("Anggota", jScrollPane1);

        tableBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Buku", "Pengarang", "Stok", "Tanggal Terbit"
            }
        ));
        tableBuku.setShowGrid(true);
        jScrollPane2.setViewportView(tableBuku);

        tabPanel.addTab("Buku", jScrollPane2);

        tablePeminjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePeminjam.setShowGrid(true);
        jScrollPane3.setViewportView(tablePeminjam);

        tabPanel.addTab("Peminjam", jScrollPane3);

        tablePanel.add(tabPanel, java.awt.BorderLayout.CENTER);

        mainPanel.add(tablePanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBtnActionPerformed
        // TODO add your handling code here:
        String nama = namaBukuInput.getText().trim();
        String penulisText = penulisInput.getText().trim();
        String stokText = stokInput.getText().trim();
        String tglTerbitText = tglTerbitInput.getText().trim();
        
        if(nama.isEmpty() || stokText.isEmpty() || tglTerbitText.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nama buku, stok, dan tanggal terbit harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int stok = Integer.parseInt(stokText);
            int result = fiturAdmin.createBuku(penulisText, nama, stok, tglTerbitText);
            
            if(result == 200){
                JOptionPane.showMessageDialog(this, "Buku berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                clearBukuFields();
                loadTableBuku();
                tableBuku.clearSelection();
            } else if(result == 400){
                JOptionPane.showMessageDialog(this, "Input tidak valid! Pastikan stok >= 0 dan format tanggal yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menambahkan buku!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Stok harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tambahBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        if(selectedBukuId == null){
            JOptionPane.showMessageDialog(this, "Pilih buku yang ingin diedit!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String nama = namaBukuInput.getText().trim();
        String penulisText = penulisInput.getText().trim();
        String stokText = stokInput.getText().trim();
        String tglTerbitText = tglTerbitInput.getText().trim();
        
        if(nama.isEmpty() || stokText.isEmpty() || tglTerbitText.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nama buku, stok, dan tanggal terbit harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            int stok = Integer.parseInt(stokText);
            int result = fiturAdmin.updateBuku(selectedBukuId, penulisText, nama, stok, tglTerbitText);
            
            if(result == 200){
                JOptionPane.showMessageDialog(this, "Buku berhasil diupdate!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                clearBukuFields();
                loadTableBuku();
                selectedBukuId = null;
                tableBuku.clearSelection();
            } else if(result == 400){
                JOptionPane.showMessageDialog(this, "Input tidak valid! Pastikan stok >= 0 dan format tanggal yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengupdate buku!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Stok harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(selectedBukuId == null){
            JOptionPane.showMessageDialog(this, "Pilih buku yang ingin dihapus!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus buku ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            int result = fiturAdmin.deleteBuku(selectedBukuId);
            
            if(result == 200){
                JOptionPane.showMessageDialog(this, "Buku berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                clearBukuFields();
                loadTableBuku();
                selectedBukuId = null;
                tableBuku.clearSelection();
            } else if(result == 400){
                JOptionPane.showMessageDialog(this, "ID buku tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus buku! Mungkin buku sedang dipinjam.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clearBukuFields();
        selectedBukuId = null;
        tableBuku.clearSelection();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void tambahBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBtn1ActionPerformed
        String nama = namaAnggotaInput.getText().trim();
        String password = passwordInput.getText().trim();
        
        if(nama.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Nama dan password harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(fiturAdmin.createAnggota(nama, password)){
            JOptionPane.showMessageDialog(this, "Anggota berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            clearAnggotaFields();
            loadTableAnggota();
            tableAnggota.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan anggota!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tambahBtn1ActionPerformed

    private void editBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtn1ActionPerformed
        if(selectedAnggotaId == null){
            JOptionPane.showMessageDialog(this, "Pilih anggota yang ingin diedit!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String password = passwordInput.getText().trim();
        
        if(password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Password harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(fiturAdmin.updatePassword(selectedAnggotaId, password)){
            JOptionPane.showMessageDialog(this, "Password berhasil diupdate!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            clearAnggotaFields();
            selectedAnggotaId = null;
            tableAnggota.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal mengupdate password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editBtn1ActionPerformed

    private void deleteBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn1ActionPerformed
        if(selectedAnggotaId == null){
            JOptionPane.showMessageDialog(this, "Pilih anggota yang ingin dihapus!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin ingin menghapus anggota ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            if(fiturAdmin.deleteAnggota(selectedAnggotaId)){
                JOptionPane.showMessageDialog(this, "Anggota berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                clearAnggotaFields();
                loadTableAnggota();
                selectedAnggotaId = null;
                tableAnggota.clearSelection();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus anggota!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteBtn1ActionPerformed

    private void cancelBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn1ActionPerformed
        clearAnggotaFields();
        selectedAnggotaId = null;
        tableAnggota.clearSelection();
    }//GEN-LAST:event_cancelBtn1ActionPerformed

    private void darkModeToggle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkModeToggle1ActionPerformed
        // TODO add your handling code here:
        setDarkMode(darkModeToggle1.isSelected());
        DarkMode.isDarkMode = darkModeToggle1.isSelected();
        
        if (darkModeToggle1.isSelected()) {
            darkModeToggle1.setText("Light Mode");
            darkModeToggle.setSelected(true);
            darkModeToggle2.setSelected(true);
            darkModeToggle.setText("Light Mode");
            darkModeToggle2.setText("Light Mode");
        } else {
            darkModeToggle1.setText("Dark Mode");
            darkModeToggle2.setText("Dark Mode");
            darkModeToggle.setSelected(false);
            darkModeToggle2.setSelected(false);
            darkModeToggle.setText("Dark Mode");
            darkModeToggle2.setText("Dark Mode");
        }
    }//GEN-LAST:event_darkModeToggle1ActionPerformed

    private void darkModeToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkModeToggleActionPerformed
        // TODO add your handling code here:
        setDarkMode(darkModeToggle.isSelected());
        DarkMode.isDarkMode = darkModeToggle.isSelected();
        
        if (darkModeToggle.isSelected()) {
            darkModeToggle.setText("Light Mode");
            darkModeToggle1.setSelected(true);
            darkModeToggle2.setSelected(true);
            darkModeToggle1.setText("Light Mode");
            darkModeToggle2.setText("Light Mode");
        } else {
            darkModeToggle.setText("Dark Mode");
            darkModeToggle1.setSelected(false);
            darkModeToggle2.setSelected(false);
            darkModeToggle1.setText("Dark Mode");
            darkModeToggle2.setText("Dark Mode");
        }
    }//GEN-LAST:event_darkModeToggleActionPerformed

    private void darkModeToggle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkModeToggle2ActionPerformed
        // TODO add your handling code here:
        setDarkMode(darkModeToggle2.isSelected());
        DarkMode.isDarkMode = darkModeToggle2.isSelected();
        
        if (darkModeToggle2.isSelected()) {
            darkModeToggle.setText("Light Mode");
            darkModeToggle1.setSelected(true);
            darkModeToggle.setSelected(true);
            darkModeToggle1.setText("Light Mode");
            darkModeToggle2.setText("Light Mode");
        } else {
            darkModeToggle.setText("Dark Mode");
            darkModeToggle1.setSelected(false);
            darkModeToggle.setSelected(false);
            darkModeToggle1.setText("Dark Mode");
            darkModeToggle2.setText("Dark Mode");
        }
    }//GEN-LAST:event_darkModeToggle2ActionPerformed

    private void logOut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut2ActionPerformed
        this.dispose();
        new loginPage().setVisible(true);
    }//GEN-LAST:event_logOut2ActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new loginPage().setVisible(true);
    }//GEN-LAST:event_logOutActionPerformed

    private void logOut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new loginPage().setVisible(true);
    }//GEN-LAST:event_logOut1ActionPerformed

    private void loadTables() {
        loadTableAnggota();
        loadTableBuku();
        loadTablePeminjam();
    }
    
    private void loadTableAnggota() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Anggota", "Nama", "Status"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        List<Anggota> listAnggota = fiturAdmin.getAllAnggota();
        for(Anggota anggota : listAnggota) {
            model.addRow(new Object[]{
                anggota.getId_anggota(),
                anggota.getNama(),
                anggota.isStatus() ? "Aktif" : "Tidak Aktif"
            });
        }
        
        tableAnggota.setModel(model);
    }
    
    private void loadTableBuku() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Buku", "Nama Buku", "Penulis", "Stok", "Tanggal Terbit"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Buku> listBuku = fiturAdmin.getAllBuku();
        for(Buku buku : listBuku) {
            model.addRow(new Object[]{
                buku.getId_buku(),
                buku.getNama_buku(),
                buku.getPenulis(),
                buku.getStok(),
                dateFormat.format(buku.getTanggal_terbit())
            });
        }
        
        tableBuku.setModel(model);
    }
    
    private void loadTablePeminjam() {
        DefaultTableModel model = new DefaultTableModel(
            new String[]{"ID Anggota", "Nama Anggota", "Nama Buku", "Jumlah", "Tanggal Pinjam", "Deadline", "Tanggal Kembali", "Status"}, 
            0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        List<PinjamDTO> listPinjam = fiturAdmin.getAllPinjam();
        if(listPinjam != null && !listPinjam.isEmpty()) {
            for(PinjamDTO pinjam : listPinjam) {
                model.addRow(new Object[]{
                    pinjam.getId_anggota(),
                    pinjam.getNama_anggota(),
                    pinjam.getNama_buku(),
                    pinjam.getJumlah_buku(),
                    pinjam.getTanggal_pinjam(),
                    pinjam.getDeadline(),
                    pinjam.getTanggal_kembali() != null ? pinjam.getTanggal_kembali() : "-",
                    pinjam.getStatus()
                });
            }
        }
        
        tablePeminjam.setModel(model);
    }
    
    private void setupTableListeners() {
        tableAnggota.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tableAnggota.getSelectedRow() != -1) {
                int row = tableAnggota.getSelectedRow();
                selectedAnggotaId = tableAnggota.getValueAt(row, 0).toString();
                namaAnggotaInput.setText(tableAnggota.getValueAt(row, 1).toString());
                passwordInput.setText("");
            }
        });
        
        tableBuku.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tableBuku.getSelectedRow() != -1) {
                int row = tableBuku.getSelectedRow();
                selectedBukuId = tableBuku.getValueAt(row, 0).toString();
                namaBukuInput.setText(tableBuku.getValueAt(row, 1).toString());
                penulisInput.setText(tableBuku.getValueAt(row, 2).toString());
                stokInput.setText(tableBuku.getValueAt(row, 3).toString());
                tglTerbitInput.setText(tableBuku.getValueAt(row, 4).toString());
            }
        });
    }
    
    private void clearAnggotaFields() {
        namaAnggotaInput.setText("");
        passwordInput.setText("");
    }
    
    private void clearBukuFields() {
        namaBukuInput.setText("");
        penulisInput.setText("");
        stokInput.setText("");
        tglTerbitInput.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new adminPage().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton cancelBtn1;
    private javax.swing.JToggleButton darkModeToggle;
    private javax.swing.JToggleButton darkModeToggle1;
    private javax.swing.JToggleButton darkModeToggle2;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton deleteBtn1;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton editBtn1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel judulMenuAnggota;
    private javax.swing.JLabel judulMenuBuku;
    private javax.swing.JButton logOut;
    private javax.swing.JButton logOut1;
    private javax.swing.JButton logOut2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel namaAnggota;
    private javax.swing.JTextField namaAnggotaInput;
    private javax.swing.JLabel namaBuku;
    private javax.swing.JTextField namaBukuInput;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelEditAnggota;
    private javax.swing.JPanel panelEditBuku;
    private javax.swing.JPanel panelPeminjam;
    private javax.swing.JLabel password;
    private javax.swing.JTextField passwordInput;
    private javax.swing.JLabel penulis;
    private javax.swing.JTextField penulisInput;
    private javax.swing.JLabel perpus;
    private javax.swing.JLabel stok;
    private javax.swing.JTextField stokInput;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTable tableAnggota;
    private javax.swing.JTable tableBuku;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTable tablePeminjam;
    private javax.swing.JButton tambahBtn;
    private javax.swing.JButton tambahBtn1;
    private javax.swing.JLabel tglTerbit;
    private javax.swing.JTextField tglTerbitInput;
    // End of variables declaration//GEN-END:variables
}
