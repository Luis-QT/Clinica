
package dao.contabilidad;

import estructura.ListaDoble;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import model.empleado.Servicios;

public class Archivo {
    public static ListaDoble leerListaClientes() throws FileNotFoundException {

        ListaDoble<Servicios> lista = new ListaDoble<>();

        final String nom = "Servicios.txt";
        File f = new File(nom);
        try {
            Scanner entrada = new Scanner(f);
            while (entrada.hasNext()) {
                String palabra = entrada.nextLine();
                String[] alumno = palabra.split("::");
                Servicios c = new Servicios(alumno[0], Float.parseFloat(alumno[1]),
                        Boolean.parseBoolean(alumno[2])
                        
                );
                lista.insertarAlFinal(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        if (lista == null) {
            return null;
        }
        return lista;
    }
}
