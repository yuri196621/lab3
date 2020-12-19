package bdtc.lab3.config;

import bdtc.lab3.controller.TestServiceController;
import bdtc.lab3.dao.TestServiceRepository;
import bdtc.lab3.model.PersonEntity;
import bdtc.lab3.service.TestBusinessLogicService;
import org.apache.ignite.Ignite;
import org.apache.ignite.configuration.CacheConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.UUID;

@Configuration
@Import(IgniteConf.class)
public class ServiceConf {
    @Bean
    TestServiceRepository testServiceRepository(Ignite ignite, CacheConfiguration<UUID, PersonEntity> personCacheConf){
        return new TestServiceRepository(ignite, personCacheConf);
    }

    @Bean
    TestBusinessLogicService testBusinessLogicService(TestServiceRepository testServiceRepository){
        return new TestBusinessLogicService(testServiceRepository);
    }

    @Bean
    TestServiceController testServiceController(TestBusinessLogicService testBusinessLogicService){
        return new TestServiceController(testBusinessLogicService);
    }
}
