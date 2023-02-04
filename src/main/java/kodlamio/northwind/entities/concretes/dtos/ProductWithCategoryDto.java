package kodlamio.northwind.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {
    private int id;
    private String productName;
    private String categoryName;


}
