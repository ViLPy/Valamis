#!/bin/bash

if [ $DEPLOYMENT_HOST ] ; then
    echo "Testing WAR deployment on $DEPLOYMENT_HOST..."
else
    echo "DEPLOYMENT_HOST is not defined."
    exit 1
fi

Checkpoints=(
    '/learn-demo-hook/css/test.css'
)


testWarDeployed() {
    max=5

    curl -s -L http://$DEPLOYMENT_HOST:8080$1 -f -o /dev/null
    curl_status=$?
    while [ $curl_status -gt 0 ] ; do
      max=`expr $max - 1`
      [ $max -lt 0 ] && break;
      sleep 5

      curl -s -L http://$DEPLOYMENT_HOST:8080$1 -f -o /dev/null
      curl_status=$?
    done

    if [ $curl_status -ne 0 ]; then
        global_status=1
        echo "curl status: $curl_status. Failed to download http://$DEPLOYMENT_HOST:8080$1"
    fi
}

global_status=0

for urlpath in ${Checkpoints[@]} ; do
    testWarDeployed $urlpath
done

if [ $global_status -ne 0 ]; then
    echo "WAR deployment failed."
    exit 1
fi

echo "WAR deployment successful."
exit 0

