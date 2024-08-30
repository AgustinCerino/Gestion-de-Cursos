package org.example.Controller;

import org.example.Exceptions.CampoVacioException;
import org.example.Exceptions.SoloNumerosException;
import org.example.Model.Entity.Curso;
import org.example.Model.Entity.Estudiante;
import org.example.Model.Entity.GestionCurso;
import org.example.View.CursoView;
import org.example.View.EstudianteView;

import java.util.*;

public class GestionCursoController {

    GestionCurso gestionCurso;
    CursoView cursoView;
    EstudianteView estudianteView;

    public GestionCursoController(GestionCurso gestionCurso, CursoView cursoView, EstudianteView estudianteView){
        this.gestionCurso = new GestionCurso();
        this.cursoView = new CursoView();
        this.estudianteView = new EstudianteView();
    }


    Scanner scanner = new Scanner(System.in);


    public void creacionCursoManual() {

        boolean creado = false;
        int op = 1;

        while(!creado && op !=2) {
            try {
                Curso nuevoCurso = cursoView.cargarCursoManual();

                Set<Estudiante> estudianteSet = new HashSet<>();
                estudianteSet.add(estudianteView.cargarEstudianteManual());
                nuevoCurso.setEstudiantes(estudianteSet);

                gestionCurso.registrar(nuevoCurso);

                System.out.println("Nuevo Curso y Estudiantes creados con exito!\n");
                creado = true;

            } catch (CampoVacioException e) {
                System.out.println(e.getMessage());
                System.out.println("-Ingrese 1 si desea intentarlo nuevamnete...\n-Ingrese 2 si desea cancelar la operacion...");
                op = scanner.nextInt();
                scanner.nextLine();
            }
        }
    }

    public void mostrarMapCursos(){
        Map<String, Curso> cursosActivos = gestionCurso.getCursosActivos();

        for (Map.Entry<String, Curso> entry : cursosActivos.entrySet()) {
            cursoView.mostrarCurso(entry.getValue());
            for (Estudiante unEstudiante: entry.getValue().getEstudiantes()){
                estudianteView.mostrarEstudiante(unEstudiante);
            }
        }
    }

    public void buscarCurso(){
        try{
            String codigo = cursoView.pedirCodigoCurso();
            Curso cursoEncontrado = (Curso) gestionCurso.consultar(codigo);

                if (cursoEncontrado != null) {
                    cursoView.mostrarCurso(cursoEncontrado);
                    for (Estudiante unEstudiante : cursoEncontrado.getEstudiantes()) {
                        estudianteView.mostrarEstudiante(unEstudiante);
                    }
                }else {
                    System.out.println("El codigo ingresado NO existe...\n");
                }

        }catch (SoloNumerosException soloNumerosException){
            System.out.println(soloNumerosException.getMessage());
        }
    }

    public void eliminarCurso(){

        String codigo = cursoView.pedirCodigoCurso();
        gestionCurso.eliminar(codigo);

        gestionCurso.saveCursos();

    }

    public void actualizarCurso(){
        try {

            String codigo = cursoView.pedirCodigoCurso();
            Curso cursoActualizado = cursoView.cargarCursoManual();
            gestionCurso.actualizar(codigo, cursoActualizado);

            gestionCurso.saveCursos();

        }catch (CampoVacioException campoVacioException){
            System.out.println(campoVacioException.getMessage());
        }
    }

    public void estudianteAcurso(){

        try {
            String codigo = cursoView.pedirCodigoCurso();
            Curso cursoEncontrado = (Curso) gestionCurso.consultar(codigo);

            if (cursoEncontrado != null){

                cursoEncontrado.getEstudiantes().add(estudianteView.cargarEstudianteManual());

                gestionCurso.saveCursos();

                System.out.println("Estudiante CREADO con Exito!\n");
            }else{
                System.out.println("El codigo ingresado NO existe...\n");
            }

        }catch(CampoVacioException campoVacioException){
            System.out.println(campoVacioException.getMessage());

        }catch(SoloNumerosException soloNumerosException){
            System.out.println(soloNumerosException.getMessage());
        }
    }




}
