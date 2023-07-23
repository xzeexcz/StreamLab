package kz.bitlab.streamlab;

import kz.bitlab.streamlab.dto.PermissionDTO;
import kz.bitlab.streamlab.dto.UserDTO;
import kz.bitlab.streamlab.entities.impls.Permission;
import kz.bitlab.streamlab.entities.impls.User;
import kz.bitlab.streamlab.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserMappingTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void UserToUserDto() {
        User user = new User();
        Permission permission = new Permission();
        permission.setRole("ROLE_TESTER");
        List<Permission> permissions = new ArrayList<>();
        permissions.add(permission);

        user.setEmail("tester@gmail.com");
        user.setFirstName("Tester");
        user.setLastName("Testing");
        user.setPermissions(permissions);

        UserDTO userDTO = userMapper.toUserDto(user);

        Assertions.assertNotNull(userDTO);
        for(int i = 0; i < permissions.size(); i++) {
            Assertions.assertNotNull(userDTO.getPermissions().get(i));
        }
        Assertions.assertEquals(user.getEmail(), userDTO.getEmail());
        Assertions.assertEquals(user.getFirstName(), userDTO.getFirstName());
        Assertions.assertEquals(user.getLastName(), userDTO.getLastName());
    }
    @Test
    public void UserDtoToUserEntity() {
        UserDTO userDTO = new UserDTO();
        PermissionDTO permissionDTO = new PermissionDTO();
        permissionDTO.setRole("USER_TESTER");

        List<PermissionDTO> permissionDTOS = new ArrayList<>();
        permissionDTOS.add(permissionDTO);
        permissionDTOS.add(permissionDTO);
        permissionDTOS.add(permissionDTO);

        userDTO.setPermissions(permissionDTOS);
        userDTO.setFirstName("Tester");
        userDTO.setLastName("Testing");
        userDTO.setEmail("tester@mail.ru");

        User user = userMapper.toUserEntity(userDTO);

        Assertions.assertNotNull(user);
        for(int i = 0; i < permissionDTOS.size(); i++) {
            Assertions.assertNotNull(user.getPermissions().get(i));
        }
        Assertions.assertEquals(userDTO.getEmail(), user.getEmail());
        Assertions.assertEquals(userDTO.getFirstName(), user.getFirstName());
        Assertions.assertEquals(userDTO.getLastName(), user.getLastName());
    }
}
