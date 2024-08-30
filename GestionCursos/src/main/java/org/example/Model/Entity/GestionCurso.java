package org.example.Model.Entity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.Exceptions.SoloNumerosException;
import org.example.Interfaces.RepositoryGeneric;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class GestionCurso implements RepositoryGeneric<String, Curso> {
    private static final String FILE_PATH = "src/main/resources/cursos.json";
    private Gson gson = new Gson();

    private Map<String, Curso> cursosActivos;

    public GestionCurso() {
        this.loadCursos();
    }

    ///GETTER Y SETTER:
    public Map<String, Curso> getCursosActivos() {
        return cursosActivos;
    }

    public void setCursosActivos(Map<String, Curso> cursosActivos) {
        this.cursosActivos = cursosActivos;
    }


    @Override
    public void registrar(Curso obj) {
        this.cursosActivos.put(obj.getCodigo(), obj);
        this.saveCursos();
    }

    @Override
    public Curso consultar(String id) throws SoloNumerosException {
        for (Map.Entry<String, Curso> entry : cursosActivos.entrySet()){

            if (!id.matches("\\d+")){
                throw new SoloNumerosException("Ingrese solo numeros... Intentelo nuevamente!\n");
            }

            else if (entry.getValue().getCodigo().equals(id)){
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void actualizar(String id, Curso obj) {
        try{
            Curso cursoAactualizar = this.consultar(id);

            if (cursoAactualizar != null){

                Curso cursoActualizado = obj;
                cursoActualizado.setEstudiantes(cursoAactualizar.getEstudiantes());

                this.cursosActivos.put(cursoAactualizar.getCodigo(), obj);
                System.out.println("Curso ACTUALIZADO con Exito!\n");

            }else {
                System.out.println("El codigo ingresado NO existe...\n");
            }

        }catch(SoloNumerosException soloNumerosException){
            System.out.println(soloNumerosException.getMessage());
        }
    }

    @Override
    public void eliminar(String id) {
        try{

            Curso cursoAeliminar = this.consultar(id);

            if (cursoAeliminar != null){
                this.cursosActivos.remove(cursoAeliminar.getCodigo());
                System.out.println("Curso ELIMINADO con exito!\n");
            }else {
                System.out.println("El codigo ingresado NO existe...\n");
            }

        }catch (SoloNumerosException soloNumerosException){
            System.out.println(soloNumerosException.getMessage());
        }
    }

    public void loadCursos(){
        try (Reader reader = new FileReader(FILE_PATH)){
            Type tipo = new TypeToken<Map<String, Curso>>() {}.getType();
            cursosActivos = gson.fromJson(reader, tipo);

            if(cursosActivos == null){
                cursosActivos = new HashMap<>();
            }

        }catch(FileNotFoundException e){
            cursosActivos = new HashMap<>();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void saveCursos(){
        try(Writer writer = new FileWriter(FILE_PATH)){
            gson.toJson(cursosActivos, writer);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
