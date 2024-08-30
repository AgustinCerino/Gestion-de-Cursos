package org.example.View;

import org.example.Exceptions.CampoVacioException;
import org.example.Model.Entity.Curso;

import java.util.Scanner;

public class CursoView {

    EstudianteView estudianteView = new EstudianteView();

    Scanner scanner = new Scanner(System.in);
    public void mostrarCurso(Curso unCurso){
        System.out.println("\n\n-----------CURSO-----------");
        System.out.println("Codigo: " + unCurso.getCodigo());
        System.out.println("Nombre: " + unCurso.getNombre());
        System.out.println("Estudiantes Acreditados en Este Curso:");
    }

    public Curso cargarCursoManual() throws CampoVacioException {
        System.out.println("--------CREACION DE CURSO--------");

        System.out.println("Ingrese el Codigo del Curso: ");
        String codigo = scanner.nextLine();
        if (codigo.isEmpty()){
            throw new CampoVacioException("Este campo no puede estar vacio...");
        }

        System.out.println("Ingrese el Nombre del Curso: ");
        String nombre = scanner.nextLine();
        if (nombre.isEmpty()){
            throw new CampoVacioException("Este campo no puede estar vacio...");
        }


        Curso nuevoCurso = new Curso(codigo, nombre);

        return nuevoCurso;
    }

    public String pedirCodigoCurso(){
        System.out.println("Ingrese el codigo del Curso buscado: ");
        String codigo = scanner.nextLine();

        return codigo;
    }


}
