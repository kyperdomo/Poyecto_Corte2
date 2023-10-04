package co.edu.unbosque.model.persistence;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.AlcoholicDTO;
import co.edu.unbosque.model.persistence.AlcoholicDAO;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class AlcoholicDAOTest {

    private AlcoholicDAO alcoholicDAO;

    @Before
    public void setUp() {
        alcoholicDAO = new AlcoholicDAO();
    }

    @Test
    public void testCreate() {
        // Crear un registro de un alcohólico en la base de datos 
        // Luego, cargar la lista de alcohólicos
        alcoholicDAO.loading();

        // Verificar si el alcohólico creado se encuentra en la lista
        ArrayList<AlcoholicDTO> list = alcoholicDAO.getList();
        boolean found = false;
        for (AlcoholicDTO alcoholic : list) {
            if (alcoholic.getName().equals("NombreDelAlcoholico")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testUpdate() {
        // Crear un alcohólico en la base de datos
        // Luego, cargar la lista de alcohólicos
        alcoholicDAO.loading();

        // Encontrar el ID del alcohólico que se creó
        int idToUpdate = -1;
        ArrayList<AlcoholicDTO> list = alcoholicDAO.getList();
        for (AlcoholicDTO alcoholic : list) {
            if (alcoholic.getName().equals("NombreDelAlcoholico")) {
                idToUpdate = alcoholic.getId();
                break;
            }
        }

        // Actualizar el alcohólico
        int result = alcoholicDAO.update(idToUpdate, "NuevoNombre", "2000-01-01", "123456", "NuevaCiudad", "5", "NuevoApodo");

        // Verificar si la actualización fue exitosa 
        assertEquals(0, result);

        // Cargar la lista actualizada de alcohólicos
        alcoholicDAO.loading();

        // Verificar si el alcohólico actualizado se encuentra en la lista
        list = alcoholicDAO.getList();
        boolean found = false;
        for (AlcoholicDTO alcoholic : list) {
            if (alcoholic.getId() == idToUpdate && alcoholic.getName().equals("NuevoNombre")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testDelete() {
        // Crear un alcohólico en la base de datos
        // Luego, cargar la lista de alcohólicos
        alcoholicDAO.loading();

        // Encontrar el ID del alcohólico que se creó
        int idToDelete = -1;
        ArrayList<AlcoholicDTO> list = alcoholicDAO.getList();
        for (AlcoholicDTO alcoholic : list) {
            if (alcoholic.getName().equals("NombreDelAlcoholico")) {
                idToDelete = alcoholic.getId();
                break;
            }
        }

        // Eliminar el alcohólico
        int result = alcoholicDAO.delete(idToDelete);

        // Verificar si la eliminación fue exitosa 
        assertEquals(0, result);

        // Cargar la lista actualizada de alcohólicos
        alcoholicDAO.loading();

        // Verificar si el alcohólico eliminado no se encuentra en la lista
        list = alcoholicDAO.getList();
        boolean found = false;
        for (AlcoholicDTO alcoholic : list) {
            if (alcoholic.getId() == idToDelete) {
                found = true;
                break;
            }
        }
        assertFalse(found);
    }


}
