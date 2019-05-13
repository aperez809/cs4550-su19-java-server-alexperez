function AdminUserServiceClient() {
    this.users = [];


    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'http://localhost:8080/api/users';
    var self = this;

    function createUser(user, callback) {
        const createUrl = this.url + "/create";

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



    function findAllUsers(callback) {
        return fetch(this.url).then(function(response) {
            return response.json();
        });
    }

    function findUserById(userId, callback) {
        return fetch(this.url)
    }

    function updateUser(userId, user, callback) {

    }

    function deleteUser(userId, callback) {

    }
}
