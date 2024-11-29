package com.ghada.commercial.product;
import com.ghada.commercial.Exception.BuisnessException;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Service
@RequiredArgsConstructor

public class productClient{
    private String productUrl;
    @Value("http://localhost:8022/api/product")
    private final RestTemplate restTemplate;

    public List<purchaseResponse> purchaseProduct(List<PurchaseRequest> requestBody){



        HttpHeaders headers=new HttpHeaders();
        headers.set(CONTENT_TYPE,APPLICATION_JSON_VALUE);
        HttpEntity<List<PurchaseRequest>> requestEntity=new HttpEntity<>(requestBody,headers);
        ParameterizedTypeReference<List<purchaseResponse>> responseType=
                new ParameterizedTypeReference<List<purchaseResponse>>() {

                };
        ResponseEntity<List<purchaseResponse>> responseEntity=restTemplate.exchange(
                productUrl+"/purchase",
                POST,
                requestEntity,
                responseType
        );
      if(responseEntity.getStatusCode().isError()){
          throw new BuisnessException("An error occured during product purchase");
      }
        return responseEntity.getBody();

    }





    }
