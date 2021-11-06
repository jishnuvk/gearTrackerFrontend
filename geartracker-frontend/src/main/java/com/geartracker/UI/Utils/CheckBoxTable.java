package com.geartracker.UI.Utils;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class CheckBoxTable extends JTable{

    public CheckBoxTable(ArrayList<ArrayList<Object>> data, ArrayList<String> columnNames){

        
        super(new CheckBoxTableModel(data, columnNames));

    }
}

class CheckBoxTableModel extends AbstractTableModel{
    
    private String[] columnNames;
    private Object[][] data;


    public CheckBoxTableModel(ArrayList<ArrayList<Object>> data, ArrayList<String> columnNames){
        
        columnNames.add("Select");
        data.forEach((row) -> row.add(false));
        
        this.columnNames = columnNames.toArray(new String[1]);
        this.data = data.stream().map(u -> u.toArray(new Object[0])).toArray(Object[][]::new);

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

    public String getColumnName(int column){

        return columnNames[column];
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
