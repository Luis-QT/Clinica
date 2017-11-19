
package controlador.contabilidad;

import controlador.Controller;
import estructura.ListaDoble;
import factory.MySQLConnectionFactory;
import gui.contabilidad.FrameContabilidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.empleado.Cajero;
import model.empleado.Monto;
import model.empleado.Servicios;
import model.paciente.Paciente;


public class ContabilidadController implements Controller,ActionListener{
    private FrameContabilidad vista;
    
    public ContabilidadController (FrameContabilidad vista){
        this.vista = vista;
        iniciar();
    }

    @Override
    public void iniciar() {
        this.vista.btnElegir.setActionCommand("Elegir");
        this.vista.btnElegir.addActionListener(this);
        
        this.vista.btnDeshacer.setActionCommand("Deshacer");
        this.vista.btnDeshacer.addActionListener(this);
        
        this.vista.btnGenerarMonto.setActionCommand("Generar Monto");
        this.vista.btnGenerarMonto.addActionListener(this);
        
        this.vista.btnNuevo.setActionCommand("Nuevo Cliente");
        this.vista.btnNuevo.addActionListener(this);
        
        this.vista.btnRegistrar.setActionCommand("Registrar");
        this.vista.btnRegistrar.addActionListener(this);
        
        this.vista.btnPrecio.setActionCommand("Precio");
        this.vista.btnPrecio.addActionListener(this);
        
        this.vista.rbtnConsulta.setActionCommand("Consulta");
        this.vista.rbtnConsulta.addActionListener(this);
        
        this.vista.rbtnLaboratorio.setActionCommand("Laboratorio");
        this.vista.rbtnLaboratorio.addActionListener(this);
        
        
        this.vista.txtBuscar.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent evt){
                formBuscar();
            }
        });
        
         this.vista.txtPago.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent evt){
                DameVuelto();
            }
            
        
        });

       
    }

    @Override
    public void index() {
        vista.setVisible(true);
    }

    @Override
   public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals("Elegir")){
            formElegir();
        }else if(comando.equals("Deshacer")){
            formDeshacer();
        }else if(comando.equals("Generar Monto")){
            formGenerarMonto();
        }else if(comando.equals("Nuevo Cliente")){
            formNuevoCliente();
        }else if(comando.equals("Registrar")){
            formRegistrar();
        }else if(comando.equals("Precio")){
            formOrdenarPrecio();
        }else if(comando.equals("Consulta")){
            formOrdenarConsulta();
        }else if(comando.equals("Laboratorio")){
            formOrdenarLaboratorio();
        }
        }
    
   public void formElegir(){
       try {
           Cajero caja = vista.getCaja();
           ListaDoble<Servicios> listaConsultaServicios = vista.getListaConsultaServicios();
           ListaDoble<Servicios> listaSeleccionGeneral = vista.getListaSeleccionGeneral();
           ListaDoble<Servicios> listaLaboratorioServicios = vista.getListaLaboratorioServicios();
           ListaDoble<Servicios> listaServicios = vista.getListaServicios();
           if (vista.rbtnConsulta.isSelected()) {
               int t = vista.TablaServicios.getSelectedRow();
               Servicios set = listaServicios.getDato(t);

               listaSeleccionGeneral.insertarAlFinal(set);

               vista.mostrarTablaSeleccion(listaSeleccionGeneral);
           } else if (vista.rbtnLaboratorio.isSelected()) {

               int t = vista.TablaServicios.getSelectedRow();
               Servicios set = listaServicios.getDato(t);

               listaSeleccionGeneral.insertarAlFinal(set);

               vista.mostrarTablaSeleccion(listaSeleccionGeneral);

           } else {
               int i = vista.TablaServicios.getSelectedRow();
               Servicios set = listaServicios.getDato(i);

               listaSeleccionGeneral.insertarAlFinal(set);

               vista.mostrarTablaSeleccion(listaSeleccionGeneral);

           }
           
       } catch (Exception e) {
           System.out.println(e.getMessage());
           JOptionPane.showMessageDialog(null, "Elija una opción\n");
       }
        
    }
    
    private void formDeshacer() {
        try{
            
            ListaDoble<Servicios> listaSeleccionGeneral = vista.getListaSeleccionGeneral();
            int i = vista.TablaSeleccion.getSelectedRow();
            listaSeleccionGeneral.eliminarPos(i);
            vista.mostrarTablaSeleccion(listaSeleccionGeneral);
            }
        catch(Exception e){
            System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Elija una opcion\n");
        }
    }

    private void formGenerarMonto() {
        try {
            int cant = vista.TablaSeleccion.getRowCount();
            int i = 0;
            Float suma = 0F;
            while (cant > i) {
                suma = suma + ((Float) vista.TablaSeleccion.getValueAt(i, 1) * (Float) vista.TablaSeleccion.getValueAt(i, 2));

                i++;
            }
            vista.txtMonto.setText(String.valueOf(suma));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Elija una opción\n");
        }

    }

    private void formBuscar() {
        try {
            Cajero caja = vista.getCaja();
            ListaDoble<Servicios> listaServicios = vista.getListaServicios();
            String palabra = vista.txtBuscar.getText();
            ListaDoble<Servicios> p = caja.bucarServicio(palabra);
            vista.setListaServicios(p);
            vista.mostrarTablaServicios(p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Servicio no encontrado\n");
        }

    }
    
    private void DameVuelto() {
        try {
            Float pago = Float.parseFloat(vista.txtPago.getText());
            Float monto = Float.parseFloat(vista.txtMonto.getText());
            Float vuelto = pago - monto;

            vista.txtVuelto.setText(String.valueOf(vuelto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Escriba el monto abonado\n");
        }

    }
    
    
      private void formNuevoCliente() {
          try {
              ListaDoble<Servicios> listaSeleccionGeneral = vista.getListaSeleccionGeneral();
              vista.txtMonto.setText("");
              vista.txtPago.setText("");
              vista.txtVuelto.setText("");
              vista.txtCodigo.setText("");
              listaSeleccionGeneral.limpiarLista();

              vista.mostrarTablaSeleccion(listaSeleccionGeneral);

          } catch (Exception e) {
              System.out.println(e.getMessage());
              JOptionPane.showMessageDialog(null, "Elija una opción\n");
          }

    }
    
      
      private void formRegistrar() {
          try {
              ListaDoble<Paciente> listaPacientes = vista.getListaPacientes();
              ListaDoble<Monto> listaMonto = vista.getListaMonto();
              Cajero caja = vista.getCaja();
              GregorianCalendar d = new GregorianCalendar();

              int anio = d.get(Calendar.YEAR);
              int mes = d.get(Calendar.MONTH) + 1;
              int dia = d.get(Calendar.DAY_OF_MONTH);
              LocalDate fecha = LocalDate.of(anio, mes, dia);
              // txt de entrada
              String codigo = vista.txtCodigo.getText();
              Float pago = Float.parseFloat(vista.txtPago.getText());
              Float monto = Float.parseFloat(vista.txtMonto.getText());
              Float vuelto = Float.parseFloat(vista.txtVuelto.getText());
              boolean comprobar = false;

              Iterator<Paciente> iterador = listaPacientes.getDescendingIterator();

              while (iterador.hasNext()) {
                  Paciente pro = iterador.next();

                  if (pro.getCodigo().equalsIgnoreCase(codigo)) {
                      comprobar = true;
                      //vista.thisFrameTriaje.getListaPacientes().insertarAlFinal(pro);
                      //Te envia el codigo ;

                  }
              }

              if (comprobar) {
                  Monto reg = new Monto(monto, pago, vuelto, fecha);

                  caja.agregarMonto(reg);
                  vista.mostrarTablaRegistro(listaMonto, listaPacientes);

                  // para mostar monto de salida
                  Iterator<Monto> it = listaMonto.getDescendingIterator();
                  Float sumaMontoEntrada = 0F;
                  Float sumaMontoSalida = 0F;
                  Float sumaMontoActual = 0F;

                  while (it.hasNext()) {
                      Monto pro = it.next();
                      sumaMontoEntrada = sumaMontoEntrada + pro.getPago();
                      sumaMontoSalida = sumaMontoSalida + pro.getVuelto();
                      sumaMontoActual = sumaMontoActual + pro.getMonto();
                  }
                  vista.txtEntrada.setText(String.valueOf(sumaMontoEntrada));
                  vista.txtSalida.setText(String.valueOf(sumaMontoSalida));
                  vista.txtMontoActual.setText(String.valueOf(sumaMontoActual));
                  /**
                   * COMPROBAR
                   */

//            this.thisFrameTriaje.setVisible(true);
//            this.thisFrameTriaje.mostrarTabla();
              } 

          } catch (Exception e) {
              System.out.println(e.getMessage());
              JOptionPane.showMessageDialog(null, "Codigo no registrado\n");
          }

    }
      private void formOrdenarPrecio() {
        try {
            ListaDoble<Servicios> listaServicios = vista.getListaServicios();
            Cajero caja = vista.getCaja();
            listaServicios = caja.ordenarPrecios();
            vista.setListaServicios(listaServicios);
            vista.mostrarTablaServicios(listaServicios);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Elija una opción\n");
        }

    }
    
      private void formOrdenarConsulta() {
        try {
            ListaDoble<Servicios> listaConsultaServicios = vista.getListaConsultaServicios();
            Cajero caja = vista.getCaja();
            
            if (vista.rbtnConsulta.isSelected()) {
            listaConsultaServicios = caja.ordenarporConsultas(); 
            vista.setListaServicios(listaConsultaServicios);
            vista.mostrarTablaServicios(listaConsultaServicios);
        }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Elija una opción\n");
        }

    }
      private void formOrdenarLaboratorio() {
        try {
            Cajero caja = vista.getCaja();
            ListaDoble<Servicios> listaLaboratorioServicios = vista.getListaLaboratorioServicios();
            if (vista.rbtnLaboratorio.isSelected()) {
                listaLaboratorioServicios = caja.ordenarporLaboratorio();
                vista.setListaServicios(listaLaboratorioServicios);
                vista.mostrarTablaServicios(listaLaboratorioServicios);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Elija una opción\n");
        }
    }
}
