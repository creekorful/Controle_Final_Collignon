$(function() {
    var management = new Vue({
        el: '#management',
        data: {
            isLogged: window.localStorage.getItem('token') !== null,
            isAdmin: true,
            motorcycles: []
        },
        methods: {
            deleteItem: function(id) {
                $.ajax({
                   url: "api/motorcycles/" + id,
                   type: 'DELETE',
                   success: function(result) {
                       $.get("api/motorcycles", function (data) {
                           management.motorcycles = data;
                       });
                   },
                   error: function(result) {
                        alert("error");
                   },
                   beforeSend: function(xhr, settings) {
                       xhr.setRequestHeader('Authorization','Bearer ' + window.localStorage.getItem('token'));
                   }
               });
            }
        }
    });

    $.get("api/motorcycles", function (data) {
        management.motorcycles = data;
    });

    $.ajax({
       url: "api/session/isAdmin",
       dataType: 'json',
       success: function(data, status) {
           management.isAdmin = data;
       },
       beforeSend: function(xhr, settings) {
           xhr.setRequestHeader('Authorization','Bearer ' + window.localStorage.getItem('token'));
       }
    });
});