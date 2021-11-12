package com.geartracker.UI.Utils;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class CheckBoxTable extends JTable{

    private ArrayList<String> columnNames;
    private ArrayList<ArrayList<Object>> data;

    public CheckBoxTable(ArrayList<ArrayList<Object>> data, ArrayList<String> columnNames){

        
        super(new CheckBoxTableModel(data, columnNames));
        this.columnNames = columnNames;
        this.data = data;



    }

    public ArrayList<String> getCheckedIDs(){

        ArrayList<String> result = new ArrayList<>();
        ArrayList<Object> row;
        for(int i = 0; i < data.size(); i++){
            row = data.get(i);
            if((Boolean)row.get(row.size()-1)){
                result.add((String)row.get(0));
            }
        }

        return result;
    }

    public void checkAll(){

        data.forEach((row)->row.set(row.size() - 1, true));
    }

    public void uncheckAll(){

        data.forEach((row)->row.set(row.size() - 1, false));
    }
}

class CheckBoxTableModel extends AbstractTableModel{
    
    private ArrayList<String> columnNames;
    private ArrayList<ArrayList<Object>> data;


    public CheckBoxTableModel(ArrayList<ArrayList<Object>> data, ArrayList<String> columnNames){
        
        columnNames.add("Select");
        data.forEach((row) -> row.add(false));
        
        this.columnNames = columnNames;
        this.data = data;

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

        if(col == getColumnCount()-1)
            return true;
        else 
            return false;
    }

    public void setValueAt(Object value, int row, int col) {
        data.get(row).set(col, value);
        fireTableCellUpdated(row, col);
    }
}
