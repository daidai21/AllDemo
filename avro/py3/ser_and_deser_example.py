#!/usr/bin/env python3
# -*- coding:utf-8 -*-

# #############################################################################
# File Name   : ser_and_deser_example.py
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 二  4/13 15:36:15 2021
# #############################################################################

import avro.schema
from avro.datafile import DataFileReader, DataFileWriter
from avro.io import DatumReader, DatumWriter

# load define of data tranform type
schema = avro.schema.parse(open("user.avsc", "rb").read())

# Serializing
writer = DataFileWriter(open("users.avro", "wb"), DatumWriter(), schema)
writer.append({"name": "Alyssa", "favorite_number": 256})
writer.append({"name": "Ben", "favorite_number": 7, "favorite_color": "red"})
writer.close()

# deserializing
reader = DataFileReader(open("users.avro", "rb"), DatumReader())
for user in reader:
    print(user, type(user))
reader.close()
