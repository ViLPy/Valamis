#!/bin/bash

mkdir /etc/puppet/hieradata
cp common.yaml /etc/puppet/hieradata/
chmod 0600 /etc/puppet/hieradata/common.yaml
cp hiera.yaml /etc/puppet/
