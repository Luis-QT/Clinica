/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.principal;

import controlador.Controller;
import controlador.administrador.AdministradorController;
import dao.dao.AdministradorDao;
import dao.daoImpl.AdministradorDaoImpl;
import gui.administrador.FramePrincipalAdministrador;
import inicio.FrameLoginAdministracion;
import inicio.FramePrincipal;
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
public class LoginAdministradorController implements Controller,ActionListener{
    
    FrameLoginAdministracion vista;
    FramePrincipalAdministrador frameAdministrador; 
    FramePrincipal padre;
    
    public LoginAdministradorController(FrameLoginAdministracion vista, FramePrincipal padre) {
        this.vista = vista;
        this.padre = padre;
    }
    
    @Override
    public void iniciar() {
        this.vista.btnIngresar.setActionCommand("Ingresar");
        this.vista.btnIngresar.addActionListener(this);
        
        vista.btnCerrar.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    vista.setVisible(false);
                    padre.setVisible(true);
                }
        });
        
    }

    @Override
    public void index() {
        this.vista.setVisible(true);
        iniciar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals("Ingresar")){
            formIngresar();
        }
    }
    private void formIngresar(){
        String codigo = vista.txtCodigo.getText();
        String contraseña = vista.txtContraseña.getText();
       
        AdministradorDao administradorDao = new AdministradorDaoImpl();
        Administrador admin = administradorDao.obtenerAdministrador();
        
        if(admin.getCodigo().equals(codigo) && admin.getContraseña().equals(contraseña)){
            vista.setVisible(false);
            frameAdministrador = new FramePrincipalAdministrador();
            AdministradorController administradorController = new AdministradorController(frameAdministrador);
            administradorController.index();
            JOptionPane.showMessageDialog(null, "Bienvenido:  \n"+admin.getNombre()+" "+admin.getApellido());
        }else{
            JOptionPane.showMessageDialog(null, "FALLO AL LOGEAR");
        }
    }
    
}
