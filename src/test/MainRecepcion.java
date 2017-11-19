/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import model.empleado.Recepcionista;
import model.paciente.Paciente;
import controlador.recepcion.AreaPacientesController;
import gui.recepcion.RecepcionAreaPacientes;

/**
 *
 * @author Luis
 */
public class MainRecepcion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Recepcionista recepcionista = new Recepcionista("123", "345", null, 12, "Jose", "Martines", 98877, true, 35, 234324, 123, "@gamil.com", 1);
 
        Paciente p1 = new Paciente(0, "Luis", "Luis", 1111, true, 21, 98766, 64564, "", 2, "A", "No hay","A04","Los Olivos","Cristiano",false);
         Paciente p2 = new Paciente(0, "Yauri", "Yauri", 2222, true, 21, 98766, 64564, "", 2, "A", "No hay","A05","Los Olivos","Cristiano",true);
         Paciente p3 = new Paciente(0, "Miriam", "Miriam", 3333, true, 21, 98766, 64564, "", 2, "A", "No hay","A06","Los Olivos","Cristiano", false);
         Paciente p4 = new Paciente(0, "Mizu", "Mizu", 4444, true, 21, 98766, 64564, "", 2, "A", "No hay","A07","Los Olivos","Cristiano", true);
         Paciente p5 = new Paciente(0, "Luis", "Luis", 1111, true, 21, 98766, 64564, "", 2, "A", "No hay","A09","Los Olivos","Cristiano", true);
         Paciente p6 = new Paciente(0, "LuisRoberto", "LuisRoberto", 6666, true, 21, 98766, 64564, "", 2, "A", "No hay","A09","Los Olivos","Cristiano", false);
         
         recepcionista.insertarPAciente(p1);
         recepcionista.insertarPAciente(p2);
         recepcionista.insertarPAciente(p3);
         recepcionista.insertarPAciente(p4);
         recepcionista.insertarPAciente(p5);
         
         
        
    }
    
}
