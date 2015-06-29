node "learn-development.novalocal" {
    include openntpd
    liferay-tomcat-bundle { 'liferay-tomcat-bundle' :
        liferay_root => "liferay-portal-6.2.0-ce-ga1",
        liferay_url => "http://kpoint.intra.arcusys.fi/downloads/liferay-portal-tomcat-6.2.0-ce-ga1-20131101192857659.zip",
        liferay_md5 => "ca92dbd28f9cc3e2f1951572be04684f",
        tomcat_version => "7.0.42"
     }
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