/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dell
 */
public class LineTableModel extends AbstractTableModel {

    private String[] col = { "Item Name", "Item Price", "Count", "Items Total"};
    private List<LineModel> lines;

    public LineTableModel(List<LineModel> lines) {
        this.lines = lines;
    }

    public List<LineModel> getLines() {
        return lines;
    }
    

    @Override
    public int getRowCount() {
        return lines.size();
    }

    @Override
    public int getColumnCount() {
        return col.length;
    }

    @Override
    public String getColumnName(int column) {
        return col[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LineModel line=lines.get(rowIndex);
        switch(columnIndex){
        case 0: return line.getItem();
        case 1: return line.getPrice();
        case 2: return line.getCount();
        case 3: return line.getTotalLine();
        }
        return "";
    }

}
