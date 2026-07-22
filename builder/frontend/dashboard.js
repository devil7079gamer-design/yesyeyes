const API_URL = "http://YOUR_SERVER_IP:8000";



const USER_ID = 1;



async function loadBuilds() {


    const container =

        document.getElementById(

            "builds"

        );



    container.innerHTML =

        "Loading builds...";



    try {


        const response =

            await fetch(

                API_URL +

                "/api/users/" +

                USER_ID +

                "/builds"

            );



        const builds =

            await response.json();



        if (

            builds.length === 0

        ) {


            container.innerHTML =

                "No builds found";


            return;

        }



        container.innerHTML = "";



        builds.forEach(

            build => {



                const div =

                    document.createElement(

                        "div"

                    );



                div.className =

                    "build-card";



                div.innerHTML = `

                    <h3>

                    ${build.app_name}

                    </h3>


                    <p>

                    Status:

                    ${build.status}

                    </p>



                    <p>

                    ${build.website_url}

                    </p>


                    ${
                        build.apk

                        ?

                        `<a href="${build.apk}">

                        Download APK

                        </a>`

                        :

                        "Building..."

                    }

                `;



                container.appendChild(

                    div

                );


            }

        );


    }


    catch(error) {


        container.innerHTML =

            "Failed to load builds";


        console.log(error);


    }


}


window.onload =

    loadBuilds;