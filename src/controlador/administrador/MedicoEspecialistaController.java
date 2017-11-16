/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.administrador;

import controlador.Controller;
import controlador.ControllerResource;
import estructura.ListaDoble;
import gui.administrador.Mantenimientro.Medico.MedicoEspecialista.EditarME;
import gui.administrador.Mantenimientro.Medico.MedicoEspecialista.InsertarME;
import gui.administrador.Mantenimientro.Medico.MedicoEspecialista.ListaME;
import gui.administrador.Mantenimientro.Medico.MedicoEspecialista.SeleccionSalaME;
import dao.dao.HorarioDao;
import dao.daoImpl.HorarioDaoImpl;
import dao.dao.MedicoEspecialistaDao;
import dao.daoImpl.MedicoEspecialistaDaoImpl;
import dao.dao.SalaDao;
import dao.daoImpl.SalaDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.empleado.MedicoEspecialista;
import model.Horario;
import model.Sala;

/**
 *
 * @author LLLL
 */
public class MedicoEspecialistaController implements ActionListener,ControllerResource{
    
    private ListaME vista;
    private InsertarME FrameInsertarME;
    private EditarME FrameEditarME;
    private ListaDoble<MedicoEspecialista> listaMedico;
    
    public MedicoEspecialistaController(ListaME view){
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
        
        MedicoEspecialistaDao medicoEspecialistaDao = new MedicoEspecialistaDaoImpl();
        listaMedico = medicoEspecialistaDao.listaMedicos();
        
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
        int aux = this.listaMedico.size;
        FrameInsertarME = new InsertarME(vista, true);
        AgregarController controladorAgregar =new AgregarController();
        controladorAgregar.index();
        if(controladorAgregar.isAgrega()){
            aumentarCambios();
            llenarTabla();
        }
    }
    
    @Override
    public void formEditar() {
        int pos = this.vista.tablaME.getSelectedRow();
        //-1 No se selecciona nada
        if(pos!=-1){
            MedicoEspecialista medico = listaMedico.getDato(pos);
            FrameEditarME = new EditarME(vista, true);
            EditarController controladorEditar = new EditarController(medico);
            controladorEditar.index();
            if(controladorEditar.isEdita()){
                aumentarCambios();
                llenarTabla();
            }
        }
    }

    @Override
    public void formEliminar() {
        int pos = vista.tablaME.getSelectedRow();
        if(pos!=-1){
            MedicoEspecialista medico = listaMedico.getDato(pos);
            if(medico.getId()==0){
                listaMedico.eliminarPos(pos);
            }else{
                medico.setSoftDelete(1);
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
        Iterator<MedicoEspecialista> iterador = listaMedico.getDescendingIterator();
        MedicoEspecialistaDao medicoEspecialistaDao = new MedicoEspecialistaDaoImpl();
        while(iterador.hasNext()){
            MedicoEspecialista medico = iterador.next();
            if(medico.getSoftDelete()==1){
                //se desea eliminar
                medicoEspecialistaDao.eliminarMedico(medico.getId());
            }else{
                //agregar o editar
                medicoEspecialistaDao.guardarMedico(medico);
            }
            if(medico.getHorarios()!=null){
                Iterator<Horario> iteradorHo = medico.getHorarios().getDescendingIterator();
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
        llenarTabla();
        JOptionPane.showMessageDialog(null, "Se guardaron todos los cambios");
    }
    
    public void formCancelar(){
        int m = JOptionPane.showConfirmDialog(null, "Se cancelaran todos los cambios\nEsta seguro ?");
        if(m==0){
            vista.txtCambios.setText("0");
            MedicoEspecialistaDao medicoEspecialistaDao = new MedicoEspecialistaDaoImpl();
            listaMedico = medicoEspecialistaDao.listaMedicos();
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
        DefaultTableModel modelo = (DefaultTableModel) vista.tablaME.getModel();
        modelo.setRowCount(0);
        Iterator<MedicoEspecialista> iterador = listaMedico.getDescendingIterator();
        while(iterador.hasNext()){
            MedicoEspecialista medico = iterador.next();
            if(medico.getSoftDelete()!=1){
                modelo.addRow(new Object[]{medico.getCodigo(), medico.getNombre(), medico.getApellido(),
                        medico.getEspecialidad(),
                        medico.getDni() ,medico.getEdad(),medico.getColegiatura() ,
                        medico.getEmail(),medico.getTelefonoCasa(),medico.getTelefonoCelular()
                        ,medico.getSoftDelete()});
            }
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
            FrameInsertarME.btnAgregar.setActionCommand("Agregar");
            FrameInsertarME.btnAgregar.addActionListener(this);
        }
        
        @Override
        public void index() {
            FrameInsertarME.setVisible(true);
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
                String especialidad = FrameInsertarME.txtEspecialidad.getText();
                String colegiatura = FrameInsertarME.txtColegiatura.getText();
                String codigo = FrameInsertarME.txtCodigo.getText();
                String contraseña = FrameInsertarME.txtDni.getText();
                String nombre = FrameInsertarME.txtNombre.getText();
                String apellido = FrameInsertarME.txtApellido.getText();
                int dni = Integer.parseInt(FrameInsertarME.txtDni.getText());
                String email = FrameInsertarME.txtEmail.getText();
                int telefono = Integer.parseInt(FrameInsertarME.txtTelefono.getText());
                int celular = Integer.parseInt(FrameInsertarME.txtCelular.getText());
                int edad = Integer.parseInt(FrameInsertarME.txtEdad.getText());
                Boolean sexo = true;
                if(FrameInsertarME.txtFemale.isSelected()){
                    sexo = false;
                }
                MedicoEspecialista medico = new MedicoEspecialista(especialidad,colegiatura, codigo, contraseña, new ListaDoble<Horario>(), 0, nombre, apellido, dni, true, edad, telefono, celular, email, 0);
                listaMedico.insertarAlFinal(medico);
                this.agrega = true;
                FrameInsertarME.setVisible(false);
           
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
        SeleccionSalaME FrameSala;
        MedicoEspecialista medico;//medico a editar
        ListaDoble<Horario> listaHorario;
        Sala sala;//sala a asignar
        Horario horario;//horario a editar
        boolean edita;
        
        public EditarController(MedicoEspecialista medico){
            this.medico = medico;
            listaHorario = medico.getHorarios();
            
            edita = false;
            sala = null;
            horario = null;
            iniciar();
        }
        @Override
        public void iniciar() {
            FrameEditarME.btnAsignarSala.setActionCommand("AsignarSala");
            FrameEditarME.btnAsignarSala.addActionListener(this);
            FrameEditarME.btnAñadir.setActionCommand("AgregarHorario");
            FrameEditarME.btnAñadir.addActionListener(this);
            FrameEditarME.btnEditar.setActionCommand("EditarHorario");
            FrameEditarME.btnEditar.addActionListener(this);
            FrameEditarME.btnModificar.setActionCommand("EditarMedico");
            FrameEditarME.btnModificar.addActionListener(this);
            FrameEditarME.btnQuitar.setActionCommand("EliminarHorario");
            FrameEditarME.btnQuitar.addActionListener(this);
            
            FrameEditarME.tabla.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    formTabla(evt);
                }
             });
            
            FrameEditarME.txtEspecialidad.setText(medico.getEspecialidad());
            FrameEditarME.txtNombre.setText(medico.getNombre());
            FrameEditarME.txtApellido.setText(medico.getApellido());
            FrameEditarME.txtCelular.setText(""+medico.getTelefonoCelular());
            FrameEditarME.txtCodigo.setText(medico.getCodigo());
            FrameEditarME.txtColegiatura.setText(medico.getColegiatura());
            FrameEditarME.txtDni.setText(""+medico.getDni());
            FrameEditarME.txtEdad.setText(""+medico.getEdad());
            FrameEditarME.txtEmail.setText(medico.getEmail());
            FrameEditarME.txtTelefono.setText(""+medico.getTelefonoCasa());
            FrameEditarME.txtHoraFin.setText("");
            FrameEditarME.txtHoraIni.setText("");
            FrameEditarME.txtMale.setSelected(false);
            FrameEditarME.txtFemale.setSelected(false);
            if(medico.isSexo()){
               FrameEditarME.txtMale.setSelected(true);
            }else{
               FrameEditarME.txtFemale.setSelected(true); 
            }
            llenarTabla();
        }
        
        @Override
        public void index() {
            FrameEditarME.setVisible(true);
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            if(comando.equals("AgregarHorario")){
                formAgregar();
            }else if(comando.equals("EditarHorario")){
                formEditar();
            }else if(comando.equals("EditarMedico")){
                formEditarMedico();
            }else if(comando.equals("EliminarHorario")){
                formEliminar();
            }else if(comando.equals("AsignarSala")){
                formAsignarSala();
            }
        }
        
        private void formTabla(MouseEvent evt){
            int pos = FrameEditarME.tabla.getSelectedRow();
            if(pos!=-1){
                horario = listaHorario.getDato(pos);
                FrameEditarME.txtHoraIni.setText(horario.getHoraEntrada());
                FrameEditarME.txtHoraFin.setText(horario.getHoraSalida());
                FrameEditarME.txtDia.setSelectedItem(horario.getDia());
                sala = horario.getSala();
                SalaDao sdi = new SalaDaoImpl();
                Sala aux = sdi.obtenerSala(horario.getSalaId());
                FrameEditarME.txtSala.setText(aux.getNombre());
            }
        }
        
        @Override
        public void formAgregar(){
            try{
                if(sala==null){
                    JOptionPane.showMessageDialog(null, "ERROR DE ASIGNACION\nNo se agrego el horario.\nFalta asginar una sala");
                }else{
                    String horaIni = FrameEditarME.txtHoraIni.getText();
                    String horaFin = FrameEditarME.txtHoraFin.getText();
                    String dia = (String)FrameEditarME.txtDia.getSelectedItem();
                    Horario horarioAux = new Horario(0, dia, horaIni, horaFin, medico, sala,2,
                            medico.getId(),sala.getId());
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
            String horaIni = FrameEditarME.txtHoraIni.getText();
            String horaFin = FrameEditarME.txtHoraFin.getText();
            String dia = (String)FrameEditarME.txtDia.getSelectedItem();
            
            horario.setDia(dia);
            horario.setHoraEntrada(horaIni);
            horario.setHoraSalida(horaFin);
            horario.setSala(sala);
            llenarTabla();
        }
        
        @Override
        public void formEliminar(){
            int pos = FrameEditarME.tabla.getSelectedRow();
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
                String especialidad = FrameEditarME.txtEspecialidad.getText();
                String colegiatura = FrameEditarME.txtColegiatura.getText();
                String codigo = FrameEditarME.txtCodigo.getText();
                String contraseña = FrameEditarME.txtDni.getText();
                String nombre = FrameEditarME.txtNombre.getText();
                String apellido = FrameEditarME.txtApellido.getText();
                int dni = Integer.parseInt(FrameEditarME.txtDni.getText());
                String email = FrameEditarME.txtEmail.getText();
                int telefono = Integer.parseInt(FrameEditarME.txtTelefono.getText());
                int celular = Integer.parseInt(FrameEditarME.txtCelular.getText());
                int edad = Integer.parseInt(FrameEditarME.txtEdad.getText());
                Boolean sexo = true;
                if(FrameEditarME.txtFemale.isSelected()){
                    sexo = false;
                }
                
                medico.setEspecialidad(especialidad);
                medico.setApellido(apellido);
                medico.setCodigo(codigo);
                medico.setColegiatura(colegiatura);
                medico.setDni(dni);
                medico.setEdad(edad);
                medico.setEmail(email);
                medico.setHorarios(listaHorario);
                medico.setNombre(nombre);
                medico.setSexo(sexo);
                medico.setTelefonoCasa(telefono);
                medico.setTelefonoCelular(celular);
                edita = true;
                //medico.setHorarios(listaHorario);
                FrameEditarME.setVisible(false);

            }catch(Exception e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\nNo se edito al medico");
            }
            
        }
        
        private void formAsignarSala(){
            FrameSala = new SeleccionSalaME(FrameEditarME, true);
            SalasController ControladorSala = new SalasController();
            ControladorSala.index();
            System.out.println(sala.getNombre());
        }
        
        private void llenarTabla(){
            DefaultTableModel modelo = (DefaultTableModel) FrameEditarME.tabla.getModel();
            modelo.setRowCount(0);
            Iterator<Horario> iterador = this.listaHorario.getDescendingIterator();
            SalaDao sdi = new SalaDaoImpl();
            Sala auxSala = null;
            while(iterador.hasNext()){
                Horario auxH = iterador.next();
                System.out.println(auxH.getSalaId());
                auxSala = sdi.obtenerSala(auxH.getSalaId());
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
                    
                    FrameEditarME.txtSala.setText(sala.getNombre());
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
