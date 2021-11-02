package pe.edu.upc.trabajo.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Products", 
		indexes = { @Index(columnList = "category_id", name = "products_index_product_id")})
@IdClass(ProductId.class)
public class Product {
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "producer_id")
	private Producer producer;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", columnDefinition = "NUMERIC(4)")
	private Product product;
	
	@Column(name = "product_name", length = 20)
	private String name;
	
	@Column(name = "product_description", length = 20)
	private String description;
	
	@Column(name = "price", columnDefinition = "DECIMAL(8,2)")
	private Float price;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<Card> carts;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Card> getCarts() {
		return carts;
	}

	public void setCarts(List<Card> carts) {
		this.carts = carts;
	}
	
}