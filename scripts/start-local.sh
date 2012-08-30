#!/bin/sh -e

CWD=`dirname $0`
${CWD}/stop-local.sh

SOURCE_ROOT="${CWD}/.."

cd ${SOURCE_ROOT}/dist

APP_DIR=`ls -1 | grep -v .zip`

cd ${APP_DIR}

sh start 2>&1 1>/dev/null &

echo "Play server running..."
echo "To see logs; type: tail -f -n 10 ${SOURCE_ROOT}/dist/${APP_DIR}/logs/*.log"
echo "And then CTRL-C to exit log tailing."