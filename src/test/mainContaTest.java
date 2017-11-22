
package test;

import controlador.contabilidad.ContabilidadController;
import controlador.triaje.PMedicoTriajeController;
import gui.contabilidad.FrameContabilidad;
import gui.triaje.FrameTriaje;
import java.time.LocalDate;
import model.empleado.Cajero;
import model.empleado.MedicoTriaje;
import model.empleado.Servicios;
import model.paciente.Paciente;


public class mainContaTest {
    
    public static void main(String[] args) {
        // TODO code application logic here
         Cajero caja = new Cajero("1234", "contraseña", null, 21, "Carlos", "Sanchez", 9098, true, 32, 9563212, 6411452, "carlos@gmail.com", 0);
        
           Paciente p1 = new Paciente(0, "Luis", "Luis", 1111, true, 21, 98766, 64564, "", 2, "A", "No hay","A02");
         Paciente p2 = new Paciente(0, "Yauri", "Yauri", 2222, true, 21, 98766, 64564, "", 2, "A", "No hay","A02");
         Paciente p3 = new Paciente(0, "Miriam", "Miriam", 3333, true, 21, 98766, 64564, "", 2, "A", "No hay","A02");
         Paciente p4 = new Paciente(0, "Mizu", "Mizu", 4444, true, 21, 98766, 64564, "", 2, "A", "No hay","A02");
         Paciente p5 = new Paciente(0, "Luis", "Luis", 1111, true, 21, 98766, 64564, "", 2, "A", "No hay","A02");
         Paciente p6 = new Paciente(0, "LuisRoberto", "LuisRoberto", 6666, true, 21, 98766, 64564, "", 2, "A", "No hay","A02");
         Paciente p7 = new Paciente(0, "LuisJose", "LuisJose", 5555, true, 21, 98766, 64564, "", 2, "A", "No hay","A02");
//         
//         
//        Servicios s1 = new Servicios("sangre", 230F, false);
//        Servicios s2 = new Servicios("glusoca", 250F, false);
//        Servicios s3 = new Servicios("cardiologo", 10F, true);
//        Servicios s4 = new Servicios("neurologo", 30F, true);
//        Servicios s5 = new Servicios("medico general", 5F, true);
//  
        
        LocalDate l = LocalDate.now();
        System.out.println("FECHA: " + l.toString());
          
        caja.agregarPaciente(p1);
        caja.agregarPaciente(p2);
        caja.agregarPaciente(p3);
        caja.agregarPaciente(p4);
        caja.agregarPaciente(p5);
        caja.agregarPaciente(p6);
        caja.agregarPaciente(p7);
        
//        caja.agregarServicios(s1);
//        caja.agregarServicios(s2);
//        caja.agregarServicios(s3);
//        caja.agregarServicios(s4);
//        caja.agregarServicios(s5);
//        
//        
   
        FrameContabilidad fm = new FrameContabilidad(caja);
        ContabilidadController mec = new ContabilidadController(fm);
        mec.index();
        
//        
//        MedicoTriaje triaje = new MedicoTriaje("triaje", "5694", "contraseña",null, 13, "Mónica","Blanco", 77777777, false, 42, 555555,999999, "mb@ail.com", 0);        
//        FrameTriaje ft = new FrameTriaje(triaje);
//        PMedicoTriajeController c = new PMedicoTriajeController(ft);
//        c.index();
        
               


    }
    
}
