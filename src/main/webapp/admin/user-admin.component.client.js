(function () {

    var $createBtn, $updateBtn, $deleteBtn, $editBtn;
    var $usernameFld, $passwordFld, $firstNameFld, $lastNameFld, $roleFld;
    var userRowTemplate;
    var tbody;

    var currSelectUserId;
    var userService;

    $(main);

    //grabs all necessary elements on document load and
    //prepares them for use with jQuery
    function main() {

        userService = new AdminUserServiceClient();

        $createBtn = $('#createBtn');
        $updateBtn = $('#updateBtn');
        $deleteBtn = $('.delete-btn');
        $editBtn = $('.edit-btn');

        $usernameFld = $('#usernameFld');
        $passwordFld = $('#passwordFld');
        $firstNameFld = $('#firstNameFld');
        $lastNameFld = $('#lastNameFld');
        $roleFld = $('#roleFld');
        userRowTemplate = $('.userRowTemplate');
        tbody = $('tbody');

        currSelectUserId = null;

        //bind each button to click handler functions
        $createBtn.click(createUser);
        $deleteBtn.click(deleteUser);
        $editBtn.click(renderUser);
        $updateBtn.click(updateUser);

        userService.findAllUsers().then(renderUsers);
    }



    // () -> HTML row elements
    //empties the body of the table and re-renders each user returned
    //by the findAllUsers function
    function renderUsers(users) {
        tbody.empty();
        users.forEach(appendUserToDom);
    }



    // User -> HTML row element
    //clone the template row grabbed in the main() function and use it to create and append a
    //new dynamically generated row to the table
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

    // Void -> Void
    // Creates a new user based on the data passed in the form
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

        // Checks for empty form values and throws an alert. Does not create user if true
        if (username === "" || password === "" || firstName === "" || lastName === "") {
            alert("Cannot add user with empty values");
            return;
        }

        // Sends a request to the server to add new user
        userService.createUser(user).then(renderUsers);
    }

    // ClickEvent -> List of Users
    // Responds to click event on the delete button, grabs id, and
    // removes that row from the table body
    function deleteUser(event) {
        const deleteBtn = $(event.currentTarget);
        const id = deleteBtn.attr("id");

        // Sends request to server to remove the specified user
        userService.deleteUser(id).then(renderUsers);
    }

    // ClickEvent -> HTML Text
    // On edit button click, adds the given user's data to the form
    function renderUser(event) {
        const editBtn = $(event.currentTarget);
        currSelectUserId = editBtn.attr("id");

        // sends request to server for the user with the given id denoted
        // by the clicked edit button
        userService.findUserById(currSelectUserId).then(function(userToRender) {
            $usernameFld.val(userToRender.username);
            $passwordFld.val(userToRender.password);
            $firstNameFld.val(userToRender.firstName);
            $lastNameFld.val(userToRender.lastName);
        });
    }

    // ClickEvent -> List of Users
    // On update button click, applies changes made in the form to specified user
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

        // clears form on submission
        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");

        // sends request to server to update the specified user
        userService.updateUser(currSelectUserId, user).then(renderUsers);
    }
})();