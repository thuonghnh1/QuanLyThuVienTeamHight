/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package quanlythuvien.ui;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import quanlythuvien.dao.PhieuMuonDAO;
import quanlythuvien.dao.ThongKeDAO;
import quanlythuvien.entity.PhieuMuon;
import quanlythuvien.utils.ExportFile;
import quanlythuvien.utils.MsgBox;
import quanlythuvien.utils.XImage;

/**
 *
 * @author NGUYENDINHNGHI
 * @author TRANTHITHUHA
 *
 */
public class ThongKeJDialog extends javax.swing.JDialog {

    ThongKeDAO tkDao = new ThongKeDAO();
    PhieuMuonDAO pmDao = new PhieuMuonDAO();
    boolean isBtnFilter = false;

    public ThongKeJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void init() {
//        this.setLocation(318, 73);
        this.setLocation(325, 74);
        this.setTitle("Thống Kê - Báo Cáo");
        this.setIconImage(XImage.getAppIcon());
        fillComboboxNam();
        fillComboxThang();
        txtTongTienPhatCacNam.setEditable(false);
        txtTongTienPhatTheoNam.setEditable(false);
        cboThangKetThuc.setSelectedItem(12);
        filter();
    }

    void fillComboboxNam() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNam.getModel();
        model.removeAllElements();
        List<Integer> list = pmDao.selectYear();
        for (Integer nam : list) {
            model.addElement(nam);
        }
    }

    void fillComboxThang() {
        DefaultComboBoxModel thangBD = (DefaultComboBoxModel) cboThangBatDau.getModel();
        DefaultComboBoxModel thangKT = (DefaultComboBoxModel) cboThangKetThuc.getModel();
        thangBD.removeAllElements();
        thangKT.removeAllElements();
        for (int i = 1; i < 13; i++) {
            thangBD.addElement(i);
            thangKT.addElement(i);
        }
    }

    void fillTable(List<Object[]> list) {
        DefaultTableModel model = (DefaultTableModel) tblThongKeMuonTra.getModel();
        model.setRowCount(0);
        long tongTienPhat = 0;
        for (Object[] row : list) {
            if (rdoTatCaCacNam.isSelected()) {
                tongTienPhat += Long.parseLong(row[7].toString());
                txtTongTienPhatCacNam.setText(tongTienPhat + "");
                txtTongTienPhatTheoNam.setText(0 + "");
            } else if (isBtnFilter) {
                tongTienPhat += Long.parseLong(row[7].toString());
                txtTongTienPhatTheoNam.setText(tongTienPhat + "");
                txtTongTienPhatCacNam.setText(0 + "");
            }
            model.addRow(new Object[]{row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8]});
        }
    }

    void filter() {
        Integer nam = Integer.valueOf(cboNam.getSelectedItem() + "");
        Integer thangBD = Integer.valueOf(cboThangBatDau.getSelectedItem() + "");
        Integer thangKT = Integer.valueOf(cboThangKetThuc.getSelectedItem() + "");
        String tinhTrang = "";
        String maDocGia = txtMaDocGiaTimKiem.getText().trim();
        if (rdoQuaHan.isSelected()) {
            tinhTrang = "Trả Quá hạn";
        } else if (rdoDungHan.isSelected()) {
            tinhTrang = "Trả Đúng hạn";
        } else if (rdoDenHanVaChuaTra.isSelected()) {
            tinhTrang = "Đến hạn mà chưa trả sách";
        } else if (rdoQuaHanVaChuaTra.isSelected()) {
            tinhTrang = "Quá hạn nhưng Chưa trả sách";
        } else if (rdoChuaDenHan.isSelected()) {
            tinhTrang = "Chưa đến hạn trả sách";
        } else {
            tinhTrang = "";
        }
        List<Object[]> list = tkDao.getMuonTraTheoLoai(nam, thangBD, thangKT, tinhTrang, maDocGia);
        System.out.println("listsizefilter:" + list.size());
        fillTable(list);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        lblTKVBC = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNam = new javax.swing.JLabel();
        lblThangBatDau = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        cboThangBatDau = new javax.swing.JComboBox<>();
        lblTatCaCac = new javax.swing.JLabel();
        lblThangKetThuc = new javax.swing.JLabel();
        cboThangKetThuc = new javax.swing.JComboBox<>();
        rdoTatCaCacNam = new javax.swing.JRadioButton();
        btnFilter = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        rdoQuaHan = new javax.swing.JRadioButton();
        rdoChuaDenHan = new javax.swing.JRadioButton();
        rdoDenHanVaChuaTra = new javax.swing.JRadioButton();
        rdoDungHan = new javax.swing.JRadioButton();
        rdoQuaHanVaChuaTra = new javax.swing.JRadioButton();
        txtMaDocGiaTimKiem = new javax.swing.JTextField();
        lblMaDocGia = new javax.swing.JLabel();
        btnXuatFile = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblTongTienPhatTheoNam = new javax.swing.JLabel();
        lblTongTienPhatCacNam = new javax.swing.JLabel();
        txtTongTienPhatTheoNam = new javax.swing.JTextField();
        txtTongTienPhatCacNam = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKeMuonTra = new javax.swing.JTable();
        lblLogo = new javax.swing.JLabel();
        btnThoat1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1100, 660));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lblTKVBC.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTKVBC.setForeground(new java.awt.Color(51, 102, 255));
        lblTKVBC.setText("Thống kê và báo cáo");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNam.setText("Năm:");

        lblThangBatDau.setText("Tháng Bắt Đầu :");

        cboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });

        cboThangBatDau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblTatCaCac.setText("Lọc tất cả  :");

        lblThangKetThuc.setText("Tháng Kết Thúc :");

        cboThangKetThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(rdoTatCaCacNam);
        rdoTatCaCacNam.setText("Tất cả theo các năm");
        rdoTatCaCacNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaCacNamActionPerformed(evt);
            }
        });

        btnFilter.setText("Lọc");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tình trạng trả sách"));

        buttonGroup2.add(rdoQuaHan);
        rdoQuaHan.setText("Quá hạn");

        buttonGroup2.add(rdoChuaDenHan);
        rdoChuaDenHan.setText("Chưa đến hạn");

        buttonGroup2.add(rdoDenHanVaChuaTra);
        rdoDenHanVaChuaTra.setText("Đến hạn và chưa trả");
        rdoDenHanVaChuaTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDenHanVaChuaTraActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoDungHan);
        rdoDungHan.setText("Đúng hạn");
        rdoDungHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDungHanActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoQuaHanVaChuaTra);
        rdoQuaHanVaChuaTra.setText("Quá hạn và chưa trả");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(rdoQuaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoDungHan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdoChuaDenHan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdoDenHanVaChuaTra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdoQuaHanVaChuaTra)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoQuaHan)
                    .addComponent(rdoChuaDenHan)
                    .addComponent(rdoDenHanVaChuaTra)
                    .addComponent(rdoDungHan)
                    .addComponent(rdoQuaHanVaChuaTra))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        lblMaDocGia.setText("Mã Độc giả:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMaDocGia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaDocGiaTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(411, 411, 411))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblThangBatDau)
                                .addGap(18, 18, 18)
                                .addComponent(cboThangBatDau, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblThangKetThuc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboThangKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88)
                        .addComponent(lblTatCaCac)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoTatCaCacNam)
                        .addGap(117, 117, 117))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTatCaCac)
                        .addComponent(rdoTatCaCacNam))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblThangBatDau)
                        .addComponent(cboThangBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblThangKetThuc)
                        .addComponent(cboThangKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNam)))
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilter)
                    .addComponent(txtMaDocGiaTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaDocGia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnXuatFile.setText("Xuất FIle ");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTongTienPhatTheoNam.setText("Tổng tiền phạt theo năm:");

        lblTongTienPhatCacNam.setText("Tổng tiền phạt các năm:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTongTienPhatTheoNam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongTienPhatTheoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTongTienPhatCacNam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongTienPhatCacNam, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongTienPhatTheoNam)
                    .addComponent(lblTongTienPhatCacNam)
                    .addComponent(txtTongTienPhatTheoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTienPhatCacNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        tblThongKeMuonTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PM", "Mã Độc giả", "Tên Độc giả", "Ngày mượn", "Ngày hẹn trả", "Ngày trả", "Số ngày trễ", "Tiền phạt", "Tình trạng trả sách"
            }
        ));
        jScrollPane1.setViewportView(tblThongKeMuonTra);
        if (tblThongKeMuonTra.getColumnModel().getColumnCount() > 0) {
            tblThongKeMuonTra.getColumnModel().getColumn(0).setPreferredWidth(25);
            tblThongKeMuonTra.getColumnModel().getColumn(1).setPreferredWidth(40);
        }

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlythuvien/icon/logoLibNgang.png"))); // NOI18N

        btnThoat1.setBackground(new java.awt.Color(255, 51, 51));
        btnThoat1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThoat1.setText("X");
        btnThoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoat1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnXuatFile)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addGap(193, 193, 193)
                        .addComponent(lblTKVBC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThoat1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogo)
                            .addComponent(lblTKVBC, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnThoat1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXuatFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNamActionPerformed

    private void rdoTatCaCacNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaCacNamActionPerformed
        List<Object[]> list = tkDao.getMuonTraTheoCacNam();
        fillTable(list);
        isBtnFilter = false;
    }//GEN-LAST:event_rdoTatCaCacNamActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        isBtnFilter = true;
        filter();
    }//GEN-LAST:event_btnFilterActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    private void rdoDungHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDungHanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoDungHanActionPerformed

    private void rdoDenHanVaChuaTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDenHanVaChuaTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoDenHanVaChuaTraActionPerformed

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        if (tblThongKeMuonTra.getRowCount() == 0) {
            MsgBox.alert(this, "Không có dữ liệu để xuất!");
        } else {
            String tieuDe = "";
            if (rdoDungHan.isSelected()) {
                tieuDe = "Trả sách đúng hạn";
            } else if (rdoQuaHan.isSelected()) {
                tieuDe = "Trả sách quá hạn";
            } else if (rdoChuaDenHan.isSelected()) {
                tieuDe = "Chưa đến hạn trả sách";
            } else if (rdoDenHanVaChuaTra.isSelected()) {
                tieuDe = "Đến hạn và chưa trả";
            } else if (rdoQuaHanVaChuaTra.isSelected()) {
                tieuDe = "Quá hạn và chưa trả sách";
            } else {
                tieuDe = "Tình hình mượn trả";
            }
            ExportFile.exportToExcel(this, tblThongKeMuonTra, tieuDe);
        }

    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void btnThoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoat1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoat1ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongKeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThongKeJDialog dialog = new ThongKeJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnThoat1;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboThangBatDau;
    private javax.swing.JComboBox<String> cboThangKetThuc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMaDocGia;
    private javax.swing.JLabel lblNam;
    private javax.swing.JLabel lblTKVBC;
    private javax.swing.JLabel lblTatCaCac;
    private javax.swing.JLabel lblThangBatDau;
    private javax.swing.JLabel lblThangKetThuc;
    private javax.swing.JLabel lblTongTienPhatCacNam;
    private javax.swing.JLabel lblTongTienPhatTheoNam;
    private javax.swing.JRadioButton rdoChuaDenHan;
    private javax.swing.JRadioButton rdoDenHanVaChuaTra;
    private javax.swing.JRadioButton rdoDungHan;
    private javax.swing.JRadioButton rdoQuaHan;
    private javax.swing.JRadioButton rdoQuaHanVaChuaTra;
    private javax.swing.JRadioButton rdoTatCaCacNam;
    private javax.swing.JTable tblThongKeMuonTra;
    private javax.swing.JTextField txtMaDocGiaTimKiem;
    private javax.swing.JTextField txtTongTienPhatCacNam;
    private javax.swing.JTextField txtTongTienPhatTheoNam;
    // End of variables declaration//GEN-END:variables
}
