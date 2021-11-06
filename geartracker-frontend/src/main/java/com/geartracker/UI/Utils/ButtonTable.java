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

// only rendering done. Click behavior remaining

public class ButtonTable extends JTable{
    
    public ButtonTable(ArrayList<ArrayList<Object>> data, ArrayList<String> columnNames){

        super(new ButtonTableModel(data, columnNames));
        
        getColumn("select").setCellRenderer(new ButtonCellRenderer());
        getColumn("select").setCellEditor(new ButtonEditor(new JCheckBox()));

    }

}


class ButtonTableModel extends AbstractTableModel{
    
    private String[] columnNames;
    private Object[][] data;


    public ButtonTableModel(ArrayList<ArrayList<Object>> data, ArrayList<String> columnNames){
        
        columnNames.add("select");
        data.forEach((row)-> row.add("select"));

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

        return columnNames[column];
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
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

    public ButtonEditor(JCheckBox checkBox) {
        
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
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
            
            //action
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


