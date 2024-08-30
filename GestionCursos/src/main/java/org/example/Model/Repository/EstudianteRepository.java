package org.example.Model.Repository;
import org.example.Interfaces.Repository;


public class EstudianteRepository implements Repository {

    @Override
    public void registrar(Object obj) {

    }

    @Override
    public Object consultar(String id) {
        return null;
    }

    @Override
    public void actualizar(String id, Object obj) {

    }

    @Override
    public void eliminar(String id) {

    }








  /*  public void loadEstudiantes(){
        try (Reader reader = new FileReader(FILE_PATH)){
            Type listType = new TypeToken<ArrayList<Estudiante>>() {}.getType();
            listaEstudiantes = gson.fromJson(reader, listType);

            if(listaEstudiantes == null){
                listaEstudiantes = new ArrayList<>();
            }

        }catch(FileNotFoundException e){
            listaEstudiantes = new ArrayList<>();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void saveEstudiante(){
        try(Writer writer = new FileWriter(FILE_PATH)){
            gson.toJson(listaEstudiantes, writer);

        }catch (IOException e){
            e.printStackTrace();
        }
    }*/




}
