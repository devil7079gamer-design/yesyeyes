const API_URL = "http://YOUR_SERVER_IP:8000";



async function createBuild() {


    const appName =

        document.getElementById(

            "appName"

        ).value;



    const websiteUrl =

        document.getElementById(

            "websiteUrl"

        ).value;



    const packageName =

        document.getElementById(

            "packageName"

        ).value;



    const result =

        document.getElementById(

            "result"

        );



    result.innerHTML =

        "Starting build...";



    try {


        const response =

            await fetch(

                API_URL + "/api/build/",

                {

                    method: "POST",

                    headers: {

                        "Content-Type":

                        "application/json"

                    },

                    body: JSON.stringify({

                        user_id: 1,

                        app_name: appName,

                        website_url: websiteUrl,

                        package_name: packageName

                    })

                }

            );



        const data =

            await response.json();



        result.innerHTML = `

            Build ID:

            ${data.build_id}

            <br>

            Status:

            ${data.status}

        `;


    }


    catch(error) {


        result.innerHTML =

            "Server connection failed";


        console.log(error);


    }


}