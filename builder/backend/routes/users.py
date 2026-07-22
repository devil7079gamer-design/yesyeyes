from fastapi import APIRouter, Depends, HTTPException

from sqlalchemy.orm import Session


from database.database import get_db

from database.models import User, Build


from auth.dependencies import get_current_user



router = APIRouter()




@router.get("/me")

def my_profile(

    current_user = Depends(get_current_user),

    db: Session = Depends(get_db)

):


    user_id = current_user.get(

        "user_id"

    )



    user = db.query(

        User

    ).filter(

        User.id == user_id

    ).first()



    if not user:


        raise HTTPException(

            status_code=404,

            detail="User not found"

        )



    return {

        "id": user.id,

        "username": user.username,

        "email": user.email,

        "created_at": user.created_at

    }





@router.get("/me/builds")

def my_builds(

    current_user = Depends(get_current_user),

    db: Session = Depends(get_db)

):


    user_id = current_user.get(

        "user_id"

    )



    builds = db.query(

        Build

    ).filter(

        Build.user_id == user_id

    ).all()



    return [

        {

            "id": build.id,

            "app_name": build.app_name,

            "status": build.status,

            "apk": build.apk_file

        }

        for build in builds

    ]