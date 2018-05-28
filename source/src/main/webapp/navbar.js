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
});