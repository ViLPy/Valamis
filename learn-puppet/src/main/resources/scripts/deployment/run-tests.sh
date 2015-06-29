#!/bin/bash

if [ $TEST_ENV ] ; then
    echo "TEST_ENV is $TEST_ENV."
else
    echo "TEST_ENV is not defined."
    exit 1
fi

if [ $TEST_SERVER ] ; then
    echo "TEST_SERVER is $TEST_SERVER."
else
    echo "TEST_SERVER is not defined."
    exit 1
fi

if [ $BUILD_ENV ] ; then
    echo "BUILD_ENV is $BUILD_ENV."
else
    echo "BUILD_ENV is not defined."
    exit 1
fi


mvn install -P integration.tests \
-Dtest.environment=${TEST_ENV} \
-Dtest.server=http://${TEST_SERVER}/wd/hub 2>&1 | tee ${BUILD_ENV}.log

egrep '^Tests run.*Time' ${BUILD_ENV}.log >> ${BUILD_ENV}.txt

