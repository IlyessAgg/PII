package net.code.java.hibernate;
// Generated 13 nov. 2018 11:01:02 by Hibernate Tools 5.2.11.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * DssPart generated by hbm2java
 */
@Entity
@Table(name = "dss_part", catalog = "tpcd")
public class DssPart implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3373375102492677668L;
	private int PPartkey;
	private String PName;
	private String PMfgr;
	private String PBrand;
	private String PType;
	private int PSize;
	private String PContainer;
	private double PRetailprice;
	private String PComment;
	private Set<DssPartsupp> dssPartsupps = new HashSet<DssPartsupp>(0);

	public DssPart() {
	}

	public DssPart(int PPartkey, String PName, String PMfgr, String PBrand, String PType, int PSize, String PContainer,
			double PRetailprice, String PComment) {
		this.PPartkey = PPartkey;
		this.PName = PName;
		this.PMfgr = PMfgr;
		this.PBrand = PBrand;
		this.PType = PType;
		this.PSize = PSize;
		this.PContainer = PContainer;
		this.PRetailprice = PRetailprice;
		this.PComment = PComment;
	}

	public DssPart(int PPartkey, String PName, String PMfgr, String PBrand, String PType, int PSize, String PContainer,
			double PRetailprice, String PComment, Set<DssPartsupp> dssPartsupps) {
		this.PPartkey = PPartkey;
		this.PName = PName;
		this.PMfgr = PMfgr;
		this.PBrand = PBrand;
		this.PType = PType;
		this.PSize = PSize;
		this.PContainer = PContainer;
		this.PRetailprice = PRetailprice;
		this.PComment = PComment;
		this.dssPartsupps = dssPartsupps;
	}

	@Id

	@Column(name = "p_partkey", unique = true, nullable = false)
	public int getPPartkey() {
		return this.PPartkey;
	}

	public void setPPartkey(int PPartkey) {
		this.PPartkey = PPartkey;
	}

	@Column(name = "p_name", nullable = false, length = 55)
	public String getPName() {
		return this.PName;
	}

	public void setPName(String PName) {
		this.PName = PName;
	}

	@Column(name = "p_mfgr", nullable = false, length = 25)
	public String getPMfgr() {
		return this.PMfgr;
	}

	public void setPMfgr(String PMfgr) {
		this.PMfgr = PMfgr;
	}

	@Column(name = "p_brand", nullable = false, length = 10)
	public String getPBrand() {
		return this.PBrand;
	}

	public void setPBrand(String PBrand) {
		this.PBrand = PBrand;
	}

	@Column(name = "p_type", nullable = false, length = 25)
	public String getPType() {
		return this.PType;
	}

	public void setPType(String PType) {
		this.PType = PType;
	}

	@Column(name = "p_size", nullable = false)
	public int getPSize() {
		return this.PSize;
	}

	public void setPSize(int PSize) {
		this.PSize = PSize;
	}

	@Column(name = "p_container", nullable = false, length = 10)
	public String getPContainer() {
		return this.PContainer;
	}

	public void setPContainer(String PContainer) {
		this.PContainer = PContainer;
	}

	@Column(name = "p_retailprice", nullable = false, precision = 22, scale = 0)
	public double getPRetailprice() {
		return this.PRetailprice;
	}

	public void setPRetailprice(double PRetailprice) {
		this.PRetailprice = PRetailprice;
	}

	@Column(name = "p_comment", nullable = false, length = 23)
	public String getPComment() {
		return this.PComment;
	}

	public void setPComment(String PComment) {
		this.PComment = PComment;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dssPart")
	public Set<DssPartsupp> getDssPartsupps() {
		return this.dssPartsupps;
	}

	public void setDssPartsupps(Set<DssPartsupp> dssPartsupps) {
		this.dssPartsupps = dssPartsupps;
	}

}
