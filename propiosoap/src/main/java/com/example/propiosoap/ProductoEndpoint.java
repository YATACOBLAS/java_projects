package com.example.propiosoap;

import com.blas.gen.GetProductoRequest;
import com.blas.gen.GetProductoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductoEndpoint {

    private static final String NAMESPACE_URI="http://www.blas.com/gen";

    private ProductoRepository repository;

    @Autowired
    public ProductoEndpoint(ProductoRepository repository){
        this.repository=repository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getProductoRequest")
    @ResponsePayload
    public GetProductoResponse getBodega(@RequestPayload GetProductoRequest request){
        GetProductoResponse  response= new GetProductoResponse();
              response.setProducto(repository.findProducto(request.getName()));
        return response;
    }


}
