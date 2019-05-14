(function () {

    const userService = new AdminUserServiceClient();

    const $createBtn = $('#createBtn');
    const $updateBtn = $('#updateBtn');
    const $deleteBtn = $('.delete-btn');
    const $editBtn = $('.edit-btn');

    const $usernameFld = $('#usernameFld');
    const $passwordFld = $('#passwordFld');
    const $firstNameFld = $('#firstNameFld');
    const $lastNameFld = $('#lastNameFld');
    const $roleFld = $('#roleFld');
    const userRowTemplate = $('.userRowTemplate');
    const tbody = $('tbody');
    const findAllUsersUrl = 'http://localhost:8080/api/users';
    const deleteUserUrl = 'http://localhost:8080/api/users/delete/USER_ID';
    const editUserUrl = 'http://localhost:8080/api/users/edit/USER_ID';

    var currSelectUserId = null;

    $.ajax(findAllUsersUrl, {
        'success': renderUsers
    });

    //Array of Users -> HTML row elements
    function renderUsers() {
        tbody.empty();

        userService.findAllUsers(null).then(function(res) {
            res.forEach(appendUserToDom);
        });
    }

    $createBtn.click(createUser);
    $deleteBtn.click(deleteUser);
    $editBtn.click(renderUser);
    $updateBtn.click(updateUser);

    // User -> HTML row element
    function appendUserToDom(user) {

        //clone the template and remove the d-none class from it
        //so that data is still visible
        const row = userRowTemplate.clone();
        row.removeClass('d-none');

        const usernameCol = row.find(".usernameCol");
        const passwordCol = row.find(".passwordCol");
        const firstNameCol = row.find(".firstNameCol");
        const lastNameCol = row.find(".lastNameCol");
        const roleCol = row.find(".roleCol");

        //Get delete button and associate click event with it
        //so button functionality is maintained
        const deleteBtn = row.find('.delete-btn');
        const editBtn = row.find('.edit-btn');
        deleteBtn.click(deleteUser);
        editBtn.click(renderUser);


        deleteBtn.attr("id", user.id);
        editBtn.attr("id", user.id);

        //set html of each object to equal the relevant value from the form
        usernameCol.html(user.username);
        passwordCol.html(user.password);
        firstNameCol.html(user.firstName);
        lastNameCol.html(user.lastName);
        roleCol.html(user.role);

        //reset form values
        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");

        //append new user to bottom of the table
        tbody.append(row);
    }

    function createUser() {
        const username = $usernameFld.val();
        const password = $passwordFld.val();
        const firstName = $firstNameFld.val();
        const lastName = $lastNameFld.val();
        const role = $roleFld.val();
        const user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        };

        userService.createUser(user, null).then(renderUsers());
    }

    function deleteUser(event) {
        //grab delete button and assign an "id" attribute to it
        //use the globally defined deleteUserUrl to input the id and send
        //request to server
        const deleteBtn = $(event.currentTarget);
        const id = deleteBtn.attr("id");
        userService.deleteUser(id).then(renderUsers());
    }

    function renderUser(event) {
        //grab edit button and assign an "id" attribute to it
        //use the id and send request to server
        const editBtn = $(event.currentTarget);
        currSelectUserId = editBtn.attr("id");

        userService.findUserById(currSelectUserId, null).then(function(userToRender) {
            $usernameFld.val(userToRender.username);
            $passwordFld.val(userToRender.password);
            $firstNameFld.val(userToRender.firstName);
            $lastNameFld.val(userToRender.lastName);
        });
    }

    function updateUser(event) {

        const username = $usernameFld.val();
        const password = $passwordFld.val();
        const firstName = $firstNameFld.val();
        const lastName = $lastNameFld.val();
        const role = $roleFld.val();
        const user = {
            id: currSelectUserId,
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        };

        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");

        userService.updateUser(currSelectUserId, user, null).then(renderUsers());
    }

})();