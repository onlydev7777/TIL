package com.dtoconvertway.domain.portal.corporationgroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporationGroupRepository extends JpaRepository<CorporationGroup, Long> {

}
