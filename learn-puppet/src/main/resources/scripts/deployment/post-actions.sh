#!/bin/bash

if [ $DEPLOYMENT_REPO ] ; then
    echo "DEPLOYMENT_REPO is $DEPLOYMENT_REPO."
else
    echo "DEPLOYMENT_REPO is not defined."
    exit 1
fi

if [ $BUILD_ENV ] ; then
    echo "BUILD_ENV is $BUILD_ENV."
else
    echo "BUILD_ENV is not defined."
    exit 1
fi

# deploy the archive with scripts and puppet manifests to $DEPLOYMENT_REPO repo in Nexus
mvn org.apache.maven.plugins:maven-deploy-plugin:2.7:deploy-file \
-Durl=https://dev-1.arcusys.fi/mvn/content/repositories/${DEPLOYMENT_REPO} \
-DrepositoryId=${DEPLOYMENT_REPO} -Dfile=learn-assembly-B${SOURCE_BUILD_NUMBER}-SNAPSHOT.zip \
-Dfiles=${BUILD_ENV}.txt -Dtypes=txt -Dclassifiers=${BUILD_ENV}-notes \
-Dpackaging=zip \
-DgroupId=com.arcusys.learn -DartifactId=learn-assembly \
-Dversion=B${SOURCE_BUILD_NUMBER}-SNAPSHOT

# get rid of unneeded file
rm -f learn-assembly-B${SOURCE_BUILD_NUMBER}-SNAPSHOT.zip
