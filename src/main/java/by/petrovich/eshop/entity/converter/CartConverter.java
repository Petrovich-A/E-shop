package by.petrovich.eshop.entity.converter;

import by.petrovich.eshop.dto.CartDto;
import by.petrovich.eshop.entity.Cart;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {
    private final ModelMapper modelMapper;

    @Autowired
    public CartConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CartDto convertToDto(Cart cart) {
        return modelMapper.map(cart, CartDto.class);
    }

    public Cart convertToEntity(CartDto cartDto) {
        return modelMapper.map(cartDto, Cart.class);
    }

}
