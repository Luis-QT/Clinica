/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.administrador;

import controlador.Controller;
import controlador.ControllerResource;
import estructura.ListaDoble;
import gui.administrador.mantenimiento.sala.Salas;
import dao.dao.SalaDao;
import dao.daoImpl.SalaDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Sala;

/**
 *
 * @author LLLL
 */
public class SalaController implements ActionListener,ControllerResource{
    
    private Salas vista;
    private ListaDoble <Sala> lista;
    
    public SalaController(Salas view){
        this.vista = view;
        iniciar();
    }
    
    @Override
    public void index() {
        this.vista.setVisible(true);
    }

    @Override
    public void iniciar() {
        
        this.vista.btnAgregar.setActionCommand("agregar");
        this.vista.btnAgregar.addActionListener(this);
        
        this.vista.btnDetalles.setActionCommand("detalles");
        this.vista.btnDetalles.addActionListener(this);
        
        this.vista.btnModificar.setActionCommand("editar");
        this.vista.btnModificar.addActionListener(this);
        
        this.vista.btnEliminar.setActionCommand("eliminar");
        this.vista.btnEliminar.addActionListener(this);
        
        this.vista.btnCargar.setActionCommand("cargar");
        this.vista.btnCargar.addActionListener(this);
        
        this.vista.btnCancelar.setActionCommand("cancelar");
        this.vista.btnCancelar.addActionListener(this);
        
        this.vista.tablaSala.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                formTabla(evt);
            }
        });
        
        SalaDao salaDao = new SalaDaoImpl();
        lista = salaDao.listaSalas();
        llenarTabla();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals("agregar")){
            formAgregar();
        }else if(comando.equals("editar")){
            formEditar();
        }else if(comando.equals("eliminar")){
            formEliminar();
        }else if(comando.equals("detalles")){
            formDetalles();
        }else if(comando.equals("cargar")){
            formCargar();
        }else if(comando.equals("cancelar")){
            formCancelar();
        }
    }
    public void formTabla(MouseEvent evt){
        int pos = this.vista.tablaSala.getSelectedRow();
        Sala sala = lista.getDato(pos);
        vista.txtSala.setText(sala.getNombre());
        vista.txtDescripcion.setText(sala.getDescripcion());
    }
    public void formAgregar(){
        String nombre = this.vista.txtSala.getText();
        String descripcion = this.vista.txtDescripcion.getText();
        Sala sala = new Sala(0, nombre, descripcion, null);
        this.lista.insertarAlFinal(sala);
        llenarTabla();
        aumentarCambios();
    }
    public void formEditar(){
        String nombre = this.vista.txtSala.getText();
        String descripcion = this.vista.txtDescripcion.getText();
        int pos = this.vista.tablaSala.getSelectedRow();
        Sala sala = lista.getDato(pos);
        
        sala.setNombre(nombre);
        sala.setDescripcion(descripcion);
        llenarTabla();
        aumentarCambios();
    }
    public void formEliminar(){
        int pos = this.vista.tablaSala.getSelectedRow();
        Sala sala = lista.getDato(pos);
        if(sala.getId()==0){
            lista.eliminarPos(pos);
        }else{
            sala.setDelete(true);
        }
        llenarTabla();
        aumentarCambios();
    }
    public void formDetalles(){
        //FALTA CODIGO.....
        JOptionPane.showMessageDialog(null, "DETALLES DE SALA\n"
                                    + "\nLUNES...."
                                    + "\n10:30 - 12:00    Carlos Albujar"
                                    + "\n08:50 - 20:00    Juan Perez\n");
    }
    private void formCargar(){
        Iterator<Sala> iterador = lista.getDescendingIterator();
        SalaDao salaDao = new SalaDaoImpl();
        while(iterador.hasNext()){
            Sala sala = iterador.next();
            if(sala.isDelete()){
                //se desea eliminar
                salaDao.eliminarSala(sala.getId());
            }else{
                //agregar o editar
                salaDao.guardarSala(sala);
            }
        }
        vista.txtCambios.setText("0");
        llenarTabla();
        JOptionPane.showMessageDialog(null, "Se guardaron todos los cambios");
    }
    private void formCancelar(){
        int m = JOptionPane.showConfirmDialog(null, "Se cancelaran todos los cambios\nEsta seguro ?");
        if(m==0){
            vista.txtCambios.setText("0");
            SalaDao salaDao = new SalaDaoImpl();
            lista = salaDao.listaSalas();
            llenarTabla();
            System.out.println("si");
        }else{
            System.err.println("no");
        }
    }
    
    private void llenarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) vista.tablaSala.getModel();
        modelo.setRowCount(0);
        Iterator<Sala> iterador = lista.getDescendingIterator();
        while(iterador.hasNext()){
            Sala sala = iterador.next();
            if(!sala.isDelete()){
                modelo.addRow(new Object[]{sala.getNombre(), sala.getDescripcion(), "" });
            }
        }
    }
    
    private void aumentarCambios(){
        String txtCambios = this.vista.txtCambios.getText();
        int cambios = Integer.parseInt(txtCambios);
        cambios++;
        System.out.println(cambios);
        this.vista.txtCambios.setText(String.valueOf(cambios));
    }
}
