from database.database import SessionLocal

from database.models import Build



def update_build_status(

    build_id: int,

    status: str,

    apk_file: str = None

):


    db = SessionLocal()



    build = db.query(

        Build

    ).filter(

        Build.id == build_id

    ).first()



    if build:


        build.status = status



        if apk_file:


            build.apk_file = apk_file



        db.commit()



    db.close()





def set_queued(

    build_id: int

):


    update_build_status(

        build_id,

        "queued"

    )





def set_building(

    build_id: int

):


    update_build_status(

        build_id,

        "building"

    )





def set_completed(

    build_id: int,

    apk_file: str

):


    update_build_status(

        build_id,

        "completed",

        apk_file

    )





def set_failed(

    build_id: int

):


    update_build_status(

        build_id,

        "failed"

    )