Run the Project with caching
============================

Using Maven,

--To Run with IGNITE_CACHE_JAVA_CONFIG Profile,
	mvn spring-boot:run -Dspring.profiles.active=IGNITE_CACHE_JAVA_CONFIG -DclientMode=false
	mvn spring-boot:run -Dspring.profiles.active=IGNITE_CACHE_JAVA_CONFIG 
	mvn spring-boot:run -Dspring.profiles.active=IGNITE_CACHE_JAVA_CONFIG -DclientMode=true

--To Run with IGNITE_To Run in IGNITE_CACHE_XML_CONFIG Profile,
	mvn spring-boot:run   -Dspring.profiles.active=IGNITE_CACHE_XML_CONFIG -DclientMode=false
	mvn spring-boot:run   -Dspring.profiles.active=IGNITE_CACHE_XML_CONFIG
	mvn spring-boot:run   -Dspring.profiles.active=IGNITE_CACHE_XML_CONFIG -DclientMode=true

Using the java jar,

--To Run with IGNITE_JAVA_CONFIG Profile,
	java -jar cachedemo-0.0.1-SNAPSHOT.jar --spring.profiles.active=IGNITE_CACHE_JAVA_CONFIG --clientMode=false
	java -jar cachedemo-0.0.1-SNAPSHOT.jar --spring.profiles.active=IGNITE_CACHE_JAVA_CONFIG
	java -jar cachedemo-0.0.1-SNAPSHOT.jar --spring.profiles.active=IGNITE_CACHE_JAVA_CONFIG --clientMode=true

--To Run with IGNITE_To Run in IGNITE_CACHE_XML_CONFIG Profile,
	java -jar cachedemo-0.0.1-SNAPSHOT.jar  --spring.profiles.active=IGNITE_CACHE_XML_CONFIG --clientMode=false
	java -jar cachedemo-0.0.1-SNAPSHOT.jar  --spring.profiles.active=IGNITE_CACHE_XML_CONFIG 
	java -jar cachedemo-0.0.1-SNAPSHOT.jar  --spring.profiles.active=IGNITE_CACHE_XML_CONFIG --clientMode=true

Run the Project without caching
===============================
Using  Maven
	mvn spring-boot:run

Using Java and built jar,
	java -jar cachedemo-0.0.1-SNAPSHOT.jar
	
	