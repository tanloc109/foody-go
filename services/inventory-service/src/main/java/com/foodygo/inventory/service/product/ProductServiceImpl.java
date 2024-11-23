package com.foodygo.inventory.service.product;

import com.foodygo.inventory.dto.request.product.ProductCreateRequest;
import com.foodygo.inventory.dto.request.product.ProductUpdateRequest;
import com.foodygo.inventory.dto.response.product.ProductCreateResponse;
import com.foodygo.inventory.dto.response.product.ProductResponse;
import com.foodygo.inventory.dto.response.product.ProductUpdateResponse;
import com.foodygo.inventory.entity.Product;
import com.foodygo.inventory.mapper.ProductMapper;
import com.foodygo.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductCreateResponse createProduct(ProductCreateRequest request) {
        Product product = ProductMapper.INSTANCE.toCreateEntity(request);
        return ProductMapper.INSTANCE.toCreateResponse(this.productRepository.save(product));
    }

    @Override
    public ProductUpdateResponse updateProduct(ProductUpdateRequest request) {
        Product product = ProductMapper.INSTANCE.toUpdateEntity(request);
        return ProductMapper.INSTANCE.toUpdateResponse(this.productRepository.save(product));    }

    @Override
    public ProductResponse findProductById(Integer productId) {
        return ProductMapper.INSTANCE.toResponse(this.productRepository.findById(productId).orElseThrow(
                () -> new RuntimeException("Product not found!")
        ));
    }

    @Override
    public List<ProductResponse> findAllProducts() {
        return this.productRepository.findAll().stream().map(ProductMapper.INSTANCE::toResponse).collect(Collectors.toList());
    }
}
