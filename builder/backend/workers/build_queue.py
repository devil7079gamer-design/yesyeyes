from workers.update_status import (
    set_building,
    set_completed,
    set_failed
)


def add_build_job(
    build_id: int,
    app_name: str,
    website_url: str,
    package_name: str
):

    try:

        set_building(build_id)

        from workers.apk_builder import APKBuilder
        from workers.file_manager import FileManager

        builder = APKBuilder(
            build_id,
            app_name,
            website_url,
            package_name
        )

        builder.start()

        manager = FileManager(build_id)

        apk = manager.find_apk()

        if apk:
            set_completed(build_id, apk)
        else:
            set_failed(build_id)

    except Exception as e:

        print(e)

        set_failed(build_id)