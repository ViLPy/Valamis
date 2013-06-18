define liferay-tomcat-bundle (
  $liferay_target = "/opt",
  $liferay_user = "liferay",
  $liferay_root = "liferay-portal-6.1.1-ce-ga2",
  $liferay_url = "http://freefr.dl.sourceforge.net/project/lportal/Liferay%20Portal/6.1.1%20GA2/liferay-portal-tomcat-6.1.1-ce-ga
2-20120731132656558.zip",
  $liferay_md5 = "36d9b6f3f2e13031e2d75a4b987d541a",
  $tomcat_version = "7.0.27",
  $jvmroute = undef,
  $ehcache = undef,
  $ehcache_node = undef,
  $ehcache_ini_host = undef,
) {
  $liferay_home = "${liferay_target}/${liferay_root}"

  Exec { path => [ "/bin/", "/sbin/" , "/usr/bin/", "/usr/sbin/", "/opt/csw/bin/" ] }

  group { "${liferay_user}":
    ensure => present,
#    gid => 111
  }
  user { "${liferay_user}":
    ensure => present,
    gid => "${liferay_user}",
    membership => minimum,
    shell => "/bin/bash",  
    require => Group["${liferay_user}"]
  }

  archive{ "liferay-portal-tomcat":
    ensure => present,
    url         => $liferay_url,
    target      => $liferay_target,
    root_dir => $liferay_root,
    checksum => true,
    timeout => 600,
    digest_string => $liferay_md5,
    extension => "zip",
  }

  file { $liferay_home :
    ensure  => directory,
    mode => 644,
    require => Archive["liferay-portal-tomcat"],
  }

  # change owner for liferay's directory
  exec { "chown -R ${liferay_user}:${liferay_user} ${liferay_home}" :
    unless => "sudo -u ${liferay_user} test -O ${liferay_home}",
    require => [Archive["liferay-portal-tomcat"], User["${liferay_user}"]],
  }

  $liferay_service_name = "liferay-portal"

  $setenv = []

  liferay-tomcat{ $liferay_service_name :
    require => [ File[$liferay_home] ],
    tomcat_version => $tomcat_version,
    liferay_home => $liferay_home,
    liferay_service_name => $liferay_service_name,
    liferay_user => $liferay_user,
    liferay_group => $liferay_user,
    setenv => $setenv,
    ehcache_conf => $ehcache,
  }

  case $::operatingsystem {
  # issue with openjdk-7 and Liferay's image preview in Ubuntu package
    Ubuntu: {
      package { 'openjdk-6-jre-headless':
            ensure => 'installed',
            require => Package['openjdk-7-jre-headless'],
            before => Liferay-tomcat[$liferay_service_name],
      }

      package { 'openjdk-7-jre-headless':
            ensure => 'purged',
      }
    }
  }

  $webapps = "${liferay_home}/tomcat-${tomcat_version}/webapps"
  $tomcat_root = "${liferay_home}/tomcat-${tomcat_version}"
  $tomcat_work = "${tomcat_root}/work"
  $tomcat_temp = "${tomcat_root}/temp"

  if $ehcache != undef {
	exec { "extract ehcache":
		command => "unzip -o ${webapps}/ROOT/WEB-INF/lib/portal-impl.jar -d ${webapps}/ROOT/WEB-INF/classes ehcache/* ; mv ${webapps}/ROOT/WEB-INF/classes/ehcache ${webapps}/ROOT/WEB-INF/classes/myehcache",
		creates => "${webapps}/ROOT/WEB-INF/classes/myehcache/ehcache.xsd",
		require => Archive["liferay-portal-tomcat"],
		
	}
	exec { "chown -R ${liferay_user}:${liferay_user} ${webapps}/ROOT/WEB-INF/classes/myehcache" :
	    unless => "sudo -u ${liferay_user} test -O ${webapps}/ROOT/WEB-INF/classes/myehcache",
	    require => [ Archive["liferay-portal-tomcat"], User["${liferay_user}"], Exec["extract ehcache"] ],
	}
	file { "${webapps}/ROOT/WEB-INF/classes/myehcache/jgroups-tcp.xml":
	    ensure  => present,
	    mode => 644,
	    owner  => $liferay_user,
	    group  => $liferay_user,
	    content => template("liferay-tomcat/jgroups-tcp.xml.erb"),
	    require => Exec["extract ehcache"],
	}
	file { "${webapps}/ROOT/WEB-INF/classes/myehcache/tcp.xml":
	    ensure  => present,
	    mode => 644,
	    owner  => $liferay_user,
	    group  => $liferay_user,
	    content => template("liferay-tomcat/tcp.xml.erb"),
	    require => Exec["extract ehcache"],
	}
  }


  # clean-up before deployment
  file { "${webapps}/ROOT":
    ensure => directory,
  }

  file { "${webapps}/marketplace-portlet":
    ensure => directory,
  }

  file { "${webapps}/resources-importer-web":
    ensure => directory,
  }

  file { "${webapps}/welcome-theme":
    ensure => directory,
  }

  file { $webapps :
    ensure => directory,
    recurse => true,
    purge => true,
    force => true,
    backup => false,
    require => File[$liferay_home],
  }

  file { $tomcat_work :
    ensure => directory,
    recurse => true,
    purge => true,
    force => true,
    backup => false,
    require => File[$liferay_home],
    notify => Service[$liferay_service_name],
  }

  file { $tomcat_temp :
    ensure => directory,
    recurse => true,
    purge => true,
    force => true,
    backup => false,
    require => File[$liferay_home],
    notify => Service[$liferay_service_name],
  }
}
