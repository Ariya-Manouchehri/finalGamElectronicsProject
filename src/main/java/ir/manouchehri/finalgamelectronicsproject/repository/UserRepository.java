package ir.manouchehri.finalgamelectronicsproject.repository;

import ir.manouchehri.finalgamelectronicsproject.domain.User;
import ir.manouchehri.finalgamelectronicsproject.dto.ProductDto;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(nativeQuery = true,value = "select * from user_tbl where id = :id")
    User getUser(@Param("id") Long id);

    @Query("select us from User us")
    List<User> getAllUsers();
}
