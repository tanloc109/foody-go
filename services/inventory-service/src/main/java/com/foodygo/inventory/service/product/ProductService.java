package com.foodygo.inventory.service.product;

import com.foodygo.inventory.dto.request.product.ProductCreateRequest;
import com.foodygo.inventory.dto.request.product.ProductUpdateRequest;
import com.foodygo.inventory.dto.response.product.ProductCreateResponse;
import com.foodygo.inventory.dto.response.product.ProductResponse;
import com.foodygo.inventory.dto.response.product.ProductUpdateResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductCreateResponse createProduct(ProductCreateRequest request);
    ProductUpdateResponse updateProduct(ProductUpdateRequest request);
    ProductResponse findProductById(Integer productId);
    List<ProductResponse> findAllProducts();
}
