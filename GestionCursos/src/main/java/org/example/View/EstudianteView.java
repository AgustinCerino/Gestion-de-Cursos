package org.example.View;

import org.example.Exceptions.CampoVacioException;
import org.example.Model.Entity.Curso;
import org.example.Model.Entity.Estudiante;

import java.util.Scanner;

public class EstudianteView {

    Scanner scanner = new Scanner(System.in);
    public void mostrarEstudiante(Estudiante unEstudiante){
        System.out.println("--------------------------");
        System.out.println("ID Estudiante: " + unEstudiante.getId());
        System.out.println("Nombre: " + unEstudiante.getNombre());
        System.out.println("Email: " + unEstudiante.getEmail());
        System.out.println("--------------------------");
    }

    public Estudiante cargarEstudianteManual() throws CampoVacioException {
        System.out.println("--------CREACION DE ESTUDIANTE--------");

        System.out.println("Ingrese el Nombre del Estudiante: ");
        String nombre = scanner.nextLine();
        if (nombre.isEmpty()){
            throw new CampoVacioException("Este campo no puede estar vacio...");
        }

        System.out.println("Ingrese el Email del Estudiante: ");
        String email = scanner.nextLine();
        if (email.isEmpty()){
            throw new CampoVacioException("Este campo no puede estar vacio...");
        }


        Estudiante nuevoEstudiante = new Estudiante(nombre, email);

        return nuevoEstudiante;
    }
}
