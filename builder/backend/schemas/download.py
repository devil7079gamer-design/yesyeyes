from pydantic import BaseModel


class DownloadResponse(BaseModel):


    build_id: int


    file_name: str


    download_url: str