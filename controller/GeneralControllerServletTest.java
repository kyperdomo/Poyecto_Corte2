package co.edu.unbosque.controller;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.edu.unbosque.model.persistence.GeneralServicesDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GeneralControllerServletTest {

    @Mock
    private GeneralServicesDAO gDao;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher requestDispatcher;

    private GeneralControllerServlet servlet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        servlet = new GeneralControllerServlet();
        servlet.setGeneralServicesDAO(gDao);
    }

    @Test
    public void testDoPostWithValidCredentials() throws ServletException, IOException {
        when(request.getParameter("username")).thenReturn("validUsername");
        when(request.getParameter("password")).thenReturn("validPassword");
        when(gDao.validate("validUsername", "validPassword")).thenReturn(true);
        when(request.getRequestDispatcher("crudgen.jsp")).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoPostWithInvalidCredentials() throws ServletException, IOException {
        when(request.getParameter("username")).thenReturn("invalidUsername");
        when(request.getParameter("password")).thenReturn("invalidPassword");
        when(gDao.validate("invalidUsername", "invalidPassword")).thenReturn(false);
        when(request.getRequestDispatcher("login-error.jsp")).thenReturn(requestDispatcher);

        servlet.doPost(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoGetCreate() throws ServletException, IOException {
        when(request.getParameter("operation")).thenReturn("create");
        when(request.getRequestDispatcher("creategen.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoGetRead() throws ServletException, IOException {
        when(request.getParameter("operation")).thenReturn("read");
        when(request.getRequestDispatcher("readgen.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoGetUpdate() throws ServletException, IOException {
        when(request.getParameter("operation")).thenReturn("update");
        when(request.getRequestDispatcher("updategen.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDoGetDelete() throws ServletException, IOException {
        when(request.getParameter("operation")).thenReturn("delete");
        when(request.getRequestDispatcher("deletegen.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

  
}







