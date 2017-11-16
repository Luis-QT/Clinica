/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.administrador;

import controlador.Controller;
import controlador.ControllerResource;
import estructura.ListaDoble;
import gui.administrador.Mantenimientro.Medico.MedicoGeneral.SeleccionSalaMG;
import gui.administrador.Mantenimientro.Medico.MedicoTriaje.EditarMT;
import gui.administrador.Mantenimientro.Medico.MedicoTriaje.InsertarMT;
import gui.administrador.Mantenimientro.Medico.MedicoTriaje.ListaMT;
import dao.dao.HorarioDao;
import dao.dao.MedicoTriajeDao;
import dao.dao.SalaDao;
import dao.daoImpl.HorarioDaoImpl;
import dao.daoImpl.MedicoTriajeDaoImpl;
import dao.daoImpl.SalaDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.empleado.MedicoTriaje;
import model.Horario;
import model.Sala;

/**
 *
 * @author LLLL
 */
public class MedicoTriajeController implements ActionListener,ControllerResource{
    private ListaMT vista;
    private InsertarMT FrameInsertarMT;
    private EditarMT FrameEditarMT;
    private ListaDoble<MedicoTriaje> listaMedico;
    
    public MedicoTriajeController(ListaMT view){
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
        
        MedicoTriajeDao medicoGeneralDao = new MedicoTriajeDaoImpl();
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
        FrameInsertarMT = new InsertarMT(vista, true);
        AgregarController controladorAgregar =new AgregarController();
        controladorAgregar.index();
        if(controladorAgregar.isAgrega()){
            aumentarCambios();
            llenarTabla();
        }
    }
    
    @Override
    public void formEditar() {
        int pos = this.vista.tablaMT.getSelectedRow();
        //-1 No se selecciona nada
        if(pos!=-1){
            MedicoTriaje medico = listaMedico.getDato(pos);
            System.out.println("medico : "+medico.getNombre());
            System.out.println("horarios : "+medico.getHorarios());
            FrameEditarMT = new EditarMT(vista, true);
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
        int pos = vista.tablaMT.getSelectedRow();
        if(pos!=-1){
            MedicoTriaje medico = listaMedico.getDato(pos);
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
        Iterator<MedicoTriaje> iterador = listaMedico.getDescendingIterator();
        MedicoTriajeDao medicoTriajeDao = new MedicoTriajeDaoImpl();
        while(iterador.hasNext()){
            MedicoTriaje medico = iterador.next();
            if(medico.getSoftDelete()==1){
                //se desea eliminar
                medicoTriajeDao.eliminarMedico(medico.getId());
            }else{
                //agregar o editar
                medicoTriajeDao.guardarMedico(medico);
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
            MedicoTriajeDao medicoTriajeDao = new MedicoTriajeDaoImpl();
            listaMedico = medicoTriajeDao.listaMedicos();
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
        DefaultTableModel modelo = (DefaultTableModel) vista.tablaMT.getModel();
        modelo.setRowCount(0);
        Iterator<MedicoTriaje> iterador = listaMedico.getDescendingIterator();
        while(iterador.hasNext()){
            MedicoTriaje medico = iterador.next();
            if(medico.getSoftDelete()!=1){
                modelo.addRow(new Object[]{medico.getCodigo(), medico.getNombre(), medico.getApellido(),
                        medico.getDni() ,medico.getEdad(),medico.getColegiatura() ,
                        medico.getEmail(),medico.getTelefonoCasa(),medico.getTelefonoCelular()
                        });
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
            FrameInsertarMT.btnAgregar.setActionCommand("Agregar");
            FrameInsertarMT.btnAgregar.addActionListener(this);
        }
        
        @Override
        public void index() {
            FrameInsertarMT.setVisible(true);
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
                String colegiatura = FrameInsertarMT.txtColegiatura.getText();
                String codigo = FrameInsertarMT.txtCodigo.getText();
                String contraseña = FrameInsertarMT.txtDni.getText();
                String nombre = FrameInsertarMT.txtNombre.getText();
                String apellido = FrameInsertarMT.txtApellido.getText();
                int dni = Integer.parseInt(FrameInsertarMT.txtDni.getText());
                String email = FrameInsertarMT.txtEmail.getText();
                int telefono = Integer.parseInt(FrameInsertarMT.txtTelefono.getText());
                int celular = Integer.parseInt(FrameInsertarMT.txtCelular.getText());
                int edad = Integer.parseInt(FrameInsertarMT.txtEdad.getText());
                Boolean sexo = true;
                if(FrameInsertarMT.txtFemale.isSelected()){
                    sexo = false;
                }
                MedicoTriaje medico = new MedicoTriaje(colegiatura, codigo, contraseña, new ListaDoble<Horario>(), 0, nombre, apellido, dni, true, edad, telefono, celular, email, 0);
                listaMedico.insertarAlFinal(medico);
                this.agrega = true;
                FrameInsertarMT.setVisible(false);
           
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
        MedicoTriaje medico;//medico a editar
        ListaDoble<Horario> listaHorario;
        Sala sala;//sala a asignar
        Horario horario;//horario a editar
        boolean edita;
        
        public EditarController(MedicoTriaje medico){
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
            FrameEditarMT.btnAsignarSala.setActionCommand("AsignarSala");
            FrameEditarMT.btnAsignarSala.addActionListener(this);
            FrameEditarMT.btnAñadir.setActionCommand("AgregarHorario");
            FrameEditarMT.btnAñadir.addActionListener(this);
            FrameEditarMT.btnEditar.setActionCommand("EditarHorario");
            FrameEditarMT.btnEditar.addActionListener(this);
            FrameEditarMT.btnModificar.setActionCommand("EditarMedico");
            FrameEditarMT.btnModificar.addActionListener(this);
            FrameEditarMT.btnQuitar.setActionCommand("EliminarHorario");
            FrameEditarMT.btnQuitar.addActionListener(this);
            
            FrameEditarMT.tabla.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    formTabla(evt);
                }
             });
            
            
            FrameEditarMT.txtNombre.setText(medico.getNombre());
            FrameEditarMT.txtApellido.setText(medico.getApellido());
            FrameEditarMT.txtCelular.setText(""+medico.getTelefonoCelular());
            FrameEditarMT.txtCodigo.setText(medico.getCodigo());
            FrameEditarMT.txtColegiatura.setText(medico.getColegiatura());
            FrameEditarMT.txtDni.setText(""+medico.getDni());
            FrameEditarMT.txtEdad.setText(""+medico.getEdad());
            FrameEditarMT.txtEmail.setText(medico.getEmail());
            FrameEditarMT.txtTelefono.setText(""+medico.getTelefonoCasa());
            FrameEditarMT.txtHoraFin.setText("");
            FrameEditarMT.txtHoraIni.setText("");
            FrameEditarMT.txtMale.setSelected(false);
            FrameEditarMT.txtFemale.setSelected(false);
            if(medico.isSexo()){
               FrameEditarMT.txtMale.setSelected(true);
            }else{
               FrameEditarMT.txtFemale.setSelected(true); 
            }
            llenarTabla();
        }
        
        @Override
        public void index() {
            FrameEditarMT.setVisible(true);
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
            int pos = FrameEditarMT.tabla.getSelectedRow();
            if(pos!=-1){
                horario = listaHorario.getDato(pos);
                FrameEditarMT.txtHoraIni.setText(horario.getHoraEntrada());
                FrameEditarMT.txtHoraFin.setText(horario.getHoraSalida());
                FrameEditarMT.txtDia.setSelectedItem(horario.getDia());
                sala = horario.getSala();
                SalaDao sdi = new SalaDaoImpl();
                Sala aux = sdi.obtenerSala(horario.getSalaId());
                FrameEditarMT.txtSala.setText(aux.getNombre());
            }
        }
        
        @Override
        public void formAgregar(){
            try{
                if(sala==null){
                    JOptionPane.showMessageDialog(null, "ERROR DE ASIGNACION\nNo se agrego el horario.\nFalta asginar una sala");
                }else{
                    String horaIni = FrameEditarMT.txtHoraIni.getText();
                    String horaFin = FrameEditarMT.txtHoraFin.getText();
                    String dia = (String)FrameEditarMT.txtDia.getSelectedItem();
                    Horario horarioAux = new Horario(0, dia, horaIni, horaFin, medico, sala,3,
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
            String horaIni = FrameEditarMT.txtHoraIni.getText();
            String horaFin = FrameEditarMT.txtHoraFin.getText();
            String dia = (String)FrameEditarMT.txtDia.getSelectedItem();
            
            horario.setDia(dia);
            horario.setHoraEntrada(horaIni);
            horario.setHoraSalida(horaFin);
            horario.setSala(sala);
            llenarTabla();
        }
        
        @Override
        public void formEliminar(){
            int pos = FrameEditarMT.tabla.getSelectedRow();
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
                String colegiatura = FrameEditarMT.txtColegiatura.getText();
                String codigo = FrameEditarMT.txtCodigo.getText();
                String contraseña = FrameEditarMT.txtDni.getText();
                String nombre = FrameEditarMT.txtNombre.getText();
                String apellido = FrameEditarMT.txtApellido.getText();
                int dni = Integer.parseInt(FrameEditarMT.txtDni.getText());
                String email = FrameEditarMT.txtEmail.getText();
                int telefono = Integer.parseInt(FrameEditarMT.txtTelefono.getText());
                int celular = Integer.parseInt(FrameEditarMT.txtCelular.getText());
                int edad = Integer.parseInt(FrameEditarMT.txtEdad.getText());
                Boolean sexo = true;
                if(FrameEditarMT.txtFemale.isSelected()){
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
                FrameEditarMT.setVisible(false);

            }catch(Exception e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "ERROR DE ESCRITURA\nNo se edito al medico");
            }
            
        }
        
        private void formAsignarSala(){
            FrameSala = new SeleccionSalaMG(FrameEditarMT, true);
            SalasController ControladorSala = new SalasController();
            ControladorSala.index();
            System.out.println(sala.getNombre());
        }
        
        private void llenarTabla(){
            DefaultTableModel modelo = (DefaultTableModel) FrameEditarMT.tabla.getModel();
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
                    
                    FrameEditarMT.txtSala.setText(sala.getNombre());
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
