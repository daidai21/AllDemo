#!/usr/bin/env python3
# -*- coding:utf-8 -*-


# #############################################################################
# File Name   : app.py
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 四  4/15 01:34:48 2021
# #############################################################################



import time

import redis
from flask import Flask

app = Flask(__name__)
cache = redis.Redis(host='redis', port=6379)


def get_hit_count():
    retries = 5
    while True:
        try:
            return cache.incr('hits')
        except redis.exceptions.ConnectionError as exc:
            if retries == 0:
                raise exc
            retries -= 1
            time.sleep(0.5)


@app.route('/')
def hello():
    count = get_hit_count()
    return 'Hello World! I have been seen {} times.\n'.format(count)
