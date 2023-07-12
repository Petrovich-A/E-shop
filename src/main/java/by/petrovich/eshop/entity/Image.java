package by.petrovich.eshop.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "images")
public class Image {
    @Id
    @Column(name = "image_id")
    private Integer productId;
    @NotBlank(message = "Link is required")
    @Column(unique = true)
    private String link;

    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "image_id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Image image = (Image) o;
        return productId != null && Objects.equals(productId, image.productId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
