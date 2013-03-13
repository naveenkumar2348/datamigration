grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()
        mavenRepo "http://dev-ff-jhbci.radixfs.com:8091/artifactory/repo"
        //mavenRepo "http://zahqinfvmdev003:8081/artifactory/repo"
        // uncomment these to enable remote dependency resolution from public Maven repositories
        //mavenCentral()
        //mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.
        compile 'net.objectlab.kit.datecalc:datecalc-common:1.1.0'
        compile 'com.qualica:flexifin-common:1.0-SNAPSHOT'
        compile 'com.qualica:flexifin-common-adapter:1.0-SNAPSHOT'
        compile('com.qualica:flexifin-data:1.0-SNAPSHOT'){
            excludes 'hibernate-annotations', 'hibernate-validator', 'hibernate-core', 'activiti-engine'
        }
        compile 'com.qualica:flexifin-masterdata-shared:1.0-SNAPSHOT'
        compile ('com.qualica:flexifin-masterdata-service:1.0-SNAPSHOT')
        compile('com.qualica:flexifin-decision-bo:1.0-SNAPSHOT'){
            excludes 'joda-time'
        }
        compile('com.qualica:flexifin-products-shared:1.0-SNAPSHOT') {
            excludes 'hibernate-annotations', 'hibernate-validator', 'hibernate-core', 'joda-time'
        }
        compile('com.qualica:flexifin-workflow-shared:1.0-SNAPSHOT') {
            excludes 'hibernate-annotations', 'hibernate-validator', 'hibernate-core', 'joda-time'
        }
        compile('com.qualica:flexifin-accounting-shared:1.0-SNAPSHOT') {
            excludes 'hibernate-annotations', 'hibernate-validator', 'hibernate-core', 'joda-time'
        }

        compile 'com.jamesmurty.utils:java-xmlbuilder:0.4'
        compile 'com.korwe:thecore-api:1.1.2'
        compile 'com.thoughtworks.xstream:xstream:1.4.1'
        compile 'commons-codec:commons-codec:1.4'
        compile 'commons-httpclient:commons-httpclient:3.1'
        compile 'joda-time:joda-time-hibernate:1.3'
        runtime 'mysql:mysql-connector-java:5.1.20'
        compile('org.apache.poi:poi-ooxml:3.8'){
            excludes 'xml-apis', 'stax-api', 'commons-codec'
        }
        compile 'org.apache.httpcomponents:httpasyncclient:4.0-beta1'
        compile 'org.apache.httpcomponents:httpcore-nio:4.2'
        compile 'org.apache.qpid:qpid-client:0.12'
        compile 'org.codehaus.jackson:jackson-core-asl:1.6.1'
        compile 'org.codehaus.jackson:jackson-mapper-asl:1.6.1'
        compile 'org.jadira.usertype:usertype.jodatime:1.9'
        compile('org.codehaus.jettison:jettison:1.3.1'){
            excludes 'stax-api'
        }
        compile 'com.ibm.icu:icu4j:50.1'
        compile 'org.codehaus.gpars:gpars:1.0.0'

        // runtime 'mysql:mysql-connector-java:5.1.16'
    }

    plugins {
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"
        compile ":excel-import:1.0.0"
        compile ":mail:1.0.1"
        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        compile ':webxml:1.4.1'
        compile ':spring-security-core:1.2.7'
        compile ':hibernate:2.0.3'
        compile ':tomcat:2.0.3'
        compile ':executor:0.3'
        compile(':jasper:1.6.1'){
            excludes 'org.apache.poi:poi'
        }
        compile(':joda-time:1.4'){
            excludes 'joda-time:joda-time:2.0'
        }
        compile ":dto:0.2.4"
//        build ":tomcat:$grailsVersion"
    }
}
