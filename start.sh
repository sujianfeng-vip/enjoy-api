#!/usr/bin/env bash

ps aux | grep gradle | grep -v grep | awk '{print $2}' | xargs kill -9
echo "已清除遗留的gradle进程"

ps aux | grep java | grep -v grep | awk '{print $2}' | xargs kill -9
echo "已清除遗留的java进程"


pidFile="./output/tmp.pid"
pid=$(cat ${pidFile})
kill -9 ${pid}
#read -p "this process closed: PID=${pid}. pls press any key to continue..." ok
nohup java -jar -Xms512m -Xmx2048m ./output/jars/80_web-1.0.0-SNAPSHOT.jar --spring.profiles.active=$ENV_CODE   >/dev/null &
echo $! > ${pidFile}
echo "this process is startd: PID=${pid}"
#read -p  "pls press any key to continue..." ok
today=`date +%Y-%m-%d`
tail -f ./logs/hougu-bi.38181.${today}.log

