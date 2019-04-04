package net.code.java.hibernate;
// Generated 13 nov. 2018 10:53:07 by Hibernate Tools 5.2.11.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * COrderLineId generated by hbm2java
 */
@Embeddable
public class COrderLineId implements java.io.Serializable {

	private int olOId;
	private int olDId;
	private int olWId;
	private int olNumber;

	public COrderLineId() {
	}

	public COrderLineId(int olOId, int olDId, int olWId, int olNumber) {
		this.olOId = olOId;
		this.olDId = olDId;
		this.olWId = olWId;
		this.olNumber = olNumber;
	}

	@Column(name = "ol_o_id", nullable = false)
	public int getOlOId() {
		return this.olOId;
	}

	public void setOlOId(int olOId) {
		this.olOId = olOId;
	}

	@Column(name = "ol_d_id", nullable = false)
	public int getOlDId() {
		return this.olDId;
	}

	public void setOlDId(int olDId) {
		this.olDId = olDId;
	}

	@Column(name = "ol_w_id", nullable = false)
	public int getOlWId() {
		return this.olWId;
	}

	public void setOlWId(int olWId) {
		this.olWId = olWId;
	}

	@Column(name = "ol_number", nullable = false)
	public int getOlNumber() {
		return this.olNumber;
	}

	public void setOlNumber(int olNumber) {
		this.olNumber = olNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof COrderLineId))
			return false;
		COrderLineId castOther = (COrderLineId) other;

		return (this.getOlOId() == castOther.getOlOId()) && (this.getOlDId() == castOther.getOlDId())
				&& (this.getOlWId() == castOther.getOlWId()) && (this.getOlNumber() == castOther.getOlNumber());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOlOId();
		result = 37 * result + this.getOlDId();
		result = 37 * result + this.getOlWId();
		result = 37 * result + this.getOlNumber();
		return result;
	}

}
