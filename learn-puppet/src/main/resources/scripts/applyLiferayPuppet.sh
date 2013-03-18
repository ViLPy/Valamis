#!/bin/bash

puppet apply -v  --modulepath=/tmp/maakportal/modules/:/etc/puppet/modules/:/usr/share/puppet/modules/ /tmp/maakportal/maakportal.pp
