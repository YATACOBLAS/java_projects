package com.example.misoap;

import com.blas.gen.GetProductoRequest;
import com.blas.gen.GetProductoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductoEndpoint {

    private static final String NAMESPACE_URI = "http://www.blas.com/gen";

    private ProductoRepository countryRepository;

    @Autowired
    public ProductoEndpoint(ProductoRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetProductoResponse getCountry(@RequestPayload GetProductoRequest request) {
        GetProductoResponse response = new GetProductoResponse();
        response.setProducto(countryRepository.findCountry(request.getName()));

        return response;
    }
}