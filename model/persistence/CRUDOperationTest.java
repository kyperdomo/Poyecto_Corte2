package co.edu.unbosque.model.persistence;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.persistence.CRUDOperation;

public class CRUDOperationTest implements CRUDOperation<String> {

    private String[] data;
    private String result;

    @Before
    public void setUp() {
        // Inicializar datos de prueba
        data = new String[] { "User1", "User2", "User3" };
        result = "";
    }

    @Override
    public void create(String... args) {
        // Simular la operación de creación
        result = "Create: " + String.join(", ", args);
    }

    @Override
    public String readOnly(int index) {
        // Simular la operación de lectura
        if (index >= 0 && index < data.length) {
            result = "Read: " + data[index];
        } else {
            result = "User not found";
        }
        return result;
    }

    @Override
    public String readAll() {
        // Simular la operación de lectura de todos los usuarios
        result = "Read All: " + String.join(", ", data);
        return result;
    }

    @Override
    public void loading() {
        // Simular la operación de carga de datos
        // No es necesario implementar para la prueba de la interfaz
    }

    @Override
    public int update(int index, String... args) {
        // Simular la operación de actualización
        if (index >= 0 && index < data.length) {
            data[index] = args[0];
            result = "Update: " + data[index];
            return 0; // Éxito
        } else {
            result = "User not found";
            return 1; // Error
        }
    }

    @Override
    public int delete(int index) {
        // Simular la operación de eliminación
        if (index >= 0 && index < data.length) {
            result = "Delete: " + data[index];
            // Eliminar el usuario de la matriz
            String[] newData = new String[data.length - 1];
            int newIndex = 0;
            for (int i = 0; i < data.length; i++) {
                if (i != index) {
                    newData[newIndex] = data[i];
                    newIndex++;
                }
            }
            data = newData;
            return 0; // Éxito
        } else {
            result = "User not found";
            return 1; // Error
        }
    }

    @Test
    public void testCRUDOperations() {
        // Prueba de operaciones CRUD simuladas
        create("User4");
        assertEquals("Create: User4", result);

        assertEquals("Read: User1", readOnly(0));
        assertEquals("Read: User2", readOnly(1));
        assertEquals("Read: User3", readOnly(2));
        assertEquals("User not found", readOnly(3));

        assertEquals("Read All: User1, User2, User3", readAll());

        update(1, "UpdatedUser");
        assertEquals("Update: UpdatedUser", result);
        assertEquals("Read: User1", readOnly(0));
        assertEquals("Read: UpdatedUser", readOnly(1));

        delete(2);
        assertEquals("Delete: User3", result);
        assertEquals("Read: User1", readOnly(0));
        assertEquals("User not found", readOnly(2));
    }
}



