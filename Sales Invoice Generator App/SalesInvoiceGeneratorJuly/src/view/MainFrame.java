/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.InvoiceListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.InvoiceModel;
import model.InvoiceTableModel;

/**
 *
 * @author dell
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        super(" Sales Invoice Generator");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invTable = new javax.swing.JTable();
        invTable.getSelectionModel().addListSelectionListener(myListner);
        btnNewInv = new javax.swing.JButton();
        btnNewInv.addActionListener(myListner);
        btnDelInv = new javax.swing.JButton();
        btnDelInv.addActionListener(myListner);
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblInvNum = new javax.swing.JLabel();
        lblInvDate = new javax.swing.JLabel();
        lblCusName = new javax.swing.JLabel();
        lblInvTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        btnNewItem = new javax.swing.JButton();
        btnNewItem.addActionListener(myListner);
        btnDeleteItem = new javax.swing.JButton();
        btnDeleteItem.addActionListener(myListner);
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        btnLoadFile = new javax.swing.JMenuItem();
        btnLoadFile.addActionListener(myListner);
        btnSaveFile = new javax.swing.JMenuItem();
        btnSaveFile.addActionListener(myListner);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 700));

        jLabel1.setText("Invoices Table");

        invTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Date", "Cutomer", "Total"
            }
        ));
        jScrollPane1.setViewportView(invTable);

        btnNewInv.setText("New");

        btnDelInv.setText("Delete");

        jLabel2.setText("Invoice Number");

        jLabel3.setText("Invoice Date");

        jLabel4.setText("Customer Name");

        jLabel5.setText("Invoice Total");

        lblInvNum.setText("   ");

        lblInvDate.setText("  ");

        lblCusName.setText("  ");

        lblInvTotal.setText("  ");

        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Item Name", "Price", "Count", "Total"
            }
        ));
        jScrollPane2.setViewportView(itemsTable);

        btnNewItem.setText("New Item");

        btnDeleteItem.setText("Delete Item");

        jLabel6.setText("Items");

        fileMenu.setText("File");

        btnLoadFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnLoadFile.setText("Load File");
        fileMenu.add(btnLoadFile);

        btnSaveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnSaveFile.setText("Save File");
        fileMenu.add(btnSaveFile);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblInvNum, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(lblInvDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCusName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblInvTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))))
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(btnNewInv)
                .addGap(54, 54, 54)
                .addComponent(btnDelInv)
                .addGap(269, 269, 269)
                .addComponent(btnNewItem)
                .addGap(72, 72, 72)
                .addComponent(btnDeleteItem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(lblInvNum))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblInvDate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblCusName))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblInvTotal))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelInv)
                    .addComponent(btnNewInv)
                    .addComponent(btnNewItem)
                    .addComponent(btnDeleteItem))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setVisible(true);
                mainFrame.myListner.loadFile("InvoiceHeader.csv", "InvoiceLine.csv");

                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelInv;
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JMenuItem btnLoadFile;
    private javax.swing.JButton btnNewInv;
    private javax.swing.JButton btnNewItem;
    private javax.swing.JMenuItem btnSaveFile;
    private javax.swing.JMenu fileMenu;
    public javax.swing.JTable invTable;
    public javax.swing.JTable itemsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblCusName;
    public javax.swing.JLabel lblInvDate;
    public javax.swing.JLabel lblInvNum;
    public javax.swing.JLabel lblInvTotal;
    // End of variables declaration//GEN-END:variables
    private InvoiceListener myListner = new InvoiceListener(this);
    public static SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
    private ArrayList<InvoiceModel> invoices ;
    private InvoiceTableModel invoiceTableModel;

    public ArrayList<InvoiceModel> getInvoices() {
        if(invoices==null){
            invoices=new ArrayList<>();
    }
        return invoices;
    }

    public void setInvoices(ArrayList<InvoiceModel> invoices) {
        this.invoices = invoices;
    }

    public InvoiceTableModel getInvoiceTableModel() {
        return invoiceTableModel;
    }

    public void setInvoiceTableModel(InvoiceTableModel invoiceTableModel) {
        this.invoiceTableModel = invoiceTableModel;
    }

    public InvoiceListener getMyListner() {
        return myListner;
    }

}
