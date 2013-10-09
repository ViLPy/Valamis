#!/bin/bash

# Expected to have variables:
# DEPLOYMENT_HOST
# SSH_USER
# PM_ENV
# SRC_ARC

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

if [ $PM_ENV ] ; then
    echo "PM_ENV is $PM_ENV."
else
    echo "PM_ENV is not defined."
    exit 1
fi

if [ $SRC_ARC ] ; then
    echo "SRC_ARC is $SRC_ARC."
else
    echo "SRC_ARC is not defined."
    exit 1
fi

ENV_DIR='/etc/puppet/environments/'

echo "Copying \"$PM_ENV\" data to $ENV_DIR on Puppet Master ($DEPLOYMENT_HOST)..."

rsync -e ssh ${SRC_ARC} $SSH_USER@$DEPLOYMENT_HOST:/tmp
SRC_ARC=`basename ${SRC_ARC}`


ssh $SSH_USER@$DEPLOYMENT_HOST "
if [ -d "${ENV_DIR}${PM_ENV}" ]; then
    sudo rm -rf "${ENV_DIR}${PM_ENV}/*"
else
    sudo mkdir -p "${ENV_DIR}${PM_ENV}"
fi &&
sudo unzip -q -d "${ENV_DIR}${PM_ENV}" "/tmp/${SRC_ARC}" &&
sudo chown -R root:root "${ENV_DIR}" &&
rm -f "/tmp/${SRC_ARC}""
