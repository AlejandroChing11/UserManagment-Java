// Call the dataTables jQuery plugin
$(document).ready(function() {

    cargarUsuarios();

  $('#usuarios').DataTable();
});

async function cargarUsuarios() {

      const request = await fetch('api/usuarios', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      });
      const usuarios = await request.json();


      let listadoHtml = '';
      for (let usuario of usuarios) {
          let usuarioHTML = 
              '<tr><td>' + usuario.id + '</td><td>' + usuario.name + ' ' + usuario.lastName + '</td><td>' 
              + usuario.email + '</td><td>' + usuario.phoneNumber
              + '</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>'
          listadoHtml += usuarioHTML
      }

      console.log(usuarios);

      
document.querySelector("#usuarios tbody").outerHTML = listadoHtml; 


}
