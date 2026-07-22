import os
from dotenv import load_dotenv


load_dotenv()


class Settings:


    APP_NAME = "WebsiteToApp Builder"


    DATABASE_URL = os.getenv(

        "DATABASE_URL",

        "sqlite:///builder.db"

    )


    REDIS_URL = os.getenv(

        "REDIS_URL",

        "redis://localhost:6379/0"

    )


    SECRET_KEY = os.getenv(

        "SECRET_KEY",

        "change-this-secret"

    )


    BUILD_FOLDER = os.getenv(

        "BUILD_FOLDER",

        "./builds"

    )


    TEMPLATE_FOLDER = os.getenv(

        "TEMPLATE_FOLDER",

        "../android-template"

    )


    MAX_BUILD_TIME = 1800


settings = Settings()