/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.administrador;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author LLLL
 */
public class TablaFilaRoja extends DefaultTableCellRenderer{
        private Component componente;
        private int posicion;
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column){
            componente = super.getTableCellRendererComponent(table,value,
                          isSelected, hasFocus,row, column);
            if(row==posicion){
                componente.setBackground(new Color(249,204,204));
            }else{
                componente.setBackground(new Color(221,255,220));
            }
            return componente;
        }

        public TablaFilaRoja(int posicion) {
            this.posicion = posicion;
        }
    }
