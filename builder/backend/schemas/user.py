from pydantic import BaseModel, EmailStr

from typing import Optional



class UserRegister(BaseModel):


    username: str


    email: EmailStr


    password: str





class UserLogin(BaseModel):


    email: EmailStr


    password: str





class UserResponse(BaseModel):


    id: int


    username: str


    email: str


    is_active: bool


    created_at: Optional[str] = None



    class Config:

        from_attributes = True