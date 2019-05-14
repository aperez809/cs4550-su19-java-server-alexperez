function AdminUserServiceClient() {
    this.users = [];


    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'http://localhost:8080/api/users/';
    var self = this;

    function createUser(user) {
        const createUrl = this.url + "create/";

        return fetch(createUrl, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function (response) {
            return response.json();
        });
    }


    function findAllUsers() {
        return fetch(this.url).then(function (response) {
            return response.json();
        });
    }

    function findUserById(userId) {
        return fetch(this.url + "find/" + userId).then(function (response) {
            return response.json();
        });
    }

    function updateUser(userId, user) {
        const updateUrl = this.url + "update/" + userId;
        return fetch(updateUrl, {
            method: 'put',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function (response) {
            return response.json();
        });
    }

    function deleteUser(userId) {
        const deleteUrl = this.url + "delete/" + userId;
        return fetch(deleteUrl, {
            method: "delete"
        }).then(function (response) {
            return response.json();
        });
    }
}
