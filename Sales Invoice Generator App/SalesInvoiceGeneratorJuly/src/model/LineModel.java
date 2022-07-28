package model;

public class LineModel {

    private String item;
    private double price;
    private int count;
    private InvoiceModel invoice;
    
    public LineModel(String item, double price, int count, InvoiceModel invoice) {
        this.item = item;
        this.price = price;
        this.count = count;
        this.invoice = invoice;
    }
 

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public InvoiceModel getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceModel invoice) {
        this.invoice = invoice;
    }

    public double getTotalLine() {
        return getCount() * getPrice();
    }
    public String toCSV(){
        return invoice.getInvoiceNum()+","+item+","+price+","+count;
    }
}
