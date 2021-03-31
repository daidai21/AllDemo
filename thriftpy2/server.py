#!/usr/bin/env python3
# -*- coding:utf-8 -*-

# #############################################################################
# File Name   : server.py
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 三  3/31 14:57:59 2021
# #############################################################################

import thriftpy2

from thriftpy2.rpc import make_server


class Dispatcher(object):
    def ping(self):
        return "pong"


if __name__ == "__main__":
    pingpong_thrift = thriftpy2.load("pingpong.thrift",
                                     module_name="pingpong_thrift")

    server = make_server(pingpong_thrift.PingPong, Dispatcher(), '127.0.0.1',
                         6000)
    server.serve()
