 $(document).ready(function()
 {
     //alert("Hola desde javascript");
     llenado();
 });

 function limpiar(){                      //--------Limpiar--------
    $('#id').val('');
    $('#nombre').val('');
    $('#pais').val('');
    $('#dano').val('');
    $('#hp').val('');
}

function llenado(){                      //--------Llenar--------
    $.ajax({
        type: 'ajax',
        method: 'get',
        url: 'http://localhost:9002/CrudHibernateTanque/crudHibernateTanque/Tanque/mostrar',
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
                '<td>'+dato[i].pais+'</td>'+
                '<td>'+dato[i].dano+'</td>'+
                '<td>'+dato[i].hp+'</td>'+
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
        url: 'http://localhost:9002/CrudHibernateTanque/crudHibernateTanque/Tanque/buscar',
        data: JSON.stringify(json),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',

        success: function(dato){
            console.log("bien "+JSON.stringify(dato));
            $('#idU').val(dato.id);
            $('#nombreU').val(dato.nombre);
            $('#paisU').val(dato.pais);
            $('#danoU').val(dato.dano);
            $('#hpU').val(dato.hp);
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
     var pais = $('#pais').val();
     var dano = $('#dano').val();
     var hp = $('#hp').val();

     console.log("id->"+id);
     console.log("nombre->"+nombre);
     console.log("pais->"+pais);
     console.log("dano->"+dano);
     console.log("hp->"+hp);

     if(id==''){
         alert('falta id');
     }else if (nombre == ''){
         alert('falta nombre');
     }else if (pais == ''){
        alert('falta pais');
    }else if (dano == ''){
        alert('falta dano');
    }else if (hp == ''){
        alert('falta hp');
    }else{
        var json = {"id": id, "nombre": nombre, "pais": pais, "dano": dano, "hp": hp};
        $.ajax({
            type: 'ajax',
            method: 'post',
            url: 'http://localhost:9002/CrudHibernateTanque/crudHibernateTanque/Tanque/guardar',
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
            $('#danoU').val(dato.dano);
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
     var pais = $('#paisU').val();
     var dano = $('#danoU').val();
     var hp = $('#hpU').val();

     console.log("id->"+id);
     console.log("nombre->"+nombre);
     console.log("pais->"+pais);
     console.log("dano->"+dano);
     console.log("hp->"+hp);

     var json = {"id": id, "nombre": nombre, "pais": pais, "dano": dano, "hp": hp};
        $.ajax({
            type: 'ajax',
            method: 'post',
            url: 'http://localhost:9002/CrudHibernateTanque/crudHibernateTanque/Tanque/editar',
            data: JSON.stringify(json),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function(dato){
                console.log("bien "+JSON.stringify(dato));
                llenado();
                limpiar();
                $('#modalEditar').modal('hide');
                $('.alert-warning').html('Se editó el registro').fadeIn().delay(4000).fadeOut('snow');
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
        url: 'http://localhost:9002/CrudHibernateTanque/crudHibernateTanque/Tanque/eliminar',
        data: JSON.stringify(json),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function(dato){
            console.log("bien "+JSON.stringify(dato));
            llenado();
            limpiar();
            $('#modalEliminar').modal('hide');
            $('.alert-danger').html('Se eliminó el registro').fadeIn().delay(4000).fadeOut('snow');
        },
        error: function(goku){
            console.log("mal "+JSON.stringify(goku));
        }
    });
 });

 $('#btnbusqueda').click(function(){
    var nombre = $('#btnBusqueda').val();
    var json = {"nombre": nombre}
    $.ajax({
        type: 'ajax',
        method: 'post',
        url: 'http://localhost:9002/CrudHibernateTanque/crudHibernateTanque/Tanque/buscarnombre',
        data: JSON.stringify(json),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function(dato){
            console.log("bien" + JSON.stringify(dato));
            var cuerpo;
            for(var i=0; i<dato.length; i++){
                cuerpo += '<tr>'+
                '<td>'+dato[i].id+'</td>'+
                '<td>'+dato[i].nombre+'</td>'+
                '<td>'+dato[i].pais+'</td>'+
                '<td>'+dato[i].dano+'</td>'+
                '<td>'+dato[i].hp+'</td>'+
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
        error: function(goku){
            console.log("mal "+JSON.stringify(goku));
        }
    })
 });