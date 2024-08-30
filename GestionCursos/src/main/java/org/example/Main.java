package org.example;

import org.example.Controller.GestionCursoController;
import org.example.Model.Entity.GestionCurso;
import org.example.View.CursoView;
import org.example.View.EstudianteView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GestionCurso gestionCurso = new GestionCurso();
        EstudianteView estudianteView = new EstudianteView();
        CursoView cursoView = new CursoView();

        GestionCursoController gestionCursoController = new GestionCursoController(gestionCurso, cursoView, estudianteView);

        Scanner scanner = new Scanner(System.in);


        int op = -1;
        do {
            System.out.println("1- Crear nuevo Curso Manual");
            System.out.println("2- Mostrar Cursos Activos");
            System.out.println("3- Buscar un Curso Activo");
            System.out.println("4- Eliminar un Curso");
            System.out.println("5- Actualizar Informacion del Curso");
            System.out.println("6- Cargar Nuevo Estudiante a Curso");
            System.out.println("7- Sign out");

            System.out.println("Ingrese una opción");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    gestionCursoController.creacionCursoManual();
                    break;
                case 2:
                    gestionCursoController.mostrarMapCursos();
                    break;
                case 3:
                    gestionCursoController.buscarCurso();
                    break;
                case 4:
                    gestionCursoController.eliminarCurso();
                    break;
                case 5:
                    gestionCursoController.actualizarCurso();
                    break;
                case 6:
                    gestionCursoController.estudianteAcurso();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (op != 7);
        System.out.println("Programa finalizado");
        scanner.close();




    }
}