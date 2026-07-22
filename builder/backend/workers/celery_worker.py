from workers.build_queue import celery


if __name__ == "__main__":

    celery.worker_main(

        [

            "worker",

            "--loglevel=info"

        ]

    )