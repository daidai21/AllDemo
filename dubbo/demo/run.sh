#!/usr/bin/env bash


# #############################################################################
# File Name   : run.sh
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 三  2/24 17:05:35 2021
# #############################################################################


# run zookeeper image
# exit zookeeper image


mvn package
java -cp target/demo-1.0-SNAPSHOT.jar com.example.demo.Consumer
java -cp target/demo-1.0-SNAPSHOT.jar com.example.demo.Provider
