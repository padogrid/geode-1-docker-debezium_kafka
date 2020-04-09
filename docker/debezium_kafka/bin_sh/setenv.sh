#
# Enter app specifics in this file.
#

# Cluster level variables:
# ------------------------
# BASE_DIR - geode-addon base dir
# ETC_DIR - Cluster etc dir
# LOG_DIR - Cluster log dir

# App level variables:
# --------------------
# APPS_DIR - <geode-addon>/apps dir
# APP_DIR - App base dir
# APP_ETC_DIR - App etc dir
# APP_LOG_DIR - App log dir

# Set JAVA_OPT to include your app specifics.
JAVA_OPTS="-Xms256m -Xmx256m"

# GEODE_CLIENT_CONFIG_FILE defaults to etc/client-cache.xml
GEODE_PROPERTY_FILE="$APP_DIR/geode-addon/etc/client-gemfire.properties"
GEODE_CLIENT_CONFIG_FILE="$APP_DIR/geode-addon/etc/client-cache.xml"
JAVA_OPTS="$JAVA_OPTS -DgemfirePropertyFile=$GEODE_PROPERTY_FILE \
-Dgemfire.cache-xml-file=$GEODE_CLIENT_CONFIG_FILE"

CLASSPATH="$CLASSPATH:$APP_DIR/padogrid/plugins/*"
if [[ ${OS_NAME} == CYGWIN* ]]; then
   CLASSPATH="$(cygpath -wp "$CLASSPATH")"
fi
