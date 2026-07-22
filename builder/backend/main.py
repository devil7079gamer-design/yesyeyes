from fastapi import FastAPI

from fastapi.middleware.cors import CORSMiddleware


from routes import (

    build,

    download,

    admin,

    status,

    users

)


from auth import routes as auth_routes


from middleware.security import SecurityMiddleware




app = FastAPI(

    title="WebsiteToApp Builder API",

    version="1.0.0",

    description="Convert websites into Android apps automatically"

)



# Security Middleware

app.add_middleware(

    SecurityMiddleware

)




# CORS

app.add_middleware(

    CORSMiddleware,

    allow_origins=["*"],

    allow_credentials=True,

    allow_methods=["*"],

    allow_headers=["*"]

)





# =========================
# AUTH ROUTES
# =========================

app.include_router(

    auth_routes.router,

    prefix="/api/auth",

    tags=["Authentication"]

)





# =========================
# BUILD ROUTES
# =========================

app.include_router(

    build.router,

    prefix="/api/build",

    tags=["Build"]

)





# =========================
# STATUS ROUTES
# =========================

app.include_router(

    status.router,

    prefix="/api/status",

    tags=["Status"]

)





# =========================
# DOWNLOAD ROUTES
# =========================

app.include_router(

    download.router,

    prefix="/api/download",

    tags=["Download"]

)





# =========================
# USER ROUTES
# =========================

app.include_router(

    users.router,

    prefix="/api/users",

    tags=["Users"]

)





# =========================
# ADMIN ROUTES
# =========================

app.include_router(

    admin.router,

    prefix="/api/admin",

    tags=["Admin"]

)





# =========================
# HOME
# =========================

@app.get("/")

def home():

    return {

        "status": "online",

        "service": "WebsiteToApp Builder",

        "version": "1.0.0",

        "modules": [

            "Authentication",

            "APK Builder",

            "Build Queue",

            "Status Tracking",

            "Download System",

            "User Dashboard",

            "Admin Panel",

            "Security Layer"

        ]

    }