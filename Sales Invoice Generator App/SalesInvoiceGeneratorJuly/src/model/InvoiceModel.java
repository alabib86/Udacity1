
package model;

import java.util.ArrayList;
import java.util.Date;
import view.MainFrame;


public class InvoiceModel {
    private int invoiceNum;
    private Date date;
    private String customerName;
    private ArrayList<LineModel> lines;

    public InvoiceModel(int invoiceNum, Date date, String customerName) {
        this.invoiceNum = invoiceNum;
        this.date = date;
        this.customerName = customerName;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<LineModel> getLines() {
        if(lines == null){
        lines=new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<LineModel> lines) {
        this.lines = lines;
    }

    public double getTotalInvoice(){
        double total = 0.0;
        for(LineModel line:getLines()){
        total += line.getTotalLine();
        }
        return total;
    }
    public String toCSV(){
        return invoiceNum+","+MainFrame.dFormat.format(date)+","+customerName;
    }
}


