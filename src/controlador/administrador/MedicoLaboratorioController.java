/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.administrador;

import controlador.Controller;
import controlador.ControllerResource;
import estructura.ListaDoble;
import gui.administrador.mantenimiento.medico.medicoLaboratorio.EditarML;
import gui.administrador.mantenimiento.medico.medicoLaboratorio.InsertarML;
import gui.administrador.mantenimiento.medico.medicoLaboratorio.ListaML;
import gui.administrador.mantenimiento.medico.medicoLaboratorio.SeleccionSalaML;
import dao.dao.HorarioDao;
import dao.daoImpl.HorarioDaoImpl;
import dao.dao.MedicoLaboratorioDao;
import dao.dao.SalaDao;
import dao.daoImpl.MedicoLaboratorioDaoImpl;
import dao.daoImpl.SalaDaoImpl;
import gui.administrador.TablaFilaRoja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.empleado.MedicoLaboratorio;
import model.Horario;
import model.Sala;

/**
 *
 * @author LLLL
 */
public class MedicoLaboratorioController implements ControllerResource,ActionListener{
    private ListaML vista;
    private InsertarML FrameInsertarML;
    private EditarML FrameEditarML;
    private ListaDoble<MedicoLaboratorio> listaMedico;
    
    public MedicoLaboratorioController(ListaML view){
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
        this.vista.tablaML.setBackground(new java.awt.Color(221, 255, 220));
        
        MedicoLaboratorioDao medicoGeneralDao = new MedicoLaboratorioDaoImpl();
        listaMedico = medicoGeneralDao.listaMedicos();
        
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
        FrameInsertarML = new InsertarML(vista, true);
        AgregarController controladorAgregar =new AgregarController();
        controladorAgregar.index();
        if(controladorAgregar.isAgrega()){
            aumentarCambios();
            llenarTabla();
        }
    }
    
    @Override
    public void formEditar() {
        int pos = this.vista.tablaML.getSelectedRow();
        //-1 No se selecciona nada
        if(pos!=-1){
            MedicoLaboratorio medico = listaMedico.getDato(pos);
            System.out.println("medico : "+medico.getNombre());
            System.out.println("horarios : "+medico.getHorarios());
            FrameEditarML = new EditarML(vista, true);
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
        int pos = vista.tablaML.getSelectedRow();
        if(pos!=-1){
            MedicoLaboratorio medico = listaMedico.getDato(pos);
            if(medico.getId()==0){
                listaMedico.eliminarPos(pos);
            }else{
                medico.setSoftDelete(1);
                vista.tablaML.setDefaultRenderer(Object.class,new TablaFilaRoja(pos));
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
        Iterator<MedicoLaboratorio> iterador = listaMedico.getDescendingIterator();
        MedicoLaboratorioDao medicoGeneralDao = new MedicoLaboratorioDaoImpl();
        while(iterador.hasNext()){
            MedicoLaboratorio medico = iterador.next();
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
        vista.tablaML.setDefaultRenderer(Object.class,new TablaFilaRoja(-1));
        llenarTabla();
        JOptionPane.showMessageDialog(null, "Se guardaron todos los cambios");
    }
    
    public void formCancelar(){
        int m = JOptionPane.showConfirmDialog(null, "Se cancelaran todos los cambios\nEsta seguro ?");
        if(m==0){
            vista.txtCambios.setText("0");
            MedicoLaboratorioDao medicoLaboratorioDao = new MedicoLaboratorioDaoImpl();
            listaMedico = medicoLaboratorioDao.listaMedicos();
            vista.tablaML.setDefaultRenderer(Object.class,new TablaFilaRoja(-1));
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
        DefaultTableModel modelo = (DefaultTableModel) vista.tablaML.getModel();
        modelo.setRowCount(0);
        Iterator<MedicoLaboratorio> iterador = listaMedico.getDescendingIterator();
        while(iterador.hasNext()){
            MedicoLaboratorio medico = iterador.next();
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
            FrameInsertarML.btnAgregar.setActionCommand("Agregar");
            FrameInsertarML.btnAgregar.addActionListener(this);
        }
        
        @Override
        public void index() {
            FrameInsertarML.setVisible(true);
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
                String colegiatura = FrameInsertarML.txtColegiatura.getText();
                String codigo = FrameInsertarML.txtCodigo.getText();
                String contraseña = FrameInsertarML.txtDni.getText();
                String nombre = FrameInsertarML.txtNombre.getText();
                String apellido = FrameInsertarML.txtApellido.getText();
                int dni = Integer.parseInt(FrameInsertarML.txtDni.getText());
                String email = FrameInsertarML.txtEmail.getText();
                int telefono = Integer.parseInt(FrameInsertarML.txtTelefono.getText());
                int celular = Integer.parseInt(FrameInsertarML.txtCelular.getText());
                int edad = Integer.parseInt(FrameInsertarML.txtEdad.getText());
                Boolean sexo = true;
                if(FrameInsertarML.txtFemale.isSelected()){
                    sexo = false;
                }
                MedicoLaboratorio medico = new MedicoLaboratorio( colegiatura, codigo, contraseña, new ListaDoble<Horario>(), 0, nombre, apellido, dni, true, edad, telefono, celular, email, 0);
                listaMedico.insertarAlFinal(medico);
                this.agrega = true;
                FrameInsertarML.setVisible(false);
           
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
        SeleccionSalaML FrameSala;
        MedicoLaboratorio medico;//medico a editar
        ListaDoble<Horario> listaHorario;
        Sala sala;//sala a asignar
        Horario horario;//horario a editar
        boolean edita;
        
        public EditarController(MedicoLaboratorio medico){
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
            FrameEditarML.btnAsignarSala.setActionCommand("AsignarSala");
            FrameEditarML.btnAsignarSala.addActionListener(this);
            FrameEditarML.btnAñadir.setActionCommand("AgregarHorario");
            FrameEditarML.btnAñadir.addActionListener(this);
            FrameEditarML.btnEditar.setActionCommand("EditarHorario");
            FrameEditarML.btnEditar.addActionListener(this);
            FrameEditarML.btnModificar.setActionCommand("EditarMedico");
            FrameEditarML.btnModificar.addActionListener(this);
            FrameEditarML.btnQuitar.setActionCommand("EliminarHorario");
            FrameEditarML.btnQuitar.addActionListener(this);
            
            FrameEditarML.tabla.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    formTabla(evt);
                }
             });
            
            
            FrameEditarML.txtNombre.setText(medico.getNombre());
            FrameEditarML.txtApellido.setText(medico.getApellido());
            FrameEditarML.txtCelular.setText(""+medico.getTelefonoCelular());
            FrameEditarML.txtCodigo.setText(medico.getCodigo());
            FrameEditarML.txtColegiatura.setText(medico.getColegiatura());
            FrameEditarML.txtDni.setText(""+medico.getDni());
            FrameEditarML.txtEdad.setText(""+medico.getEdad());
            FrameEditarML.txtEmail.setText(medico.getEmail());
            FrameEditarML.txtTelefono.setText(""+medico.getTelefonoCasa());
            FrameEditarML.txtHoraFin.setText("");
            FrameEditarML.txtHoraIni.setText("");
            FrameEditarML.txtMale.setSelected(false);
            FrameEditarML.txtFemale.setSelected(false);
            if(medico.isSexo()){
               FrameEditarML.txtMale.setSelected(true);
            }else{
               FrameEditarML.txtFemale.setSelected(true); 
            }
            llenarTabla();
        }
        
        @Override
        public void index() {
            FrameEditarML.setVisible(true);
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
            int pos = FrameEditarML.tabla.getSelectedRow();
            if(pos!=-1){
                horario = listaHorario.getDato(pos);
                FrameEditarML.txtHoraIni.setText(horario.getHoraEntrada());
                FrameEditarML.txtHoraFin.setText(horario.getHoraSalida());
                FrameEditarML.txtDia.setSelectedItem(horario.getDia());
                sala = horario.getSala();
                SalaDao sdi = new SalaDaoImpl();
                Sala aux = sdi.obtenerSala(horario.getSalaId());
                FrameEditarML.txtSala.setText(aux.getNombre());
            }
        }
        
        @Override
        public void formAgregar(){
            try{
                if(sala==null){
                    JOptionPane.showMessageDialog(null, "ERROR DE ASIGNACION\nNo se agrego el horario.\nFalta asginar una sala");
                }else{
                    String horaIni = FrameEditarML.txtHoraIni.getText();
                    String horaFin = FrameEditarML.txtHoraFin.getText();
                    String dia = (String)FrameEditarML.txtDia.getSelectedItem();
                    Horario horarioAux = new Horario(0, dia, horaIni, horaFin, medico, sala,4,
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
            String horaIni = FrameEditarML.txtHoraIni.getText();
            String horaFin = FrameEditarML.txtHoraFin.getText();
            String dia = (String)FrameEditarML.txtDia.getSelectedItem();
            
            horario.setDia(dia);
            horario.setHoraEntrada(horaIni);
            horario.setHoraSalida(horaFin);
            horario.setSala(sala);
            llenarTabla();
        }
        
        @Override
        public void formEliminar(){
            int pos = FrameEditarML.tabla.getSelectedRow();
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
                String colegiatura = FrameEditarML.txtColegiatura.getText();
                String codigo = FrameEditarML.txtCodigo.getText();
                String contraseña = FrameEditarML.txtDni.getText();
                String nombre = FrameEditarML.txtNombre.getText();
                String apellido = FrameEditarML.txtApellido.getText();
                int dni = Integer.parseInt(FrameEditarML.txtDni.getText());
                String email = FrameEditarML.txtEmail.getText();
                int telefono = Integer.parseInt(FrameEditarML.txtTelefono.getText());
                int celular = Integer.parseInt(FrameEditarML.txtCelular.getText());
                int edad = Integer.parseInt(FrameEditarML.txtEdad.getText());
                Boolean sexo = true;
                if(FrameEditarML.txtFemale.isSelected()){
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
                FrameEditarML.setVisible(false);

            }catch(Exception e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\nNo se edito al medico");
            }
            
        }
        
        private void formAsignarSala(){
            FrameSala = new SeleccionSalaML(FrameEditarML, true);
            SalasController ControladorSala = new SalasController();
            ControladorSala.index();
            System.out.println(sala.getNombre());
        }
        
        private void llenarTabla(){
            DefaultTableModel modelo = (DefaultTableModel) FrameEditarML.tabla.getModel();
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
                    
                    FrameEditarML.txtSala.setText(sala.getNombre());
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
