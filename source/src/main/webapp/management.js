Vue.component('todo-item', {
    props: ['todo'],
    template: '<tr><td>{{ todo.id }}</td><td>{{ todo.brand }}</td><td>{{ todo.model }}</td></tr>'
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