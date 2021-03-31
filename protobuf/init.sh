#!/usr/bin/env bash


# #############################################################################
# File Name   : init.sh
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 三  3/31 11:36:17 2021
# #############################################################################

set -ex


pip3 install protobuf

if [ "$(uname)" == "Darwin" ]; then
    echo "MacOS"
    brew install protobuf
elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
    echo "linux"
    sudo apt install protobuf-compiler
else
    echo "Err: not found OS version !"
fi
