#!/usr/bin/env python3
# -*- coding:utf-8 -*-


# #############################################################################
# File Name   : writer.py
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 三  3/31 11:49:52 2021
# #############################################################################

from person_pb2 import Person

def main():
    person = Person()
    person.id = 1
    person.age = 18
    person.name = "Jerry"

    with open("person.bin", "wb") as f:
        print(person.SerializeToString())
        f.write(person.SerializeToString())

if __name__ == "__main__":
    main()
