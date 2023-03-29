package springexamples.database.entity;

import java.util.Date;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "orders")
@Getter
@Setter
@ToString
@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "customer_id", insertable = false, updatable = false)
	private Integer customerId;
	
	@Column(name = "order_date")
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@Column(name = "required_date")
	@Temporal(TemporalType.DATE)
	private Date requiredDate;
	
	@Column(name = "shipped_date")
	@Temporal(TemporalType.DATE)
	private Date shippedDate;


	@Column(name = "status")
	private String status;

	@Column(name = "comments", columnDefinition = "text")
	private String comments;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

}
