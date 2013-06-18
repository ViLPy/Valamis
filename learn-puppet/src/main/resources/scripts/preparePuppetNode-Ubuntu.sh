#!/bin/bash

apt-get -y update
apt-get -y install openjdk-7-jre postgresql-9.1 rubygems puppet
gem install hiera hiera-puppet
cp -a /var/lib/gems/1.8/gems/hiera-puppet-1.0.0 /etc/puppet/modules
mkdir /etc/puppet/hieradata
cp common.yaml /etc/puppet/hieradata/
cp hiera.yaml /etc/puppet/
