/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.administrador;

import controlador.ControllerResource;
import dao.dao.PlanTratamientoDao;
import dao.daoImpl.PlanTratamientoDaoImpl;
import estructura.ListaDoble;
import gui.administrador.TablaFilaRoja;
import gui.administrador.areaMedico.PlanTratamientoV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PlanTratamiento;

/**
 *
 * @author LLLL
 */
public class PlanTratamientoController implements ActionListener,ControllerResource{
    private PlanTratamientoV vista;
    private ListaDoble <PlanTratamiento> lista;
    
    public PlanTratamientoController(PlanTratamientoV view){
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
        
        this.vista.tabla.setBackground(new java.awt.Color(221, 255, 220));
        
        this.vista.tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                formTabla(evt);
            }
        });
        
        PlanTratamientoDao planTratamientoDao = new PlanTratamientoDaoImpl();
        lista = planTratamientoDao.listaTratamientos();
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
        int pos = this.vista.tabla.getSelectedRow();
        PlanTratamiento planTratamiento = lista.getDato(pos);
        vista.txtNombre.setText(planTratamiento.getNombre());
        vista.txtDescripcion.setText(planTratamiento.getDescripcion());
        vista.txtPrecio.setText(""+planTratamiento.getPrecio());
    }
    public void formAgregar(){
        String nombre = this.vista.txtNombre.getText();
        String descripcion = this.vista.txtDescripcion.getText();
        Double costo = Double.parseDouble(vista.txtPrecio.getText());
        PlanTratamiento planTratamiento = new PlanTratamiento(0, nombre, descripcion,costo);
        this.lista.insertarAlFinal(planTratamiento);
        llenarTabla();
        aumentarCambios();
    }
    public void formEditar(){
        String nombre = this.vista.txtNombre.getText();
        String descripcion = this.vista.txtDescripcion.getText();
        Double costo = Double.parseDouble(vista.txtPrecio.getText());
        
        int pos = this.vista.tabla.getSelectedRow();
        PlanTratamiento planTratamiento = lista.getDato(pos);
        
        planTratamiento.setNombre(nombre);
        planTratamiento.setDescripcion(descripcion);
        planTratamiento.setPrecio(costo);
        llenarTabla();
        aumentarCambios();
    }
    public void formEliminar(){
        int pos = this.vista.tabla.getSelectedRow();
        if(pos!=-1){
           PlanTratamiento planTratamiento = lista.getDato(pos);
            if(planTratamiento.getId()==0){
                lista.eliminarPos(pos);
            }else{
                planTratamiento.setDelete(true);
                vista.tabla.setDefaultRenderer(Object.class,new TablaFilaRoja(pos));
            }
            llenarTabla();
            aumentarCambios(); 
        }
    }
    public void formDetalles(){
        //FALTA CODIGO.....
        JOptionPane.showMessageDialog(null, "DETALLES DE SALA\n"
                                    + "\nLUNES...."
                                    + "\n10:30 - 12:00    Carlos Albujar"
                                    + "\n08:50 - 20:00    Juan Perez\n");
    }
    private void formCargar(){
        Iterator<PlanTratamiento> iterador = lista.getDescendingIterator();
        PlanTratamientoDao planTratamientoDao = new PlanTratamientoDaoImpl();
        while(iterador.hasNext()){
            PlanTratamiento planTratamiento = iterador.next();
            if(planTratamiento.isDelete()){
                //se desea eliminar
                planTratamientoDao.eliminarTratamiento(planTratamiento.getId());
            }else{
                //agregar o editar
                planTratamientoDao.guardarTratamiento(planTratamiento);
            }
        }
        vista.txtCambios.setText("0");
        lista = planTratamientoDao.listaTratamientos();
        vista.tabla.setDefaultRenderer(Object.class,new TablaFilaRoja(-1));
        llenarTabla();
        JOptionPane.showMessageDialog(null, "Se guardaron todos los cambios");
    }
    private void formCancelar(){
        int m = JOptionPane.showConfirmDialog(null, "Se cancelaran todos los cambios\nEsta seguro ?");
        if(m==0){
            vista.txtCambios.setText("0");
            PlanTratamientoDao planTratamientoDao = new PlanTratamientoDaoImpl();
            lista = planTratamientoDao.listaTratamientos();
            vista.tabla.setDefaultRenderer(Object.class,new TablaFilaRoja(-1));
            llenarTabla();
        }else{
        }
    }
    
    private void llenarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) vista.tabla.getModel();
        modelo.setRowCount(0);
        Iterator<PlanTratamiento> iterador = lista.getDescendingIterator();
        while(iterador.hasNext()){
            PlanTratamiento planTratamiento = iterador.next();
            modelo.addRow(new Object[]{planTratamiento.getNombre(), planTratamiento.getDescripcion(),planTratamiento.getPrecio() });
            
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
