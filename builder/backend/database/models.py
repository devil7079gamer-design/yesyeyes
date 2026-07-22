from sqlalchemy import Column, Integer, String, DateTime, Boolean
from datetime import datetime

from database.database import Base


class User(Base):

    __tablename__ = "users"


    id = Column(

        Integer,

        primary_key=True,

        index=True

    )


    username = Column(

        String,

        unique=True,

        index=True

    )


    email = Column(

        String,

        unique=True,

        index=True

    )


    password = Column(

        String

    )


    is_active = Column(

        Boolean,

        default=True

    )


    created_at = Column(

        DateTime,

        default=datetime.utcnow

    )




class Build(Base):

    __tablename__ = "builds"


    id = Column(

        Integer,

        primary_key=True,

        index=True

    )


    user_id = Column(

        Integer

    )


    app_name = Column(

        String

    )


    website_url = Column(

        String

    )


    package_name = Column(

        String

    )


    status = Column(

        String,

        default="pending"

    )


    apk_file = Column(

        String,

        nullable=True

    )


    created_at = Column(

        DateTime,

        default=datetime.utcnow

    )