#!/bin/sh

# expected to have variables:
# PACKAGE_NAME
# DEPLOYMENT_HOST
# SSH_USER
# SRC_ARC
#
# an optional variable:
# LIFERAY_HOME

PROJECT="learn"

if [ $SRC_ARC ] ; then
    echo "SRC_ARC is $SRC_ARC."
else
    echo "SRC_ARC is not defined."
    exit 1
fi

PRGDIR=`dirname "$0"`

if [ $LIFERAY_HOME ] ; then
    echo "LIFERAY_HOME is $LIFERAY_HOME."

    LIFERAY_DEPLOY_DIR="$LIFERAY_HOME/deploy/"
    export LIFERAY_DEPLOY_DIR
    LIFERAY_TOMCAT_ROOT="$LIFERAY_HOME/tomcat-7.0.27"
    export LIFERAY_TOMCAT_ROOT

    echo "LIFERAY_DEPLOY_DIR is $LIFERAY_DEPLOY_DIR."
else
    echo "WARNING: LIFERAY_HOME is not defined."
fi

if [ $PACKAGE_NAME ] ; then
    echo "PACKAGE_NAME is $PACKAGE_NAME."
else
    echo "PACKAGE_NAME is not defined."
    exit 1
fi

if [ $DEPLOYMENT_HOST ] ; then
    echo "DEPLOYMENT_HOST is $DEPLOYMENT_HOST."
else
    echo "DEPLOYMENT_HOST is not defined."
    exit 1
fi

if [ $SSH_USER ] ; then
    echo "SSH_USER is $SSH_USER."
else
    echo "SSH_USER is not defined."
    exit 1
fi

if [ $# -eq 1 ]; then
    MANIFEST="$1"
else
    MANIFEST="manifests/site.pp"
fi

PATH=$PATH:/opt/csw/bin/
export PATH

# if we deploy Liferay, archive with EE licenses should be copied to the target machine first.
if [ $LIFERAY_HOME ]; then
    scp $SRC_ARC $SSH_USER@$DEPLOYMENT_HOST:/tmp/$PACKAGE_NAME.zip &&

    ssh $SSH_USER@$DEPLOYMENT_HOST "

        sudo rm -rf /tmp/$PROJECT-deploy/; sudo mkdir /tmp/$PROJECT-deploy/ &&

        sudo rm -f /tmp/$PACKAGE_NAME.zip &&

        sudo puppet agent -v --onetime --no-daemonize 
    "
    if [ $? -ne 0 ]; then
        echo "Puppet run failure on $DEPLOYMENT_HOST"
        exit 1
    fi
else
    ssh $SSH_USER@$DEPLOYMENT_HOST  "sudo puppet agent -v --onetime --no-daemonize"
    if [ $? -ne 0 ]; then
        echo "Puppet run failure on $DEPLOYMENT_HOST"
        exit 1
    fi
fi

