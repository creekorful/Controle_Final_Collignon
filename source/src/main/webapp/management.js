$(function() {
    var navbar = new Vue({
        el: '#navbar',
        data: {
            isLogged: window.localStorage.getItem('token') !== null,
            isAdmin: false
        },
        methods: {
            logout: function() {
                window.localStorage.clear();
                window.location.reload();
            },
            showAdd: function() {
                createMotorcycle.isShow = true;
                editMotorcycle.motorcycle = undefined;
                details.motorcycle = undefined;
            }
        }
    });

    $.ajax({
           url: "api/session/isAdmin",
           dataType: 'json',
           success: function(data, status) {
               navbar.isAdmin = data;
           },
           beforeSend: function(xhr, settings) {
               xhr.setRequestHeader('Authorization','Bearer ' + window.localStorage.getItem('token'));
           }
       });

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
                    createMotorcycle.isShow = false;
                });
            },
            editItem: function(id) {
                $.get("api/motorcycles/" + id, function (data) {
                    details.motorcycle = undefined;
                    editMotorcycle.motorcycle = data;
                    createMotorcycle.isShow = false;
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
                   url: "api/motorcycles/" + editMotorcycle.motorcycle.id,
                   contentType: "application/json; charset=utf-8",
                   dataType: 'json',
                   type: 'PATCH',
                   data: JSON.stringify(editMotorcycle.motorcycle),
                   success: function(data) {
                       $.get("api/motorcycles", function (data) {
                           management.motorcycles = data;
                           editMotorcycle.motorcycle = undefined;
                       });
                   },
                   beforeSend: function(xhr, settings) {
                       xhr.setRequestHeader('Authorization','Bearer ' + window.localStorage.getItem('token'));
                   }
               });
            }
        }
    });

    var createMotorcycle = new Vue({
        el: '#createMotorcycle',
        data: {
            isShow: false,
            motorcycle: {
                brand: '',
                model: '',
                fiscalPower: 0,
                tireType: '',
                engineId: 0
            }
        },
        methods: {
            createMotorcycle: function() {
                $.ajax({
                   url: "api/motorcycles/",
                   contentType: "application/json; charset=utf-8",
                   dataType: 'json',
                   type: 'POST',
                   data: JSON.stringify(createMotorcycle.motorcycle),
                   success: function(data) {
                       $.get("api/motorcycles", function (data) {
                           management.motorcycles = data;
                           editMotorcycle.motorcycle = undefined;
                           createMotorcycle.isShow = false;
                       });
                   },
                   beforeSend: function(xhr, settings) {
                       xhr.setRequestHeader('Authorization','Bearer ' + window.localStorage.getItem('token'));
                   }
               });
            }
        }
    });
});