#!/usr/bin/env bash


# #############################################################################
# File Name   : bash_helper.sh
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 三  2/24 16:25:40 2021
# #############################################################################

# create project
mvn archetype:generate -DgroupId=com.example.demo -DartifactId=demo -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

mvn archetype:generate -DgroupId=com.example.demo -DartifactId=demo-consumer -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.example.demo -DartifactId=demo-provider -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.example.demo -DartifactId=demo-api -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
