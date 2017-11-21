/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.administrador;

import controlador.Controller;
import controlador.ControllerResource;
import estructura.ListaDoble;
import gui.administrador.mantenimiento.medico.medicoGeneral.EditarMG;
import gui.administrador.mantenimiento.medico.medicoGeneral.InsertarMG;
import gui.administrador.mantenimiento.medico.medicoGeneral.ListaMG;
import gui.administrador.mantenimiento.medico.medicoGeneral.SeleccionSalaMG;

import dao.dao.HorarioDao;
import dao.daoImpl.HorarioDaoImpl;
import dao.dao.MedicoGeneralDao;
import dao.daoImpl.MedicoGeneralDaoImpl;
import dao.dao.SalaDao;
import dao.daoImpl.SalaDaoImpl;
import gui.administrador.TablaFilaRoja;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.empleado.Empleado;
import model.empleado.MedicoGeneral;
import model.Horario;
import model.Sala;

/** 
 *
 * @author LLLL
 */
public class MedicoGeneralController implements ActionListener,ControllerResource{
    private ListaMG vista;
    private InsertarMG FrameInsertarMG;
    private EditarMG FrameEditarMG;
    private ListaDoble<MedicoGeneral> listaMedico;
    
    public MedicoGeneralController(ListaMG view){
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
        
        vista.btnCerrar.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    vista.setVisible(false);
                }
            });
        
        MedicoGeneralDao medicoGeneralDao = new MedicoGeneralDaoImpl();
        listaMedico = medicoGeneralDao.listaMedicos();
        this.vista.TablaML.setBackground(new java.awt.Color(221, 255, 220));
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
        FrameInsertarMG = new InsertarMG(vista, true);
        AgregarController controladorAgregar =new AgregarController();
        controladorAgregar.index();
        if(controladorAgregar.isAgrega()){
            aumentarCambios();
            llenarTabla();
        }
    }
    
    @Override
    public void formEditar() {
        int pos = this.vista.TablaML.getSelectedRow();
        //-1 No se selecciona nada
        if(pos!=-1){
            MedicoGeneral medico = listaMedico.getDato(pos);
            System.out.println("medico : "+medico.getNombre());
            System.out.println("horarios : "+medico.getHorarios());
            FrameEditarMG = new EditarMG(vista, true);
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
        int pos = vista.TablaML.getSelectedRow();
        if(pos!=-1){
            MedicoGeneral medico = listaMedico.getDato(pos);
            if(medico.getId()==0){
                listaMedico.eliminarPos(pos);
            }else{
                medico.setSoftDelete(1);
                vista.TablaML.setDefaultRenderer(Object.class,new TablaFilaRoja(pos));
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
        Iterator<MedicoGeneral> iterador = listaMedico.getDescendingIterator();
        MedicoGeneralDao medicoGeneralDao = new MedicoGeneralDaoImpl();
        while(iterador.hasNext()){
            MedicoGeneral medico = iterador.next();
            if(medico.getSoftDelete()==1){
                //se desea eliminar
                medicoGeneralDao.eliminarMedico(medico.getId());
            }else{
                //agregar o editar
                medicoGeneralDao.guardarMedico(medico);
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
        listaMedico = medicoGeneralDao.listaMedicos();
        vista.TablaML.setDefaultRenderer(Object.class,new TablaFilaRoja(-1));
        llenarTabla();
        JOptionPane.showMessageDialog(null, "Se guardaron todos los cambios");
    }
    
    public void formCancelar(){
        int m = JOptionPane.showConfirmDialog(null, "Se cancelaran todos los cambios\nEsta seguro ?");
        if(m==0){
            vista.txtCambios.setText("0");
            MedicoGeneralDao medicoGeneralDao = new MedicoGeneralDaoImpl();
            listaMedico = medicoGeneralDao.listaMedicos();
            vista.TablaML.setDefaultRenderer(Object.class,new TablaFilaRoja(-1));
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
        DefaultTableModel modelo = (DefaultTableModel) vista.TablaML.getModel();
        modelo.setRowCount(0);
        Iterator<MedicoGeneral> iterador = listaMedico.getDescendingIterator();
        while(iterador.hasNext()){
            MedicoGeneral medico = iterador.next();
            
            modelo.addRow(new Object[]{medico.getCodigo(), medico.getNombre(), medico.getApellido(),
                    medico.getDni() ,medico.getEdad(),medico.getColegiatura() ,
                    medico.getEmail(),medico.getTelefonoCasa(),medico.getTelefonoCelular()
                    ,medico.getSoftDelete()});
            
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
            FrameInsertarMG.btnAgregar.setActionCommand("Agregar");
            FrameInsertarMG.btnAgregar.addActionListener(this);
        }
        
        @Override
        public void index() {
            FrameInsertarMG.setVisible(true);
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
                String colegiatura = FrameInsertarMG.txtColegiatura.getText();
                String codigo = FrameInsertarMG.txtCodigo.getText();
                String contraseña = FrameInsertarMG.txtDni.getText();
                String nombre = FrameInsertarMG.txtNombre.getText();
                String apellido = FrameInsertarMG.txtApellido.getText();
                int dni = Integer.parseInt(FrameInsertarMG.txtDni.getText());
                String email = FrameInsertarMG.txtEmail.getText();
                int telefono = Integer.parseInt(FrameInsertarMG.txtTelefono.getText());
                int celular = Integer.parseInt(FrameInsertarMG.txtCelular.getText());
                int edad = Integer.parseInt(FrameInsertarMG.txtEdad.getText());
                Boolean sexo = true;
                if(FrameInsertarMG.txtFemale.isSelected()){
                    sexo = false;
                }
                MedicoGeneral medico = new MedicoGeneral(colegiatura, codigo, contraseña, new ListaDoble<Horario>(), 0, nombre, apellido, dni, true, edad, telefono, celular, email, 0);
                listaMedico.insertarAlFinal(medico);
                this.agrega = true;
                FrameInsertarMG.setVisible(false);
           
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
        SeleccionSalaMG FrameSala;
        MedicoGeneral medico;//medico a editar
        ListaDoble<Horario> listaHorario;
        Sala sala;//sala a asignar
        Horario horario;//horario a editar
        boolean edita;
        
        public EditarController(MedicoGeneral medico){
            this.medico = medico;
            listaHorario = medico.getHorarios();
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
            FrameEditarMG.btnAsignarSala.setActionCommand("AsignarSala");
            FrameEditarMG.btnAsignarSala.addActionListener(this);
            FrameEditarMG.btnAñadir.setActionCommand("AgregarHorario");
            FrameEditarMG.btnAñadir.addActionListener(this);
            FrameEditarMG.btnEditar.setActionCommand("EditarHorario");
            FrameEditarMG.btnEditar.addActionListener(this);
            FrameEditarMG.btnModificar.setActionCommand("EditarMedico");
            FrameEditarMG.btnModificar.addActionListener(this);
            FrameEditarMG.btnQuitar.setActionCommand("EliminarHorario");
            FrameEditarMG.btnQuitar.addActionListener(this);
            
            FrameEditarMG.tabla.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    formTabla(evt);
                }
             });
            
            
            FrameEditarMG.txtNombre.setText(medico.getNombre());
            FrameEditarMG.txtApellido.setText(medico.getApellido());
            FrameEditarMG.txtCelular.setText(""+medico.getTelefonoCelular());
            FrameEditarMG.txtCodigo.setText(medico.getCodigo());
            FrameEditarMG.txtColegiatura.setText(medico.getColegiatura());
            FrameEditarMG.txtDni.setText(""+medico.getDni());
            FrameEditarMG.txtEdad.setText(""+medico.getEdad());
            FrameEditarMG.txtEmail.setText(medico.getEmail());
            FrameEditarMG.txtTelefono.setText(""+medico.getTelefonoCasa());
            FrameEditarMG.txtHoraFin.setText("");
            FrameEditarMG.txtHoraIni.setText("");
            FrameEditarMG.txtMale.setSelected(false);
            FrameEditarMG.txtFemale.setSelected(false);
            if(medico.isSexo()){
               FrameEditarMG.txtMale.setSelected(true);
            }else{
               FrameEditarMG.txtFemale.setSelected(true); 
            }
            llenarTabla();
        }
        
        @Override
        public void index() {
            FrameEditarMG.setVisible(true);
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
            int pos = FrameEditarMG.tabla.getSelectedRow();
            if(pos!=-1){
                horario = listaHorario.getDato(pos);
                FrameEditarMG.txtHoraIni.setText(horario.getHoraEntrada());
                FrameEditarMG.txtHoraFin.setText(horario.getHoraSalida());
                FrameEditarMG.txtDia.setSelectedItem(horario.getDia());
                sala = horario.getSala();
                SalaDao sdi = new SalaDaoImpl();
                Sala aux = sdi.obtenerSala(horario.getSalaId());
                FrameEditarMG.txtSala.setText(aux.getNombre());
            }
        }
        
        @Override
        public void formAgregar(){
            try{
                if(sala==null){
                    JOptionPane.showMessageDialog(null, "ERROR DE ASIGNACION\nNo se agrego el horario.\nFalta asginar una sala");
                }else{
                    String horaIni = FrameEditarMG.txtHoraIni.getText();
                    String horaFin = FrameEditarMG.txtHoraFin.getText();
                    String dia = (String)FrameEditarMG.txtDia.getSelectedItem();
                    Horario horarioAux = new Horario(0, dia, horaIni, horaFin, medico, sala,1,
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
            String horaIni = FrameEditarMG.txtHoraIni.getText();
            String horaFin = FrameEditarMG.txtHoraFin.getText();
            String dia = (String)FrameEditarMG.txtDia.getSelectedItem();
            
            horario.setDia(dia);
            horario.setHoraEntrada(horaIni);
            horario.setHoraSalida(horaFin);
            horario.setSala(sala);
            llenarTabla();
        }
        
        @Override
        public void formEliminar(){
            int pos = FrameEditarMG.tabla.getSelectedRow();
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
                String colegiatura = FrameEditarMG.txtColegiatura.getText();
                String codigo = FrameEditarMG.txtCodigo.getText();
                String contraseña = FrameEditarMG.txtDni.getText();
                String nombre = FrameEditarMG.txtNombre.getText();
                String apellido = FrameEditarMG.txtApellido.getText();
                int dni = Integer.parseInt(FrameEditarMG.txtDni.getText());
                String email = FrameEditarMG.txtEmail.getText();
                int telefono = Integer.parseInt(FrameEditarMG.txtTelefono.getText());
                int celular = Integer.parseInt(FrameEditarMG.txtCelular.getText());
                int edad = Integer.parseInt(FrameEditarMG.txtEdad.getText());
                Boolean sexo = true;
                if(FrameEditarMG.txtFemale.isSelected()){
                    sexo = false;
                }

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
                FrameEditarMG.setVisible(false);

            }catch(Exception e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\nNo se edito al medico");
            }
            
        }
        
        private void formAsignarSala(){
            FrameSala = new SeleccionSalaMG(FrameEditarMG, true);
            SalasController ControladorSala = new SalasController();
            ControladorSala.index();
            System.out.println(sala.getNombre());
        }
        
        private void llenarTabla(){
            DefaultTableModel modelo = (DefaultTableModel) FrameEditarMG.tabla.getModel();
            modelo.setRowCount(0);
            Iterator<Horario> iterador = this.listaHorario.getDescendingIterator();
            SalaDao sdi = new SalaDaoImpl();
            Sala auxSala = null;
            while(iterador.hasNext()){
                Horario auxH = iterador.next();
                System.out.println("antes");
                auxSala = sdi.obtenerSala(auxH.getSalaId());
                System.out.println(auxSala.getId());
                if(!auxH.isEliminar()){
                    modelo.addRow(new Object[]{auxH.getDia(),auxH.getHoraEntrada(),auxH.getHoraSalida(),auxSala.getNombre() });
                }
                System.out.println("despues");
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
                    
                    FrameEditarMG.txtSala.setText(sala.getNombre());
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
