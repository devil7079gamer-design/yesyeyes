from fastapi import APIRouter, HTTPException, Depends

from sqlalchemy.orm import Session


from database.database import get_db

from database.models import Build


from schemas.status import BuildStatusResponse



router = APIRouter()




@router.get(

    "/{build_id}",

    response_model=BuildStatusResponse

)

def check_status(

    build_id: int,

    db: Session = Depends(get_db)

):


    build = db.query(

        Build

    ).filter(

        Build.id == build_id

    ).first()



    if not build:


        raise HTTPException(

            status_code=404,

            detail="Build not found"

        )



    return {

        "build_id": build.id,

        "app_name": build.app_name,

        "status": build.status,

        "apk": build.apk_file

    }