/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.administrador;

import controlador.Controller;
import controlador.ControllerResource;
import estructura.ListaDoble;
import gui.administrador.mantenimiento.recepcionista.EditarR;
import gui.administrador.mantenimiento.recepcionista.InsertarR;
import gui.administrador.mantenimiento.recepcionista.ListaR;
import gui.administrador.mantenimiento.recepcionista.SeleccionSalaR;
import dao.dao.HorarioDao;
import dao.dao.RecepcionistaDao;
import dao.dao.SalaDao;
import dao.daoImpl.HorarioDaoImpl;
import dao.daoImpl.RecepcionistaDaoImpl;
import dao.daoImpl.SalaDaoImpl;
import gui.administrador.TablaFilaRoja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.empleado.Recepcionista;
import model.Horario;
import model.Sala;

/**
 *
 * @author LLLL
 */
public class RecepcionistaController implements ControllerResource, ActionListener{
    private ListaR vista;
    private InsertarR FrameInsertarR;
    private EditarR FrameEditarR;
    private ListaDoble<Recepcionista> listaRecepcionista;
    
    public RecepcionistaController(ListaR view){
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
        this.vista.tablaR.setBackground(new java.awt.Color(221, 255, 220));

        RecepcionistaDao recepcionistaDao = new RecepcionistaDaoImpl();
        listaRecepcionista = recepcionistaDao.listaRecepcionistas();
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
        int aux = this.listaRecepcionista.size;
        FrameInsertarR = new InsertarR(vista, true);
        AgregarController controladorAgregar =new AgregarController();
        controladorAgregar.index();
        if(controladorAgregar.isAgrega()){
            aumentarCambios();
            llenarTabla();
        }
    }
    
    @Override
    public void formEditar() {
        int pos = this.vista.tablaR.getSelectedRow();
        //-1 No se selecciona nada
        if(pos!=-1){
            Recepcionista recepcionista = listaRecepcionista.getDato(pos);
            System.out.println("recepcionista : "+recepcionista.getNombre());
            System.out.println("horarios : "+recepcionista.getHorarios());
            FrameEditarR = new EditarR(vista, true);
            EditarController controladorEditar = new EditarController(recepcionista);
            controladorEditar.index();
            if(controladorEditar.isEdita()){
                aumentarCambios();
                llenarTabla();
            }
        }
    }

    @Override
    public void formEliminar() {
        int pos = vista.tablaR.getSelectedRow();
        if(pos!=-1){
            Recepcionista recepcionista = listaRecepcionista.getDato(pos);
            if(recepcionista.getId()==0){
                listaRecepcionista.eliminarPos(pos);
            }else{
                recepcionista.setSoftDelete(1);
                vista.tablaR.setDefaultRenderer(Object.class,new TablaFilaRoja(pos));
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
        Iterator<Recepcionista> iterador = listaRecepcionista.getDescendingIterator();
        RecepcionistaDao recepcionistaDao = new RecepcionistaDaoImpl();
        while(iterador.hasNext()){
            Recepcionista recepcionista = iterador.next();
            if(recepcionista.getSoftDelete()==1){
                //se desea eliminar
                recepcionistaDao.eliminarRecepcionista(recepcionista.getId());
            }else{
                //agregar o editar
                recepcionistaDao.guardarRecepcionista(recepcionista);
            }
            if(recepcionista.getHorarios()!=null){
                Iterator<Horario> iteradorHo = recepcionista.getHorarios().getDescendingIterator();
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
        listaRecepcionista = recepcionistaDao.listaRecepcionistas();
        vista.tablaR.setDefaultRenderer(Object.class,new TablaFilaRoja(-1));
        llenarTabla();
        JOptionPane.showMessageDialog(null, "Se guardaron todos los cambios");
    }
    
    public void formCancelar(){
        int m = JOptionPane.showConfirmDialog(null, "Se cancelaran todos los cambios\nEsta seguro ?");
        if(m==0){
            vista.txtCambios.setText("0");
            RecepcionistaDao recepcionistaDao = new RecepcionistaDaoImpl();
            listaRecepcionista = recepcionistaDao.listaRecepcionistas();
            vista.tablaR.setDefaultRenderer(Object.class,new TablaFilaRoja(-1));
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
        DefaultTableModel modelo = (DefaultTableModel) vista.tablaR.getModel();
        modelo.setRowCount(0);
        Iterator<Recepcionista> iterador = listaRecepcionista.getDescendingIterator();
        while(iterador.hasNext()){
            Recepcionista recepcionista = iterador.next();
            
            modelo.addRow(new Object[]{recepcionista.getCodigo(), recepcionista.getNombre(),
                    recepcionista.getApellido(),
                    recepcionista.getDni() ,recepcionista.getEdad(),
                    recepcionista.getEmail(),recepcionista.getTelefonoCasa()
                    ,recepcionista.getTelefonoCelular()
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
            FrameInsertarR.btnAgregar.setActionCommand("Agregar");
            FrameInsertarR.btnAgregar.addActionListener(this);
        }
        
        @Override
        public void index() {
            FrameInsertarR.setVisible(true);
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
                String codigo = FrameInsertarR.txtCodigo.getText();
                String contraseña = FrameInsertarR.txtDni.getText();
                String nombre = FrameInsertarR.txtNombre.getText();
                String apellido = FrameInsertarR.txtApellido.getText();
                int dni = Integer.parseInt(FrameInsertarR.txtDni.getText());
                String email = FrameInsertarR.txtEmail.getText();
                int telefono = Integer.parseInt(FrameInsertarR.txtTelefono.getText());
                int celular = Integer.parseInt(FrameInsertarR.txtCelular.getText());
                int edad = Integer.parseInt(FrameInsertarR.txtEdad.getText());
                Boolean sexo = true;
                if(FrameInsertarR.txtFemale.isSelected()){
                    sexo = false;
                }
                Recepcionista recepcionista = new Recepcionista(codigo, contraseña, new ListaDoble<Horario>(), 0, nombre, apellido, dni, true, edad, telefono, celular, email, 0);
                listaRecepcionista.insertarAlFinal(recepcionista);
                this.agrega = true;
                FrameInsertarR.setVisible(false);
           
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
        SeleccionSalaR FrameSala;
        Recepcionista recepcionista;//medico a editar
        ListaDoble<Horario> listaHorario;       
        Sala sala;//sala a asignar
        Horario horario;//horario a editar
        boolean edita;
        
        public EditarController(Recepcionista recepcionista){
            this.recepcionista = recepcionista;
            listaHorario = recepcionista.getHorarios();
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
            FrameEditarR.btnAsignarSala.setActionCommand("AsignarSala");
            FrameEditarR.btnAsignarSala.addActionListener(this);
            FrameEditarR.btnAñadir.setActionCommand("AgregarHorario");
            FrameEditarR.btnAñadir.addActionListener(this);
            FrameEditarR.btnEditar.setActionCommand("EditarHorario");
            FrameEditarR.btnEditar.addActionListener(this);
            FrameEditarR.btnModificar.setActionCommand("EditarRecepcionista");
            FrameEditarR.btnModificar.addActionListener(this);
            FrameEditarR.btnQuitar.setActionCommand("EliminarHorario");
            FrameEditarR.btnQuitar.addActionListener(this);
            
            FrameEditarR.tabla.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    formTabla(evt);
                }
             });
            
            
            FrameEditarR.txtNombre.setText(recepcionista.getNombre());
            FrameEditarR.txtApellido.setText(recepcionista.getApellido());
            FrameEditarR.txtCelular.setText(""+recepcionista.getTelefonoCelular());
            FrameEditarR.txtCodigo.setText(recepcionista.getCodigo());
            FrameEditarR.txtDni.setText(""+recepcionista.getDni());
            FrameEditarR.txtEdad.setText(""+recepcionista.getEdad());
            FrameEditarR.txtEmail.setText(recepcionista.getEmail());
            FrameEditarR.txtTelefono.setText(""+recepcionista.getTelefonoCasa());
            FrameEditarR.txtHoraFin.setText("");
            FrameEditarR.txtHoraIni.setText("");
            FrameEditarR.txtMale.setSelected(false);
            FrameEditarR.txtFemale.setSelected(false);
            if(recepcionista.isSexo()){
               FrameEditarR.txtMale.setSelected(true);
            }else{
               FrameEditarR.txtFemale.setSelected(true); 
            }
            llenarTabla();
        }
        
        @Override
        public void index() {
            FrameEditarR.setVisible(true);
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
            int pos = FrameEditarR.tabla.getSelectedRow();
            if(pos!=-1){
                horario = listaHorario.getDato(pos);
                FrameEditarR.txtHoraIni.setText(horario.getHoraEntrada());
                FrameEditarR.txtHoraFin.setText(horario.getHoraSalida());
                FrameEditarR.txtDia.setSelectedItem(horario.getDia());
                sala = horario.getSala();                
                SalaDao sdi = new SalaDaoImpl();
                Sala aux = sdi.obtenerSala(horario.getSalaId());
                FrameEditarR.txtSala.setText(aux.getNombre());
            }
        }
        
        @Override
        public void formAgregar(){
            try{
                if(sala==null){
                    JOptionPane.showMessageDialog(null, "ERROR DE ASIGNACION\nNo se agrego el horario.\nFalta asginar una sala");
                }else{
                    String horaIni = FrameEditarR.txtHoraIni.getText();
                    String horaFin = FrameEditarR.txtHoraFin.getText();
                    String dia = (String)FrameEditarR.txtDia.getSelectedItem();
                    Horario horarioAux = new Horario(0, dia, horaIni, horaFin, recepcionista, sala,5,
                            recepcionista.getId(),sala.getId());
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
            String horaIni = FrameEditarR.txtHoraIni.getText();
            String horaFin = FrameEditarR.txtHoraFin.getText();
            String dia = (String)FrameEditarR.txtDia.getSelectedItem();
            
            horario.setDia(dia);
            horario.setHoraEntrada(horaIni);
            horario.setHoraSalida(horaFin);
            horario.setSala(sala);
            llenarTabla();
        }
        
        @Override
        public void formEliminar(){
            int pos = FrameEditarR.tabla.getSelectedRow();
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
                String codigo = FrameEditarR.txtCodigo.getText();
                String contraseña = FrameEditarR.txtDni.getText();
                String nombre = FrameEditarR.txtNombre.getText();
                String apellido = FrameEditarR.txtApellido.getText();
                int dni = Integer.parseInt(FrameEditarR.txtDni.getText());
                String email = FrameEditarR.txtEmail.getText();
                int telefono = Integer.parseInt(FrameEditarR.txtTelefono.getText());
                int celular = Integer.parseInt(FrameEditarR.txtCelular.getText());
                int edad = Integer.parseInt(FrameEditarR.txtEdad.getText());
                Boolean sexo = true;
                if(FrameEditarR.txtFemale.isSelected()){
                    sexo = false;
                }

                recepcionista.setApellido(apellido);
                recepcionista.setCodigo(codigo);
                recepcionista.setDni(dni);
                recepcionista.setEdad(edad);
                recepcionista.setEmail(email);
                recepcionista.setHorarios(listaHorario);
                recepcionista.setNombre(nombre);
                recepcionista.setSexo(sexo);
                recepcionista.setTelefonoCasa(telefono);
                recepcionista.setTelefonoCelular(celular);
                edita = true;
                //medico.setHorarios(listaHorario);
                FrameEditarR.setVisible(false);

            }catch(Exception e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\nNo se edito al medico");
            }
            
        }
        
        private void formAsignarSala(){
            FrameSala = new SeleccionSalaR(FrameEditarR, true);
            SalasController ControladorSala = new SalasController();
            ControladorSala.index();
            System.out.println(sala.getNombre());
        }
        
        private void llenarTabla(){
            DefaultTableModel modelo = (DefaultTableModel) FrameEditarR.tabla.getModel();
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
                    
                    FrameEditarR.txtSala.setText(sala.getNombre());
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
