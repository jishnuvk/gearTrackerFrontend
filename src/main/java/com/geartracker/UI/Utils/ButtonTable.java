package com.geartracker.UI.Utils;

import java.util.ArrayList;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class ButtonTable extends JTable{

    ButtonTableModel buttonTableModel;

    public ButtonTable(ArrayList<ArrayList<Object>> data, ArrayList<String> columnNames, ButtonTableAction action){

        super(new ButtonTableModel(data, columnNames));
        buttonTableModel = (ButtonTableModel)getModel();
        
        getColumn("select").setCellRenderer(new ButtonCellRenderer());
        getColumn("select").setCellEditor(new ButtonEditor(new JCheckBox(),action));

    }

    public void updateData(ArrayList<ArrayList<Object>> data){

        buttonTableModel.updateData(data);
        buttonTableModel.fireTableDataChanged();
    }

}


class ButtonTableModel extends AbstractTableModel{
    
    private ArrayList<String> columnNames;
    private ArrayList<ArrayList<Object>> data;


    public ButtonTableModel(ArrayList<ArrayList<Object>> data, ArrayList<String> columnNames){
        
        columnNames.add("select");
        data.forEach((row)-> row.add(row.get(0)));

        this.columnNames = columnNames;
        this.data = data;

    }

    public void updateData(ArrayList<ArrayList<Object>> data){

        data.forEach((row)-> row.add(row.get(0)));
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

    public Class<?> getColumnClass(int c){
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col){

        if(col == getColumnCount()-1)
            return true;
        else 
            return false;


    }

    public String getColumnName(int column){

        return columnNames.get(column);
    }

    public void setValueAt(Object value, int row, int col) {
        data.get(row).set(col, value);
        fireTableCellUpdated(row, col);
    }

}

class ButtonCellRenderer extends JButton implements TableCellRenderer{
    
    public ButtonCellRenderer(){
        setOpaque(true);
    }



    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                    boolean hasFocus, int row, int col) {
        
                                                        
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        setText((value == null) ? "" : value.toString());
        return this;
                                                                                                       
        
    }

}

class ButtonEditor extends DefaultCellEditor{

    protected JButton button;
    private String label;
    private boolean isPushed;
    private ButtonTableAction action;

    public ButtonEditor(JCheckBox checkBox, ButtonTableAction action) {
        
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    fireEditingStopped();
                }
                catch(Exception ex){

                }    
            }
        });
        this.action = action;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
    
                if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            
            action.action(label);
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

}
 
