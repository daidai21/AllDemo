#!/usr/bin/env python3
# -*- coding:utf-8 -*-

# #############################################################################
# File Name   : client.py
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 三  3/31 14:58:05 2021
# #############################################################################

import thriftpy2

from thriftpy2.rpc import make_client

if __name__ == "__main__":
    pingpong_thrift = thriftpy2.load("pingpong.thrift",
                                     module_name="pingpong_thrift")
    client = make_client(pingpong_thrift.PingPong, '127.0.0.1', 6000)
    print(client.ping())
