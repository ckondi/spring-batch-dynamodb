package my.batch.workload.springbatchdynamodb.config;

import my.batch.workload.springbatchdynamodb.entity.UserEntity;
import my.batch.workload.springbatchdynamodb.mapper.UserFieldMapper;
import my.batch.workload.springbatchdynamodb.model.User;
import my.batch.workload.springbatchdynamodb.processor.UserProcessor;
import my.batch.workload.springbatchdynamodb.reader.CsvReader;
import my.batch.workload.springbatchdynamodb.writer.UserWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CsvReader csvReader;
    @Autowired
    private UserWriter userWriter;

    @Autowired
    private UserProcessor userProcessor;

    @Autowired
    private UserFieldMapper userFieldMapper;

    @Bean
    public Job createJob(){
        return jobBuilderFactory.get("DynamoDBJob")
                .incrementer(new RunIdIncrementer())
                .flow(createStep())
                .end()
                .build();
    }

    @Bean
    public Step createStep() {
        return stepBuilderFactory.get("DynamoDBStep")
                .<User, UserEntity>chunk(10)
                .reader(csvReader)
                .processor(userProcessor)
                .writer(userWriter)
                .build();
    }


}
