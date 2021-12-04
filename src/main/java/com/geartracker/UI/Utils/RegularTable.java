package com.geartracker.UI.Utils;

import javax.swing.JTable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class RegularTable extends JTable{

    RegularTableModel tableModel;
    public RegularTable(ArrayList<ArrayList<Object>> data, ArrayList<String> columnNames){

        tableModel = new RegularTableModel(data, columnNames);
        setModel(tableModel);
    }

    public void setData(ArrayList<ArrayList<Object>> data){
        tableModel.setData(data);
        repaint();
    }
    
}

class RegularTableModel extends AbstractTableModel{

    private ArrayList<String> columnNames;
    private ArrayList<ArrayList<Object>> data;

    public RegularTableModel(ArrayList<ArrayList<Object>> data, ArrayList<String> columnNames){
                
        this.columnNames = columnNames;
        this.data = data;

    }

    public void setData(ArrayList<ArrayList<Object>> data){
        this.data = data;
        fireTableDataChanged();
    }

    public int getColumnCount(){
        return columnNames.size();
    }

    public int getRowCount(){
        return data.size();
    }

    public Object getValueAt(int row, int col){
        return data.get(row).get(col);
    }

    public String getColumnName(int column){

        return columnNames.get(column);
    }

    public Class<?> getColumnClass(int c){
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col){

        return false;
    }


}
