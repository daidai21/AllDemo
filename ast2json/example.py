#!/usr/bin/env python3
# -*- coding:utf-8 -*-

# #############################################################################
# File Name   : example.py
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 四  4/ 1 15:25:09 2021
# #############################################################################

import json
import ast
import ast2json

if __name__ == '__main__':
    # define
    func_def = \
"""
def add(x, y):
    return x + y

print(add(3, 5))
"""

    r_node = ast2json.ast2json(ast.parse(func_def))
    print(r_node)
    print(json.dumps(r_node, indent=4))
