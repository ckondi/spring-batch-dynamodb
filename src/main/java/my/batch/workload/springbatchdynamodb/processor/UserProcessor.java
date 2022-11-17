package my.batch.workload.springbatchdynamodb.processor;

import lombok.extern.slf4j.Slf4j;
import my.batch.workload.springbatchdynamodb.entity.UserEntity;
import my.batch.workload.springbatchdynamodb.model.User;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class UserProcessor implements ItemProcessor<User, UserEntity> {

    /*The processor allows us to write business logic to convert/transform raw data into meaningful data as per business rules outlined */
    @Override
    public UserEntity process(User item) throws Exception {
        log.info("Transforming Users with id {}", item.getId());

        final UserEntity transformedUser = UserEntity.builder()
                .id(item.getId())
                .email(item.getEmail())
                .firstName(item.getFirstName().toUpperCase())
                .lastName(item.getLastName().toUpperCase())
                .fullName(item.getFirstName() + " " + item.getLastName())
                .build();

        return transformedUser;
    }
}
