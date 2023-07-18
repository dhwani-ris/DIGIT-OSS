package package org.egov.wf.service.impl;

import org.egov.wf.web.models.Catalog;
import org.egov.wf.web.models.Purchase;
import org.egov.wf.util.HandledException;
import org.egov.wf.repository.CatalogRepo;
import org.egov.wf.repository.PurchaseRepo;
import org.egov.wf.request.CatalogRequest;
import org.egov.wf.request.PurchaseRequest;
import org.egov.wf.util.Response;
import org.egov.wf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    CatalogRepo catalogRepo;

    @Autowired
    PurchaseRepo purchaseRepo;

    @Override
    public Response<?> saveCatalog(CatalogRequest request, HttpServletRequest req) {
        Response<Catalog> response = new Response<>();
        List<Catalog> resultList=new ArrayList<>();
        Catalog catalog = new Catalog();
        catalog.setName(request.getName());
        catalog.setDescription(request.getDescription());
        catalog.setImage(request.getImage());
        catalog.setPrice(request.getPrice());
        catalog.setStatus(1);
        catalog.setUuid(request.getUuid());
        catalog.setTenantid(request.getTenantid());
        catalog.setLastModifiedBy(1);
        catalog.setCreatedBy(1);
       Catalog result= catalogRepo.save(catalog);
//        resultList.add(result);
       response.setWrapperList(null);
       response.setTotalcount(null);
       response.setResponseCode(HttpStatus.OK.toString());
       response.setResponseDesc(HttpStatus.OK.toString());
        return response;
    }

    @Override
    public Response<?> listCatalog(HttpServletRequest req, Map<String, String> queryParams) {
        Response<Catalog> response = new Response<>();
        List<Catalog> resultList=new ArrayList<>();
        resultList=catalogRepo.findAll();
        response.setWrapperList(resultList);
        response.setTotalcount((long)resultList.size());
        response.setResponseCode(HttpStatus.OK.toString());
        response.setResponseDesc(HttpStatus.OK.toString());
        return response;
    }

    @Override
    public Response<?> updateCatalog(CatalogRequest request, HttpServletRequest req, Long id) {
        Response<Catalog> response = new Response<>();
        List<Catalog> resultList=new ArrayList<>();
        Optional<Catalog> optionalCatalog= catalogRepo.findById(id);
        if (optionalCatalog.isPresent()){
            Catalog catalog = optionalCatalog.get();
            catalog.setName(request.getName());
            catalog.setDescription(request.getDescription());
            catalog.setImage(request.getImage());
            catalog.setPrice(request.getPrice());
            catalog.setStatus(1);
            catalog.setUuid(request.getUuid());
            catalog.setTenantid(request.getTenantid());
            catalog.setLastModifiedBy(1);
            catalog.setCreatedBy(1);
            Catalog result= catalogRepo.save(catalog);
//            resultList.add(result);
            response.setWrapperList(null);
            response.setTotalcount(null);
            response.setResponseCode(HttpStatus.OK.toString());
            response.setResponseDesc(HttpStatus.OK.toString());
            return response;
        }else{
            throw new HandledException(HttpStatus.UNPROCESSABLE_ENTITY, "id not found!! ");
        }

    }

    @Override
    public Response<?> savePurchase(PurchaseRequest request, HttpServletRequest req) {
        Response<Purchase> response = new Response<>();
        List<Purchase> resultList=new ArrayList<>();
        Purchase purchase = new Purchase();
        purchase.setUuid(request.getUuid());
        purchase.setItemId(request.getItemId());
        purchase.setQuantity(request.getQuantity());
        purchase.setStatus(1);
        purchase.setTenantid(request.getTenantid());
        purchase.setCreatedBy(1);
        purchase.setLastModifiedBy(1);

        Purchase result= purchaseRepo.save(purchase);
//        resultList.add(result);
        response.setWrapperList(null);
        response.setTotalcount(null);
        response.setResponseCode(HttpStatus.OK.toString());
        response.setResponseDesc(HttpStatus.OK.toString());
        return response;

    }

    @Override
    public Response<?> listPurchase(HttpServletRequest req, Map<String, String> queryParams) {
        Response<Purchase> response = new Response<>();
        List<Purchase> resultList=new ArrayList<>();
        resultList=purchaseRepo.findAll();
        response.setWrapperList(resultList);
        response.setTotalcount((long)resultList.size());
        response.setResponseCode(HttpStatus.OK.toString());
        response.setResponseDesc(HttpStatus.OK.toString());
        return response;
    }

    @Override
    public Response<?> updatePurchase(PurchaseRequest request, HttpServletRequest req, Long id) {
        Response<Purchase> response = new Response<>();
        List<Purchase> resultList=new ArrayList<>();
       Optional<Purchase> optionalPurchase= purchaseRepo.findById(id);
        if (optionalPurchase.isPresent()) {
            Purchase purchase = new Purchase();
            purchase.setUuid(request.getUuid());
            purchase.setItemId(request.getItemId());
            purchase.setQuantity(request.getQuantity());
            purchase.setStatus(1);
            purchase.setTenantid(request.getTenantid());
            purchase.setCreatedBy(1);
            purchase.setLastModifiedBy(1);

            Purchase result = purchaseRepo.save(purchase);
//            resultList.add(result);
            response.setWrapperList(null);
            response.setTotalcount(null);
            response.setResponseCode(HttpStatus.OK.toString());
            response.setResponseDesc(HttpStatus.OK.toString());
            return response;
        }
        else{
            throw new HandledException(HttpStatus.UNPROCESSABLE_ENTITY, "id not found!! ");
        }
    }
}
