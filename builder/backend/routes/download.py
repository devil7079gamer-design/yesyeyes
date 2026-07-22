from fastapi import APIRouter, HTTPException

from fastapi.responses import FileResponse


from workers.file_manager import FileManager


from schemas.download import DownloadResponse



router = APIRouter()




@router.get(

    "/{build_id}",

    response_model=DownloadResponse

)

def download_apk(

    build_id: int

):


    manager = FileManager(

        build_id

    )


    apk = manager.find_apk()



    if not apk:


        raise HTTPException(

            status_code=404,

            detail="APK not found"

        )



    return {


        "build_id": build_id,


        "file_name": "app.apk",


        "download_url": f"/api/download/file/{build_id}"


    }





@router.get(

    "/file/{build_id}"

)

def get_file(

    build_id: int

):


    manager = FileManager(

        build_id

    )


    apk = manager.find_apk()



    if not apk:


        raise HTTPException(

            status_code=404,

            detail="File not found"

        )



    return FileResponse(

        path=apk,

        filename="app.apk",

        media_type="application/vnd.android.package-archive"

    )