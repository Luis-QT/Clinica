/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.administrador;

import controlador.Controller;
import controlador.ControllerResource;
import dao.dao.CajeroDao;
import dao.dao.HorarioDao;
import dao.dao.SalaDao;
import dao.daoImpl.CajeroDaoImpl;
import dao.daoImpl.HorarioDaoImpl;
import dao.daoImpl.SalaDaoImpl;
import estructura.ListaDoble;
import gui.administrador.TablaFilaRoja;
import gui.administrador.mantenimiento.cajero.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Horario;
import model.Sala;
import model.empleado.Cajero;

/**
 *
 * @author LLLL
 */
public class CajeroController implements ControllerResource, ActionListener{
    private ListaC vista;
    private InsertarC FrameInsertarC;
    private EditarC FrameEditarC;
    private ListaDoble<Cajero> listaCajero;
    
    public CajeroController(ListaC view){
        this.vista = view;
        iniciar();
    }
    
    @Override
    public void iniciar(){
        this.vista.btnAgregar.setActionCommand("Agregar");
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnModificar.setActionCommand("Editar");
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.setActionCommand("Eliminar");
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnCancelar.setActionCommand("Cancelar");
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnCargar.setActionCommand("Cargar");
        this.vista.btnCargar.addActionListener(this);
        this.vista.tablaC.setBackground(new java.awt.Color(221, 255, 220));
        
        vista.btnCerrar.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    vista.setVisible(false);
                }
            });
            
        CajeroDao cajeroDao = new CajeroDaoImpl();
        listaCajero = cajeroDao.listaCajeros();
        llenarTabla();
    }
    
    
    @Override
    public void index() {
        this.vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        if(comando.equals("Agregar")){
            formAgregar();
        }else if(comando.equals("Editar")){
            formEditar();
        }else if(comando.equals("Eliminar")){
            formEliminar();
        }else if(comando.equals("Cancelar")){
            formCancelar();
        }else if(comando.equals("Cargar")){
            formCargar();
        }
    }
    
    @Override
    public void formAgregar(){
        int aux = this.listaCajero.size;
        FrameInsertarC = new InsertarC(vista, true);
        AgregarController controladorAgregar =new AgregarController();
        controladorAgregar.index();
        if(controladorAgregar.isAgrega()){
            aumentarCambios();
            llenarTabla();
        }
    }
    
    @Override
    public void formEditar() {
        int pos = this.vista.tablaC.getSelectedRow();
        //-1 No se selecciona nada
        if(pos!=-1){
            Cajero cajero = listaCajero.getDato(pos);
            System.out.println("recepcionista : "+cajero.getNombre());
            System.out.println("horarios : "+cajero.getHorarios());
            FrameEditarC = new EditarC(vista, true);
            EditarController controladorEditar = new EditarController(cajero);
            controladorEditar.index();
            if(controladorEditar.isEdita()){
                aumentarCambios();
                llenarTabla();
            }
        }
    }

    @Override
    public void formEliminar() {
        int pos = vista.tablaC.getSelectedRow();
        if(pos!=-1){
            Cajero cajero = listaCajero.getDato(pos);
            if(cajero.getId()==0){
                listaCajero.eliminarPos(pos);
            }else{
                cajero.setSoftDelete(1);
                vista.tablaC.setDefaultRenderer(Object.class,new TablaFilaRoja(pos));
            }
            llenarTabla();
            aumentarCambios();
        }
    }

    @Override
    public void formDetalles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void formCargar(){
        Iterator<Cajero> iterador = listaCajero.getDescendingIterator();
        CajeroDao cajeroDao = new CajeroDaoImpl();
        while(iterador.hasNext()){
            Cajero cajero = iterador.next();
            if(cajero.getSoftDelete()==1){
                //se desea eliminar
                cajeroDao.eliminarCajero(cajero.getId());
            }else{
                //agregar o editar
                cajeroDao.guardarCajero(cajero);
            }
            if(cajero.getHorarios()!=null){
                Iterator<Horario> iteradorHo = cajero.getHorarios().getDescendingIterator();
                HorarioDao horarioDao = new HorarioDaoImpl();
                while(iteradorHo.hasNext()){
                    Horario horaAux = iteradorHo.next();
                    if(horaAux.isEliminar()){
                        horarioDao.eliminarHorario(horaAux.getId());
                    }else{
                        horarioDao.guardarHorario(horaAux);
                    }
                }
            }
        }
        vista.txtCambios.setText("0");
        listaCajero = cajeroDao.listaCajeros();
        vista.tablaC.setDefaultRenderer(Object.class,new TablaFilaRoja(-1));
        llenarTabla();
        JOptionPane.showMessageDialog(null, "Se guardaron todos los cambios");
    }
    
    public void formCancelar(){
        int m = JOptionPane.showConfirmDialog(null, "Se cancelaran todos los cambios\nEsta seguro ?");
        if(m==0){
            vista.txtCambios.setText("0");
            CajeroDao cajeroDao = new CajeroDaoImpl();
            listaCajero = cajeroDao.listaCajeros();
            vista.tablaC.setDefaultRenderer(Object.class,new TablaFilaRoja(-1));
            llenarTabla();
            JOptionPane.showMessageDialog(null, "Se eliminaron todos los cambios");
        }else{
            //no se elimino los cambios
        }
    }
    
    private void aumentarCambios(){
        String txtCambios = this.vista.txtCambios.getText();
        int cambios = Integer.parseInt(txtCambios);
        cambios++;
        this.vista.txtCambios.setText(String.valueOf(cambios));
    }

    private void llenarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) vista.tablaC.getModel();
        modelo.setRowCount(0);
        Iterator<Cajero> iterador = listaCajero.getDescendingIterator();
        while(iterador.hasNext()){
            Cajero cajero = iterador.next();
            
            modelo.addRow(new Object[]{cajero.getCodigo(), cajero.getNombre(),
                    cajero.getApellido(),
                    cajero.getDni() ,cajero.getEdad(),
                    cajero.getEmail(),cajero.getTelefonoCasa()
                    ,cajero.getTelefonoCelular()
                    });
            
        }
    }
    
    
    /***************************************************************/
    /****************** CLASE AGREGAR ******************************/
    /***************************************************************/
    
    private class AgregarController implements ActionListener,Controller{
        
        Boolean agrega;
        
        public AgregarController(){
            agrega = false;
            iniciar();
        }
        
        @Override
        public void iniciar() {
            FrameInsertarC.btnAgregar.setActionCommand("Agregar");
            FrameInsertarC.btnAgregar.addActionListener(this);
        }
        
        @Override
        public void index() {
            FrameInsertarC.setVisible(true);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            if(comando.equals("Agregar")){
                formAgregar();
            }
        }
        
        private void formAgregar(){
           try{
                //Al agregar un nuevo medico , el id debe pasar como 0
                String codigo = FrameInsertarC.txtCodigo.getText();
                String contraseña = FrameInsertarC.txtDni.getText();
                String nombre = FrameInsertarC.txtNombre.getText();
                String apellido = FrameInsertarC.txtApellido.getText();
                int dni = Integer.parseInt(FrameInsertarC.txtDni.getText());
                String email = FrameInsertarC.txtEmail.getText();
                int telefono = Integer.parseInt(FrameInsertarC.txtTelefono.getText());
                int celular = Integer.parseInt(FrameInsertarC.txtCelular.getText());
                int edad = Integer.parseInt(FrameInsertarC.txtEdad.getText());
                Boolean sexo = true;
                if(FrameInsertarC.txtFemale.isSelected()){
                    sexo = false;
                }
                Cajero cajero = new Cajero(codigo, contraseña, new ListaDoble<Horario>(), 0, nombre, apellido, dni, true, edad, telefono, celular, email, 0);
                listaCajero.insertarAlFinal(cajero);
                this.agrega = true;
                FrameInsertarC.setVisible(false);
           
           }catch(Exception e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\nNo se agrego al medico");
           }
        }
        
        public Boolean isAgrega(){
            return agrega;
        }
    }
    
    
    /***************************************************************/
    /***************************** CLASE EDITAR ********************************/
    /***************************************************************/

    private class EditarController implements ActionListener,ControllerResource{
        SeleccionSalaC FrameSala;
        Cajero cajero;
        ListaDoble<Horario> listaHorario;       
        Sala sala;//sala a asignar
        Horario horario;//horario a editar
        boolean edita;
        
        public EditarController(Cajero cajero){
            this.cajero = cajero;
            listaHorario = cajero.getHorarios();
            if(listaHorario==null){
                listaHorario = new ListaDoble<Horario>();
            }
            edita = false;
            sala = null;
            horario = null;
            iniciar();
        }
        @Override
        public void iniciar() {
            FrameEditarC.btnAsignarSala.setActionCommand("AsignarSala");
            FrameEditarC.btnAsignarSala.addActionListener(this);
            FrameEditarC.btnAñadir.setActionCommand("AgregarHorario");
            FrameEditarC.btnAñadir.addActionListener(this);
            FrameEditarC.btnEditar.setActionCommand("EditarHorario");
            FrameEditarC.btnEditar.addActionListener(this);
            FrameEditarC.btnModificar.setActionCommand("EditarRecepcionista");
            FrameEditarC.btnModificar.addActionListener(this);
            FrameEditarC.btnQuitar.setActionCommand("EliminarHorario");
            FrameEditarC.btnQuitar.addActionListener(this);
            
            FrameEditarC.tabla.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    formTabla(evt);
                }
             });
            
            
            FrameEditarC.txtNombre.setText(cajero.getNombre());
            FrameEditarC.txtApellido.setText(cajero.getApellido());
            FrameEditarC.txtCelular.setText(""+cajero.getTelefonoCelular());
            FrameEditarC.txtCodigo.setText(cajero.getCodigo());
            FrameEditarC.txtDni.setText(""+cajero.getDni());
            FrameEditarC.txtEdad.setText(""+cajero.getEdad());
            FrameEditarC.txtEmail.setText(cajero.getEmail());
            FrameEditarC.txtTelefono.setText(""+cajero.getTelefonoCasa());
            FrameEditarC.txtHoraFin.setText("");
            FrameEditarC.txtHoraIni.setText("");
            FrameEditarC.txtMale.setSelected(false);
            FrameEditarC.txtFemale.setSelected(false);
            if(cajero.isSexo()){
               FrameEditarC.txtMale.setSelected(true);
            }else{
               FrameEditarC.txtFemale.setSelected(true); 
            }
            llenarTabla();
        }
        
        @Override
        public void index() {
            FrameEditarC.setVisible(true);
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            if(comando.equals("AgregarHorario")){
                formAgregar();
            }else if(comando.equals("EditarHorario")){
                formEditar();
            }else if(comando.equals("EditarRecepcionista")){
                formEditarMedico();
            }else if(comando.equals("EliminarHorario")){
                formEliminar();
            }else if(comando.equals("AsignarSala")){
                formAsignarSala();
            }
        }
        
        private void formTabla(MouseEvent evt){
            int pos = FrameEditarC.tabla.getSelectedRow();
            if(pos!=-1){
                horario = listaHorario.getDato(pos);
                FrameEditarC.txtHoraIni.setText(horario.getHoraEntrada());
                FrameEditarC.txtHoraFin.setText(horario.getHoraSalida());
                FrameEditarC.txtDia.setSelectedItem(horario.getDia());
                sala = horario.getSala();                
                SalaDao sdi = new SalaDaoImpl();
                Sala aux = sdi.obtenerSala(horario.getSalaId());
                FrameEditarC.txtSala.setText(aux.getNombre());
            }
        }
        
        @Override
        public void formAgregar(){
            try{
                if(sala==null){
                    JOptionPane.showMessageDialog(null, "ERROR DE ASIGNACION\nNo se agrego el horario.\nFalta asginar una sala");
                }else{
                    String horaIni = FrameEditarC.txtHoraIni.getText();
                    String horaFin = FrameEditarC.txtHoraFin.getText();
                    String dia = (String)FrameEditarC.txtDia.getSelectedItem();
                    Horario horarioAux = new Horario(0, dia, horaIni, horaFin, cajero, sala,6,
                            cajero.getId(),sala.getId());
                    listaHorario.insertarAlFinal(horarioAux);
                    llenarTabla();  
                }
                
            }catch(Exception e){
                System.out.println("ERROR FormAgregar: "+e.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\nNo se agrego el horario");
           }
            
        }
        
        @Override
        public void formEditar(){
            String horaIni = FrameEditarC.txtHoraIni.getText();
            String horaFin = FrameEditarC.txtHoraFin.getText();
            String dia = (String)FrameEditarC.txtDia.getSelectedItem();
            
            horario.setDia(dia);
            horario.setHoraEntrada(horaIni);
            horario.setHoraSalida(horaFin);
            horario.setSala(sala);
            llenarTabla();
        }
        
        @Override
        public void formEliminar(){
            int pos = FrameEditarC.tabla.getSelectedRow();
            if(pos!=-1){
                listaHorario.getDato(pos).setEliminar(true);
                llenarTabla();
            }
        }
        
        @Override
        public void formDetalles() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        public void formEditarMedico(){
            try{
                String codigo = FrameEditarC.txtCodigo.getText();
                String contraseña = FrameEditarC.txtDni.getText();
                String nombre = FrameEditarC.txtNombre.getText();
                String apellido = FrameEditarC.txtApellido.getText();
                int dni = Integer.parseInt(FrameEditarC.txtDni.getText());
                String email = FrameEditarC.txtEmail.getText();
                int telefono = Integer.parseInt(FrameEditarC.txtTelefono.getText());
                int celular = Integer.parseInt(FrameEditarC.txtCelular.getText());
                int edad = Integer.parseInt(FrameEditarC.txtEdad.getText());
                Boolean sexo = true;
                if(FrameEditarC.txtFemale.isSelected()){
                    sexo = false;
                }

                cajero.setApellido(apellido);
                cajero.setCodigo(codigo);
                cajero.setDni(dni);
                cajero.setEdad(edad);
                cajero.setEmail(email);
                cajero.setHorarios(listaHorario);
                cajero.setNombre(nombre);
                cajero.setSexo(sexo);
                cajero.setTelefonoCasa(telefono);
                cajero.setTelefonoCelular(celular);
                edita = true;
                //medico.setHorarios(listaHorario);
                FrameEditarC.setVisible(false);

            }catch(Exception e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\nNo se edito al medico");
            }
            
        }
        
        private void formAsignarSala(){
            FrameSala = new SeleccionSalaC(FrameEditarC, true);
            SalasController ControladorSala = new SalasController();
            ControladorSala.index();
            System.out.println(sala.getNombre());
        }
        
        private void llenarTabla(){
            DefaultTableModel modelo = (DefaultTableModel) FrameEditarC.tabla.getModel();
            modelo.setRowCount(0);
            Iterator<Horario> iterador = this.listaHorario.getDescendingIterator();
            SalaDao sdi = new SalaDaoImpl();
            Sala auxSala = null;
            while(iterador.hasNext()){
                Horario auxH = iterador.next();
                auxSala = sdi.obtenerSala(auxH.getSalaId());
                System.out.println(auxSala.getId());
                if(!auxH.isEliminar()){
                    modelo.addRow(new Object[]{auxH.getDia(),auxH.getHoraEntrada(),auxH.getHoraSalida(),auxSala.getNombre() });
                }
            }
        }
        
        public boolean isEdita(){
            return edita;
        }

        
         /***************************************************************/
        /************************* CLASE SALAS **************************/
         /***************************************************************/
        private class SalasController implements Controller,ActionListener{
            ListaDoble<Sala> listaSala;
            
            public SalasController(){
                iniciar();
            }
            
            @Override
            public void iniciar() {
                SalaDao salaDao = new SalaDaoImpl();
                listaSala = salaDao.listaSalas();
                
                FrameSala.btnSeleccionar.setActionCommand("Seleccionar");
                FrameSala.btnSeleccionar.addActionListener(this);
                llenarTabla();
            }

            @Override
            public void index() {
                FrameSala.setVisible(true);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String comando = e.getActionCommand();
                if(comando.equals("Seleccionar")){
                    formSeleccionar();
                }
            }
            
            private void formSeleccionar(){
                int pos = FrameSala.tabla.getSelectedRow();
                //-1 no selecciona nada
                if(pos!=-1){
                    sala = listaSala.getDato(pos);
                    if(horario!=null){
                        horario.setSalaId(sala.getId());
                    }
                    
                    FrameEditarC.txtSala.setText(sala.getNombre());
                    FrameSala.setVisible(false);
                }
            }
            
            private void llenarTabla(){
                DefaultTableModel modeloSala = (DefaultTableModel) FrameSala.tabla.getModel();
                modeloSala.setRowCount(0);
                Iterator<Sala> iterador = this.listaSala.getDescendingIterator();
                while(iterador.hasNext()){
                    Sala sala = iterador.next();
                        modeloSala.addRow(new Object[]{sala.getNombre()});
                }
            }
            
        }
        
    }
}
