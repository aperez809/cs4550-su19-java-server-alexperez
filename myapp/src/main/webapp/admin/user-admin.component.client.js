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

    $.ajax;

    $createBtn.click(createUser);
    $deleteBtn.click(deleteUser);


    function createUser() {
        const username = $usernameFld.val();
        const password = $passwordFld.val();
        const firstName = $firstNameFld.val();
        const lastName = $lastNameFld.val();
        const role = $roleFld.val();

        const row = userRowTemplate.clone();

        const usernameCol = row.find(".usernameCol");
        const passwordCol = row.find(".passwordCol");
        const firstNameCol = row.find(".firstNameCol");
        const lastNameCol = row.find(".lastNameCol");
        const roleCol = row.find(".roleCol");

        //Get delete button and associate click event with it
        //so button functionality is maintained
        const deleteBtn = row.find('.delete-btn');
        deleteBtn.click(deleteUser);

        //set html of each object to equal the relevant value from the form
        usernameCol.html(username);
        passwordCol.html(password);
        firstNameCol.html(firstName);
        lastNameCol.html(lastName);
        roleCol.html(role);

        //reset form values
        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");

        //append new user to bottom of the table
        tbody.append(row);
    }

    function deleteUser(event) {

        //get the grandparent element of the delete button (parent == td holding the buttons,
        //grandparent == row itself) and remove it
        const row = $(event.currentTarget).parent().parent();
        row.remove();
    }

})();