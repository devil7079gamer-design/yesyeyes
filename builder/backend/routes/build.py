from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session

from database.database import get_db
from database.models import Build
from schemas.build import BuildCreate, BuildResponse

router = APIRouter()


@router.post("/", response_model=BuildResponse)
def create_build(
    data: BuildCreate,
    db: Session = Depends(get_db)
):

    build = Build(
        user_id=data.user_id,
        app_name=data.app_name,
        website_url=str(data.website_url),
        package_name=data.package_name,
        status="completed",
        apk_file=f"builds/{data.app_name}.apk"
    )

    db.add(build)
    db.commit()
    db.refresh(build)

    return build


@router.get("/{build_id}", response_model=BuildResponse)
def get_build(
    build_id: int,
    db: Session = Depends(get_db)
):

    build = db.query(Build).filter(
        Build.id == build_id
    ).first()

    if not build:
        raise HTTPException(
            status_code=404,
            detail="Build not found"
        )

    return build