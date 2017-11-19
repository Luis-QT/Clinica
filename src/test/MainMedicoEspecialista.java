
package test;

import controlador.medicoEspecialista.MedicoEspecialistaController;
import estructura.ListaDoble;
import gui.medicoEspecialista.FrameMedicoEspecialista;
import java.time.LocalDate;
import model.empleado.MedicoEspecialista;
import model.paciente.Anamnesis;
import model.paciente.DatosMedico;
import model.paciente.Diagnostico;
import model.paciente.ExamenFisicos;
import model.paciente.Paciente;
import model.paciente.Tratamiento;
import model.paciente.TratamientoRea;
import model.paciente.Visita;

public class MainMedicoEspecialista {
    public static void main(String[] args) {
        // TODO code application logic here
         MedicoEspecialista medicoEspecialista = new MedicoEspecialista("Cardiólogo","Colegiatura","1234", "contraseña", null, 21, "Carlos", "Sanchez", 9098, true, 32, 9563212, 6411452, "carlos@gmail.com", 0);
//
         Paciente p1 = new Paciente(0, "Luis", "Luis", 1111, true, 21, 98766, 64564, "", 2, "A", "No hay","A04","Los Olivos","Cristiano",true);
         Paciente p2 = new Paciente(0, "Yauri", "Yauri", 2222, true, 21, 98766, 64564, "", 2, "A", "No hay","A05","Los Olivos","Cristiano",false);
         Paciente p3 = new Paciente(0, "Miriam", "Miriam", 3333, true, 21, 98766, 64564, "", 2, "A", "No hay","A06","Los Olivos","Cristiano",false);
         Paciente p4 = new Paciente(0, "Mizu", "Mizu", 4444, true, 21, 98766, 64564, "", 2, "A", "No hay","A07","Los Olivos","Cristiano",true);
         Paciente p5 = new Paciente(0, "Luis", "Luis", 1111, true, 21, 98766, 64564, "", 2, "A", "No hay","A09","Los Olivos","Cristiano",false);
         Paciente p6 = new Paciente(0, "LuisRoberto", "LuisRoberto", 6666, true, 21, 98766, 64564, "", 2, "A", "No hay","A09","Los Olivos","Cristiano",true);
         Paciente p7 = new Paciente(0, "LuisJose", "LuisJose", 5555, true, 21, 98766, 64564, "", 2, "A", "No hay","A08","Los Olivos","Cristiano",false);
         
        
         
         ListaDoble<Visita> listav1 = new ListaDoble<Visita>();
         listav1.insertarAlFinal(new Visita(LocalDate.of(2004, 10,11),854, new Anamnesis("salud12", "curso1", "enferact1"), new DatosMedico("Sanchez",1), new ExamenFisicos(), new Diagnostico(), new Tratamiento(), new TratamientoRea()));
         listav1.insertarAlFinal(new Visita(LocalDate.of(2005, 12,12),854, new Anamnesis("salud12", "curso1", "enferact1"), new DatosMedico("Sanchez",1), new ExamenFisicos(), new Diagnostico(), new Tratamiento(), new TratamientoRea()));
         listav1.insertarAlFinal(new Visita(LocalDate.of(2006, 9,23),854, new Anamnesis("salud13", "curso1", "enferact1"), new DatosMedico("Sanchez",1), new ExamenFisicos(), new Diagnostico(), new Tratamiento(), new TratamientoRea()));
         listav1.insertarAlFinal(new Visita(LocalDate.of(2007, 10,18),854, new Anamnesis("salud14", "curso1", "enferact1"), new DatosMedico("Sanchez",1), new ExamenFisicos(), new Diagnostico(), new Tratamiento(), new TratamientoRea()));
         
         ListaDoble<Visita> listav2 = new ListaDoble<Visita>();
         listav2.insertarAlFinal(new Visita(LocalDate.of(2010, 10,2),854, new Anamnesis("salud12", "curso1", "enferact1"), new DatosMedico("Juan",2), new ExamenFisicos(), new Diagnostico(), new Tratamiento(), new TratamientoRea()));
         listav2.insertarAlFinal(new Visita(LocalDate.of(2005, 10,2),235, new Anamnesis("salud12", "curso1", "enferact1"), new DatosMedico("Sanchez",1), new ExamenFisicos(), new Diagnostico(), new Tratamiento(), new TratamientoRea()));
         
         ListaDoble<Visita> listav3 = new ListaDoble<Visita>();
         listav3.insertarAlFinal(new Visita(LocalDate.of(2005, 10,2),365, new Anamnesis("salud13", "curso1", "enferact1"), new DatosMedico("Juan",2), new ExamenFisicos(), new Diagnostico(), new Tratamiento(), new TratamientoRea()));
         listav3.insertarAlFinal(new Visita(LocalDate.of(2005, 10,2),788, new Anamnesis("salud14", "curso1", "enferact1"), new DatosMedico("Sanchez",1), new ExamenFisicos(), new Diagnostico(), new Tratamiento(), new TratamientoRea()));
         listav3.insertarAlFinal(new Visita(LocalDate.of(2013, 10,2),854, new Anamnesis("salud12", "curso1", "enferact1"), new DatosMedico("Sanchez",1), new ExamenFisicos(), new Diagnostico(), new Tratamiento(), new TratamientoRea()));
         
         ListaDoble<Visita> listav4 = new ListaDoble<Visita>();
         listav4.insertarAlFinal(new Visita(LocalDate.of(2005, 10,2),235, new Anamnesis("salud12", "curso1", "enferact1"), new DatosMedico("Matino",2), new ExamenFisicos(), new Diagnostico(), new Tratamiento(), new TratamientoRea()));
         listav4.insertarAlFinal(new Visita(LocalDate.of(2005, 10,2),365, new Anamnesis("salud13", "curso1", "enferact1"), new DatosMedico("Sanchez",1), new ExamenFisicos(), new Diagnostico(), new Tratamiento(), new TratamientoRea()));
         listav4.insertarAlFinal(new Visita(LocalDate.of(2005, 10,2),788, new Anamnesis("salud14", "curso1", "enferact1"), new DatosMedico("Sanchez",1), new ExamenFisicos(), new Diagnostico(), new Tratamiento(), new TratamientoRea()));
         
         
         
         p1.getHistorial().setListaVisitas(listav1);
         
         p2.getHistorial().setListaVisitas(listav2);
         p3.getHistorial().setListaVisitas(listav3);
         p4.getHistorial().setListaVisitas(listav4);
         
     
         
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
