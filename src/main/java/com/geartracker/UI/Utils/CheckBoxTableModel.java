package com.geartracker.UI.Utils;

import javax.swing.table.AbstractTableModel;

public class CheckBoxTableModel extends AbstractTableModel{
    
    private String[] columnNames;
    private Object[][] data;


    public CheckBoxTableModel(Object data[][], String columnNames[]){
        
    
        
        this.columnNames = columnNames;
        this.data = data;

    }

    

    public int getColumnCount(){
        return columnNames.length;
    }

    public int getRowCount(){
        return data.length;
    }

    public Object getValueAt(int row, int col){
        return data[row][col];
    }

    public Class<?> getColumnClass(int c){
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col){

        if(col == getColumnCount()-1)
            return true;
        else 
            return false;
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}
