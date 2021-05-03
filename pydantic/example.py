#!/usr/bin/env python3
# -*- coding:utf-8 -*-

# #############################################################################
# File Name   : example.py
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 一  5/ 3 23:59:01 2021
# #############################################################################

from datetime import datetime
from typing import List, Optional
from pydantic import BaseModel


class User(BaseModel):
    id: int
    name = 'John Doe'
    signup_ts: Optional[datetime] = None
    friends: List[int] = []


if __name__ == '__main__':
    external_data = {
        'id': '123',
        'signup_ts': '2017-06-01 12:22',
        'friends': [1, '2', b'3']
    }
    user = User(**external_data)
    print(user)
    print(type(user))
    print(user.id)
