package by.petrovich.eshop.entity.converter;

import by.petrovich.eshop.dto.ProductDto;
import by.petrovich.eshop.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    private final ModelMapper modelMapper;

    @Autowired
    public ProductConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDto convertToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    public Product convertToEntity(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }

}
