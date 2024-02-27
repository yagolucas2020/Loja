package br.com.Store40.model;

import java.io.Serializable;

import br.com.Store40.enums.CategoryEnum;
import br.com.Store40.enums.CorEnum;
import br.com.Store40.enums.DepartamentEnum;
import br.com.Store40.enums.SizeEnum;
import br.com.Store40.enums.TypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Produtos")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="Id")
	private Long id;
	
	@Column(name ="sku")
	private String sku;
	
	@Column(name ="descricao")
	private String desc;
	
	
	@Column(name ="quantidade")
	private Integer quantity;
	
	@Column(name ="preco")
	private Double price;
	
	@Column(name ="tipo")
	private TypeEnum type;
	
	@Column(name ="cor")
	private CorEnum cor;
	
	@Column(name ="departamento")
	private DepartamentEnum depart;
	
	@Column(name ="tamanho")
	private SizeEnum size;
	
	@Column(name ="categoria")
	private CategoryEnum category;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String sku, String desc, Integer quantity, Double price) {
		this. sku = sku;
		this.desc = desc;
		this.quantity = quantity;
		this.price = price;
		
		parseSku();
		
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
		
		parseSku();
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public CorEnum getCor() {
		return cor;
	}

	public void setCor(CorEnum cor) {
		this.cor = cor;
	}

	public DepartamentEnum getDepart() {
		return depart;
	}

	public void setDepart(DepartamentEnum depart) {
		this.depart = depart;
	}

	public SizeEnum getSize() {
		return size;
	}

	public void setSize(SizeEnum size) {
		this.size = size;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}
	
	
	private void parseSku() {
		this.depart = DepartamentEnum.getDept(sku.substring(0, 2));
		this.cor = CorEnum.getCorEnum(sku.substring(2, 5));
		this.category = CategoryEnum.getCategory(sku.substring(5,6));
		this.size = SizeEnum.getSizeEnum(sku.substring(6,7));
		this.type = TypeEnum.getTypeEnum(sku.substring(7));
		
		//     FM   AZL   R      P     I
		//     2    2,5   5,6   6,7    7
		
		//FMAZLRPI
	}

	@Override
	public String toString() {
		return "Product \n sku: " + sku + ", \n Descricao: " + desc + ",\n  quantity: " + quantity + ",\n price: " + price + ", \n type: "
				+ type + ",\n  cor: " + cor + ", \n depart: " + depart + ",\n  size: " + size + ",\n category: " + category + "\n...................";
	}
	
	
	
}





