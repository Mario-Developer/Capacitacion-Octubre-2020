<!-- JSP (Java Server Page): Poder hacer peticiones hacia un servidor desde html, es decir, meter código java-->
<!-- ASP para C# -->
<html>

<%@page import = 'java.util.*' %>
<%@page import = 'com.mx.entidad.Profesor' %>
<%@page import = 'com.mx.dao.ProfesorDao' %>

<body>
<h2>Gestion Alumno</h2>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%
	ProfesorDao dao = new ProfesorDao();
	List<Profesor> lista = new ArrayList<Profesor>();
%>

<div class="span3">
    <form action = "ProfesorCtrl" method = "POST">
    <label>Id</label>
    <input type="text" name="id" id="id" class="span3">
    <label>Nombre</label>
    <input type="text" name="nombre" id="nombre" class="span3">
    <label>App</label>
    <input type="text" name="app" id="app" class="span3">
    <label>Matricula</label>
    <input type="text" name="matricula" id="matricula" class="span3">
    
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
                      <th>App</th>
                      <th>Matricula</th>                                                                 
                  </tr>
              </thead>   
              <tbody>
              <%
              	lista = dao.mostrar();
              	for (Profesor p : lista){
              %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getNombre() %></td>
                    <td><%= p.getApp() %></td>
                    <td><%= p.getMatricula() %></td>
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
