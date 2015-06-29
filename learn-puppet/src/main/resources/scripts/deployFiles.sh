#!/bin/sh

# expected to have variables:
# DEPLOYMENT_HOST
# SSH_USER
# LIFERAY_HOME
# SRC_ARC

if [ -f $SRC_ARC ] ; then
    echo "SRC_ARC is $SRC_ARC."
else
    echo "SRC_ARC is not defined."
    exit 1
fi

PRGDIR=`dirname "$0"`

if [ $LIFERAY_HOME ] ; then
    echo "LIFERAY_HOME is $LIFERAY_HOME."
else
    echo "LIFERAY_HOME is not defined."
    exit 1
fi

LIFERAY_DEPLOY_DIR="$LIFERAY_HOME/deploy/"
export LIFERAY_DEPLOY_DIR

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

if [ $LIFERAY_DEPLOY_DIR ] ; then
    echo "LIFERAY_DEPLOY_DIR is $LIFERAY_DEPLOY_DIR."
else
    echo "LIFERAY_DEPLOY_DIR is not defined."
    exit 1
fi

scp $SRC_ARC $SSH_USER@$DEPLOYMENT_HOST:/tmp/ &&

ssh $SSH_USER@$DEPLOYMENT_HOST "
    sudo rm -rf /tmp/deploy-files/; sudo mkdir /tmp/deploy-files/ &&

    sudo unzip -o "/tmp/`basename $SRC_ARC`" -d /tmp/deploy-files/ *.war &&

    sudo rm -f "/tmp/`basename $SRC_ARC`" &&

    sudo find /tmp/deploy-files -type f -name '*.war' | sudo xargs -I files sudo -u liferay cp files $LIFERAY_DEPLOY_DIR && sudo ls -l $LIFERAY_DEPLOY_DIR
"
