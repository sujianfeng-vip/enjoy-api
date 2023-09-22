#!/usr/bin/env bash
source /etc/profile

ps aux | grep gradle | grep -v grep | awk '{print $2}' | xargs kill -9
echo "已清除遗留的gradle进程"

ps aux | grep java | grep -v grep | awk '{print $2}' | xargs kill -9
echo "已清除遗留的java进程"

git reset --hard
git pull
gradle clean
gradle build -x test

sh start.sh

