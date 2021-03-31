#!/usr/bin/env python3
# -*- coding:utf-8 -*-


# #############################################################################
# File Name   : reader.py
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 三  3/31 11:49:59 2021
# #############################################################################



from person_pb2 import Person


def main():
    person = Person()
    with open("person.bin", "rb") as f:
        person.ParseFromString(f.read())
        print(person.id)
        print(person.age)
        print(person.name)


if __name__ == "__main__":
    main()
