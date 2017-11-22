/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.administrador;

import controlador.Controller;
import dao.dao.AdministradorDao;
import dao.daoImpl.AdministradorDaoImpl;
import gui.administrador.configuracion.FrameConfiguracion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import model.empleado.Administrador;

/**
 *
 * @author LLLL
 */
public class ConfiguracionController implements Controller,ActionListener{

    FrameConfiguracion vista;

    public ConfiguracionController(FrameConfiguracion vista) {
        this.vista = vista;
        iniciar();
    }
    
    @Override
    public void iniciar() {
        this.vista.btnModificar.setActionCommand("editar");
        this.vista.btnModificar.addActionListener(this);
        
        vista.btnCerrar.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    vista.setVisible(false);
                }
            });
        
    }

    @Override
    public void index() {
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals("editar")){
            formEditar();
        }
    }
    private void formEditar(){
        String nombre = vista.txtNombre.getText();
        String apellido = vista.txtApellido.getText();
        String codigo = vista.txtCodigo.getText();
        String codigoNuevo = vista.txtCodigoNuevo.getText();
        String contraseña = vista.txtContraseña.getText();
        String contraseñaNueva = vista.txtContraseñaNueva.getText();
        
        AdministradorDao adminDao = new AdministradorDaoImpl();
        Administrador admin = adminDao.obtenerAdministrador();

        if(admin.getCodigo().equals(codigo) && admin.getContraseña().equals(contraseña)){
            admin.setNombre(nombre);
            admin.setApellido(apellido);
            admin.setCodigo(codigoNuevo);
            admin.setContraseña(contraseñaNueva);
            System.out.println("ENTRAS CONFI");
            adminDao.guardarAdministrador(admin);
            JOptionPane.showMessageDialog(null, "Modificacion exitosa..");
        }else{
            JOptionPane.showMessageDialog(null, "Codigo o contraseña incorrecta !!!");
        }
    }
}
