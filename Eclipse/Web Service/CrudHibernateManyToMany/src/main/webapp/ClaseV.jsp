<!-- JSP (Java Server Page): Poder hacer peticiones hacia un servidor desde html, es decir, meter código java-->
<!-- ASP para C# -->
<html>

<%@page import = 'java.util.*' %>
<%@page import = 'com.mx.entidad.Clase' %>
<%@page import = 'com.mx.dao.ClaseDao' %>

<body>
<h2>Gestion Alumno</h2>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%
	ClaseDao dao = new ClaseDao();
	List<Clase> lista = new ArrayList<Clase>();
%>

<div class="span3">
    <form action = "ClaseCtrl" method = "POST">
    <label>Id</label>
    <input type="text" name="id" id="id" class="span3">
    <label>Nombre</label>
    <input type="text" name="nombre" id="nombre" class="span3">
    <label>ID Alumno</label>
    <input type="text" name="id_alumno" id="id_alumno" class="span3">
    <label>ID Profesor</label>
    <input type="text" name="id_profesor" id="id_profesor" class="span3">
    
    <input type="submit" value="Guardar" name="btnGuardar" class="btn btn-primary pull-right">
    <input type="submit" value="Eliminar" name="btnEliminar" class="btn btn-primary pull-right">
    <input type="submit" value="Editar" name="btnEditar" class="btn btn-primary pull-right">
    </form>
</div>

<div class="container">
	<div class="row">
		<div class="span5">
            <table class="table table-striped table-condensed">
                  <thead>
                  <tr>
                      <th>ID</th>
                      <th>Nombre</th>
                      <th>Profesor</th>
                      <th>Alumno</th>                                                                 
                  </tr>
              </thead>   
              <tbody>
              <%
              	lista = dao.mostrar();
              	for (Clase c : lista){
              %>
                <tr>
                    <td><%= c.getId() %></td>
                    <td><%= c.getNombre() %></td>
                    <td><%= (c.getProfesor() == null ? "No hay profesores" : c.getProfesor().getNombre())%></td>
                    <td><%= (c.getAlumno() == null ? "No hay alumnos" : c.getAlumno().getNombre()) %></td>
                    <td><span class="label label-success">Active</span>
                    </td>                                       
                </tr>         
                <% } %>                                        
              </tbody>
            </table>
            </div>
	</div>
</div>
</body>
</html>
