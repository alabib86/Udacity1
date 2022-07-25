/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Dialog;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class NewInvoiceFrame extends JDialog {

    private JLabel invNumlbl;
    public JLabel invNumtxt;

    private JButton createInvbtn;
    private JButton addLinesbtn;

    private JPanel pnl1;
    private JPanel pnl2;

    public JTable tbl;
    public JTable tbl2;



    public NewInvoiceFrame(MainFrame frame) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        invNumlbl = new JLabel("Invoice ID :");
        invNumtxt = new JLabel();

        pnl1 = new JPanel();
        pnl2 = new JPanel();

        tbl = new JTable();
        tbl.setModel(new DefaultTableModel(
                new Object[][]{null},
                new String[]{
                    "Date", "Cutomer"
                }
        ));
        tbl2 = new JTable();
        tbl2.setModel(new DefaultTableModel(
                new Object[][]{null},
                new String[]{
                    "Item Name", "Item Price", "Count"
                }
        ));

        createInvbtn = new JButton("Create Invoice");
        addLinesbtn = new JButton("Add Line");

        createInvbtn.addActionListener(frame.getMyListner());
        addLinesbtn.addActionListener(frame.getMyListner());
        createInvbtn.setActionCommand("Create");
        addLinesbtn.setActionCommand("Add");

        add(pnl1);
        add(pnl2);

        pnl1.add(invNumlbl);
        pnl1.add(invNumtxt);
        pnl1.add(new JScrollPane(tbl));
        pnl1.add(createInvbtn);

        pnl2.add(new JScrollPane(tbl2));
        pnl2.add(addLinesbtn);

        setModal(true);
        setLocation(200, 100);
        setSize(1000, 700);
    }

}
