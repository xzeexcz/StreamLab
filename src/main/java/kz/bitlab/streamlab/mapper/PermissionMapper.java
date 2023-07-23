package kz.bitlab.streamlab.mapper;

import kz.bitlab.streamlab.dto.PermissionDTO;
import kz.bitlab.streamlab.entities.impls.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PermissionMapper.class})
public interface PermissionMapper {
    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);
    PermissionDTO toPermissionDto(Permission permission);
    Permission toPermissionEntity(PermissionDTO permissionDTO);

    List<PermissionDTO> toPermissionDtoList(List<Permission> permissionsList);
    List<Permission> toPermissionEntityList(List<PermissionDTO> permissionDTOList);
}
