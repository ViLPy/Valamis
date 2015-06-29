#!/bin/bash

if [ $LIFERAY_HOME ] ; then
    echo "LIFERAY_HOME is $LIFERAY_HOME."
else
    echo "LIFERAY_HOME is not defined."
    exit 1
fi

if [ $LIFERAY_HOST ] ; then
    echo "LIFERAY_HOST is $LIFERAY_HOST."
else
    echo "LIFERAY_HOST is not defined."
    exit 1
fi

if [ $BUILD_ENV ] ; then
    echo "BUILD_ENV is $BUILD_ENV."
else
    echo "BUILD_ENV is not defined."
    exit 1
fi

# get Liferay's bundle
if [ $BUILD_ENV = "development" ]; then
    BUNDLE_URL="http://kpoint.intra.arcusys.fi/downloads/liferay-portal-tomcat-6.2.0-ce-ga1-20131101192857659.zip"
else
    BUNDLE_URL="http://kpoint.intra.arcusys.fi/downloads/liferay-portal-tomcat-6.1.1-ce-ga2-20120731132656558.zip"
fi
sudo rm -f liferay-portal-tomcat.zip
wget -q -c -O liferay-portal-tomcat.zip "$BUNDLE_URL"


# make sure that deployment host has the bundle
rsync -e ssh liferay-portal-tomcat.zip ${LIFERAY_HOST}:/tmp/liferay-portal-tomcat.zip

# deploy liferay with Puppet on a deployment host
SRC_ARC=learn-assembly-B${SOURCE_BUILD_NUMBER}-SNAPSHOT.zip \
PACKAGE_NAME=learn \
DEPLOYMENT_HOST=${LIFERAY_HOST} \
SSH_USER=ubuntu \
LIFERAY_HOME=${LIFERAY_HOME} \
sh /tmp/learn-B${SOURCE_BUILD_NUMBER}/scripts/applyPuppetRemote.sh

# save notes 
DEPLOYMENT_HOST=${LIFERAY_HOST} \
bash /tmp/learn-B${SOURCE_BUILD_NUMBER}/scripts/testLiferayAvailable.sh 2>&1 | tee -a ${BUILD_ENV}.txt

# deploy Liferay portlets
SRC_ARC=learn-assembly-B${SOURCE_BUILD_NUMBER}-SNAPSHOT.zip \
DEPLOYMENT_HOST=${LIFERAY_HOST} \
SSH_USER=ubuntu \
LIFERAY_HOME=${LIFERAY_HOME} \
sh /tmp/learn-B${SOURCE_BUILD_NUMBER}/scripts/deployFiles.sh

# check that war files were deployed successfully
DEPLOYMENT_HOST=${LIFERAY_HOST} \
bash /tmp/learn-B${SOURCE_BUILD_NUMBER}/scripts/testDeploymentFinished.sh 2>&1 | tee -a ${BUILD_ENV}.txt

