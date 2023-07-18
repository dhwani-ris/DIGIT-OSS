package org.egov.wf.service;


import org.egov.wf.request.CatalogRequest;
import org.egov.wf.request.PurchaseRequest;
import org.egov.wf.util.Response;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Map;

public interface ProductService {

    public Response<?> saveCatalog(CatalogRequest request, HttpServletRequest req);
    public Response<?> listCatalog(HttpServletRequest req, Map<String, String> queryParams);
    public Response<?> updateCatalog(CatalogRequest request, HttpServletRequest req,Long id);
    public Response<?> savePurchase(PurchaseRequest request, HttpServletRequest req);
    public Response<?> listPurchase(HttpServletRequest req, Map<String, String> queryParams);
    public Response<?> updatePurchase(PurchaseRequest request, HttpServletRequest req,Long id);
}
