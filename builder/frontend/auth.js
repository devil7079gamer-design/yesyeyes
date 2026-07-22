const API_URL = "http://YOUR_SERVER_IP:8000";



async function register() {


    const username =

        document.getElementById(

            "username"

        ).value;



    const email =

        document.getElementById(

            "email"

        ).value;



    const password =

        document.getElementById(

            "password"

        ).value;



    const result =

        document.getElementById(

            "result"

        );



    try {


        const response =

            await fetch(

                API_URL + "/api/auth/register",

                {

                    method: "POST",

                    headers: {

                        "Content-Type":

                        "application/json"

                    },

                    body: JSON.stringify({

                        username,

                        email,

                        password

                    })

                }

            );



        const data =

            await response.json();



        result.innerHTML =

            data.message ||

            "Account created";


    }


    catch(error) {


        result.innerHTML =

            "Registration failed";


        console.log(error);


    }


}





async function login() {


    const email =

        document.getElementById(

            "email"

        ).value;



    const password =

        document.getElementById(

            "password"

        ).value;



    const result =

        document.getElementById(

            "result"

        );



    try {


        const response =

            await fetch(

                API_URL + "/api/auth/login",

                {

                    method: "POST",

                    headers: {

                        "Content-Type":

                        "application/json"

                    },

                    body: JSON.stringify({

                        email,

                        password

                    })

                }

            );



        const data =

            await response.json();



        if(data.token){


            localStorage.setItem(

                "token",

                data.token

            );


            window.location.href =

                "dashboard.html";


        }

        else {


            result.innerHTML =

                data.detail;


        }



    }


    catch(error) {


        result.innerHTML =

            "Login failed";


        console.log(error);


    }


}