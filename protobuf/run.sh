#!/usr/bin/env bash


# #############################################################################
# File Name   : run.sh
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 三  3/31 11:42:44 2021
# #############################################################################

# 生成.py文件
# person_pb2.py
protoc --proto_path=./ ./person.proto --python_out=./

# 
rm person.bin

# 
python3 writer.py

# 
python3 reader.py
