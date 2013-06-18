#!/bin/sh

if [ $DEPLOYMENT_HOST ] ; then
    echo "Testing deployment on $DEPLOYMENT_HOST."
else
    echo "DEPLOYMENT_HOST is not defined."
    exit 1
fi


testLiferayThemeDeployed() {
	max=10;

	curl -L http://$DEPLOYMENT_HOST:8080/liferay-theme/js/main.js -f -o /dev/null
	curl_status=$?
	while [ $curl_status -gt 0 ] ; do
	  let max=max-1;
	  [ $max -lt 0 ] && break;
	  sleep 5

	  curl -L http://$DEPLOYMENT_HOST:8080/liferay-theme/js/main.js -f -o /dev/null
	  curl_status=$?
	done; [ $max -gt 0 ]

	return $curl_status;
}


testLiferayServicesDeployed() {
	max=15;

#TODO: add more reasonable testing here
	curl -L http://$DEPLOYMENT_HOST:8080/web/guest/ > /dev/null
	curl_status=$?
	while [ $curl_status -gt 0 ] ; do
	  let max=max-1;
	  [ $max -lt 0 ] && break;
	  sleep 5

	  curl -L http://$DEPLOYMENT_HOST:8080/web/guest/ > /dev/null
	  curl_status=$?
	done; [ $max -gt 0 ]	

	return $curl_status;
}


# wait for Liferay to deploy theme package
testLiferayThemeDeployed
if [ $? -gt 0 ]; then
    echo "Theme deployment failed."
    exit 1
fi

# wait for Liferay to deploy all services
testLiferayServicesDeployed
if [ $? -gt 0 ]; then
    echo "Service deployment failed."
    exit 1
fi

echo "Deployment successful"



