package com.mycompany.tr_ast_pbo.user;

import logic.FiturUser;
import objek.Buku;
import java.util.List;

public class DashboardUser extends javax.swing.JFrame {

    private String userID;
    private FiturUser logic = new FiturUser();
    private List<Buku> listBuku; // Menyimpan data buku untuk ditampilkan di dashboard

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DashboardUser.class.getName());

    public DashboardUser(String userID) {
        this.userID = userID;
        initComponents();
        loadData();
    }

    private void loadData() {
        label1.setText("Selamat Datang, " + userID);
        jLabel1.setText(logic.getJumlahBukuDipinjam(userID));

        listBuku = logic.getListBuku("");

        clearSlots();

        if (listBuku != null) {
            if (listBuku.size() > 0) isiSlot1(listBuku.get(0));
            if (listBuku.size() > 1) isiSlot2(listBuku.get(1));
            if (listBuku.size() > 2) isiSlot3(listBuku.get(2));
            if (listBuku.size() > 3) isiSlot4(listBuku.get(3));
            if (listBuku.size() > 4) isiSlot5(listBuku.get(4));
        }
    }

    private void clearSlots() {
        jLabel8.setText("-"); jLabel9.setText("-"); jButton1.setEnabled(false);
        jLabel14.setText("-"); jLabel15.setText("-"); jButton4.setEnabled(false);
        jLabel16.setText("-"); jLabel17.setText("-"); jButton5.setEnabled(false);
        jLabel18.setText("-"); jLabel19.setText("-"); jButton6.setEnabled(false);
        jLabel20.setText("-"); jLabel21.setText("-"); jButton7.setEnabled(false);
    }

    private void isiSlot1(Buku b) { jLabel8.setText(b.getNama_buku()); jLabel9.setText(b.getPenulis()); jButton1.setEnabled(true); }
    private void isiSlot2(Buku b) { jLabel14.setText(b.getNama_buku()); jLabel15.setText(b.getPenulis()); jButton4.setEnabled(true); }
    private void isiSlot3(Buku b) { jLabel16.setText(b.getNama_buku()); jLabel17.setText(b.getPenulis()); jButton5.setEnabled(true); }
    private void isiSlot4(Buku b) { jLabel18.setText(b.getNama_buku()); jLabel19.setText(b.getPenulis()); jButton6.setEnabled(true); }
    private void isiSlot5(Buku b) { jLabel20.setText(b.getNama_buku()); jLabel21.setText(b.getPenulis()); jButton7.setEnabled(true); }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        tambahBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        editBtn1 = new javax.swing.JButton();
        editBtn2 = new javax.swing.JButton();
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

        label1.setFont(new java.awt.Font("Serif", 1, 18));
        label1.setText("Perpustakaan Digital");

        tambahBtn.setBackground(new java.awt.Color(153, 153, 255));
        tambahBtn.setFont(new java.awt.Font("Serif", 1, 14));
        tambahBtn.setText("Home");
        tambahBtn.addActionListener(evt -> HomeBtnActionPerformed(evt));

        editBtn.setBackground(new java.awt.Color(153, 153, 255));
        editBtn.setFont(new java.awt.Font("Serif", 1, 14));
        editBtn.setText("Katalog");
        editBtn.addActionListener(evt -> KatalogBtnActionPerformed(evt));

        editBtn1.setBackground(new java.awt.Color(153, 153, 255));
        editBtn1.setFont(new java.awt.Font("Serif", 1, 14));
        editBtn1.setText("Peminjaman");
        editBtn1.addActionListener(evt -> editBtn1ActionPerformed(evt));

        editBtn2.setBackground(new java.awt.Color(153, 153, 255));
        editBtn2.setFont(new java.awt.Font("Serif", 1, 14));
        editBtn2.setText("Dark Mode");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tambahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editBtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editBtn2)
                                .addGap(30, 30, 30))
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
                                                .addComponent(editBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); jLabel1.setText("0");
        jLabel2.setFont(new java.awt.Font("Serif", 0, 14)); jLabel2.setText("Buku Dipinjam");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); jLabel3.setText("0");
        jLabel4.setFont(new java.awt.Font("Serif", 0, 14)); jLabel4.setText("Deadline Terdekat");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); jLabel5.setText("0");
        jLabel6.setFont(new java.awt.Font("Serif", 0, 14)); jLabel6.setText("Buku Dikembalikan");

        label3.setFont(new java.awt.Font("Serif", 1, 18)); label3.setText("Dashboard");

        // Layout Statistik (Sederhana Manual)
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3); jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap(78, Short.MAX_VALUE).addComponent(jLabel2).addGap(90, 90, 90)).addGroup(jPanel3Layout.createSequentialGroup().addGap(98, 98, 98).addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap(24, Short.MAX_VALUE).addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4); jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(62, 62, 62).addComponent(jLabel4)).addGroup(jPanel4Layout.createSequentialGroup().addGap(88, 88, 88).addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(72, Short.MAX_VALUE)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5); jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap(60, Short.MAX_VALUE).addComponent(jLabel6).addGap(58, 58, 58)).addGroup(jPanel5Layout.createSequentialGroup().addGap(89, 89, 89).addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap(20, Short.MAX_VALUE).addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2); jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(143, 143, 143).addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(jPanel2Layout.createSequentialGroup().addGap(38, 38, 38).addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(29, 29, 29)));

        label2.setFont(new java.awt.Font("Serif", 1, 18));
        label2.setText("List Buku Terbaru"); // Ganti judul

        setupBookPanel(jPanel8, jLabel8, jLabel9, jButton1, evt -> jButton1PinjamActionPerformed(evt));
        setupBookPanel(jPanel11, jLabel14, jLabel15, jButton4, evt -> jButton4PinjamActionPerformed(evt));
        setupBookPanel(jPanel12, jLabel16, jLabel17, jButton5, evt -> jButton5PinjamActionPerformed(evt));
        setupBookPanel(jPanel13, jLabel18, jLabel19, jButton6, evt -> jButton6PinjamActionPerformed(evt));
        setupBookPanel(jPanel14, jLabel20, jLabel21, jButton7, evt -> jButton7PinjamActionPerformed(evt));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6); jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(37, 37, 37).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(jPanel6Layout.createSequentialGroup().addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(76, Short.MAX_VALUE)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(20, 20, 20).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap(112, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane()); getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));

        pack();
    }// </editor-fold>
    private void setupBookPanel(javax.swing.JPanel panel, javax.swing.JLabel lTitle, javax.swing.JLabel lAuthor, javax.swing.JButton btn, java.awt.event.ActionListener action) {
        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lTitle.setFont(new java.awt.Font("Serif", 0, 14)); lTitle.setText("Judul Buku");
        lAuthor.setFont(new java.awt.Font("Serif", 0, 14)); lAuthor.setText("Penulis");
        btn.setBackground(new java.awt.Color(0, 204, 0)); btn.setText("Pinjam");
        btn.addActionListener(action);

        javax.swing.GroupLayout l = new javax.swing.GroupLayout(panel); panel.setLayout(l);
        l.setHorizontalGroup(l.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(l.createSequentialGroup().addContainerGap().addGroup(l.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(btn, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE).addGroup(l.createSequentialGroup().addGroup(l.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lTitle).addComponent(lAuthor)).addGap(0, 0, Short.MAX_VALUE))).addContainerGap()));
        l.setVerticalGroup(l.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(l.createSequentialGroup().addContainerGap().addComponent(lTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btn).addContainerGap()));
    }

    private void HomeBtnActionPerformed(java.awt.event.ActionEvent evt) { loadData(); }
    private void KatalogBtnActionPerformed(java.awt.event.ActionEvent evt) { new KatalogUser(this.userID).setVisible(true); this.dispose(); }
    private void editBtn1ActionPerformed(java.awt.event.ActionEvent evt) { new PeminjamanUser(this.userID).setVisible(true); this.dispose(); }

    private void processPinjam(int index) {
        if (listBuku != null && listBuku.size() > index) {
            logic.prosesPinjam(this.userID, listBuku.get(index));
            loadData();
        }
    }
    private void jButton1PinjamActionPerformed(java.awt.event.ActionEvent evt) { processPinjam(0); }
    private void jButton4PinjamActionPerformed(java.awt.event.ActionEvent evt) { processPinjam(1); }
    private void jButton5PinjamActionPerformed(java.awt.event.ActionEvent evt) { processPinjam(2); }
    private void jButton6PinjamActionPerformed(java.awt.event.ActionEvent evt) { processPinjam(3); }
    private void jButton7PinjamActionPerformed(java.awt.event.ActionEvent evt) { processPinjam(4); }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new DashboardUser("TEST_USER").setVisible(true));
    }

    private javax.swing.JButton editBtn; private javax.swing.JButton editBtn1; private javax.swing.JButton editBtn2;
    private javax.swing.JButton jButton1; private javax.swing.JButton jButton4; private javax.swing.JButton jButton5; private javax.swing.JButton jButton6; private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1; private javax.swing.JLabel jLabel14; private javax.swing.JLabel jLabel15; private javax.swing.JLabel jLabel16; private javax.swing.JLabel jLabel17; private javax.swing.JLabel jLabel18; private javax.swing.JLabel jLabel19; private javax.swing.JLabel jLabel2; private javax.swing.JLabel jLabel20; private javax.swing.JLabel jLabel21; private javax.swing.JLabel jLabel3; private javax.swing.JLabel jLabel4; private javax.swing.JLabel jLabel5; private javax.swing.JLabel jLabel6; private javax.swing.JLabel jLabel8; private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1; private javax.swing.JPanel jPanel11; private javax.swing.JPanel jPanel12; private javax.swing.JPanel jPanel13; private javax.swing.JPanel jPanel14; private javax.swing.JPanel jPanel2; private javax.swing.JPanel jPanel3; private javax.swing.JPanel jPanel4; private javax.swing.JPanel jPanel5; private javax.swing.JPanel jPanel6; private javax.swing.JPanel jPanel8;
    private java.awt.Label label1; private java.awt.Label label2; private java.awt.Label label3;
    private javax.swing.JButton tambahBtn;
}