from fastapi import Request

from starlette.middleware.base import BaseHTTPMiddleware


class SecurityMiddleware(

    BaseHTTPMiddleware

):


    async def dispatch(

        self,

        request: Request,

        call_next

    ):


        response = await call_next(

            request

        )


        # Security Headers


        response.headers["X-Content-Type-Options"] = (

            "nosniff"

        )


        response.headers["X-Frame-Options"] = (

            "DENY"

        )


        response.headers["X-XSS-Protection"] = (

            "1; mode=block"

        )


        response.headers["Cache-Control"] = (

            "no-store"

        )


        return response