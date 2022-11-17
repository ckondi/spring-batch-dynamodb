package my.batch.workload.springbatchdynamodb.reader;

import my.batch.workload.springbatchdynamodb.mapper.UserFieldMapper;
import my.batch.workload.springbatchdynamodb.model.User;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;

public class CsvReader extends FlatFileItemReader<User> {

    @Value("user.file.location")
    private String fileLocation;

    @Autowired
    private UserFieldMapper userFieldMapper;

    @Override
    public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        FlatFileItemReader<User> reader = new FlatFileItemReaderBuilder<User>()
                .name("userCsvReader")
                .linesToSkip(1)
                .resource(new ClassPathResource(fileLocation))
                .delimited()
                .delimiter(",")
                .names(new String[]{"LoginEmail","Identifier","FirstName","LastName"})
                .fieldSetMapper(userFieldMapper)
                .build();
        reader.open(new ExecutionContext());
        User user = reader.read();
        return user;
    }

}
