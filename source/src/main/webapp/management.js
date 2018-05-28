Vue.component('todo-item', {
    props: ['todo'],
    template: '<tr><td>{{ todo.brand }}</td></tr>'
});

$(function() {
    var management = new Vue({
        el: '#management',
        data: {
            isLogged: window.localStorage.getItem('token') !== null,
            motorcycles: []
        }
    });

    $.get("api/motorcycles", function (data) {
        management.motorcycles = data;
    })
});