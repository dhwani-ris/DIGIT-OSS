package org.egov.wf.repository;


import org.egov.wf.web.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase,Long> {
}
