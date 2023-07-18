package org.egov.wf.repository;

import org.egov.wf.web.models.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepo extends JpaRepository<Catalog,Long> {
}
