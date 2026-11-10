package fr.simplon.domedespuys.dto;

import java.math.BigDecimal;
import java.util.List;

public class ProductPostDTO {
    public String label;
    public String description;
    public BigDecimal price;
    public String brand;
    public List<ImageDTO> images;
}