
package test;

import controlador.medicoEspecialista.MedicoEspecialistaController;
import gui.medicoEspecialista.FrameMedicoEspecialista;
import java.time.LocalDate;
import model.empleado.MedicoEspecialista;
import model.paciente.Paciente;

public class MainMedicoEspecialista {
    public static void main(String[] args) {
        // TODO code application logic here
         MedicoEspecialista medicoEspecialista = new MedicoEspecialista("Cardiólogo","Colegiatura","1234", "contraseña", null, 21, "Carlos", "Sanchez", 9098, true, 32, 9563212, 6411452, "carlos@gmail.com", 0);
//
         Paciente p1 = new Paciente(0, "Luis", "Luis", 1111, true, 21, 98766, 64564, "", 2, "A", "No hay","A04");
         Paciente p2 = new Paciente(0, "Yauri", "Yauri", 2222, true, 21, 98766, 64564, "", 2, "A", "No hay","A05");
         Paciente p3 = new Paciente(0, "Miriam", "Miriam", 3333, true, 21, 98766, 64564, "", 2, "A", "No hay","A06");
         Paciente p4 = new Paciente(0, "Mizu", "Mizu", 4444, true, 21, 98766, 64564, "", 2, "A", "No hay","A07");
         Paciente p5 = new Paciente(0, "Luis", "Luis", 1111, true, 21, 98766, 64564, "", 2, "A", "No hay","A09");
         Paciente p6 = new Paciente(0, "LuisRoberto", "LuisRoberto", 6666, true, 21, 98766, 64564, "", 2, "A", "No hay","A09");
         Paciente p7 = new Paciente(0, "LuisJose", "LuisJose", 5555, true, 21, 98766, 64564, "", 2, "A", "No hay","A08");
         
        LocalDate l = LocalDate.now();
        System.out.println("FECHA: " + l.toString());
          
        medicoEspecialista.agregarPaciente(p1);
        medicoEspecialista.agregarPaciente(p2);
        medicoEspecialista.agregarPaciente(p3);
        medicoEspecialista.agregarPaciente(p4);
        medicoEspecialista.agregarPaciente(p5);
        medicoEspecialista.agregarPaciente(p6);
        medicoEspecialista.agregarPaciente(p7);
        
        
        FrameMedicoEspecialista fm = new FrameMedicoEspecialista(medicoEspecialista);
        MedicoEspecialistaController mec = new MedicoEspecialistaController(fm);
        mec.index();
        
        
    }
    
}
