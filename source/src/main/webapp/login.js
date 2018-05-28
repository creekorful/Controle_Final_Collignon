$(function() {
    var login = new Vue({
        el: '#login',
        data: {
            isLogged: window.localStorage.getItem('token') !== null
        },
        methods: {
            login: function () {
                var credentials = { username: $('#username').val(), password: $('#password').val()};

                $.ajax({
                    url: 'api/session',
                    type: 'POST',
                    data: JSON.stringify(credentials),
                    contentType: 'application/json; charset=utf-8',
                    dataType: 'json',
                    async: false
                }).done(function(msg) {
                    var token = msg['token'];

                    if (token !== null) {
                        window.localStorage.setItem('token', msg['token']);
                        window.location.reload();
                    } else {
                        $("#login").prepend('<div class="alert alert-danger"> <strong>Erreur! </strong>Mauvais' +
                                            ' credentials.</div>');
                    }
                });
            }
        }
    });
});