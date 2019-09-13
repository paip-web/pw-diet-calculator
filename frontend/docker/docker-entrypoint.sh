#!/usr/bin/env sh

APACHE_CONF=/etc/apache2/conf.d/http.conf

if [ -f "${APACHE_CONF}" ]; then
rm "${APACHE_CONF}"
fi

cat > "${APACHE_CONF}" <<EOF
<VirtualHost *:80>
    ServerAdmin paipweb@paipweb.com
    DocumentRoot /app/build
    <Directory /app/build>
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

# a2enmod rewrite
/usr/sbin/httpd -D FOREGROUND
