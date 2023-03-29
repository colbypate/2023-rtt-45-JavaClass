package springexamples.database.entity;

import java.util.Date;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "payments")
@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "customer_id", insertable=false, updatable=false)
	private Integer customerId;

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@Column(name = "check_number")
	private String checkNumber;

	@Column(name = "payment_date")
	@Temporal(TemporalType.DATE)
	private Date paymentDate;


	@Column(name = "amount", columnDefinition = "decimal", precision = 10, scale = 2)
	private Double amount;

}
