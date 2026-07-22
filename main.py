import os
import sys

BASE_DIR = os.path.join(
    os.path.dirname(__file__),
    "builder",
    "backend"
)

sys.path.insert(0, BASE_DIR)
os.chdir(BASE_DIR)

# Database
from database.database import Base, engine
from database import models

Base.metadata.create_all(bind=engine)

# FastAPI
import uvicorn

if __name__ == "__main__":
    uvicorn.run(
        "main:app",
        host="0.0.0.0",
        port=int(os.getenv("SERVER_PORT", "8000"))
    )