import os
import shutil
import json
import re


class BuilderReplaceEngine:

    def __init__(self, template_path, output_path, config_file):
        self.template_path = template_path
        self.output_path = output_path
        self.config_file = config_file


    # Load user settings
    def load_config(self):

        with open(self.config_file, "r", encoding="utf-8") as file:
            self.config = json.load(file)


    # Copy Android template
    def copy_template(self):

        if os.path.exists(self.output_path):
            shutil.rmtree(self.output_path)

        shutil.copytree(
            self.template_path,
            self.output_path
        )


    # Replace text in files
    def replace_text(self):

        replacements = {

            "OLD_APP_NAME":
                self.config["app_name"],

            "OLD_PACKAGE":
                self.config["package_name"],

            "OLD_URL":
                self.config["website_url"]
        }


        for root, dirs, files in os.walk(self.output_path):

            for file in files:

                path = os.path.join(root, file)

                try:

                    with open(
                        path,
                        "r",
                        encoding="utf-8"
                    ) as f:

                        data = f.read()


                    old_data = data


                    for old, new in replacements.items():

                        data = data.replace(
                            old,
                            new
                        )


                    if data != old_data:

                        with open(
                            path,
                            "w",
                            encoding="utf-8"
                        ) as f:

                            f.write(data)


                except:

                    pass



    # Change Android package folders
    def replace_package(self):

        old_package = "com.template.app"

        new_package = self.config["package_name"]


        old_path = old_package.replace(
            ".",
            "/"
        )


        new_path = new_package.replace(
            ".",
            "/"
        )


        for root, dirs, files in os.walk(
            self.output_path
        ):

            for folder in dirs:

                if folder == old_path:

                    src = os.path.join(
                        root,
                        folder
                    )

                    dst = os.path.join(
                        root,
                        new_path
                    )

                    shutil.move(
                        src,
                        dst
                    )



    # Replace app icon
    def replace_icon(self):

        icon_source = self.config["icon"]


        icon_locations = [

            "app/src/main/res/mipmap-hdpi",
            "app/src/main/res/mipmap-mdpi",
            "app/src/main/res/mipmap-xhdpi",
            "app/src/main/res/mipmap-xxhdpi",
            "app/src/main/res/mipmap-xxxhdpi"

        ]


        for folder in icon_locations:

            path = os.path.join(
                self.output_path,
                folder
            )


            if os.path.exists(path):

                shutil.copy(
                    icon_source,
                    os.path.join(
                        path,
                        "ic_launcher.png"
                    )
                )



    # Run complete engine
    def build(self):

        print("Starting Builder Engine...")


        self.load_config()

        print("Config Loaded")


        self.copy_template()

        print("Template Copied")


        self.replace_text()

        print("Text Replaced")


        self.replace_package()

        print("Package Updated")


        self.replace_icon()

        print("Icon Updated")


        print("Builder Ready!")



if __name__ == "__main__":


    builder = BuilderReplaceEngine(

        template_path="templates/android-project",

        output_path="output/generated-app",

        config_file="input/config.json"

    )


    builder.build()
