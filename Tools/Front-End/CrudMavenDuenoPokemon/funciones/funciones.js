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
        url: 'http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Dueno/mostrar',
        contentType: 'application/json; charset=utf-8',
        async: false,
        dataType: 'json',
        success: function(dato){
            console.log("bien" + JSON.stringify(dato));
            var cuerpo;
            for(var i=0; i<dato.length; i++){
                cuerpo += '<tr>'+
                '<td>'+dato[i].id+'</td>'+
                '<td>'+dato[i].nombre+'</td>'+
                '<td>'+dato[i].app+'</td>'+
                '<td>'+dato[i].pueblo+'</td>'+
                '<td>'+
						  '<a href="javascript:;" style="width: 40%;" class="btn btn-block btn-warning" data="'+dato[i].id+'"><i class="fa fa-fw fa-refresh"></i></a>'+
						  '</td>'+
						
						  '<td>'+
						  '<a href="javascript:;" style="width: 40%;" class="btn btn-block btn-danger" data="'+dato[i].id+'"><i class="fa fa-fw fa-remove"></i></a>'+
						  '</td>'+
                '</tr>';
            }
            $('#cuerpoT').html(cuerpo);
        },
        error: function(){
            console.log("mal");
        }
    })
}//Cierra Ajax -> Metodología de programación que permite hacer prgramacion asincrona

$('#cuerpoT').on('click','.btn-danger',function(){
    var id = $(this).attr("data");
    $('#idE').val(id);
    $('#modalEliminar').modal('show');

});

$('#cuerpoT').on('click','.btn-warning',function(){
    var id = $(this).attr("data");
    var json = {"id": id};
    $.ajax({
        type: 'ajax',
        method: 'post',
        url: 'http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Dueno/buscar',
        data: JSON.stringify(json),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',

        success: function(dato){
            console.log("bien "+JSON.stringify(dato));
            $('#idU').val(dato.id);
            $('#nombreU').val(dato.nombre);
            $('#appU').val(dato.app);
            $('#puebloU').val(dato.pueblo);
            $('#modalEditar').modal('show');
        },
        error: function(goku){
            console.log("mal "+JSON.stringify(goku));
        }
    });
});

 $('#btnAgregarModal').click(function()        //--------Modal Agregar--------
 {
     console.log("Se precionó el botón");
     $('#modalAgregar').modal('show')
 });

 $('#btnGuardar').click(function()             //--------Botón Guardar--------
 {
     var id = $('#id').val();
     var nombre = $('#nombre').val();
     var app = $('#app').val();
     var pueblo = $('#pueblo').val();

     console.log("id->"+id);
     console.log("modelo->"+nombre);
     console.log("marca->"+app);
     console.log("precio->"+pueblo);

     if(id==''){
         alert('falta id');
     }else if (nombre == ''){
         alert('falta nombre');
     }else if (app == ''){
        alert('falta apellido');
    }else if (pueblo == ''){
        alert('falta pueblo');
    }else{
        var json = {"id": id, "nombre": nombre, "app": app, "pueblo": pueblo};
        $.ajax({
            type: 'ajax',
            method: 'post',
            url: 'http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Dueno/guardar',
            data: JSON.stringify(json),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function(dato){
                console.log("bien "+JSON.stringify(dato));
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
 });

 $('#idU').keyup(function(){               //-------- Autocompletar--------
    var id = $('#idU').val();
    console.log("id-> "+ id);
    var json = {"id": id};
    $.ajax({
        type: 'ajax',
        method: 'post',
        url: 'http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Dueno/buscar',
        data: JSON.stringify(json),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',

        success: function(dato){
            console.log("bien "+JSON.stringify(dato));
            $('#nombreU').val(dato.nombre);
            $('#appU').val(dato.app);
            $('#puebloU').val(dato.pueblo);
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
     var app = $('#appU').val();
     var pueblo = $('#puebloU').val();

     console.log("id->"+id);
     console.log("modelo->"+nombre);
     console.log("marca->"+app);
     console.log("precio->"+pueblo);

     var json = {"id": id, "nombre": nombre, "app": app, "pueblo": pueblo};
        $.ajax({
            type: 'ajax',
            method: 'post',
            url: 'http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Dueno/editar',
            data: JSON.stringify(json),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function(dato){
                console.log("bien "+JSON.stringify(dato));
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
        url: 'http://localhost:9002/CrudMavenPokemon/crudMavenPokemon/Dueno/eliminar',
        data: JSON.stringify(json),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function(dato){
            console.log("bien "+JSON.stringify(dato));
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
