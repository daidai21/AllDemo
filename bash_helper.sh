#!/usr/bin/env bash


# #############################################################################
# File Name   : bash_helper.sh
# Author      : DaiDai
# Mail        : daidai4269@aliyun.com
# Created Time: 三  2/24 16:25:40 2021
# #############################################################################

# create project

mvn archetype:generate -DgroupId=com.example.demo -DartifactId=httpclient -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false



mvn archetype:generate -DgroupId=com.example.demo -DartifactId=okhttp -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false


mvn archetype:generate -DgroupId=com.example.demo -DartifactId=xstream -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false


mvn archetype:generate -DgroupId=com.example.demo -DartifactId=asm -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false


mvn archetype:generate -DgroupId=com.example.demo -DartifactId=commons-beanutils -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false



mvn archetype:generate -DgroupId=com.example.demo -DartifactId=commons-codec -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

mvn archetype:generate -DgroupId=com.example.demo -DartifactId=commons-logging -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false



mvn archetype:generate -DgroupId=com.example.demo -DartifactId=commons-collections -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false


mvn archetype:generate -DgroupId=com.example.demo -DartifactId=commons-io -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

mvn archetype:generate -DgroupId=com.example.demo -DartifactId=dubbo -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
