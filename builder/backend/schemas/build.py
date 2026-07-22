from pydantic import BaseModel, HttpUrl

from typing import Optional



class BuildCreate(BaseModel):


    user_id: int


    app_name: str


    website_url: HttpUrl


    package_name: str





class BuildResponse(BaseModel):


    id: int


    app_name: str


    website_url: str


    package_name: str


    status: str


    apk_file: Optional[str] = None



    class Config:

        from_attributes = True