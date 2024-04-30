package com.simsasookbak.accommodation.domain;

import com.simsasookbak.global.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.SQLDelete;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE board SET is_deleted = true WHERE id = ?")
public class Accommodation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accommodation_id", updatable = false)
    private Long id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "content", length = 1000, nullable = false)
	private String content;

	@Column(name = "region", length = 10, nullable = false)
	private String region;

	@Column(name = "check_in", nullable = false)
	@Temporal(TemporalType.TIME)
	private String checkIn;

	@Column(name = "check_out", nullable = false)
	@Temporal(TemporalType.TIME)
	private String checkOut;

	@Column(name = "is_deleted", nullable = false, columnDefinition = "tinyint(1)")
	@ColumnDefault("0")
	@Comment("삭제여부")
	private Boolean isDeleted;

	/*ai_external_id`	bigint(20)	NOT NULL,
	member_id`	bigint(20)	NOT NULL*/
}