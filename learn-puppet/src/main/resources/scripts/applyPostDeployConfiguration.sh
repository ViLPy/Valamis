#!/bin/sh

# expected to have variables:
# LIFERAY_TOMCAT_ROOT

if [ $LIFERAY_TOMCAT_ROOT ] ; then
    echo "LIFERAY_TOMCAT_ROOT is $LIFERAY_TOMCAT_ROOT."
else
    echo "LIFERAY_TOMCAT_ROOT is not defined."
    exit 1
fi
