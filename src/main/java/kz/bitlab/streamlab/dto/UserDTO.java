package kz.bitlab.streamlab.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private String email;
    private String firstName;
    private String LastName;
    private List<PermissionDTO> permissions;
}
