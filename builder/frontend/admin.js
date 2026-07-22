const API_URL = "http://YOUR_SERVER_IP:8000";



const adminBox =

    document.getElementById(

        "adminData"

    );





async function loadUsers() {


    adminBox.innerHTML =

        "Loading users...";



    try {


        const response =

            await fetch(

                API_URL + "/api/admin/users"

            );



        const users =

            await response.json();



        adminBox.innerHTML = "";



        users.forEach(

            user => {


                adminBox.innerHTML += `

                    <div class="build-card">

                        <h3>

                        ${user.username}

                        </h3>


                        <p>

                        ${user.email}

                        </p>


                        <p>

                        ID:

                        ${user.id}

                        </p>

                    </div>

                `;


            }

        );


    }

    catch(error){


        adminBox.innerHTML =

            "Failed loading users";


    }


}





async function loadBuilds() {


    adminBox.innerHTML =

        "Loading builds...";



    try {


        const response =

            await fetch(

                API_URL + "/api/admin/builds"

            );



        const builds =

            await response.json();



        adminBox.innerHTML = "";



        builds.forEach(

            build => {


                adminBox.innerHTML += `

                <div class="build-card">

                    <h3>

                    ${build.app_name}

                    </h3>


                    <p>

                    Status:

                    ${build.status}

                    </p>


                    <p>

                    User ID:

                    ${build.user_id}

                    </p>

                </div>

                `;


            }

        );



    }

    catch(error){


        adminBox.innerHTML =

            "Failed loading builds";


    }


}