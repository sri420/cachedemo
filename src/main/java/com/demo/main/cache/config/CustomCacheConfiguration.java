package com.demo.main.cache.config;

import java.util.concurrent.TimeUnit;

import javax.cache.expiry.AccessedExpiryPolicy;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.expiry.ModifiedExpiryPolicy;

import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.eviction.lru.LruEvictionPolicy;
import org.apache.ignite.cache.spring.SpringCacheManager;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("CUSTOM_CACHE_JAVA_CONFIG")
@Configuration
@EnableConfigurationProperties({CacheConfig.class})
@EnableCaching
public class CustomCacheConfiguration {

	
	@Autowired
    CacheConfig cacheConfig;
	
	
	@Bean
	CacheConfiguration<String,Object> booksCacheConfiguration(){
		CacheConfiguration<String, Object> cacheConfiguration = new CacheConfiguration<>("books");
		cacheConfiguration.setCacheMode(CacheMode.REPLICATED);
		
		///Default OffHeapMemory is disabled , value is "-1"
		//Specify a value in bytes to allocate for offheapmemory, value of "0" will set unlimited offheapmemory 
		cacheConfiguration.setOffHeapMaxMemory(CacheConfiguration.DFLT_OFFHEAP_MEMORY);
		
		cacheConfiguration.setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(new Duration(TimeUnit.MINUTES,2) ));
		cacheConfiguration.setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.FIVE_MINUTES));
		cacheConfiguration.setExpiryPolicyFactory(ModifiedExpiryPolicy.factoryOf(Duration.ONE_DAY));
		
		cacheConfiguration.setEvictionPolicy(new LruEvictionPolicy<String, Object>(1000000));
		
		return cacheConfiguration;
	}

	@Bean
	SpringCacheManager cacheManager() {
		SpringCacheManager cacheManager = new SpringCacheManager();
		cacheManager.setConfiguration(igniteConfiguration());
		return cacheManager;
	}

	public CacheConfig getCacheConfig() {
		return cacheConfig;
	}

	@Bean
	IgniteConfiguration igniteConfiguration(){
		IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
		igniteConfiguration.setClientMode(cacheConfig.isClientMode());	
		igniteConfiguration.setCacheConfiguration(booksCacheConfiguration(),quoteCacheConfiguration());
		return igniteConfiguration;
	}
	
	@Bean
	CacheConfiguration<String,Object> quoteCacheConfiguration(){
		CacheConfiguration<String, Object> cacheConfiguration = new CacheConfiguration<>("quotes");
		cacheConfiguration.setCacheMode(CacheMode.PARTITIONED);
		return cacheConfiguration;
	}
	
	public void setCacheConfig(CacheConfig cacheConfig) {
				this.cacheConfig = cacheConfig;
	}

	
	/*private CacheConfiguration getCacheConfiguration(CacheConfig cacheConfig) {
		
		List<CacheBean> listCacheBeans=cacheConfig.getCaches();
		Iterator iterator=listCacheBeans.iterator();
		while(iterator.hasNext()){
			CacheBean cacheBean=(CacheBean)iterator.next();
			CacheConfiguration<String, Object> cacheConfiguration=new CacheConfiguration<>(cacheBean.getName());
			if(null!=cacheBean.getCacheMode()){
				if(cacheBean.getCacheMode().indexOf("Parti")>0){
					cacheConfiguration.setCacheMode(CacheMode.PARTITIONED);
				}else{
					cacheConfiguration.setCacheMode(CacheMode.REPLICATED);
				}
			}
			
			if(null!=cacheBean.getExpiryPolicy()){
				if(cacheBean.getEvictionPolicy().getType().indexOf("LRU")>0){
					if(cacheBean.getEvictionPolicy().getMaxSize()!=null)
						cacheConfiguration.setEvictionPolicy(new LruEvictionPolicy<String, Object>(Integer.parseInt(cacheBean.getEvictionPolicy().getMaxSize())))
					else{					
					}
				}
			}
			
		}
		return null;
	}*/
}
