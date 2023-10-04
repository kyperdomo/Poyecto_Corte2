package co.edu.unbosque.model.persistence;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.PsychologistDTO;
import co.edu.unbosque.model.persistence.PsychologistDAO;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PsychologistDAOTest {

    private PsychologistDAO psychologistDAO;

    @Before
    public void setUp() {
        // Inicializar la instancia de PsychologistDAO
        psychologistDAO = new PsychologistDAO();
    }

    @Test
    public void testCreateAndReadAll() {
        // Prueba de creación y lectura de todas las personas
        psychologistDAO.create("John Doe", "1990-01-15", "12345", "City", "2000-05-20", "30", "100", "50000");
        psychologistDAO.create("Jane Smith", "1985-03-20", "67890", "Town", "1995-12-10", "25", "90", "60000");
        String allPsychologists = psychologistDAO.readAll();
        assertTrue(allPsychologists.contains("John Doe"));
        assertTrue(allPsychologists.contains("Jane Smith"));
    }

    @Test
    public void testReadOnly() {
        // Prueba de lectura de un psicólogo específico
        psychologistDAO.create("John Doe", "1990-01-15", "12345", "City", "2000-05-20", "30", "100", "50000");
        int psychologistId = 1;
        String psychologistInfo = psychologistDAO.readOnly(psychologistId);
        assertTrue(psychologistInfo.contains("John Doe"));
    }

    @Test
    public void testUpdate() {
        // Prueba de actualización de información de un psicólogo
        psychologistDAO.create("John Doe", "1990-01-15", "12345", "City", "2000-05-20", "30", "100", "50000");
        int psychologistId = 1;
        int result = psychologistDAO.update(psychologistId, "Updated Name", "1980-02-10", "54321", "New City", "1999-08-15", "35", "110", "55000");
        assertEquals(0, result);
        String updatedInfo = psychologistDAO.readOnly(psychologistId);
        assertTrue(updatedInfo.contains("Updated Name"));
        assertTrue(updatedInfo.contains("New City"));
    }

    @Test
    public void testDelete() {
        // Prueba de eliminación de un psicólogo
        psychologistDAO.create("John Doe", "1990-01-15", "12345", "City", "2000-05-20", "30", "100", "50000");
        int psychologistId = 1;
        int result = psychologistDAO.delete(psychologistId);
        assertEquals(0, result);
        String deletedInfo = psychologistDAO.readAll();
        assertFalse(deletedInfo.contains("John Doe"));
    }

    @Test
    public void testReadDate() {
        // Prueba de conversión de fecha
        String dateString = "1990-01-15";
        Date date = psychologistDAO.readDate(dateString);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date);
        assertEquals(dateString, formattedDate);
    }

    @Test
    public void testGetAndSetList() {
        // Prueba de obtención y configuración de la lista de psicólogos
        ArrayList<PsychologistDTO> newList = new ArrayList<>();
        PsychologistDTO psychologist = new PsychologistDTO(1, "John Doe", 12345, new Date(0), "City", new Date(0), 30, 100, 50000);
        newList.add(psychologist);
        psychologistDAO.setList(newList);
        ArrayList<PsychologistDTO> retrievedList = psychologistDAO.getList();
        assertEquals(newList, retrievedList);
    }
}

