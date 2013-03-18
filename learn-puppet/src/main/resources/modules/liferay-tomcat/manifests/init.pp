define liferay-tomcat (
  $liferay_home,
  $tomcat_version = "7.0.27",
  $setenv = [],
  $ensure = "running",
  $liferay_user = "root",
  $liferay_group = "root",
  $liferay_service_name,
  $java_home = "",
  $ehcache_conf = undef,
) {

  $tomcat_home = "${liferay_home}/tomcat-${tomcat_version}"
  $basedir = $tomcat_home
  $catalinahome = $tomcat_home

  if $java_home == "" {
    case $::operatingsystem {
      RedHat: {
        $javahome = "/usr/lib/jvm/java"
      }
      Debian,Ubuntu,Solaris,Darwin: {
        $javahome = "/usr"
      }
      default: {
        err("java_home not defined for '${::operatingsystem}'.")
      }
    }
  } else {
    $javahome = $java_home
  }

  $present = $ensure ? {
    present   => "present",
    installed => "present",
    running   => "present",
    stopped   => "present",
    absent    => "absent",
  }

  File {
    ensure  => $present,
    owner  => $liferay_user,
    group  => $liferay_group,
    before => Service["${liferay_service_name}"],
  }

  # Default JVM options
  file {"${basedir}/bin/setenv.sh":
    content => template("liferay-tomcat/setenv.sh.erb"),
    mode   => 754,
    notify  => Service["${liferay_service_name}"],
  }

  file {"${basedir}/bin/setenv-local.sh":
    content => template("liferay-tomcat/setenv-local.sh.erb"),
    mode   => 754,
    notify  => Service["${liferay_service_name}"],
  }

  # Executable catalina.sh
  file {"${basedir}/bin/catalina.sh":
    mode => 754,
    source => "puppet:///modules/liferay-tomcat/catalina.sh",
    notify  => Service["${liferay_service_name}"],
  }

  file {"${basedir}/conf/server.xml":
        mode => 644,
        content => template("liferay-tomcat/server.xml.erb"),
        notify  => Service["${liferay_service_name}"],
  }

  # Main configuration file - portal-ext.properties
  if $ehcache_conf == undef {
    file { "${tomcat_home}/webapps/ROOT/WEB-INF/classes/portal-ext.properties" :
      content => template("liferay-tomcat/portal-ext.properties.erb"),
      mode => 740,
      notify  => Service["${liferay_service_name}"],
    }
  } else { 
    file { "${tomcat_home}/webapps/ROOT/WEB-INF/classes/portal-ext.properties" :
      content => template("liferay-tomcat/portal-ext.properties.ehcache.erb","liferay-tomcat/portal-ext.properties.jcr.erb","liferay-tomcat/portal-ext.properties.erb"),
      mode => 740,
      notify  => Service["${liferay_service_name}"],
    }
    file { "${liferay_home}/data/jackrabbit":
	ensure => directory,
	mode => 750,
	before => File["${liferay_home}/data/jackrabbit/repository.xml"],
    }
    file { "${liferay_home}/data/jackrabbit/repository.xml":
      ensure  => present,
      mode => 660,
      content => template("liferay-tomcat/repository.xml.erb"),
      require => [ Archive["liferay-portal-tomcat"], User["${liferay_user}"] ],
      notify  => Service["${liferay_service_name}"],
    }
  }

  # liferay setup config - portal-setup-wizard.properties
  file { "${liferay_home}/portal-setup-wizard.properties" :
    content => template("liferay-tomcat/portal-setup-wizard.properties.erb"),
    mode => 740,
    notify  => Service["${liferay_service_name}"],
  }


  # Init and env scripts
  file {"/etc/init.d/${liferay_service_name}":
    ensure  => $present,
    content => template("liferay-tomcat/tomcat.init.erb"),
    owner   => "root",
    mode    => "755",
    require => File["${basedir}/bin/setenv.sh", "${basedir}/bin/catalina.sh"],
    seluser => $seluser ? {
            ''      => 'system_u',
            default => $seluser,
          },
    selrole => $selrole ? {
            ''      => 'object_r',
            default => $selrole,
          },
    seltype => $seltype ? {
            ''      => 'initrc_exec_t',
            default => $seltype,
          },
  }


  if $::operatingsystem == "Solaris" {
      # Service in Solaris 10
    $solaris_web_services_dir = "/var/svc/manifest/application/web/"
    file { $solaris_web_services_dir :
      ensure => directory,
    }

    file { "${solaris_web_services_dir}/${liferay_service_name}.xml" :
      ensure  => $present,
      content => template("liferay-tomcat/liferay_solaris_service.xml.erb"),
      owner   => "root",
      mode    => "755",
      require => File[$solaris_web_services_dir],
      before => Service["${liferay_service_name}"],
    }
    $liferay_service_manifest = "${solaris_web_services_dir}/${liferay_service_name}.xml"

    # jira: INTRA-151 - log rotation in Solaris
    ## tomcat/logs/catalina.out
    exec { "logadm -z 1 -C 10 -c -s 50m -w ${tomcat_home}/logs/catalina.out" :
    }
    ## tomcat/logs/*.log
    exec { "logadm -C 8 -c -s 100m -w ${tomcat_home}/logs/*.log" :
    }
    ## tomcat/logs/*.txt
    exec { "logadm -C 8 -c -s 100m -w ${tomcat_home}/logs/*.txt" :
    }
    ## liferay/logs/*.log
    exec { "logadm -C 8 -c -s 100m -w ${liferay_home}/logs/*.log" :
    }
  }

  service { "${liferay_service_name}" :
    ensure  => $ensure ? {
      present   => "running",
      running   => "running",
      stopped   => "stopped",
      installed => undef,
      absent    => "stopped",
    },
    enable  => $ensure ? {
      present   => true,
      running   => true,
      stopped   => false,
      installed => false,
      absent    => false,
    },
    require => File["/etc/init.d/${liferay_service_name}"],
    manifest => "${liferay_service_manifest}",
  }

}
