#!/bin/bash

DST_HIERA="/etc/puppet/hieradata/"
ENV_VARIANTS="development testing staging production"

if [ $PM_HOST ] ; then
    echo "PM_HOST is $PM_HOST."
else
    echo "PM_HOST is not defined."
    exit 1
fi

if [ $SSH_USER ] ; then
    echo "SSH_USER is $SSH_USER."
else
    echo "SSH_USER is not defined."
    exit 1
fi

if [ $SRC_HIERA ] ; then
    echo "SRC_HIERA is $SRC_HIERA."
else
    echo "SRC_HIERA is not defined."
    exit 1
fi

if [ $PUPPET_ENV ] ; then
    IN_ARRAY=false
    for i in $ENV_VARIANTS; do
       if [ "$i" == "$PUPPET_ENV" ]; then
           IN_ARRAY=true
       fi
    done
    if [ ! $IN_ARRAY ]; then
        echo "PUPPET_ENV isn't a valid environment name."
        exit 1
    fi
    echo "PUPPET_ENV is $PUPPET_ENV."
else
    echo "PUPPET_ENV is not defined."
    exit 1
fi

ssh $SSH_USER@$PM_HOST "

if [ -d "${DST_HIERA}/${PUPPET_ENV}/public" ]; then
    sudo rm -rf "${DST_HIERA}/${PUPPET_ENV}/public"
fi
sudo mkdir -p "${DST_HIERA}/${PUPPET_ENV}/public"
sudo chown $SSH_USER "${DST_HIERA}/${PUPPET_ENV}/public"
# make sure that the private data for current env. is readable by puppet user
if [ -d "${DST_HIERA}/${PUPPET_ENV}/private" ]; then
    sudo chown -R puppet "${DST_HIERA}/${PUPPET_ENV}/private"
fi
"

rsync -r -e ssh "${SRC_HIERA}/${PUPPET_ENV}"/ $SSH_USER@$PM_HOST:"${DST_HIERA}/${PUPPET_ENV}/public/"
rsync -e ssh "${SRC_HIERA}/common.yaml" $SSH_USER@$PM_HOST:"${DST_HIERA}/${PUPPET_ENV}/public/"
