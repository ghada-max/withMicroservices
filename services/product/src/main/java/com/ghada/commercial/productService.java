package com.ghada.commercial;

import com.ghada.commercial.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class productService {
    private final productRepository repository;
    private final productMapper mapper;
    public Integer createProduct(ProductRequest request) {

        var product=mapper.toProduct(request);
        return repository.save(product).getId();

    }

    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> request) {
      var productIds=request.stream()
              .map(ProductPurchaseRequest::productId)
              .toList();
      var storedProducts=repository.findAllByIdInOrderById(productIds);
      if(productIds.size() !=storedProducts.size()){
         throw new ProductPurchaseException("one or more product does not exist");
      }
      var storedRequest=request.stream()
              .sorted(Comparator.comparing(ProductPurchaseRequest::productId)).toList();
              var purchasedProducts=new ArrayList<ProductPurchaseResponse>();
              for(int i=0;i<storedProducts.size();i++){
                  var product=storedProducts.get(i);
                  var productRequest=storedRequest.get(i);
                  if(product.getAvailableQuantity()<productRequest.Quantity()){
                      throw new ProductPurchaseException("Insuffucent stock");
                  }
                  var newAvailableQuantity=product.getAvailableQuantity()-productRequest.Quantity();
                  product.setAvailableQuantity(newAvailableQuantity);
                  repository.save(product);
                  purchasedProducts.add(mapper.toProductPurchaseResponse(product,productRequest.Quantity()));
              }
              return purchasedProducts;
    }

    public List<ProductResponse> findAll() {
        return repository.findAll().stream().map(mapper::toProductResponse).collect(Collectors.toList());
    }

    public ProductResponse findById(Integer productId) {
        return repository.findById(productId).map(mapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }
}
