exec { "apt-update":
command => "/usr/bin/apt-get update"
}

case $::hostname {

  'appserver':{
    exec { "get-curl":
    require=> Exec['apt-update'],
    command => "/usr/bin/sudo apt-get install -y curl"
    }

    exec { "install curl":
    require=> Exec['get-curl'],
    command=> "/usr/bin/curl -sL https://deb.nodesource.com/setup_12.x | sudo -E bash -" 
    }

    exec { "nodejs":
    command => "/usr/bin/sudo apt-get install -y nodejs"
    }
  }

  'dbserver':{
    package { 'mysql-server':
    ensure => latest,
    }
  }

  default: {
  }
}