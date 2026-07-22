from fastapi import APIRouter, Depends, HTTPException

from sqlalchemy.orm import Session


from database.database import get_db

from database.models import User


from auth.security import (

    hash_password,

    verify_password,

    create_token

)


from schemas.user import (

    UserRegister,

    UserLogin

)



router = APIRouter()





@router.post("/register")

def register(

    data: UserRegister,

    db: Session = Depends(get_db)

):


    user_exist = db.query(User).filter(

        User.email == data.email

    ).first()



    if user_exist:


        raise HTTPException(

            status_code=400,

            detail="Email already registered"

        )



    user = User(

        username=data.username,

        email=data.email,

        password=hash_password(

            data.password

        )

    )



    db.add(user)

    db.commit()

    db.refresh(user)



    return {

        "message": "Registration successful",

        "user_id": user.id

    }





@router.post("/login")

def login(

    data: UserLogin,

    db: Session = Depends(get_db)

):


    user = db.query(User).filter(

        User.email == data.email

    ).first()



    if not user:


        raise HTTPException(

            status_code=404,

            detail="Account not found"

        )



    if not verify_password(

        data.password,

        user.password

    ):


        raise HTTPException(

            status_code=401,

            detail="Invalid password"

        )



    token = create_token({

        "user_id": user.id,

        "username": user.username,

        "email": user.email

    })



    return {

        "message": "Login successful",

        "token": token,

        "user": {

            "id": user.id,

            "username": user.username,

            "email": user.email

        }

    }