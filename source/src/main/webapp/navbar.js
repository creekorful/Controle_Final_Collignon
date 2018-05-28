$(function() {
    var navbar = new Vue({
        el: '#navbar',
        data: {
            isLogged: window.localStorage.getItem('token') !== null
        },
        methods: {
            logout: function() {
                window.localStorage.clear();
                window.location.reload();
            }
        }
    });
});