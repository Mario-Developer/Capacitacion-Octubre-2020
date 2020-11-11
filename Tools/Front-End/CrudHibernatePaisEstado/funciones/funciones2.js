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
$('#inputSearch').keyup(function(){
    var nombre = $('#inputSearch').val();
    var json = {"nombre": nombre};
    $.ajax({
        type: 'ajax',
        method: 'post',
        url: 'http://localhost:9002/CrudHibernateOneToMany/crudHibernateOneToMany/Estado/buscarNombre',
        data: JSON.stringify(json),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function(datos){
            console.log("bien "+JSON.stringify(datos));
            var cuerpo;
           for(var i=0; i<datos.length; i++){
               cuerpo += '<tr>'+
               '<td>'+datos[i].id+'</td>'+
               '<td>'+datos[i].nombre+'</td>'+
               '<td>'+datos[i].habitantes+'</td>'+
               '<td>'+datos[i].pais.nombre+'</td>'+
               '<td>'+datos[i].pais.continente+'</td>'+
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
        error: function(goku){
            console.log("mal "+JSON.stringify(goku));
        }
    });

});

function llenado(){                      //--------Llenar--------
   $.ajax({
       type: 'ajax',
       method: 'get',
       url: 'http://localhost:9002/CrudHibernateOneToMany/crudHibernateOneToMany/Estado/mostrar',
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
               '<td>'+datos[i].habitantes+'</td>'+
               '<td>'+datos[i].pais.nombre+'</td>'+
               '<td>'+datos[i].pais.continente+'</td>'+
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
        url: 'http://localhost:9002/CrudHibernateOneToMany/crudHibernateOneToMany/Pais/mostrar',
        contentType: 'application/json; charset=utf-8',
        async: false,
        dataType: 'json',
        success: function(datos){
            console.log("bien" + JSON.stringify(datos));
            //var pais = $('#cuerpoSelect').val();
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
    var habitantes = $('#habitantes').val();
    var id_pais = $('#cuerpoSelect').val();

    console.log("id->"+id);
    console.log("nombre->"+nombre);
    console.log("habitantes->"+habitantes);
    console.log("pais->"+id_pais);
    //console.log("pais->"+pais);

    if(id==''){
        alert('falta id');
    }else if (nombre == ''){
        alert('falta nombre');
    }else if (habitantes == ''){
       alert('falta habitantes');
   }else if (id_pais == '0'){
    alert('falta pais');
   }else{
       var pais = {'id':id_pais};
       var json = {"id": id, "nombre": nombre, "habitantes": habitantes, "pais": pais};
       $.ajax({
           type: 'ajax',
           method: 'post',
           url: 'http://localhost:9002/CrudHibernateOneToMany/crudHibernateOneToMany/Estado/guardar',
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
           $('#habitantesU').val(datos.habitantes);
           $('#paisU').val(datos.pais);
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
        url: 'http://localhost:9002/CrudHibernateOneToMany/crudHibernateOneToMany/Estado/buscar',
        data: JSON.stringify(json),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function(datos){
            console.log("bien "+JSON.stringify(datos));
            $('#idU').val(datos.id);
            $('#nombreU').val(datos.nombre);
            $('#habitantesU').val(datos.habitantes);
            $('#paisU').val(datos.pais);
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
    var habitantes = $('#habitantesU').val();
    var id_pais = $('#cuerpoSelectU').val();

    console.log("id->"+id);
    console.log("nombre->"+nombre);
    console.log("habitantes->"+habitantes);
    console.log("pais->"+id_pais);

    var pais = {'id':id_pais};
    var json = {"id": id, "nombre": nombre, "habitantes": habitantes, "pais": pais};
       $.ajax({
           type: 'ajax',
           method: 'post',
           url: 'http://localhost:9002/CrudHibernateOneToMany/crudHibernateOneToMany/Estado/editar',
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
