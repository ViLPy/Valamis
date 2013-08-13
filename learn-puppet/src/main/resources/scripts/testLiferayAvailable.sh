#!/bin/sh

if [ $PORTAL ]; then
    echo "PORTAL is $PORTAL"
else
    PORTAL="Liferay"
fi

if [ $DEPLOYMENT_HOST ] ; then
    echo "Testing $PORTAL on $DEPLOYMENT_HOST..."
else
    echo "DEPLOYMENT_HOST is not defined."
    exit 1
fi

# wait for $PORTAL to deploy packages
max=10
curl -s -L http://$DEPLOYMENT_HOST:8080/ -o /dev/null
curl_status=$?
while [ $curl_status -gt 0 ] ; do
  max=`expr $max - 1`
  [ $max -lt 0 ] && break;
  sleep 5

  curl -s -L http://$DEPLOYMENT_HOST:8080/ -o /dev/null
  curl_status=$?
done

if [ $max -lt 0 ]; then
    echo "curl status: $curl_status. $PORTAL is not responding."
    exit 1
else
    echo "$PORTAL available."
fi

