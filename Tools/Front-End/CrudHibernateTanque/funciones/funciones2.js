$(document).ready(function()
{
    //alert("Hola desde javascript");
    llenado();
});

function limpiar(){                      //--------Limpiar--------
   $('#id').val('');
   $('#nombre').val('');
   $('#app').val('');
   $('#pueblo').val('');
}

function llenado(){                      //--------Llenar--------
   $.ajax({
       type: 'ajax',
       method: 'get',
       url: 'http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Pokemon/mostrar',
       contentType: 'application/json; charset=utf-8',
       async: false,
       dataType: 'json',
       success: function(datos){
           console.log("bien" + JSON.stringify(datos));
           var cuerpo;
           for(var i=0; i<datos.length; i++){
               cuerpo += '<tr>'+
               '<td>'+datos[i].id+'</td>'+
               '<td>'+datos[i].nombre+'</td>'+
               '<td>'+datos[i].tipo+'</td>'+
               '<td>'+datos[i].ataque+'</td>'+
               '<td>'+datos[i].dueno.nombre+'</td>'+
               '<td>'+datos[i].dueno.pueblo+'</td>'+
               '<td>'+
                         '<a href="javascript:;" style="width: 40%;" class="btn btn-block btn-warning" data="'+datos[i].id+'"><i class="fa fa-fw fa-refresh"></i></a>'+
                         '</td>'+
                       
                         '<td>'+
                         '<a href="javascript:;" style="width: 40%;" class="btn btn-block btn-danger" data="'+datos[i].id+'"><i class="fa fa-fw fa-remove"></i></a>'+
                         '</td>'+
               '</tr>';
           }
           $('#cuerpoT').html(cuerpo);
       },
       error: function(){
           console.log("mal");
       }
   });
}//Cierra Ajax -> Metodología de programación que permite hacer prgramacion asincrona

function llenadoSelect(){
    $.ajax({
        type: 'ajax',
        method: 'get',
        url: 'http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Dueno/mostrar',
        contentType: 'application/json; charset=utf-8',
        async: false,
        dataType: 'json',
        success: function(datos){
            console.log("bien" + JSON.stringify(datos));
            //var dueno = $('#cuerpoSelect').val();
            var cuerpo1;
            var cuerpo2;
            cuerpo1 ='<option value="0" selected>Selecciona dueño</option>'
            for(var i=0; i<datos.length; i++){
                cuerpo1 += '<option value="'+datos[i].id+'">'+datos[i].nombre+'</option>';
                cuerpo2 += '<option value="'+datos[i].id+'">'+datos[i].nombre+'</option>';
            }
            $('#cuerpoSelectU').html(cuerpo2);
            $('#cuerpoSelect').html(cuerpo1);
        },
        error: function(){
            console.log("mal");
        }
    });
}

$('#cuerpoT').on('click','.btn-danger',function(){
   var id = $(this).attr("data");
   $('#idE').val(id);
   $('#modalEliminar').modal('show');

});

$('#btnAgregarModal').click(function()        //--------Modal Agregar--------
{
    console.log("Se precionó el botón");
    $('#modalAgregar').modal('show')
    llenadoSelect();
});

$('#btnGuardar').click(function()             //--------Botón Guardar--------
{
    var id = $('#id').val();
    var nombre = $('#nombre').val();
    var tipo = $('#tipo').val();
    var ataque = $('#ataque').val();
    var id_dueno = $('#cuerpoSelect').val();

    console.log("id->"+id);
    console.log("nombre->"+nombre);
    console.log("tipo->"+tipo);
    console.log("ataque->"+ataque);
    //console.log("dueno->"+dueno);

    if(id==''){
        alert('falta id');
    }else if (nombre == ''){
        alert('falta nombre');
    }else if (tipo == ''){
       alert('falta tipo');
   }else if (ataque == ''){
       alert('falta ataque');
   }else if (id_dueno == '0'){
    alert('falta dueño');
   }else{
       var dueno = {'id':id_dueno};
       var json = {"id": id, "nombre": nombre, "tipo": tipo, "ataque": ataque, "dueno": dueno};
       $.ajax({
           type: 'ajax',
           method: 'post',
           url: 'http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Pokemon/guardar',
           data: JSON.stringify(json),
           contentType: 'application/json; charset=utf-8',
           dataType: 'json',
           success: function(datos){
               console.log("bien "+JSON.stringify(datos));
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

$('#btnEditarModal').click(function()      //--------Modal Editar--------
{
    $('#modalEditar').modal('show');
    llenadoSelect();
});

$('#idU').keyup(function(){               //-------- Autocompletar--------
   var id = $('#idU').val();
   console.log("id-> "+ id);
   var json = {"id": id};
   $.ajax({
       type: 'ajax',
       method: 'post',
       url: 'http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Pokemon/buscar',
       data: JSON.stringify(json),
       contentType: 'application/json; charset=utf-8',
       dataType: 'json',

       success: function(datos){
           console.log("bien "+JSON.stringify(datos));
           $('#nombreU').val(datos.nombre);
           $('#tipoU').val(datos.tipo);
           $('#ataqueU').val(datos.ataque);
       },
       error: function(goku){
           console.log("mal "+JSON.stringify(goku));
       }
   });
});

$('#cuerpoT').on('click','.btn-warning',function(){
    llenadoSelect();
    var id = $(this).attr("data");
    var json = {"id": id};
    $.ajax({
        type: 'ajax',
        method: 'post',
        url: 'http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Pokemon/buscar',
        data: JSON.stringify(json),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function(datos){
            console.log("bien "+JSON.stringify(datos));
            $('#idU').val(datos.id);
            $('#nombreU').val(datos.nombre);
            $('#tipoU').val(datos.tipo);
            $('#ataqueU').val(datos.ataque);
            $('#modalEditar').modal('show');
        },
        error: function(goku){
            console.log("mal "+JSON.stringify(goku));
        }
    });
});

$('#btnEditar').click(function()          //--------Boton Editar--------
{
    var id = $('#idU').val();
    var nombre = $('#nombreU').val();
    var tipo = $('#tipoU').val();
    var ataque = $('#ataqueU').val();
    var id_dueno = $('#cuerpoSelectU').val();

    console.log("id->"+id);
    console.log("nombre->"+nombre);
    console.log("tipo->"+tipo);
    console.log("ataque->"+ataque);

    var dueno = {'id':id_dueno};
    var json = {"id": id, "nombre": nombre, "tipo": tipo, "ataque": ataque, "dueno": dueno};
       $.ajax({
           type: 'ajax',
           method: 'post',
           url: 'http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Pokemon/editar',
           data: JSON.stringify(json),
           contentType: 'application/json; charset=utf-8',
           dataType: 'json',
           success: function(datos){
               console.log("bien "+JSON.stringify(datos));
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

$('#btnEliminarModal').click(function(){   //--------Modal Eliminar--------
   $('#modalEliminar').modal('show');
});

$('#btnEliminar').click(function(){
    var id = $('#idE').val();
    var json = {"id": id};
    $.ajax({
       type: 'ajax',
       method: 'post',
       url: 'http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Pokemon/eliminar',
       data: JSON.stringify(json),
       contentType: 'application/json; charset=utf-8',
       dataType: 'json',
       success: function(datos){
           console.log("bien "+JSON.stringify(datos));
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
