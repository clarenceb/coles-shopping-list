#!/bin/sh -e

EXISTING_SERVER_PID=`ps -ef | grep "play\.core\.server\.NettyServer" | awk '{ print $2 }'`

if [ ! -z "${EXISTING_SERVER_PID}" ]; then
  echo "Terminating existing Play server (PID: ${EXISTING_SERVER_PID})"
  kill -1 ${EXISTING_SERVER_PID}
fi
