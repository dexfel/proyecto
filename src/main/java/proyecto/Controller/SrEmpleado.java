package gt.edu.umg.desarrollo.proyecto.Controller;

import gt.edu.umg.desarrollo.proyecto.Model.EmpleadoDao;
import gt.edu.umg.desarrollo.proyecto.Model.EmpleadoEntity;
import gt.edu.umg.desarrollo.proyecto.Model.IEmpleadoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SrEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SrEmpleado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>rEmpleado at " + request.getContextPath() + "</h1>");

            EmpleadoEntity empleado = new EmpleadoEntity();
            IEmpleadoDao dao = new EmpleadoDao();

            empleado.setNombre(request.getParameter("txt_nombres"));
            empleado.setDireccion(request.getParameter("txt_direccion"));
            empleado.setTelefono(Integer.valueOf(request.getParameter("txt_telefono")));
            empleado.setFechaNacimiento(request.getParameter("txt_fn"));
            empleado.setDpi(Long.valueOf(request.getParameter("txt_cui")));
            empleado.setIdTipoEmpleado(Integer.valueOf(request.getParameter("drop_puesto")));
            
                  

            //Botno Guardar
            if ("agregar".equals(request.getParameter("btn_agregar"))) {

                int contador = dao.AddEmpleado(empleado);
                
                if (contador > 0) {
                    response.sendRedirect("empleados.jsp");

                } else {
                    out.println("<h1> xxxxxxx No se Ingreso xxxxxxxxxxxx </h1>");
                    out.println("<a href='index.jsp'>Regresar...</a>");
                }
            }
 

            

            out.println(request.getParameter("txt_nombres"));
            out.println(request.getParameter("txt_direccion"));
            out.println(Integer.valueOf(request.getParameter("txt_telefono")));
            out.println(request.getParameter("txt_fn"));
            out.println(Long.valueOf(request.getParameter("txt_cui")));
            out.println(Integer.valueOf(request.getParameter("drop_puesto")));

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
