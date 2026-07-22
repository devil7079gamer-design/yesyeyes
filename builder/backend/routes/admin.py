from fastapi import APIRouter, Depends

from sqlalchemy.orm import Session


from database.database import get_db

from database.models import User, Build


from schemas.admin import (

    AdminUserResponse,

    AdminBuildResponse

)



router = APIRouter()




@router.get(

    "/users",

    response_model=list[AdminUserResponse]

)

def all_users(

    db: Session = Depends(get_db)

):


    users = db.query(

        User

    ).all()



    return [

        {

            "id": user.id,

            "username": user.username,

            "email": user.email,

            "active": user.is_active

        }

        for user in users

    ]





@router.get(

    "/builds",

    response_model=list[AdminBuildResponse]

)

def all_builds(

    db: Session = Depends(get_db)

):


    builds = db.query(

        Build

    ).all()



    return [

        {

            "id": build.id,

            "user_id": build.user_id,

            "app_name": build.app_name,

            "website_url": build.website_url,

            "status": build.status,

            "apk": build.apk_file

        }

        for build in builds

    ]