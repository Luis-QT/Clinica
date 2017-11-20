package controlador.recepcion;

import controlador.Controller;
import estructura.ListaDoble;
import gui.recepcion.FrameRecepcionAgregar;
import gui.recepcion.FrameRecepcionAreaPacientes;
import gui.recepcion.FrameRecepcionModificar;
import gui.recepcion.FrameRecepcionPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.paciente.Paciente;
import model.paciente.Visita;

/**
 *
 * @author Luis
 */
public class RecepcionAreaPacientesController implements Controller, ActionListener {

    private FrameRecepcionAreaPacientes vista;
    private FrameRecepcionAgregar areaAgregar;
    private FrameRecepcionModificar areaModificar;

    public RecepcionAreaPacientesController(FrameRecepcionAreaPacientes vista) {
        this.vista = vista;
        iniciar();
    }

    @Override
    public void iniciar() {
        this.vista.btnBuscar.setActionCommand("Buscar");
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnOrdenar.setActionCommand("Ordenar");
        this.vista.btnOrdenar.addActionListener(this);
        this.vista.btnAgregar.setActionCommand("Agregar");
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEliminar.setActionCommand("Elimnar");
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnRefrescar.setActionCommand("Refrescar");
        this.vista.btnRefrescar.addActionListener(this);
        this.vista.btnGuardar.setActionCommand("Guardar");
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.setActionCommand("Modificar");
        this.vista.btnModificar.addActionListener(this);

    }

    @Override
    public void index() {
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("Buscar")) {
            formBuscar();
        } else if (comando.equals("Ordenar")) {
            formOrdenar();
        } else if (comando.equals("Agregar")) {
            formAgregar();
        } else if (comando.equals("Eliminar")) {
            formEliminar();
        } else if (comando.equals("Refrescar")) {
            formRefrescar();
        } else if (comando.equals("Guardar")) {
            // formGuardar();
        } else if (comando.equals("Modificar")) {
            formModificar();
        }
    }

    private void formBuscar() {
        String palabraBuscar = vista.txtBuscar.getText();
        if (vista.chxApellido.isSelected()) {
            ListaDoble<Paciente> sp = vista.getRecepcionista().buscarporApellido(palabraBuscar);
            vista.setListaPaciente(sp);
            refrescartabla(sp);
        } else if (vista.chxDni.isSelected()) {
            ListaDoble<Paciente> sp = vista.getRecepcionista().buscarporDNI(Integer.parseInt(palabraBuscar));
            vista.setListaPaciente(sp);
            refrescartabla(sp);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una opcion");
        }
    }

    public void refrescartabla(ListaDoble<Paciente> sp) {
        DefaultTableModel dtm = (DefaultTableModel) vista.tblPacientes.getModel();
        dtm.setRowCount(0);
        Iterator<Paciente> iterador = vista.listaPaciente.getDescendingIterator();
        while (iterador.hasNext()) {
            Paciente pro = iterador.next();
            dtm.addRow(new Object[]{pro.getId(), pro.getNombre(), pro.getApellido(), pro.getDni(),
                pro.getEdad(), pro.getTelefonoCasa(), pro.getTelefonoCelular(),
                pro.getEmail()});
        }
    }

    private void formOrdenar() {
        vista.idcbo = vista.cboOrdenar.getSelectedIndex();
        switch (vista.idcbo) {
            case 0:
                vista.getRecepcionista().ordenarPorNombre();
                break;
            case 1:

                vista.getRecepcionista().ordenarPorApellido();
                break;
            case 2:

                vista.getRecepcionista().ordenarPorEdad();
                break;
        }
    }

    private void formAgregar() {

        this.areaAgregar = new FrameRecepcionAgregar(new javax.swing.JDialog(), true, vista.getRecepcionista(), vista);
        new RecepcionAgregarController(areaAgregar, vista).index();

    }

    private void formEliminar() {
        System.out.println("Eliminando");
        System.out.println(vista.tblPacientes.getSelectedRow());
        vista.getRecepcionista().eliminarPaciente(vista.tblPacientes.getSelectedRow());
        refrescartabla(vista.listaPaciente);
    }

    private void formRefrescar() {
        vista.listaPaciente = vista.getRecepcionista().getListaPaciente();
        refrescartabla(vista.listaPaciente);
    }

    private void formModificar() {
        int indice = vista.tblPacientes.getSelectedRow();
        Paciente pers  = vista.listaPaciente.getDato(indice);
        this.areaModificar = new FrameRecepcionModificar(new javax.swing.JDialog(), true, vista.getRecepcionista(), vista, pers);
        new RecepcionModificarController(areaModificar, vista,pers).index();
    }

}
