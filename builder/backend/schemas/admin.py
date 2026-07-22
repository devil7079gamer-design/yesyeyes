from pydantic import BaseModel

from typing import Optional



class AdminUserResponse(BaseModel):


    id: int


    username: str


    email: str


    active: bool



    class Config:

        from_attributes = True





class AdminBuildResponse(BaseModel):


    id: int


    user_id: int


    app_name: str


    website_url: str


    status: str


    apk: Optional[str] = None



    class Config:

        from_attributes = True