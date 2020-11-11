 $(document).ready(function()
 {
     //alert("Hola desde javascript");
     llenado();
 });
 function limpiar(){
    $('#id').val('');
    $('#modelo').val('');
    $('#marca').val('');
    $('#precio').val('');
}

function llenado(){
    $.ajax({
        type: 'ajax',
        method: 'get',
        url: 'http://localhost:9002/CrudMavenCelular/crudMavenCelular/Celular/mostrar',
        contentType: 'application/json; charset=utf-8',
        async: false,
        dataType: 'json',
        success: function(vegeta){
            console.log("bien" + JSON.stringify(vegeta));
            var cuerpo;
            for(var i=0; i<vegeta.length; i++){
                cuerpo += '<tr>'+
                '<td>'+vegeta[i].id+'</td>'+
                '<td>'+vegeta[i].modelo+'</td>'+
                '<td>'+vegeta[i].marca+'</td>'+
                '<td>'+vegeta[i].precio+'</td>'+
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
     var modelo = $('#modelo').val();
     var marca = $('#marca').val();
     var precio = $('#precio').val();

     console.log("id->"+id);
     console.log("modelo->"+modelo);
     console.log("marca->"+marca);
     console.log("precio->"+precio);
     //$('#modalAgregar').modal('hide');

     if(id==''){
         alert('falta id');
     }else if (modelo == ''){
         alert('falta modelo');
     }else if (marca == ''){
        alert('falta marca');
    }else if (precio == ''){
        alert('falta precio');
    }else{
        var json = {"id": id, "modelo": modelo, "marca": marca, "precio": precio};
        $.ajax({
            type: 'ajax',
            method: 'post',
            url: 'http://localhost:9002/CrudMavenCelular/crudMavenCelular/Celular/guardar',
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
 
 $('#btnEditar').click(function()
 {
    var id = $('#idU').val();
    var modelo = $('#modeloU').val();
    var marca = $('#marcaU').val();
    var precio = $('#precioU').val();

    console.log("id->"+id);
    console.log("modelo->"+modelo);
    console.log("marca->"+marca);
    console.log("precio->"+precio);

    var json = {"id": id, "modelo": modelo, "marca": marca, "precio": precio};
        $.ajax({
            type: 'ajax',
            method: 'post',
            url: 'http://localhost:9002/CrudMavenCelular/crudMavenCelular/Celular/editar',
            data: JSON.stringify(json),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function(vegeta){
                console.log("bien "+JSON.stringify(vegeta));
                llenado();
                //limpiar();
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

 $('#idU').keyup(function(){
    var id = $('#idU').val();
    console.log("id->"+id);
    var json = {"id": id};
    $.ajax({
        type: 'ajax',
        method: 'post',
        url: 'http://localhost:9002/CrudMavenCelular/crudMavenCelular/Celular/buscar',
        data: JSON.stringify(json),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',

        success: function(vegeta){
            console.log("bien "+JSON.stringify(vegeta));
            $('#modeloU').val(vegeta.modelo);
            $('#marcaU').val(vegeta.marca);
            $('#precioU').val(vegeta.precio);
            /*llenado();
            limpiar();
            $('#modalAgregar').modal('hide');
            $('.alert-success').html('Se eliminó el registro').fadeIn().delay(4000).fadeOut('snow');*/
        },
        error: function(goku){
            console.log("mal "+JSON.stringify(goku));
        }
    });
});

 $('#btnEliminar').click(function(){
     //$('#modalEliminar').modal('hide');
     var id = $('#idE').val();
     var json = {"id": id};
     $.ajax({
        type: 'ajax',
        method: 'post',
        url: 'http://localhost:9002/CrudMavenCelular/crudMavenCelular/Celular/eliminar',
        data: JSON.stringify(json),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function(vegeta){
            console.log("bien "+JSON.stringify(vegeta));
            llenado();
            limpiar();
            $('#modalAgregar').modal('hide');
            $('.alert-success').html('Se eliminó el registro').fadeIn().delay(4000).fadeOut('snow');
        },
        error: function(goku){
            console.log("mal "+JSON.stringify(goku));
        }
    });
 });
