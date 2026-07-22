import os
import shutil
import subprocess

from config import settings



class APKBuilder:


    def __init__(

        self,

        build_id,

        app_name,

        website_url,

        package_name

    ):


        self.build_id = build_id

        self.app_name = app_name

        self.website_url = website_url

        self.package_name = package_name


        self.output = os.path.join(

            settings.BUILD_FOLDER,

            str(build_id)

        )




    def prepare_folder(self):


        if os.path.exists(

            self.output

        ):

            shutil.rmtree(

                self.output

            )


        shutil.copytree(

            settings.TEMPLATE_FOLDER,

            self.output

        )




    def replace_values(self):


        files = [

            "app/src/main/assets/config.json",

            "app/build.gradle",

            "app/src/main/res/values/strings.xml"

        ]


        for file in files:


            path = os.path.join(

                self.output,

                file

            )


            if os.path.exists(path):


                data = open(

                    path,

                    "r",

                    encoding="utf-8"

                ).read()



                data = data.replace(

                    "__APP_NAME__",

                    self.app_name

                )


                data = data.replace(

                    "__WEBSITE_URL__",

                    self.website_url

                )


                data = data.replace(

                    "__PACKAGE_NAME__",

                    self.package_name

                )


                open(

                    path,

                    "w",

                    encoding="utf-8"

                ).write(

                    data

                )




    def build(self):


        subprocess.run(

            [

                "./gradlew",

                "assembleRelease"

            ],

            cwd=self.output,

            check=True

        )




    def start(self):


        self.prepare_folder()

        self.replace_values()

        self.build()


        return "APK Generated"