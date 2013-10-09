node "learn-development.novalocal" {
    include openntpd
    liferay-tomcat-bundle { 'liferay-tomcat-bundle' :  }
}

node "learn-testing.novalocal" {
    include openntpd
    liferay-tomcat-bundle { 'liferay-tomcat-bundle' :  }
}

# staging env.
node "learn-staging.novalocal" {
    include openntpd
    liferay-tomcat-bundle { 'liferay-tomcat-bundle' :  }
}