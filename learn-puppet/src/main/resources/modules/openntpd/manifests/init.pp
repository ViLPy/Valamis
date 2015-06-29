class openntpd {
    package { "openntpd":
        ensure => "installed",
    }
    file { "/etc/default/openntpd":
        mode => "0644",
        owner => "root",
        group => "root",
        source => "puppet://$puppetserver/modules/openntpd/openntpd",
        require => Package["openntpd"],
        before => Service["openntpd"],
        notify => Service["openntpd"],
    }
    service { "openntpd":
        ensure => "running",
        enable => "true",
    }
}
