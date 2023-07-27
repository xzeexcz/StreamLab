package kz.bitlab.streamlab.respository;

import kz.bitlab.streamlab.entities.impls.Permission;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PermissionsRepository extends JpaRepository<Permission, Long> {
    Permission findByRole(String role);
}
