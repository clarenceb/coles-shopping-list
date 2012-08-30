#!/bin/sh -e

SOURCE_ROOT="`dirname $0`/.."
PLAY_LOCATION=`which play`
UNZIP_LOCATION=`which unzip`

if [ -z "${PLAY_LOCATION}" ]; then
  echo "Missing Play Framework or not in your PATH!"
  exit 1;
fi

if [ -z "${UNZIP_LOCATION}" ]; then
  echo "Missing Unzip tool or not in your PATH!"
  exit 1;
fi

cd ${SOURCE_ROOT}

play clean dist

cd ${SOURCE_ROOT}/dist

unzip *.zip

echo "*** Application Deployed to `pwd`"
