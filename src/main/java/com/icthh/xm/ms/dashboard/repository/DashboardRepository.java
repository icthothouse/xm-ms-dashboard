package com.icthh.xm.ms.dashboard.repository;

import com.icthh.xm.commons.permission.access.repository.ResourceRepository;
import com.icthh.xm.ms.dashboard.domain.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


/**
 * Spring Data JPA repository for the Dashboard entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long>, ResourceRepository {

    Dashboard findOneById(Long id);

    void deleteAllByIdIn(Collection<Long> ids);
}
