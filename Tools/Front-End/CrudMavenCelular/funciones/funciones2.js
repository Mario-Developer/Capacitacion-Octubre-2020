$(document).ready(function()
{
    //alert("Hola desde javascript");
    llenado();
});

function limpiar(){ 
   $('#id').val('');
   $('#nombre').val('');
   $('#pais').val('');
   $('#slogan').val('');
}

function llenado(){
   $.ajax({
       type: 'ajax',
       method: 'get',
       url: 'http://localhost:9002/CrudMavenCelular/crudMavenCelular/MarcaCelular/mostrar',
       contentType: 'application/json; charset=utf-8',
       async: false,
       dataType: 'json',
       success: function(vegeta){
           console.log("bien" + JSON.stringify(vegeta));
           var cuerpo;
           for(var i=0; i<vegeta.length; i++){
               cuerpo += '<tr>'+
               '<td>'+vegeta[i].id+'</td>'+
               '<td>'+vegeta[i].nombre+'</td>'+
               '<td>'+vegeta[i].pais+'</td>'+
               '<td>'+vegeta[i].slogan+'</td>'+
               '</tr>';
           }
           $('#cuerpoT').html(cuerpo);
       },
       error: function(){
           console.log("mal");
       }
   })
}//Cierra Ajax -> Metodología de programación que permite hacer prgramacion asincrona

$('#btnAgregarModal').click(function()
{
    console.log("Se precionó el botón");
    $('#modalAgregar').modal('show')
});

$('#btnGuardar').click(function()
{
    var id = $('#id').val();
    var nombre = $('#nombre').val();
    var pais = $('#pais').val();
    var slogan = $('#slogan').val();

    console.log("id->"+id);
    console.log("nombre->"+nombre);
    console.log("pais->"+pais);
    console.log("slogan->"+slogan);

    if(id==''){
        alert('falta id');
    }else if (nombre == ''){
        alert('falta nombre');
    }else if (pais == ''){
       alert('falta pais');
   }else if (slogan == ''){
       alert('falta slogan');
   }else{
    var json = {"id": id, "nombre": nombre, "pais": pais, "slogan": slogan};
       $.ajax({
           type: 'ajax',
           method: 'post',
           url: 'http://localhost:9002/CrudMavenCelular/crudMavenCelular/MarcaCelular/guardar',
           data: JSON.stringify(json),
           contentType: 'application/json; charset=utf-8',
           dataType: 'json',
           success: function(vegeta){
               console.log("bien "+JSON.stringify(vegeta));
               llenado();
               limpiar();
               $('#modalAgregar').modal('hide');
               $('.alert-success').html('Se guardo el registro').fadeIn().delay(4000).fadeOut('snow');
           },
           error: function(goku){
               console.log("mal "+JSON.stringify(goku));
           }
       }); //Cierra Ajax
   }//Cierra else
});//Cierra btnGuardar

$('#btnEditarModal').click(function()
{
    $('#modalEditar').modal('show');
});

$('#idU').keyup(function(){
    var id = $('#idU').val();
    console.log("id->"+id);
    var json = {"id": id};
    $.ajax({
        type: 'ajax',
        method: 'post',
        url: 'http://localhost:9002/CrudMavenCelular/crudMavenCelular/MarcaCelular/buscar',
        data: JSON.stringify(json),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
 
        success: function(vegeta){
            console.log("bien "+JSON.stringify(vegeta));
            $('#nombreU').val(vegeta.nombre);
            $('#paisU').val(vegeta.pais);
            $('#sloganU').val(vegeta.slogan);
        },
        error: function(goku){
            console.log("mal "+JSON.stringify(goku));
        }
    });
 });

$('#btnEditar').click(function()
{
   var id = $('#idU').val();
   var nombre = $('#nombreU').val();
   var pais = $('#paisU').val();
   var slogan = $('#sloganU').val();

   console.log("id->"+id);
   console.log("nombre->"+nombre);
   console.log("pais->"+pais);
   console.log("slogan->"+slogan);

   var json = {"id": id, "nombre": nombre, "pais": pais, "slogan": slogan};
       $.ajax({
           type: 'ajax',
           method: 'post',
           url: 'http://localhost:9002/CrudMavenCelular/crudMavenCelular/MarcaCelular/editar',
           data: JSON.stringify(json),
           contentType: 'application/json; charset=utf-8',
           dataType: 'json',
           success: function(vegeta){
               console.log("bien "+JSON.stringify(vegeta));
               llenado();
               limpiar();
               $('#modalEditar').modal('hide');
               $('.alert-success').html('Se editó el registro').fadeIn().delay(4000).fadeOut('snow');
           },
           error: function(goku){
               console.log("mal "+JSON.stringify(goku));
           }
       }); //Cierra Ajax
});

$('#btnEliminarModal').click(function(){
   $('#modalEliminar').modal('show');
});

$('#btnEliminar').click(function(){
    var id = $('#idE').val();
    var json = {"id": id};
    $.ajax({
       type: 'ajax',
       method: 'post',
       url: 'http://localhost:9002/CrudMavenCelular/crudMavenCelular/MarcaCelular/eliminar',
       data: JSON.stringify(json),
       contentType: 'application/json; charset=utf-8',
       dataType: 'json',
       success: function(vegeta){
           console.log("bien "+JSON.stringify(vegeta));
           llenado();
           limpiar();
           $('#modalEliminar').modal('hide');
           $('.alert-success').html('Se eliminó el registro').fadeIn().delay(4000).fadeOut('snow');
       },
       error: function(goku){
           console.log("mal "+JSON.stringify(goku));
       }
   });
});
