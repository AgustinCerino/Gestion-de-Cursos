package org.example.Model.Repository;
import org.example.Interfaces.Repository;


public class CursoRepository implements Repository {


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






 /*    private static final String FILE_PATH = "src/main/resources/cursos.json";
    private Gson gson = new Gson();
    private HashSet<Estudiante> estudiantes;

    public void loadEstudiantes() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type setType = new TypeToken<HashSet<Estudiante>>() {}.getType();
            estudiantes = gson.fromJson(reader, setType);

            if (estudiantes == null) {
                estudiantes = new HashSet<>();
            }

        } catch (FileNotFoundException e) {
            estudiantes = new HashSet<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveEstudiantes() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(estudiantes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
