from pydantic import BaseModel

from typing import Optional



class BuildStatusResponse(BaseModel):


    build_id: int


    app_name: str


    status: str


    apk: Optional[str] = None



    class Config:

        from_attributes = True