<!-- JSP (Java Server Page): Poder hacer peticiones hacia un servidor desde html, es decir, meter código java-->
<!-- ASP para C# -->
<html>

<%@page import = 'java.util.*' %>
<%@page import = 'com.mx.entidad.Novio' %>
<%@page import = 'com.mx.dao.NovioDao' %>

<body>
<h2>Gestion Novio</h2>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%
	NovioDao dao = new NovioDao();
	List<Novio> lista = new ArrayList<Novio>();
%>

<div class="span3">
    <form action = "NovioCtrl" method = "POST">
    <label>Id</label>
    <input type="text" name="id" id="id" class="span3">
    <label>Nombre</label>
    <input type="text" name="nombre" id="nombre" class="span3">
    <label>App</label>
    <input type="text" name="app" id="app" class="span3">
    <label>Apm</label>
    <input type="text" name="apm" id="apm" class="span3">
    <label>Profesion</label>
    <input type="text" name="profesion" id="profesion" class="span3">
    <label>Novia</label>
    <input type="text" name="id_novia" id="id_novia" class="span3">
    
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
                      <th>Apm</th>
                      <th>Profesion</th>   
                      <th>N Novia</th>   
                      <th>App Novia</th>   
                      <th>Apm Novia</th>                                             
                  </tr>
              </thead>   
              <tbody>
              <%
              	lista = dao.mostrar();
              	for (Novio n : lista){
              %>
                <tr>
                    <td><%= n.getId() %></td>
                    <td><%= n.getNombre() %></td>
                    <td><%= n.getApp() %></td>
                    <td><%= n.getApm() %></td>
                    <td><%= n.getProfesion() %></td>
                    <td><%= (n.getNovia()==null) ? "No tiene novia" : n.getNovia().getNombre()%></td>
                    <td><%= (n.getNovia()==null) ? "No tiene novia" : n.getNovia().getApp()%></td>
                    <td><%= (n.getNovia()==null) ? "No tiene novia" : n.getNovia().getApm()%></td>
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
