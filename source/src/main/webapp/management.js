$(function() {
    var management = new Vue({
        el: '#management',
        data: {
            isLogged: window.localStorage.getItem('token') !== null,
            isAdmin: false,
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
            },
            selectItem: function(id) {
                $.get("api/motorcycles/" + id, function (data) {
                    details.motorcycle = data;
                    editMotorcycle.motorcycle = undefined;
                });
            },
            editItem: function(id) {
                $.get("api/motorcycles/" + id, function (data) {
                    details.motorcycle = undefined;
                    editMotorcycle.motorcycle = data;
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

    var details = new Vue({
        el: '#details',
        data: {
            motorcycle: undefined
        }
    });

    var editMotorcycle = new Vue({
        el: '#editMotorcycle',
        data: {
            motorcycle: undefined
        },
        methods: {
            updateMotorcycle: function() {
                $.ajax({
                   url: "api/motorcycles/" + motorcycle.id,
                   type: 'PATCH',
                   data: data.motorcycle,
                   success: function(data) {
                       $.get("api/motorcycles", function (data) {
                           management.motorcycles = data;
                           data.motorcycle = undefined;
                       });
                   }
               });
            }
        }
    });
});