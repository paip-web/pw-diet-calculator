#!/usr/bin/env bash

APACHE_CONF=/etc/apache2/sites-available/000-default.conf

if [ -f "${APACHE_CONF}" ]; then
rm "${APACHE_CONF}"
fi

cat > "${APACHE_CONF}" <<EOF
<VirtualHost *:80>
    ServerAdmin paipweb@paipweb.com
    DocumentRoot /app/public
    <Directory /app/public>
        AllowOverride All
        Require all granted
    </Directory>
</VirtualHost>
ServerName localhost
ServerSignature Off
ServerTokens Minimal
TraceEnable On
<Directory />
    Options -Indexes
</Directory>
EOF

a2enmod rewrite
/usr/sbin/apache2ctl -D FOREGROUND
