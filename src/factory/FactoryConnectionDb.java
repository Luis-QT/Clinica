/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

/**
 *
 * @author LLLL
 */
public class FactoryConnectionDb {
    
    //tipo de empleado
    //  0 => administrador
    //  1 => medico general
    //  2 => medico especialista
    //  3 => meidico triaje
    //  4 => medico laboratorio
    //  5 => recepcionista
    //  6 => cajero
    //  7 => vigilante
    //  8 => limpieza
    
    public static String[] configMSQLCreate = {
            //Tabla paciente
            "Create TABLE Paciente"
            + "(id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), PRIMARY KEY(id), nombre VARCHAR(20), apellido VARCHAR(20) ,dni INT , "
            + "sexo SMALLINT,edad SMALLINT,telefonoCasa INT,telefonoCelular INT,email VARCHAR(40),softDelete SMALLINT,tipoSangre VARCHAR(40),alergias VARCHAR(40), codigoP VARCHAR(10))",          
        
            //Tabla Historia Clínica
            "Create TABLE HistoriaClinica"
            + "(id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), PRIMARY KEY(id), estadoPapa VARCHAR(20), hosPapa VARCHAR(20) ,muertePapa SMALLINT ,"
            + " estadoMama VARCHAR(20), hosMama VARCHAR(20) , muerteMama SMALLINT, enferTrata VARCHAR(20), hospitalizaciones INT, inmunizacion INT, tipoSangre VARCHAR(5),alergias VARCHAR(20))"         
            + "sexo SMALLINT,edad SMALLINT,telefonoCasa INT,telefonoCelular INT,email VARCHAR(40),softDelete SMALLINT,tipoSangre VARCHAR(40),alergias VARCHAR(40), codigoP VARCHAR(40))",          

            
            "CREATE TABLE Salas (id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), PRIMARY KEY(id),"
            + "nombre VARCHAR(15) , descripcion VARCHAR(150))",
            
            //Tabla Visitas
            
            "Create TABLE Visitas"
            + "(id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), PRIMARY KEY(id),historialID INT, foreign key (historialID) references HistoriaClinica(id), servicio VARCHAR(20), nombreMedico VARCHAR(20), especialidadMedico VARCHAR(30) ,"
            + " diaV INT, mesV INT, anioV INT, motivo VARCHAR(40),curso VARCHAR(40),enferActual VARCHAR(40), cabezaobs VARCHAR(40),cabezaaus VARCHAR(40),cabezaper VARCHAR(40), torzoobs VARCHAR(40)," 
            + " torzoaus VARCHAR(40),torzoper VARCHAR(40),abdomenobs VARCHAR(40),abdomenaus VARCHAR(40),abdomenper VARCHAR(40), espaldaobs VARCHAR(40),espaldaaus VARCHAR(40),espaldaper VARCHAR(40) ,"
            + "extreobs VARCHAR(40),extreaus VARCHAR(40),extreper VARCHAR(40))" ,

            
            //Luis Taquire
            "CREATE TABLE Administrador"
            + "(id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), PRIMARY KEY(id),codigo VARCHAR(100) , nombre VARCHAR(30), apellido VARCHAR(30) ,"
            + "contraseña VARCHAR(35))",
            
            "CREATE TABLE MedicoGeneral"
            + "(id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), PRIMARY KEY(id),codigo VARCHAR(100) , nombre VARCHAR(20), apellido VARCHAR(20) ,dni INT , "
            + "contraseña VARCHAR(35),colegiatura VARCHAR(20),edad SMALLINT,telefonoCasa INT,telefonoCelular INT, sexo SMALLINT,email VARCHAR(40),softDelete SMALLINT)",
            
            "CREATE TABLE MedicoEspecialista"
            + "(id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), PRIMARY KEY(id),especialidad VARCHAR(20),codigo VARCHAR(100) , nombre VARCHAR(20), apellido VARCHAR(20) ,dni INT , "
            + "contraseña VARCHAR(35),colegiatura VARCHAR(20),edad SMALLINT,telefonoCasa INT,telefonoCelular INT, sexo SMALLINT,email VARCHAR(40),softDelete SMALLINT)",
          
            "CREATE TABLE MedicoTriaje"
            + "(id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), PRIMARY KEY(id),codigo VARCHAR(100) , nombre VARCHAR(20), apellido VARCHAR(20) ,dni INT , "
            + "contraseña VARCHAR(35),colegiatura VARCHAR(20),edad SMALLINT,telefonoCasa INT,telefonoCelular INT, sexo SMALLINT,email VARCHAR(40),softDelete SMALLINT)",
            
            "CREATE TABLE Recepcionista"
            + "(id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), PRIMARY KEY(id),codigo VARCHAR(100) , nombre VARCHAR(30), apellido VARCHAR(30) ,dni INT , "
            + "contraseña VARCHAR(35) ,edad SMALLINT,telefonoCasa INT,telefonoCelular INT, sexo SMALLINT,email VARCHAR(40),softDelete SMALLINT)",
            
            "CREATE TABLE Cajero"
            + "(id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), PRIMARY KEY(id),codigo VARCHAR(100) , nombre VARCHAR(30), apellido VARCHAR(30) ,dni INT , "
            + "contraseña VARCHAR(35) ,edad SMALLINT,telefonoCasa INT,telefonoCelular INT, sexo SMALLINT,email VARCHAR(40),softDelete SMALLINT)",

            
           
            "CREATE TABLE Horarios (id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), PRIMARY KEY(id),"
            + " dia VARCHAR(10), horaIni VARCHAR(10), horaFin VARCHAR(10),"
            + "empleadoId INT , tipoEmpleado INT , salaId INT , foreign key (salaId) references Salas(id))",
            
            "CREATE TABLE PlanTratamiento (id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), PRIMARY KEY(id),"
            +"nombre VARCHAR(35), descripcion VARCHAR(60) , precio DOUBLE)",
            
            
            /********* CREAR TABLAS **********/  
            "INSERT INTO Administrador"
            + "(codigo , nombre, apellido, contraseña) VALUES"
            + "('admin','Luis Antonio','Quispe Taquire','1234')",
            
            "INSERT INTO Recepcionista"

            + "(codigo , nombre , apellido  ,dni  , contraseña, edad, telefonoCasa, telefonoCelular, sexo, email,softDelete ) VALUES "
            + "('r00000','LuisDavid','YauriMartinez',987654321, 'contraseña',21,9541236,954123685,1,'Luis@gmail.com',0)",
            
            "INSERT INTO MedicoGeneral "
            + "(codigo,nombre,apellido,dni,contraseña,colegiatura,edad,telefonoCasa,telefonoCelular,sexo,email,softDelete) VALUES "
            + "('medico1','Ximena','Politi',56487752,'1234-2','cole1',20,5284422,973849441,0,'a@a',0)",
            
           
            /*"Create TABLE Paciente"
            + ", nombre VARCHAR(20), apellido VARCHAR(20) ,dni INT , "
            + "sexo SMALLINT,edad SMALLINT,telefonoCasa INT,telefonoCelular INT
            ,email VARCHAR(40),softDelete SMALLINT,tipoSangre VARCHAR(40),alergias VARCHAR(40), codigoP VARCHAR(10))",          
        */
             "INSERT INTO Paciente" 
            + "(nombre,apellido, sexo ,edad,telefonoCasa,telefonoCelular,email,softDelete,tipoSangre,alergias, codigoP) VALUES "
            + "('Paciente01','Apellido01',0,23,123487548,35236232,'paciente@gmail',0,'A', 'alergia al polvo','A03')",
            
            "INSERT INTO MedicoGeneral "
            + "(codigo,nombre,apellido,dni,contraseña,colegiatura,edad,telefonoCasa,telefonoCelular,sexo,email,softDelete) VALUES "
            + "('medico2','Luis','Yauri',11111111,'1234-3','cole1',10,5284422,973555441,1,'a@a',0)",
            
            "INSERT INTO MedicoEspecialista"
            + "(especialidad,codigo,nombre,apellido,dni,contraseña,colegiatura,edad,telefonoCasa,telefonoCelular,sexo,email,softDelete) VALUES "
            + "('Neurocirujano','medico3','Ximena','Politi',56487752,'1234-2','cole1',20,5284422,973849441,0,'a@a',0)",
            
            "INSERT INTO MedicoEspecialista "
            + "(especialidad,codigo,nombre,apellido,dni,contraseña,colegiatura,edad,telefonoCasa,telefonoCelular,sexo,email,softDelete) VALUES "
            + "('Odontologo','medico4','Luis','Yauri',11111111,'1234-3','cole1',10,5284422,973555441,1,'a@a',0)",
            
            "INSERT INTO MedicoTriaje"
            + "(codigo, nombre, apellido ,dni ,contraseña,colegiatura ,edad, telefonoCasa, telefonoCelular, sexo, email, softDelete) VALUES "
            + "('medicoTriaje','MedicTriaje','Martin Lopez',11222111,'contraseña','cole2Triaje',55,5284422,973555441,1,'a@a',0)",
            
            "INSERT INTO Cajero"
            + "(codigo , nombre , apellido ,dni ,contraseña, edad, telefonoCasa, telefonoCelular, sexo, email, softDelete) VALUES "
            + "('cajero','Cajero02','ApellidoCajero',11999981,'contraseña',30,5284322,973566441,1,'a@a',0)",
            
            "INSERT INTO Salas "
            + "(nombre,descripcion) VALUES"
            + "('Aula Magna' , 'Hay 2 mesas y 4 estetoscopios')",
            
            "INSERT INTO Salas"
            + "(nombre,descripcion) VALUES"
            + "('Aula 105' , '2 camillas')",
            
            "INSERT INTO Horarios "
            + "(dia,horaIni,horaFin,empleadoId,tipoEmpleado,salaId) VALUES"
            + "('lunes' , '12:30', '20:00' ,1,1,1)",
            
            "INSERT INTO Horarios "
            + "(dia,horaIni,horaFin,empleadoId,tipoEmpleado,salaId) VALUES"
            + "('jueves' , '8:00', '15:00' ,1,1,2)",
            
            "INSERT INTO Horarios"
            + "(dia,horaIni,horaFin,empleadoId,tipoEmpleado,salaId) VALUES"
            + "('lunes' , '8:30', '21:00' ,2,1,2)",
            
            "INSERT INTO Horarios "
            + "(dia,horaIni,horaFin,empleadoId,tipoEmpleado,salaId) VALUES"
            + "('lunes' , '12:30', '20:00' ,1,2,1)",
            
            "INSERT INTO Horarios "
            + "(dia,horaIni,horaFin,empleadoId,tipoEmpleado,salaId) VALUES"
            + "('jueves' , '8:00', '15:00' ,1,2,2)",
            
            "INSERT INTO PlanTratamiento"
            +"(nombre,descripcion,precio) VALUES "
            + "('Cirugia Plastica','Consiste en un procedimiento de operaciones ....',700.80)"
            
            
            
    };
    
    public static ConnectionDb open(){
        return new MySQLConnectionFactory();
    }
    public static ConnectionDb create(){
        return new MySQLConnectionFactory(configMSQLCreate);
    }
}
