#!/bin/sh

# expected to have variables:
# PACKAGE_NAME
# DEPLOYMENT_HOST
# SSH_USER
# LIFERAY_HOME
# SRC_ARC

if [ $SRC_ARC ] ; then
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
LIFERAY_TOMCAT_ROOT="$LIFERAY_HOME/tomcat-7.0.27"
export LIFERAY_TOMCAT_ROOT

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

if [ $LIFERAY_DEPLOY_DIR ] ; then
    echo "LIFERAY_DEPLOY_DIR is $LIFERAY_DEPLOY_DIR."
else
    echo "LIFERAY_DEPLOY_DIR is not defined."
    exit 1
fi

PATH=$PATH:/opt/csw/bin/
export PATH

scp $SRC_ARC $SSH_USER@$DEPLOYMENT_HOST:/tmp/$PACKAGE_NAME.zip &&

ssh $SSH_USER@$DEPLOYMENT_HOST "PATH=\$PATH:/opt/csw/bin/;

sudo rm -rf /tmp/learn-deploy/; sudo mkdir /tmp/learn-deploy/ &&

sudo unzip -o /tmp/$PACKAGE_NAME.zip -d /tmp/learn-deploy/ &&

sudo rm -f /tmp/$PACKAGE_NAME.zip &&

sudo puppet apply --trace -v --modulepath=/tmp/learn-deploy/modules/:/etc/puppet/modules/:/usr/share/puppet/modules/ /tmp/learn-deploy/learn-liferay.pp" #&&

#/bin/bash $PRGDIR/testLiferayAvailable.sh # &&

#ssh $SSH_USER@$DEPLOYMENT_HOST "PATH=\$PATH:/opt/csw/bin/; ENV=\`sudo puppet config print environment\` && sudo find /tmp/learn-deploy/licenses/\$ENV -type f -name 'license*.xml' | sudo xargs -I files cp files $LIFERAY_DEPLOY_DIR &&
#    sudo find /tmp/learn-deploy/files -type f -name '*.war' | sudo xargs -I files cp files $LIFERAY_DEPLOY_DIR && sudo ls -l $LIFERAY_DEPLOY_DIR" # &&

#/bin/bash $PRGDIR/testDeploymentFinished.sh &&

#scp $PRGDIR/applyPostDeployConfiguration.sh $SSH_USER@$DEPLOYMENT_HOST:/tmp/ &&

#ssh $SSH_USER@$DEPLOYMENT_HOST "PATH=\$PATH:/opt/csw/bin/; sudo LIFERAY_TOMCAT_ROOT=$LIFERAY_TOMCAT_ROOT /bin/bash /tmp/applyPostDeployConfiguration.sh"
