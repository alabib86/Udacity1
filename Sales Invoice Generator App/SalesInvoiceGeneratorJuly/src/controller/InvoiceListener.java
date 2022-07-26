/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.InvoiceModel;
import model.InvoiceTableModel;
import model.LineModel;
import model.LineTableModel;
import view.MainFrame;
import view.NewInvoiceFrame;
import view.NewLineFrame;

public class InvoiceListener implements ActionListener, ListSelectionListener {

    private MainFrame frame;
    private NewInvoiceFrame newInvoiceFrame;
    private NewLineFrame newLineFrame;

    public InvoiceListener(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Load File":
                loadFile(null, null);
                break;
            case "Save File":
                saveFile(null, null);
                break;
            case "New":
                newInvoice();
                break;
            case "Delete":
                deleteInvoice();
                break;
            case "New Item":
                newItem();
                break;
            case "Delete Item":
                deleteItem();
                break;
            case "Create Header":
                createHeader();

                break;
            case "Cancel Header":
                cancelHeader();
                break;
            case "Ok":
                ok();
                break;
            case "Cancel Adding":
                cancelAdding();
                break;

        };
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = frame.invTable.getSelectedRow();

        if (selectedRow > -1 && selectedRow < frame.getInvoices().size()) {

            InvoiceModel inv = frame.getInvoices().get(selectedRow);

            frame.lblInvNum.setText("" + inv.getInvoiceNum());
            frame.lblInvDate.setText(MainFrame.dFormat.format(inv.getDate()));
            frame.lblCusName.setText(inv.getCustomerName());
            frame.lblInvTotal.setText("" + inv.getTotalInvoice());

            List<LineModel> lines = inv.getLines();
            frame.itemsTable.setModel(new LineTableModel(lines));

        } else {
            frame.lblInvNum.setText("");
            frame.lblInvDate.setText("");
            frame.lblCusName.setText("");
            frame.lblInvTotal.setText("");

            frame.itemsTable.setModel(new LineTableModel(new ArrayList<LineModel>()));

        }
    }

    public void loadFile(String headerPath, String linePath) {

        File headerFile = null;
        File lineFile = null;
        if (headerPath == null) {
            JFileChooser fileChooser = new JFileChooser();
            // filter on csv files only
//            FileNameExtensionFilter filter = new FileNameExtensionFilter("", "csv");
//            fileChooser.setFileFilter(filter);
            int x = fileChooser.showOpenDialog(frame);
            if (x == JFileChooser.APPROVE_OPTION) {
                headerFile = fileChooser.getSelectedFile();
                x = fileChooser.showOpenDialog(frame);
                if (x == JFileChooser.APPROVE_OPTION) {
                    lineFile = fileChooser.getSelectedFile();
                } else {
                    JOptionPane.showMessageDialog(frame, "Second File Not Found Please Try Again", "Erorr Message", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "First File Not Found Please Try Again", "Erorr Message", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            headerFile = new File(headerPath);
            lineFile = new File(linePath);
        }
        if (headerFile != null && lineFile != null) {
            if (getExtension(lineFile).equals("csv") && getExtension(headerFile).equals("csv")) {
                try {

                    List<String> headerList = Files.lines(Paths.get(headerFile.getAbsolutePath())).collect(Collectors.toList());
                    List<String> lineList = Files.lines(Paths.get(lineFile.getAbsolutePath())).collect(Collectors.toList());

                    int v = 0;
                    int i = 0;
                    for (String headerSt : headerList) {
                        String[] row = headerSt.split(",");
                        String numString = row[0];
                        String dateString = row[1];
                        String customerName = row[2];

                        int num = Integer.parseInt(numString);
                        Date date = frame.dFormat.parse(dateString);

                        InvoiceModel inv = new InvoiceModel(num, date, customerName);
                        frame.getInvoices().add(inv);
                    }

                    for (String lineSt : lineList) {
                        String[] rowLine = lineSt.split(",");
                        String invNumString = rowLine[0];
                        String itemName = rowLine[1];
                        String itemPrice = rowLine[2];
                        String countString = rowLine[3];

                        int invNum = Integer.parseInt(invNumString);
                        int count = Integer.parseInt(countString);
                        double price = Double.parseDouble(itemPrice);

                        InvoiceModel inv = getInvoiveByNum(invNum);
                        LineModel line = new LineModel(itemName, price, count, inv);
                        inv.getLines().add(line);
                        frame.invTable.setModel(new InvoiceTableModel(frame.getInvoices()));

                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "Wrong Date Format", "Erorr Message", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please Choose a csv File", "Erorr Message", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void saveFile(String headerPath, String linePath) {

        File headerFile = null;
        File lineFile = null;

        if (headerPath == null && linePath == null) {
            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            JOptionPane.showMessageDialog(frame, "Choose Path of First File", "Erorr Message", JOptionPane.PLAIN_MESSAGE);
            fileChooser.setSelectedFile(new File("InvoiceHeader"));
            int x = fileChooser.showSaveDialog(frame);
            if (x == JFileChooser.APPROVE_OPTION) {
                headerFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(frame, "Choose Path of Second File", "Erorr Message", JOptionPane.PLAIN_MESSAGE);
                fileChooser.setSelectedFile(new File("InvoiceLine"));
                x = fileChooser.showSaveDialog(frame);
                if (x == JFileChooser.APPROVE_OPTION) {
                    lineFile = fileChooser.getSelectedFile();

                } else {
                    JOptionPane.showMessageDialog(frame, "File Not Found Please Try Again", "Erorr Message", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "File Not Found Please Try Again", "Erorr Message", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            headerFile = new File(headerPath);
            lineFile = new File(linePath);
        }
        if (headerFile != null && lineFile != null) {
            if (headerFile.getName().equals("InvoiceHeader") && lineFile.getName().equals("InvoiceLine")) {
                try {

                    FileWriter fwHeader = new FileWriter(Paths.get(headerFile.getAbsolutePath()) + ".csv");
                    BufferedWriter bwHeader = new BufferedWriter(fwHeader);
                    for (int i = 0; i < frame.getInvoices().size(); i++) {
                        bwHeader.write(frame.getInvoices().get(i).getInvoiceNum() + ",");
                        bwHeader.write(frame.getInvoices().get(i).getDate() + ",");
                        bwHeader.write(frame.getInvoices().get(i).getCustomerName());
                        bwHeader.newLine();
                    }
                    bwHeader.close();
                    fwHeader.close();
                    FileWriter fwLine = new FileWriter(Paths.get(lineFile.getAbsolutePath()) + ".csv");
                    BufferedWriter bwLine = new BufferedWriter(fwLine);
                    for (int i = 0; i < frame.getInvoices().size(); i++) {
                        for (int j = 0; j < frame.getInvoices().get(i).getLines().size(); j++) {
                            bwLine.write(frame.getInvoices().get(i).getInvoiceNum() + ",");
                            bwLine.write(frame.getInvoices().get(i).getLines().get(j).getItem() + ",");
                            bwLine.write(frame.getInvoices().get(i).getLines().get(j).getPrice() + ",");
                            bwLine.write(frame.getInvoices().get(i).getLines().get(j).getCount() + "");
                            bwLine.newLine();

                        }
                    }
                    bwLine.close();
                    fwLine.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Wrong File Format", "Erorr Message", JOptionPane.ERROR_MESSAGE);
                }
            }else{JOptionPane.showMessageDialog(frame, "Please Don't Change Files Names or Format", "Erorr Message", JOptionPane.ERROR_MESSAGE);}
        }

    }

    private void newInvoice() {
        newInvoiceFrame = new NewInvoiceFrame(frame);
        newInvoiceFrame.invNumtxt.setText(Integer.toString(getNextInvNum()));
        newInvoiceFrame.setVisible(true);

    }

    private void deleteInvoice() {
        int x = frame.invTable.getSelectedRow();
        if (x != -1) {
            frame.getInvoices().remove(x);
            ((InvoiceTableModel) frame.invTable.getModel()).fireTableDataChanged();
        }

    }

    private void newItem() {
        newLineFrame = new NewLineFrame(frame);
        newLineFrame.setVisible(true);
    }

    private void deleteItem() {
        int selectedRow = frame.itemsTable.getSelectedRow();
        if (selectedRow != -1) {
            int hRow = frame.invTable.getSelectedRow();
            LineTableModel lineTableModel = (LineTableModel) frame.itemsTable.getModel();
            lineTableModel.getLines().remove(selectedRow);
            lineTableModel.fireTableDataChanged();
            ((InvoiceTableModel) frame.invTable.getModel()).fireTableDataChanged();
            frame.invTable.setRowSelectionInterval(hRow, hRow);

        }
    }

    private InvoiceModel getInvoiveByNum(int num) {

        for (InvoiceModel inv : frame.getInvoices()) {
            if (num == inv.getInvoiceNum()) {
                return inv;
            }
        }
        return null;
    }

    private void cancelHeader() {
        newInvoiceFrame.setVisible(false);
        newInvoiceFrame.dispose();
    }

    private void createHeader() {

        String dateStr = (String) newInvoiceFrame.datetxt.getText();
        String customerName = (String) newInvoiceFrame.cusNametxt.getText();
        newInvoiceFrame.setVisible(false);
        newInvoiceFrame.dispose();
        try {
            Date date = frame.dFormat.parse(dateStr);
            InvoiceModel inv = new InvoiceModel(getNextInvNum(), date, customerName);
            frame.getInvoices().add(inv);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Erorr Date Format (dd-MM-yyy)", "Error", JOptionPane.ERROR_MESSAGE);
        }

        frame.invTable.setModel(new InvoiceTableModel(frame.getInvoices()));

        ((InvoiceTableModel) frame.invTable.getModel()).fireTableDataChanged();
    }

    private int getNextInvNum() {
        int num = 1;
        for (InvoiceModel inv : frame.getInvoices()) {
            if (inv.getInvoiceNum() > num) {
                num = inv.getInvoiceNum();
            }
        }
        return num + 1;
    }

    private void ok() {
        int selectedRow = frame.invTable.getSelectedRow();
        if (selectedRow != -1) {
            String itemName = newLineFrame.itemNametxt.getText();
            String itemPrice = newLineFrame.itemPricetxt.getText();
            String itemCount = newLineFrame.counttxt.getText();

            newLineFrame.setVisible(false);
            newLineFrame.dispose();

            double price = Double.parseDouble(itemPrice);
            int count = Integer.parseInt(itemCount);

            InvoiceModel inv = frame.getInvoices().get(selectedRow);

            LineModel line = new LineModel(itemName, price, count, inv);

            inv.getLines().add(line);
            frame.invTable.setModel(new InvoiceTableModel(frame.getInvoices()));
            ((InvoiceTableModel) frame.invTable.getModel()).fireTableDataChanged();
        }
    }

    private void cancelAdding() {
        newLineFrame.setVisible(false);
        newLineFrame.dispose();
    }

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

}
