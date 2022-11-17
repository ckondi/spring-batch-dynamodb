package my.batch.workload.springbatchdynamodb.mapper;

import my.batch.workload.springbatchdynamodb.model.User;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

@Component
public class UserFieldMapper implements FieldSetMapper<User> {
    @Override
    public User mapFieldSet(FieldSet fieldSet) throws BindException {
        return User.builder()
                .id(fieldSet.readLong("Identifier"))
                .email(fieldSet.readString("LoginEmail"))
                .firstName(fieldSet.readString("FirstName"))
                .lastName(fieldSet.readString("LastName"))
                .build();

    }
}
