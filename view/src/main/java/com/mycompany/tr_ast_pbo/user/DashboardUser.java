/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tr_ast_pbo.user;

import com.mycompany.tr_ast_pbo.loginPage;
import com.mycompany.tr_ast_pbo.DarkMode;
import DTO.PinjamDTO;
import objek.Buku;
import repo.BukuRepository;
import repo.PinjamRepository;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows
 */
public class DashboardUser extends JFrame {

    private static final Logger logger = Logger.getLogger(DashboardUser.class.getName());
    private String currentUser;

    private BukuRepository bukuRepo = new BukuRepository();
    private PinjamRepository pinjamRepo = new PinjamRepository();

    /**
     * Creates new form DashboardUser
     */
    public DashboardUser(String username) {
        this.currentUser = username;
        initComponents();
        jPanel6.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        loadDataRekomendasi();
        loadStatistik();
        setDarkMode(DarkMode.isDarkMode);
    }

    private void loadDataRekomendasi() {
        jPanel6.removeAll();
        List<Buku> listBuku = bukuRepo.getAllBuku();

        int limit = Math.min(listBuku.size(), 4);

        for (int i = 0; i < limit; i++) {
            Buku buku = listBuku.get(i);
            JPanel card = createBookCard(buku.getId_buku(), buku.getNama_buku(), buku.getPenulis());
            jPanel6.add(card);
        }

        jPanel6.revalidate();
        jPanel6.repaint();
    }

    private void loadStatistik() {
        List<PinjamDTO> listPinjam = pinjamRepo.getPinjamByAnggota(currentUser);

        int bukuDipinjam = 0;
        long deadlineTerdekat = -1;
        int bukuDikembalikan = 0;

        LocalDate today = LocalDate.now();

        for (PinjamDTO pinjam : listPinjam) {
            if ("DIPINJAM".equalsIgnoreCase(pinjam.getStatus())) {
                bukuDipinjam += pinjam.getJumlah_buku();

                try {
                    LocalDate tglDeadline = LocalDate.parse(pinjam.getDeadline());
                    long daysBetween = ChronoUnit.DAYS.between(today, tglDeadline);

                    if (deadlineTerdekat == -1 || daysBetween < deadlineTerdekat) {
                        deadlineTerdekat = daysBetween;
                    }
                } catch (Exception e) {
                }
            }
        }

        jLabel1.setText(String.valueOf(bukuDipinjam));

        if (deadlineTerdekat != -1) {
            jLabel3.setText(deadlineTerdekat + " Hari");
        } else {
            jLabel3.setText("-");
        }
        jLabel5.setText("-");
    }

    private JPanel createBookCard(String idBuku, String judul, String penulis) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        // KUNCI UKURAN KARTU AGAR TIDAK MELAR
        Dimension cardSize = new Dimension(200, 160); // Sesuaikan ukuran di sini
        panel.setPreferredSize(cardSize);
        panel.setMinimumSize(cardSize);
        panel.setMaximumSize(cardSize); // Penting agar BoxLayout tidak membuatnya melar

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel lblJudul = new JLabel(judul);
        lblJudul.setFont(new Font("Serif", Font.BOLD, 14)); // Tambah Bold biar bagus

        JLabel lblPenulis = new JLabel(penulis);
        lblPenulis.setFont(new Font("Serif", Font.PLAIN, 12));

        JButton btnPinjam = new JButton("Pinjam");
        btnPinjam.setBackground(new Color(0, 204, 0));
        btnPinjam.setForeground(Color.BLACK);

        btnPinjam.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Pinjam buku " + judul + "?");
            if (confirm == JOptionPane.YES_OPTION) {
                boolean success = pinjamRepo.insertPinjam(currentUser, idBuku, 1);

                if(success) {
                    Buku b = bukuRepo.getBukuById(idBuku);
                    if(b != null) {
                        bukuRepo.changeStock(idBuku, b.getStok() - 1);
                    }

                    JOptionPane.showMessageDialog(this, "Berhasil meminjam!");
                    loadStatistik();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal meminjam (Stok habis/Error DB)");
                }
            }
        });

        lblJudul.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPenulis.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPinjam.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(15));
        panel.add(lblJudul);
        panel.add(Box.createVerticalStrut(5));
        panel.add(lblPenulis);

        panel.add(Box.createVerticalGlue());

        panel.add(btnPinjam);
        panel.add(Box.createVerticalStrut(15));

        return panel;
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
        label1 = new java.awt.Label();
        tambahBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        editBtn1 = new javax.swing.JButton();
        editBtn2 = new javax.swing.JButton();
        tambahBtn1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        label3 = new java.awt.Label();
        jPanel6 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label1.setText("Perpustakaan Digital");

        tambahBtn.setBackground(new java.awt.Color(153, 153, 255));
        tambahBtn.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        tambahBtn.setText("Home");
        tambahBtn.setName(""); // NOI18N
        tambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(153, 153, 255));
        editBtn.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        editBtn.setText("Katalog");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KatalogBtnActionPerformed(evt);
            }
        });

        editBtn1.setBackground(new java.awt.Color(153, 153, 255));
        editBtn1.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        editBtn1.setText("Peminjaman");
        editBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtn1ActionPerformed(evt);
            }
        });

        editBtn2.setBackground(new java.awt.Color(153, 153, 255));
        editBtn2.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        editBtn2.setText("Dark Mode");
        editBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtn2ActionPerformed(evt);
            }
        });

        tambahBtn1.setBackground(new java.awt.Color(153, 153, 255));
        tambahBtn1.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        tambahBtn1.setText("Logout");
        tambahBtn1.setName(""); // NOI18N
        tambahBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tambahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editBtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tambahBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tambahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tambahBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("0");

        jLabel2.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel2.setText("Buku Dipinjam");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(90, 90, 90))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("0");

        jLabel4.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel4.setText("Deadline Terdekat");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("0");

        jLabel6.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel6.setText("Buku Dikembalikan");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(58, 58, 58))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        label3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label3.setText("Dashboard");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        label2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label2.setText("Rekomendasi Buku");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel8.setText("Judul Buku");

        jLabel9.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel9.setText("Penulis");

        jButton1.setBackground(new java.awt.Color(0, 204, 0));
        jButton1.setText("Pinjam");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pinjam1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel14.setText("Judul Buku");

        jLabel15.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel15.setText("Penulis");

        jButton4.setBackground(new java.awt.Color(0, 204, 0));
        jButton4.setText("Pinjam");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pinjam2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel16.setText("Judul Buku");

        jLabel17.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel17.setText("Penulis");

        jButton5.setBackground(new java.awt.Color(0, 204, 0));
        jButton5.setText("Pinjam");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pinjam3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel18.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel18.setText("Judul Buku");

        jLabel19.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel19.setText("Penulis");

        jButton6.setBackground(new java.awt.Color(0, 204, 0));
        jButton6.setText("Pinjam");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pinjam4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel20.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel20.setText("Judul Buku");

        jLabel21.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel21.setText("Penulis");

        jButton7.setBackground(new java.awt.Color(0, 204, 0));
        jButton7.setText("Pinjam");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7Pinjam4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeBtnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_HomeBtnActionPerformed
        // TODO add your handling code here:
        loadDataRekomendasi();
        loadStatistik();
    }//GEN-LAST:event_HomeBtnActionPerformed

    private void KatalogBtnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_KatalogBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new KatalogUser(currentUser).setVisible(true);
    }//GEN-LAST:event_KatalogBtnActionPerformed

    private void editBtn1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_editBtn1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new PeminjamanUser(currentUser).setVisible(true);
    }//GEN-LAST:event_editBtn1ActionPerformed

    private void editBtn2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_editBtn2ActionPerformed
        DarkMode.isDarkMode = !DarkMode.isDarkMode;
        setDarkMode(DarkMode.isDarkMode);
    }//GEN-LAST:event_editBtn2ActionPerformed

    private void Pinjam1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_Pinjam1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pinjam1ActionPerformed

    private void Pinjam2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_Pinjam2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pinjam2ActionPerformed

    private void Pinjam3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_Pinjam3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pinjam3ActionPerformed

    private void Pinjam4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_Pinjam4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pinjam4ActionPerformed

    private void jButton7Pinjam4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton7Pinjam4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7Pinjam4ActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        this.dispose();
        new loginPage().setVisible(true);
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void setDarkMode(boolean isDark) {
        if (isDark) {
            // Dark mode colors
            Color darkBg = new Color(44, 44, 44);
            Color darkPanel = new Color(60, 60, 60);
            Color darkText = Color.WHITE;
            Color darkButton = new Color(70, 70, 70);
            
            // Main panels
            jPanel1.setBackground(new Color(30, 30, 30));
            jPanel2.setBackground(darkBg);
            jPanel6.setBackground(darkBg);
            
            // Dashboard panels
            jPanel3.setBackground(darkPanel);
            jPanel4.setBackground(darkPanel);
            jPanel5.setBackground(darkPanel);
            
            // Book recommendation panels
            jPanel8.setBackground(darkPanel);
            jPanel11.setBackground(darkPanel);
            jPanel12.setBackground(darkPanel);
            jPanel13.setBackground(darkPanel);
            jPanel14.setBackground(darkPanel);
            
            // Labels
            label1.setForeground(darkText);
            label2.setForeground(darkText);
            label3.setForeground(darkText);
            jLabel1.setForeground(darkText);
            jLabel2.setForeground(darkText);
            jLabel3.setForeground(darkText);
            jLabel4.setForeground(darkText);
            jLabel5.setForeground(darkText);
            jLabel6.setForeground(darkText);
            jLabel8.setForeground(darkText);
            jLabel9.setForeground(darkText);
            jLabel14.setForeground(darkText);
            jLabel15.setForeground(darkText);
            jLabel16.setForeground(darkText);
            jLabel17.setForeground(darkText);
            jLabel18.setForeground(darkText);
            jLabel19.setForeground(darkText);
            jLabel20.setForeground(darkText);
            jLabel21.setForeground(darkText);
            
            // Buttons
            tambahBtn.setBackground(darkButton);
            tambahBtn.setForeground(darkText);
            editBtn.setBackground(darkButton);
            editBtn.setForeground(darkText);
            editBtn1.setBackground(darkButton);
            editBtn1.setForeground(darkText);
            editBtn2.setBackground(darkButton);
            editBtn2.setForeground(darkText);
            editBtn2.setText("Light Mode");
            tambahBtn1.setBackground(darkButton);
            tambahBtn1.setForeground(darkText);
            
        } else {
            // Light mode colors
            Color lightBg = Color.WHITE;
            Color lightPanel = Color.WHITE;
            Color lightText = Color.BLACK;
            
            // Main panels
            jPanel1.setBackground(new Color(102, 102, 255));
            jPanel2.setBackground(lightBg);
            jPanel6.setBackground(lightBg);
            
            // Dashboard panels
            jPanel3.setBackground(lightPanel);
            jPanel4.setBackground(lightPanel);
            jPanel5.setBackground(lightPanel);
            
            // Book recommendation panels
            jPanel8.setBackground(lightPanel);
            jPanel11.setBackground(lightPanel);
            jPanel12.setBackground(lightPanel);
            jPanel13.setBackground(lightPanel);
            jPanel14.setBackground(lightPanel);
            
            // Labels
            label1.setForeground(lightText);
            label2.setForeground(lightText);
            label3.setForeground(lightText);
            jLabel1.setForeground(lightText);
            jLabel2.setForeground(lightText);
            jLabel3.setForeground(lightText);
            jLabel4.setForeground(lightText);
            jLabel5.setForeground(lightText);
            jLabel6.setForeground(lightText);
            jLabel8.setForeground(lightText);
            jLabel9.setForeground(lightText);
            jLabel14.setForeground(lightText);
            jLabel15.setForeground(lightText);
            jLabel16.setForeground(lightText);
            jLabel17.setForeground(lightText);
            jLabel18.setForeground(lightText);
            jLabel19.setForeground(lightText);
            jLabel20.setForeground(lightText);
            jLabel21.setForeground(lightText);
            
            // Buttons
            tambahBtn.setBackground(new Color(153, 153, 255));
            tambahBtn.setForeground(lightText);
            editBtn.setBackground(new Color(153, 153, 255));
            editBtn.setForeground(lightText);
            editBtn1.setBackground(new Color(153, 153, 255));
            editBtn1.setForeground(lightText);
            editBtn2.setBackground(new Color(153, 153, 255));
            editBtn2.setForeground(lightText);
            editBtn2.setText("Dark Mode");
            tambahBtn1.setBackground(new Color(153, 153, 255));
            tambahBtn1.setForeground(lightText);
        }
        
        // Repaint to apply changes
        this.repaint();
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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | UnsupportedLookAndFeelException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        String username = "";
        EventQueue.invokeLater(() -> new DashboardUser(username).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editBtn;
    private javax.swing.JButton editBtn1;
    private javax.swing.JButton editBtn2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JButton tambahBtn;
    private javax.swing.JButton tambahBtn1;
    // End of variables declaration//GEN-END:variables
}