#!/bin/sh

if [ $DEPLOYMENT_HOST ] ; then
    echo "Testing Liferay on $DEPLOYMENT_HOST."
else
    echo "DEPLOYMENT_HOST is not defined."
    exit 1
fi

# wait for Liferay to deploy packages
max=10
curl -L http://$DEPLOYMENT_HOST:8080/ -o /dev/null
curl_status=$?
while [ $curl_status -gt 0 ] ; do
  max=`expr $max - 1`
  [ $max -lt 0 ] && break;
  sleep 5

  curl -L http://$DEPLOYMENT_HOST:8080/ -o /dev/null
  curl_status=$?
done; [ $max -gt 0 ]

if [ $? -gt 0 ]; then
    echo "Liferay is not responding"
    exit 1
else
    echo "Liferay available."
fi

