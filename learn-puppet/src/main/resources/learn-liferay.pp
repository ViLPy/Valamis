# liferay in a testing environment
node default {
  liferay-tomcat-bundle { 'liferay-tomcat-bundle' :
  	liferay_url => "http://liferay-mirror/liferay-ce/liferay-portal-tomcat-6.1.1-ce-ga2-20120731132656558.zip",
  	liferay_root => "liferay-portal-6.1.0-ce-ga1",
  	liferay_md5 => "084457917710262cff566fd69f91b680",
    tomcat_version => "7.0.23",
  }
}

node 'dhcp-10-93-87-89' {
  liferay-tomcat-bundle { 'liferay-tomcat-bundle' :
  	liferay_url => "http://liferay-mirror/liferay-ce/liferay-portal-tomcat-6.1.1-ce-ga2-20120731132656558.zip",
  	liferay_root => "liferay-portal-6.1.0-ce-ga1",
  	liferay_md5 => "084457917710262cff566fd69f91b680",
    tomcat_version => "7.0.23",
  }

}
