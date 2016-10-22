Run the Project with caching
============================

Using Maven,

--To Run with IGNITE_CACHE_JAVA_CONFIG Profile,

(i) To Run in (Default) Ignite Server Mode
	mvn spring-boot:run -Dspring.profiles.active=IGNITE_CACHE_JAVA_CONFIG -DclientMode=false
	(OR)
	mvn spring-boot:run -Dspring.profiles.active=IGNITE_CACHE_JAVA_CONFIG
	
(ii)To Run in Ignite Client Mode 
	mvn spring-boot:run -Dspring.profiles.active=IGNITE_CACHE_JAVA_CONFIG -DclientMode=true

--To Run with IGNITE_To Run in IGNITE_CACHE_XML_CONFIG Profile,

(i) To Run in (Default) Ignite Server Mode
	
	mvn spring-boot:run   -Dspring.profiles.active=IGNITE_CACHE_XML_CONFIG -DclientMode=false
	(OR)
	mvn spring-boot:run   -Dspring.profiles.active=IGNITE_CACHE_XML_CONFIG
	
(ii) To Run in Ignite Client Mode	
	mvn spring-boot:run   -Dspring.profiles.active=IGNITE_CACHE_XML_CONFIG -DclientMode=true

Using the java jar,

--To Run with IGNITE_JAVA_CONFIG Profile,

(i) To Run in (Default) Ignite Server Mode
	java -jar cachedemo-0.0.1-SNAPSHOT.jar --spring.profiles.active=IGNITE_CACHE_JAVA_CONFIG --clientMode=false
	(OR)
	java -jar cachedemo-0.0.1-SNAPSHOT.jar --spring.profiles.active=IGNITE_CACHE_JAVA_CONFIG
	
(i) To Run in Ignite Client Mode	
	java -jar cachedemo-0.0.1-SNAPSHOT.jar --spring.profiles.active=IGNITE_CACHE_JAVA_CONFIG --clientMode=true

--To Run with IGNITE_To Run in IGNITE_CACHE_XML_CONFIG Profile,
(i) To Run in (Default) Ignite Server Mode
	java -jar cachedemo-0.0.1-SNAPSHOT.jar  --spring.profiles.active=IGNITE_CACHE_XML_CONFIG --clientMode=false
	(OR)
	java -jar cachedemo-0.0.1-SNAPSHOT.jar  --spring.profiles.active=IGNITE_CACHE_XML_CONFIG
	
(ii) To Run in Ignite Client Mode	 
	java -jar cachedemo-0.0.1-SNAPSHOT.jar  --spring.profiles.active=IGNITE_CACHE_XML_CONFIG --clientMode=true


Optional
========

By Default, ignite-config.xml in src/main/resources (OR) in Application classpath would be used.

If we want to override with a different ignite configuration xml file, we can do so as below,

--To Run with IGNITE_To Run in IGNITE_CACHE_XML_CONFIG Profile,

(ii) To Run in (Default) Ignite Server Mode	
	mvn spring-boot:run   -Dspring.profiles.active=IGNITE_CACHE_XML_CONFIG -DclientMode=false -DCONFIG_FILE=ignite-config-2.xml
	mvn spring-boot:run   -Dspring.profiles.active=IGNITE_CACHE_XML_CONFIG -DCONFIG_FILE=ignite-config-2.xml
	
(ii) To Run in Ignite Client Mode	
	mvn spring-boot:run   -Dspring.profiles.active=IGNITE_CACHE_XML_CONFIG -DclientMode=true -DCONFIG_FILE=ignite-config-2.xml
	
--To Run with IGNITE_To Run in IGNITE_CACHE_XML_CONFIG Profile,

(i) To Run in (Default) Ignite Server Mode
	java -jar cachedemo-0.0.1-SNAPSHOT.jar  --spring.profiles.active=IGNITE_CACHE_XML_CONFIG --clientMode=false --CONFIG_FILE=ignite-config-2.xml
	java -jar cachedemo-0.0.1-SNAPSHOT.jar  --spring.profiles.active=IGNITE_CACHE_XML_CONFIG --CONFIG_FILE=ignite-config-2.xml
	
(i) To Run in Ignite Client Mode	
	java -jar cachedemo-0.0.1-SNAPSHOT.jar  --spring.profiles.active=IGNITE_CACHE_XML_CONFIG --clientMode=true --CONFIG_FILE=ignite-config-2.xml
	
	

Run the Project without caching
===============================
Using  Maven
	mvn spring-boot:run

Using Java and built jar,
	java -jar cachedemo-0.0.1-SNAPSHOT.jar
	
	