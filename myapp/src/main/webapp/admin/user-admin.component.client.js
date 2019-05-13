(function () {

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
    const findAllUsersUrl = 'http://localhost:8080/users';
    const deleteUserUrl = 'http://localhost:8080/users/delete/USER_ID';
    const editUserUrl = 'http://localhost:8080/users/edit/USER_ID';

    $.ajax(findAllUsersUrl, {
        'success': renderUsers
    });

    //Array of Users -> HTML row elements
    function renderUsers(users) {
        users.forEach(appendUserToDom);
    }

    $createBtn.click(createUser);
    $deleteBtn.click(deleteUser);
    $editBtn.click(editUser);

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
        editBtn.click(editUser);


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



        appendUserToDom(user);
    }

    function deleteUser(event) {
        //grab delete button and assign an "id" attribute to it
        //use the globally defined deleteUserUrl to input the id and send
        //request to server
        const deleteBtn = $(event.currentTarget);
        const id = deleteBtn.attr("id");
        const url = deleteUserUrl.replace("USER_ID", id);

        $.ajax(url, {
            "type": "DELETE"
        });
        
        //get the grandparent element of the delete button (parent == td holding the buttons,
        //grandparent == row itself) and remove it
        const row = deleteBtn.parent().parent();
        row.remove();
    }

    function editUser(event) {
        //grab delete button and assign an "id" attribute to it
        //use the globally defined deleteUserUrl to input the id and send
        //request to server
        const editBtn = $(event.currentTarget);
        const id = editBtn.attr("id");
        const url = editUserUrl.replace("USER_ID", id);

        const row = editBtn.parent().parent();

        const usernameCol = row.find(".usernameCol");
        const passwordCol = row.find(".passwordCol");
        const firstNameCol = row.find(".firstNameCol");
        const lastNameCol = row.find(".lastNameCol");
        const roleCol = row.find(".roleCol");

        console.log(usernameCol.text);
        $usernameFld.val(usernameCol.toString());
        $passwordFld.val(passwordCol.toString());
        $firstNameFld.val(firstNameCol.toString());
        $lastNameFld.val(lastNameCol);
    }

    function updateUser(event) {
        const updateBtn = $(event.currentTarget);

        $.ajax(url, {
            "type": "PUT",
            "success": renderUsers
        });
    }

})();