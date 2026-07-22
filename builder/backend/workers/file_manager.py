import os
import shutil

from config import settings



class FileManager:


    def __init__(

        self,

        build_id

    ):


        self.build_folder = os.path.join(

            settings.BUILD_FOLDER,

            str(build_id)

        )




    def find_apk(self):


        for root, dirs, files in os.walk(

            self.build_folder

        ):


            for file in files:


                if file.endswith(

                    ".apk"

                ):


                    return os.path.join(

                        root,

                        file

                    )


        return None





    def move_apk(

        self,

        apk_path

    ):


        output_folder = os.path.join(

            settings.BUILD_FOLDER,

            "downloads"

        )


        os.makedirs(

            output_folder,

            exist_ok=True

        )


        destination = os.path.join(

            output_folder,

            os.path.basename(

                apk_path

            )

        )


        shutil.copy(

            apk_path,

            destination

        )


        return destination




    def delete_build(self):


        if os.path.exists(

            self.build_folder

        ):


            shutil.rmtree(

                self.build_folder

            )