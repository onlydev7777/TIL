package com.dtoconvertway.domain.portal.corporation;

import com.dtoconvertway.domain.portal.corporation.dto.flat.CorporationFlatDto;
import com.dtoconvertway.domain.portal.corporationgroup.CorporationGroup;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporationRepository extends JpaRepository<Corporation, Long> {

  @Query("select new com.dtoconvertway.domain.portal.corporation.dto.flat.CorporationFlatDto("
      + "   c.id, c.name, c.corporationNumber, c.address, "
      + "   cg.id, cg.name"
      + ") "
      + "from Corporation c "
      + "join CorporationGroup cg "
      + "where cg = :corporationGroup")
  List<CorporationFlatDto> findFlatDtoAllByCorpGroup(CorporationGroup corporationGroup);
}
